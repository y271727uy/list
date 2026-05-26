package com.list.recipe;

import com.google.gson.JsonObject;
import com.list.all.ModRecipes;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.crafting.CraftingHelper;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class FishSmokerRecipe extends AbstractCookingRecipe {
    public FishSmokerRecipe(ResourceLocation id, String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
        super(ModRecipes.FISH_SMOKER_RECIPE_TYPE.get(), id, group, category, ingredient, result, experience, cookingTime);
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public ItemStack getResultStack() {
        return result;
    }

    public int getFishSmokerCookingTime() {
        return cookingTime;
    }

    public float getFishSmokerExperience() {
        return experience;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.FISH_SMOKER_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.FISH_SMOKER_RECIPE_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<FishSmokerRecipe> {
        @Override
        public FishSmokerRecipe fromJson(ResourceLocation recipeId, JsonObject serializedRecipe) {
            String group = GsonHelper.getAsString(serializedRecipe, "group", "");
            CookingBookCategory category = CookingBookCategory.MISC;
            Ingredient ingredient = Ingredient.fromJson(serializedRecipe.get("ingredient"));
            JsonObject resultJson = GsonHelper.getAsJsonObject(serializedRecipe, "result");
            ItemStack result = CraftingHelper.getItemStack(resultJson, true);
            float experience = GsonHelper.getAsFloat(serializedRecipe, "experience", 0.0F);
            int cookingTime = GsonHelper.getAsInt(serializedRecipe, "cookingtime", 200);
            return new FishSmokerRecipe(recipeId, group, category, ingredient, result, experience, cookingTime);
        }

        @Override
        public FishSmokerRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            String group = buffer.readUtf();
            CookingBookCategory category = buffer.readEnum(CookingBookCategory.class);
            Ingredient ingredient = Ingredient.fromNetwork(buffer);
            ItemStack result = buffer.readItem();
            float experience = buffer.readFloat();
            int cookingTime = buffer.readVarInt();
            return new FishSmokerRecipe(recipeId, group, category, ingredient, result, experience, cookingTime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, FishSmokerRecipe recipe) {
            buffer.writeUtf(recipe.getGroup());
            buffer.writeEnum(CookingBookCategory.MISC);
            recipe.ingredient.toNetwork(buffer);
            buffer.writeItem(recipe.result);
            buffer.writeFloat(recipe.experience);
            buffer.writeVarInt(recipe.cookingTime);
        }
    }
}




