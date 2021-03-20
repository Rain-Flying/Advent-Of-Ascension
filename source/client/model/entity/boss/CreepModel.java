package net.tslat.aoa3.client.model.entity.boss;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;

public class CreepModel extends EntityModel<MobEntity> {
	private final ModelRenderer body;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;
	private final ModelRenderer body2;
	private final ModelRenderer body3;
	private final ModelRenderer body4;
	private final ModelRenderer body5;
	private final ModelRenderer body6;
	private final ModelRenderer body7;
	private final ModelRenderer body8;
	private final ModelRenderer body9;
	private final ModelRenderer body10;
	private final ModelRenderer body11;
	private final ModelRenderer body12;
	private final ModelRenderer body13;
	private final ModelRenderer body14;
	private final ModelRenderer body15;
	private final ModelRenderer body16;
	private final ModelRenderer body17;
	private final ModelRenderer body18;
	private final ModelRenderer rightArm2;
	private final ModelRenderer leftArm2;
	private final ModelRenderer leftArm3;
	private final ModelRenderer rightArm3;
	private final ModelRenderer leftArm4;
	private final ModelRenderer rightArm4;
	private final ModelRenderer leftArm5;
	private final ModelRenderer rightArm5;
	private final ModelRenderer leftArm6;
	private final ModelRenderer rightArm6;
	private final ModelRenderer head;

	public CreepModel() {
		texWidth = 64;
		texHeight = 64;
		(body = new ModelRenderer(this, 45, 5)).addBox(-5.0f, -1.0f, -3.0f, 1, 1, 8);
		body.setPos(9.0f, -2.0f, -1.0f);
		body.setTexSize(64, 64);
		body.mirror = true;
		setRotation(body, 0.0f, 0.0f, 0.0f);
		(rightArm = new ModelRenderer(this, 5, 38)).addBox(0.5f, -9.0f, -9.0f, 1, 1, 1);
		rightArm.setPos(-6.0f, 1.0f, 0.0f);
		rightArm.setTexSize(64, 64);
		rightArm.mirror = true;
		setRotation(rightArm, 1.047198f, 0.0f, 0.0f);
		(leftArm = new ModelRenderer(this, 5, 45)).addBox(2.5f, -9.0f, -9.0f, 1, 1, 1);
		leftArm.setPos(6.0f, 1.0f, 0.0f);
		leftArm.setTexSize(64, 64);
		leftArm.mirror = true;
		setRotation(leftArm, 1.047198f, 0.0f, 0.0f);
		(rightLeg = new ModelRenderer(this, 0, 16)).addBox(-2.0f, 0.0f, -2.0f, 4, 7, 4);
		rightLeg.setPos(-3.0f, 17.0f, 0.0f);
		rightLeg.setTexSize(64, 64);
		rightLeg.mirror = true;
		setRotation(rightLeg, 0.0f, 0.0f, 0.0f);
		(leftLeg = new ModelRenderer(this, 0, 16)).addBox(-2.0f, 0.0f, -2.0f, 4, 7, 4);
		leftLeg.setPos(3.0f, 17.0f, 0.0f);
		leftLeg.setTexSize(64, 64);
		leftLeg.mirror = true;
		setRotation(leftLeg, 0.0f, 0.0f, 0.0f);
		(body2 = new ModelRenderer(this, 16, 16)).addBox(-5.0f, 0.0f, -3.0f, 10, 19, 6);
		body2.setPos(0.0f, -2.0f, 0.0f);
		body2.setTexSize(64, 64);
		body2.mirror = true;
		setRotation(body2, 0.0f, 0.0f, 0.0f);
		(body3 = new ModelRenderer(this, 33, 5)).addBox(-5.0f, 0.0f, 4.0f, 1, 8, 1);
		body3.setPos(9.0f, -2.0f, -1.0f);
		body3.setTexSize(64, 64);
		body3.mirror = true;
		setRotation(body3, 0.0f, 0.0f, 0.0f);
		(body4 = new ModelRenderer(this, 33, 5)).addBox(-5.0f, 0.0f, -3.0f, 1, 8, 1);
		body4.setPos(9.0f, -2.0f, -1.0f);
		body4.setTexSize(64, 64);
		body4.mirror = true;
		setRotation(body4, 0.0f, 0.0f, 0.0f);
		(body5 = new ModelRenderer(this, 33, 5)).addBox(-5.0f, 0.0f, -3.0f, 1, 8, 1);
		body5.setPos(0.0f, -2.0f, -1.0f);
		body5.setTexSize(64, 64);
		body5.mirror = true;
		setRotation(body5, 0.0f, 0.0f, 0.0f);
		(body6 = new ModelRenderer(this, 45, 5)).addBox(-5.0f, -1.0f, -3.0f, 1, 1, 8);
		body6.setPos(0.0f, -2.0f, -1.0f);
		body6.setTexSize(64, 64);
		body6.mirror = true;
		setRotation(body6, 0.0f, 0.0f, 0.0f);
		(body7 = new ModelRenderer(this, 54, 35)).addBox(0.0f, -1.0f, 5.0f, 1, 1, 4);
		body7.setPos(2.0f, -3.0f, -1.0f);
		body7.setTexSize(64, 64);
		body7.mirror = true;
		setRotation(body7, 0.0f, 0.0f, 0.0f);
		(body8 = new ModelRenderer(this, 38, 5)).addBox(3.0f, 7.0f, 4.0f, 1, 1, 1);
		body8.setPos(0.0f, -2.0f, -1.0f);
		body8.setTexSize(64, 64);
		body8.mirror = true;
		setRotation(body8, 0.0f, 0.0f, 0.0f);
		(body9 = new ModelRenderer(this, 40, 48)).addBox(-5.0f, 0.0f, 4.0f, 6, 10, 6);
		body9.setPos(2.0f, -3.0f, -1.0f);
		body9.setTexSize(64, 64);
		body9.mirror = true;
		setRotation(body9, 0.0f, 0.0f, 0.0f);
		(body10 = new ModelRenderer(this, 40, 45)).addBox(-5.0f, -1.0f, 4.0f, 6, 1, 1);
		body10.setPos(2.0f, -3.0f, -1.0f);
		body10.setTexSize(64, 64);
		body10.mirror = true;
		setRotation(body10, 0.0f, 0.0f, 0.0f);
		(body11 = new ModelRenderer(this, 40, 42)).addBox(-5.0f, -1.0f, 9.0f, 6, 1, 1);
		body11.setPos(2.0f, -3.0f, -1.0f);
		body11.setTexSize(64, 64);
		body11.mirror = true;
		setRotation(body11, 0.0f, 0.0f, 0.0f);
		(body12 = new ModelRenderer(this, 54, 42)).addBox(-5.0f, -1.0f, 5.0f, 1, 1, 4);
		body12.setPos(2.0f, -3.0f, -1.0f);
		body12.setTexSize(64, 64);
		body12.mirror = true;
		setRotation(body12, 0.0f, 0.0f, 0.0f);
		(body13 = new ModelRenderer(this, 33, 5)).addBox(-5.0f, 0.0f, 4.0f, 1, 8, 1);
		body13.setPos(0.0f, -2.0f, -1.0f);
		body13.setTexSize(64, 64);
		body13.mirror = true;
		setRotation(body13, 0.0f, 0.0f, 0.0f);
		(body14 = new ModelRenderer(this, 38, 5)).addBox(3.0f, 1.0f, 4.0f, 1, 1, 1);
		body14.setPos(0.0f, -2.0f, -1.0f);
		body14.setTexSize(64, 64);
		body14.mirror = true;
		setRotation(body14, 0.0f, 0.0f, 0.0f);
		(body15 = new ModelRenderer(this, 38, 5)).addBox(3.0f, 4.0f, 4.0f, 1, 1, 1);
		body15.setPos(0.0f, -2.0f, -1.0f);
		body15.setTexSize(64, 64);
		body15.mirror = true;
		setRotation(body15, 0.0f, 0.0f, 0.0f);
		(body16 = new ModelRenderer(this, 38, 5)).addBox(-4.0f, 7.0f, 4.0f, 1, 1, 1);
		body16.setPos(0.0f, -2.0f, -1.0f);
		body16.setTexSize(64, 64);
		body16.mirror = true;
		setRotation(body16, 0.0f, 0.0f, 0.0f);
		(body17 = new ModelRenderer(this, 38, 5)).addBox(-4.0f, 4.0f, 4.0f, 1, 1, 1);
		body17.setPos(0.0f, -2.0f, -1.0f);
		body17.setTexSize(64, 64);
		body17.mirror = true;
		setRotation(body17, 0.0f, 0.0f, 0.0f);
		(body18 = new ModelRenderer(this, 38, 5)).addBox(-4.0f, 1.0f, 4.0f, 1, 1, 1);
		body18.setPos(0.0f, -2.0f, -1.0f);
		body18.setTexSize(64, 64);
		body18.mirror = true;
		setRotation(body18, 0.0f, 0.0f, 0.0f);
		(rightArm2 = new ModelRenderer(this, 48, 16)).addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4);
		rightArm2.setPos(-6.0f, 1.0f, 0.0f);
		rightArm2.setTexSize(64, 64);
		rightArm2.mirror = true;
		setRotation(rightArm2, 0.0f, 0.0f, 0.0f);
		(leftArm2 = new ModelRenderer(this, 48, 16)).addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4);
		leftArm2.setPos(6.0f, 1.0f, 0.0f);
		leftArm2.setTexSize(64, 64);
		leftArm2.mirror = true;
		setRotation(leftArm2, 0.0f, 0.0f, 0.0f);
		(leftArm3 = new ModelRenderer(this, 0, 28)).addBox(0.5f, -7.0f, -10.0f, 1, 19, 1);
		leftArm3.setPos(6.0f, 1.0f, 0.0f);
		leftArm3.setTexSize(64, 64);
		leftArm3.mirror = true;
		setRotation(leftArm3, 1.047198f, 0.0f, 0.0f);
		(rightArm3 = new ModelRenderer(this, 0, 28)).addBox(-1.5f, -7.0f, -10.0f, 1, 19, 1);
		rightArm3.setPos(-6.0f, 1.0f, 0.0f);
		rightArm3.setTexSize(64, 64);
		rightArm3.mirror = true;
		setRotation(rightArm3, 1.047198f, 0.0f, 0.0f);
		(leftArm4 = new ModelRenderer(this, 0, 57)).addBox(-0.5f, -9.0f, -11.0f, 3, 2, 3);
		leftArm4.setPos(6.0f, 1.0f, 0.0f);
		leftArm4.setTexSize(64, 64);
		leftArm4.mirror = true;
		setRotation(leftArm4, 1.047198f, 0.0f, 0.0f);
		(rightArm4 = new ModelRenderer(this, 0, 50)).addBox(-2.5f, -9.0f, -11.0f, 3, 2, 3);
		rightArm4.setPos(-6.0f, 1.0f, 0.0f);
		rightArm4.setTexSize(64, 64);
		rightArm4.mirror = true;
		setRotation(rightArm4, 1.047198f, 0.0f, 0.0f);
		(leftArm5 = new ModelRenderer(this, 5, 41)).addBox(-0.5f, -11.0f, -11.0f, 3, 2, 1);
		leftArm5.setPos(6.0f, 1.0f, 0.0f);
		leftArm5.setTexSize(64, 64);
		leftArm5.mirror = true;
		setRotation(leftArm5, 1.047198f, 0.0f, 0.0f);
		(rightArm5 = new ModelRenderer(this, 5, 34)).addBox(-2.5f, -11.0f, -11.0f, 3, 2, 1);
		rightArm5.setPos(-6.0f, 1.0f, 0.0f);
		rightArm5.setTexSize(64, 64);
		rightArm5.mirror = true;
		setRotation(rightArm5, 1.047198f, 0.0f, 0.0f);
		(leftArm6 = new ModelRenderer(this, 5, 45)).addBox(-1.5f, -9.0f, -9.0f, 1, 1, 1);
		leftArm6.setPos(6.0f, 1.0f, 0.0f);
		leftArm6.setTexSize(64, 64);
		leftArm6.mirror = true;
		setRotation(leftArm6, 1.047198f, 0.0f, 0.0f);
		(rightArm6 = new ModelRenderer(this, 5, 38)).addBox(-3.5f, -9.0f, -9.0f, 1, 1, 1);
		rightArm6.setPos(-6.0f, 1.0f, 0.0f);
		rightArm6.setTexSize(64, 64);
		rightArm6.mirror = true;
		setRotation(rightArm6, 1.047198f, 0.0f, 0.0f);
		(head = new ModelRenderer(this, 0, 0)).addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8);
		head.setPos(0.0f, 4.0f, -6.0f);
		head.setTexSize(64, 64);
		head.mirror = true;
		setRotation(head, 0.0f, 0.0f, 0.0f);
	}

	@Override
	public void renderToBuffer(MatrixStack matrix, IVertexBuilder buffer, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArm.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftArm.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightLeg.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftLeg.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body4.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body5.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body6.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body7.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body8.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body9.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body10.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body11.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body12.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body13.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body14.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body15.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body16.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body17.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body18.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArm2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftArm2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftArm3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArm3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftArm4.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArm4.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftArm5.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArm5.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftArm6.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArm6.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head.render(matrix, buffer, light, overlay, red, green, blue, alpha);
	}

	private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
		model.xRot = x;
		model.yRot = y;
		model.zRot = z;
	}

	@Override
	public void setupAnim(MobEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		head.yRot = netHeadYaw / 57.295776f;
		head.xRot = headPitch / 54.11268f;
		rightArm.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f + 1.047f;
		rightArm.zRot = 0.0f;
		rightArm2.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
		rightArm2.zRot = 0.0f;
		rightArm3.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f + 1.047f;
		rightArm3.zRot = 0.0f;
		rightArm4.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f + 1.047f;
		rightArm4.zRot = 0.0f;
		rightArm5.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f + 1.047f;
		rightArm5.zRot = 0.0f;
		rightArm6.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f + 1.047f;
		rightArm6.zRot = 0.0f;
		leftArm.xRot = MathHelper.cos(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f + 1.047f;
		leftArm.zRot = 0.0f;
		leftArm2.xRot = MathHelper.cos(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f;
		leftArm2.zRot = 0.0f;
		leftArm3.xRot = MathHelper.cos(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f + 1.047f;
		leftArm3.zRot = 0.0f;
		leftArm4.xRot = MathHelper.cos(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f + 1.047f;
		leftArm4.zRot = 0.0f;
		leftArm5.xRot = MathHelper.cos(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f + 1.047f;
		leftArm5.zRot = 0.0f;
		leftArm6.xRot = MathHelper.cos(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f + 1.047f;
		leftArm6.zRot = 0.0f;
		rightLeg.xRot = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
		rightLeg.yRot = 0.0f;
		leftLeg.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
	}
}
