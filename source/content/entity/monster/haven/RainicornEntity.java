package net.tslat.aoa3.content.entity.monster.haven;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.base.AoAAnimalOld;
import org.jetbrains.annotations.Nullable;


public class RainicornEntity extends AoAAnimalOld {
	public RainicornEntity(EntityType<? extends Animal> entityType, Level world) {
		super(entityType, world);

		setSpeed(2.3f);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return 1.3125f;
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
	protected boolean isBreedable() {
		return false;
	}
}
