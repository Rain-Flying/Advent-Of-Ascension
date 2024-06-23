package net.tslat.aoa3.content.item.weapon.staff;

import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BonemealableBlock;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.common.registration.item.AoAItems;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.aoa3.util.WorldUtil;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class NatureStaff extends BaseStaff<List<BlockPos>> {
	public NatureStaff(Item.Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public SoundEvent getCastingSound() {
		return AoASounds.ITEM_NATURE_STAFF_CAST.get();
	}

	@Override
	public Optional<List<BlockPos>> checkPreconditions(LivingEntity caster, ItemStack staff) {
		List<BlockPos> blocks = WorldUtil.getBlocksWithinAABB(caster.level(), caster.getBoundingBox().inflate(10), (state, pos) -> {
			if (!(state.getBlock() instanceof BonemealableBlock bonemealable))
				return false;

			if (!bonemealable.isValidBonemealTarget(caster.level(), pos.immutable(), state))
				return false;

			return WorldUtil.canModifyBlock(caster.level(), pos, caster, staff);
		});

		return Optional.ofNullable(blocks.isEmpty() ? null : blocks);
	}

	public static Object2IntMap<Item> getDefaultRunes() {
		return Util.make(new Object2IntArrayMap<>(), runes -> {
			runes.put(AoAItems.LIFE_RUNE.get(), 4);
			runes.put(AoAItems.ENERGY_RUNE.get(), 2);
		});
	}

	@Override
	public void cast(Level world, ItemStack staff, LivingEntity caster, List<BlockPos> args) {
		for (BlockPos pos : args) {
			BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), caster.level(), pos);
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.BENEFICIAL, 1));
		super.appendHoverText(stack, context, tooltip, flag);
	}
}
