package net.tslat.aoa3.common.registration.worldgen;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.tslat.aoa3.common.registration.AoARegistries;
import net.tslat.aoa3.content.world.gen.structure.placement.SingleStructurePlacement;

public final class AoAStructurePlacements {
	public static void init() {}

	public static final DeferredHolder<StructurePlacementType<?>, StructurePlacementType<SingleStructurePlacement>> SINGLE_STRUCTURE = register("single_structure", SingleStructurePlacement.CODEC);

	private static <S extends StructurePlacement> DeferredHolder<StructurePlacementType<?>, StructurePlacementType<S>> register(String id, MapCodec<S> placementType) {
		return AoARegistries.STRUCTURE_PLACEMENTS.register(id, () -> () -> placementType);
	}
}
