package net.tslat.aoa3.worldgen.feature.placement;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.SimplePlacement;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AllZPlacement extends SimplePlacement<NoPlacementConfig> {
	public AllZPlacement(Codec<NoPlacementConfig> codec) {
		super(codec);
	}

	@Override
	protected Stream<BlockPos> place(Random random, NoPlacementConfig config, BlockPos pos) {
		return IntStream.range(0, 16).mapToObj(z -> new BlockPos(pos.getX(), pos.getY(), z + pos.getZ()));
	}
}
