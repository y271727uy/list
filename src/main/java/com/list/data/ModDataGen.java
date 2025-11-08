package com.list.data;

import com.tterrag.registrate.providers.ProviderType;

import static com.list.ListMod.REGISTRATE;


public class ModDataGen {
    public static void init() {
        REGISTRATE.addDataGenerator(ProviderType.LANG, ModLangs::init);
        REGISTRATE.addDataGenerator(ProviderType.ITEM_MODEL, ModModels::initItem);
    }
}
