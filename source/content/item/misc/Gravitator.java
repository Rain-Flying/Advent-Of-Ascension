package net.tslat.aoa3.content.item.misc;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.item.AoAItems;
import net.tslat.aoa3.common.registration.worldgen.AoADimensions;
import net.tslat.aoa3.util.ItemUtil;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.aoa3.util.WorldUtil;
import net.tslat.smartbrainlib.util.RandomUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Gravitator extends Item {
	public Gravitator() {
		super(new Item.Properties().durability(1500));
	}

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int itemSlot, boolean isSelected) {
		if (entity instanceof Player pl && (isSelected || pl.getOffhandItem() == stack)) {
			if (entity.getDeltaMovement().y() < -0.079) {
				entity.setDeltaMovement(entity.getDeltaMovement().multiply(1, 0.8f, 1));

				if (!level.isClientSide) {
					if (RandomUtil.oneInNChance(15) && !pl.getAbilities().instabuild)
						ItemUtil.damageItem(stack, (LivingEntity)entity, 1, EquipmentSlot.MAINHAND);

					entity.fallDistance *= 0.8f;
				}
			}

			if (!level.isClientSide) {
				if (WorldUtil.isWorld(level, AoADimensions.HAVEN) && !entity.onGround() && level.getGameTime() % 5 == 0) {
					if (pl.isCreative())
						return;

					BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(entity.blockPosition().getX(), entity.blockPosition().getY(), entity.blockPosition().getZ());

					for (ItemStack invStack : pl.getInventory().items) {
						if (invStack.getItem() == AoAItems.BLANK_REALMSTONE.get()) {
							for (int i = 0; i < entity.getY(); i++) {
								if (!level.isEmptyBlock(pos.set(pos.getX(), pos.getY() - i, pos.getZ())))
									return;
							}

							invStack.shrink(1);
							ItemUtil.givePlayerItemOrDrop(pl, new ItemStack(AoAItems.LUNALUS_REALMSTONE.get()));

							break;
						}
					}
				}
			}
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.NEUTRAL, 1));
	}
}
