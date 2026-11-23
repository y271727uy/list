package com.list.dsl;

import com.google.gson.JsonObject;
import com.list.dsl.registrate.ModOres;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

/** Writes an isolated fragment; processResources merges it into the hand-authored zh_cn.json. */
public final class OreChineseLanguageProvider implements DataProvider {
    private final PackOutput output;

    public OreChineseLanguageProvider(PackOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        JsonObject translations = new JsonObject();
        for (OreDsl.Definition definition : OreDsl.definitions()) {
            translations.addProperty(definition.block().get().getDescriptionId(), definition.chineseName());
        }
        ModOres.chineseTranslations().forEach(translations::addProperty);
        // Always write, including an empty object, so removing declarations removes stale translations.
        return DataProvider.saveStable(cache, translations,
                output.getOutputFolder().resolve("assets/list/dsl_lang/zh_cn.json"));
    }

    @Override
    public String getName() {
        return "List ore DSL Chinese translations";
    }
}
