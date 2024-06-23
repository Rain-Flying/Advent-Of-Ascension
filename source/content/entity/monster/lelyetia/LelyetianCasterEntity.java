package net.tslat.aoa3.content.entity.monster.lelyetia;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.common.registration.custom.AoAResources;
import net.tslat.aoa3.content.entity.base.AoARangedMob;
import net.tslat.aoa3.content.entity.projectile.mob.BaseMobProjectile;
import net.tslat.aoa3.content.entity.projectile.mob.LelyetianShotEntity;
import net.tslat.aoa3.util.PlayerUtil;
import org.jetbrains.annotations.Nullable;


public class LelyetianCasterEntity extends AoARangedMob<LelyetianCasterEntity> {
	public LelyetianCasterEntity(EntityType<? extends LelyetianCasterEntity> entityType, Level world) {
		super(entityType, world);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return 1.75f;
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return AoASounds.ENTITY_LELYETIAN_AMBIENT.get();
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return AoASounds.ENTITY_LELYETIAN_DEATH.get();
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return AoASounds.ENTITY_LELYETIAN_HURT.get();
	}

	@Override
	public void onProjectileAttack(BaseMobProjectile projectile, Entity target) {
		if (target instanceof ServerPlayer)
			PlayerUtil.consumeResource((ServerPlayer)target, AoAResources.SPIRIT.get(), 50, true);
	}

	@Nullable
	@Override
	protected SoundEvent getShootSound() {
		return null;
	}

	@Override
	protected BaseMobProjectile getNewProjectileInstance() {
		return new LelyetianShotEntity(this, BaseMobProjectile.Type.MAGIC);
	}
}
