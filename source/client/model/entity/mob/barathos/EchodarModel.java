package net.tslat.aoa3.client.model.entity.mob.barathos;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;

public class EchodarModel extends EntityModel<MobEntity> {
	private final ModelRenderer shape1;
	private final ModelRenderer shape2;
	private final ModelRenderer shape3;
	private final ModelRenderer shape4;
	private final ModelRenderer shape5;
	private final ModelRenderer WingL;
	private final ModelRenderer WingR;
	private final ModelRenderer shape6;
	private final ModelRenderer shape7;

	public EchodarModel() {
		texWidth = 64;
		texHeight = 32;
		(shape1 = new ModelRenderer(this, 0, 14)).addBox(0.0f, 0.0f, 0.0f, 5, 2, 2);
		shape1.setPos(3.0f, 14.0f, -2.0f);
		shape1.setTexSize(64, 32);
		shape1.mirror = true;
		setRotation(shape1, 0.0f, 0.0f, 0.0f);
		(shape2 = new ModelRenderer(this, 25, 0)).addBox(0.0f, -4.0f, 0.0f, 3, 4, 2);
		shape2.setPos(2.0f, 13.0f, -3.0f);
		shape2.setTexSize(64, 32);
		shape2.mirror = true;
		setRotation(shape2, 0.0f, 0.0f, 0.0f);
		(shape3 = new ModelRenderer(this, 0, 14)).addBox(0.0f, 0.0f, 0.0f, 5, 2, 2);
		shape3.setPos(-8.0f, 14.0f, -2.0f);
		shape3.setTexSize(64, 32);
		shape3.mirror = true;
		setRotation(shape3, 0.0f, 0.0f, 0.0f);
		(shape4 = new ModelRenderer(this, 16, 16)).addBox(-1.0f, -1.0f, -2.0f, 1, 1, 4);
		shape4.setPos(-8.0f, 15.0f, -1.0f);
		shape4.setTexSize(64, 32);
		shape4.mirror = true;
		setRotation(shape4, 0.0f, 0.0f, 0.0f);
		(shape5 = new ModelRenderer(this, 16, 16)).addBox(0.0f, -1.0f, -2.0f, 1, 1, 4);
		shape5.setPos(8.0f, 15.0f, -1.0f);
		shape5.setTexSize(64, 32);
		shape5.mirror = true;
		setRotation(shape5, 0.0f, 0.0f, 0.0f);
		(WingL = new ModelRenderer(this, 0, 22)).addBox(0.0f, 0.0f, -4.0f, 9, 1, 8);
		WingL.setPos(8.0f, 15.0f, -1.0f);
		WingL.setTexSize(64, 32);
		WingL.mirror = true;
		setRotation(WingL, 0.0f, 0.0f, 0.0f);
		(WingR = new ModelRenderer(this, 0, 22)).addBox(-9.0f, 0.0f, -4.0f, 9, 1, 8);
		WingR.setPos(-8.0f, 15.0f, -1.0f);
		WingR.setTexSize(64, 32);
		WingR.mirror = true;
		setRotation(WingR, 0.0f, 0.0f, 0.0f);
		(shape6 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 6, 6);
		shape6.setPos(-3.0f, 12.0f, -4.0f);
		shape6.setTexSize(64, 32);
		shape6.mirror = true;
		setRotation(shape6, 0.0f, 0.0f, 0.0f);
		(shape7 = new ModelRenderer(this, 25, 0)).addBox(0.0f, -4.0f, 0.0f, 3, 4, 2);
		shape7.setPos(-5.0f, 13.0f, -3.0f);
		shape7.setTexSize(64, 32);
		shape7.mirror = true;
		setRotation(shape7, 0.0f, 0.0f, 0.0f);
	}

	@Override
	public void renderToBuffer(MatrixStack matrix, IVertexBuilder buffer, int light, int overlay, float red, float green, float blue, float alpha) {
		shape1.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		shape2.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		shape3.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		shape4.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		shape5.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		WingL.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		WingR.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		shape6.render(matrix, buffer, light, overlay, red, green, blue, alpha);
		shape7.render(matrix, buffer, light, overlay, red, green, blue, alpha);
	}

	private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
		model.xRot = x;
		model.yRot = y;
		model.zRot = z;
	}

	@Override
	public void setupAnim(MobEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		WingR.zRot = MathHelper.cos(ageInTicks * 0.1f) * 3.1415927f * 0.15f;
		WingL.zRot = -WingR.zRot;
	}
}
