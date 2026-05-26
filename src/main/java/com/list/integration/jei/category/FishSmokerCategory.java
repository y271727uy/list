package com.list.integration.jei.category;

import com.list.all.ModBlocks;
import com.list.integration.jei.ListJeiPlugin;
import com.list.recipe.FishSmokerRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class FishSmokerCategory extends AbstractRecipeCategory<FishSmokerRecipe> {
    private static final int INPUT_X = 56;
    private static final int INPUT_Y = 17;
    private static final int FUEL_X = 56;
    private static final int FUEL_Y = 53;
    private static final int OUTPUT_X = 116;
    private static final int OUTPUT_Y = 35;

    private final IDrawable slot;

    public FishSmokerCategory(IJeiHelpers helpers) {
        super(
            ListJeiPlugin.FISH_SMOKER,
            Component.translatable("gui.list.category.fish_smoker"),
            helpers.getGuiHelper().createDrawableItemStack(ModBlocks.FISHSMOKER.asStack()),
            176,
            85
        );
        this.slot = helpers.getGuiHelper().getSlotDrawable();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FishSmokerRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, INPUT_X, INPUT_Y)
            .addIngredients(recipe.getIngredient());

        builder.addSlot(RecipeIngredientRole.INPUT, FUEL_X, FUEL_Y)
            .addItemStack(new ItemStack(Items.COAL))
            .addItemStack(new ItemStack(Items.CHARCOAL));

        builder.addSlot(RecipeIngredientRole.OUTPUT, OUTPUT_X, OUTPUT_Y)
            .addItemStack(recipe.getResultStack().copy());
    }

    @Override
    public void draw(FishSmokerRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        slot.draw(guiGraphics, INPUT_X - 1, INPUT_Y - 1);
        slot.draw(guiGraphics, FUEL_X - 1, FUEL_Y - 1);
        slot.draw(guiGraphics, OUTPUT_X - 1, OUTPUT_Y - 1);
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, FishSmokerRecipe recipe, IFocusGroup focuses) {
        builder.addAnimatedRecipeArrow(recipe.getFishSmokerCookingTime())
            .setPosition(81, 35);
    }
}


