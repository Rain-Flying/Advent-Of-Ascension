package net.tslat.aoa3.entity.base;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.tslat.aoa3.common.registration.AoAAttributes;
import net.tslat.aoa3.config.AoAConfig;
import net.tslat.aoa3.entity.ai.mob.FlyingLookRandomlyGoal;
import net.tslat.aoa3.entity.ai.mob.FlyingRangedAttackGoal;
import net.tslat.aoa3.entity.ai.mob.RandomFlyingGoal;
import net.tslat.aoa3.entity.ai.movehelper.RoamingFlightMovementController;
import net.tslat.aoa3.entity.minion.AoAMinion;
import net.tslat.aoa3.entity.projectile.mob.BaseMobProjectile;
import net.tslat.aoa3.util.DamageUtil;
import net.tslat.aoa3.util.player.PlayerUtil;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AoAFlyingRangedMob extends FlyingEntity implements IMob, IRangedAttackMob, AoARangedAttacker {
	protected boolean isSlipperyMovement = false;

	protected AoAFlyingRangedMob(EntityType<? extends FlyingEntity> entityType, World world) {
		super(entityType, world);

		moveControl = new RoamingFlightMovementController(this);
	}

	@Override
	protected void registerGoals() {
		goalSelector.addGoal(1, new RandomFlyingGoal(this, true));
		goalSelector.addGoal(2, new FlyingLookRandomlyGoal(this));
		goalSelector.addGoal(3, new FlyingRangedAttackGoal(this, 40, 80));
		targetSelector.addGoal(1, new NearestAttackableTargetGoal<AoAMinion>(this, AoAMinion.class, 10, true, true, entity -> entity instanceof AoAMinion && ((AoAMinion)entity).isTame()));
		targetSelector.addGoal(2, new NearestAttackableTargetGoal<PlayerEntity>(this, PlayerEntity.class, 10, true, true, pl -> pl instanceof PlayerEntity && PlayerUtil.shouldPlayerBeAffected((PlayerEntity)pl)));
	}

	@Nullable
	@Override
	public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
		xpReward = (int)(5 + (getAttributeValue(Attributes.MAX_HEALTH) + getAttributeValue(Attributes.ARMOR) * 1.75f + getAttributeValue(AoAAttributes.RANGED_ATTACK_DAMAGE.get()) * 2) / 10f);

		return super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
	}

	@Override
	protected PathNavigator createNavigation(World world) {
		return new FlyingPathNavigator(this, world);
	}

	@Override
	protected abstract float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn);

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return null;
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return null;
	}

	@Nullable
	protected abstract SoundEvent getShootSound();

	protected void onHit(DamageSource source, float amount) {}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (super.hurt(source, amount)) {
			onHit(source, amount);

			return true;
		}

		return false;
	}

	@Override
	public void performRangedAttack(@Nonnull LivingEntity target, float bowDamageFactor) {
		BaseMobProjectile projectile = getNewProjectileInstance();

		double distanceFactorX = target.getX() - projectile.getX();
		double distanceFactorY = target.getBoundingBox().minY + (target.getBbHeight() / 3) - projectile.getY();
		double distanceFactorZ = target.getZ() - projectile.getZ();
		double hyp = MathHelper.sqrt(distanceFactorX * distanceFactorX + distanceFactorZ * distanceFactorZ) * 0.05d;

		if (getShootSound() != null)
			level.playSound(null, getX(), getY(), getZ(), getShootSound(), SoundCategory.HOSTILE, 1.0f, 1.0f);

		projectile.shoot(distanceFactorX, distanceFactorY + hyp, distanceFactorZ, 1.6f, (float)(4 - level.getDifficulty().getId()));
		level.addFreshEntity(projectile);
	}

	protected abstract BaseMobProjectile getNewProjectileInstance();

	@Override
	public void doProjectileEntityImpact(BaseMobProjectile projectile, Entity target) {
		boolean success;
		float mod = AoAConfig.COMMON.hardcoreMode.get() ? 1.5f : 1f;

		switch (projectile.getProjectileType()) {
			case MAGIC:
				success = DamageUtil.dealMagicDamage(projectile, this, target, (float)getAttributeValue(AoAAttributes.RANGED_ATTACK_DAMAGE.get()) * mod, false);
				break;
			case GUN:
				success = DamageUtil.dealGunDamage(target, this, projectile, (float)getAttributeValue(AoAAttributes.RANGED_ATTACK_DAMAGE.get()) * mod);
				break;
			case PHYSICAL:
				success = DamageUtil.dealRangedDamage(target, this, projectile, (float)getAttributeValue(AoAAttributes.RANGED_ATTACK_DAMAGE.get()) * mod);
				break;
			case OTHER:
			default:
				success = target.hurt(DamageSource.indirectMobAttack(projectile, this), (float)getAttributeValue(AoAAttributes.RANGED_ATTACK_DAMAGE.get()) * mod);
				break;
		}

		if (success)
			doProjectileImpactEffect(projectile, target);
	}

	@Override
	public void doProjectileBlockImpact(BaseMobProjectile projectile, BlockState blockHit, BlockPos pos, Direction sideHit) {}

	@Override
	public void doProjectileImpactEffect(BaseMobProjectile projectile, Entity target) {}

	@Override
	public boolean isIgnoringBlockTriggers() {
		return true;
	}

	@Override
	protected boolean isMovementNoisy() {
		return false;
	}

	@Override
	protected boolean shouldDespawnInPeaceful() {
		return true;
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {}
}
