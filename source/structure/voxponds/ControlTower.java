package net.tslat.aoa3.structure.voxponds;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tslat.aoa3.common.registration.BlockRegister;
import net.tslat.aoa3.structure.AoAStructure;

import java.util.Random;

public class ControlTower extends AoAStructure { //StructureSize: 11x55x11
	private static final IBlockState degradedSteel = BlockRegister.degradedSteel.getDefaultState();
	private static final IBlockState steelLight = BlockRegister.lightSteel.getDefaultState();

	public ControlTower() {
		super("ControlTower");
	}

	@Override
	protected boolean replacesBlocks() {
		return true;
	}

	@Override
	protected void build(World world, Random rand, BlockPos basePos) {
		addBlock(world, basePos, 2, 0, 4, degradedSteel);
		addBlock(world, basePos, 2, 0, 6, degradedSteel);
		addBlock(world, basePos, 4, 0, 2, degradedSteel);
		addBlock(world, basePos, 4, 0, 4, degradedSteel);
		addBlock(world, basePos, 4, 0, 6, degradedSteel);
		addBlock(world, basePos, 4, 0, 8, degradedSteel);
		addBlock(world, basePos, 6, 0, 2, degradedSteel);
		addBlock(world, basePos, 6, 0, 4, degradedSteel);
		addBlock(world, basePos, 6, 0, 6, degradedSteel);
		addBlock(world, basePos, 6, 0, 8, degradedSteel);
		addBlock(world, basePos, 8, 0, 4, degradedSteel);
		addBlock(world, basePos, 8, 0, 6, degradedSteel);
		addBlock(world, basePos, 2, 1, 4, degradedSteel);
		addBlock(world, basePos, 2, 1, 6, degradedSteel);
		addBlock(world, basePos, 4, 1, 2, degradedSteel);
		addBlock(world, basePos, 4, 1, 4, degradedSteel);
		addBlock(world, basePos, 4, 1, 6, degradedSteel);
		addBlock(world, basePos, 4, 1, 8, degradedSteel);
		addBlock(world, basePos, 6, 1, 2, degradedSteel);
		addBlock(world, basePos, 6, 1, 4, degradedSteel);
		addBlock(world, basePos, 6, 1, 6, degradedSteel);
		addBlock(world, basePos, 6, 1, 8, degradedSteel);
		addBlock(world, basePos, 8, 1, 4, degradedSteel);
		addBlock(world, basePos, 8, 1, 6, degradedSteel);
		addBlock(world, basePos, 2, 2, 4, degradedSteel);
		addBlock(world, basePos, 2, 2, 6, degradedSteel);
		addBlock(world, basePos, 4, 2, 2, degradedSteel);
		addBlock(world, basePos, 4, 2, 4, degradedSteel);
		addBlock(world, basePos, 4, 2, 6, degradedSteel);
		addBlock(world, basePos, 4, 2, 8, degradedSteel);
		addBlock(world, basePos, 6, 2, 2, degradedSteel);
		addBlock(world, basePos, 6, 2, 4, degradedSteel);
		addBlock(world, basePos, 6, 2, 6, degradedSteel);
		addBlock(world, basePos, 6, 2, 8, degradedSteel);
		addBlock(world, basePos, 8, 2, 4, degradedSteel);
		addBlock(world, basePos, 8, 2, 6, degradedSteel);
		addBlock(world, basePos, 2, 3, 4, degradedSteel);
		addBlock(world, basePos, 2, 3, 6, degradedSteel);
		addBlock(world, basePos, 4, 3, 2, degradedSteel);
		addBlock(world, basePos, 4, 3, 4, degradedSteel);
		addBlock(world, basePos, 4, 3, 6, degradedSteel);
		addBlock(world, basePos, 4, 3, 8, degradedSteel);
		addBlock(world, basePos, 6, 3, 2, degradedSteel);
		addBlock(world, basePos, 6, 3, 4, degradedSteel);
		addBlock(world, basePos, 6, 3, 6, degradedSteel);
		addBlock(world, basePos, 6, 3, 8, degradedSteel);
		addBlock(world, basePos, 8, 3, 4, degradedSteel);
		addBlock(world, basePos, 8, 3, 6, degradedSteel);
		addBlock(world, basePos, 2, 4, 4, degradedSteel);
		addBlock(world, basePos, 2, 4, 6, degradedSteel);
		addBlock(world, basePos, 4, 4, 2, degradedSteel);
		addBlock(world, basePos, 4, 4, 4, degradedSteel);
		addBlock(world, basePos, 4, 4, 6, degradedSteel);
		addBlock(world, basePos, 4, 4, 8, degradedSteel);
		addBlock(world, basePos, 6, 4, 2, degradedSteel);
		addBlock(world, basePos, 6, 4, 4, degradedSteel);
		addBlock(world, basePos, 6, 4, 6, degradedSteel);
		addBlock(world, basePos, 6, 4, 8, degradedSteel);
		addBlock(world, basePos, 8, 4, 4, degradedSteel);
		addBlock(world, basePos, 8, 4, 6, degradedSteel);
		addBlock(world, basePos, 2, 5, 4, degradedSteel);
		addBlock(world, basePos, 2, 5, 6, degradedSteel);
		addBlock(world, basePos, 3, 5, 4, degradedSteel);
		addBlock(world, basePos, 3, 5, 6, degradedSteel);
		addBlock(world, basePos, 4, 5, 2, degradedSteel);
		addBlock(world, basePos, 4, 5, 3, degradedSteel);
		addBlock(world, basePos, 4, 5, 4, degradedSteel);
		addBlock(world, basePos, 4, 5, 6, degradedSteel);
		addBlock(world, basePos, 4, 5, 7, degradedSteel);
		addBlock(world, basePos, 4, 5, 8, degradedSteel);
		addBlock(world, basePos, 6, 5, 2, degradedSteel);
		addBlock(world, basePos, 6, 5, 3, degradedSteel);
		addBlock(world, basePos, 6, 5, 4, degradedSteel);
		addBlock(world, basePos, 6, 5, 6, degradedSteel);
		addBlock(world, basePos, 6, 5, 7, degradedSteel);
		addBlock(world, basePos, 6, 5, 8, degradedSteel);
		addBlock(world, basePos, 7, 5, 4, degradedSteel);
		addBlock(world, basePos, 7, 5, 6, degradedSteel);
		addBlock(world, basePos, 8, 5, 4, degradedSteel);
		addBlock(world, basePos, 8, 5, 6, degradedSteel);
		addBlock(world, basePos, 4, 6, 4, degradedSteel);
		addBlock(world, basePos, 4, 6, 5, degradedSteel);
		addBlock(world, basePos, 4, 6, 6, degradedSteel);
		addBlock(world, basePos, 5, 6, 4, degradedSteel);
		addBlock(world, basePos, 5, 6, 6, degradedSteel);
		addBlock(world, basePos, 6, 6, 4, degradedSteel);
		addBlock(world, basePos, 6, 6, 5, degradedSteel);
		addBlock(world, basePos, 6, 6, 6, degradedSteel);
		addBlock(world, basePos, 4, 7, 4, degradedSteel);
		addBlock(world, basePos, 4, 7, 6, degradedSteel);
		addBlock(world, basePos, 6, 7, 4, degradedSteel);
		addBlock(world, basePos, 6, 7, 6, degradedSteel);
		addBlock(world, basePos, 4, 8, 4, degradedSteel);
		addBlock(world, basePos, 4, 8, 6, degradedSteel);
		addBlock(world, basePos, 6, 8, 4, degradedSteel);
		addBlock(world, basePos, 6, 8, 6, degradedSteel);
		addBlock(world, basePos, 4, 9, 4, degradedSteel);
		addBlock(world, basePos, 4, 9, 5, degradedSteel);
		addBlock(world, basePos, 4, 9, 6, degradedSteel);
		addBlock(world, basePos, 5, 9, 4, degradedSteel);
		addBlock(world, basePos, 5, 9, 6, degradedSteel);
		addBlock(world, basePos, 6, 9, 4, degradedSteel);
		addBlock(world, basePos, 6, 9, 5, degradedSteel);
		addBlock(world, basePos, 6, 9, 6, degradedSteel);
		addBlock(world, basePos, 4, 10, 4, degradedSteel);
		addBlock(world, basePos, 4, 10, 6, degradedSteel);
		addBlock(world, basePos, 6, 10, 4, degradedSteel);
		addBlock(world, basePos, 6, 10, 6, degradedSteel);
		addBlock(world, basePos, 4, 11, 4, degradedSteel);
		addBlock(world, basePos, 4, 11, 6, degradedSteel);
		addBlock(world, basePos, 6, 11, 4, degradedSteel);
		addBlock(world, basePos, 6, 11, 6, degradedSteel);
		addBlock(world, basePos, 4, 12, 4, degradedSteel);
		addBlock(world, basePos, 4, 12, 5, degradedSteel);
		addBlock(world, basePos, 4, 12, 6, degradedSteel);
		addBlock(world, basePos, 5, 12, 4, degradedSteel);
		addBlock(world, basePos, 5, 12, 6, degradedSteel);
		addBlock(world, basePos, 6, 12, 4, degradedSteel);
		addBlock(world, basePos, 6, 12, 5, degradedSteel);
		addBlock(world, basePos, 6, 12, 6, degradedSteel);
		addBlock(world, basePos, 4, 13, 4, degradedSteel);
		addBlock(world, basePos, 4, 13, 6, degradedSteel);
		addBlock(world, basePos, 6, 13, 4, degradedSteel);
		addBlock(world, basePos, 6, 13, 6, degradedSteel);
		addBlock(world, basePos, 4, 14, 4, degradedSteel);
		addBlock(world, basePos, 4, 14, 6, degradedSteel);
		addBlock(world, basePos, 6, 14, 4, degradedSteel);
		addBlock(world, basePos, 6, 14, 6, degradedSteel);
		addBlock(world, basePos, 4, 15, 4, degradedSteel);
		addBlock(world, basePos, 4, 15, 5, degradedSteel);
		addBlock(world, basePos, 4, 15, 6, degradedSteel);
		addBlock(world, basePos, 5, 15, 4, degradedSteel);
		addBlock(world, basePos, 5, 15, 6, degradedSteel);
		addBlock(world, basePos, 6, 15, 4, degradedSteel);
		addBlock(world, basePos, 6, 15, 5, degradedSteel);
		addBlock(world, basePos, 6, 15, 6, degradedSteel);
		addBlock(world, basePos, 4, 16, 4, degradedSteel);
		addBlock(world, basePos, 4, 16, 6, degradedSteel);
		addBlock(world, basePos, 6, 16, 4, degradedSteel);
		addBlock(world, basePos, 6, 16, 6, degradedSteel);
		addBlock(world, basePos, 4, 17, 4, degradedSteel);
		addBlock(world, basePos, 4, 17, 6, degradedSteel);
		addBlock(world, basePos, 6, 17, 4, degradedSteel);
		addBlock(world, basePos, 6, 17, 6, degradedSteel);
		addBlock(world, basePos, 4, 18, 4, degradedSteel);
		addBlock(world, basePos, 4, 18, 5, degradedSteel);
		addBlock(world, basePos, 4, 18, 6, degradedSteel);
		addBlock(world, basePos, 5, 18, 4, degradedSteel);
		addBlock(world, basePos, 5, 18, 6, degradedSteel);
		addBlock(world, basePos, 6, 18, 4, degradedSteel);
		addBlock(world, basePos, 6, 18, 5, degradedSteel);
		addBlock(world, basePos, 6, 18, 6, degradedSteel);
		addBlock(world, basePos, 4, 19, 4, degradedSteel);
		addBlock(world, basePos, 4, 19, 6, degradedSteel);
		addBlock(world, basePos, 6, 19, 4, degradedSteel);
		addBlock(world, basePos, 6, 19, 6, degradedSteel);
		addBlock(world, basePos, 4, 20, 4, degradedSteel);
		addBlock(world, basePos, 4, 20, 6, degradedSteel);
		addBlock(world, basePos, 6, 20, 4, degradedSteel);
		addBlock(world, basePos, 6, 20, 6, degradedSteel);
		addBlock(world, basePos, 4, 21, 4, degradedSteel);
		addBlock(world, basePos, 4, 21, 5, degradedSteel);
		addBlock(world, basePos, 4, 21, 6, degradedSteel);
		addBlock(world, basePos, 5, 21, 4, degradedSteel);
		addBlock(world, basePos, 5, 21, 6, degradedSteel);
		addBlock(world, basePos, 6, 21, 4, degradedSteel);
		addBlock(world, basePos, 6, 21, 5, degradedSteel);
		addBlock(world, basePos, 6, 21, 6, degradedSteel);
		addBlock(world, basePos, 4, 22, 4, degradedSteel);
		addBlock(world, basePos, 4, 22, 6, degradedSteel);
		addBlock(world, basePos, 6, 22, 4, degradedSteel);
		addBlock(world, basePos, 6, 22, 6, degradedSteel);
		addBlock(world, basePos, 4, 23, 4, degradedSteel);
		addBlock(world, basePos, 4, 23, 6, degradedSteel);
		addBlock(world, basePos, 6, 23, 4, degradedSteel);
		addBlock(world, basePos, 6, 23, 6, degradedSteel);
		addBlock(world, basePos, 4, 24, 4, degradedSteel);
		addBlock(world, basePos, 4, 24, 5, degradedSteel);
		addBlock(world, basePos, 4, 24, 6, degradedSteel);
		addBlock(world, basePos, 5, 24, 4, degradedSteel);
		addBlock(world, basePos, 5, 24, 6, degradedSteel);
		addBlock(world, basePos, 6, 24, 4, degradedSteel);
		addBlock(world, basePos, 6, 24, 5, degradedSteel);
		addBlock(world, basePos, 6, 24, 6, degradedSteel);
		addBlock(world, basePos, 4, 25, 4, degradedSteel);
		addBlock(world, basePos, 4, 25, 6, degradedSteel);
		addBlock(world, basePos, 6, 25, 4, degradedSteel);
		addBlock(world, basePos, 6, 25, 6, degradedSteel);
		addBlock(world, basePos, 4, 26, 4, degradedSteel);
		addBlock(world, basePos, 4, 26, 6, degradedSteel);
		addBlock(world, basePos, 6, 26, 4, degradedSteel);
		addBlock(world, basePos, 6, 26, 6, degradedSteel);
		addBlock(world, basePos, 4, 27, 4, degradedSteel);
		addBlock(world, basePos, 4, 27, 5, degradedSteel);
		addBlock(world, basePos, 4, 27, 6, degradedSteel);
		addBlock(world, basePos, 5, 27, 4, degradedSteel);
		addBlock(world, basePos, 5, 27, 6, degradedSteel);
		addBlock(world, basePos, 6, 27, 4, degradedSteel);
		addBlock(world, basePos, 6, 27, 5, degradedSteel);
		addBlock(world, basePos, 6, 27, 6, degradedSteel);
		addBlock(world, basePos, 4, 28, 4, degradedSteel);
		addBlock(world, basePos, 4, 28, 6, degradedSteel);
		addBlock(world, basePos, 6, 28, 4, degradedSteel);
		addBlock(world, basePos, 6, 28, 6, degradedSteel);
		addBlock(world, basePos, 4, 29, 4, degradedSteel);
		addBlock(world, basePos, 4, 29, 6, degradedSteel);
		addBlock(world, basePos, 6, 29, 4, degradedSteel);
		addBlock(world, basePos, 6, 29, 6, degradedSteel);
		addBlock(world, basePos, 4, 30, 4, degradedSteel);
		addBlock(world, basePos, 4, 30, 5, degradedSteel);
		addBlock(world, basePos, 4, 30, 6, degradedSteel);
		addBlock(world, basePos, 5, 30, 4, degradedSteel);
		addBlock(world, basePos, 5, 30, 6, degradedSteel);
		addBlock(world, basePos, 6, 30, 4, degradedSteel);
		addBlock(world, basePos, 6, 30, 5, degradedSteel);
		addBlock(world, basePos, 6, 30, 6, degradedSteel);
		addBlock(world, basePos, 4, 31, 4, degradedSteel);
		addBlock(world, basePos, 4, 31, 6, degradedSteel);
		addBlock(world, basePos, 6, 31, 4, degradedSteel);
		addBlock(world, basePos, 6, 31, 6, degradedSteel);
		addBlock(world, basePos, 4, 32, 4, degradedSteel);
		addBlock(world, basePos, 4, 32, 6, degradedSteel);
		addBlock(world, basePos, 6, 32, 4, degradedSteel);
		addBlock(world, basePos, 6, 32, 6, degradedSteel);
		addBlock(world, basePos, 4, 33, 4, degradedSteel);
		addBlock(world, basePos, 4, 33, 5, degradedSteel);
		addBlock(world, basePos, 4, 33, 6, degradedSteel);
		addBlock(world, basePos, 5, 33, 4, degradedSteel);
		addBlock(world, basePos, 5, 33, 6, degradedSteel);
		addBlock(world, basePos, 6, 33, 4, degradedSteel);
		addBlock(world, basePos, 6, 33, 5, degradedSteel);
		addBlock(world, basePos, 6, 33, 6, degradedSteel);
		addBlock(world, basePos, 4, 34, 4, degradedSteel);
		addBlock(world, basePos, 4, 34, 6, degradedSteel);
		addBlock(world, basePos, 6, 34, 4, degradedSteel);
		addBlock(world, basePos, 6, 34, 6, degradedSteel);
		addBlock(world, basePos, 4, 35, 4, degradedSteel);
		addBlock(world, basePos, 4, 35, 6, degradedSteel);
		addBlock(world, basePos, 6, 35, 4, degradedSteel);
		addBlock(world, basePos, 6, 35, 6, degradedSteel);
		addBlock(world, basePos, 4, 36, 4, degradedSteel);
		addBlock(world, basePos, 4, 36, 5, degradedSteel);
		addBlock(world, basePos, 4, 36, 6, degradedSteel);
		addBlock(world, basePos, 5, 36, 4, degradedSteel);
		addBlock(world, basePos, 5, 36, 6, degradedSteel);
		addBlock(world, basePos, 6, 36, 4, degradedSteel);
		addBlock(world, basePos, 6, 36, 5, degradedSteel);
		addBlock(world, basePos, 6, 36, 6, degradedSteel);
		addBlock(world, basePos, 4, 37, 4, degradedSteel);
		addBlock(world, basePos, 4, 37, 6, degradedSteel);
		addBlock(world, basePos, 6, 37, 4, degradedSteel);
		addBlock(world, basePos, 6, 37, 6, degradedSteel);
		addBlock(world, basePos, 4, 38, 4, degradedSteel);
		addBlock(world, basePos, 4, 38, 6, degradedSteel);
		addBlock(world, basePos, 6, 38, 4, degradedSteel);
		addBlock(world, basePos, 6, 38, 6, degradedSteel);
		addBlock(world, basePos, 4, 39, 4, degradedSteel);
		addBlock(world, basePos, 4, 39, 5, degradedSteel);
		addBlock(world, basePos, 4, 39, 6, degradedSteel);
		addBlock(world, basePos, 5, 39, 4, degradedSteel);
		addBlock(world, basePos, 5, 39, 6, degradedSteel);
		addBlock(world, basePos, 6, 39, 4, degradedSteel);
		addBlock(world, basePos, 6, 39, 5, degradedSteel);
		addBlock(world, basePos, 6, 39, 6, degradedSteel);
		addBlock(world, basePos, 4, 40, 4, degradedSteel);
		addBlock(world, basePos, 4, 40, 6, degradedSteel);
		addBlock(world, basePos, 6, 40, 4, degradedSteel);
		addBlock(world, basePos, 6, 40, 6, degradedSteel);
		addBlock(world, basePos, 4, 41, 4, degradedSteel);
		addBlock(world, basePos, 4, 41, 6, degradedSteel);
		addBlock(world, basePos, 6, 41, 4, degradedSteel);
		addBlock(world, basePos, 6, 41, 6, degradedSteel);
		addBlock(world, basePos, 4, 42, 4, degradedSteel);
		addBlock(world, basePos, 4, 42, 5, degradedSteel);
		addBlock(world, basePos, 4, 42, 6, degradedSteel);
		addBlock(world, basePos, 5, 42, 4, degradedSteel);
		addBlock(world, basePos, 5, 42, 6, degradedSteel);
		addBlock(world, basePos, 6, 42, 4, degradedSteel);
		addBlock(world, basePos, 6, 42, 5, degradedSteel);
		addBlock(world, basePos, 6, 42, 6, degradedSteel);
		addBlock(world, basePos, 4, 43, 4, degradedSteel);
		addBlock(world, basePos, 4, 43, 6, degradedSteel);
		addBlock(world, basePos, 6, 43, 4, degradedSteel);
		addBlock(world, basePos, 6, 43, 6, degradedSteel);
		addBlock(world, basePos, 4, 44, 4, degradedSteel);
		addBlock(world, basePos, 4, 44, 6, degradedSteel);
		addBlock(world, basePos, 6, 44, 4, degradedSteel);
		addBlock(world, basePos, 6, 44, 6, degradedSteel);
		addBlock(world, basePos, 4, 45, 4, degradedSteel);
		addBlock(world, basePos, 4, 45, 5, degradedSteel);
		addBlock(world, basePos, 4, 45, 6, degradedSteel);
		addBlock(world, basePos, 5, 45, 4, degradedSteel);
		addBlock(world, basePos, 5, 45, 5, degradedSteel);
		addBlock(world, basePos, 5, 45, 6, degradedSteel);
		addBlock(world, basePos, 6, 45, 4, degradedSteel);
		addBlock(world, basePos, 6, 45, 5, degradedSteel);
		addBlock(world, basePos, 6, 45, 6, degradedSteel);
		addBlock(world, basePos, 5, 46, 5, degradedSteel);
		addBlock(world, basePos, 5, 47, 5, degradedSteel);
		addBlock(world, basePos, 5, 48, 5, degradedSteel);
		addBlock(world, basePos, 5, 49, 5, degradedSteel);
		addBlock(world, basePos, 0, 50, 2, degradedSteel);
		addBlock(world, basePos, 0, 50, 5, degradedSteel);
		addBlock(world, basePos, 0, 50, 8, degradedSteel);
		addBlock(world, basePos, 2, 50, 0, degradedSteel);
		addBlock(world, basePos, 2, 50, 10, degradedSteel);
		addBlock(world, basePos, 5, 50, 0, degradedSteel);
		addBlock(world, basePos, 5, 50, 5, degradedSteel);
		addBlock(world, basePos, 5, 50, 10, degradedSteel);
		addBlock(world, basePos, 8, 50, 0, degradedSteel);
		addBlock(world, basePos, 8, 50, 10, degradedSteel);
		addBlock(world, basePos, 10, 50, 2, degradedSteel);
		addBlock(world, basePos, 10, 50, 5, degradedSteel);
		addBlock(world, basePos, 10, 50, 8, degradedSteel);
		addBlock(world, basePos, 0, 51, 2, degradedSteel);
		addBlock(world, basePos, 0, 51, 5, degradedSteel);
		addBlock(world, basePos, 0, 51, 8, degradedSteel);
		addBlock(world, basePos, 1, 51, 1, degradedSteel);
		addBlock(world, basePos, 1, 51, 2, degradedSteel);
		addBlock(world, basePos, 1, 51, 3, degradedSteel);
		addBlock(world, basePos, 1, 51, 4, degradedSteel);
		addBlock(world, basePos, 1, 51, 5, degradedSteel);
		addBlock(world, basePos, 1, 51, 6, degradedSteel);
		addBlock(world, basePos, 1, 51, 7, degradedSteel);
		addBlock(world, basePos, 1, 51, 8, degradedSteel);
		addBlock(world, basePos, 1, 51, 9, degradedSteel);
		addBlock(world, basePos, 2, 51, 0, degradedSteel);
		addBlock(world, basePos, 2, 51, 1, degradedSteel);
		addBlock(world, basePos, 2, 51, 5, degradedSteel);
		addBlock(world, basePos, 2, 51, 9, degradedSteel);
		addBlock(world, basePos, 2, 51, 10, degradedSteel);
		addBlock(world, basePos, 3, 51, 1, degradedSteel);
		addBlock(world, basePos, 3, 51, 5, degradedSteel);
		addBlock(world, basePos, 3, 51, 9, degradedSteel);
		addBlock(world, basePos, 4, 51, 1, degradedSteel);
		addBlock(world, basePos, 4, 51, 5, degradedSteel);
		addBlock(world, basePos, 4, 51, 9, degradedSteel);
		addBlock(world, basePos, 5, 51, 0, degradedSteel);
		addBlock(world, basePos, 5, 51, 1, degradedSteel);
		addBlock(world, basePos, 5, 51, 2, degradedSteel);
		addBlock(world, basePos, 5, 51, 3, degradedSteel);
		addBlock(world, basePos, 5, 51, 4, degradedSteel);
		addBlock(world, basePos, 5, 51, 5, degradedSteel);
		addBlock(world, basePos, 5, 51, 6, degradedSteel);
		addBlock(world, basePos, 5, 51, 7, degradedSteel);
		addBlock(world, basePos, 5, 51, 8, degradedSteel);
		addBlock(world, basePos, 5, 51, 9, degradedSteel);
		addBlock(world, basePos, 5, 51, 10, degradedSteel);
		addBlock(world, basePos, 6, 51, 1, degradedSteel);
		addBlock(world, basePos, 6, 51, 5, degradedSteel);
		addBlock(world, basePos, 6, 51, 9, degradedSteel);
		addBlock(world, basePos, 7, 51, 1, degradedSteel);
		addBlock(world, basePos, 7, 51, 5, degradedSteel);
		addBlock(world, basePos, 7, 51, 9, degradedSteel);
		addBlock(world, basePos, 8, 51, 0, degradedSteel);
		addBlock(world, basePos, 8, 51, 1, degradedSteel);
		addBlock(world, basePos, 8, 51, 5, degradedSteel);
		addBlock(world, basePos, 8, 51, 9, degradedSteel);
		addBlock(world, basePos, 8, 51, 10, degradedSteel);
		addBlock(world, basePos, 9, 51, 1, degradedSteel);
		addBlock(world, basePos, 9, 51, 2, degradedSteel);
		addBlock(world, basePos, 9, 51, 3, degradedSteel);
		addBlock(world, basePos, 9, 51, 4, degradedSteel);
		addBlock(world, basePos, 9, 51, 5, degradedSteel);
		addBlock(world, basePos, 9, 51, 6, degradedSteel);
		addBlock(world, basePos, 9, 51, 7, degradedSteel);
		addBlock(world, basePos, 9, 51, 8, degradedSteel);
		addBlock(world, basePos, 9, 51, 9, degradedSteel);
		addBlock(world, basePos, 10, 51, 2, degradedSteel);
		addBlock(world, basePos, 10, 51, 5, degradedSteel);
		addBlock(world, basePos, 10, 51, 8, degradedSteel);
		addBlock(world, basePos, 0, 52, 2, steelLight);
		addBlock(world, basePos, 0, 52, 5, steelLight);
		addBlock(world, basePos, 0, 52, 8, steelLight);
		addBlock(world, basePos, 2, 52, 0, steelLight);
		addBlock(world, basePos, 2, 52, 10, steelLight);
		addBlock(world, basePos, 5, 52, 0, steelLight);
		addBlock(world, basePos, 5, 52, 10, steelLight);
		addBlock(world, basePos, 8, 52, 0, steelLight);
		addBlock(world, basePos, 8, 52, 10, steelLight);
		addBlock(world, basePos, 10, 52, 2, steelLight);
		addBlock(world, basePos, 10, 52, 5, steelLight);
		addBlock(world, basePos, 10, 52, 8, steelLight);
		addBlock(world, basePos, 0, 53, 2, degradedSteel);
		addBlock(world, basePos, 0, 53, 5, degradedSteel);
		addBlock(world, basePos, 0, 53, 8, degradedSteel);
		addBlock(world, basePos, 2, 53, 0, degradedSteel);
		addBlock(world, basePos, 2, 53, 10, degradedSteel);
		addBlock(world, basePos, 5, 53, 0, degradedSteel);
		addBlock(world, basePos, 5, 53, 10, degradedSteel);
		addBlock(world, basePos, 8, 53, 0, degradedSteel);
		addBlock(world, basePos, 8, 53, 10, degradedSteel);
		addBlock(world, basePos, 10, 53, 2, degradedSteel);
		addBlock(world, basePos, 10, 53, 5, degradedSteel);
		addBlock(world, basePos, 10, 53, 8, degradedSteel);
		addBlock(world, basePos, 0, 54, 2, degradedSteel);
		addBlock(world, basePos, 0, 54, 5, degradedSteel);
		addBlock(world, basePos, 0, 54, 8, degradedSteel);
		addBlock(world, basePos, 2, 54, 0, degradedSteel);
		addBlock(world, basePos, 2, 54, 10, degradedSteel);
		addBlock(world, basePos, 5, 54, 0, degradedSteel);
		addBlock(world, basePos, 5, 54, 10, degradedSteel);
		addBlock(world, basePos, 8, 54, 0, degradedSteel);
		addBlock(world, basePos, 8, 54, 10, degradedSteel);
		addBlock(world, basePos, 10, 54, 2, degradedSteel);
		addBlock(world, basePos, 10, 54, 5, degradedSteel);
		addBlock(world, basePos, 10, 54, 8, degradedSteel);
	}
}
