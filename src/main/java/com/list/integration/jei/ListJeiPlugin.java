package com.list.integration.jei;

import com.list.ListMod;
import com.list.all.ModBlocks;
import com.list.all.ModMenus;
import com.list.all.ModRecipes;
import com.list.integration.jei.category.FishPondCategory;
import com.list.menu.FishPondMenu;
import com.list.recipe.FishPondRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import javax.annotation.ParametersAreNonnullByDefault;

@JeiPlugin
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ListJeiPlugin implements IModPlugin {
    public static final RecipeType<FishPondRecipe> FISH_POND = RecipeType.create(ListMod.MODID, "fish_pond", FishPondRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return ListMod.rl("jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IJeiHelpers jeiHelpers = registration.getJeiHelpers();
        registration.addRecipeCategories(new FishPondCategory(jeiHelpers));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        Minecraft mc = Minecraft.getInstance();
        RecipeManager recipeManager = mc.level.getRecipeManager();
        registration.addRecipes(
            FISH_POND,
            recipeManager.getAllRecipesFor(ModRecipes.FISH_POND_RECIPE_TYPE.get())
        );
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(ModBlocks.FISHPOND_CORE, FISH_POND);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(FishPondMenu.class, ModMenus.FISH_POND.get(), FISH_POND,0, 9,12,36);
    }
}
