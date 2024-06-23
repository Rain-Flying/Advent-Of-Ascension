package net.tslat.aoa3.content.entity.projectile.mob;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.content.entity.base.AoARangedAttacker;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class StoneGiantRockEntity extends BaseMobProjectile implements GeoEntity {
	private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

	public StoneGiantRockEntity(EntityType<? extends ThrowableProjectile> entityType, Level level) {
		super(entityType, level);
	}

	public StoneGiantRockEntity(EntityType<? extends ThrowableProjectile> entityType, Level world, AoARangedAttacker shooter, double posX, double posY, double posZ, Type projectileType) {
		super(entityType, world, shooter, posX, posY, posZ, projectileType);
	}

	public StoneGiantRockEntity(EntityType<? extends ThrowableProjectile> entityType, Level world, AoARangedAttacker shooter, Entity target, Type projectileType) {
		super(entityType, world, shooter, target, projectileType);
	}

	public StoneGiantRockEntity(EntityType<? extends ThrowableProjectile> entityType, Level world, AoARangedAttacker shooter, Type projectileType) {
		super(entityType, world, shooter, projectileType);
	}

	@Override
	public double getDefaultGravity() {
		return 0.5f;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.geoCache;
	}
}
