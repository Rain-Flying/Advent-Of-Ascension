package net.tslat.aoa3.client.model.entity.mob.deeplands;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;

public class CaveCreepModel extends EntityModel<MobEntity> {
	private final ModelRenderer body;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;
	private final ModelRenderer body2;
	private final ModelRenderer body3;
	private final ModelRenderer body4;
	private final ModelRenderer body5;
	private final ModelRenderer leg6;
	private final ModelRenderer leg5;
	private final ModelRenderer leg8;
	private final ModelRenderer leg7;
	private final ModelRenderer body6;
	private final ModelRenderer body7;
	private final ModelRenderer body8;
	private final ModelRenderer body9;
	private final ModelRenderer body10;
	private final ModelRenderer body11;
	private final ModelRenderer body12;
	private final ModelRenderer body13;

	public CaveCreepModel() {
		texWidth = 64;
		texHeight = 64;
		(body = new ModelRenderer(this, 18, 4)).addBox(-6.0f, -10.0f, -6.0f, 12, 8, 5);
		body.setPos(0.0f, 22.0f, 13.0f);
		body.setTexSize(64, 64);
		body.mirror = true;
		setRotation(body, 0.0f, 0.0f, 0.0f);
		(leg1 = new ModelRenderer(this, 0, 16)).addBox(-1.0f, 0.0f, -1.0f, 2, 6, 2);
		leg1.setPos(-7.0f, 18.0f, 10.0f);
		leg1.setTexSize(64, 64);
		leg1.mirror = true;
		setRotation(leg1, 0.0f, 0.0f, 0.0f);
		(leg2 = new ModelRenderer(this, 0, 16)).addBox(-1.0f, 0.0f, -1.0f, 2, 6, 2);
		leg2.setPos(7.0f, 18.0f, 10.0f);
		leg2.setTexSize(64, 64);
		leg2.mirror = true;
		setRotation(leg2, 0.0f, 0.0f, 0.0f);
		(leg3 = new ModelRenderer(this, 0, 16)).addBox(-1.0f, 0.0f, -1.0f, 2, 6, 2);
		leg3.setPos(-7.0f, 18.0f, -8.0f);
		leg3.setTexSize(64, 64);
		leg3.mirror = true;
		setRotation(leg3, 0.0f, 0.0f, 0.0f);
		(leg4 = new ModelRenderer(this, 0, 16)).addBox(-1.0f, 0.0f, -1.0f, 2, 6, 2);
		leg4.setPos(7.0f, 18.0f, -8.0f);
		leg4.setTexSize(64, 64);
		leg4.mirror = true;
		setRotation(leg4, 0.0f, 0.0f, 0.0f);
		(body2 = new ModelRenderer(this, 18, 38)).addBox(0.0f, 0.0f, 0.0f, 6, 6, 3);
		body2.setPos(-3.0f, 13.0f, -5.0f);
		body2.setTexSize(64, 64);
		body2.mirror = true;
		setRotation(body2, 0.0f, 0.0f, 0.0f);
		(body3 = new ModelRenderer(this, 18, 38)).addBox(0.0f, 0.0f, 1.0f, 6, 6, 3);
		body3.setPos(-3.0f, 13.0f, 3.0f);
		body3.setTexSize(64, 64);
		body3.mirror = true;
		setRotation(body3, 0.0f, 0.0f, 0.0f);
		(body4 = new ModelRenderer(this, 38, 46)).addBox(-3.0f, -14.0f, -3.0f, 6, 6, 6);
		body4.setPos(0.0f, 14.0f, 9.5f);
		body4.setTexSize(64, 64);
		body4.mirror = true;
		setRotation(body4, 0.0f, 0.0f, 0.0f);
		(body5 = new ModelRenderer(this, 18, 4)).addBox(-6.0f, -10.0f, -7.0f, 12, 8, 5);
		body5.setPos(0.0f, 22.0f, -3.0f);
		body5.setTexSize(64, 64);
		body5.mirror = true;
		setRotation(body5, 0.0f, 0.0f, 0.0f);
		(leg6 = new ModelRenderer(this, 0, 16)).addBox(-1.0f, 0.0f, -1.0f, 2, 6, 2);
		leg6.setPos(7.0f, 18.0f, -2.0f);
		leg6.setTexSize(64, 64);
		leg6.mirror = true;
		setRotation(leg6, 0.0f, 0.0f, 0.0f);
		(leg5 = new ModelRenderer(this, 0, 16)).addBox(-1.0f, 0.0f, -1.0f, 2, 6, 2);
		leg5.setPos(-7.0f, 18.0f, -2.0f);
		leg5.setTexSize(64, 64);
		leg5.mirror = true;
		setRotation(leg5, 0.0f, 0.0f, 0.0f);
		(leg8 = new ModelRenderer(this, 0, 16)).addBox(-1.0f, 0.0f, -1.0f, 2, 6, 2);
		leg8.setPos(7.0f, 18.0f, 4.0f);
		leg8.setTexSize(64, 64);
		leg8.mirror = true;
		setRotation(leg8, 0.0f, 0.0f, 0.0f);
		(leg7 = new ModelRenderer(this, 0, 16)).addBox(-1.0f, 0.0f, -1.0f, 2, 6, 2);
		leg7.setPos(-7.0f, 18.0f, 4.0f);
		leg7.setTexSize(64, 64);
		leg7.mirror = true;
		setRotation(leg7, 0.0f, 0.0f, 0.0f);
		(body6 = new ModelRenderer(this, 18, 20)).addBox(-6.0f, -10.0f, -7.0f, 12, 8, 6);
		body6.setPos(0.0f, 22.0f, 5.0f);
		body6.setTexSize(64, 64);
		body6.mirror = true;
		setRotation(body6, 0.0f, 0.0f, 0.0f);
		(body7 = new ModelRenderer(this, 38, 46)).addBox(-3.0f, -14.0f, -3.0f, 6, 6, 6);
		body7.setPos(-2.0f, 14.0f, 1.0f);
		body7.setTexSize(64, 64);
		body7.mirror = true;
		setRotation(body7, 0.0f, 0.0f, -0.6108652f);
		(body8 = new ModelRenderer(this, 38, 46)).addBox(-3.0f, -14.0f, -3.0f, 6, 6, 6);
		body8.setPos(2.0f, 14.0f, 1.0f);
		body8.setTexSize(64, 64);
		body8.mirror = true;
		setRotation(body8, 0.0f, 0.0f, 0.6108652f);
		(body9 = new ModelRenderer(this, 38, 46)).addBox(-3.0f, -14.0f, -3.0f, 6, 6, 6);
		body9.setPos(0.0f, 14.0f, -7.5f);
		body9.setTexSize(64, 64);
		body9.mirror = true;
		setRotation(body9, 0.0f, 0.0f, 0.0f);
		(body10 = new ModelRenderer(this, 18, 51)).addBox(-2.0f, -8.0f, -2.0f, 4, 8, 4);
		body10.setPos(0.0f, 14.0f, 9.5f);
		body10.setTexSize(64, 64);
		body10.mirror = true;
		setRotation(body10, 0.0f, 0.0f, 0.0f);
		(body11 = new ModelRenderer(this, 18, 51)).addBox(-2.0f, -8.0f, -2.0f, 4, 8, 4);
		body11.setPos(0.0f, 14.0f, -7.5f);
		body11.setTexSize(64, 64);
		body11.mirror = true;
		setRotation(body11, 0.0f, 0.0f, 0.0f);
		(body12 = new ModelRenderer(this, 18, 51)).addBox(-2.0f, -8.0f, -2.0f, 4, 8, 4);
		body12.setPos(2.0f, 14.0f, 1.0f);
		body12.setTexSize(64, 64);
		body12.mirror = true;
		setRotation(body12, 0.0f, 0.0f, 0.6108652f);
		(body13 = new ModelRenderer(this, 18, 51)).addBox(-2.0f, -8.0f, -2.0f, 4, 8, 4);
		body13.setPos(-2.0f, 14.0f, 1.0f);
		body13.setTexSize(64, 64);
		body13.mirror = true;
		setRotation(body13, 0.0f, 0.0f, -0.6108652f);
	}

	@Override
	public void renderToBuffer(MatrixStack matrix, IVertexBuilder buffer, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg1.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg4.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body4.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body5.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg6.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg5.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg8.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg7.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body6.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body7.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body8.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body9.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body10.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body11.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body12.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body13.render(matrix, buffer, light, overlay, red, green, blue, alpha);
	}

	private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
		model.xRot = x;
		model.yRot = y;
		model.zRot = z;
	}

	@Override
	public void setupAnim(MobEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		leg1.xRot = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
		leg1.yRot = 0.0f;
		leg3.xRot = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
		leg3.yRot = 0.0f;
		leg5.xRot = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
		leg5.yRot = 0.0f;
		leg7.xRot = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
		leg7.yRot = 0.0f;
		leg2.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
		leg4.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
		leg6.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
		leg8.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
	}
}
