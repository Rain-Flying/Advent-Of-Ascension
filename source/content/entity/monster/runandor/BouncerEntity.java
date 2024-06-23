package net.tslat.aoa3.content.entity.monster.runandor;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import net.tslat.smartbrainlib.util.RandomUtil;
import org.jetbrains.annotations.Nullable;


public class BouncerEntity extends AoAMeleeMob<BouncerEntity> {
	private int jumpCooldown;

	public BouncerEntity(EntityType<? extends BouncerEntity> entityType, Level world) {
		super(entityType, world);

		rand().setSeed(getUUID().getMostSignificantBits());
		jumpCooldown = RandomUtil.randomNumberBetween(40, 120);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return 1.1875f;
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return AoASounds.ENTITY_BOUNCER_AMBIENT.get();
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return AoASounds.ENTITY_BOUNCER_DEATH.get();
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return AoASounds.ENTITY_BOUNCER_HURT.get();
	}

	@Override
	public boolean causeFallDamage(float distance, float damageMultiplier, DamageSource damageSource) {
		return false;
	}

	@Override
	public float getJumpPower() {
		return jumpCooldown == 0 ? 1.2f : super.getJumpPower();
	}

	@Override
	public void aiStep() {
		super.aiStep();

		if (!isAlive())
			return;

		if (jumpCooldown > 0) {
			jumpCooldown--;
		}
		else if (onGround()) {
			jumpFromGround();
			jumpCooldown = 70;
		}
	}
}
