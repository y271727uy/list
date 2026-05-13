package com.list.data;

import com.tterrag.registrate.providers.RegistrateItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;

public class ModModels {
    public static void initItem(RegistrateItemModelProvider provider) {
        provider.getBuilder("template_egg")
            .parent(new ModelFile.UncheckedModelFile("item/generated"))
            .texture("layer0", "item/template_egg");

        // 双层图层物品模板 - 基础层A
        provider.getBuilder("template_layered_base")
            .parent(new ModelFile.UncheckedModelFile("item/generated"));

        // 双层图层物品模板 - 覆盖层B
        provider.getBuilder("template_layered_overlay")
            .parent(new ModelFile.UncheckedModelFile("item/generated"));
    }
}
