package net.tslat.aoa3.content.loottable.modifier;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AddItemsLootModifier extends LootModifier {
	public static final MapCodec<AddItemsLootModifier> CODEC = RecordCodecBuilder.mapCodec(builder -> codecStart(builder).and(
			ItemStack.CODEC.listOf().fieldOf("items").forGetter(instance -> instance.additionalStacks)
	).apply(builder, AddItemsLootModifier::new));

	private final List<ItemStack> additionalStacks;

	public AddItemsLootModifier(LootItemCondition[] conditions, List<ItemStack> additionalStacks) {
		super(conditions);

		this.additionalStacks = additionalStacks;
	}

	@Override
	public MapCodec<? extends IGlobalLootModifier> codec() {
		return CODEC;
	}

	@NotNull
	@Override
	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		generatedLoot.addAll(additionalStacks);

		return generatedLoot;
	}
}
