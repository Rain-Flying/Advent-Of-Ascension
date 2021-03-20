package net.tslat.aoa3.client.gui.hud.toasts;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.toasts.IToast;
import net.minecraft.client.gui.toasts.ToastGui;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.aoa3.util.NumberUtil;
import net.tslat.aoa3.util.RenderUtil;
import net.tslat.aoa3.util.StringUtil;
import net.tslat.aoa3.util.constant.Deities;

import net.minecraft.client.gui.toasts.IToast.Visibility;

public class TributeRequirementToast implements IToast {
	private static final ResourceLocation resourcesTextures = new ResourceLocation("aoa3", "textures/gui/maingui/resources.png");

	private final Deities deity;
	private final float resourceAmount;
	private final String title;
	private final String subtitle;

	public TributeRequirementToast(Deities releventDeity, int tributeRequirement) {
		this.deity = releventDeity;
		this.resourceAmount = tributeRequirement;
		this.title = LocaleUtil.getLocaleString("gui.aoatoast.tributeReq.title", TextFormatting.DARK_RED, StringUtil.toSentenceCase(releventDeity.toString()));
		this.subtitle = LocaleUtil.getLocaleString("gui.aoatoast.tributeReq.subtitle", String.valueOf(tributeRequirement));
	}

	public Deities getDeity() {
		return deity;
	}

	public float getAmountRequired() {
		return resourceAmount;
	}

	@Override
	public Visibility render(MatrixStack matrix, ToastGui toastGui, long delta) {
		toastGui.getMinecraft().getTextureManager().bind(TEXTURE);
		RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		toastGui.blit(matrix, 0, 0, 0, 0, 160, 32);
		toastGui.getMinecraft().getTextureManager().bind(resourcesTextures);
		RenderUtil.renderScaledCustomSizedTexture(matrix, 6, 6, 0, 540, 50, 50, 20, 20, 400, 590);
		toastGui.getMinecraft().font.draw(matrix, title, 30, 7, -11534256);
		toastGui.getMinecraft().font.draw(matrix, subtitle, 30, 18, NumberUtil.RGB(255, 255, 255));

		return delta >= 3000 ? Visibility.HIDE : Visibility.SHOW;
	}
}
