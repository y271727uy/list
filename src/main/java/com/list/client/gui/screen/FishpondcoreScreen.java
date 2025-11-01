package com.list.client.gui.screen;

import com.list.world.inventory.FishpondcoreMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.HashMap;
import java.util.Map;

public class FishpondcoreScreen extends AbstractContainerScreen<FishpondcoreMenu> {
    private final static ResourceLocation TEXTURE = new ResourceLocation("list", "textures/screens/fishpondcore.png");
    private final FishpondcoreMenu menu;

    public FishpondcoreScreen(FishpondcoreMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        this.menu = menu;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        guiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
    }
}