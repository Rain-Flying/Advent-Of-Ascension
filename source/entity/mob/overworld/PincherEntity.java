package net.tslat.aoa3.entity.mob.overworld;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.entity.ai.movehelper.UnderwaterWalkingMovementController;
import net.tslat.aoa3.entity.base.AoAWaterMeleeMob;
import net.tslat.aoa3.util.WorldUtil;
import software.bernie.geckolib3.core.manager.AnimationData;

import javax.annotation.Nullable;

public class PincherEntity extends AoAWaterMeleeMob {
	public PincherEntity(EntityType<? extends WaterMobEntity> entityType, World world) {
		super(entityType, world);

		this.moveControl = new UnderwaterWalkingMovementController(this);
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return sizeIn.height * 0.85f;
	}

	@Override
	protected PathNavigator createNavigation(World world) {
		return new GroundPathNavigator(this, world);
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return AoASounds.ENTITY_PINCHER_AMBIENT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return AoASounds.ENTITY_PINCHER_DEATH.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return AoASounds.ENTITY_PINCHER_HURT.get();
	}

	@Override
	public void travel(Vector3d motion) {
		if (isEffectiveAi() && isInWater()) {
			moveRelative(0.01F, motion);
			move(MoverType.SELF, getDeltaMovement());
			setDeltaMovement(getDeltaMovement().scale(0.9D));

			if (getTarget() == null)
				setDeltaMovement(getDeltaMovement().add(0, -0.01d, 0));
		}
		else {
			super.travel(motion);
		}
	}

	@Override
	protected void onAttack(Entity target) {
		if (!level.isClientSide && isInWater() && target.isInWater())
			WorldUtil.createExplosion(this, level, 1.5f);
	}

	@Override
	public CreatureAttribute getMobType() {
		return CreatureAttribute.ARTHROPOD;
	}

	@Override
	public void registerControllers(AnimationData animationData) {}
}
