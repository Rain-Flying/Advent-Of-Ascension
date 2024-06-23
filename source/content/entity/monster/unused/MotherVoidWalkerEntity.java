package net.tslat.aoa3.content.entity.monster.unused;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import net.tslat.aoa3.util.EntityUtil;
import net.tslat.effectslib.api.util.EffectBuilder;

public class MotherVoidWalkerEntity extends AoAMeleeMob<MotherVoidWalkerEntity> {
	public MotherVoidWalkerEntity(EntityType<? extends MotherVoidWalkerEntity> entityType, Level world) {
		super(entityType, world);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return getDimensions(pose).height() * 0.85f;
	}/*

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return AoASounds.ENTITY_MOTHER_VOID_WALKER_AMBIENT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return AoASounds.ENTITY_MOTHER_VOID_WALKER_DEATH.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return AoASounds.ENTITY_MOTHER_VOID_WALKER_HURT.get();
	}*/

	@Override
	protected void onAttack(Entity target) {
		EntityUtil.applyPotions(target, new EffectBuilder(MobEffects.BLINDNESS, 200));
	}

}
