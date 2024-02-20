package net.mcreator.copier.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.copier.world.inventory.CopierUIMenu;
import net.mcreator.copier.network.CopierUIButtonMessage;
import net.mcreator.copier.CopierMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CopierUIScreen extends AbstractContainerScreen<CopierUIMenu> {
	private final static HashMap<String, Object> guistate = CopierUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_fu_yin;

	public CopierUIScreen(CopierUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("copier:textures/screens/copier_ui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("copier:textures/screens/ui_arrow.png"), this.leftPos + 47, this.topPos + 35, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.copier.copier_ui.label_fu_yin_ji"), 6, 7, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_fu_yin = Button.builder(Component.translatable("gui.copier.copier_ui.button_fu_yin"), e -> {
			if (true) {
				CopierMod.PACKET_HANDLER.sendToServer(new CopierUIButtonMessage(0, x, y, z));
				CopierUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 92, this.topPos + 33, 35, 20).build();
		guistate.put("button:button_fu_yin", button_fu_yin);
		this.addRenderableWidget(button_fu_yin);
	}
}
