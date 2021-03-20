package net.tslat.aoa3.client.model.entity.mob.greckon;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;

public class HunterModel extends EntityModel<MobEntity> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer leg1;
	private final ModelRenderer connect1;
	private final ModelRenderer leg4;
	private final ModelRenderer connect2;
	private final ModelRenderer body2;
	private final ModelRenderer body3;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg1p2;
	private final ModelRenderer leg4p2;
	private final ModelRenderer leg3p2;
	private final ModelRenderer leg2p2;
	private final ModelRenderer connect4;
	private final ModelRenderer connect3;
	private final ModelRenderer head2;
	private final ModelRenderer head3;
	private final ModelRenderer head4;
	private final ModelRenderer head5;

	public HunterModel() {
		texWidth = 128;
		texHeight = 32;
		(head = new ModelRenderer(this, 50, 16)).addBox(-5.0f, -4.0f, -7.0f, 8, 16, 0);
		head.setPos(0.0f, 9.0f, -7.0f);
		head.setTexSize(128, 32);
		setRotation(head, 0.0f, 0.0f, 0.0f);
		(body = new ModelRenderer(this, 52, 8)).addBox(-1.0f, -19.0f, -3.0f, 2, 6, 2);
		body.setPos(0.0f, 3.0f, 10.0f);
		body.setTexSize(128, 32);
		setRotation(body, 1.832596f, 0.0f, 0.0f);
		(leg1 = new ModelRenderer(this, 72, 1)).addBox(-4.0f, -2.0f, -2.0f, 3, 6, 3);
		leg1.setPos(-4.0f, 2.0f, 16.0f);
		leg1.setTexSize(128, 32);
		setRotation(leg1, 0.0f, 0.0f, 0.0f);
		(connect1 = new ModelRenderer(this, 107, 1)).addBox(-2.0f, -5.0f, -2.5f, 3, 8, 4);
		connect1.setPos(-4.0f, 2.0f, 16.0f);
		connect1.setTexSize(128, 32);
		connect1.mirror = true;
		setRotation(connect1, 0.0f, 0.0f, -0.9599311f);
		(leg4 = new ModelRenderer(this, 72, 1)).addBox(-11.0f, -5.0f, -2.0f, 3, 6, 3);
		leg4.setPos(-4.0f, 5.0f, 3.0f);
		leg4.setTexSize(128, 32);
		leg4.mirror = true;
		setRotation(leg4, 0.0f, 0.0f, 0.0f);
		(connect2 = new ModelRenderer(this, 90, 1)).addBox(-3.0f, -12.0f, -2.5f, 3, 13, 4);
		connect2.setPos(-4.0f, 5.0f, 3.0f);
		connect2.setTexSize(128, 32);
		setRotation(connect2, 0.0f, 0.0f, -0.9599311f);
		(body2 = new ModelRenderer(this, 28, 8)).addBox(-4.0f, -9.0f, -3.0f, 8, 16, 3);
		body2.setPos(0.0f, 3.0f, 10.0f);
		body2.setTexSize(128, 32);
		setRotation(body2, 1.832596f, 0.0f, 0.0f);
		(body3 = new ModelRenderer(this, 72, 23)).addBox(-6.0f, -13.0f, -4.0f, 12, 4, 4);
		body3.setPos(0.0f, 3.0f, 10.0f);
		body3.setTexSize(128, 32);
		setRotation(body3, 1.832596f, 0.0f, 0.0f);
		(leg2 = new ModelRenderer(this, 66, 1)).addBox(2.0f, -2.0f, -1.0f, 1, 24, 1);
		leg2.setPos(4.0f, 2.0f, 16.0f);
		leg2.setTexSize(128, 32);
		setRotation(leg2, 0.0f, 0.0f, 0.0f);
		(leg3 = new ModelRenderer(this, 66, 1)).addBox(9.0f, -5.0f, -1.0f, 1, 24, 1);
		leg3.setPos(4.0f, 5.0f, 3.0f);
		leg3.setTexSize(128, 32);
		setRotation(leg3, 0.0f, 0.0f, 0.0f);
		(leg1p2 = new ModelRenderer(this, 66, 1)).addBox(-3.0f, -2.0f, -1.0f, 1, 24, 1);
		leg1p2.setPos(-4.0f, 2.0f, 16.0f);
		leg1p2.setTexSize(128, 32);
		setRotation(leg1p2, 0.0f, 0.0f, 0.0f);
		(leg4p2 = new ModelRenderer(this, 66, 1)).addBox(-10.0f, -5.0f, -1.0f, 1, 24, 1);
		leg4p2.setPos(-4.0f, 5.0f, 3.0f);
		leg4p2.setTexSize(128, 32);
		setRotation(leg4p2, 0.0f, 0.0f, 0.0f);
		(leg3p2 = new ModelRenderer(this, 72, 1)).addBox(8.0f, -5.0f, -2.0f, 3, 6, 3);
		leg3p2.setPos(4.0f, 5.0f, 3.0f);
		leg3p2.setTexSize(128, 32);
		leg3p2.mirror = true;
		setRotation(leg3p2, 0.0f, 0.0f, 0.0f);
		(leg2p2 = new ModelRenderer(this, 72, 1)).addBox(1.0f, -2.0f, -2.0f, 3, 6, 3);
		leg2p2.setPos(4.0f, 2.0f, 16.0f);
		leg2p2.setTexSize(128, 32);
		setRotation(leg2p2, 0.0f, 0.0f, 0.0f);
		(connect4 = new ModelRenderer(this, 90, 1)).addBox(0.0f, -12.0f, -2.5f, 3, 13, 4);
		connect4.setPos(4.0f, 5.0f, 3.0f);
		connect4.setTexSize(128, 32);
		setRotation(connect4, 0.0f, 0.0f, 0.9599311f);
		(connect3 = new ModelRenderer(this, 107, 1)).addBox(-2.0f, -5.0f, -2.5f, 3, 8, 4);
		connect3.setPos(4.0f, 2.0f, 16.0f);
		connect3.setTexSize(128, 32);
		setRotation(connect3, 0.0f, 0.0f, 0.9599311f);
		(head2 = new ModelRenderer(this, 0, 0)).addBox(-4.0f, -4.0f, -6.0f, 6, 8, 6);
		head2.setPos(0.0f, 9.0f, -7.0f);
		head2.setTexSize(128, 32);
		setRotation(head2, 0.0f, 0.0f, 0.0f);
		(head3 = new ModelRenderer(this, 0, 23)).addBox(-5.0f, -5.0f, -7.0f, 8, 1, 7);
		head3.setPos(0.0f, 9.0f, -7.0f);
		head3.setTexSize(128, 32);
		setRotation(head3, 0.0f, 0.0f, 0.0f);
		(head4 = new ModelRenderer(this, 110, 9)).addBox(-5.0f, -4.0f, -7.0f, 0, 16, 7);
		head4.setPos(0.0f, 9.0f, -7.0f);
		head4.setTexSize(128, 32);
		setRotation(head4, 0.0f, 0.0f, 0.0f);
		(head5 = new ModelRenderer(this, 110, 9)).addBox(3.0f, -4.0f, -7.0f, 0, 16, 7);
		head5.setPos(0.0f, 9.0f, -7.0f);
		head5.setTexSize(128, 32);
		setRotation(head5, 0.0f, 0.0f, 0.0f);
	}

	@Override
	public void renderToBuffer(MatrixStack matrix, IVertexBuilder buffer, int light, int overlay, float red, float green, float blue, float alpha) {
		head.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg1.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		connect1.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg4.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		connect2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		body3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg1p2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg4p2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg3p2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		leg2p2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		connect4.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		connect3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head4.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		head5.render(matrix, buffer, light, overlay, red, green, blue, alpha);
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
		leg1.xRot = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
		leg1.yRot = 0.0f;
		leg3.xRot = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
		leg3.yRot = 0.0f;
		leg1p2.xRot = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
		leg1p2.yRot = 0.0f;
		leg3p2.xRot = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
		leg3p2.yRot = 0.0f;
		leg2.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
		leg4.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
		leg2p2.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
		leg4p2.xRot = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
	}
}
