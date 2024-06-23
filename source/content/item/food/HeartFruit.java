package net.tslat.aoa3.content.item.food;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.item.AoAFood;
import net.tslat.aoa3.common.registration.item.AoAItems;
import net.tslat.aoa3.common.registration.worldgen.AoADimensions;
import net.tslat.aoa3.util.DamageUtil;
import net.tslat.aoa3.util.ItemUtil;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.aoa3.util.WorldUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HeartFruit extends Item {
	public HeartFruit() {
		super(new Item.Properties().food(AoAFood.HEART_FRUIT));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
		if (!world.isClientSide) {
			DamageUtil.doRecoilAttack(entity, 7);

			if (entity.getHealth() > 0 && WorldUtil.isWorld(world, AoADimensions.PRECASIA) && entity instanceof ServerPlayer && ItemUtil.findInventoryItem((ServerPlayer)entity, new ItemStack(AoAItems.BLANK_REALMSTONE.get()), true, 1, false))
				ItemUtil.givePlayerItemOrDrop((ServerPlayer)entity, new ItemStack(AoAItems.CANDYLAND_REALMSTONE.get()));
		}

		return super.finishUsingItem(stack, world, entity);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.NEUTRAL, 1));
	}
}