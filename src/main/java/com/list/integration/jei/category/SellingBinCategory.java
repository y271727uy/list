package com.list.integration.jei.category;

import com.list.all.ModBlocks;
import com.list.integration.jei.ListJeiPlugin;
import com.list.integration.jei.tooltip.SellingBinTooltipComponent;
import com.list.recipe.SellingBinRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.tooltip.TooltipComponent;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SellingBinCategory extends AbstractRecipeCategory<SellingBinRecipe> {

    private static final int IN_X = 20;
    private static final int IN_Y = 25;

    private static final int OUT_X = 110;
    private static final int OUT_Y = 25;

    private final IDrawable slot;

    public SellingBinCategory(IJeiHelpers helpers) {
        super(
            ListJeiPlugin.SELLING_BIN,
            Component.translatable("gui.list.category.selling_bin"),
            helpers.getGuiHelper().createDrawableItemStack(ModBlocks.SELLING_BIN.asStack()),
            150,
            60
        );
        this.slot = helpers.getGuiHelper().getSlotDrawable();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, SellingBinRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, IN_X, IN_Y)
            .addIngredients(recipe.input);

        IRecipeSlotBuilder out = builder.addSlot(RecipeIngredientRole.OUTPUT, OUT_X, OUT_Y)
            .addItemStack(recipe.output);

        // Only SellingBin recipes have this: a graphical tooltip component.
        // Attach it to the OUTPUT slot so it shows on hover.
        out.addRichTooltipCallback((recipeSlotView, tooltip) -> {
            TooltipComponent component = new SellingBinTooltipComponent(recipe.input, recipe.output);
            tooltip.add(component);
        });
    }

    @Override
    public void draw(SellingBinRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        // slot backgrounds
        slot.draw(guiGraphics, IN_X - 1, IN_Y - 1);
        slot.draw(guiGraphics, OUT_X - 1, OUT_Y - 1);

        // simple arrow
        guiGraphics.drawString(
            net.minecraft.client.Minecraft.getInstance().font,
            Component.literal("->"),
            70,
            28,
            0xFF404040,
            false
        );
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, SellingBinRecipe recipe, IFocusGroup focuses) {
        // no time bar; selling bin runs on a fixed server interval.
    }
}




