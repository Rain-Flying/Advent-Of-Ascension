package net.tslat.aoa3.content.item.misc;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.client.ClientOperations;
import net.tslat.aoa3.common.registration.item.AoAItems;
import net.tslat.aoa3.common.registration.worldgen.AoADimensions;
import net.tslat.aoa3.content.entity.base.AoATrader;
import net.tslat.aoa3.content.entity.npc.trader.AoABanker;
import net.tslat.aoa3.util.*;
import net.tslat.smartbrainlib.util.RandomUtil;

import java.util.List;

public class BlankRealmstone extends Item {
	public BlankRealmstone() {
		super(new Item.Properties().stacksTo(1));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		if (world.isClientSide)
			ClientOperations.displayBlankRealmstoneGui();

		return InteractionResultHolder.success(player.getItemInHand(hand));
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
		if (WorldUtil.isWorld(player.level(), AoADimensions.CREEPONIA) && (target instanceof AoATrader || target instanceof AoABanker)) {
			if (player instanceof ServerPlayer serverPlayer && DamageUtil.isPlayerEnvironmentallyProtected(serverPlayer) && serverPlayer.getItemInHand(hand).getItem() == AoAItems.BLANK_REALMSTONE.get()) {
				serverPlayer.setItemInHand(hand, ItemStack.EMPTY);
				InventoryUtil.giveItemTo(serverPlayer, AoAItems.VOX_PONDS_REALMSTONE);
				PlayerUtil.notifyPlayer(serverPlayer, Component.translatable(LocaleUtil.createDialogueLocaleKey("creeponiaBlankRealmstone." + RandomUtil.randomNumberUpTo(3))));
			}

			return InteractionResult.SUCCESS;
		}

		return InteractionResult.PASS;
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (!attacker.level().isClientSide && target.getHealth() <= 0 && target instanceof Husk && attacker instanceof Player)
			attacker.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(AoAItems.BARATHOS_REALMSTONE.get()));

		return super.hurtEnemy(stack, target, attacker);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.NEUTRAL, 1));
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.NEUTRAL, 2));
	}
}
