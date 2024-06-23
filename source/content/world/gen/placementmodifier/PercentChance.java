package net.tslat.aoa3.content.world.gen.placementmodifier;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.tslat.aoa3.common.registration.worldgen.AoAPlacementModifiers;

public class PercentChance extends PlacementFilter {
	public static final MapCodec<PercentChance> CODEC = ExtraCodecs.POSITIVE_FLOAT.fieldOf("chance").xmap(PercentChance::new, instance -> instance.chance);

	private final float chance;

	private PercentChance(float chance) {
		this.chance = chance;
	}

	public static PercentChance of(float chance) {
		return new PercentChance(chance);
	}

	@Override
	public PlacementModifierType<PercentChance> type() {
		return AoAPlacementModifiers.PERCENT_CHANCE.get();
	}

	@Override
	protected boolean shouldPlace(PlacementContext context, RandomSource rand, BlockPos pos) {
		return rand.nextFloat() < this.chance;
	}
}
