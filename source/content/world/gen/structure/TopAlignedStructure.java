package net.tslat.aoa3.content.world.gen.structure;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.tslat.aoa3.common.registration.worldgen.AoAStructureTypes;

import java.util.List;
import java.util.Optional;

import static net.tslat.aoa3.content.world.gen.structure.AoAStructure.Settings.aoaSettings;

public class TopAlignedStructure extends AoAStructure {
	protected int nextGenHeight = 0;

	public static final MapCodec<TopAlignedStructure> CODEC = RecordCodecBuilder.mapCodec(codec ->
			codec.group(aoaSettings())
					.apply(codec, TopAlignedStructure::new));

	public TopAlignedStructure(Settings settings) {
		super(settings);
	}

	@Override
	public StructureType<? extends AoAStructure> type() {
		return AoAStructureTypes.TOP_ALIGNED.get();
	}

	@Override
	public Optional<GenerationStub> findGenerationPoint(GenerationContext genContext) {
		ChunkPos chunkpos = genContext.chunkPos();
		this.nextGenHeight = this.settings.startHeight().sample(genContext.random(), new WorldGenerationContext(genContext.chunkGenerator(), genContext.heightAccessor()));
		BlockPos blockpos = new BlockPos(chunkpos.getMinBlockX(), this.nextGenHeight, chunkpos.getMinBlockZ());

		return assembler.addPieces(genContext, this.settings.startPool(), this.settings.startJigsawName(), this.settings.maxPieces(), blockpos, this.settings.startHeightmap(), 128, this.settings.liquidSettings());
	}

	@Override
	protected AoAJigsawAssembler getJigsawAssembler() {
		return new AoAJigsawAssembler() {
			@Override
			protected Optional<GenerationStub> buildGenerationStub(PoolElementStructurePiece startPiece, BoundingBox startPieceBounds, GenerationContext genContext, int startX, int startY, int startZ, int maxPieces, int maxRadius, LiquidSettings liquidSettings) {
				return Optional.of(new Structure.GenerationStub(getStartPos(startPiece, startX, startY, startZ), pieceBuilder -> {
					List<PoolElementStructurePiece> pieces = new ObjectArrayList<>();

					pieces.add(startPiece);

					if (maxPieces > 0) {
						addPieces(
								genContext.randomState(),
								maxPieces,
								genContext.chunkGenerator(),
								genContext.structureTemplateManager(),
								genContext.heightAccessor(),
								genContext.random(),
								genContext.registryAccess().registryOrThrow(Registries.TEMPLATE_POOL),
								startPiece,
								pieces,
								Shapes.join(
										Shapes.create(new AABB(startX - maxRadius, -4000, startZ - maxRadius, startX + maxRadius + 1, 4000, startZ + maxRadius + 1)),
										Shapes.create(AABB.of(startPieceBounds)), BooleanOp.ONLY_FIRST),
								liquidSettings);
						pieces.forEach(pieceBuilder::addPiece);
					}

					pieceBuilder.offsetPiecesVertically(TopAlignedStructure.this.nextGenHeight - startPieceBounds.maxY());
				}));
			}
		};
	}
}
