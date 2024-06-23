package net.tslat.aoa3.content.loottable.modifier;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.tslat.aoa3.common.registration.AoARegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ReplaceItemsLootModifier extends LootModifier {
	public static final MapCodec<ReplaceItemsLootModifier> CODEC = RecordCodecBuilder.mapCodec(builder -> codecStart(builder).and(
			Codec.pair(
					AoARegistries.ITEMS.lookupCodec().fieldOf("item").codec(),
					ItemStack.CODEC.fieldOf("replace_with").codec()
			).listOf().fieldOf("replacements").forGetter(instance -> instance.replacements)
	).apply(builder, ReplaceItemsLootModifier::new));

	private final List<Pair<Item, ItemStack>> replacements;

	public ReplaceItemsLootModifier(LootItemCondition[] conditions, List<Pair<Item, ItemStack>> replacements) {
		super(conditions);

		this.replacements = replacements;
	}

	@Override
	public MapCodec<? extends IGlobalLootModifier> codec() {
		return CODEC;
	}

	@NotNull
	@Override
	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		ObjectArrayList<ItemStack> loot = new ObjectArrayList<>();

		for (ItemStack stack : generatedLoot) {
			for (Pair<Item, ItemStack> pair : this.replacements) {
				loot.add((stack.is(pair.getFirst()) ? pair.getSecond() : stack));
			}
		}

		if (context.getParamOrNull(LootContextParams.THIS_ENTITY) instanceof Mob mob) {
			for(EquipmentSlot slot : EquipmentSlot.values()) {
				ItemStack stack = mob.getItemBySlot(slot);

				if (stack.isEmpty())
					continue;

				for (Pair<Item, ItemStack> pair : this.replacements) {
					if (stack.is(pair.getFirst())) {
						mob.setItemSlot(slot, pair.getSecond());

						break;
					}
				}
			}
		}

		return loot;
	}
}
