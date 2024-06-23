package net.tslat.aoa3.content.item.weapon.shotgun;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.common.registration.item.AoADataComponents;
import net.tslat.aoa3.common.registration.item.AoAEnchantments;
import net.tslat.aoa3.common.registration.item.AoAItems;
import net.tslat.aoa3.content.entity.projectile.gun.BaseBullet;
import net.tslat.aoa3.content.entity.projectile.gun.LimoniteBulletEntity;
import net.tslat.aoa3.content.entity.projectile.gun.MetalSlugEntity;
import net.tslat.aoa3.content.item.datacomponent.ShotgunStats;
import net.tslat.aoa3.content.item.weapon.gun.BaseGun;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.aoa3.util.NumberUtil;
import net.tslat.smartbrainlib.util.RandomUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BaseShotgun extends BaseGun {
	public BaseShotgun(Item.Properties properties) {
		super(properties);
	}

	public ShotgunStats shotgunStats() {
		return shotgunStats(getDefaultInstance());
	}

	public ShotgunStats shotgunStats(ItemStack stack) {
		return stack.get(AoADataComponents.SHOTGUN_STATS.get());
	}

	@Nullable
	@Override
	public SoundEvent getFiringSound() {
		return AoASounds.ITEM_GUN_SHOTGUN_MEDIUM_FIRE_LONG.get();
	}

	@Override
	public Item getAmmoItem() {
		return AoAItems.SPREADSHOT.get();
	}

	@Override
	public boolean isFullAutomatic() {
		return false;
	}

	public int getPelletCount(ItemStack stack) {
		return shotgunStats(stack).pellets();
	}

	@Override
	protected boolean fireGun(ServerLevel level, LivingEntity shooter, ItemStack stack, InteractionHand hand) {
		BaseBullet bullet = findAndConsumeAmmo(shooter, stack, hand);

		if (bullet == null)
			return false;

		int pellets = getPelletCount(stack);
		float spreadFactor = getSpreadFactor(shooter, stack, pellets);

		for (int i = 0; i < pellets; i++) {
			BaseBullet pellet = new LimoniteBulletEntity(shooter, this, hand, 4, 1.0f, 0, RandomUtil.randomValueUpTo(0.5f) * spreadFactor, RandomUtil.randomValueUpTo(0.5f) * spreadFactor, RandomUtil.randomValueUpTo(0.5f) * spreadFactor);

			level.addFreshEntity(pellet);
		}

		doFiringEffects(level, shooter, bullet, stack, hand);

		return true;
	}

	protected float getSpreadFactor(LivingEntity shooter, ItemStack stack, int pellets) {
		return shooter.level() instanceof ServerLevel level ? AoAEnchantments.modifyPelletSpread(level, stack, 0.1f * pellets) : 0.1f * pellets;
	}

	@Override
	public BaseBullet createProjectileEntity(LivingEntity shooter, ItemStack gunStack, InteractionHand hand) {
		return new MetalSlugEntity(shooter, this, hand, 4, 0);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
		super.appendHoverText(stack, context, tooltip, flag);

		tooltip.set(1, LocaleUtil.getFormattedItemDescriptionText(LocaleUtil.Keys.SHOTGUN_DAMAGE, LocaleUtil.ItemDescriptionType.ITEM_DAMAGE, Component.literal(NumberUtil.roundToNthDecimalPlace(getGunDamage(stack), 2)), LocaleUtil.numToComponent(getPelletCount(stack))));
	}
}
