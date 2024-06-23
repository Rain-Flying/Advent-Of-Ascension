package net.tslat.aoa3.content.loottable.modifier;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.tslat.aoa3.content.item.LootModifyingItem;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class LootModifyingItemLootModifier extends LootModifier {
	public static final MapCodec<LootModifyingItemLootModifier> CODEC = RecordCodecBuilder.mapCodec(builder -> codecStart(builder).apply(builder, LootModifyingItemLootModifier::new));

	public LootModifyingItemLootModifier(LootItemCondition[] conditions) {
		super(conditions);
	}

	@Override
	public MapCodec<? extends IGlobalLootModifier> codec() {
		return CODEC;
	}

	@NotNull
	@Override
	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		ItemStack tool = ItemStack.EMPTY;

		if (context.hasParam(LootContextParams.TOOL)) {
			tool = context.getParamOrNull(LootContextParams.TOOL);

			if (tool == null)
				return generatedLoot;
		}
		else if (context.hasParam(LootContextParams.ATTACKING_ENTITY)) {
			Entity entity = context.getParamOrNull(LootContextParams.ATTACKING_ENTITY);

			if (entity instanceof LivingEntity killer) {
				Iterator<ItemStack> heldItems = killer.getHandSlots().iterator();

				if (heldItems.hasNext())
					tool = heldItems.next();
			}
		}

		if (tool.getItem() instanceof LootModifyingItem)
			((LootModifyingItem)tool.getItem()).doLootModification(generatedLoot, context);

		return generatedLoot;
	}
}
