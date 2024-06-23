package net.tslat.aoa3.content.loottable.modifier;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.tslat.aoa3.event.AoAPlayerEvents;
import net.tslat.aoa3.player.AoAPlayerEventListener;
import net.tslat.aoa3.util.PlayerUtil;
import org.jetbrains.annotations.NotNull;


public class PlayerEventListenerLootModifier extends LootModifier {
	public static final MapCodec<PlayerEventListenerLootModifier> CODEC = RecordCodecBuilder.mapCodec(builder -> codecStart(builder).apply(builder, PlayerEventListenerLootModifier::new));
	private static final LootContextParam<?>[] ENTITY_SOURCE_PARAMS = new LootContextParam<?>[] {LootContextParams.THIS_ENTITY, LootContextParams.DIRECT_ATTACKING_ENTITY, LootContextParams.ATTACKING_ENTITY, LootContextParams.LAST_DAMAGE_PLAYER};

	public PlayerEventListenerLootModifier(LootItemCondition[] conditions) {
		super(conditions);
	}

	@Override
	public MapCodec<? extends IGlobalLootModifier> codec() {
		return CODEC;
	}

	@NotNull
	@Override
	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		for (LootContextParam<?> param : ENTITY_SOURCE_PARAMS) {
			if (context.hasParam(param)) {
				Player pl = PlayerUtil.getPlayerOrOwnerIfApplicable((Entity)context.getParamOrNull(param));

				if (pl instanceof ServerPlayer) {
					AoAPlayerEvents.issueEvent((ServerPlayer)pl, AoAPlayerEventListener.ListenerType.LOOT_MODIFICATION, listener -> listener.handleLootModification(generatedLoot, context));

					return generatedLoot;
				}
			}
		}

		return generatedLoot;
	}
}
