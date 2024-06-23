package net.tslat.aoa3.content.entity.projectile.blaster;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.entity.AoAProjectiles;
import net.tslat.aoa3.content.entity.projectile.staff.BaseEnergyShot;
import net.tslat.aoa3.content.item.EnergyProjectileWeapon;

public class HeavyShowerShotEntity extends BaseEnergyShot {
	public HeavyShowerShotEntity(EntityType<? extends ThrowableProjectile> entityType, Level world) {
		super(entityType, world);
	}
	
	public HeavyShowerShotEntity(Level world) {
		super(AoAProjectiles.HEAVY_SHOWER_SHOT.get(), world);
	}

	public HeavyShowerShotEntity(LivingEntity shooter, EnergyProjectileWeapon weapon, int maxAge) {
		super(AoAProjectiles.HEAVY_SHOWER_SHOT.get(), shooter, weapon, maxAge);
	}

	public HeavyShowerShotEntity(Level world, double x, double y, double z) {
		super(AoAProjectiles.HEAVY_SHOWER_SHOT.get(), world, x, y, z);
	}

	@Override
	public double getDefaultGravity() {
		return 0.2f;
	}
}
