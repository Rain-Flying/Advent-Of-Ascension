package net.tslat.aoa3.content.world.teleporter;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.tslat.aoa3.common.registration.AoATags;
import net.tslat.aoa3.common.registration.block.AoABlocks;
import net.tslat.aoa3.content.block.functional.portal.PortalBlock;
import net.tslat.effectslib.api.particle.ParticleBuilder;
import net.tslat.effectslib.networking.packet.TELParticlePacket;

import java.util.ArrayList;

import static net.tslat.aoa3.content.world.teleporter.AoAPortalFrame.PortalDirection.*;

public class AoAPortalFrame {
    private static final ArrayList<Vec3i> northSouthPattern = new ArrayList<Vec3i>();
    private static final ArrayList<Vec3i> eastWestPattern = new ArrayList<Vec3i>();

    public static PortalDirection testFrameForActivation(Level world, BlockPos activationPos, Direction sideClicked, PortalBlock portalBlock) {
        switch (sideClicked) {
            case NORTH:
            case SOUTH:
            	return testNorthSouthPortalFrame(world, activationPos, portalBlock);
            case EAST:
            case WEST:
            	return testEastWestPortalFrame(world, activationPos, portalBlock);
            case UP:
            case DOWN:
            default:
            	PortalDirection dir = testNorthSouthPortalFrame(world, activationPos, portalBlock);

            	if (dir == INVALID)
            		dir = testEastWestPortalFrame(world, activationPos, portalBlock);

            	return dir;
        }
    }

    public static PortalDirection testNorthSouthPortalFrame(Level world, BlockPos basePos, PortalBlock portalBlock) {
        Block carvedRuneTravel = null;
        Block carvedRuneReality = null;
        Block carvedRuneSpace = null;
        Block carvedRuneDirection = null;
        int ancientRockCount = 0;

        for (Vec3i pos : northSouthPattern) {
            BlockState testState = world.getBlockState(basePos.offset(pos));
            Block testBlock = testState.getBlock();

            if (testBlock == AoABlocks.ANCIENT_ROCK.get()) {
                ancientRockCount++;
            }
            else if (testState.is(AoATags.Blocks.CARVED_RUNE)) {
                if (testBlock == AoABlocks.CARVED_RUNE_OF_TRAVEL.get()) {
                    if (carvedRuneTravel != null)
                        return INVALID;

                    carvedRuneTravel = testBlock;
                }
                else if (testBlock == AoABlocks.CARVED_RUNE_OF_REALITY.get()) {
                    if (carvedRuneReality != null)
                        return INVALID;

                    carvedRuneReality = testBlock;
                }
                else if (testBlock == AoABlocks.CARVED_RUNE_OF_SPACE.get()) {
                    if (carvedRuneSpace != null)
                        return INVALID;

                    carvedRuneSpace = testBlock;
                }
                else if (testBlock == AoABlocks.CARVED_RUNE_OF_DIRECTION.get()) {
                    if (carvedRuneDirection != null)
                        return INVALID;

                    carvedRuneDirection = testBlock;
                }
            }
        }

        if (ancientRockCount == 13 && carvedRuneDirection != null && carvedRuneReality != null && carvedRuneSpace != null && carvedRuneTravel != null) {
            for (int x = -1; x < 2; x++) {
                for (int y = 1; y < 5; y++) {
					BlockState state = world.getBlockState(basePos.offset(x, y, 0));

					if (state.getBlock() instanceof PortalBlock) {
						if (state.getBlock() == portalBlock)
							return EXISTING;
					}
					else if (!state.canBeReplaced()) {
						return INVALID;
					}
                }
            }

            return NORTH_SOUTH;
        }

        return INVALID;
    }

    public static PortalDirection testEastWestPortalFrame(Level world, BlockPos basePos, PortalBlock portalBlock) {
        Block carvedRuneTravel = null;
        Block carvedRuneReality = null;
        Block carvedRuneSpace = null;
        Block carvedRuneDirection = null;
        int ancientRockCount = 0;

        for (Vec3i pos : eastWestPattern) {
            BlockState testState = world.getBlockState(basePos.offset(pos));
            Block testBlock = testState.getBlock();

            if (testBlock == AoABlocks.ANCIENT_ROCK.get()) {
                ancientRockCount++;
            }
            else if (testState.is(AoATags.Blocks.CARVED_RUNE)) {
                if (testBlock == AoABlocks.CARVED_RUNE_OF_TRAVEL.get()) {
                    if (carvedRuneTravel != null)
                        return INVALID;

                    carvedRuneTravel = testBlock;
                }
                else if (testBlock == AoABlocks.CARVED_RUNE_OF_REALITY.get()) {
                    if (carvedRuneReality != null)
                        return INVALID;

                    carvedRuneReality = testBlock;
                }
                else if (testBlock == AoABlocks.CARVED_RUNE_OF_SPACE.get()) {
                    if (carvedRuneSpace != null)
                        return INVALID;

                    carvedRuneSpace = testBlock;
                }
                else if (testBlock == AoABlocks.CARVED_RUNE_OF_DIRECTION.get()) {
                    if (carvedRuneDirection != null)
                        return INVALID;

                    carvedRuneDirection = testBlock;
                }
            }
        }

        if (ancientRockCount == 13 && carvedRuneDirection != null && carvedRuneReality != null && carvedRuneSpace != null && carvedRuneTravel != null) {
            for (int z = -1; z < 2; z++) {
                for (int y = 1; y < 5; y++) {
					BlockState state = world.getBlockState(basePos.offset(0, y, z));

					if (state.getBlock() instanceof PortalBlock) {
						if (state.getBlock() == portalBlock)
							return EXISTING;
					}
					else if (!state.canBeReplaced()) {
						return INVALID;
					}
                }
            }

            return EAST_WEST;
        }

        return INVALID;
    }

    public static void lightPortalFrame(ServerLevel level, BlockPos basePos, PortalDirection direction, PortalBlock portalBlock) {
        final TELParticlePacket packet = new TELParticlePacket();
        final int colour = portalBlock.getParticleColour(portalBlock.defaultBlockState());

        switch (direction) {
            case NORTH_SOUTH:
                for (int x = -1; x < 2; x++) {
                    for (int y = 1; y < 5; y++) {
                        BlockPos pos = basePos.offset(x, y, 0);

                        level.setBlock(pos, portalBlock.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.Z), Block.UPDATE_CLIENTS);

                        for (int i = 0; i < 10; i++) {
                            if (level.random.nextBoolean()) {
                                packet.particle(ParticleBuilder.forRandomPosInBounds(ParticleTypes.END_ROD, new AABB(pos)).spawnNTimes(5).scaleMod(0.5f).colourOverride(0, 0, 0, 1f));
                            }
                            else {
                                packet.particle(ParticleBuilder.forRandomPosInBounds(ParticleTypes.END_ROD, new AABB(pos)).spawnNTimes(5).scaleMod(0.5f).colourOverride(colour));
                            }
                        }
                    }
                }
                break;
            case EAST_WEST:
                for (int z = -1; z < 2; z++) {
                    for (int y = 1; y < 5; y++) {
                        BlockPos pos = basePos.offset(0, y, z);

                        level.setBlock(pos, portalBlock.defaultBlockState(), Block.UPDATE_CLIENTS);

                        for (int i = 0; i < 10; i++) {
                            if (level.random.nextBoolean()) {
                                packet.particle(ParticleBuilder.forRandomPosInBounds(ParticleTypes.END_ROD, new AABB(pos)).spawnNTimes(5).scaleMod(0.5f).colourOverride(0, 0, 0, 1f));
                            }
                            else {
                                packet.particle(ParticleBuilder.forRandomPosInBounds(ParticleTypes.END_ROD, new AABB(pos)).spawnNTimes(5).scaleMod(0.5f).colourOverride(colour));
                            }
                        }
                    }
                }
                break;
            default:
                break;
        }

        packet.sendToAllNearbyPlayers(level, Vec3.atBottomCenterOf(basePos), 32);
    }

    public enum PortalDirection {
        INVALID,
		EXISTING,
        NORTH_SOUTH,
        EAST_WEST
    }

    static {
        northSouthPattern.add(new Vec3i(-2, 0, 0));
        northSouthPattern.add(new Vec3i(-1, 0, 0));
        northSouthPattern.add(new Vec3i(-0, 0, 0));
        northSouthPattern.add(new Vec3i(1, 0, 0));
        northSouthPattern.add(new Vec3i(2, 0, 0));
        northSouthPattern.add(new Vec3i(2, 1, 0));
        northSouthPattern.add(new Vec3i(2, 2, 0));
        northSouthPattern.add(new Vec3i(2, 3, 0));
        northSouthPattern.add(new Vec3i(2, 4, 0));
        northSouthPattern.add(new Vec3i(2, 5, 0));
        northSouthPattern.add(new Vec3i(1, 5, 0));
        northSouthPattern.add(new Vec3i(0, 5, 0));
        northSouthPattern.add(new Vec3i(-1, 5, 0));
        northSouthPattern.add(new Vec3i(-2, 5, 0));
        northSouthPattern.add(new Vec3i(-2, 4, 0));
        northSouthPattern.add(new Vec3i(-2, 3, 0));
        northSouthPattern.add(new Vec3i(-2, 2, 0));
        northSouthPattern.add(new Vec3i(-2, 1, 0));

        eastWestPattern.add(new Vec3i(0, 0, -2));
        eastWestPattern.add(new Vec3i(0, 0, -1));
        eastWestPattern.add(new Vec3i(0, 0, 0));
        eastWestPattern.add(new Vec3i(0, 0, 1));
        eastWestPattern.add(new Vec3i(0, 0, 2));
        eastWestPattern.add(new Vec3i(0, 1, 2));
        eastWestPattern.add(new Vec3i(0, 2, 2));
        eastWestPattern.add(new Vec3i(0, 3, 2));
        eastWestPattern.add(new Vec3i(0, 4, 2));
        eastWestPattern.add(new Vec3i(0, 5, 2));
        eastWestPattern.add(new Vec3i(0, 5, 1));
        eastWestPattern.add(new Vec3i(0, 5, 0));
        eastWestPattern.add(new Vec3i(0, 5, -1));
        eastWestPattern.add(new Vec3i(0, 5, -2));
        eastWestPattern.add(new Vec3i(0, 4, -2));
        eastWestPattern.add(new Vec3i(0, 3, -2));
        eastWestPattern.add(new Vec3i(0, 2, -2));
        eastWestPattern.add(new Vec3i(0, 1, -2));
    }
}
