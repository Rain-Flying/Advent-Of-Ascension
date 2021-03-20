package net.tslat.aoa3.client.model.entity.mob.nether;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;

public class NethengeicBeastModel extends EntityModel<MobEntity> {
	private final ModelRenderer body;
	private final ModelRenderer leg1p1;
	private final ModelRenderer leg2p1;
	private final ModelRenderer leg3p1;
	private final ModelRenderer leg4p1;
	private final ModelRenderer leg3p2;
	private final ModelRenderer leg4p2;
	private final ModelRenderer leg1p2;
	private final ModelRenderer leg2p2;
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

	public NethengeicBeastModel() {
		texWidth = 128;
		texHeight = 32;
		(body = new ModelRenderer(this, 33, 8)).addBox(-5.0f, -10.0f, -7.0f, 10, 16, 8);
		body.setPos(0.0f, 8.0f, 2.0f);
		body.setTexSize(128, 32);
		body.mirror = true;
		setRotation(body, 1.745329f, 0.0f, 0.0f);
		(leg1p1 = new ModelRenderer(this, 113, 16)).addBox(-1.6f, 5.0f, -4.0f, 3, 5, 4);
		leg1p1.setPos(-3.0f, 14.0f, 7.0f);
		leg1p1.setTexSize(128, 32);
		leg1p1.mirror = true;
		setRotation(leg1p1, 0.2094395f, 0.0f, 0.0f);
		(leg2p1 = new ModelRenderer(this, 113, 16)).addBox(-1.4f, 5.0f, -4.0f, 3, 5, 4);
		leg2p1.setPos(3.0f, 14.0f, 7.0f);
		leg2p1.setTexSize(128, 32);
		leg2p1.mirror = true;
		setRotation(leg2p1, 0.2094395f, 0.0f, 0.0f);
		(leg3p1 = new ModelRenderer(this, 97, 16)).addBox(-1.6f, 5.0f, -4.0f, 3, 4, 4);
		leg3p1.setPos(-3.0f, 15.0f, -5.0f);
		leg3p1.setTexSize(128, 32);
		leg3p1.mirror = true;
		setRotation(leg3p1, 0.2094395f, 0.0f, 0.0f);
		(leg4p1 = new ModelRenderer(this, 97, 16)).addBox(-1.4f, 5.0f, -4.0f, 3, 4, 4);
		leg4p1.setPos(3.0f, 15.0f, -5.0f);
		leg4p1.setTexSize(128, 32);
		leg4p1.mirror = true;
		setRotation(leg4p1, 0.2094395f, 0.0f, 0.0f);
		(leg3p2 = new ModelRenderer(this, 71, 16)).addBox(-2.1f, 0.0f, -2.0f, 4, 6, 4);
		leg3p2.setPos(-3.0f, 15.0f, -5.0f);
		leg3p2.setTexSize(128, 32);
		leg3p2.mirror = true;
		setRotation(leg3p2, -0.2094395f, 0.0f, 0.0f);
		(leg4p2 = new ModelRenderer(this, 71, 16)).addBox(-1.9f, 0.0f, -2.0f, 4, 6, 4);
		leg4p2.setPos(3.0f, 15.0f, -5.0f);
		leg4p2.setTexSize(128, 32);
		leg4p2.mirror = true;
		setRotation(leg4p2, -0.2094395f, 0.0f, 0.0f);
		(leg1p2 = new ModelRenderer(this, 71, 16)).addBox(-2.1f, 0.0f, -2.0f, 4, 6, 4);
		leg1p2.setPos(-3.0f, 14.0f, 7.0f);
		leg1p2.setTexSize(128, 32);
		leg1p2.mirror = true;
		setRotation(leg1p2, -0.2094395f, 0.0f, 0.0f);
		(leg2p2 = new ModelRenderer(this, 71, 16)).addBox(-1.9f, 0.0f, -2.0f, 4, 6, 4);
		leg2p2.setPos(3.0f, 14.0f, 7.0f);
		leg2p2.setTexSize(128, 32);
		leg2p2.mirror = true;
		setRotation(leg2p2, -0.2094395f, 0.0f, 0.0f);
		(head1 = new ModelRenderer(this, 71, 0)).addBox(-3.0f, -3.0f, -11.0f, 6, 5, 4);
		head1.setPos(0.0f, 12.0f, -6.0f);
		head1.setTexSize(128, 32);
		head1.mirror = true;
		setRotation(head1, 0.2268928f, 0.0f, 0.0f);
		(head2 = new ModelRenderer(this, 0, 17)).addBox(-2.0f, -1.5f, -9.0f, 4, 2, 7);
		head2.setPos(0.0f, 10.0f, -6.0f);
		head2.setTexSize(128, 32);
		head2.mirror = true;
		setRotation(head2, -0.1745329f, 0.0f, 0.0f);
		(head3 = new ModelRenderer(this, 14, 27)).addBox(-3.0f, -3.1f, -10.0f, 6, 2, 2);
		head3.setPos(0.0f, 10.0f, -6.0f);
		head3.setTexSize(128, 32);
		head3.mirror = true;
		setRotation(head3, 0.0f, 0.0f, 0.0f);
		(head4 = new ModelRenderer(this, 0, 27)).addBox(6.0f, -3.5f, -12.0f, 3, 2, 2);
		head4.setPos(0.0f, 10.0f, -6.0f);
		head4.setTexSize(128, 32);
		head4.mirror = true;
		setRotation(head4, 0.0f, 0.0f, 0.0f);
		(head5 = new ModelRenderer(this, 62, 0)).addBox(1.0f, -8.0f, -12.0f, 2, 4, 1);
		head5.setPos(0.0f, 10.0f, -6.0f);
		head5.setTexSize(128, 32);
		head5.mirror = true;
		setRotation(head5, 0.0f, 0.0f, 0.0f);
		(head6 = new ModelRenderer(this, 20, 16)).addBox(-9.0f, -3.5f, -12.0f, 3, 2, 2);
		head6.setPos(0.0f, 10.0f, -6.0f);
		head6.setTexSize(128, 32);
		head6.mirror = true;
		setRotation(head6, 0.0f, 0.0f, 0.0f);
		(head7 = new ModelRenderer(this, 94, 0)).addBox(-6.0f, -4.0f, -13.0f, 12, 3, 4);
		head7.setPos(0.0f, 10.0f, -6.0f);
		head7.setTexSize(128, 32);
		head7.mirror = true;
		setRotation(head7, 0.0f, 0.0f, 0.0f);
		(head8 = new ModelRenderer(this, 37, 0)).addBox(-12.0f, -4.0f, -12.0f, 3, 3, 3);
		head8.setPos(0.0f, 10.0f, -6.0f);
		head8.setTexSize(128, 32);
		head8.mirror = true;
		setRotation(head8, 0.0f, 0.0f, 0.0f);
		(head9 = new ModelRenderer(this, 37, 0)).addBox(9.0f, -4.0f, -12.0f, 3, 3, 3);
		head9.setPos(0.0f, 10.0f, -6.0f);
		head9.setTexSize(128, 32);
		head9.mirror = true;
		setRotation(head9, 0.0f, 0.0f, 0.0f);
		(head10 = new ModelRenderer(this, 54, 0)).addBox(4.0f, -7.0f, -12.0f, 2, 3, 1);
		head10.setPos(0.0f, 10.0f, -6.0f);
		head10.setTexSize(128, 32);
		head10.mirror = true;
		setRotation(head10, 0.0f, 0.0f, 0.0f);
		(head11 = new ModelRenderer(this, 54, 0)).addBox(-6.0f, -7.0f, -12.0f, 2, 3, 1);
		head11.setPos(0.0f, 10.0f, -6.0f);
		head11.setTexSize(128, 32);
		head11.mirror = true;
		setRotation(head11, 0.0f, 0.0f, 0.0f);
		(head12 = new ModelRenderer(this, 62, 0)).addBox(-3.0f, -8.0f, -12.0f, 2, 4, 1);
		head12.setPos(0.0f, 10.0f, -6.0f);
		head12.setTexSize(128, 32);
		head12.mirror = true;
		setRotation(head12, 0.0f, 0.0f, 0.0f);
		(head13 = new ModelRenderer(this, 0, 0)).addBox(-4.0f, -4.0f, -8.0f, 8, 7, 8);
		head13.setPos(0.0f, 12.0f, -6.0f);
		head13.setTexSize(128, 32);
		head13.mirror = true;
		setRotation(head13, 0.1745329f, 0.0f, 0.0f);
	}

	@Override
	public void renderToBuffer(MatrixStack matrix, IVertexBuilder buffer, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg1p1.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg2p1.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg3p1.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg4p1.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg3p2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg4p2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg1p2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg2p2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
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
	}

	private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
		model.xRot = x;
		model.yRot = y;
		model.zRot = z;
	}

	@Override
	public void setupAnim(MobEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		leg1p1.xRot = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount + 0.2094f;
		leg1p1.yRot = 0.2094f;
		leg1p2.xRot = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount - 0.2094f;
		leg1p2.yRot = 0.0f;
		leg3p1.xRot = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
		leg3p1.yRot = 0.2094f;
		leg3p2.xRot = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount - 0.2094f;
		leg3p2.yRot = 0.0f;
		leg2p1.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount + 0.2094f;
		leg2p2.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount - 0.2094f;
		leg4p1.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount + 0.2094f;
		leg4p2.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount - 0.2094f;
	}
}
