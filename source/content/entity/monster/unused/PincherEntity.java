package net.tslat.aoa3.content.entity.monster.unused;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.tslat.aoa3.content.entity.ai.movehelper.UnderwaterWalkingMovementController;
import net.tslat.aoa3.content.entity.base.AoAWaterMeleeMobOld;
import net.tslat.aoa3.util.EntityUtil;
import net.tslat.aoa3.util.WorldUtil;
import org.jetbrains.annotations.Nullable;

public class PincherEntity extends AoAWaterMeleeMobOld {
	public PincherEntity(EntityType<? extends WaterAnimal> entityType, Level world) {
		super(entityType, world);

		this.moveControl = new UnderwaterWalkingMovementController(this);
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData) {
		if (EntityUtil.isNaturalSpawnReason(reason)) {
			BlockPos.MutableBlockPos spawnPos = new BlockPos.MutableBlockPos().set(blockPosition());

			while (!world.getBlockState(spawnPos).blocksMotion() && spawnPos.getY() > 0) {
				spawnPos.move(Direction.DOWN);
			}

			setPos(spawnPos.getX(), spawnPos.getY() + 1, spawnPos.getZ());
		}

		return super.finalizeSpawn(world, difficulty, reason, spawnData);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return getDimensions(pose).height() * 0.85f;
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new GroundPathNavigation(this, world);
	}/*

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
	}*/

	@Override
	public void travel(Vec3 motion) {
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
		if (!level().isClientSide && isInWater() && target.isInWater())
			WorldUtil.createExplosion(this, level(), 1.5f);
	}
}
