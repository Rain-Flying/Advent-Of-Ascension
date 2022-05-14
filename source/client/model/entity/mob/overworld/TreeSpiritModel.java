package net.tslat.aoa3.client.model.entity.mob.overworld;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;

public class TreeSpiritModel extends EntityModel<MobEntity> {
	private final ModelRenderer body;
	private final ModelRenderer leftArmbot;
	private final ModelRenderer rightLegtop;
	private final ModelRenderer leftLegtop;
	private final ModelRenderer rightLegbot;
	private final ModelRenderer leftLegbot;
	private final ModelRenderer leftArmtop;
	private final ModelRenderer rightArmbot;
	private final ModelRenderer rightArmtop;
	private final ModelRenderer head1;
	private final ModelRenderer head2;
	private final ModelRenderer head3;
	private final ModelRenderer head4;
	private final ModelRenderer head5;
	private final ModelRenderer head6;
	private final ModelRenderer head7;
	private final ModelRenderer head8;
	private final ModelRenderer head9;
	private final ModelRenderer head10;
	private final ModelRenderer head11;
	private final ModelRenderer head12;
	private final ModelRenderer head13;
	private final ModelRenderer head14;
	private final ModelRenderer leftArmmid;
	private final ModelRenderer rightArmmid;
	private final ModelRenderer head15;
	private final ModelRenderer head16;
	private final ModelRenderer head17;
	private final ModelRenderer head18;
	private final ModelRenderer head19;
	private final ModelRenderer head20;
	private final ModelRenderer head21;
	private final ModelRenderer head22;
	private final ModelRenderer head23;
	private final ModelRenderer head24;
	private final ModelRenderer head25;
	private final ModelRenderer head26;
	private final ModelRenderer head27;

	public TreeSpiritModel() {
		texWidth = 256;
		texHeight = 64;
		(body = new ModelRenderer(this, 94, 0)).addBox(-6.0f, 0.0f, -3.0f, 12, 16, 6);
		body.setPos(0.0f, -12.0f, 0.0f);
		body.setTexSize(256, 64);
		body.mirror = true;
		setRotation(body, 0.0f, 0.0f, 0.0f);
		(leftArmbot = new ModelRenderer(this, 134, 22)).addBox(-2.0f, 10.0f, -3.0f, 6, 12, 6);
		leftArmbot.setPos(10.0f, -8.0f, 0.0f);
		leftArmbot.setTexSize(256, 64);
		leftArmbot.mirror = true;
		setRotation(leftArmbot, 0.0f, 0.0f, 0.0f);
		(rightLegtop = new ModelRenderer(this, 72, 1)).addBox(-2.5f, 0.0f, -2.5f, 5, 8, 5);
		rightLegtop.setPos(-4.0f, 4.0f, 0.0f);
		rightLegtop.setTexSize(256, 64);
		rightLegtop.mirror = true;
		setRotation(rightLegtop, 0.0f, 0.0f, 0.0f);
		(leftLegtop = new ModelRenderer(this, 72, 1)).addBox(-2.5f, 0.0f, -2.5f, 5, 8, 5);
		leftLegtop.setPos(4.0f, 4.0f, 0.0f);
		leftLegtop.setTexSize(256, 64);
		leftLegtop.mirror = true;
		setRotation(leftLegtop, 0.0f, 0.0f, 0.0f);
		(rightLegbot = new ModelRenderer(this, 0, 16)).addBox(-3.0f, 8.0f, -3.0f, 6, 12, 6);
		rightLegbot.setPos(-4.0f, 4.0f, 0.0f);
		rightLegbot.setTexSize(256, 64);
		rightLegbot.mirror = true;
		setRotation(rightLegbot, 0.0f, 0.0f, 0.0f);
		(leftLegbot = new ModelRenderer(this, 0, 16)).addBox(-3.0f, 8.0f, -3.0f, 6, 12, 6);
		leftLegbot.setPos(4.0f, 4.0f, 0.0f);
		leftLegbot.setTexSize(256, 64);
		leftLegbot.mirror = true;
		setRotation(leftLegbot, 0.0f, 0.0f, 0.0f);
		(leftArmtop = new ModelRenderer(this, 58, 15)).addBox(-4.0f, -5.0f, -3.0f, 8, 3, 6);
		leftArmtop.setPos(10.0f, -8.0f, 0.0f);
		leftArmtop.setTexSize(256, 64);
		leftArmtop.mirror = true;
		setRotation(leftArmtop, 0.0f, 0.0f, 0.0f);
		(rightArmbot = new ModelRenderer(this, 134, 22)).addBox(-4.0f, 10.0f, -3.0f, 6, 12, 6);
		rightArmbot.setPos(-10.0f, -8.0f, 0.0f);
		rightArmbot.setTexSize(256, 64);
		rightArmbot.mirror = true;
		setRotation(rightArmbot, 0.0f, 0.0f, 0.0f);
		(rightArmtop = new ModelRenderer(this, 26, 16)).addBox(-4.0f, -5.0f, -3.0f, 8, 3, 6);
		rightArmtop.setPos(-10.0f, -8.0f, 0.0f);
		rightArmtop.setTexSize(256, 64);
		rightArmtop.mirror = true;
		setRotation(rightArmtop, 0.0f, 0.0f, 0.0f);
		(head1 = new ModelRenderer(this, 38, 0)).addBox(-4.0f, -6.0f, -4.0f, 8, 6, 8);
		head1.setPos(0.0f, -11.0f, -2.0f);
		head1.setTexSize(256, 64);
		head1.mirror = true;
		setRotation(head1, 0.0f, 0.0f, 0.0f);
		(head2 = new ModelRenderer(this, 0, 0)).addBox(-5.0f, -14.0f, -4.0f, 10, 8, 8);
		head2.setPos(0.0f, -11.0f, -2.0f);
		head2.setTexSize(256, 64);
		head2.mirror = true;
		setRotation(head2, 0.0f, 0.0f, 0.0f);
		(head3 = new ModelRenderer(this, 58, 25)).addBox(0.0f, -22.0f, 10.0f, 12, 6, 5);
		head3.setPos(0.0f, -11.0f, -2.0f);
		head3.setTexSize(256, 64);
		head3.mirror = true;
		setRotation(head3, 0.0f, 0.0f, 0.0f);
		(head4 = new ModelRenderer(this, 95, 31)).addBox(-8.0f, -30.0f, 0.0f, 8, 8, 8);
		head4.setPos(0.0f, -11.0f, -2.0f);
		head4.setTexSize(256, 64);
		head4.mirror = true;
		setRotation(head4, 0.0f, 0.0f, 0.0f);
		(head5 = new ModelRenderer(this, 95, 31)).addBox(0.0f, -30.0f, 0.0f, 8, 8, 8);
		head5.setPos(0.0f, -11.0f, -2.0f);
		head5.setTexSize(256, 64);
		head5.mirror = true;
		setRotation(head5, 0.0f, 0.0f, 0.0f);
		(head6 = new ModelRenderer(this, 90, 48)).addBox(-17.0f, -22.0f, 0.0f, 5, 6, 10);
		head6.setPos(0.0f, -11.0f, -2.0f);
		head6.setTexSize(256, 64);
		head6.mirror = true;
		setRotation(head6, 0.0f, 0.0f, 0.0f);
		(head7 = new ModelRenderer(this, 90, 48)).addBox(-17.0f, -22.0f, -10.0f, 5, 6, 10);
		head7.setPos(0.0f, -11.0f, -2.0f);
		head7.setTexSize(256, 64);
		head7.mirror = true;
		setRotation(head7, 0.0f, 0.0f, 0.0f);
		(head8 = new ModelRenderer(this, 90, 48)).addBox(12.0f, -22.0f, -10.0f, 5, 6, 10);
		head8.setPos(0.0f, -11.0f, -2.0f);
		head8.setTexSize(256, 64);
		head8.mirror = true;
		setRotation(head8, 0.0f, 0.0f, 0.0f);
		(head9 = new ModelRenderer(this, 90, 48)).addBox(12.0f, -22.0f, 0.0f, 5, 6, 10);
		head9.setPos(0.0f, -11.0f, -2.0f);
		head9.setTexSize(256, 64);
		head9.mirror = true;
		setRotation(head9, 0.0f, 0.0f, 0.0f);
		(head10 = new ModelRenderer(this, 0, 36)).addBox(-12.0f, -22.0f, -10.0f, 24, 8, 20);
		head10.setPos(0.0f, -11.0f, -2.0f);
		head10.setTexSize(256, 64);
		head10.mirror = true;
		setRotation(head10, 0.0f, 0.0f, 0.0f);
		(head11 = new ModelRenderer(this, 58, 25)).addBox(-12.0f, -22.0f, 10.0f, 12, 6, 5);
		head11.setPos(0.0f, -11.0f, -2.0f);
		head11.setTexSize(256, 64);
		head11.mirror = true;
		setRotation(head11, 0.0f, 0.0f, 0.0f);
		(head12 = new ModelRenderer(this, 58, 25)).addBox(-12.0f, -22.0f, -15.0f, 12, 6, 5);
		head12.setPos(0.0f, -11.0f, -2.0f);
		head12.setTexSize(256, 64);
		head12.mirror = true;
		setRotation(head12, 0.0f, 0.0f, 0.0f);
		(head13 = new ModelRenderer(this, 95, 31)).addBox(0.0f, -30.0f, -8.0f, 8, 8, 8);
		head13.setPos(0.0f, -11.0f, -2.0f);
		head13.setTexSize(256, 64);
		head13.mirror = true;
		setRotation(head13, 0.0f, 0.0f, 0.0f);
		(head14 = new ModelRenderer(this, 95, 31)).addBox(-8.0f, -30.0f, -8.0f, 8, 8, 8);
		head14.setPos(0.0f, -11.0f, -2.0f);
		head14.setTexSize(256, 64);
		head14.mirror = true;
		setRotation(head14, 0.0f, 0.0f, 0.0f);
		(leftArmmid = new ModelRenderer(this, 134, 2)).addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4);
		leftArmmid.setPos(10.0f, -8.0f, 0.0f);
		leftArmmid.setTexSize(256, 64);
		leftArmmid.mirror = true;
		setRotation(leftArmmid, 0.0f, 0.0f, 0.0f);
		(rightArmmid = new ModelRenderer(this, 134, 2)).addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4);
		rightArmmid.setPos(-10.0f, -8.0f, 0.0f);
		rightArmmid.setTexSize(256, 64);
		rightArmmid.mirror = true;
		setRotation(rightArmmid, 0.0f, 0.0f, 0.0f);
		(head15 = new ModelRenderer(this, 58, 25)).addBox(0.0f, -22.0f, -15.0f, 12, 6, 5);
		head15.setPos(0.0f, -11.0f, -2.0f);
		head15.setTexSize(256, 64);
		head15.mirror = true;
		setRotation(head15, 0.0f, 0.0f, 0.0f);
		(head16 = new ModelRenderer(this, 207, 24)).addBox(-12.0f, -16.0f, 10.0f, 0, 20, 5);
		head16.setPos(0.0f, -11.0f, -2.0f);
		head16.setTexSize(256, 64);
		head16.mirror = true;
		setRotation(head16, 0.0f, 0.0f, 0.0f);
		(head17 = new ModelRenderer(this, 160, 1)).addBox(-12.0f, -16.0f, -15.0f, 24, 20, 0);
		head17.setPos(0.0f, -11.0f, -2.0f);
		head17.setTexSize(256, 64);
		head17.mirror = true;
		setRotation(head17, 0.0f, 0.0f, 0.0f);
		(head18 = new ModelRenderer(this, 160, 24)).addBox(-17.0f, -16.0f, -10.0f, 0, 20, 20);
		head18.setPos(0.0f, -11.0f, -2.0f);
		head18.setTexSize(256, 64);
		head18.mirror = true;
		setRotation(head18, 0.0f, 0.0f, 0.0f);
		(head19 = new ModelRenderer(this, 160, 1)).addBox(-12.0f, -16.0f, 15.0f, 24, 20, 0);
		head19.setPos(0.0f, -11.0f, -2.0f);
		head19.setTexSize(256, 64);
		head19.mirror = true;
		setRotation(head19, 0.0f, 0.0f, 0.0f);
		(head20 = new ModelRenderer(this, 214, 1)).addBox(12.0f, -16.0f, -10.0f, 5, 20, 0);
		head20.setPos(0.0f, -11.0f, -2.0f);
		head20.setTexSize(256, 64);
		head20.mirror = true;
		setRotation(head20, 0.0f, 0.0f, 0.0f);
		(head21 = new ModelRenderer(this, 214, 1)).addBox(12.0f, -16.0f, 10.0f, 5, 20, 0);
		head21.setPos(0.0f, -11.0f, -2.0f);
		head21.setTexSize(256, 64);
		head21.mirror = true;
		setRotation(head21, 0.0f, 0.0f, 0.0f);
		(head22 = new ModelRenderer(this, 214, 1)).addBox(-17.0f, -16.0f, 10.0f, 5, 20, 0);
		head22.setPos(0.0f, -11.0f, -2.0f);
		head22.setTexSize(256, 64);
		head22.mirror = true;
		setRotation(head22, 0.0f, 0.0f, 0.0f);
		(head23 = new ModelRenderer(this, 214, 1)).addBox(-17.0f, -16.0f, -10.0f, 5, 20, 0);
		head23.setPos(0.0f, -11.0f, -2.0f);
		head23.setTexSize(256, 64);
		head23.mirror = true;
		setRotation(head23, 0.0f, 0.0f, 0.0f);
		(head24 = new ModelRenderer(this, 160, 24)).addBox(17.0f, -16.0f, -10.0f, 0, 20, 20);
		head24.setPos(0.0f, -11.0f, -2.0f);
		head24.setTexSize(256, 64);
		head24.mirror = true;
		setRotation(head24, 0.0f, 0.0f, 0.0f);
		(head25 = new ModelRenderer(this, 207, 24)).addBox(-12.0f, -16.0f, -15.0f, 0, 20, 5);
		head25.setPos(0.0f, -11.0f, -2.0f);
		head25.setTexSize(256, 64);
		head25.mirror = true;
		setRotation(head25, 0.0f, 0.0f, 0.0f);
		(head26 = new ModelRenderer(this, 207, 24)).addBox(12.0f, -16.0f, 10.0f, 0, 20, 5);
		head26.setPos(0.0f, -11.0f, -2.0f);
		head26.setTexSize(256, 64);
		head26.mirror = true;
		setRotation(head26, 0.0f, 0.0f, 0.0f);
		(head27 = new ModelRenderer(this, 207, 24)).addBox(12.0f, -16.0f, -15.0f, 0, 20, 5);
		head27.setPos(0.0f, -11.0f, -2.0f);
		head27.setTexSize(256, 64);
		head27.mirror = true;
		setRotation(head27, 0.0f, 0.0f, 0.0f);
	}

	@Override
	public void setupAnim(MobEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		head1.yRot = netHeadYaw / 57.295776f;
		head1.xRot = headPitch / 54.11268f;
		head2.yRot = netHeadYaw / 57.295776f;
		head2.xRot = headPitch / 54.11268f;
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
		head14.yRot = netHeadYaw / 57.295776f;
		head14.xRot = headPitch / 54.11268f;
		head15.yRot = netHeadYaw / 57.295776f;
		head15.xRot = headPitch / 54.11268f;
		head16.yRot = netHeadYaw / 57.295776f;
		head16.xRot = headPitch / 54.11268f;
		head17.yRot = netHeadYaw / 57.295776f;
		head17.xRot = headPitch / 54.11268f;
		head18.yRot = netHeadYaw / 57.295776f;
		head18.xRot = headPitch / 54.11268f;
		head19.yRot = netHeadYaw / 57.295776f;
		head19.xRot = headPitch / 54.11268f;
		head20.yRot = netHeadYaw / 57.295776f;
		head20.xRot = headPitch / 54.11268f;
		head21.yRot = netHeadYaw / 57.295776f;
		head21.xRot = headPitch / 54.11268f;
		head22.yRot = netHeadYaw / 57.295776f;
		head22.xRot = headPitch / 54.11268f;
		head23.yRot = netHeadYaw / 57.295776f;
		head23.xRot = headPitch / 54.11268f;
		head24.yRot = netHeadYaw / 57.295776f;
		head24.xRot = headPitch / 54.11268f;
		head25.yRot = netHeadYaw / 57.295776f;
		head25.xRot = headPitch / 54.11268f;
		head26.yRot = netHeadYaw / 57.295776f;
		head26.xRot = headPitch / 54.11268f;
		head27.yRot = netHeadYaw / 57.295776f;
		head27.xRot = headPitch / 54.11268f;
		rightArmtop.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
		rightArmtop.zRot = 0.0f;
		rightArmbot.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
		rightArmbot.zRot = 0.0f;
		rightArmmid.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
		rightArmmid.zRot = 0.0f;
		leftArmtop.xRot = MathHelper.cos(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f;
		leftArmtop.zRot = 0.0f;
		leftArmbot.xRot = MathHelper.cos(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f;
		leftArmbot.zRot = 0.0f;
		leftArmmid.xRot = MathHelper.cos(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f;
		leftArmmid.zRot = 0.0f;
		rightLegtop.xRot = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
		rightLegtop.yRot = 0.0f;
		rightLegbot.xRot = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
		rightLegbot.yRot = 0.0f;
		leftLegbot.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
		leftLegtop.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(MatrixStack matrix, IVertexBuilder buffer, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftArmbot.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightLegtop.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftLegtop.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightLegbot.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftLegbot.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftArmtop.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArmbot.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArmtop.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head1.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head4.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head5.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head6.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head7.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head8.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head9.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head10.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head11.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head12.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head13.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head14.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leftArmmid.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		rightArmmid.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head15.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head16.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head17.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head18.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head19.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head20.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head21.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head22.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head23.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head24.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head25.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head26.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head27.render(matrix, buffer, light, overlay, red, green, blue, alpha);
	}

	private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
		model.xRot = x;
		model.yRot = y;
		model.zRot = z;
	}
}