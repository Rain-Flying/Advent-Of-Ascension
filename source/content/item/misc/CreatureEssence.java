package net.tslat.aoa3.content.item.misc;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.tslat.aoa3.util.LocaleUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CreatureEssence extends Item {
	public CreatureEssence() {
		super(new Item.Properties().rarity(Rarity.RARE).fireResistant());
	}

	/*@Nullable
	public EntityType<?> getStoredEntity(ItemStack stack) {
		if (!stack.hasTag())
			return null;

		CompoundTag tag = stack.getTag();

		if (!tag.contains("essence_entity", Tag.TAG_STRING))
			return null;

		ResourceLocation entityId = new ResourceLocation(tag.getString("essence_entity"));

		return AoARegistries.ENTITIES.hasRegisteredId(entityId) ? AoARegistries.ENTITIES.getEntry(entityId) : null;
	}*/

	@NotNull
	public String getStoredEntityName(ItemStack stack) {
		String entityName = "?";/*

		if (stack.hasTag()) {
			CompoundTag tag = stack.getTag();

			if (tag.contains("essence_entity_name"))
				entityName = tag.getString("essence_entity_name");
		}*/

		return entityName;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipType) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.ITEM_TYPE_INFO, 1, Component.literal(getStoredEntityName(stack))));
	}
}
