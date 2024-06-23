package net.tslat.aoa3.content.entity.monster.runandor;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import org.jetbrains.annotations.Nullable;


public class RunicornRiderEntity extends AoAMeleeMob<RunicornRiderEntity> {
	public RunicornRiderEntity(EntityType<? extends RunicornRiderEntity> entityType, Level world) {
		super(entityType, world);

		setSpeed(2.3f);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return 2.34375f;
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return AoASounds.ENTITY_RAINICORN_AMBIENT.get();
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return AoASounds.ENTITY_RAINICORN_DEATH.get();
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return AoASounds.ENTITY_RAINICORN_HURT.get();
	}

	@Override
	protected void actuallyHurt(DamageSource damageSrc, float damageAmount) {
		super.actuallyHurt(damageSrc, damageAmount);

		if (!level().isClientSide && getHealth() <= getMaxHealth() * 0.45f) {
			/*RunicornEntity runicorn = new RunicornEntity(this, getHealth());

			level().addFreshEntity(runicorn);
			setHealth(0);
			die(damageSrc);*/
		}
	}
}
