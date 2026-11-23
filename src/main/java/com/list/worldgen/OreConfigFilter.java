package com.list.worldgen;

import com.list.ListMod;
import com.list.config.OreManageConfig;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/** Keeps worldgen entries present while gating actual placement with the server's fixed rules. */
public final class OreConfigFilter extends PlacementFilter {
    public static final Codec<OreConfigFilter> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.fieldOf("ore").forGetter(filter -> filter.ore),
            Codec.STRING.fieldOf("base").forGetter(filter -> filter.base),
            Codec.BOOL.fieldOf("gem").forGetter(filter -> filter.kind == OreKind.GEM)
    ).apply(instance, OreConfigFilter::new));

    private static final DeferredRegister<PlacementModifierType<?>> TYPES =
            DeferredRegister.create(Registries.PLACEMENT_MODIFIER_TYPE, ListMod.MODID);
    private static final RegistryObject<PlacementModifierType<OreConfigFilter>> TYPE =
            TYPES.register("ore_config_filter", () -> () -> CODEC);

    private final ResourceLocation ore;
    private final String family;
    private final String base;
    private final OreKind kind;

    public OreConfigFilter(ResourceLocation ore, String base, boolean gem) {
        this.ore = ore;
        this.family = ore.toString();
        this.base = base;
        this.kind = gem ? OreKind.GEM : OreKind.ORE;
    }

    public static void register(IEventBus bus) {
        TYPES.register(bus);
    }

    @Override
    protected boolean shouldPlace(PlacementContext context, RandomSource random, BlockPos pos) {
        return OreManageConfig.allows(kind, family, base);
    }

    @Override
    public PlacementModifierType<?> type() {
        return TYPE.get();
    }
}
