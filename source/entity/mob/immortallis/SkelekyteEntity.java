package net.tslat.aoa3.entity.mob.immortallis;

import net.minecraft.entity.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.tslat.aoa3.common.registration.AoADimensions;
import net.tslat.aoa3.entity.base.AoAMeleeMob;
import net.tslat.aoa3.util.EntityUtil;
import net.tslat.aoa3.util.PotionUtil;
import net.tslat.aoa3.util.WorldUtil;
import net.tslat.aoa3.util.constant.Deities;
import net.tslat.aoa3.util.player.PlayerDataManager;
import net.tslat.aoa3.util.player.PlayerUtil;

import javax.annotation.Nullable;

public class SkelekyteEntity extends AoAMeleeMob {
	private int cloakCooldown = 80;

	public SkelekyteEntity(EntityType<? extends MonsterEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return 1.71875f;
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.SKELETON_AMBIENT;
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.SKELETON_DEATH;
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.SKELETON_HURT;
	}

	@Nullable
	@Override
	protected ResourceLocation getDefaultLootTable() {
		return null;
	}

	@Override
	public CreatureAttribute getMobType() {
		return CreatureAttribute.UNDEAD;
	}

	@Override
	public void aiStep() {
		super.aiStep();

		cloakCooldown--;

		if (cloakCooldown == 0) {
			cloakCooldown = 80;

			setDeltaMovement(getDeltaMovement().multiply(0.5f, 1, 0.5f));
			EntityUtil.applyPotions(this, new PotionUtil.EffectBuilder(Effects.INVISIBILITY, 20));
		}
	}

	@Override
	public void die(DamageSource cause) {
		super.die(cause);

		if (!level.isClientSide && WorldUtil.isWorld(level, AoADimensions.IMMORTALLIS.key)) {
			Entity attacker = cause.getEntity();

			if (attacker instanceof PlayerEntity || attacker instanceof TameableEntity) {
				ServerPlayerEntity pl = null;

				if (attacker instanceof TameableEntity) {
					if (((TameableEntity)attacker).getOwner() instanceof ServerPlayerEntity)
						pl = (ServerPlayerEntity)((TameableEntity)attacker).getOwner();
				}
				else {
					pl = (ServerPlayerEntity)attacker;
				}

				if (pl != null) {
					PlayerDataManager plData = PlayerUtil.getAdventPlayer(pl);

					if (plData.stats().getTribute(Deities.EREBON) < 100)
						plData.stats().addTribute(Deities.EREBON, Math.min(4, 100 - plData.stats().getTribute(Deities.EREBON)));

					if (plData.stats().getTribute(Deities.EREBON) >= 100)
						plData.sendThrottledChatMessage("message.feedback.immortallisProgression.skeletalSpiritsEnd");
				}
			}
		}
	}
}
