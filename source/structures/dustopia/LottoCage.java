package net.nevermine.structures.dustopia;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.nevermine.izer.Blockizer;
import net.nevermine.npc.entity.lottoman.EntityLottomanDustopia;

import java.util.Random;

public class LottoCage extends WorldGenerator {
	public boolean generate(final World world, final Random rand, final int i, final int j, final int k) {
		if (world.getBlock(i + 2, j - 1, k + 2) != Blockizer.GrassDustopia && world.getBlock(i + 2, j - 1, k + 2) != Blockizer.DirtDustopia) {
			return false;
		}
		world.setBlock(i + 0, j + 4, k + 0, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 0, j + 4, k + 1, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 0, j + 4, k + 2, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 0, j + 4, k + 3, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 0, j + 4, k + 4, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 0, j + 5, k + 0, Blockizer.DawnwoodBars);
		world.setBlock(i + 0, j + 5, k + 1, Blockizer.DawnwoodBars);
		world.setBlock(i + 0, j + 5, k + 2, Blockizer.DawnwoodBars);
		world.setBlock(i + 0, j + 5, k + 3, Blockizer.DawnwoodBars);
		world.setBlock(i + 0, j + 5, k + 4, Blockizer.DawnwoodBars);
		world.setBlock(i + 0, j + 6, k + 0, Blockizer.DawnwoodBars);
		world.setBlock(i + 0, j + 6, k + 1, Blockizer.DawnwoodBars);
		world.setBlock(i + 0, j + 6, k + 2, Blockizer.DawnwoodBars);
		world.setBlock(i + 0, j + 6, k + 3, Blockizer.DawnwoodBars);
		world.setBlock(i + 0, j + 6, k + 4, Blockizer.DawnwoodBars);
		world.setBlock(i + 0, j + 7, k + 0, Blockizer.DawnwoodBars);
		world.setBlock(i + 0, j + 7, k + 1, Blockizer.DawnwoodBars);
		world.setBlock(i + 0, j + 7, k + 2, Blockizer.DawnwoodBars);
		world.setBlock(i + 0, j + 7, k + 3, Blockizer.DawnwoodBars);
		world.setBlock(i + 0, j + 7, k + 4, Blockizer.DawnwoodBars);
		world.setBlock(i + 0, j + 8, k + 0, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 0, j + 8, k + 1, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 0, j + 8, k + 2, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 0, j + 8, k + 3, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 0, j + 8, k + 4, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 1, j + 4, k + 0, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 1, j + 4, k + 1, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 1, j + 4, k + 2, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 1, j + 4, k + 3, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 1, j + 4, k + 4, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 1, j + 5, k + 0, Blockizer.DawnwoodBars);
		world.setBlock(i + 1, j + 5, k + 4, Blockizer.DawnwoodBars);
		world.setBlock(i + 1, j + 6, k + 0, Blockizer.DawnwoodBars);
		world.setBlock(i + 1, j + 6, k + 4, Blockizer.DawnwoodBars);
		world.setBlock(i + 1, j + 7, k + 0, Blockizer.DawnwoodBars);
		world.setBlock(i + 1, j + 7, k + 4, Blockizer.DawnwoodBars);
		world.setBlock(i + 1, j + 8, k + 0, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 1, j + 8, k + 1, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 1, j + 8, k + 2, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 1, j + 8, k + 3, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 1, j + 8, k + 4, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 2, j + 0, k + 2, Blockizer.StoneDustopia);
		world.setBlock(i + 2, j + 1, k + 2, Blockizer.StoneDustopia);
		world.setBlock(i + 2, j + 2, k + 2, Blockizer.StoneDustopia);
		world.setBlock(i + 2, j + 3, k + 2, Blockizer.StoneDustopia);
		world.setBlock(i + 2, j + 4, k + 0, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 2, j + 4, k + 1, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 2, j + 4, k + 2, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 2, j + 4, k + 3, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 2, j + 4, k + 4, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 2, j + 5, k + 0, Blockizer.DawnwoodBars);
		world.setBlock(i + 2, j + 5, k + 4, Blockizer.DawnwoodBars);
		world.setBlock(i + 2, j + 6, k + 0, Blockizer.DawnwoodBars);
		if (!world.isRemote) {
			final EntityLottomanDustopia var2 = new EntityLottomanDustopia(world);
			var2.setLocationAndAngles((double)(i + 2), (double)(j + 6), (double)(k + 2), rand.nextFloat() * 360.0f, 0.0f);
			world.spawnEntityInWorld(var2);
		}
		world.setBlock(i + 2, j + 6, k + 4, Blockizer.DawnwoodBars);
		world.setBlock(i + 2, j + 7, k + 0, Blockizer.DawnwoodBars);
		world.setBlock(i + 2, j + 7, k + 4, Blockizer.DawnwoodBars);
		world.setBlock(i + 2, j + 8, k + 0, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 2, j + 8, k + 1, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 2, j + 8, k + 2, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 2, j + 8, k + 3, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 2, j + 8, k + 4, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 3, j + 4, k + 0, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 3, j + 4, k + 1, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 3, j + 4, k + 2, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 3, j + 4, k + 3, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 3, j + 4, k + 4, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 3, j + 5, k + 0, Blockizer.DawnwoodBars);
		world.setBlock(i + 3, j + 5, k + 4, Blockizer.DawnwoodBars);
		world.setBlock(i + 3, j + 6, k + 0, Blockizer.DawnwoodBars);
		world.setBlock(i + 3, j + 6, k + 4, Blockizer.DawnwoodBars);
		world.setBlock(i + 3, j + 7, k + 0, Blockizer.DawnwoodBars);
		world.setBlock(i + 3, j + 7, k + 4, Blockizer.DawnwoodBars);
		world.setBlock(i + 3, j + 8, k + 0, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 3, j + 8, k + 1, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 3, j + 8, k + 2, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 3, j + 8, k + 3, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 3, j + 8, k + 4, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 4, j + 4, k + 0, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 4, j + 4, k + 1, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 4, j + 4, k + 2, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 4, j + 4, k + 3, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 4, j + 4, k + 4, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 4, j + 5, k + 0, Blockizer.DawnwoodBars);
		world.setBlock(i + 4, j + 5, k + 1, Blockizer.DawnwoodBars);
		world.setBlock(i + 4, j + 5, k + 2, Blockizer.DawnwoodBars);
		world.setBlock(i + 4, j + 5, k + 3, Blockizer.DawnwoodBars);
		world.setBlock(i + 4, j + 5, k + 4, Blockizer.DawnwoodBars);
		world.setBlock(i + 4, j + 6, k + 0, Blockizer.DawnwoodBars);
		world.setBlock(i + 4, j + 6, k + 1, Blockizer.DawnwoodBars);
		world.setBlock(i + 4, j + 6, k + 2, Blockizer.DawnwoodBars);
		world.setBlock(i + 4, j + 6, k + 3, Blockizer.DawnwoodBars);
		world.setBlock(i + 4, j + 6, k + 4, Blockizer.DawnwoodBars);
		world.setBlock(i + 4, j + 7, k + 0, Blockizer.DawnwoodBars);
		world.setBlock(i + 4, j + 7, k + 1, Blockizer.DawnwoodBars);
		world.setBlock(i + 4, j + 7, k + 2, Blockizer.DawnwoodBars);
		world.setBlock(i + 4, j + 7, k + 3, Blockizer.DawnwoodBars);
		world.setBlock(i + 4, j + 7, k + 4, Blockizer.DawnwoodBars);
		world.setBlock(i + 4, j + 8, k + 0, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 4, j + 8, k + 1, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 4, j + 8, k + 2, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 4, j + 8, k + 3, Blockizer.DawnwoodPlanks);
		world.setBlock(i + 4, j + 8, k + 4, Blockizer.DawnwoodPlanks);
		return true;
	}
}