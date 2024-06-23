package net.tslat.aoa3.content.world.gen.structure;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.tslat.aoa3.common.registration.worldgen.AoAStructureTypes;

import java.util.Optional;

import static net.tslat.aoa3.content.world.gen.structure.AoAStructure.Settings.aoaSettings;

public class SinglePlacementStructure extends AoAStructure {
	public static final MapCodec<SinglePlacementStructure> CODEC = RecordCodecBuilder.mapCodec(codec -> codec.group(
			aoaSettings(),
			BlockPos.CODEC.fieldOf("position").forGetter(SinglePlacementStructure::pos)
	).apply(codec, SinglePlacementStructure::new));

	private final BlockPos pos;

	public SinglePlacementStructure(Settings settings, BlockPos pos) {
		super(settings);

		this.pos = pos;
	}

	@Override
	public StructureType<? extends AoAStructure> type() {
		return AoAStructureTypes.SINGLE_PLACEMENT.get();
	}

	public BlockPos pos() {
		return this.pos;
	}

	@Override
	protected AoAJigsawAssembler getJigsawAssembler() {
		return new AoAJigsawAssembler() {
			@Override
			protected boolean ignoreRotations() {
				return true;
			}
		};
	}

	@Override
	public Optional<GenerationStub> findGenerationPoint(GenerationContext genContext) {
		return assembler.addPieces(genContext, this.settings.startPool(), this.settings.startJigsawName(), this.settings.maxPieces(), this.pos, this.settings.startHeightmap(), 128, this.settings.liquidSettings());
	}
}
