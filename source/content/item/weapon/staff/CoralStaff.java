package net.tslat.aoa3.content.item.weapon.staff;

import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.common.registration.item.AoAItems;
import net.tslat.aoa3.scheduling.async.CoralStaffTask;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.aoa3.util.WorldUtil;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class CoralStaff extends BaseStaff<List<BlockPos>> {
	public CoralStaff(Item.Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public SoundEvent getCastingSound() {
		return AoASounds.ITEM_CORAL_STAFF_CAST.get();
	}

	public static Object2IntMap<Item> getDefaultRunes() {
		return Util.make(new Object2IntArrayMap<>(), runes -> {
			runes.put(AoAItems.WATER_RUNE.get(), 2);
			runes.put(AoAItems.KINETIC_RUNE.get(), 8);
		});
	}

	@Override
    public Optional<List<BlockPos>> checkPreconditions(LivingEntity caster, ItemStack staff) {
		final List<BlockPos> coralPositions = new ObjectArrayList<>();
		final BlockPos pos = caster.blockPosition();
		BlockPos.MutableBlockPos checkPos = new BlockPos.MutableBlockPos();

		for (int x = -2; x <= 1; x++) {
			for (int z = -2; z <= 1; z++) {
				checkPos.set(pos.getX() + x, pos.getY() - 2, pos.getZ() + z);

				if (safeBlockPos(caster, checkPos, staff))
					coralPositions.add(checkPos.immutable());

				if (safeBlockPos(caster, checkPos.move(Direction.UP, 4), staff))
					coralPositions.add(checkPos.immutable());
			}

			for (int y = -2; y <= 2; y++) {
				checkPos.set(pos.getX() + x, pos.getY() + y, pos.getZ() - 2);

				if (safeBlockPos(caster, checkPos, staff))
					coralPositions.add(checkPos.immutable());

				if (safeBlockPos(caster, checkPos.move(Direction.SOUTH, 4), staff))
					coralPositions.add(checkPos.immutable());
			}
		}

		for (int z = -2; z <= 2; z++) {
			for (int y = -2; y <= 2; y++) {
				checkPos.set(pos.getX() - 2, pos.getY() + y, pos.getZ() + z);

				if (safeBlockPos(caster, checkPos, staff))
					coralPositions.add(checkPos.immutable());

				if (safeBlockPos(caster, checkPos.move(Direction.EAST, 4), staff))
					coralPositions.add(checkPos.immutable());
			}
		}

		return Optional.ofNullable(coralPositions.isEmpty() ? null : coralPositions);
	}

	@Override
	public void cast(Level world, ItemStack staff, LivingEntity caster, List<BlockPos> args) {
		if (!world.isClientSide && caster instanceof Player) {
			for (BlockPos pos : args) {
				world.setBlock(pos, Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
			}

			world.playSound(null, caster.getX(), caster.getY(), caster.getZ(), AoASounds.ITEM_REEF_STAFF_CAST.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
			new CoralStaffTask(world, args).schedule(600);
		}
	}

	private boolean safeBlockPos(LivingEntity caster, BlockPos pos, ItemStack staff) {
		return caster.level().getBlockState(pos).getBlock() == Blocks.AIR && WorldUtil.canPlaceBlock(caster.level(), pos, caster, staff);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.BENEFICIAL, 1));
		super.appendHoverText(stack, context, tooltip, flag);
	}
}
