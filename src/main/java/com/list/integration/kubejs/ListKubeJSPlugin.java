package com.list.integration.kubejs;

import com.list.all.ModRecipes;
import com.list.integration.kubejs.recipe.FishPondRecipeSchema;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.schema.RegisterRecipeSchemasEvent;
import dev.latvian.mods.kubejs.script.ScriptType;
import dev.latvian.mods.kubejs.util.ClassFilter;

import java.util.Objects;

public class ListKubeJSPlugin extends KubeJSPlugin {
    @Override
    public void registerClasses(ScriptType type, ClassFilter filter) {
        filter.allow("com.list.integration.kubejs.api");
    }

    @Override
    public void registerRecipeSchemas(RegisterRecipeSchemasEvent event) {
        event.register(Objects.requireNonNull(ModRecipes.FISH_POND_RECIPE_TYPE.getId()), FishPondRecipeSchema.SCHEMA);
    }
}
