package com.list.all.moditem;

import com.list.ListMod;
import com.list.item.util.SmokerFish;
import com.list.util.ItemModelUtil;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.food.FoodProperties;

import static com.list.ListMod.REGISTRATE;

public class ModItemsSmokerFish {

    public static final ItemEntry<SmokerFish> SMOKER_COD = REGISTRATE
            .item("smoker_cod", p -> new SmokerFish(p, 0xA0A0A0, ListMod.rl("item/food/component/smoke_lite")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.6f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.smokerFishModel(ctx, provider,
                    provider.mcLoc("item/cod"),   //fish_slice_base  /food/component/   item/cod
                    ListMod.rl("item/food/component/smoke_lite")))
            .register();

    public static final ItemEntry<SmokerFish> SMOKER_SALMON = REGISTRATE
            .item("smoker_salmon", p -> new SmokerFish(p, 0xA0A0A0, ListMod.rl("item/food/component/smoke_lite")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.6f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.smokerFishModel(ctx, provider,
                    provider.mcLoc("item/salmon"),
                    ListMod.rl("item/food/component/smoke_lite")))
            .register();

    public static final ItemEntry<SmokerFish> SMOKER_TROPICAL_FISH = REGISTRATE
            .item("smoker_tropical_fish", p -> new SmokerFish(p, 0xA0A0A0, ListMod.rl("item/food/component/smoke_lite")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.6f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.smokerFishModel(ctx, provider,
                    provider.mcLoc("item/tropical_fish"),
                    ListMod.rl("item/food/component/smoke_lite")))
            .register();

    public static final ItemEntry<SmokerFish> SMOKER_PUFFERFISH = REGISTRATE
            .item("smoker_pufferfish", p -> new SmokerFish(p, 0xA0A0A0, ListMod.rl("item/food/component/smoke_large")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.6f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.smokerFishModel(ctx, provider,
                    provider.mcLoc("item/pufferfish"),
                    ListMod.rl("item/food/component/smoke_large")))
            .register();

    public static final ItemEntry<SmokerFish> SMOKER_CATFISH = REGISTRATE
            .item("smoker_catfish", p -> new SmokerFish(
                    p,
                    0xFF808080,
                    ListMod.rl("item/food/component/smoke_large")
            ))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.6f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.smokerFishModel(
                    ctx,
                    provider,
                    ItemModelUtil.textureOrFallback(provider, "aquaculture:item/catfish", provider.mcLoc("item/cod")),
                    ListMod.rl("item/food/component/smoke_large")
            ))
            .register();

    public static void register() {
    }
}
