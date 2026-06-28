package com.list.gameplay.fish_book;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class FishBookScreen extends AbstractContainerScreen<FishBookMenu> {
    private static final ResourceLocation BOOK_TEXTURE = ResourceLocation.tryParse("minecraft:textures/gui/book.png");
    private int currentPage;
    private Button previousButton;
    private Button nextButton;

    public FishBookScreen(FishBookMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.imageWidth = 192;
        this.imageHeight = 192;
        this.titleLabelX = -9999;
        this.inventoryLabelX = -9999;
    }

    @Override
    protected void init() {
        super.init();
        this.nextButton = this.addRenderableWidget(new PageButton(this.leftPos + 116, this.topPos + 159, true, button -> pageForward()));
        this.previousButton = this.addRenderableWidget(new PageButton(this.leftPos + 43, this.topPos + 159, false, button -> pageBack()));
        updateButtons();
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        guiGraphics.blit(BOOK_TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        List<FishBookEntry.Synced> entries = this.menu.entries();
        if (entries.isEmpty()) {
            drawCentered(guiGraphics, Component.translatable("screen.list.fish_book.empty"), this.topPos + 78, 0x3F2A14);
            return;
        }

        if (this.currentPage >= entries.size()) {
            this.currentPage = Math.max(0, entries.size() - 1);
        }

        FishBookEntry.Synced synced = entries.get(this.currentPage);
        FishBookEntry entry = synced.entry();
        int contentX = this.leftPos + 36;
        Component title = synced.unlocked()
                ? entry.item().getDescription()
                : Component.translatable("screen.list.fish_book.locked");
        drawCentered(guiGraphics, title.copy().withStyle(ChatFormatting.DARK_GRAY), this.topPos + 16, 0x3F2A14);

        if (synced.unlocked()) {
            ItemStack displayStack = new ItemStack(entry.item());
            int itemX = this.leftPos + 64;
            int itemY = this.topPos + 27;
            float itemScale = 4.0F;
            guiGraphics.pose().pushPose();
            guiGraphics.pose().translate(itemX, itemY, 100);
            guiGraphics.pose().scale(itemScale, itemScale, 1.0F);
            guiGraphics.renderItem(displayStack, 0, 0);
            guiGraphics.pose().popPose();

            int y = this.topPos + 97;
            Component noData = Component.translatable("screen.list.fish_book.no_data");
            drawLine(guiGraphics, Component.translatable("screen.list.fish_book.max_size", noData), contentX, y);
            y += 9;
            drawLine(guiGraphics, Component.translatable("screen.list.fish_book.max_weight", noData), contentX, y);
            y += 9;
            drawLine(guiGraphics, Component.translatable("screen.list.fish_book.seasons", formatValues(entry.seasonTags(), "season")), contentX, y);
            y += 9;
            drawLine(guiGraphics, Component.translatable("screen.list.fish_book.weather", formatValues(entry.weatherTags(), "weather")), contentX, y);
            y += 9;
            drawLine(guiGraphics, Component.translatable("screen.list.fish_book.time", formatValues(entry.time(), "time")), contentX, y);
            y += 9;
            drawLine(guiGraphics, Component.translatable("screen.list.fish_book.diet", formatValues(entry.diet(), "diet")), contentX, y);
            y += 9;
            drawLine(guiGraphics, Component.translatable("screen.list.fish_book.habits", formatValues(entry.habits(), "habit")), contentX, y);

            if (isMouseInside(itemX, itemY, (int) (16 * itemScale), (int) (16 * itemScale), mouseX, mouseY)) {
                guiGraphics.renderTooltip(this.font, displayStack, mouseX, mouseY);
            }
        } else {
            drawCentered(guiGraphics, Component.literal("???").withStyle(ChatFormatting.GRAY), this.topPos + 70, 0x5F554A);
            drawCentered(guiGraphics, Component.translatable("screen.list.fish_book.unlock_hint"), this.topPos + 104, 0x5F554A);
        }
    }

    private void pageForward() {
        if (this.currentPage < this.menu.entries().size() - 1) {
            this.currentPage++;
            updateButtons();
        }
    }

    private void pageBack() {
        if (this.currentPage > 0) {
            this.currentPage--;
            updateButtons();
        }
    }

    private void updateButtons() {
        if (this.previousButton != null) {
            this.previousButton.visible = this.currentPage > 0;
        }
        if (this.nextButton != null) {
            this.nextButton.visible = this.currentPage < this.menu.entries().size() - 1;
        }
    }

    private void drawCentered(GuiGraphics guiGraphics, Component text, int y, int color) {
        guiGraphics.drawString(this.font, text, this.leftPos + (this.imageWidth - this.font.width(text)) / 2, y, color, false);
    }

    private void drawLine(GuiGraphics guiGraphics, Component text, int x, int y) {
        guiGraphics.drawString(this.font, text, x, y, 0x3F2A14, false);
    }

    private static boolean isMouseInside(int x, int y, int width, int height, int mouseX, int mouseY) {
        return mouseX >= x && mouseX < x + width && mouseY >= y && mouseY < y + height;
    }

    private static String formatRange(FishBookEntry.Range range, String unit) {
        if (!range.known()) {
            return "?";
        }
        return range.min() == range.max()
                ? range.min() + unit
                : range.min() + "-" + range.max() + unit;
    }

    private static Component formatValues(List<?> values, String category) {
        if (values.isEmpty()) {
            return Component.literal("?");
        }
        List<Component> translatedValues = new ArrayList<>();
        for (Object value : values) {
            translatedValues.add(translateValue(category, value));
        }
        return joinComponents(translatedValues);
    }

    private static Component translateValue(String category, Object value) {
        String key = value instanceof ResourceLocation id ? formatId(id) : value.toString();
        return Component.translatable("screen.list.fish_book.value." + category + "." + key);
    }

    private static Component joinComponents(List<Component> values) {
        Component result = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            result = result.copy().append(Component.literal(", ")).append(values.get(i));
        }
        return result;
    }

    private static String formatIds(List<ResourceLocation> ids) {
        if (ids.isEmpty()) {
            return "?";
        }
        return ids.stream()
                .map(FishBookScreen::formatId)
                .collect(Collectors.joining(", "));
    }

    private static String formatId(ResourceLocation id) {
        String path = id.getPath();
        int slash = path.lastIndexOf('/');
        return slash >= 0 ? path.substring(slash + 1) : path;
    }

    private static final class PageButton extends Button {
        private static final int WIDTH = 23;
        private static final int HEIGHT = 13;
        private final boolean forward;

        private PageButton(int x, int y, boolean forward, OnPress onPress) {
            super(x, y, WIDTH, HEIGHT, Component.empty(), onPress, DEFAULT_NARRATION);
            this.forward = forward;
        }

        @Override
        protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
            int u = this.isHoveredOrFocused() ? WIDTH : 0;
            int v = this.forward ? 192 : 205;
            guiGraphics.blit(BOOK_TEXTURE, this.getX(), this.getY(), u, v, WIDTH, HEIGHT);
        }
    }
}
