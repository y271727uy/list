package com.list.integration.jei.tooltip;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Client renderer for {@link SellingBinTooltipComponent}.
 * Renders: [input]  ->  [output]
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class SellingBinClientTooltipComponent implements ClientTooltipComponent {

    private static final int SLOT_SIZE = 18;
    private static final int ARROW_W = 16;

    private final ItemStack inputPreview;
    private final ItemStack output;

    public SellingBinClientTooltipComponent(SellingBinTooltipComponent component) {
        this.output = component.output().copy();

        // Choose a stable preview stack for ingredient (first matching item) so tooltip is deterministic.
        ItemStack[] items = component.input().getItems();
        if (items.length > 0) {
            this.inputPreview = items[0].copy();
        } else {
            this.inputPreview = ItemStack.EMPTY;
        }
    }

    @Override
    public int getHeight() {
        return SLOT_SIZE;
    }

    @Override
    public int getWidth(Font font) {
        return SLOT_SIZE + ARROW_W + SLOT_SIZE;
    }

    @Override
    public void renderImage(Font font, int x, int y, GuiGraphics guiGraphics) {
        // Draw item icons
        if (!inputPreview.isEmpty()) {
            guiGraphics.renderItem(inputPreview, x + 1, y + 1);
            guiGraphics.renderItemDecorations(font, inputPreview, x + 1, y + 1);
        }

        // Arrow
        int arrowX = x + SLOT_SIZE;
        int arrowY = y + 5;
        guiGraphics.drawString(font, "->", arrowX + 4, arrowY, 0xFF404040, false);

        if (!output.isEmpty()) {
            int outX = x + SLOT_SIZE + ARROW_W;
            guiGraphics.renderItem(output, outX + 1, y + 1);
            guiGraphics.renderItemDecorations(font, output, outX + 1, y + 1);
        }
    }
}


