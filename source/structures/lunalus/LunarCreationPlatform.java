package net.nevermine.structures.lunalus;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.nevermine.izer.Blockizer;

import java.util.Random;

public class LunarCreationPlatform extends WorldGenerator {
	public boolean generate(final World world, final Random rand, final int i, final int j, final int k) {
		world.setBlock(i + 0, j + 2, k + 1, Blockizer.LunarBricks);
		world.setBlock(i + 0, j + 2, k + 7, Blockizer.LunarBricks);
		world.setBlock(i + 1, j + 0, k + 1, Blockizer.LunarBricks);
		world.setBlock(i + 1, j + 0, k + 2, Blockizer.LunarBricks);
		world.setBlock(i + 1, j + 0, k + 3, Blockizer.LunarBricks);
		world.setBlock(i + 1, j + 0, k + 4, Blockizer.LunarBricks);
		world.setBlock(i + 1, j + 0, k + 5, Blockizer.LunarBricks);
		world.setBlock(i + 1, j + 0, k + 6, Blockizer.LunarBricks);
		world.setBlock(i + 1, j + 0, k + 7, Blockizer.LunarBricks);
		world.setBlock(i + 1, j + 1, k + 1, Blockizer.LunarBricks);
		world.setBlock(i + 1, j + 1, k + 7, Blockizer.LunarBricks);
		world.setBlock(i + 1, j + 2, k + 0, Blockizer.LunarBricks);
		world.setBlock(i + 1, j + 2, k + 1, Blockizer.LunarPillar);
		world.setBlock(i + 1, j + 2, k + 7, Blockizer.LunarPillar);
		world.setBlock(i + 1, j + 2, k + 8, Blockizer.LunarBricks);
		world.setBlock(i + 1, j + 3, k + 1, Blockizer.LunarPillar);
		world.setBlock(i + 1, j + 3, k + 7, Blockizer.LunarPillar);
		world.setBlock(i + 1, j + 4, k + 1, Blockizer.LunarPillar);
		world.setBlock(i + 1, j + 4, k + 7, Blockizer.LunarPillar);
		world.setBlock(i + 2, j + 0, k + 1, Blockizer.LunarBricks);
		world.setBlock(i + 2, j + 0, k + 2, Blockizer.LunarPad);
		world.setBlock(i + 2, j + 0, k + 3, Blockizer.LunarBricks);
		world.setBlock(i + 2, j + 0, k + 4, Blockizer.LunarPad);
		world.setBlock(i + 2, j + 0, k + 5, Blockizer.LunarBricks);
		world.setBlock(i + 2, j + 0, k + 6, Blockizer.LunarPad);
		world.setBlock(i + 2, j + 0, k + 7, Blockizer.LunarBricks);
		world.setBlock(i + 3, j + 0, k + 1, Blockizer.LunarBricks);
		world.setBlock(i + 3, j + 0, k + 2, Blockizer.LunarBricks);
		world.setBlock(i + 3, j + 0, k + 3, Blockizer.LunarBricks);
		world.setBlock(i + 3, j + 0, k + 4, Blockizer.LunarBricks);
		world.setBlock(i + 3, j + 0, k + 5, Blockizer.LunarBricks);
		world.setBlock(i + 3, j + 0, k + 6, Blockizer.LunarBricks);
		world.setBlock(i + 3, j + 0, k + 7, Blockizer.LunarBricks);
		world.setBlock(i + 4, j + 0, k + 1, Blockizer.LunarBricks);
		world.setBlock(i + 4, j + 0, k + 2, Blockizer.LunarPad);
		world.setBlock(i + 4, j + 0, k + 3, Blockizer.LunarBricks);
		world.setBlock(i + 4, j + 0, k + 4, Blockizer.LunarBricks);
		world.setBlock(i + 4, j + 0, k + 5, Blockizer.LunarBricks);
		world.setBlock(i + 4, j + 0, k + 6, Blockizer.LunarPad);
		world.setBlock(i + 4, j + 0, k + 7, Blockizer.LunarBricks);
		world.setBlock(i + 4, j + 1, k + 4, Blockizer.LunarCreationTable);
		world.setBlock(i + 5, j + 0, k + 1, Blockizer.LunarBricks);
		world.setBlock(i + 5, j + 0, k + 2, Blockizer.LunarBricks);
		world.setBlock(i + 5, j + 0, k + 3, Blockizer.LunarBricks);
		world.setBlock(i + 5, j + 0, k + 4, Blockizer.LunarBricks);
		world.setBlock(i + 5, j + 0, k + 5, Blockizer.LunarBricks);
		world.setBlock(i + 5, j + 0, k + 6, Blockizer.LunarBricks);
		world.setBlock(i + 5, j + 0, k + 7, Blockizer.LunarBricks);
		world.setBlock(i + 6, j + 0, k + 1, Blockizer.LunarBricks);
		world.setBlock(i + 6, j + 0, k + 2, Blockizer.LunarPad);
		world.setBlock(i + 6, j + 0, k + 3, Blockizer.LunarBricks);
		world.setBlock(i + 6, j + 0, k + 4, Blockizer.LunarPad);
		world.setBlock(i + 6, j + 0, k + 5, Blockizer.LunarBricks);
		world.setBlock(i + 6, j + 0, k + 6, Blockizer.LunarPad);
		world.setBlock(i + 6, j + 0, k + 7, Blockizer.LunarBricks);
		world.setBlock(i + 7, j + 0, k + 1, Blockizer.LunarBricks);
		world.setBlock(i + 7, j + 0, k + 2, Blockizer.LunarBricks);
		world.setBlock(i + 7, j + 0, k + 3, Blockizer.LunarBricks);
		world.setBlock(i + 7, j + 0, k + 4, Blockizer.LunarBricks);
		world.setBlock(i + 7, j + 0, k + 5, Blockizer.LunarBricks);
		world.setBlock(i + 7, j + 0, k + 6, Blockizer.LunarBricks);
		world.setBlock(i + 7, j + 0, k + 7, Blockizer.LunarBricks);
		world.setBlock(i + 7, j + 1, k + 1, Blockizer.LunarBricks);
		world.setBlock(i + 7, j + 1, k + 7, Blockizer.LunarBricks);
		world.setBlock(i + 7, j + 2, k + 0, Blockizer.LunarBricks);
		world.setBlock(i + 7, j + 2, k + 1, Blockizer.LunarPillar);
		world.setBlock(i + 7, j + 2, k + 7, Blockizer.LunarPillar);
		world.setBlock(i + 7, j + 2, k + 8, Blockizer.LunarBricks);
		world.setBlock(i + 7, j + 3, k + 1, Blockizer.LunarPillar);
		world.setBlock(i + 7, j + 3, k + 7, Blockizer.LunarPillar);
		world.setBlock(i + 7, j + 4, k + 1, Blockizer.LunarPillar);
		world.setBlock(i + 7, j + 4, k + 7, Blockizer.LunarPillar);
		world.setBlock(i + 8, j + 2, k + 1, Blockizer.LunarBricks);
		world.setBlock(i + 8, j + 2, k + 7, Blockizer.LunarBricks);
		return true;
	}
}