package com.list.client.screen;

import com.list.ListMod;
import com.list.menu.ForestryGreenhouseMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

/**
 * Forestry Greenhouse GUI.
 * Background texture is 256x256, but we only blit the standard 176x166 area.
 */
public class ForestryGreenhouseScreen extends AbstractContainerScreen<ForestryGreenhouseMenu> {

    public static final ResourceLocation BACKGROUND = ListMod.rl("textures/gui/screen/greenhouse_gui.png");

    public ForestryGreenhouseScreen(ForestryGreenhouseMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 175;
        this.imageHeight = 204;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        // The texture is 256x256, and our GUI uses the top-left 176x166 like vanilla.
        guiGraphics.blit(BACKGROUND, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        // vanilla positions: title at y=6, inventory title at y=(imageHeight - 94)
        // Move inventory title down by +2.
        guiGraphics.drawString(this.font, this.title, 8, 6, 0x404040, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle, 8, this.imageHeight - 94 + 2, 0x404040, false);
    }
}

