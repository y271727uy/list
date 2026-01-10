package com.list.integration.jade;

import com.list.block.FishPondCoreBlock;
import com.list.block.entity.FishPondCoreBlockEntity;
import com.list.integration.jade.provider.FishPondProvider;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class ListJadePlugin implements IWailaPlugin {
    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerBlockDataProvider(FishPondProvider.INSTANCE, FishPondCoreBlockEntity.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(FishPondProvider.INSTANCE, FishPondCoreBlock.class);
    }
}
