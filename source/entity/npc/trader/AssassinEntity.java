package net.tslat.aoa3.entity.npc.trader;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.tslat.aoa3.common.registration.AoAItems;
import net.tslat.aoa3.common.registration.AoAWeapons;
import net.tslat.aoa3.entity.base.AoATrader;
import net.tslat.aoa3.entity.npc.AoATraderRecipe;
import net.tslat.aoa3.item.misc.ReservedItem;

public class AssassinEntity extends AoATrader {
	public AssassinEntity(EntityType<? extends CreatureEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected boolean isOverworldNPC() {
		return true;
	}

	@Override
	protected ActionResultType mobInteract(PlayerEntity player, Hand hand) {
		ItemStack heldStack = player.getItemInHand(hand);

		if (heldStack.getItem() == AoAItems.ROCK_BONES.get()) {
			if (!level.isClientSide)
				player.setItemInHand(hand, ((ReservedItem)AoAItems.MILLENNIUM_UPGRADER.get()).newValidStack());

			return ActionResultType.SUCCESS;
		}

		return super.mobInteract(player, hand);
	}

	@Override
	protected void getTradesList(final NonNullList<AoATraderRecipe> newTradesList) {
		newTradesList.add(new AoATraderRecipe(new ItemStack(AoAItems.COPPER_COIN.get(), 2), new ItemStack(AoAWeapons.SLICE_STAR.get(), 2)));
		newTradesList.add(new AoATraderRecipe(new ItemStack(AoAItems.COPPER_COIN.get(), 2), new ItemStack(AoAWeapons.GOO_BALL.get(), 3)));
		newTradesList.add(new AoATraderRecipe(new ItemStack(AoAItems.COPPER_COIN.get(), 3), new ItemStack(AoAWeapons.CHAKRAM.get(), 2)));
		newTradesList.add(new AoATraderRecipe(new ItemStack(AoAItems.COPPER_COIN.get(), 2), new ItemStack(AoAWeapons.HELLFIRE.get(), 1)));
		newTradesList.add(new AoATraderRecipe(new ItemStack(AoAItems.COPPER_COIN.get(), 3), new ItemStack(AoAWeapons.VULKRAM.get(), 2)));
		newTradesList.add(new AoATraderRecipe(new ItemStack(AoAItems.COPPER_COIN.get(), 2), new ItemStack(AoAItems.METAL_SLUG.get(), 2)));
		newTradesList.add(new AoATraderRecipe(new ItemStack(AoAItems.COPPER_COIN.get(), 2), new ItemStack(AoAItems.LIMONITE_BULLET.get(), 3)));
	}
}
