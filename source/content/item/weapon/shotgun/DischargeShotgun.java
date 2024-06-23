package net.tslat.aoa3.content.item.weapon.shotgun;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.phys.Vec3;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.common.registration.item.AoAItems;
import net.tslat.aoa3.content.entity.projectile.gun.BaseBullet;
import net.tslat.aoa3.content.entity.projectile.gun.DischargeShotEntity;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.aoa3.util.NumberUtil;
import net.tslat.aoa3.util.WorldUtil;
import net.tslat.smartbrainlib.util.RandomUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DischargeShotgun extends BaseShotgun {
	public DischargeShotgun(Item.Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public SoundEvent getFiringSound() {
		return AoASounds.ITEM_GUN_SHOTGUN_HEAVY_FIRE_LONG.get();
	}

	@Override
	public Item getAmmoItem() {
		return AoAItems.DISCHARGE_CAPSULE.get();
	}

	@Override
	public void doImpactDamage(Entity target, LivingEntity shooter, BaseBullet bullet, Vec3 impactPosition, float bulletDmgMultiplier) {
		WorldUtil.createExplosion(shooter, bullet.level(), bullet, 2.5f);
	}

	@Override
	protected boolean fireGun(ServerLevel level, LivingEntity shooter, ItemStack stack, InteractionHand hand) {
		BaseBullet bullet = findAndConsumeAmmo(shooter, stack, hand);

		if (bullet == null)
			return false;

		int pellets = getPelletCount(stack);
		float spreadFactor = getSpreadFactor(shooter, stack, pellets);

		for (int i = 0; i < pellets; i++) {
			BaseBullet pellet = new DischargeShotEntity(shooter, this, hand, 4, 1.0f, 0, RandomUtil.randomValueUpTo(0.5f) * spreadFactor, RandomUtil.randomValueUpTo(0.5f) * spreadFactor, RandomUtil.randomValueUpTo(0.5f) * spreadFactor);

			level.addFreshEntity(pellet);
		}

		doFiringEffects(level, shooter, bullet, stack, hand);

		return true;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
		super.appendHoverText(stack, context, tooltip, flag);

		tooltip.set(1, LocaleUtil.getFormattedItemDescriptionText(LocaleUtil.Keys.EXPLODES_ON_HIT, LocaleUtil.ItemDescriptionType.BENEFICIAL));
		tooltip.add(2, LocaleUtil.getFormattedItemDescriptionText(LocaleUtil.Keys.FIRING_SPEED, LocaleUtil.ItemDescriptionType.NEUTRAL, Component.literal(NumberUtil.roundToNthDecimalPlace(20 / (float) getTicksBetweenShots(stack), 2))));
	}
}
