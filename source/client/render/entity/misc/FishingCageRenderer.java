package net.tslat.aoa3.client.render.entity.misc;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.tslat.aoa3.advent.AdventOfAscension;
import net.tslat.aoa3.client.AoAEntityRendering;
import net.tslat.aoa3.client.model.misc.FishingCageModel;
import net.tslat.aoa3.content.entity.misc.FishingCageEntity;
import net.tslat.aoa3.util.ColourUtil;
import org.jetbrains.annotations.Nullable;


public class FishingCageRenderer extends EntityRenderer<FishingCageEntity> {
	private final ResourceLocation texture = AdventOfAscension.id("textures/entity/misc/fishing_cage.png");
	private final FishingCageModel model;

	public FishingCageRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager);

		this.model = new FishingCageModel(renderManager.bakeLayer(AoAEntityRendering.FISHING_CAGE.getMainLayerLocation()));
	}

	@Override
	public void render(FishingCageEntity entity, float entityYaw, float partialTicks, PoseStack matrix, MultiBufferSource buffer, int packedLight) {
		matrix.pushPose();
		matrix.translate(0, 1.5d, 0);
		matrix.mulPose(Axis.XP.rotationDegrees(180));
		matrix.mulPose(Axis.YP.rotationDegrees(entityYaw));
		matrix.scale(-1, 1, -1);

		VertexConsumer vertexBuilder = buffer.getBuffer(RenderType.entityCutoutNoCull(texture));

		model.renderToBuffer(matrix, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY, ColourUtil.WHITE);

		matrix.translate(0, 1.4d, 0.1d);
		matrix.mulPose(Axis.XP.rotationDegrees(90));

		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

		for (ItemStack stack : entity.getLoot()) {
			itemRenderer.renderStatic(stack, ItemDisplayContext.GROUND, packedLight, OverlayTexture.NO_OVERLAY, matrix, buffer, entity.level(), 0);
			matrix.translate(0, -0.15d, 0);
		}

		matrix.popPose();

		super.render(entity, entityYaw, partialTicks, matrix, buffer, packedLight);
	}

	@Nullable
	@Override
	public ResourceLocation getTextureLocation(FishingCageEntity entity) {
		return texture;
	}
}