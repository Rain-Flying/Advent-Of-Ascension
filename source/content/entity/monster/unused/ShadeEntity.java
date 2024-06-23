package net.tslat.aoa3.content.entity.monster.unused;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import org.jetbrains.annotations.Nullable;


public class ShadeEntity extends AoAMeleeMob<ShadeEntity> {
	public ShadeEntity(EntityType<? extends ShadeEntity> entityType, Level world) {
		super(entityType, world);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return 1.5f;
	}/*

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return AoASounds.ENTITY_SHADE_AMBIENT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return AoASounds.ENTITY_SHADE_DEATH.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return AoASounds.ENTITY_SHADE_HURT.get();
	}*/

	@Override
	public boolean addEffect(MobEffectInstance effect, @Nullable Entity source) {
		return false;
	}

	@Override
	public boolean isAffectedByPotions() {
		return false;
	}

}
