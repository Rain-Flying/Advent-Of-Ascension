package net.tslat.aoa3.content.entity.projectile.mob;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.entity.AoAProjectiles;
import net.tslat.aoa3.content.entity.base.AoARangedMob;

public class YellowGuardianShotEntity extends BaseMobProjectile {
	public YellowGuardianShotEntity(EntityType<? extends ThrowableProjectile> entityType, Level world) {
		super(entityType, world);
	}

	public YellowGuardianShotEntity(Level world) {
		super(AoAProjectiles.YELLOW_GUARDIAN_SHOT.get(), world);
	}

	public YellowGuardianShotEntity(AoARangedMob shooter, Type projectileType) {
		super(AoAProjectiles.YELLOW_GUARDIAN_SHOT.get(), shooter.level(), shooter, projectileType);
	}

	@Override
	public double getDefaultGravity() {
		return 0.075f;
	}
}
