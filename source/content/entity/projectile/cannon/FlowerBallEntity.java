package net.tslat.aoa3.content.entity.projectile.cannon;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.entity.AoAProjectiles;
import net.tslat.aoa3.content.entity.projectile.HardProjectile;
import net.tslat.aoa3.content.entity.projectile.gun.BaseBullet;
import net.tslat.aoa3.content.item.weapon.gun.BaseGun;

public class FlowerBallEntity extends BaseBullet implements HardProjectile {
	public FlowerBallEntity(EntityType<? extends ThrowableProjectile> entityType, Level world) {
		super(entityType, world);
	}
	
	public FlowerBallEntity(Level world) {
		super(AoAProjectiles.FLOWER_BALL.get(), world);
	}

	public FlowerBallEntity(LivingEntity shooter, BaseGun gun, InteractionHand hand, int maxAge, int piercingValue) {
		super(AoAProjectiles.FLOWER_BALL.get(), shooter, gun, hand, maxAge, 1.0f, piercingValue);
	}

	public FlowerBallEntity(Level world, double x, double y, double z) {
		super(AoAProjectiles.FLOWER_BALL.get(), world, x, y, z);
	}

	@Override
	public double getDefaultGravity() {
		return 0.1f;
	}
}
