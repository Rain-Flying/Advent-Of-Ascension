package net.tslat.aoa3.client.gui.lib;

import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.util.Mth;
import org.joml.Matrix4f;

public abstract class ScrollablePane {
	private Minecraft mc;
	protected int top;
	protected int bottom;
	protected int left;
	protected int right;
	protected int viewWidth;
	protected int viewHeight;
	protected int scrollBarHeight;
	private float currentRenderScale;

	protected float mouseX;
	protected float mouseY;
	private boolean mouseFocussed;
	protected boolean isDragging = false;

	private float mouseYPosState = -2f;
	protected float distanceScrolled;
	private float scrollFactor;

	public ScrollablePane(Minecraft mc, int top, int left, int viewHeight, int viewWidth, float renderingScale) {
		this.mc = mc;
		this.top = top;
		this.left = left;
		this.viewWidth = viewWidth;
		this.viewHeight = viewHeight;
		this.bottom = top + viewHeight;
		this.right = left + viewWidth;
		this.currentRenderScale = renderingScale;
	}

	public void render(GuiGraphics guiGraphics, float mouseX, float mouseY, float partialTicks) {
		this.mouseX = mouseX;
		this.mouseY = mouseY;
		int scrollBarWidth = 6;
		mouseFocussed = isMouseHovering();
		int paneHeight = getFullPaneHeight();
		int paneViewDiff = Math.max(0, paneHeight - viewHeight);

		if (paneViewDiff > 0)
			scrollBarHeight = (int)Mth.clamp(((float)(viewHeight * viewHeight) / (float)paneHeight), 32, viewHeight);

		if (isDragging) {
			if (mouseYPosState == -1) {
				if (mouseFocussed) {
					if (mouseX >= right - scrollBarWidth - 2 && mouseX <= right) {
						scrollFactor = -1;
						int scrollHeight = Math.max(paneHeight - viewHeight, 1);
						scrollFactor /= (float)(viewHeight - scrollBarHeight) / (float)scrollHeight;
					}
					else {
						scrollFactor = 1;
					}

					mouseYPosState = mouseY;
				}
				else {
					mouseYPosState = -2;
				}
			}
			else if (mouseYPosState >= 0) {
				distanceScrolled = distanceScrolled - (mouseY - mouseYPosState) * scrollFactor;
				mouseYPosState = mouseY;
			}
		}
		else {
			mouseYPosState = -1;
		}

		distanceScrolled = Mth.clamp(distanceScrolled, 0, paneViewDiff);
		Window mcWindow = mc.getWindow();
		float windowWidthScale = currentRenderScale * (mcWindow.getScreenWidth() / (float)mcWindow.getGuiScaledWidth());
		float windowHeightScale = currentRenderScale * (mcWindow.getScreenHeight() / (float)mcWindow.getGuiScaledHeight());

		RenderSystem.enableScissor((int)((left - 1.5) * windowWidthScale), (int)((mcWindow.getScreenHeight() / windowHeightScale - bottom - 2) * windowHeightScale), (int)((viewWidth + 3) * windowWidthScale), (int)((viewHeight + 1.5) * windowHeightScale + 2));
		drawBackground(guiGraphics);
		guiGraphics.fillGradient(left - 1, top - 1, right + 1, bottom + 1, 0, 0xC0101010, 0xD0101010);
		int newTop = top - Math.max(0, (int)distanceScrolled);
		drawPaneContents(guiGraphics, newTop, left, right, bottom, distanceScrolled, partialTicks);
		RenderSystem.disableDepthTest();

		if (paneViewDiff > 0) {
			int barTop = Math.max((int)distanceScrolled * (viewHeight - scrollBarHeight) / paneViewDiff + top, top);
			int barLeft = right - 6;
			Tesselator tess = Tesselator.getInstance();
			BufferBuilder buff = tess.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
			Matrix4f matrix4f = guiGraphics.pose().last().pose();

			RenderSystem.setShader(GameRenderer::getPositionColorShader);
			buff.addVertex(matrix4f, barLeft, bottom, 0).setUv(0, 1).setColor(0, 0, 0, 255);
			buff.addVertex(matrix4f, right + 1, bottom, 0).setUv(1, 1).setColor(0, 0, 0, 255);
			buff.addVertex(matrix4f, right + 1, top, 0).setUv(1, 0).setColor(0, 0, 0, 255);
			buff.addVertex(matrix4f, barLeft, top, 0).setUv(0, 0).setColor(0, 0, 0, 255);
			BufferUploader.drawWithShader(buff.buildOrThrow());
			buff = tess.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
			buff.addVertex(matrix4f, barLeft, barTop + scrollBarHeight, 0).setUv(0, 1).setColor(128, 128, 128, 255);
			buff.addVertex(matrix4f, right + 1, barTop + scrollBarHeight, 0).setUv(1, 1).setColor(128, 128, 128, 255);
			buff.addVertex(matrix4f, right + 1, barTop, 0).setUv(1, 0).setColor(128, 128, 128, 255);
			buff.addVertex(matrix4f, barLeft, barTop, 0).setUv(0, 0).setColor(128, 128, 128, 255);
			BufferUploader.drawWithShader(buff.buildOrThrow());
			buff = tess.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
			buff.addVertex(matrix4f, barLeft, barTop + scrollBarHeight - 1, 0).setUv(0, 1).setColor(192, 192, 192, 255);
			buff.addVertex(matrix4f, right, barTop + scrollBarHeight - 1, 0).setUv(1, 1).setColor(192, 192, 192, 255);
			buff.addVertex(matrix4f, right, barTop, 0).setUv(1, 0).setColor(192, 192, 192, 255);
			buff.addVertex(matrix4f, barLeft, barTop, 0).setUv(0, 0).setColor(192, 192, 192, 255);
			BufferUploader.drawWithShader(buff.buildOrThrow());
		}

		//RenderSystem.shadeModel(GL11.GL_FLAT);
		///RenderSystem.enableAlphaTest();
		RenderSystem.disableBlend();
		RenderSystem.disableScissor();
	}

	public void onResize(Minecraft mc, int left, int top, int viewWidth, int viewHeight) {
		this.mc = mc;
		this.top = top;
		this.left = left;
		this.viewHeight = viewHeight;
		this.viewWidth = viewWidth;
		this.bottom = top + viewHeight;
		this.right = left + viewWidth;
	}

	public boolean handleMouseClick(double mouseX, double mouseY, int button) {
		isDragging = true;

		return isMouseHovering();
	}

	public boolean handleMouseReleased(double mouseX, double mouseY, int button) {
		isDragging = false;

		return isMouseHovering();
	}

	public boolean handleMouseScroll(double mouseX, double mouseY, double scrollAmount) {
		if (!mouseFocussed)
			return false;

		if (scrollAmount != 0)
			distanceScrolled += (float)(-20 * scrollAmount);

		return isMouseHovering();
	}

	protected boolean isMouseHovering() {
		return mouseX >= left && mouseX <= right && mouseY >= top && mouseY <= bottom;
	}

	public abstract int getFullPaneHeight();

	public abstract void drawPaneContents(GuiGraphics guiGraphics, int top, int left, int right, int bottom, float scrollDistance, float partialTicks);

	public abstract void drawBackground(GuiGraphics guiGraphics);
}
