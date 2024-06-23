package net.tslat.aoa3.content.item.tool.misc;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.tslat.aoa3.content.entity.misc.HaulingFishingBobberEntity;
import net.tslat.aoa3.util.LocaleUtil;

import java.util.List;

public class LightRod extends HaulingRod {
	public LightRod(Properties itemProperties) {
		super(itemProperties);
	}

	@Override
	protected HaulingFishingBobberEntity getNewBobber(Player player, ItemStack stack, float lureMod, float luckMod) {
		return new HaulingFishingBobberEntity(player, player.level(), stack, luckMod, lureMod);
	}

	@Override
	public float getHaulStrengthMod(Player player, ItemStack stack, HaulingFishingBobberEntity bobber) {
		return super.getHaulStrengthMod(player, stack, bobber) * 2f;
	}

	@Override
	public void appendHoverText(ItemStack pStack, TooltipContext context, List<Component> tooltip, TooltipFlag pFlag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.NEUTRAL, 1));
	}
}
