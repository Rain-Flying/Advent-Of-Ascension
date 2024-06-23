package net.tslat.aoa3.player.skill;

import com.google.gson.JsonObject;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.NetherWartBlock;
import net.neoforged.neoforge.event.entity.living.BabyEntitySpawnEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.tslat.aoa3.common.registration.custom.AoASkills;
import net.tslat.aoa3.player.ServerPlayerDataManager;
import net.tslat.aoa3.util.BlockUtil;
import net.tslat.aoa3.util.PlayerUtil;

public class FarmingSkill extends AoASkill.Instance {
	private static final ListenerType[] LISTENERS = new ListenerType[] {ListenerType.BLOCK_BREAK, ListenerType.ANIMAL_BREED};

	public FarmingSkill(ServerPlayerDataManager plData, JsonObject jsonData) {
		super(AoASkills.FARMING.get(), plData, jsonData);
	}

	public FarmingSkill(CompoundTag nbtData) {
		super(AoASkills.FARMING.get(), nbtData);
	}

	@Override
	public ListenerType[] getListenerTypes() {
		return LISTENERS;
	}

	@Override
	public void handleBlockBreak(BlockEvent.BreakEvent ev) {
		if (canGainXp(true) && BlockUtil.canPlayerHarvest(ev.getState(), ev.getPlayer(), ev.getLevel(), ev.getPos())) {
			int xpTime = switch (ev.getState().getBlock()) {
				case CropBlock crop -> crop.isMaxAge(ev.getState()) ? 7 * crop.getMaxAge() : 0;
				case NetherWartBlock netherWart -> ev.getState().getValue(NetherWartBlock.AGE) == 3 ? 21 : 0;
				default -> ev.getState().is(BlockTags.CROPS) ? 12 : 0;
			};

			if (xpTime > 0)
				PlayerUtil.giveTimeBasedXpToPlayer((ServerPlayer)ev.getPlayer(), type(), xpTime,  false);
		}
	}

	@Override
	public void handleAnimalBreed(BabyEntitySpawnEvent ev) {
		if (!canGainXp(true))
			return;

		PlayerUtil.giveTimeBasedXpToPlayer((ServerPlayer)getPlayer(), type(), 600, false);
	}
}
