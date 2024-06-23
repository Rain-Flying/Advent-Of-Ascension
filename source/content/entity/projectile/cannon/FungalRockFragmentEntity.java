package net.tslat.aoa3.content.entity.projectile.cannon;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.tslat.aoa3.common.registration.AoAGameRules;
import net.tslat.aoa3.common.registration.entity.AoAProjectiles;
import net.tslat.aoa3.content.entity.projectile.HardProjectile;
import net.tslat.aoa3.content.entity.projectile.gun.BaseBullet;
import net.tslat.aoa3.content.item.weapon.gun.BaseGun;
import net.tslat.aoa3.util.WorldUtil;

public class FungalRockFragmentEntity extends BaseBullet implements HardProjectile {
	public FungalRockFragmentEntity(EntityType<? extends ThrowableProjectile> entityType, Level world) {
		super(entityType, world);
	}

	public FungalRockFragmentEntity(Level world) {
		super(AoAProjectiles.FUNGAL_ROCK_FRAGMENT.get(), world);
	}

	public FungalRockFragmentEntity(LivingEntity shooter, BaseGun gun, InteractionHand hand, int maxAge, int piercingValue) {
		super(AoAProjectiles.FUNGAL_ROCK_FRAGMENT.get(), shooter, gun, hand, maxAge, 1.0f, piercingValue);
	}

	public FungalRockFragmentEntity(Level world, double x, double y, double z) {
		super(AoAProjectiles.FUNGAL_ROCK_FRAGMENT.get(), world, x, y, z);
	}

	@Override
	public void doBlockImpact(Vec3 impactLocation, Direction face, BlockPos blockPos) {
		if (!level().isClientSide && AoAGameRules.checkDestructiveWeaponPhysics(level()) && level().isEmptyBlock(blockPosition())) {
			int i = 1;

			while (level().getBlockState(blockPosition().below(i)).canBeReplaced() && blockPosition().getY() - i >= 0) {
				i++;
			}

			if (blockPosition().getY() - i <= 0)
				return;

			Entity shooter = getOwner();

			if (!WorldUtil.canPlaceBlock(level(), blockPosition(), shooter instanceof Player ? shooter : null, null))
				return;

			level().setBlockAndUpdate(blockPosition().below(i - 1), Blocks.COBBLESTONE.defaultBlockState());
		}
	}

	@Override
	public double getDefaultGravity() {
		return 0.06f;
	}
}
