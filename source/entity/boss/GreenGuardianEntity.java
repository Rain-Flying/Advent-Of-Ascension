package net.tslat.aoa3.entity.boss;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.tslat.aoa3.advent.AdventOfAscension;
import net.tslat.aoa3.common.packet.AoAPackets;
import net.tslat.aoa3.common.packet.packets.MusicPacket;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.entity.base.AoARangedMob;
import net.tslat.aoa3.entity.minion.AoAMinion;
import net.tslat.aoa3.entity.projectile.mob.BaseMobProjectile;
import net.tslat.aoa3.entity.projectile.mob.GreenGuardianShotEntity;
import net.tslat.aoa3.util.AdvancementUtil;
import net.tslat.aoa3.util.WorldUtil;

import javax.annotation.Nullable;

public class GreenGuardianEntity extends AoARangedMob {
	private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(getType().getDescription().copy().append(getDisplayName()), BossInfo.Color.GREEN, BossInfo.Overlay.NOTCHED_20)).setDarkenScreen(false).setCreateWorldFog(false);

	private BlueGuardianEntity blueGuardian;
	private RedGuardianEntity redGuardian;
	private YellowGuardianEntity yellowGuardian;

	public GreenGuardianEntity(EntityType<? extends MonsterEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected float getStandingEyeHeight(Pose pose, EntitySize size) {
		return 1.875f;
	}

	@Override
	protected void registerGoals() {
		goalSelector.addGoal(1, new SwimGoal(this));
		goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0d, 35, 60, 32));
		goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1));
		goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8f));
		goalSelector.addGoal(8, new LookRandomlyGoal(this));
		targetSelector.addGoal(1, new NearestAttackableTargetGoal<AoAMinion>(this, AoAMinion.class, true));
		targetSelector.addGoal(2, new HurtByTargetGoal(this));
		targetSelector.addGoal(3, new NearestAttackableTargetGoal<PlayerEntity>(this, PlayerEntity.class, true));
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return AoASounds.ENTITY_GUARDIAN_DEATH.get();
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return AoASounds.ENTITY_GUARDIAN_HURT.get();
	}

	@Nullable
	@Override
	protected SoundEvent getShootSound() {
		return AoASounds.ENTITY_GUARDIAN_SHOOT.get();
	}

	@Nullable
	@Override
	protected ResourceLocation getDefaultLootTable() {
		if (checkGuardian(blueGuardian) && checkGuardian(redGuardian) && checkGuardian(yellowGuardian))
			return super.getDefaultLootTable();

		return null;
	}

	@Override
	public boolean canChangeDimensions() {
		return false;
	}

	public void setRedGuardian(RedGuardianEntity redGuardian) {
		this.redGuardian = redGuardian;
	}

	public void setBlueGuardian(BlueGuardianEntity blueGuardian) {
		this.blueGuardian = blueGuardian;
	}

	public void setYellowGuardian(YellowGuardianEntity yellowGuardian) {
		this.yellowGuardian = yellowGuardian;
	}

	private boolean checkGuardian(LivingEntity guardian) {
		return guardian == null || !guardian.isAlive() || guardian.getHealth() == 0;
	}

	@Override
	public void die(DamageSource cause) {
		super.die(cause);

		if (!level.isClientSide) {
			remove();

			if (checkGuardian(yellowGuardian) && checkGuardian(blueGuardian) && checkGuardian(redGuardian)) {
				for (ServerPlayerEntity pl : level.getEntitiesOfClass(ServerPlayerEntity.class, getBoundingBox().inflate(20))) {
					AdvancementUtil.completeAdvancement(pl, new ResourceLocation(AdventOfAscension.MOD_ID, "haven/guard_that"), "kill_four_guardians");
				}
			}
		}
	}

	@Override
	public void doProjectileEntityImpact(BaseMobProjectile projectile, Entity target) {
		if (target instanceof AoARangedMob && !target.canChangeDimensions())
			return;

		super.doProjectileEntityImpact(projectile, target);
	}

	@Override
	public void doProjectileImpactEffect(BaseMobProjectile projectile, Entity target) {
		WorldUtil.createExplosion(this, level, projectile, 2f);
	}

	@Override
	public void doProjectileBlockImpact(BaseMobProjectile projectile, BlockState blockHit, BlockPos pos, Direction sideHit) {
		WorldUtil.createExplosion(this, level, projectile, 2f);
	}

	@Override
	protected BaseMobProjectile getNewProjectileInstance() {
		return new GreenGuardianShotEntity(this, BaseMobProjectile.Type.MAGIC);
	}

	@Override
	public void readAdditionalSaveData(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);

		if (hasCustomName())
			bossInfo.setName(getType().getDescription().copy().append(getDisplayName()));
	}

	@Override
	public void setCustomName(@Nullable ITextComponent name) {
		super.setCustomName(name);

		bossInfo.setName(getType().getDescription().copy().append(getDisplayName()));
	}

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();

		bossInfo.setPercent(getHealth() / getMaxHealth());
	}

	@Override
	public void startSeenByPlayer(ServerPlayerEntity player) {
		super.startSeenByPlayer(player);

		AoAPackets.messagePlayer(player, new MusicPacket(true, AoASounds.GREEN_GUARDIAN_MUSIC.getId()));
		bossInfo.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayerEntity player) {
		super.stopSeenByPlayer(player);

		AoAPackets.messagePlayer(player, new MusicPacket(false, AoASounds.GREEN_GUARDIAN_MUSIC.getId()));
		bossInfo.removePlayer(player);
	}

}
