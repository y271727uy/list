package com.list.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.list.all.ModRecipes;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class SellingBinRecipe implements Recipe<SellingBinRecipe.RecipeInput> {

    public final ResourceLocation id;
    public final Ingredient input;
    /**
     * Prototype output stack (includes NBT if provided in JSON).
     * The runtime output count is computed from base/max (if present) and then applied to a copy.
     */
    public final ItemStack output;

    /**
     * Optional: if both are present, output count is random in [base, max].
     */
    @Nullable public final Integer base;
    @Nullable public final Integer max;

    /**
     * Required marker key in JSON for future calls. Stored as-is.
     */
    public final JsonObject listMarker;

    public SellingBinRecipe(ResourceLocation id, Ingredient input, ItemStack output, @Nullable Integer base, @Nullable Integer max, JsonObject listMarker) {
        this.id = id;
        this.input = input;
        this.output = output;
        this.base = base;
        this.max = max;
        this.listMarker = listMarker;
    }

    @Override
    public boolean matches(RecipeInput container, Level level) {
        ItemStack stack = container.getItem(0);
        if (stack.isEmpty()) return false;
        return input.test(stack);
    }

    @Override
    public ItemStack assemble(RecipeInput container, RegistryAccess registryAccess) {
        // Vanilla assemble must be deterministic; return prototype copy.
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return output;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.SELLING_BIN_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.SELLING_BIN_RECIPE_TYPE.get();
    }

    public int rollOutputCount(Level level) {
        if (base == null || max == null) {
            return output.getCount();
        }
        int b = Math.max(0, base);
        int m = Math.max(b, max);
        // inclusive range
        return b + level.random.nextInt(m - b + 1);
    }

    public static class RecipeInput implements Container {
        private final List<ItemStack> stacks;

        public RecipeInput(List<ItemStack> stacks) {
            this.stacks = stacks;
        }

        @Override
        public int getContainerSize() {
            return stacks.size();
        }

        @Override
        public boolean isEmpty() {
            for (ItemStack s : stacks) {
                if (!s.isEmpty()) return false;
            }
            return true;
        }

        @Override
        public ItemStack getItem(int slot) {
            return stacks.get(slot);
        }

        @Override
        public ItemStack removeItem(int slot, int amount) {
            ItemStack removed = ContainerHelper.removeItem(stacks, slot, amount);
            setChanged();
            return removed;
        }

        @Override
        public ItemStack removeItemNoUpdate(int slot) {
            ItemStack itemstack = stacks.get(slot);
            if (itemstack.isEmpty()) {
                return ItemStack.EMPTY;
            }
            stacks.set(slot, ItemStack.EMPTY);
            return itemstack;
        }

        @Override
        public void setItem(int slot, ItemStack stack) {
            stacks.set(slot, stack);
            setChanged();
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
            stacks.clear();
            setChanged();
        }
    }

    public static class Serializer implements RecipeSerializer<SellingBinRecipe> {

        @Override
        public SellingBinRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            if (!json.has("input")) {
                throw new JsonParseException("SellingBin recipe missing 'input'");
            }
            Ingredient input = Ingredient.fromJson(json.get("input"));

            if (!json.has("output")) {
                throw new JsonParseException("SellingBin recipe missing 'output'");
            }
            // Supports strict NBT definition via Forge CraftingHelper: {"item":"...","count":1,"nbt":"{...}"}
            ItemStack output = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(json, "output"), true);

            Integer base = json.has("base") ? GsonHelper.getAsInt(json, "base") : null;
            Integer max = json.has("max") ? GsonHelper.getAsInt(json, "max") : null;

            // key must exist; contents are not constrained for now.
            if (!json.has("list")) {
                throw new JsonParseException("SellingBin recipe missing required marker key 'list'");
            }
            JsonElement listEl = json.get("list");
            JsonObject listObj;
            if (listEl != null && listEl.isJsonObject()) {
                listObj = listEl.getAsJsonObject();
            } else {
                // allow primitive/array but still keep a marker object
                listObj = new JsonObject();
                listObj.add("value", listEl);
            }

            // If only one of base/max is provided, ignore both (as requested: optional and should not crash)
            if ((base == null) != (max == null)) {
                base = null;
                max = null;
            }

            return new SellingBinRecipe(recipeId, input, output, base, max, listObj);
        }

        @Override
        public @Nullable SellingBinRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buf) {
            Ingredient input = Ingredient.fromNetwork(buf);
            ItemStack output = buf.readItem();

            boolean hasRange = buf.readBoolean();
            Integer base = null;
            Integer max = null;
            if (hasRange) {
                base = buf.readVarInt();
                max = buf.readVarInt();
            }

            // list marker - synced as json string
            String listJson = buf.readUtf();
            JsonObject listObj = com.google.gson.JsonParser.parseString(listJson).getAsJsonObject();

            return new SellingBinRecipe(recipeId, input, output, base, max, listObj);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, SellingBinRecipe recipe) {
            recipe.input.toNetwork(buf);
            buf.writeItem(recipe.output);

            boolean hasRange = recipe.base != null && recipe.max != null;
            buf.writeBoolean(hasRange);
            if (hasRange) {
                buf.writeVarInt(recipe.base);
                buf.writeVarInt(recipe.max);
            }

            buf.writeUtf(recipe.listMarker.toString());
        }
    }
}

