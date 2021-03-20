package net.tslat.aoa3.entity.projectile.blaster;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.world.World;
import net.tslat.aoa3.common.registration.AoAEntities;
import net.tslat.aoa3.entity.projectile.staff.BaseEnergyShot;
import net.tslat.aoa3.item.EnergyProjectileWeapon;

public class DoomShotEntity extends BaseEnergyShot {
	public DoomShotEntity(EntityType<? extends ThrowableEntity> entityType, World world) {
		super(entityType, world);
	}
	
	public DoomShotEntity(World world) {
		super(AoAEntities.Projectiles.DOOM_SHOT.get(), world);
	}

	public DoomShotEntity(LivingEntity shooter, EnergyProjectileWeapon weapon, int maxAge) {
		super(AoAEntities.Projectiles.DOOM_SHOT.get(), shooter, weapon, maxAge);
	}

	public DoomShotEntity(World world, double x, double y, double z) {
		super(AoAEntities.Projectiles.DOOM_SHOT.get(), world, x, y, z);
	}

	@Override
	public float getGravity() {
		return 0.03f;
	}
}
