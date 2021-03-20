package net.tslat.aoa3.worldgen.feature.placement;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.placement.SimplePlacement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class YFillPlacement extends SimplePlacement<TopSolidRangeConfig> {
	public YFillPlacement(Codec<TopSolidRangeConfig> codec) {
		super(codec);
	}

	@Override
	protected Stream<BlockPos> place(Random random, TopSolidRangeConfig config, BlockPos pos) {
		return IntStream.range(config.bottomOffset, config.maximum + 1).mapToObj(y -> new BlockPos(pos.getX(), y, pos.getZ()));
	}
}
