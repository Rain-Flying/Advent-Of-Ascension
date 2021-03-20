package net.tslat.aoa3.client.model.entity.mob.overworld;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;

public class FishixModel extends EntityModel<MobEntity> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;
	private final ModelRenderer head3;
	private final ModelRenderer head4;
	private final ModelRenderer head6;
	private final ModelRenderer head7;
	private final ModelRenderer leftArm2;
	private final ModelRenderer rightArm2;
	private final ModelRenderer leftArm3;
	private final ModelRenderer rightArm3;
	private final ModelRenderer head11;
	private final ModelRenderer head5;
	private final ModelRenderer head12;
	private final ModelRenderer head13;
	private final ModelRenderer head8;
	private final ModelRenderer head9;
	private final ModelRenderer head10;

	public FishixModel() {
		texWidth = 64;
		texHeight = 64;
		(head = new ModelRenderer(this, 27, 0)).addBox(0.0f, -1.0f, 0.0f, 3, 1, 4);
		head.setPos(0.0f, 4.0f, -1.0f);
		head.setTexSize(64, 64);
		head.mirror = true;
		setRotation(head, 0.0f, 0.0f, 0.0f);
		(body = new ModelRenderer(this, 20, 37)).addBox(-6.0f, 0.0f, -2.0f, 12, 17, 10);
		body.setPos(0.0f, 4.0f, -3.0f);
		body.setTexSize(64, 64);
		body.mirror = true;
		setRotation(body, 0.0f, 0.0f, 0.0f);
		(rightArm = new ModelRenderer(this, 27, 18)).addBox(-3.0f, -8.0f, -4.0f, 9, 9, 9);
		rightArm.setPos(-12.0f, 8.0f, -1.0f);
		rightArm.setTexSize(64, 64);
		rightArm.mirror = true;
		setRotation(rightArm, 0.0f, 0.0f, 0.0f);
		(leftArm = new ModelRenderer(this, 27, 18)).addBox(-5.0f, -8.0f, -4.0f, 9, 9, 9);
		leftArm.setPos(11.0f, 8.0f, -1.0f);
		leftArm.setTexSize(64, 64);
		leftArm.mirror = true;
		setRotation(leftArm, 0.0f, 0.0f, 0.0f);
		(rightLeg = new ModelRenderer(this, 0, 19)).addBox(-3.0f, 0.0f, -2.0f, 6, 8, 6);
		rightLeg.setPos(-6.0f, 16.0f, 0.0f);
		rightLeg.setTexSize(64, 64);
		rightLeg.mirror = true;
		setRotation(rightLeg, 0.0f, 0.0f, 0.0f);
		(leftLeg = new ModelRenderer(this, 0, 19)).addBox(-3.0f, 0.0f, -2.0f, 6, 8, 6);
		leftLeg.setPos(6.0f, 16.0f, 0.0f);
		leftLeg.setTexSize(64, 64);
		leftLeg.mirror = true;
		setRotation(leftLeg, 0.0f, 0.0f, 0.0f);
		(head3 = new ModelRenderer(this, 2, 4)).addBox(1.0f, -11.0f, -4.0f, 2, 2, 10);
		head3.setPos(0.0f, 4.0f, -1.0f);
		head3.setTexSize(64, 64);
		head3.mirror = true;
		setRotation(head3, 0.0f, 0.0f, 0.0f);
		(head4 = new ModelRenderer(this, 0, 35)).addBox(-4.0f, -3.0f, 2.0f, 8, 2, 4);
		head4.setPos(0.0f, 4.0f, -1.0f);
		head4.setTexSize(64, 64);
		head4.mirror = true;
		setRotation(head4, 0.0f, 0.0f, 0.0f);
		(head6 = new ModelRenderer(this, 0, 57)).addBox(-4.0f, -2.0f, -4.0f, 2, 1, 2);
		head6.setPos(0.0f, 4.0f, -1.0f);
		head6.setTexSize(64, 64);
		head6.mirror = true;
		setRotation(head6, 0.0f, 0.0f, 0.0f);
		(head7 = new ModelRenderer(this, 0, 57)).addBox(2.0f, -2.0f, -1.0f, 2, 1, 2);
		head7.setPos(0.0f, 4.0f, -1.0f);
		head7.setTexSize(64, 64);
		head7.mirror = true;
		setRotation(head7, 0.0f, 0.0f, 0.0f);
		(leftArm2 = new ModelRenderer(this, 0, 42)).addBox(1.0f, 10.0f, -2.0f, 4, 6, 6);
		leftArm2.setPos(10.0f, 8.0f, -1.0f);
		leftArm2.setTexSize(64, 64);
		leftArm2.mirror = true;
		setRotation(leftArm2, 0.0f, 0.0f, 0.0f);
		(rightArm2 = new ModelRenderer(this, 0, 42)).addBox(-3.0f, 10.0f, -2.0f, 4, 6, 6);
		rightArm2.setPos(-12.0f, 8.0f, -1.0f);
		rightArm2.setTexSize(64, 64);
		rightArm2.mirror = true;
		setRotation(rightArm2, 0.0f, 0.0f, 0.0f);
		(leftArm3 = new ModelRenderer(this, 40, 2)).addBox(-1.0f, 1.0f, -2.0f, 6, 9, 6);
		leftArm3.setPos(10.0f, 8.0f, -1.0f);
		leftArm3.setTexSize(64, 64);
		leftArm3.mirror = true;
		setRotation(leftArm3, 0.0f, 0.0f, 0.0f);
		(rightArm3 = new ModelRenderer(this, 40, 2)).addBox(-3.0f, 1.0f, -2.0f, 6, 9, 6);
		rightArm3.setPos(-12.0f, 8.0f, -1.0f);
		rightArm3.setTexSize(64, 64);
		rightArm3.mirror = true;
		setRotation(rightArm3, 0.0f, 0.0f, 0.0f);
		(head11 = new ModelRenderer(this, 0, 0)).addBox(-4.0f, -9.0f, -4.0f, 8, 6, 10);
		head11.setPos(0.0f, 4.0f, -1.0f);
		head11.setTexSize(64, 64);
		head11.mirror = true;
		setRotation(head11, 0.0f, 0.0f, 0.0f);
		(head5 = new ModelRenderer(this, 2, 4)).addBox(-3.0f, -11.0f, -4.0f, 2, 2, 10);
		head5.setPos(0.0f, 4.0f, -1.0f);
		head5.setTexSize(64, 64);
		head5.mirror = true;
		setRotation(head5, 0.0f, 0.0f, 0.0f);
		(head12 = new ModelRenderer(this, 0, 57)).addBox(2.0f, -2.0f, -4.0f, 2, 1, 2);
		head12.setPos(0.0f, 4.0f, -1.0f);
		head12.setTexSize(64, 64);
		head12.mirror = true;
		setRotation(head12, 0.0f, 0.0f, 0.0f);
		(head13 = new ModelRenderer(this, 27, 0)).addBox(-3.0f, -1.0f, 0.0f, 3, 1, 4);
		head13.setPos(0.0f, 4.0f, -1.0f);
		head13.setTexSize(64, 64);
		head13.mirror = true;
		setRotation(head13, 0.0f, 0.0f, 0.0f);
		(head8 = new ModelRenderer(this, 27, 0)).addBox(0.0f, -1.0f, -4.0f, 3, 1, 4);
		head8.setPos(0.0f, 4.0f, -1.0f);
		head8.setTexSize(64, 64);
		head8.mirror = true;
		setRotation(head8, 0.0f, 0.0f, 0.0f);
		(head9 = new ModelRenderer(this, 27, 0)).addBox(-3.0f, -1.0f, -4.0f, 3, 1, 4);
		head9.setPos(0.0f, 4.0f, -1.0f);
		head9.setTexSize(64, 64);
		head9.mirror = true;
		setRotation(head9, 0.0f, 0.0f, 0.0f);
		(head10 = new ModelRenderer(this, 0, 57)).addBox(-4.0f, -2.0f, -1.0f, 2, 1, 2);
		head10.setPos(0.0f, 4.0f, -1.0f);
		head10.setTexSize(64, 64);
		head10.mirror = true;
		setRotation(head10, 0.0f, 0.0f, 0.0f);
	}

	@Override
	public void renderToBuffer(MatrixStack matrix, IVertexBuilder buffer, int light, int overlay, float red, float green, float blue, float alpha) {
		head.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArm.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftArm.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightLeg.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftLeg.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head4.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head6.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head7.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftArm2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArm2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftArm3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArm3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head11.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head5.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head12.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head13.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head8.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head9.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head10.render(matrix, buffer, light, overlay, red, green, blue, alpha);
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
		head3.yRot = netHeadYaw / 57.295776f;
		head3.xRot = headPitch / 54.11268f;
		head4.yRot = netHeadYaw / 57.295776f;
		head4.xRot = headPitch / 54.11268f;
		head5.yRot = netHeadYaw / 57.295776f;
		head5.xRot = headPitch / 54.11268f;
		head6.yRot = netHeadYaw / 57.295776f;
		head6.xRot = headPitch / 54.11268f;
		head7.yRot = netHeadYaw / 57.295776f;
		head7.xRot = headPitch / 54.11268f;
		head8.yRot = netHeadYaw / 57.295776f;
		head8.xRot = headPitch / 54.11268f;
		head9.yRot = netHeadYaw / 57.295776f;
		head9.xRot = headPitch / 54.11268f;
		head10.yRot = netHeadYaw / 57.295776f;
		head10.xRot = headPitch / 54.11268f;
		head11.yRot = netHeadYaw / 57.295776f;
		head11.xRot = headPitch / 54.11268f;
		head12.yRot = netHeadYaw / 57.295776f;
		head12.xRot = headPitch / 54.11268f;
		head13.yRot = netHeadYaw / 57.295776f;
		head13.xRot = headPitch / 54.11268f;
		rightArm.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
		rightArm.zRot = 0.0f;
		rightArm2.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
		rightArm2.zRot = 0.0f;
		rightArm3.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
		rightArm3.zRot = 0.0f;
		leftArm.xRot = MathHelper.cos(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f;
		leftArm.zRot = 0.0f;
		leftArm2.xRot = MathHelper.cos(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f;
		leftArm2.zRot = 0.0f;
		leftArm3.xRot = MathHelper.cos(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f;
		leftArm3.zRot = 0.0f;
		rightLeg.xRot = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
		rightLeg.yRot = 0.0f;
		leftLeg.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
	}
}