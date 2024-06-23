package net.tslat.aoa3.content.entity.monster.candyland;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.base.AoAFlyingRangedMob;
import net.tslat.aoa3.content.entity.projectile.mob.BaseMobProjectile;
import net.tslat.aoa3.content.entity.projectile.mob.SkyShotEntity;
import org.jetbrains.annotations.Nullable;


public class AirheadEntity extends AoAFlyingRangedMob {
	public AirheadEntity(EntityType<? extends FlyingMob> entityType, Level world) {
		super(entityType, world);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return 0.53125f;
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return AoASounds.ENTITY_AIRHEAD_AMBIENT.get();
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return AoASounds.ENTITY_AIRHEAD_HURT.get();
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return AoASounds.ENTITY_AIRHEAD_DEATH.get();
	}

	@Nullable
	@Override
	protected SoundEvent getShootSound() {
		return null;
	}

	@Override
	protected BaseMobProjectile getNewProjectileInstance() {
		return new SkyShotEntity(this, BaseMobProjectile.Type.PHYSICAL);
	}
}
