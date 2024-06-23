package net.tslat.aoa3.content.entity.monster.lelyetia;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.client.render.AoAAnimations;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.animation.AnimatableManager;


public class TrackerEntity extends AoAMeleeMob<TrackerEntity> {
	public TrackerEntity(EntityType<? extends TrackerEntity> entityType, Level world) {
		super(entityType, world);

		setSpeed(1.4f);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return 1.125f;
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return AoASounds.ENTITY_TRACKER_AMBIENT.get();
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return AoASounds.ENTITY_TRACKER_DEATH.get();
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return AoASounds.ENTITY_TRACKER_HURT.get();
	}

	@Override
	protected int getPreAttackTime() {
		return 8;
	}

	@Override
	protected int getAttackSwingDuration() {
		return 13;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(
				DefaultAnimations.genericWalkIdleController(this),
				AoAAnimations.genericAttackAnimation(this, DefaultAnimations.ATTACK_STOMP));
	}
}
