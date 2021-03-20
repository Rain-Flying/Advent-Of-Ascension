package net.tslat.aoa3.worldgen.feature.features.trees;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.tslat.aoa3.common.registration.AoABlocks;

import java.util.Random;
import java.util.function.Supplier;

public abstract class CelevusTreeFeature extends AoAVariableLeafTreeFeature {
	public CelevusTreeFeature(Codec<BlockStateFeatureConfig> codec, Supplier<SaplingBlock> saplingBlock) {
		super(codec, saplingBlock);
	}

	@Override
	protected boolean generateTree(ISeedReader reader, Random rand, BlockPos pos, BlockState leafBlock, boolean isWorldGen) {
		BlockPos multiSaplingPos = findMultiSaplingPosition(reader, rand, pos, 2, isWorldGen);
		boolean success;

		if (multiSaplingPos == null || (sapling == null && rand.nextInt(6) != 0)) {
			success = genSmallTree(reader, rand, pos, leafBlock, isWorldGen);
		}
		else {
			success = genBigTree(reader, rand, multiSaplingPos, leafBlock, isWorldGen);
		}

		return success;
	}

	public boolean genBigTree(ISeedReader reader, Random rand, BlockPos pos, BlockState leafBlock, boolean isWorldGen) {
		int trunkHeight = 15 + rand.nextInt(10);

		if (!checkSafeHeight(reader, pos, trunkHeight + 5, 2, isWorldGen))
			return false;

		if (!checkAndPrepSoil(reader, pos, 2, isWorldGen))
			return false;

		BlockState log = AoABlocks.CELEVE_STEM.get().defaultBlockState();
		boolean clockwise = rand.nextBoolean();
		boolean thickTwist = rand.nextBoolean();
		int twistOffset = 1 + rand.nextInt(3);

		for (int i = 0; i < trunkHeight; i++) {
			for (int x = 0; x <= 1; x++) {
				for (int z = 0; z <= 1; z++) {
					placeBlock(reader, pos.offset(x, i, z), log);
				}
			}

			switch ((i + twistOffset) % 4) {
				case 0:
					placeBlock(reader, pos.offset(0, i, 0), leafBlock, true);

					if (thickTwist)
						placeBlock(reader, pos.offset(0, i - 1, 0), leafBlock, true);

					break;
				case 1:
					if (clockwise) {
						placeBlock(reader, pos.offset(0, i, 1), leafBlock, true);

						if (thickTwist && i > 0)
							placeBlock(reader, pos.offset(0, i - 1, 1), leafBlock, true);
					}
					else {
						placeBlock(reader, pos.offset(1, i, 0), leafBlock, true);

						if (thickTwist && i > 0)
							placeBlock(reader, pos.offset(1, i - 1, 0), leafBlock, true);
					}
					break;
				case 2:
					placeBlock(reader, pos.offset(1, i, 1), leafBlock, true);

					if (thickTwist && i > 0)
						placeBlock(reader, pos.offset(1, i - 1, 1), leafBlock, true);

					break;
				case 3:
					if (clockwise) {
						placeBlock(reader, pos.offset(1, i, 0), leafBlock, true);

						if (thickTwist && i > 0)
							placeBlock(reader, pos.offset(1, i - 1, 0), leafBlock, true);
					}
					else {
						placeBlock(reader, pos.offset(0, i, 1), leafBlock, true);

						if (thickTwist && i > 0)
							placeBlock(reader, pos.offset(0, i - 1, 1), leafBlock, true);
					}
					break;
			}
		}

		pos = pos.above(trunkHeight);

		for (int x = -1; x <= 2; x++) {
			for (int z = -1; z <= 2; z++) {
				placeBlock(reader, pos.offset(x, 0, z), leafBlock);
				placeBlock(reader, pos.offset(x, 5, z), leafBlock);
			}
		}

		for (int x = -2; x <= 3; x++) {
			for (int y = 1; y <= 4; y++) {
				for (int z = -2; z <= 3; z++) {
					placeBlock(reader, pos.offset(x, y, z), leafBlock);
				}
			}
		}

		return true;
	}

	public boolean genSmallTree(ISeedReader reader, Random rand, BlockPos pos, BlockState leafBlock, boolean isWorldGen) {
		int trunkHeight = 8 + rand.nextInt(7);

		if (!checkSafeHeight(reader, pos, trunkHeight + 5, 1, isWorldGen))
			return false;

		if (!checkAndPrepSoil(reader, pos, 1, isWorldGen))
			return false;

		BlockPos.Mutable movablePos = new BlockPos.Mutable().set(pos.below());
		BlockState log = AoABlocks.CELEVE_STEM.get().defaultBlockState();
		BlockState whiteLeaves = AoABlocks.WHITE_CELEVUS_LEAVES.get().defaultBlockState();
		int leafRingGap = -1;

		for (int i = 0; i < trunkHeight; i++) {
			placeBlock(reader, movablePos.move(Direction.UP), log);

			if (leafRingGap > 1 && i < trunkHeight - 1 && rand.nextBoolean()) {
				leafRingGap = 0;

				for (int x = -1; x <= 1; x++) {
					for (int z = -1; z <= 1; z++) {
						placeBlock(reader, movablePos.offset(x, 0, z), leafBlock);
					}
				}
			}

			leafRingGap++;
		}

		for (int x = -1; x <= 1; x++) {
			for (int z = -1; z <= 1; z++) {
				placeBlock(reader, movablePos.offset(x, 0, z), whiteLeaves);
				placeBlock(reader, movablePos.offset(x, 5, z), leafBlock);
			}
		}

		for (int x = -2; x <= 2; x++) {
			for (int z = -2; z <= 2; z++) {
				placeBlock(reader, movablePos.offset(x, 1, z), leafBlock);
				placeBlock(reader, movablePos.offset(x, 2, z), whiteLeaves);
				placeBlock(reader, movablePos.offset(x, 3, z), leafBlock);
				placeBlock(reader, movablePos.offset(x, 4, z), whiteLeaves);
			}
		}

		return true;
	}
}
