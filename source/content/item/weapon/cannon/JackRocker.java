package net.tslat.aoa3.content.item.weapon.cannon;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.projectile.cannon.RockFragmentEntity;
import net.tslat.aoa3.content.entity.projectile.gun.BaseBullet;
import org.jetbrains.annotations.Nullable;

public class JackRocker extends BaseCannon {
	public JackRocker(Item.Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public SoundEvent getFiringSound() {
		return AoASounds.ITEM_JACK_ROCKER_FIRE.get();
	}

	@Override
	public Item getAmmoItem() {
		return Blocks.COBBLESTONE.asItem();
	}

	@Override
	public BaseBullet createProjectileEntity(LivingEntity shooter, ItemStack gunStack, InteractionHand hand) {
		return new RockFragmentEntity(shooter, this, hand, 120, 0);
	}
}
