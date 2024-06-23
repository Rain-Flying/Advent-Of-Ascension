package net.tslat.aoa3.content.entity.monster.unused;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;

public class FishixEntity extends AoAMeleeMob<FishixEntity> {
	public FishixEntity(EntityType<? extends FishixEntity> entityType, Level world) {
		super(entityType, world);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return 1.6875f;
	}

	@Override
	protected float getWaterSlowDown() {
		return 1;
	}/*

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return AoASounds.ENTITY_FISHIX_AMBIENT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return AoASounds.ENTITY_FISHIX_DEATH.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return AoASounds.ENTITY_FISHIX_HURT.get();
	}*/

}
