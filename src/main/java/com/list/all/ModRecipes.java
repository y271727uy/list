package com.list.all;

import com.list.ListMod;
import com.list.recipe.FishPondRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    private static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, ListMod.MODID);
    private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ListMod.MODID);

    public static final RegistryObject<RecipeType<FishPondRecipe>> FISH_POND_RECIPE_TYPE = RECIPE_TYPES.register(
        "fish_pond",
        () -> RecipeType.simple(ListMod.rl("fish_pond"))
    );

    public static final RegistryObject<RecipeSerializer<FishPondRecipe>> FISH_POND_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register(
        "fish_pond",
        FishPondRecipe.Serializer::new
    );

    public static void register(IEventBus bus) {
        RECIPE_TYPES.register(bus);
        RECIPE_SERIALIZERS.register(bus);
    }
}
