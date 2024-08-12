package net.tslat.aoa3.content.entity.npc.ambient;

import com.google.common.base.Suppliers;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.Tags;
import net.tslat.aoa3.client.render.AoAAnimations;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.common.registration.entity.AoAEntityDataSerializers;
import net.tslat.aoa3.common.registration.entity.AoAEntityStats;
import net.tslat.aoa3.common.registration.entity.variant.DryadSpriteVariant;
import net.tslat.aoa3.content.entity.base.AoAAmbientNPC;
import net.tslat.aoa3.library.object.EntityDataHolder;
import net.tslat.effectslib.api.particle.ParticleBuilder;
import net.tslat.effectslib.networking.packet.TELParticlePacket;
import net.tslat.smartbrainlib.util.RandomUtil;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.constant.DefaultAnimations;

import java.util.Optional;
import java.util.UUID;

public class DryadSpriteEntity extends AoAAmbientNPC {
	private static final EntityDataHolder<DryadSpriteVariant> VARIANT = EntityDataHolder.register(DryadSpriteEntity.class, AoAEntityDataSerializers.DRYAD_SPRITE_VARIANT.get(), DryadSpriteVariant.WOOD.get(), entity -> entity.variant, (entity, value) -> entity.variant = value);
	private static final EntityDataHolder<Optional<UUID>> OWNER = EntityDataHolder.register(DryadSpriteEntity.class, EntityDataSerializers.OPTIONAL_UUID, Optional.empty(), entity -> entity.owner, (entity, uuid) -> entity.owner = uuid);
	private static final EntityDataHolder<Integer> SUCCESS_TIMER = EntityDataHolder.register(DryadSpriteEntity.class, EntityDataSerializers.INT, -1, entity -> entity.successTimer, (entity, value) -> entity.successTimer = value);

	private DryadSpriteVariant variant = DryadSpriteVariant.WOOD.get();
	private Optional<UUID> owner = Optional.empty();
	private int successTimer = -1;

	public DryadSpriteEntity(EntityType<? extends DryadSpriteEntity> entityType, Level world) {
		super(entityType, world);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);

		registerDataParams(builder, VARIANT, OWNER, SUCCESS_TIMER);
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData) {
		spawnData = super.finalizeSpawn(world, difficulty, reason, spawnData);

		VARIANT.set(this, DryadSpriteVariant.getVariantForSpawn(world.getLevel(), difficulty, reason, this, Suppliers.memoize(() -> level().getBiome(blockPosition())), spawnData));

		return spawnData;
	}

	@Nullable
	@Override
	protected String getInteractMessage(ItemStack heldItem) {
		if (heldItem.isEmpty())
			return getType().getDescriptionId() + ".interact.empty";

		if (!heldItem.getItem().canPerformAction(heldItem, ItemAbilities.HOE_TILL))
			return getType().getDescriptionId() + ".interact.incorrect";

		return null;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (!source.is(Tags.DamageTypes.IS_TECHNICAL))
			return false;

		return super.hurt(source, amount);
	}

	public void setOwner(ServerPlayer owner) {
		OWNER.set(this, Optional.of(owner.getUUID()));
	}

	@Override
	protected InteractionResult mobInteract(Player player, InteractionHand hand) {
		if (isAlive() && isOwner(player) && SUCCESS_TIMER.is(this, -1)) {
			ItemStack heldStack = player.getItemInHand(hand);

			if (OWNER.get(this).isEmpty())
				OWNER.set(this, Optional.of(player.getUUID()));

			if (heldStack.canPerformAction(ItemAbilities.HOE_TILL)) {
				if (getVariant().isCorrectOffering(heldStack)) {
					if (!level().isClientSide()) {
						SUCCESS_TIMER.set(this, 44);
						player.awardKillScore(this, 1, this.level().damageSources().playerAttack(player));
						navigation.stop();
						setDeltaMovement(0, 0, 0);
					}
				}
				else if (!level().isClientSide) {
					discard();

					level().playSound(null, getX(), getY(), getZ(), AoASounds.ENTITY_DRYAD_SPRITE_UNHAPPY.get(), SoundSource.PLAYERS, 1, 1);

					for(int i = 0; i < 20; ++i) {
						ParticleBuilder.forRandomPosInEntity(ParticleTypes.ANGRY_VILLAGER, this)
								.velocity(RandomUtil.randomScaledGaussianValue(0.02d), RandomUtil.randomScaledGaussianValue(0.02d), RandomUtil.randomScaledGaussianValue(0.02d))
								.sendToAllPlayersTrackingEntity((ServerLevel)level(), this);
					}
				}

				return InteractionResult.SUCCESS;
			}
		}

		return super.mobInteract(player, hand);
	}

	public DryadSpriteVariant getVariant() {
		return this.variant;
	}

	@Override
	public void checkDespawn() {
		super.checkDespawn();

		if (!isRemoved() && tickCount > 100 && SUCCESS_TIMER.is(this, -1))
			discard();
	}

	@Override
	protected void customServerAiStep() {
		if (successTimer > 0) {
			SUCCESS_TIMER.set(this, successTimer - 1);
		}
		else if (successTimer == 0) {
			TELParticlePacket packet = new TELParticlePacket();

			for (int i = 0; i < 20; ++i) {
				packet.particle(ParticleBuilder.forRandomPosInEntity(ParticleTypes.HAPPY_VILLAGER, this)
						.velocity(rand().randomScaledGaussianValue(0.02d), rand().randomScaledGaussianValue(0.02d), rand().randomScaledGaussianValue(0.02d)));
			}

			packet.sendToAllPlayersTrackingEntity((ServerLevel)level(), this);
			level().playSound(null, getX(), getY(), getZ(), AoASounds.ENTITY_DRYAD_SPRITE_HAPPY.get(), SoundSource.NEUTRAL, 1, 1);

			if (level().getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT))
				ExperienceOrb.award((ServerLevel)level(), position(), random.nextInt(10, 20));

			OWNER.get(this).ifPresent(ownerId -> {
				setHealth(0);

				Player player = level().getPlayerByUUID(ownerId);

				if (player != null) {
					setLastHurtByPlayer(player);

					DamageSource damageSource = damageSources().playerAttack(player);

					if (this.deathScore >= 0)
						player.awardKillScore(this, this.deathScore, damageSource);

					this.dead = true;

					getCombatTracker().recheckStatus();

					if (player.killedEntity((ServerLevel)level(), this)) {
						gameEvent(GameEvent.ENTITY_DIE);
						dropAllDeathLoot((ServerLevel)level(), damageSource);
						createWitherRose(player);
					}
				}
			});

			remove(RemovalReason.KILLED);
		}
	}

	public boolean isOwner(Entity entity) {
		return OWNER.get(this).map(value -> value.equals(entity.getUUID())).orElse(true);
	}

	public static AoAEntityStats.AttributeBuilder entityStats(EntityType<DryadSpriteEntity> entityType) {
		return AoAEntityStats.AttributeBuilder.createMonster(entityType)
				.health(5)
				.moveSpeed(0.329)
				.followRange(16);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>(this, state -> {
			if (SUCCESS_TIMER.get(this) >= 0)
				return state.setAndContinue(AoAAnimations.SUCCEED);

			return state.setAndContinue(state.isMoving() ? DefaultAnimations.WALK : DefaultAnimations.IDLE);
		}));
	}
}
