package com.list.integration.jei.category;

import com.list.all.ModBlocks;
import com.list.block.TapperRecipe;
import com.list.integration.jei.ListJeiPlugin;
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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class TapperCategory extends AbstractRecipeCategory<TapperRecipe> {
    private static final int TREE_X = 20;
    private static final int TREE_Y = 34;
    private static final int TOOL_X = 63;
    private static final int TOOL_Y = 34;
    private static final int OUTPUT_X = 126;
    private static final int OUTPUT_Y = 34;

    private final IDrawable slot;

    public TapperCategory(IJeiHelpers helpers) {
        super(
            ListJeiPlugin.TAPPER,
            Component.translatable("gui.list.category.tapper"),
            helpers.getGuiHelper().createDrawableItemStack(ModBlocks.TAPPER.asStack()),
            160,
            72
        );
        this.slot = helpers.getGuiHelper().getSlotDrawable();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, TapperRecipe recipe, IFocusGroup focuses) {
        addInputSlot(builder, recipe);

        if (recipe.hasToolRequirement()) {
            ItemStack tool = TapperRecipe.parseOutput(recipe.tool);
            if (!tool.isEmpty()) {
                builder.addSlot(RecipeIngredientRole.INPUT, TOOL_X, TOOL_Y)
                    .addItemStack(tool);
            }
        }

        ItemStack output = TapperRecipe.parseOutput(recipe.output);
        if (!output.isEmpty()) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, OUTPUT_X, OUTPUT_Y)
                .addItemStack(output);
        }
    }

    @Override
    public void draw(TapperRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        slot.draw(guiGraphics, TREE_X - 1, TREE_Y - 1);
        if (recipe.hasToolRequirement()) {
            slot.draw(guiGraphics, TOOL_X - 1, TOOL_Y - 1);
        }
        slot.draw(guiGraphics, OUTPUT_X - 1, OUTPUT_Y - 1);
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, TapperRecipe recipe, IFocusGroup focuses) {
        builder.addAnimatedRecipeArrow(recipe.time)
            .setPosition(91, 34);
        builder.addText(Component.translatable("gui.list.category.tapper.time", formatTime(recipe.time)), 100, 12)
            .setPosition(20, 10);
    }

    public static boolean isDisplayable(TapperRecipe recipe) {
        if (recipe == null || !hasDisplayableInput(recipe)) {
            return false;
        }
        if (TapperRecipe.parseOutput(recipe.output).isEmpty()) {
            return false;
        }
        return !recipe.hasToolRequirement() || !TapperRecipe.parseOutput(recipe.tool).isEmpty();
    }

    private static void addInputSlot(IRecipeLayoutBuilder builder, TapperRecipe recipe) {
        TagKey<Item> itemTag = getItemTagInput(recipe);
        if (itemTag != null && hasItemTagEntries(itemTag)) {
            builder.addSlot(RecipeIngredientRole.INPUT, TREE_X, TREE_Y)
                .addIngredients(Ingredient.of(itemTag));
            return;
        }

        List<ItemStack> treeStacks = getInputStacks(recipe);
        if (!treeStacks.isEmpty()) {
            builder.addSlot(RecipeIngredientRole.INPUT, TREE_X, TREE_Y)
                .addItemStacks(treeStacks);
        }
    }

    private static boolean hasDisplayableInput(TapperRecipe recipe) {
        TagKey<Item> itemTag = getItemTagInput(recipe);
        if (itemTag != null && hasItemTagEntries(itemTag)) {
            return true;
        }
        return !getInputStacks(recipe).isEmpty();
    }

    private static TagKey<Item> getItemTagInput(TapperRecipe recipe) {
        if (recipe.input == null || !recipe.input.startsWith("#")) {
            return null;
        }

        ResourceLocation tagId = ResourceLocation.tryParse(recipe.input.substring(1));
        if (tagId == null) {
            return null;
        }
        return TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(), tagId);
    }

    private static boolean hasItemTagEntries(TagKey<Item> tag) {
        var tags = ForgeRegistries.ITEMS.tags();
        if (tags == null) {
            return false;
        }
        for (Item ignored : tags.getTag(tag)) {
            return true;
        }
        return false;
    }

    public static List<ItemStack> getInputStacks(TapperRecipe recipe) {
        if (recipe.input == null || recipe.input.isBlank()) {
            return List.of();
        }

        if (recipe.input.startsWith("#")) {
            ResourceLocation tagId = ResourceLocation.tryParse(recipe.input.substring(1));
            if (tagId == null) {
                return List.of();
            }
            return stacksFromBlockTag(tagId);
        }

        ResourceLocation blockId = ResourceLocation.tryParse(recipe.input);
        if (blockId == null) {
            return List.of();
        }

        Block block = ForgeRegistries.BLOCKS.getValue(blockId);
        if (block == null || block == Blocks.AIR || block.asItem() == Items.AIR) {
            return List.of();
        }
        return List.of(new ItemStack(block));
    }

    private static List<ItemStack> stacksFromBlockTag(ResourceLocation tagId) {
        var tags = ForgeRegistries.BLOCKS.tags();
        if (tags == null) {
            return List.of();
        }

        TagKey<Block> tag = TagKey.create(ForgeRegistries.BLOCKS.getRegistryKey(), tagId);
        Map<ResourceLocation, ItemStack> stacks = new LinkedHashMap<>();
        for (Block block : tags.getTag(tag)) {
            Item item = block.asItem();
            if (item == Items.AIR) {
                continue;
            }
            ResourceLocation itemId = ForgeRegistries.ITEMS.getKey(item);
            if (itemId != null) {
                stacks.putIfAbsent(itemId, new ItemStack(item));
            }
        }
        return new ArrayList<>(stacks.values());
    }

    private static String formatTime(int ticks) {
        int totalSeconds = Math.max(0, ticks / 20);
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return minutes > 0 ? minutes + "m " + seconds + "s" : seconds + "s";
    }
}
