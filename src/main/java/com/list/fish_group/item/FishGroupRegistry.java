package com.list.fish_group.item;

import com.list.ListMod;
import com.list.fish_group.entity.FloatingDebrisEntity;
import com.list.fish_group.entity.OceanFishPoolEntity;
import com.list.fish_group.entity.RiverFishPoolEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class FishGroupRegistry {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ListMod.MODID);
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ListMod.MODID);

    public static final RegistryObject<Item> BAMBOO_FISHING_ROD = ITEMS.register(
            "bamboo_fishing_rod",
            () -> new FishingRodItem(new Item.Properties().stacksTo(1).durability(32))
    );

    public static final RegistryObject<Item> FLOATING_DEBRIS_ITEM = ITEMS.register(
            "floating_debris",
            () -> new FloatingPoolsItem(new Item.Properties())
    );
    // FLOATING_BOOKS item removed - feature disabled
    public static final RegistryObject<Item> RIVER_FISH_POOL_ITEM = ITEMS.register(
            "river_fish_pool",
            () -> new FloatingPoolsItem(new Item.Properties())
    );
    public static final RegistryObject<Item> OCEAN_FISH_POOL_ITEM = ITEMS.register(
            "ocean_fish_pool",
            () -> new FloatingPoolsItem(new Item.Properties())
    );

    public static final RegistryObject<EntityType<FloatingDebrisEntity>> FLOATING_DEBRIS = ENTITY_TYPES.register(
            "floating_debris",
            () -> EntityType.Builder.<FloatingDebrisEntity>of(FloatingDebrisEntity::new, MobCategory.MISC)
                    .sized(2.0F, 2.5F)
                    .build(ListMod.rl("floating_debris").toString())
    );
    // FLOATING_BOOKS entity registration removed - feature disabled
    public static final RegistryObject<EntityType<RiverFishPoolEntity>> RIVER_FISH_POOL = ENTITY_TYPES.register(
            "river_fish_pool",
            () -> EntityType.Builder.<RiverFishPoolEntity>of(RiverFishPoolEntity::new, MobCategory.MISC)
                    .sized(2.0F, 2.5F)
                    .build(ListMod.rl("river_fish_pool").toString())
    );
    public static final RegistryObject<EntityType<OceanFishPoolEntity>> OCEAN_FISH_POOL = ENTITY_TYPES.register(
            "ocean_fish_pool",
            () -> EntityType.Builder.<OceanFishPoolEntity>of(OceanFishPoolEntity::new, MobCategory.MISC)
                    .sized(2.0F, 2.5F)
                    .build(ListMod.rl("ocean_fish_pool").toString())
    );

    private FishGroupRegistry() {
    }

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
        ENTITY_TYPES.register(bus);
    }
}

