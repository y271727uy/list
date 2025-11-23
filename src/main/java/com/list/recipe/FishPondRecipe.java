package com.list.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.list.all.ModRecipes;
import com.mojang.serialization.JsonOps;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.Util;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class FishPondRecipe implements Recipe<FishPondRecipe.RecipeInput> {

    public final ResourceLocation id;
    public final List<Ingredient> ingredients;
    public final List<ItemStack> results;
    public final int time;

    public FishPondRecipe(ResourceLocation id, List<Ingredient> ingredients, List<ItemStack> results, int time) {
        this.id = id;
        this.ingredients = ingredients;
        this.results = results;
        this.time = time;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean matches(RecipeInput container, Level level) {
        List<Ingredient> remaining = new ArrayList<>(this.ingredients);
        for (int i = 0; i < container.getContainerSize(); i++) {
            ItemStack stack = container.getItem(i);
            if (stack.isEmpty()) continue;
            boolean matched = false;
            for (int j = 0; j < remaining.size(); j++) {
                if (remaining.get(j).test(stack)) {
                    remaining.remove(j);
                    matched = true;
                    break;
                }
            }
            if (!matched) return false;
        }
        return remaining.isEmpty();
    }

    @Override
    public ItemStack assemble(RecipeInput container, RegistryAccess registryAccess) {
        return results.get(0).copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return results.get(0);
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.FISH_POND_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.FISH_POND_RECIPE_TYPE.get();
    }

    public static class RecipeInput implements Container {

        private final NonNullList<ItemStack> input = NonNullList.withSize(9, ItemStack.EMPTY);

        public RecipeInput(List<ItemStack> list) {
            for (int i = 0; i < Math.min(list.size(), 9); i++) {
                input.set(i, list.get(i));
            }
        }

        @Override
        public int getContainerSize() {
            return 9;
        }

        @Override
        public boolean isEmpty() {
            for (ItemStack itemStack : input) {
                if (!itemStack.isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public ItemStack getItem(int slot) {
            return input.get(slot);
        }

        @Override
        public ItemStack removeItem(int slot, int amount) {
            ItemStack itemstack = ContainerHelper.removeItem(this.input, slot, amount);
            if (!itemstack.isEmpty()) {
                this.setChanged();
            }
            return itemstack;
        }

        @Override
        public ItemStack removeItemNoUpdate(int slot) {
            ItemStack itemstack = this.input.get(slot);
            if (itemstack.isEmpty()) {
                return ItemStack.EMPTY;
            } else {
                this.input.set(slot, ItemStack.EMPTY);
                return itemstack;
            }
        }

        @Override
        public void setItem(int slot, ItemStack stack) {
            this.input.set(slot, stack);
            if (!stack.isEmpty() && stack.getCount() > this.getMaxStackSize()) {
                stack.setCount(this.getMaxStackSize());
            }

            this.setChanged();
        }

        @Override
        public void setChanged() {

        }

        @Override
        public boolean stillValid(Player player) {
            return true;
        }

        @Override
        public void clearContent() {
            this.input.clear();
            this.setChanged();
        }
    }

    public static class Serializer implements RecipeSerializer<FishPondRecipe> {

        @Override
        public FishPondRecipe fromJson(ResourceLocation recipeId, JsonObject serializedRecipe) {
            JsonArray ingredientsJson = serializedRecipe.getAsJsonArray("ingredients");
            List<Ingredient> ingredients = new ArrayList<>();
            for (int i = 0; i < ingredientsJson.size(); i++) {
                ingredients.add(Ingredient.fromJson(ingredientsJson.get(i)));
            }

            JsonArray resultsJson = serializedRecipe.getAsJsonArray("results");
            List<ItemStack> results = new ArrayList<>();
            for (int i = 0; i < resultsJson.size(); i++) {
                results.add(Util.getOrThrow(ItemStack.CODEC.decode(JsonOps.INSTANCE, resultsJson.get(i)), JsonParseException::new).getFirst());
            }

            int time = serializedRecipe.get("time").getAsInt();

            return new FishPondRecipe(recipeId, ingredients, results, time);
        }

        @Override
        public FishPondRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            int ingredientCount = buffer.readInt();
            List<Ingredient> ingredients = new ArrayList<>();
            for (int i = 0; i < ingredientCount; i++) {
                ingredients.add(Ingredient.fromNetwork(buffer));
            }

            int resultCount = buffer.readInt();
            List<ItemStack> results = new ArrayList<>();
            for (int i = 0; i < resultCount; i++) {
                results.add(buffer.readItem());
            }

            int time = buffer.readInt();
            return new FishPondRecipe(recipeId, ingredients, results, time);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, FishPondRecipe recipe) {
            buffer.writeInt(recipe.ingredients.size());
            for (Ingredient ingredient : recipe.ingredients) {
                ingredient.toNetwork(buffer);
            }

            buffer.writeInt(recipe.results.size());
            for (ItemStack result : recipe.results) {
                buffer.writeItem(result);
            }

            buffer.writeInt(recipe.time);
        }
    }

    public static class Builder implements RecipeBuilder {
        private final Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();
        private final List<Ingredient> ingredients = new ArrayList<>();
        private final List<ItemStack> results = new ArrayList<>();
        private int time = 600;

        @Override
        public RecipeBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionTrigger) {
            this.advancement.addCriterion(criterionName, criterionTrigger);
            return this;
        }

        @Override
        public RecipeBuilder group(@Nullable String groupName) {
            return this;
        }

        @Override
        public Item getResult() {
            return results.get(0).getItem();
        }

        public Builder ingredient(Ingredient ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public Builder result(ItemStack result) {
            this.results.add(result);
            return this;
        }

        public Builder time(int time) {
            this.time = time;
            return this;
        }

        @Override
        public void save(Consumer<FinishedRecipe> finishedRecipeConsumer, ResourceLocation recipeId) {
            finishedRecipeConsumer.accept(new Result(recipeId, this.ingredients, this.results, this.time, this.advancement));
        }

        public record Result(
            ResourceLocation id,
            List<Ingredient> ingredients,
            List<ItemStack> results,
            int time,
            Advancement.Builder advancementBuilder
        ) implements FinishedRecipe {

            @Override
            public void serializeRecipeData(JsonObject json) {
                JsonArray ingredientsArray = new JsonArray();
                for (Ingredient ingredient : this.ingredients) {
                    ingredientsArray.add(ingredient.toJson());
                }
                json.add("ingredients", ingredientsArray);

                JsonArray resultsArray = new JsonArray();
                for (ItemStack stack : this.results) {
                    resultsArray.add(Util.getOrThrow(ItemStack.CODEC.encodeStart(JsonOps.INSTANCE, stack), JsonParseException::new));
                }
                json.add("results", resultsArray);

                json.addProperty("time", this.time);
            }

            @Override
            public ResourceLocation getId() {
                return this.id;
            }

            @Override
            public RecipeSerializer<?> getType() {
                return ModRecipes.FISH_POND_RECIPE_SERIALIZER.get();
            }

            @Override
            public JsonObject serializeAdvancement() {
                return this.advancementBuilder.serializeToJson();
            }

            @Override
            public ResourceLocation getAdvancementId() {
                return new ResourceLocation(this.id.getNamespace(), "recipes/" + this.id.getPath());
            }
        }
    }
}
