package com.list.data;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class ModLangs {
    public static void init(RegistrateLangProvider provider) {
        provider.add("item.list.just_bread.desc.1", "It's just a piece of bread, an ordinary, unremarkable piece of bread;");
        provider.add("item.list.just_bread.desc.2", "Eat it, and you will no longer feel hungry;");
        provider.add("item.list.just_bread.desc.3", "But that familiar aroma of wheat has long since faded.");
        provider.add("item.list.farmers_ranch_star.desc.1","§7§oA star synthesized through countless hardships, it is light with unknown mass.");
        provider.add("item.list.farmers_ranch_star.desc.2", "§7§oThank you for playing the Farmer's Ranch: Pastoral Serenade modpack. The entire development team and contributors send their regards.");
        provider.add("item.list.bad_item.desc", "§7§oTechnical item, please do not attempt to obtain");
        provider.add("item.list.tasmanian_giant_freshwater_crayfish.desc.1", "§7§oThe Tasmanian giant freshwater lobster is the largest freshwater lobster in the world.");
        provider.add("item.list.tasmanian_giant_freshwater_crayfish.desc.2", "§7§oValued for its enormous size and delicious meat, it is considered a luxury delicacy.");
        provider.add("item.list.tasmanian_giant_freshwater_crayfish.desc.3", "§7§oHowever, it is an endangered species, strictly protected, and its harvesting is restricted.");
        provider.add("item.list.tasmanian_giant_freshwater_crayfish.desc.4", "§7§oIt is also known as the 'living fossil of freshwater.'");
        provider.add("item.list.euastacus_armatus.desc", "§7§oIts meat is delicious, making it an important freshwater crayfish for local consumption in Australia.");

        provider.add("gui.list.category.fish_pond", "Fish Pond");
        provider.add("gui.list.category.fish_pond.require_lava", "Requires Lava");
        provider.add("gui.list.category.fish_pond.require_water", "Requires Water");
        provider.add("gui.list.category.fish_pond.chance", "Chance: %s%%");

        provider.add("config.jade.plugin_list.fish_pond", "Fish Pond");
        provider.add("config.jade.plugin_list.tapper", "Tapper");
        provider.add("tooltip.list.tapper.no_recipe", "Not connected to a valid tree");
        provider.add("tooltip.list.tapper.title", "Tapper");
        provider.add("tooltip.list.tapper.state.mature", "State: Mature, ready to collect");
        provider.add("tooltip.list.tapper.state.working", "State: Collecting");
        provider.add("tooltip.list.tapper.output", "Output: %s");
        provider.add("tooltip.list.tapper.remaining", "Remaining: %s");
        provider.add("tooltip.list.tapper.tool", "Collect Tool: %s");
        provider.add("tooltip.list.tapper.tool.none", "Collect Tool: Not required");
        provider.add("tooltip.fishpond.not_formed", "Not Formed");
        provider.add("tooltip.fishpond.formed", "Formed");
        provider.add("tooltip.fishpond.lava_mode", "Lava Mode");
        provider.add("tooltip.fishpond.water_mode", "Water Mode");
        provider.add("tooltip.fishpond.recipe_outputs", "Recipe Outputs: ");

        provider.add("gui.list.category.forestry_hybridizer", "Forestry Hybridizer");
        provider.add("gui.list.category.forestry_hybridizer.chance", "Chance: %s%%");

        provider.add("item.list.purple_drink.desc.1", "§7§oHow about some lemonade? Or maybe some ice tea? I got a Purple Drink!");
        provider.add("item.list.purple_drink.desc.2", "§9From:GregTech");

        provider.add("item.list.leninade.desc.1", "§7§oLet communism flow in your blood!");
        provider.add("item.list.leninade.desc.2", "§9From:GregTech Food Option");
        provider.add("item.list.vodka.desc.1", "§7§oDistilled and concentrated Russia.");

        provider.add("item.list.cheese_pizza.desc.1", "§7§oDaring today, aren't we?");
        provider.add("item.list.mince_meat_pizza.desc.1", "§7§oWait, *what* does the GT5U veggie pizza have on it???");
        provider.add("item.list.olive_mushroom_pizza.desc.1", "§7§oNo, GregoriusT! Don't fall down the inescapable Tooltip-Making Asshole Singularity!");

        provider.add("entity.list.ocean_fish_pool", "Ocean Fish Pool");
        provider.add("entity.list.river_fish_pool", "River Fish Pool");
        

    }
}

/*
        provider.add("item.list..desc.1", "§7§o");
        provider.add("item.list..desc.2", "§9GregTech Food Option");
*/