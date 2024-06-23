package net.tslat.aoa3.content.entity.animal;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.content.entity.ai.mob.CompletePanicGoal;
import net.tslat.aoa3.content.entity.base.AoAAnimalOld;
import net.tslat.aoa3.content.entity.monster.haven.SpiritGuardianEntity;
import net.tslat.aoa3.content.entity.monster.haven.SpiritProtectorEntity;
import org.jetbrains.annotations.Nullable;


public class EeoEntity extends AoAAnimalOld {
	public EeoEntity(EntityType<? extends Animal> entityType, Level world) {
		super(entityType, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

		goalSelector.addGoal(1, new CompletePanicGoal(this, 200, 1.1d));
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return 1.125f;
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.RABBIT_AMBIENT;
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.RABBIT_DEATH;
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.RABBIT_HURT;
	}

	@Override
	protected boolean isBreedable() {
		return false;
	}

	@Override
	public boolean skipAttackInteraction(Entity entity) {
		if (!level().isClientSide()) {
			if (!level().getEntitiesOfClass(LivingEntity.class, getBoundingBox().inflate(20), nearbyEntity -> nearbyEntity instanceof SpiritGuardianEntity || nearbyEntity instanceof SpiritProtectorEntity).isEmpty())
				return false;

			/*if (random.nextBoolean()) {
				SpiritGuardianEntity guardian = new SpiritGuardianEntity(AoAMonsters.SPIRIT_GUARDIAN.get(), level());

				guardian.absMoveTo(getX(), getY(), getZ(), getYRot(), getXRot());
				level().addFreshEntity(guardian);
			}
			else {
				SpiritProtectorEntity protector = new SpiritProtectorEntity(AoAMonsters.SPIRIT_PROTECTOR.get(), level());

				protector.absMoveTo(getX(), getY(), getZ(), getYRot(), getXRot());
				level().addFreshEntity(protector);
			}*/
		}

		return false;
	}
}
