package net.tslat.aoa3.content.item.food;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;
import net.tslat.aoa3.advent.AdventOfAscension;
import net.tslat.aoa3.common.registration.item.AoAFood;
import net.tslat.aoa3.util.AdvancementUtil;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.aoa3.util.PlayerUtil;
import net.tslat.aoa3.util.WorldUtil;

import java.util.List;

public class Rosidons extends Item {
	public Rosidons() {
		super(new Item.Properties().food(AoAFood.ROSIDONS));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
		if (!world.isClientSide) {
			int minY = Math.max(world.getMinBuildHeight(), (int)Math.floor(entity.getY()));
			int calculatedY = WorldUtil.getHighestSafeLocation(world, (int)Math.floor(entity.getX()), (int)Math.floor(entity.getZ()), false, minY);

			if (calculatedY <= minY) {
				if (entity instanceof ServerPlayer pl)
					PlayerUtil.notifyPlayer(pl, Component.translatable(LocaleUtil.createFeedbackLocaleKey("item.rosidons.noHeightFail")));

				return super.finishUsingItem(stack, world, entity);
			}

			if (NeoForge.EVENT_BUS.post(new EntityTeleportEvent(entity, entity.getX(), calculatedY, entity.getZ())).isCanceled())
				return stack;

			if (calculatedY - entity.getY() >= 350 && entity instanceof ServerPlayer pl)
				AdvancementUtil.grantCriterion(pl, AdventOfAscension.id("completionist/super_escape_rope"), "350_blocks");

			world.gameEvent(GameEvent.TELEPORT, entity.position(), GameEvent.Context.of(entity));
			world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS, 1, 1);
			entity.teleportTo(entity.getX(), calculatedY + 1.5d, entity.getZ());
		}

		return super.finishUsingItem(stack, world, entity);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.NEUTRAL, 1));
	}
}
