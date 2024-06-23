package net.tslat.aoa3.content.item.weapon.gun;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.projectile.gun.BaseBullet;
import net.tslat.aoa3.content.entity.projectile.gun.WartDartEntity;
import net.tslat.aoa3.util.LocaleUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WartGun extends BaseGun {
	public WartGun(Item.Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public SoundEvent getFiringSound() {
		return AoASounds.ITEM_GUN_BLOWPIPE_SHOOT.get();
	}

	@Override
	public boolean isFullAutomatic() {
		return false;
	}

	@Override
	public Item getAmmoItem() {
		return Items.NETHER_WART;
	}

	@Override
	protected void doImpactEffect(Entity target, LivingEntity shooter, BaseBullet bullet, Vec3 impactPos, float bulletDmgMultiplier) {
		if (target instanceof LivingEntity)
			target.igniteForSeconds(3);
	}

	@Override
	public BaseBullet createProjectileEntity(LivingEntity shooter, ItemStack gunStack, InteractionHand hand) {
		return new WartDartEntity(shooter, this, hand, 120, 0);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(LocaleUtil.Keys.BURNS_TARGETS, LocaleUtil.ItemDescriptionType.BENEFICIAL));

		super.appendHoverText(stack, context, tooltip, flag);
	}

	@Override
	protected void doFiringEffects(ServerLevel level, LivingEntity shooter, BaseBullet bullet, ItemStack stack, InteractionHand hand) {
		doFiringSound(shooter, bullet, stack, hand);
	}
}
