package net.tslat.aoa3.content.entity.monster.unused;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.client.render.AoAAnimations;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import net.tslat.aoa3.util.EntityUtil;
import net.tslat.effectslib.api.util.EffectBuilder;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.animation.AnimatableManager;


public class GoalbyEntity extends AoAMeleeMob<GoalbyEntity> {
	public GoalbyEntity(EntityType<? extends GoalbyEntity> entityType, Level world) {
		super(entityType, world);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return 1f;
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return AoASounds.ENTITY_GOALBY_AMBIENT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return AoASounds.ENTITY_GOALBY_DEATH.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return AoASounds.ENTITY_GOALBY_HURT.get();
	}

	@Override
	protected void onAttack(Entity target) {
		EntityUtil.applyPotions(target, new EffectBuilder(MobEffects.WEAKNESS, 45));
	}

	@Override
	protected int getAttackSwingDuration() {
		return 13;
	}

	@Override
	protected int getPreAttackTime() {
		return 4;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(
				DefaultAnimations.genericWalkIdleController(this),
				AoAAnimations.genericAttackAnimation(this, DefaultAnimations.ATTACK_BITE));
	}
}
