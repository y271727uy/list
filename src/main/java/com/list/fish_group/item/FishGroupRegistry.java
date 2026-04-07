package com.list.fish_group.item;

import com.list.ListMod;
import com.list.fish_group.entity.AbstractFishPoolEntity;
import com.list.fish_group.entity.FloatingDebrisEntity;
import com.list.fish_group.entity.OceanFishPoolEntity;
import com.list.fish_group.entity.RiverFishPoolEntity;
import com.list.fish_group.pool.FishPoolDefinition;
import com.list.fish_group.pool.FishPoolDefinitions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class FishGroupRegistry {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ListMod.MODID);
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ListMod.MODID);
    private static final Map<ResourceLocation, FishPoolRegistration> FISH_POOL_REGISTRATIONS = new LinkedHashMap<>();

    public static final RegistryObject<Item> BAMBOO_FISHING_ROD = ITEMS.register(
            "bamboo_fishing_rod",
            () -> new FishingRodItem(new Item.Properties().stacksTo(1).durability(32))
    );

    public static final RegistryObject<Item> FLOATING_DEBRIS_ITEM = ITEMS.register(
            "floating_debris",
            () -> new FloatingPoolsItem(new Item.Properties())
    );

    public static final RegistryObject<EntityType<FloatingDebrisEntity>> FLOATING_DEBRIS = ENTITY_TYPES.register(
            "floating_debris",
            () -> EntityType.Builder.of(FloatingDebrisEntity::new, MobCategory.MISC)
                    .sized(2.0F, 2.5F)
                    .build(ListMod.rl("floating_debris").toString())
    );

    static {
        FishPoolDefinitions.getAll().forEach(FishGroupRegistry::registerFishPool);
    }

    public static final FishPoolRegistration OCEAN_FISH_POOL = getFishPoolRegistration(FishPoolDefinitions.OCEAN_FISH_POOL.id());
    public static final FishPoolRegistration COD_FISH_POOL = getFishPoolRegistration(FishPoolDefinitions.COD_FISH_POOL.id());
    public static final FishPoolRegistration RIVER_FISH_POOL = getFishPoolRegistration(FishPoolDefinitions.RIVER_FISH_POOL.id());
    public static final FishPoolRegistration SALMON_FISH_POOL = getFishPoolRegistration(FishPoolDefinitions.SALMON_FISH_POOL.id());

    private FishGroupRegistry() {
    }

    private static FishPoolRegistration registerFishPool(FishPoolDefinition definition) {
        String path = definition.id().getPath();
        RegistryObject<Item> item = ITEMS.register(path, () -> new FloatingPoolsItem(new Item.Properties()));
        RegistryObject<EntityType<?>> entityType = switch (definition.environment()) {
            case RIVER -> ENTITY_TYPES.register(
                    path,
                    () -> EntityType.Builder.of(RiverFishPoolEntity::new, MobCategory.MISC)
                            .sized(2.0F, 2.5F)
                            .build(definition.id().toString())
            );
            case OCEAN -> ENTITY_TYPES.register(
                    path,
                    () -> EntityType.Builder.of(OceanFishPoolEntity::new, MobCategory.MISC)
                            .sized(2.0F, 2.5F)
                            .build(definition.id().toString())
            );
        };

        FishPoolRegistration registration = new FishPoolRegistration(definition.id(), definition.environment(), item, entityType);
        FishPoolRegistration existing = FISH_POOL_REGISTRATIONS.putIfAbsent(definition.id(), registration);
        if (existing != null) {
            throw new IllegalStateException("Duplicate fish pool registry entry: " + definition.id());
        }
        return registration;
    }

    public static FishPoolRegistration getFishPoolRegistration(ResourceLocation id) {
        FishPoolRegistration registration = FISH_POOL_REGISTRATIONS.get(id);
        if (registration == null) {
            throw new IllegalStateException("Missing fish pool registration for " + id);
        }
        return registration;
    }

    public static Collection<FishPoolRegistration> getFishPoolRegistrations() {
        return List.copyOf(FISH_POOL_REGISTRATIONS.values());
    }

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
        ENTITY_TYPES.register(bus);
    }

    public record FishPoolRegistration(
            ResourceLocation id,
            FishPoolDefinition.Environment environment,
            RegistryObject<Item> item,
            RegistryObject<EntityType<?>> entityType
    ) {
        @Nullable
        public AbstractFishPoolEntity create(Level level) {
            Entity entity = this.entityType.get().create(level);
            return entity instanceof AbstractFishPoolEntity fishPool ? fishPool : null;
        }
    }
}

