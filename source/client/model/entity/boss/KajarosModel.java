package net.tslat.aoa3.client.model.entity.boss;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;

public class KajarosModel extends EntityModel<MobEntity> {
	private final ModelRenderer body;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;
	private final ModelRenderer body2;
	private final ModelRenderer body3;
	private final ModelRenderer body4;
	private final ModelRenderer body5;
	private final ModelRenderer body6;
	private final ModelRenderer body7;
	private final ModelRenderer head;
	private final ModelRenderer head2;
	private final ModelRenderer head3;
	private final ModelRenderer head4;
	private final ModelRenderer head5;
	private final ModelRenderer head6;
	private final ModelRenderer head7;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer rightArm2;
	private final ModelRenderer leftArm2;
	private final ModelRenderer body8;
	private final ModelRenderer rightArm3;
	private final ModelRenderer rightArm4;
	private final ModelRenderer rightArm5;
	private final ModelRenderer rightArm6;
	private final ModelRenderer rightArm7;
	private final ModelRenderer rightArm8;

	public KajarosModel() {
		texWidth = 128;
		texHeight = 64;
		(body = new ModelRenderer(this, 16, 16)).addBox(-5.0f, 0.0f, -2.0f, 10, 12, 5);
		body.setPos(0.0f, 9.0f, -1.0f);
		body.setTexSize(128, 64);
		body.mirror = true;
		setRotation(body, 0.0f, 0.0f, 0.0f);
		(rightLeg = new ModelRenderer(this, 0, 16)).addBox(-2.0f, 0.0f, -2.0f, 3, 6, 3);
		rightLeg.setPos(-2.0f, 18.0f, 0.0f);
		rightLeg.setTexSize(128, 64);
		rightLeg.mirror = true;
		setRotation(rightLeg, 0.0f, 0.0f, 0.0f);
		(leftLeg = new ModelRenderer(this, 0, 16)).addBox(-1.0f, 0.0f, -2.0f, 3, 6, 3);
		leftLeg.setPos(2.0f, 18.0f, 0.0f);
		leftLeg.setTexSize(128, 64);
		leftLeg.mirror = true;
		setRotation(leftLeg, 0.0f, 0.0f, 0.0f);
		(body2 = new ModelRenderer(this, 50, 50)).addBox(-3.0f, -3.0f, -3.5f, 6, 3, 2);
		body2.setPos(0.0f, 7.0f, 0.0f);
		body2.setTexSize(128, 64);
		body2.mirror = true;
		setRotation(body2, 0.0f, 0.0f, 0.0f);
		(body3 = new ModelRenderer(this, 1, 36)).addBox(-9.0f, -1.0f, -3.0f, 4, 2, 6);
		body3.setPos(0.0f, -5.0f, 0.0f);
		body3.setTexSize(128, 64);
		body3.mirror = true;
		setRotation(body3, 0.0f, 0.0f, 0.0f);
		(body4 = new ModelRenderer(this, 57, 16)).addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4);
		body4.setPos(0.0f, -5.0f, 0.0f);
		body4.setTexSize(128, 64);
		body4.mirror = true;
		setRotation(body4, 0.0f, 0.0f, 0.0f);
		(body5 = new ModelRenderer(this, 27, 47)).addBox(2.0f, -1.0f, -3.0f, 3, 4, 6);
		body5.setPos(0.0f, -5.0f, 0.0f);
		body5.setTexSize(128, 64);
		body5.mirror = true;
		setRotation(body5, 0.0f, 0.0f, 0.0f);
		(body6 = new ModelRenderer(this, 23, 36)).addBox(5.0f, -1.0f, -3.0f, 4, 2, 6);
		body6.setPos(0.0f, -5.0f, 0.0f);
		body6.setTexSize(128, 64);
		body6.mirror = true;
		setRotation(body6, 0.0f, 0.0f, 0.0f);
		(body7 = new ModelRenderer(this, 2, 47)).addBox(-5.0f, -1.0f, -3.0f, 3, 4, 6);
		body7.setPos(0.0f, -5.0f, 0.0f);
		body7.setTexSize(128, 64);
		body7.mirror = true;
		setRotation(body7, 0.0f, 0.0f, 0.0f);
		(head = new ModelRenderer(this, 0, 0)).addBox(-3.0f, -8.0f, -4.0f, 6, 8, 6);
		head.setPos(0.0f, -5.0f, -1.0f);
		head.setTexSize(128, 64);
		head.mirror = true;
		setRotation(head, 0.0f, 0.0f, 0.0f);
		(head2 = new ModelRenderer(this, 80, 0)).addBox(-3.0f, -9.0f, 2.0f, 6, 7, 1);
		head2.setPos(0.0f, -5.0f, -1.0f);
		head2.setTexSize(128, 64);
		head2.mirror = true;
		setRotation(head2, 0.0f, 0.0f, 0.0f);
		(head3 = new ModelRenderer(this, 119, 0)).addBox(4.0f, -11.0f, 4.0f, 1, 7, 3);
		head3.setPos(0.0f, -5.0f, -1.0f);
		head3.setTexSize(128, 64);
		head3.mirror = true;
		setRotation(head3, 0.7853982f, 0.0f, 0.0f);
		(head4 = new ModelRenderer(this, 65, 0)).addBox(3.0f, -9.0f, -3.0f, 1, 7, 6);
		head4.setPos(0.0f, -5.0f, -1.0f);
		head4.setTexSize(128, 64);
		head4.mirror = true;
		setRotation(head4, 0.0f, 0.0f, 0.0f);
		(head5 = new ModelRenderer(this, 25, 0)).addBox(-3.0f, -9.0f, -3.0f, 6, 1, 5);
		head5.setPos(0.0f, -5.0f, -1.0f);
		head5.setTexSize(128, 64);
		head5.mirror = true;
		setRotation(head5, 0.0f, 0.0f, 0.0f);
		(head6 = new ModelRenderer(this, 49, 0)).addBox(-4.0f, -9.0f, -3.0f, 1, 7, 6);
		head6.setPos(0.0f, -5.0f, -1.0f);
		head6.setTexSize(128, 64);
		head6.mirror = true;
		setRotation(head6, 0.0f, 0.0f, 0.0f);
		(head7 = new ModelRenderer(this, 109, 0)).addBox(-5.0f, -11.0f, 4.0f, 1, 7, 3);
		head7.setPos(0.0f, -5.0f, -1.0f);
		head7.setTexSize(128, 64);
		head7.mirror = true;
		setRotation(head7, 0.7853982f, 0.0f, 0.0f);
		(leftArm = new ModelRenderer(this, 117, 16)).addBox(3.0f, 7.0f, -3.0f, 1, 6, 5);
		leftArm.setPos(6.0f, -2.0f, 0.0f);
		leftArm.setTexSize(128, 64);
		leftArm.mirror = true;
		setRotation(leftArm, 0.0f, 0.0f, 0.0f);
		(rightArm = new ModelRenderer(this, 104, 16)).addBox(-4.0f, 7.0f, -3.0f, 1, 6, 5);
		rightArm.setPos(-6.0f, -2.0f, 0.0f);
		rightArm.setTexSize(128, 64);
		rightArm.mirror = true;
		setRotation(rightArm, 0.0f, 0.0f, 0.0f);
		(rightArm2 = new ModelRenderer(this, 108, 31)).addBox(-2.5f, -11.0f, -11.0f, 2, 5, 1);
		rightArm2.setPos(-6.0f, -2.0f, 0.0f);
		rightArm2.setTexSize(128, 64);
		rightArm2.mirror = true;
		setRotation(rightArm2, 0.2617994f, 0.0f, 0.0f);
		(leftArm2 = new ModelRenderer(this, 83, 16)).addBox(0.0f, -2.0f, -2.0f, 3, 16, 3);
		leftArm2.setPos(6.0f, -2.0f, 0.0f);
		leftArm2.setTexSize(128, 64);
		leftArm2.mirror = true;
		setRotation(leftArm2, 0.0f, 0.0f, 0.0f);
		(body8 = new ModelRenderer(this, 50, 39)).addBox(-5.5f, 0.0f, -3.5f, 11, 2, 6);
		body8.setPos(0.0f, 7.0f, 0.0f);
		body8.setTexSize(128, 64);
		body8.mirror = true;
		setRotation(body8, 0.0f, 0.0f, 0.0f);
		(rightArm3 = new ModelRenderer(this, 83, 16)).addBox(-3.0f, -2.0f, -2.0f, 3, 16, 3);
		rightArm3.setPos(-6.0f, -2.0f, 0.0f);
		rightArm3.setTexSize(128, 64);
		rightArm3.mirror = true;
		setRotation(rightArm3, 0.0f, 0.0f, 0.0f);
		(rightArm4 = new ModelRenderer(this, 96, 16)).addBox(-2.5f, -14.0f, -6.0f, 2, 38, 2);
		rightArm4.setPos(-6.0f, -2.0f, 0.0f);
		rightArm4.setTexSize(128, 64);
		rightArm4.mirror = true;
		setRotation(rightArm4, 0.2617994f, 0.0f, 0.0f);
		(rightArm5 = new ModelRenderer(this, 108, 31)).addBox(-2.5f, -14.0f, -7.0f, 2, 8, 1);
		rightArm5.setPos(-6.0f, -2.0f, 0.0f);
		rightArm5.setTexSize(128, 64);
		rightArm5.mirror = true;
		setRotation(rightArm5, 0.2617994f, 0.0f, 0.0f);
		(rightArm6 = new ModelRenderer(this, 108, 31)).addBox(-2.5f, -14.0f, -8.0f, 2, 7, 1);
		rightArm6.setPos(-6.0f, -2.0f, 0.0f);
		rightArm6.setTexSize(128, 64);
		rightArm6.mirror = true;
		setRotation(rightArm6, 0.2617994f, 0.0f, 0.0f);
		(rightArm7 = new ModelRenderer(this, 108, 31)).addBox(-2.5f, -13.0f, -9.0f, 2, 5, 1);
		rightArm7.setPos(-6.0f, -2.0f, 0.0f);
		rightArm7.setTexSize(128, 64);
		rightArm7.mirror = true;
		setRotation(rightArm7, 0.2617994f, 0.0f, 0.0f);
		(rightArm8 = new ModelRenderer(this, 108, 31)).addBox(-2.5f, -12.0f, -10.0f, 2, 5, 1);
		rightArm8.setPos(-6.0f, -2.0f, 0.0f);
		rightArm8.setTexSize(128, 64);
		rightArm8.mirror = true;
		setRotation(rightArm8, 0.2617994f, 0.0f, 0.0f);
	}

	@Override
	public void renderToBuffer(MatrixStack matrix, IVertexBuilder buffer, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightLeg.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftLeg.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body4.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body5.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body6.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body7.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head4.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head5.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head6.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head7.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftArm.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArm.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArm2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftArm2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body8.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArm3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArm4.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArm5.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArm6.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArm7.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArm8.render(matrix, buffer, light, overlay, red, green, blue, alpha);
	}

	private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
		model.xRot = x;
		model.yRot = y;
		model.zRot = z;
	}

	@Override
	public void setupAnim(MobEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		head.yRot = netHeadYaw / (float)(180f / Math.PI);
		head2.yRot = netHeadYaw / (float)(180f / Math.PI);
		head3.yRot = netHeadYaw / (float)(180f / Math.PI);
		head4.yRot = netHeadYaw / (float)(180f / Math.PI);
		head5.yRot = netHeadYaw / (float)(180f / Math.PI);
		head6.yRot = netHeadYaw / (float)(180f / Math.PI);
		head7.yRot = netHeadYaw / (float)(180f / Math.PI);
		rightArm.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
		rightArm.zRot = 0.0f;
		rightArm2.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f + 0.261f;
		rightArm2.zRot = 0.0f;
		rightArm3.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
		rightArm3.zRot = 0.0f;
		rightArm4.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f + 0.261f;
		rightArm4.zRot = 0.0f;
		rightArm5.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f + 0.261f;
		rightArm5.zRot = 0.0f;
		rightArm6.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f + 0.261f;
		rightArm6.zRot = 0.0f;
		rightArm7.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f + 0.261f;
		rightArm7.zRot = 0.0f;
		rightArm8.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f + 0.261f;
		rightArm8.zRot = 0.0f;
		leftArm.xRot = MathHelper.cos(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f;
		leftArm.zRot = 0.0f;
		leftArm2.xRot = MathHelper.cos(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f;
		leftArm2.zRot = 0.0f;
		rightLeg.xRot = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
		rightLeg.yRot = 0.0f;
		leftLeg.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
	}
}
