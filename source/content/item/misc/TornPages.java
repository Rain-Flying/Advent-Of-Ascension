package net.tslat.aoa3.content.item.misc;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class TornPages extends Item {
	public TornPages() {
		super(new Properties().stacksTo(1));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		ItemStack bookStack = player.getItemInHand(hand);

		/*if (!IntegrationManager.isPatchouliActive())
			return InteractionResultHolder.pass(bookStack);

		CompoundTag tag = bookStack.getTag();

		if (tag == null || !tag.contains("TornPagesEntryId"))
			return InteractionResultHolder.pass(bookStack);

		ResourceLocation bookId = new ResourceLocation(tag.getString("TornPagesEntryId"));

		if (!PatchouliIntegration.isBookLoaded(bookId))
			return InteractionResultHolder.pass(bookStack);

		if (!world.isClientSide) {
			PlayerUtil.getAdventPlayer((ServerPlayer)player).addPatchouliBook(bookId);
		}
		else {
			if (IntegrationManager.isPatchouliActive())
				PatchouliIntegration.openBook(bookId);
		}*/

		return InteractionResultHolder.success(bookStack);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag isAdvanced) {
		/*CompoundTag tag = stack.getTag();

		if (tag == null || !tag.contains("TornPagesEntryId"))
			return;

		boolean patchouli = IntegrationManager.isPatchouliActive();

		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, patchouli ? LocaleUtil.ItemDescriptionType.NEUTRAL : LocaleUtil.ItemDescriptionType.HARMFUL, patchouli ? 1 : 2));*/
	}
}
