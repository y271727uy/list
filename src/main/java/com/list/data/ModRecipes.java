package com.list.data;

import com.list.all.ModItems;
import com.list.recipe.FishPondRecipe;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.crafting.Ingredient;

public class ModRecipes {
    public static void init(RegistrateRecipeProvider provider) {
        FishPondRecipe.builder()
            .ingredient(Ingredient.of(ItemTags.PLANKS))
            .result(ModItems.BAD_ITEM.asStack())
            .time(6000)
            .save(provider);
    }
}
