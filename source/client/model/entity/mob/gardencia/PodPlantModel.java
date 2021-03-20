package net.tslat.aoa3.client.model.entity.mob.gardencia;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;

public class PodPlantModel extends EntityModel<MobEntity> {
	private final ModelRenderer RearEnd;
	private final ModelRenderer Leg6;
	private final ModelRenderer Leg4;
	private final ModelRenderer Leg2;
	private final ModelRenderer Leg5;
	private final ModelRenderer Leg3;
	private final ModelRenderer Leg1;
	private final ModelRenderer RearEnd2;
	private final ModelRenderer RearEnd3;
	private final ModelRenderer RearEnd4;
	private final ModelRenderer RearEnd5;
	private final ModelRenderer RearEnd6;
	private final ModelRenderer RearEnd7;
	private final ModelRenderer RearEnd8;
	private final ModelRenderer RearEnd9;
	private final ModelRenderer RearEnd10;
	private final ModelRenderer RearEnd11;
	private final ModelRenderer RearEnd12;
	private final ModelRenderer RearEnd13;
	private final ModelRenderer RearEnd14;
	private final ModelRenderer RearEnd15;
	private final ModelRenderer RearEnd16;
	private final ModelRenderer RearEnd17;
	private final ModelRenderer RearEnd18;
	private final ModelRenderer RearEnd19;
	private final ModelRenderer RearEnd20;
	private final ModelRenderer RearEnd21;
	private final ModelRenderer RearEnd22;

	public PodPlantModel() {
		texWidth = 128;
		texHeight = 32;
		(RearEnd = new ModelRenderer(this, 26, 10)).addBox(8.0f, -8.0f, -2.0f, 2, 2, 2);
		RearEnd.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd.setTexSize(128, 32);
		RearEnd.mirror = true;
		setRotation(RearEnd, 0.0f, 0.0f, 0.0f);
		(Leg6 = new ModelRenderer(this, 18, 0)).addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2);
		Leg6.setPos(4.0f, 20.0f, 0.0f);
		Leg6.setTexSize(128, 32);
		Leg6.mirror = true;
		setRotation(Leg6, 0.0f, 0.2792527f, 0.1919862f);
		(Leg4 = new ModelRenderer(this, 18, 0)).addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2);
		Leg4.setPos(4.0f, 20.0f, 1.0f);
		Leg4.setTexSize(128, 32);
		Leg4.mirror = true;
		setRotation(Leg4, 0.0f, -0.2792527f, 0.1919862f);
		(Leg2 = new ModelRenderer(this, 18, 0)).addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2);
		Leg2.setPos(4.0f, 20.0f, 2.0f);
		Leg2.setTexSize(128, 32);
		Leg2.mirror = true;
		setRotation(Leg2, 0.0f, -0.5759587f, 0.1919862f);
		(Leg5 = new ModelRenderer(this, 18, 0)).addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2);
		Leg5.setPos(-4.0f, 20.0f, 0.0f);
		Leg5.setTexSize(128, 32);
		Leg5.mirror = true;
		setRotation(Leg5, 0.0f, -0.2792527f, -0.1919862f);
		(Leg3 = new ModelRenderer(this, 18, 0)).addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2);
		Leg3.setPos(-4.0f, 20.0f, 1.0f);
		Leg3.setTexSize(128, 32);
		Leg3.mirror = true;
		setRotation(Leg3, 0.0f, 0.2792527f, -0.1919862f);
		(Leg1 = new ModelRenderer(this, 18, 0)).addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2);
		Leg1.setPos(-4.0f, 20.0f, 2.0f);
		Leg1.setTexSize(128, 32);
		Leg1.mirror = true;
		setRotation(Leg1, 0.0f, 0.5759587f, -0.1919862f);
		(RearEnd2 = new ModelRenderer(this, 46, 13)).addBox(-5.0f, 3.0f, -2.0f, 10, 1, 6);
		RearEnd2.setPos(0.0f, 18.0f, 2.0f);
		RearEnd2.setTexSize(128, 32);
		RearEnd2.mirror = true;
		setRotation(RearEnd2, 0.0f, 0.0f, 0.0f);
		(RearEnd3 = new ModelRenderer(this, 26, 10)).addBox(2.0f, -8.0f, -2.0f, 2, 2, 2);
		RearEnd3.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd3.setTexSize(128, 32);
		RearEnd3.mirror = true;
		setRotation(RearEnd3, 0.0f, 0.0f, 0.0f);
		(RearEnd4 = new ModelRenderer(this, 26, 10)).addBox(-4.0f, -8.0f, -2.0f, 2, 2, 2);
		RearEnd4.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd4.setTexSize(128, 32);
		RearEnd4.mirror = true;
		setRotation(RearEnd4, 0.0f, 0.0f, 0.0f);
		(RearEnd5 = new ModelRenderer(this, 0, 15)).addBox(-5.0f, -4.0f, -6.0f, 10, 7, 10);
		RearEnd5.setPos(0.0f, 18.0f, 2.0f);
		RearEnd5.setTexSize(128, 32);
		RearEnd5.mirror = true;
		setRotation(RearEnd5, 0.0f, 0.0f, 0.0f);
		(RearEnd6 = new ModelRenderer(this, 43, 20)).addBox(-5.0f, 4.0f, -6.0f, 10, 2, 10);
		RearEnd6.setPos(0.0f, 18.0f, 2.0f);
		RearEnd6.setTexSize(128, 32);
		RearEnd6.mirror = true;
		setRotation(RearEnd6, 0.0f, 0.0f, 0.0f);
		(RearEnd7 = new ModelRenderer(this, 74, 0)).addBox(-13.0f, 0.0f, -1.5f, 8, 5, 1);
		RearEnd7.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd7.setTexSize(128, 32);
		RearEnd7.mirror = true;
		setRotation(RearEnd7, 0.0f, 0.0f, 0.0f);
		(RearEnd8 = new ModelRenderer(this, 0, 7)).addBox(2.0f, -4.0f, -2.0f, 2, 7, 2);
		RearEnd8.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd8.setTexSize(128, 32);
		RearEnd8.mirror = true;
		setRotation(RearEnd8, 0.0f, 0.0f, 0.0f);
		(RearEnd9 = new ModelRenderer(this, 95, 0)).addBox(11.0f, 0.0f, -1.5f, 8, 5, 1);
		RearEnd9.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd9.setTexSize(128, 32);
		RearEnd9.mirror = true;
		setRotation(RearEnd9, 0.0f, 0.0f, 0.0f);
		(RearEnd10 = new ModelRenderer(this, 10, 10)).addBox(-4.0f, -6.0f, -1.0f, 2, 2, 2);
		RearEnd10.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd10.setTexSize(128, 32);
		RearEnd10.mirror = true;
		setRotation(RearEnd10, 0.0f, 0.0f, 0.0f);
		(RearEnd11 = new ModelRenderer(this, 10, 10)).addBox(2.0f, -6.0f, -1.0f, 2, 2, 2);
		RearEnd11.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd11.setTexSize(128, 32);
		RearEnd11.mirror = true;
		setRotation(RearEnd11, 0.0f, 0.0f, 0.0f);
		(RearEnd12 = new ModelRenderer(this, 10, 10)).addBox(8.0f, -6.0f, -1.0f, 2, 2, 2);
		RearEnd12.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd12.setTexSize(128, 32);
		RearEnd12.mirror = true;
		setRotation(RearEnd12, 0.0f, 0.0f, 0.0f);
		(RearEnd13 = new ModelRenderer(this, 26, 10)).addBox(-6.0f, -6.0f, -2.0f, 2, 2, 2);
		RearEnd13.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd13.setTexSize(128, 32);
		RearEnd13.mirror = true;
		setRotation(RearEnd13, 0.0f, 0.0f, 0.0f);
		(RearEnd14 = new ModelRenderer(this, 26, 10)).addBox(0.0f, -6.0f, -2.0f, 2, 2, 2);
		RearEnd14.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd14.setTexSize(128, 32);
		RearEnd14.mirror = true;
		setRotation(RearEnd14, 0.0f, 0.0f, 0.0f);
		(RearEnd15 = new ModelRenderer(this, 26, 10)).addBox(6.0f, -6.0f, -2.0f, 2, 2, 2);
		RearEnd15.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd15.setTexSize(128, 32);
		RearEnd15.mirror = true;
		setRotation(RearEnd15, 0.0f, 0.0f, 0.0f);
		(RearEnd16 = new ModelRenderer(this, 26, 10)).addBox(-2.0f, -6.0f, -2.0f, 2, 2, 2);
		RearEnd16.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd16.setTexSize(128, 32);
		RearEnd16.mirror = true;
		setRotation(RearEnd16, 0.0f, 0.0f, 0.0f);
		(RearEnd17 = new ModelRenderer(this, 26, 10)).addBox(4.0f, -6.0f, -2.0f, 2, 2, 2);
		RearEnd17.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd17.setTexSize(128, 32);
		RearEnd17.mirror = true;
		setRotation(RearEnd17, 0.0f, 0.0f, 0.0f);
		(RearEnd18 = new ModelRenderer(this, 26, 10)).addBox(10.0f, -6.0f, -2.0f, 2, 2, 2);
		RearEnd18.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd18.setTexSize(128, 32);
		RearEnd18.mirror = true;
		setRotation(RearEnd18, 0.0f, 0.0f, 0.0f);
		(RearEnd19 = new ModelRenderer(this, 0, 7)).addBox(8.0f, -4.0f, -2.0f, 2, 7, 2);
		RearEnd19.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd19.setTexSize(128, 32);
		RearEnd19.mirror = true;
		setRotation(RearEnd19, 0.0f, 0.0f, 0.0f);
		(RearEnd20 = new ModelRenderer(this, 0, 7)).addBox(-4.0f, -4.0f, -2.0f, 2, 7, 2);
		RearEnd20.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd20.setTexSize(128, 32);
		RearEnd20.mirror = true;
		setRotation(RearEnd20, 0.0f, 0.0f, 0.0f);
		(RearEnd21 = new ModelRenderer(this, 56, 0)).addBox(8.0f, 1.0f, -2.5f, 5, 3, 3);
		RearEnd21.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd21.setTexSize(128, 32);
		RearEnd21.mirror = true;
		setRotation(RearEnd21, 0.0f, 0.0f, 0.0f);
		(RearEnd22 = new ModelRenderer(this, 56, 0)).addBox(-7.0f, 1.0f, -2.5f, 5, 3, 3);
		RearEnd22.setPos(-3.0f, 13.0f, 2.0f);
		RearEnd22.setTexSize(128, 32);
		RearEnd22.mirror = true;
		setRotation(RearEnd22, 0.0f, 0.0f, 0.0f);
	}

	@Override
	public void renderToBuffer(MatrixStack matrix, IVertexBuilder buffer, int light, int overlay, float red, float green, float blue, float alpha) {
		RearEnd.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		Leg6.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		Leg4.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		Leg2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		Leg5.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		Leg3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		Leg1.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd4.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd5.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd6.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd7.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd8.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd9.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd10.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd11.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd12.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd13.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd14.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd15.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd16.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd17.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd18.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd19.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd20.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd21.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		RearEnd22.render(matrix, buffer, light, overlay, red, green, blue, alpha);
	}

	private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
		model.xRot = x;
		model.yRot = y;
		model.zRot = z;
	}

	@Override
	public void setupAnim(MobEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		final float var8 = 0.7853982f;
		Leg1.zRot = -var8;
		Leg2.zRot = var8;
		Leg3.zRot = -var8 * 0.74f;
		Leg4.zRot = var8 * 0.74f;
		Leg5.zRot = -var8 * 0.74f;
		Leg6.zRot = var8 * 0.74f;
		final float var9 = -0.0f;
		final float var10 = 0.3926991f;
		Leg1.yRot = var10 * 2.0f + var9;
		Leg2.yRot = -var10 * 2.0f - var9;
		Leg3.yRot = var10 * 1.0f + var9;
		Leg4.yRot = -var10 * 1.0f - var9;
		Leg5.yRot = -var10 * 1.0f + var9;
		Leg6.yRot = var10 * 1.0f - var9;
		final float var11 = -(MathHelper.cos(limbSwing * 0.6662f * 2.0f + 0.0f) * 0.4f) * limbSwingAmount;
		final float var12 = -(MathHelper.cos(limbSwing * 0.6662f * 2.0f + 3.1415927f) * 0.4f) * limbSwingAmount;
		final float var13 = -(MathHelper.cos(limbSwing * 0.6662f * 2.0f + 1.5707964f) * 0.4f) * limbSwingAmount;
		final float var14 = -(MathHelper.cos(limbSwing * 0.6662f * 2.0f + 4.712389f) * 0.4f) * limbSwingAmount;
		final float var15 = Math.abs(MathHelper.sin(limbSwing * 0.6662f + 0.0f) * 0.4f) * limbSwingAmount;
		final float var16 = Math.abs(MathHelper.sin(limbSwing * 0.6662f + 3.1415927f) * 0.4f) * limbSwingAmount;
		final float var17 = Math.abs(MathHelper.sin(limbSwing * 0.6662f + 1.5707964f) * 0.4f) * limbSwingAmount;
		final float var18 = Math.abs(MathHelper.sin(limbSwing * 0.6662f + 4.712389f) * 0.4f) * limbSwingAmount;
		final ModelRenderer leg1 = Leg1;
		leg1.yRot += var11;
		final ModelRenderer leg2 = Leg2;
		leg2.yRot += -var11;
		final ModelRenderer leg3 = Leg3;
		leg3.yRot += var12;
		final ModelRenderer leg4 = Leg4;
		leg4.yRot += -var12;
		final ModelRenderer leg5 = Leg5;
		leg5.yRot += var13;
		final ModelRenderer leg6 = Leg6;
		leg6.yRot += -var13;
		final ModelRenderer leg7 = Leg1;
		leg7.zRot += var15;
		final ModelRenderer leg8 = Leg2;
		leg8.zRot += -var15;
		final ModelRenderer leg9 = Leg3;
		leg9.zRot += var16;
		final ModelRenderer leg10 = Leg4;
		leg10.zRot += -var16;
		final ModelRenderer leg11 = Leg5;
		leg11.zRot += var17;
		final ModelRenderer leg12 = Leg6;
		leg12.zRot += -var17;
	}
}
