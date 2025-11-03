package com.list.all;

import com.list.item.GlowingItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import static com.list.ListMod.REGISTRATE;

public class ModItems {

    public static final ItemEntry<Item> INDUSTRIAL_COPPER_CREDIT = REGISTRATE
        .item("industrial_copper_credit", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/industrial_copper_credit")))
        .register();

    // 工业银币
    public static final ItemEntry<Item> INDUSTRIAL_SILVER_CREDIT = REGISTRATE
        .item("industrial_silver_credit", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/industrial_silver_credit")))
        .register();

    // 工业金币
    public static final ItemEntry<Item> INDUSTRIAL_GOLD_CREDIT = REGISTRATE
        .item("industrial_gold_credit", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/industrial_gold_credit")))
        .register();

    // 工业铂币
    public static final ItemEntry<Item> INDUSTRIAL_PLATINUM_CREDIT = REGISTRATE
        .item("industrial_platinum_credit", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/industrial_platinum_credit")))
        .register();

    // 工业锇币
    public static final ItemEntry<Item> INDUSTRIAL_OSMIUM_CREDIT = REGISTRATE
        .item("industrial_osmium_credit", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/industrial_osmium_credit")))
        .register();


    // 平平无奇的面包
    public static final ItemEntry<GlowingItem> JUST_BREAD =REGISTRATE
        .item("just_bread", GlowingItem::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.mcLoc("item/bread")))
        .register();

    // 食物之星
    public static final ItemEntry<GlowingItem> FOOD_STAR =REGISTRATE
        .item("food_star", GlowingItem::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/food_star")))
        .register();

    // 渔业之星
    public static final ItemEntry<GlowingItem> FISHERY_STAR =REGISTRATE
        .item("fishery_star", GlowingItem::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/fishery_star")))
        .register();

    // 农夫之星
    public static final ItemEntry<GlowingItem> FARMING_STAR =REGISTRATE
        .item("farming_star", GlowingItem::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/farming_star")))
        .register();

    // 林业之星
    public static final ItemEntry<GlowingItem> FORESTRY_STAR =REGISTRATE
        .item("forestry_star", GlowingItem::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/forestry_star")))
        .register();

    // 财富之星
    public static final ItemEntry<GlowingItem> WEALTH_STAR =REGISTRATE
        .item("wealth_star", GlowingItem::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/wealth_star")))
        .register();

    // 养殖之星
    public static final ItemEntry<GlowingItem> ANIMAL_HUSBANDRY_STAR =REGISTRATE
        .item("animal_husbandry_star", GlowingItem::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/animal_husbandry_star")))
        .register();

    // Farmer's Ranch: Pastoral Serenade之星
    public static final ItemEntry<GlowingItem> FARMERS_RANCH_STAR =REGISTRATE
        .item("farmers_ranch_star", GlowingItem::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/farmers_ranch_star")))
        .register();

    //皇帝蟹
    public static final ItemEntry<Item> EMPEROR_CRAB = REGISTRATE
            .item("emperor_crab", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/crustacean/emperor_crab")))
            .register();


    // 技术性屏蔽物品
    public static final ItemEntry<GlowingItem> BAD_ITEM = REGISTRATE
        .item("bad_item", GlowingItem::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.mcLoc("item/book")))
        .register();

    public static void register() {
    }
}
