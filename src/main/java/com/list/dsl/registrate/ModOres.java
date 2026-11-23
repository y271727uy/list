package com.list.dsl.registrate;

import com.list.ListMod;
import com.list.dsl.OreHost;
import com.list.item.util.LayeredItem;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static com.list.ListMod.REGISTRATE;

/** Single registration and recipe entry point for all List gems, ores and metal forms. */
public final class ModOres {
    private static boolean registered;
    /**
     * Ordinary (non-gem) ore blocks are currently unused: their materials and DSL declarations stay,
     * but the 17 host variants are not registered. Flip to true to bring them back.
     * Raw/ingot/nugget items are unaffected. Gem ores are always registered.
     */
    private static final boolean REGISTER_ORDINARY_ORE_BLOCKS = false;
    private static final Map<String, String> CHINESE = new LinkedHashMap<>();

    private ModOres() {}

    public static void register() {
        if (registered) return;
        registered = true;
        registerGemstones();
        registerOrdinaryOres();
    }

    public static Map<String, String> chineseTranslations() { return Map.copyOf(CHINESE); }

    public static void recipes(RegistrateRecipeProvider provider) {
        gemstoneRecipes(provider);
        industrialRecipes(provider);
    }

    // BEGIN NORMAL MATERIALS: maintained by scripts/gt_normal_materials.py
    public record Material(String id, String english, String chinese, String icon,
                           int color, int secondary, String output) {}
    public static final List<Material> ORE_MATERIALS = List.of(
        new Material("aluminium", "Aluminium", "铝", "dull", 0x7db9d8, 0x56ac9c, "aluminium"),
        new Material("beryllium", "Beryllium", "铍", "metallic", 0x73d73d, 0x184537, "beryllium"),
        new Material("cobalt", "Cobalt", "钴", "metallic", 0x5050fa, 0x2d2d7a, "cobalt"),
        new Material("copper", "Copper", "铜", "bright", 0xe77c56, 0xe4673e, "copper"),
        new Material("gold", "Gold", "金", "shiny", 0xfdf55f, 0xf25833, "gold"),
        new Material("iron", "Iron", "铁", "metallic", 0xeeeeee, 0x979797, "iron"),
        new Material("lead", "Lead", "铅", "dull", 0x7e6f82, 0x290633, "lead"),
        new Material("lithium", "Lithium", "锂", "dull", 0xd7e7ee, 0xbdc7db, ""),
        new Material("molybdenum", "Molybdenum", "钼", "shiny", 0xc1c1ce, 0x404068, "molybdenum"),
        new Material("neodymium", "Neodymium", "钕", "metallic", 0x6c5863, 0x2c1919, "neodymium"),
        new Material("nickel", "Nickel", "镍", "metallic", 0xccdff5, 0x59563a, "nickel"),
        new Material("palladium", "Palladium", "钯", "shiny", 0xbd92b5, 0x535b14, "palladium"),
        new Material("platinum", "Platinum", "铂", "shiny", 0xfff4ba, 0x8d8d71, "platinum"),
        new Material("plutonium", "Plutonium", "钚", "radioactive", 0xba2727, 0x222730, "plutonium"),
        new Material("silver", "Silver", "银", "shiny", 0xdcdcff, 0x5a4705, "silver"),
        new Material("sulfur", "Sulfur", "硫", "dull", 0xfdff31, 0xffb400, ""),
        new Material("thorium", "Thorium", "钍", "shiny", 0x25411b, 0x051e05, "thorium"),
        new Material("tin", "Tin", "锡", "dull", 0xfafeff, 0x4e676c, "tin"),
        new Material("naquadah", "Naquadah", "硅岩", "metallic", 0x323232, 0x1e251b, "naquadah"),
        new Material("asbestos", "Asbestos", "石棉", "dull", 0xe6e6e6, 0xdbd7bf, ""),
        new Material("hematite", "Hematite", "赤铁矿", "dull", 0xff7161, 0x330817, "iron"),
        new Material("goethite", "Goethite", "针铁矿", "metallic", 0x97873a, 0x313131, "iron"),
        new Material("calcite", "Calcite", "方解石", "dull", 0xfffef8, 0xbbaf62, ""),
        new Material("cassiterite", "Cassiterite", "锡石", "rough", 0x89847e, 0x3b3b35, "tin"),
        new Material("cassiterite_sand", "Cassiterite Sand", "锡石矿砂", "sand", 0x89847e, 0x3b3b35, "tin"),
        new Material("chalcopyrite", "Chalcopyrite", "黄铜矿", "dull", 0x96c185, 0xe3af1a, "copper"),
        new Material("chromite", "Chromite", "铬铁矿", "metallic", 0xc5c1a8, 0x4c1a69, ""),
        new Material("cobaltite", "Cobaltite", "辉钴矿", "metallic", 0x1975ff, 0x56071f, "cobalt"),
        new Material("cooperite", "Cooperite", "谢尔顿矿", "metallic", 0xe9ffa7, 0x665f2f, ""),
        new Material("galena", "Galena", "方铅矿", "metallic", 0xf3e8fa, 0x331d42, "lead"),
        new Material("garnierite", "Garnierite", "硅镁镍矿", "metallic", 0x32c880, 0x344028, "nickel"),
        new Material("ilmenite", "Ilmenite", "钛铁矿", "metallic", 0x2b2a24, 0x2b1700, ""),
        new Material("bauxite", "Bauxite", "铝土矿", "dull", 0xcfb853, 0xe6220c, ""),
        new Material("magnesite", "Magnesite", "菱镁矿", "rough", 0xfbfbf6, 0x80705e, ""),
        new Material("magnetite", "Magnetite", "磁铁矿", "metallic", 0x9d9d9d, 0x06070e, "iron"),
        new Material("molybdenite", "Molybdenite", "辉钼矿", "metallic", 0xe3ddc3, 0x191919, "molybdenum"),
        new Material("powellite", "Powellite", "钼钙矿", "dull", 0xd8cfac, 0xbc7a2c, ""),
        new Material("pyrite", "Pyrite", "黄铁矿", "rough", 0xfffee6, 0xb69f4e, "iron"),
        new Material("pyrolusite", "Pyrolusite", "软锰矿", "dull", 0xc7b5ab, 0x595756, "manganese"),
        new Material("saltpeter", "Saltpeter", "硝石", "fine", 0xe6e6e6, 0xe6e1cf, ""),
        new Material("scheelite", "Scheelite", "白钨矿", "dull", 0xd7e8b3, 0x143cae, ""),
        new Material("tantalite", "Tantalite", "钽铁矿", "metallic", 0x4e6b94, 0x632300, ""),
        new Material("sphalerite", "Sphalerite", "闪锌矿", "dull", 0xffdc88, 0x0f1605, "zinc"),
        new Material("stibnite", "Stibnite", "辉锑矿", "metallic", 0x656565, 0x0a1432, "antimony"),
        new Material("tetrahedrite", "Tetrahedrite", "黝铜矿", "dull", 0xa3a09b, 0x143313, "copper"),
        new Material("tungstate", "Tungstate", "钨酸锂", "dull", 0xe0ffc4, 0xab4400, ""),
        new Material("uraninite", "Uraninite", "晶质铀矿", "metallic", 0xffd52e, 0x17212b, ""),
        new Material("wulfenite", "Wulfenite", "钼铅矿", "dull", 0xff9000, 0xff0000, ""),
        new Material("yellow_limonite", "Yellow Limonite", "褐铁矿", "metallic", 0xf5e315, 0xc06f33, "iron"),
        new Material("graphite", "Graphite", "石墨", "dull", 0xa8a89e, 0x172602, ""),
        new Material("bornite", "Bornite", "斑铜矿", "rough", 0xffe05a, 0x442602, "copper"),
        new Material("chalcocite", "Chalcocite", "辉铜矿", "emerald", 0x657882, 0x33302e, "copper"),
        new Material("bastnasite", "Bastnasite", "氟碳镧铈矿", "fine", 0xcaab60, 0xc8502d, ""),
        new Material("pentlandite", "Pentlandite", "镍黄铁矿", "dull", 0xe3cf13, 0x29315b, "nickel"),
        new Material("spodumene", "Spodumene", "锂辉石", "dull", 0xffbcbc, 0xc490ff, ""),
        new Material("lepidolite", "Lepidolite", "锂云母", "fine", 0xffdae4, 0x75376f, ""),
        new Material("glauconite_sand", "Glauconite Sand", "海绿石砂", "sand", 0x1da351, 0x1a6e8f, ""),
        new Material("mica", "Mica", "云母", "fine", 0xecfeff, 0xc2a03c, ""),
        new Material("barite", "Barite", "重晶石", "dull", 0xe8e2d1, 0xf4b74b, ""),
        new Material("alunite", "Alunite", "明矾石", "metallic", 0xfbd677, 0xe11e0a, ""),
        new Material("talc", "Talc", "滑石", "fine", 0xebffe9, 0x6fe19b, ""),
        new Material("soapstone", "Soapstone", "皂石", "rough", 0x5a7261, 0x464c4b, ""),
        new Material("kyanite", "Kyanite", "蓝晶石", "flint", 0xd5ffff, 0x5a69d6, ""),
        new Material("pyrochlore", "Pyrochlore", "烧绿石", "metallic", 0x5b4838, 0x331400, ""),
        new Material("electrotine", "Electrotine", "蓝石", "shiny", 0x83cbf5, 0x004585, ""),
        new Material("diatomite", "Diatomite", "硅藻土", "dull", 0xfffafa, 0xffffff, ""),
        new Material("granitic_mineral_sand", "Granitic Mineral Sand", "花岗岩矿砂", "sand", 0xd69077, 0x71352c, "iron"),
        new Material("garnet_sand", "Garnet Sand", "石榴石砂", "sand", 0xcc4c25, 0x510b04, ""),
        new Material("basaltic_mineral_sand", "Basaltic Mineral Sand", "玄武岩矿砂", "sand", 0x5c5c5c, 0x283228, "iron"),
        new Material("tricalcium_phosphate", "Tricalcium Phosphate", "磷酸三钙", "flint", 0xfffddb, 0xffff00, ""),
        new Material("vanadium_magnetite", "Vanadium Magnetite", "钒磁铁矿", "metallic", 0x505d70, 0x170322, ""),
        new Material("pollucite", "Pollucite", "铯榴石", "dull", 0xeed9e1, 0x72a6a7, ""),
        new Material("bentonite", "Bentonite", "膨润土", "rough", 0xede8a3, 0xcdb44c, ""),
        new Material("fullers_earth", "Fullers Earth", "漂白土", "fine", 0xf3efbb, 0xb8d066, ""),
        new Material("pitchblende", "Pitchblende", "沥青铀矿", "dull", 0xffd647, 0x0d1e2f, ""),
        new Material("trona", "Trona", "天然碱", "metallic", 0xe6e6a5, 0x87875f, ""),
        new Material("gypsum", "Gypsum", "石膏", "dull", 0xfffaec, 0x71570a, ""),
        new Material("zeolite", "Zeolite", "沸石", "dull", 0xf2e3e0, 0xeabeb4, ""),
        new Material("redstone", "Redstone", "红石", "rough", 0xff0000, 0x340605, ""),
        new Material("oilsands", "Oilsands", "油砂", "sand", 0xe3c78a, 0x161e22, "")
    );
    public static final List<Material> METAL_MATERIALS = List.of(
        new Material("aluminium", "Aluminium", "铝", "dull", 0x7db9d8, 0x56ac9c, ""),
        new Material("antimony", "Antimony", "锑", "shiny", 0xeaeaff, 0x8181bd, ""),
        new Material("beryllium", "Beryllium", "铍", "metallic", 0x73d73d, 0x184537, ""),
        new Material("cobalt", "Cobalt", "钴", "metallic", 0x5050fa, 0x2d2d7a, ""),
        new Material("copper", "Copper", "铜", "bright", 0xe77c56, 0xe4673e, ""),
        new Material("gold", "Gold", "金", "shiny", 0xfdf55f, 0xf25833, ""),
        new Material("iron", "Iron", "铁", "metallic", 0xeeeeee, 0x979797, ""),
        new Material("lead", "Lead", "铅", "dull", 0x7e6f82, 0x290633, ""),
        new Material("manganese", "Manganese", "锰", "dull", 0x88a669, 0xcde1b9, ""),
        new Material("molybdenum", "Molybdenum", "钼", "shiny", 0xc1c1ce, 0x404068, ""),
        new Material("naquadah", "Naquadah", "硅岩", "metallic", 0x323232, 0x1e251b, ""),
        new Material("neodymium", "Neodymium", "钕", "metallic", 0x6c5863, 0x2c1919, ""),
        new Material("nickel", "Nickel", "镍", "metallic", 0xccdff5, 0x59563a, ""),
        new Material("palladium", "Palladium", "钯", "shiny", 0xbd92b5, 0x535b14, ""),
        new Material("platinum", "Platinum", "铂", "shiny", 0xfff4ba, 0x8d8d71, ""),
        new Material("plutonium", "Plutonium", "钚", "radioactive", 0xba2727, 0x222730, ""),
        new Material("silver", "Silver", "银", "shiny", 0xdcdcff, 0x5a4705, ""),
        new Material("thorium", "Thorium", "钍", "shiny", 0x25411b, 0x051e05, ""),
        new Material("tin", "Tin", "锡", "dull", 0xfafeff, 0x4e676c, ""),
        new Material("zinc", "Zinc", "锌", "metallic", 0xebebfa, 0x232c30, "")
    );
    // END NORMAL MATERIALS

    record ExtraOre(Material material, boolean generates) {}

    static final List<ExtraOre> EXTRA_ORDINARY = List.of(
        extraOre("adamantium", "Adamantium", "精金", "shiny", 0xffffff, 0x949494, false),
        extraOre("americium", "Americium", "镅", "metallic", 0xc8c8c8, 0x747474, false),
        extraOre("andradite", "Andradite", "钙铁榴石", "rough", 0x967800, 0x574600, false),
        extraOre("antimony", "Antimony", "锑", "shiny", 0xdcdcf0, 0x80808b, false),
        extraOre("arsenic", "Arsenic", "砷", "dull", 0xffffff, 0x949494, false),
        extraOre("astral_silver", "Astral Silver", "星辉银", "shiny", 0xe6e6ff, 0x858594, false),
        extraOre("barium", "Barium", "钡", "metallic", 0xffffff, 0x949494, false),
        extraOre("bismuth", "Bismuth", "铋", "metallic", 0x64a0a0, 0x3a5d5d, true),
        extraOre("borax", "Borax", "硼砂", "fine", 0xfafafa, 0x919191, false),
        extraOre("boron", "Boron", "硼", "dull", 0xfafafa, 0x919191, false),
        extraOre("cadmium", "Cadmium", "镉", "shiny", 0x32323c, 0x1d1d23, false),
        extraOre("caesium", "Caesium", "铯", "metallic", 0xffffff, 0x949494, false),
        extraOre("celestine", "Celestine", "天青石", "dull", 0xc8cdf0, 0x74778b, false),
        extraOre("cerium", "Cerium", "铈", "metallic", 0xffffff, 0x949494, false),
        extraOre("cheese", "Cheese", "奶酪", "fine", 0xffff00, 0x949400, false),
        extraOre("chromium", "Chromium", "铬", "shiny", 0xffe6e6, 0x948585, false),
        extraOre("chrysotile", "Chrysotile", "温石棉", "dull", 0x6e8c6e, 0x405140, false),
        extraOre("dark_iron", "Dark Iron", "暗铁", "dull", 0x37283c, 0x201723, false),
        extraOre("deep_iron", "Deep Iron", "深铁", "metallic", 0x968c8c, 0x575151, false),
        extraOre("desh", "Desh", "戴斯", "dull", 0x282828, 0x171717, false),
        extraOre("dolomite", "Dolomite", "白云石", "flint", 0xe1cdcd, 0x827777, false),
        extraOre("dysprosium", "Dysprosium", "镝", "metallic", 0xffffff, 0x949494, false),
        extraOre("electrum", "Electrum", "琥珀金", "shiny", 0xffff64, 0x94943a, false),
        extraOre("emery", "Emery", "金刚砂", "dull", 0xffffff, 0x949494, false),
        extraOre("erbium", "Erbium", "铒", "metallic", 0xffffff, 0x949494, false),
        extraOre("europium", "Europium", "铕", "metallic", 0xffffff, 0x949494, false),
        extraOre("gadolinium", "Gadolinium", "钆", "metallic", 0xffffff, 0x949494, false),
        extraOre("gallium", "Gallium", "镓", "shiny", 0xdcdcff, 0x808094, false),
        extraOre("glauconite", "Glauconite", "海绿石", "dull", 0x82b43c, 0x4b6823, true),
        extraOre("holmium", "Holmium", "钬", "metallic", 0xffffff, 0x949494, false),
        extraOre("indium", "Indium", "铟", "metallic", 0x400080, 0x25004a, false),
        extraOre("infused_gold", "Infused Gold", "注魔金", "shiny", 0xffc83c, 0x947423, false),
        extraOre("iridium", "Iridium", "铱", "dull", 0xf0f0f5, 0x8b8b8e, true),
        extraOre("jade", "Jade", "玉", "shiny", 0x006400, 0x003a00, false),
        extraOre("kaolinite", "Kaolinite", "高岭石", "dull", 0xf5ebeb, 0x8e8888, false),
        extraOre("lanthanum", "Lanthanum", "镧", "metallic", 0xffffff, 0x949494, false),
        extraOre("lutetium", "Lutetium", "镥", "metallic", 0xffffff, 0x949494, false),
        extraOre("magnesium", "Magnesium", "镁", "metallic", 0xffc8c8, 0x947474, false),
        extraOre("manganese", "Manganese", "锰", "dull", 0xfafafa, 0x919191, false),
        extraOre("meteoric_iron", "Meteoric Iron", "陨铁", "metallic", 0x643250, 0x3a1d2e, false),
        extraOre("midasium", "Midasium", "米达斯金", "shiny", 0xffc828, 0x947417, false),
        extraOre("mirabilite", "Mirabilite", "芒硝", "dull", 0xf0fad2, 0x8b917a, false),
        extraOre("mithril", "Mithril", "秘银", "shiny", 0xffffd2, 0x94947a, false),
        extraOre("enriched_naquadah", "Enriched Naquadah", "富集硅岩", "metallic", 0x323232, 0x1d1d1d, true),
        extraOre("naquadria", "Naquadria", "超能硅岩", "shiny", 0x1e1e1e, 0x111111, false),
        extraOre("neutronium", "Neutronium", "中子素", "dull", 0xfafafa, 0x919191, false),
        extraOre("nikolite", "Nikolite", "尼科莱特", "shiny", 0x3cb4c8, 0x236874, false),
        extraOre("niobium", "Niobium", "铌", "metallic", 0xbeb4c8, 0x6e6874, false),
        extraOre("osmium", "Osmium", "锇", "metallic", 0x3232ff, 0x1d1d94, false),
        extraOre("perlite", "Perlite", "珍珠岩", "dull", 0x1e141e, 0x110c11, false),
        extraOre("phosphate", "Phosphate", "磷酸盐", "dull", 0xffff00, 0x949400, true),
        extraOre("phosphor", "Phosphor", "磷光体", "dull", 0xffff00, 0x949400, false),
        extraOre("pig_iron", "Pig Iron", "生铁", "metallic", 0xc8b4b4, 0x746868, false),
        extraOre("plutonium_241", "Plutonium-241", "钚-241", "radioactive", 0xfa4646, 0x912929, false),
        extraOre("praseodymium", "Praseodymium", "镨", "metallic", 0xffffff, 0x949494, false),
        extraOre("promethium", "Promethium", "钷", "metallic", 0xffffff, 0x949494, false),
        extraOre("pumice", "Pumice", "浮石", "dull", 0xe6b9b9, 0x856b6b, false),
        extraOre("quartz_sand", "Quartz Sand", "石英砂", "sand", 0xc8c8c8, 0x747474, false),
        extraOre("rubidium", "Rubidium", "铷", "metallic", 0xf01e1e, 0x8b1111, false),
        extraOre("samarium", "Samarium", "钐", "metallic", 0xffffff, 0x949494, false),
        extraOre("scandium", "Scandium", "钪", "metallic", 0xffffff, 0x949494, false),
        extraOre("shadow_iron", "Shadow Iron", "影铁", "metallic", 0x787878, 0x464646, false),
        extraOre("silicon", "Silicon", "硅", "metallic", 0x3c3c50, 0x23232e, false),
        extraOre("strontium", "Strontium", "锶", "metallic", 0xc8c8c8, 0x747474, false),
        extraOre("tantalum", "Tantalum", "钽", "metallic", 0xffffff, 0x949494, false),
        extraOre("tellurium", "Tellurium", "碲", "metallic", 0xffffff, 0x949494, false),
        extraOre("terbium", "Terbium", "铽", "metallic", 0xffffff, 0x949494, false),
        extraOre("thulium", "Thulium", "铥", "metallic", 0xffffff, 0x949494, false),
        extraOre("titanium", "Titanium", "钛", "metallic", 0xdca0f0, 0x805d8b, false),
        extraOre("tungsten", "Tungsten", "钨", "metallic", 0x323232, 0x1d1d1d, false),
        extraOre("uranium", "Uranium-238", "铀-238", "radioactive", 0x32f032, 0x1d8b1d, true),
        extraOre("uranium_235", "Uranium-235", "铀-235", "radioactive", 0x46fa46, 0x299129, false),
        extraOre("uvarovite", "Uvarovite", "钙铬榴石", "emerald", 0xb4ffb4, 0x689468, false),
        extraOre("vanadium", "Vanadium", "钒", "metallic", 0x323232, 0x1d1d1d, false),
        extraOre("vermiculite", "Vermiculite", "蛭石", "metallic", 0xc8b40f, 0x746809, false),
        extraOre("wollastonite", "Wollastonite", "硅灰石", "dull", 0xf0f0f0, 0x8b8b8b, false),
        extraOre("ytterbium", "Ytterbium", "镱", "metallic", 0xffffff, 0x949494, false),
        extraOre("yttrium", "Yttrium", "钇", "metallic", 0xdcfadc, 0x809180, false),
        extraOre("zinc", "Zinc", "锌", "metallic", 0xfaf0f0, 0x918b8b, true)
    );

    static final List<ExtraOre> EXTRA_GEM_ORES = List.of(
        extraOre("amber", "Amber", "琥珀", "ruby", 0xff8000, 0x944a00, true),
        extraOre("charged_certus_quartz", "Charged Certus Quartz", "充能赛特斯石英", "certus", 0xd2d2e6, 0x7a7a85, false),
        extraOre("dilithium", "Dilithium", "二锂", "diamond", 0xfffafa, 0x949191, false),
        extraOre("firestone", "Firestone", "火石", "quartz", 0xc81400, 0x740c00, false),
        extraOre("fools_ruby", "Fool's Ruby", "愚人红宝石", "ruby", 0xff6464, 0x943a3a, true),
        extraOre("force", "Force", "力量", "diamond", 0xffff00, 0x949400, false),
        extraOre("forcicium", "Forcicium", "弗锡晶", "diamond", 0x323246, 0x1d1d29, false),
        extraOre("forcillium", "Forcillium", "弗西晶", "diamond", 0x323246, 0x1d1d29, false),
        extraOre("infused_air", "Aer", "风之魔力", "certus", 0xffff00, 0x949400, false),
        extraOre("infused_earth", "Terra", "地之魔力", "certus", 0x00ff00, 0x009400, false),
        extraOre("infused_entropy", "Perditio", "混沌魔力", "certus", 0x3e3e3e, 0x242424, false),
        extraOre("infused_fire", "Ignis", "火之魔力", "certus", 0xff0000, 0x940000, false),
        extraOre("infused_order", "Ordo", "秩序魔力", "certus", 0xfcfcfc, 0x929292, false),
        extraOre("infused_water", "Aqua", "水之魔力", "certus", 0x0000ff, 0x000094, false),
        extraOre("jasper", "Jasper", "碧玉", "emerald", 0xc85050, 0x742e2e, true),
        extraOre("lignite", "Lignite Coal", "褐煤", "lignite", 0x644646, 0x3a2929, true),
        extraOre("niter", "Niter", "硝石", "fine", 0xffc8c8, 0x947474, false),
        extraOre("phosphorus", "Phosphorus", "磷", "fine", 0xffff00, 0x949400, true),
        extraOre("tanzanite", "Tanzanite", "坦桑石", "gem_vertical", 0x4000c8, 0x250074, true),
        extraOre("vinteum", "Vinteum", "温特姆", "emerald", 0x64c8ff, 0x3a7494, false)
    );


    private static ExtraOre extraOre(String id, String english, String chinese, String icon, int color, int secondary,
                           boolean generates) {
        return new ExtraOre(new Material(id, english, chinese, icon, color, secondary, ""), generates);
    }

    public enum Grade {
        CHIPPED("chipped_", "Chipped ", "破碎的", "gem_chipped", 64),
        FLAWED("flawed_", "Flawed ", "有瑕的", "gem_flawed", 64),
        NORMAL("", "", "", "gem", 64),
        FLAWLESS("flawless_", "Flawless ", "无瑕的", "gem_flawless", 32),
        EXQUISITE("exquisite_", "Exquisite ", "精致的", "gem_exquisite", 16);

        final String prefix, english, chinese, texture;
        final int stackSize;
        Grade(String prefix, String english, String chinese, String texture, int stackSize) {
            this.prefix = prefix; this.english = english; this.chinese = chinese;
            this.texture = texture; this.stackSize = stackSize;
        }
    }

    public record Gem(String id, String english, String chinese, String iconSet, int color,
                      int secondary, Supplier<? extends ItemLike> vanillaNormal, boolean vanillaOre,
                      Map<Grade, Supplier<? extends ItemLike>> items) {
        public Item item(Grade grade) { return items.get(grade).get().asItem(); }
    }

    private static final List<Gem> GEMS = new ArrayList<>();
    private static final List<BlockEntry<Block>> GEM_ORES = new ArrayList<>();


    private static void registerGemstones() {
        material("almandine", "Almandine", "铁铝榴石", "gem_vertical", 0xa21717, 0x4b1e0c, null, false);
        material("amethyst", "Amethyst", "紫水晶", "ruby", 0xcfa0f3, 0x734fbc, () -> Items.AMETHYST_SHARD, false);
        material("apatite", "Apatite", "磷灰石", "diamond", 0x06cdf1, 0x701c07, null, false);
        material("blue_topaz", "Blue Topaz", "蓝黄玉", "gem_horizontal", 0xdbfeff, 0xa0c4d7, null, false);
        material("certus_quartz", "Certus Quartz", "赛特斯石英", "certus", 0xc2d6ff, 0x86bacf, null, false);
        material("cinnabar", "Cinnabar", "朱砂", "emerald", 0xff335f, 0x3f0110, null, false);
        material("coal", "Coal", "煤炭", "lignite", 0x393e41, 0x101015, () -> Items.COAL, true);
        material("diamond", "Diamond", "钻石", "diamond", 0xc8ffff, 0xc8ffff, () -> Items.DIAMOND, true);
        material("emerald", "Emerald", "绿宝石", "emerald", 0x17ff6c, 0x003f00, () -> Items.EMERALD, true);
        material("green_sapphire", "Green Sapphire", "绿色蓝宝石", "gem_horizontal", 0x9ae6b0, 0x64c882, null, false);
        material("grossular", "Grossular", "钙铝榴石", "ruby", 0xffb777, 0x856f48, null, false);
        material("lapis", "Lapis", "青金石", "lapis", 0x85a9ff, 0x2a7fff, () -> Items.LAPIS_LAZULI, true);
        material("lazurite", "Lazurite", "蓝金石", "lapis", 0x2836f1, 0x183ca3, null, false);
        material("malachite", "Malachite", "孔雀石", "lapis", 0x00f1b0, 0x107a47, null, false);
        material("nether_quartz", "Nether Quartz", "下界石英", "quartz", 0xf8efe3, 0xe6c1bb, () -> Items.QUARTZ, true);
        material("olivine", "Olivine", "橄榄石", "ruby", 0xa7e404, 0x166439, null, false);
        material("opal", "Opal", "猫眼石", "opal", 0xf9e3ea, 0x16bbe0, null, false);
        material("monazite", "Monazite", "独居石", "diamond", 0xd0ee98, 0x520505, null, false);
        material("pyrope", "Pyrope", "镁铝榴石", "ruby", 0xe81958, 0x811e00, null, false);
        material("quartzite", "Quartzite", "石英岩", "quartz", 0xf2f5ed, 0xb8e2b8, null, false);
        material("realgar", "Realgar", "雄黄", "emerald", 0xff3d33, 0x3f0110, null, false);
        material("red_garnet", "Red Garnet", "红石榴石", "ruby", 0x950c15, 0x510b04, null, false);
        material("rock_salt", "Rock Salt", "岩盐", "fine", 0xffeae1, 0xf0c8c8, null, false);
        material("ruby", "Ruby", "红宝石", "ruby", 0xd72310, 0x960b6d, null, false);
        material("salt", "Salt", "盐", "fine", 0xfafafa, 0xfafafa, null, false);
        material("sapphire", "Sapphire", "蓝宝石", "emerald", 0x3235e3, 0x211455, null, false);
        material("sodalite", "Sodalite", "方钠石", "lapis", 0x3d54ff, 0x210d78, null, false);
        material("spessartine", "Spessartine", "锰铝榴石", "ruby", 0xffa81e, 0xb33700, null, false);
        material("topaz", "Topaz", "黄玉", "gem_horizontal", 0xe8d73a, 0xf4680f, null, false);
        material("yellow_garnet", "Yellow Garnet", "黄石榴石", "ruby", 0xf6ff09, 0xe7a800, null, false);
        for (ExtraOre ore : EXTRA_GEM_ORES) {
            var gem = ore.material();
            material(gem.id(), gem.english(), gem.chinese(), gem.icon(), gem.color(), gem.secondary(),
                    null, false, ore.generates());
        }
    }

    private static void material(String id, String english, String chinese, String iconSet,
                                 int color, int secondary, Supplier<? extends ItemLike> vanilla, boolean vanillaOre) {
        material(id, english, chinese, iconSet, color, secondary, vanilla, vanillaOre, true);
    }

    private static void material(String id, String english, String chinese, String iconSet,
                                 int color, int secondary, Supplier<? extends ItemLike> vanilla, boolean vanillaOre,
                                 boolean generates) {
        String chineseItemName = chinese + switch (id) {
            case "vinteum" -> "晶石";
            case "dilithium" -> "晶体";
            case "infused_air", "infused_earth", "infused_entropy",
                    "infused_fire", "infused_order", "infused_water" -> "水晶";
            default -> "";
        };
        Map<Grade, Supplier<? extends ItemLike>> items = new EnumMap<>(Grade.class);
        for (Grade grade : Grade.values()) {
            if (grade == Grade.NORMAL && vanilla != null) {
                items.put(grade, vanilla);
                continue;
            }
            String name = grade.prefix + id + "_gem";
            String texture = "item/gt_gems/" + iconSet + "/" + grade.texture;
            var entry = REGISTRATE.item(name,
                            p -> new LayeredItem(p, color | 0xff000000, secondary | 0xff000000))
                    .properties(p -> p.stacksTo(grade.stackSize))
                    .lang(grade.english + english)
                    .model((ctx, provider) -> provider.withExistingParent(ctx.getName(), "minecraft:item/generated")
                            .texture("layer0", ListMod.rl(texture))
                            .texture("layer1", ListMod.rl(texture + "_secondary"))
                            .texture("layer2", ListMod.rl(texture + "_overlay")))
                    .tag(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("forge", grade.prefix + "gems")),
                            TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("forge", grade.prefix + "gems/" + id)))
                    .register();
            items.put(grade, entry);
            CHINESE.put("item.list." + name, grade.chinese + chineseItemName);
        }
        Gem gem = new Gem(id, english, chinese, iconSet, color, secondary, vanilla, vanillaOre, Map.copyOf(items));
        GEMS.add(gem);
        if (!vanillaOre) {
            for (OreHost host : OreHost.values()) {
                GEM_ORES.add(host.register(gem.id(), gem.english(), gem.chinese(),
                        "list:block/gt_gems/" + gem.iconSet() + "/ore", gem.color(), gem.items().get(Grade.NORMAL), generates, com.list.worldgen.OreKind.GEM));
            }
        }
    }

    public static List<Gem> gems() { return List.copyOf(GEMS); }
    public static List<BlockEntry<Block>> gemOres() { return List.copyOf(GEM_ORES); }

    private static void gemstoneRecipes(RegistrateRecipeProvider provider) {
        Grade[] grades = Grade.values();
        for (Gem gem : GEMS) {
            for (int i = 0; i < grades.length - 1; i++) {
                Item small = gem.item(grades[i]);
                Item large = gem.item(grades[i + 1]);
                String grade = grades[i + 1].name().toLowerCase(java.util.Locale.ROOT);
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, large)
                        .requires(small, 2)
                        .unlockedBy("has_gem", InventoryChangeTrigger.TriggerInstance.hasItems(small))
                        .save(provider, ListMod.rl("gems/" + gem.id() + "/combine_" + grade));
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, small, 2)
                        .requires(large)
                        .unlockedBy("has_gem", InventoryChangeTrigger.TriggerInstance.hasItems(large))
                        .save(provider, ListMod.rl("gems/" + gem.id() + "/split_" + grade));
            }
        }
    }

    private static final Map<String, Supplier<? extends ItemLike>> RAW = new LinkedHashMap<>();
    private static final Map<String, Supplier<? extends ItemLike>> INGOTS = new LinkedHashMap<>();
    private static final Map<String, Supplier<? extends ItemLike>> NUGGETS = new LinkedHashMap<>();
    private static final List<Supplier<? extends ItemLike>> NEW_ITEMS = new ArrayList<>();
    private static final Map<String, List<BlockEntry<Block>>> ORES_BY_MATERIAL = new LinkedHashMap<>();
    private static final List<BlockEntry<Block>> ORES = new ArrayList<>();


    private static void registerOrdinaryOres() {
        for (Material metal : METAL_MATERIALS) {
            Supplier<? extends ItemLike> ingot = switch (metal.id()) {
                case "iron" -> () -> Items.IRON_INGOT;
                case "copper" -> () -> Items.COPPER_INGOT;
                case "gold" -> () -> Items.GOLD_INGOT;
                default -> item(metal.id() + "_ingot", metal, "ingot", metal.english() + " Ingot", metal.chinese() + "锭");
            };
            Supplier<? extends ItemLike> nugget = switch (metal.id()) {
                case "iron" -> () -> Items.IRON_NUGGET;
                case "gold" -> () -> Items.GOLD_NUGGET;
                default -> item(metal.id() + "_nugget", metal, "nugget", metal.english() + " Nugget", metal.chinese() + "粒");
            };
            INGOTS.put(metal.id(), ingot);
            NUGGETS.put(metal.id(), nugget);
            formTags("ingots", metal.id(), ingot);
            formTags("nuggets", metal.id(), nugget);
            if (metal.id().equals("aluminium")) {
                formTags("ingots", "aluminum", ingot);
                formTags("nuggets", "aluminum", nugget);
            }
        }
        for (Material material : ORE_MATERIALS) {
            registerOre(material, true);
        }
        for (ExtraOre ore : EXTRA_ORDINARY) {
            registerOre(ore.material(), ore.generates());
        }
    }

    private static void registerOre(Material material, boolean generates) {
        Supplier<? extends ItemLike> raw = switch (material.id()) {
            case "iron" -> () -> Items.RAW_IRON;
            case "copper" -> () -> Items.RAW_COPPER;
            case "gold" -> () -> Items.RAW_GOLD;
            case "redstone" -> () -> Items.REDSTONE;
            default -> item("raw_" + material.id(), material, "raw_ore", "Raw " + material.english(), "粗" + material.chinese());
        };
        RAW.put(material.id(), raw);
        // Vanilla redstone already supplies its own item.
        if (!material.id().equals("redstone")) formTags("raw_materials", material.id(), raw);
        if (isVanillaOre(material.id()) || !REGISTER_ORDINARY_ORE_BLOCKS) return;
        List<BlockEntry<Block>> variants = new ArrayList<>();
        for (OreHost host : OreHost.values()) {
            BlockEntry<Block> ore = host.register(material.id(), material.english(), material.chinese(),
                    "list:block/gt_ores/" + material.icon() + "/ore", material.color(), raw, generates);
            variants.add(ore);
            ORES.add(ore);
        }
        ORES_BY_MATERIAL.put(material.id(), List.copyOf(variants));
        REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, provider -> {
            for (BlockEntry<Block> ore : variants) {
                provider.addTag(TagKey.create(Registries.BLOCK, ListMod.rl("industrial_ores/" + material.id()))).add(ore.get());
                provider.addTag(TagKey.create(Registries.BLOCK, forge("ores"))).add(ore.get());
                provider.addTag(TagKey.create(Registries.BLOCK, forge("ores/" + material.id()))).add(ore.get());
            }
        });
        for (BlockEntry<Block> ore : variants) formTags("ores", material.id(), ore);
    }

    private static Supplier<? extends ItemLike> item(String id, Material material, String form,
                                                    String english, String chinese) {
        String texture = "item/gt_ores/" + material.icon() + "/" + form;
        var entry = REGISTRATE.item(id, p -> new LayeredItem(p, material.color() | 0xff000000, material.secondary() | 0xff000000))
                .lang(english)
                .model((ctx, provider) -> {
                    var model = provider.withExistingParent(ctx.getName(), "minecraft:item/generated")
                            .texture("layer0", ListMod.rl(texture))
                            .texture("layer1", ListMod.rl(texture + "_secondary"));
                    if (!form.equals("raw_ore") || List.of("shiny", "bright", "emerald").contains(material.icon())) {
                        model.texture("layer2", ListMod.rl(texture + "_overlay"));
                    }
                })
                .register();
        NEW_ITEMS.add(entry);
        CHINESE.put("item.list." + id, chinese);
        return entry;
    }

    private static net.minecraft.resources.ResourceLocation forge(String path) {
        return net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("forge", path);
    }

    private static void formTags(String form, String material, Supplier<? extends ItemLike> item) {
        REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, provider -> {
            provider.addTag(TagKey.create(Registries.ITEM, forge(form))).add(item.get().asItem());
            provider.addTag(TagKey.create(Registries.ITEM, forge(form + "/" + material))).add(item.get().asItem());
        });
    }

    private static boolean isVanillaOre(String id) {
        return id.equals("iron") || id.equals("copper") || id.equals("gold") || id.equals("redstone");
    }

    /** Resolve registered forms for recipes without duplicating items. Unknown forms fail explicitly. */
    public static Item raw(String material) { return form(RAW, material, "raw ore"); }
    public static Item ingot(String material) { return form(INGOTS, material, "ingot"); }
    public static Item nugget(String material) { return form(NUGGETS, material, "nugget"); }

    private static Item form(Map<String, Supplier<? extends ItemLike>> forms, String material, String name) {
        var entry = forms.get(material);
        if (entry == null) throw new IllegalArgumentException("Unknown " + name + " material: " + material);
        return entry.get().asItem();
    }

    public static List<BlockEntry<Block>> ores() { return List.copyOf(ORES); }

    public static void displayItems(CreativeModeTab.Output output) {
        NEW_ITEMS.forEach(item -> output.accept(item.get()));
        ORES.forEach(ore -> output.accept(ore.get()));
    }

    private static void industrialRecipes(RegistrateRecipeProvider provider) {
        for (Material material : ORE_MATERIALS) {
            if (material.output().isBlank() || isVanillaOre(material.id())) continue;
            ItemLike raw = RAW.get(material.id()).get();
            ItemLike ingot = INGOTS.get(material.output()).get();
            List<ItemLike> inputs = new ArrayList<>();
            inputs.add(raw);
            ORES_BY_MATERIAL.getOrDefault(material.id(), List.of()).forEach(ore -> inputs.add(ore.get()));
            Ingredient ingredient = Ingredient.of(inputs.toArray(ItemLike[]::new));
            SimpleCookingRecipeBuilder.smelting(ingredient, RecipeCategory.MISC, ingot, 0.7f, 200)
                    .unlockedBy("has_raw_ore", InventoryChangeTrigger.TriggerInstance.hasItems(raw))
                    .save(provider, ListMod.rl("ores/" + material.id() + "/smelting"));
            SimpleCookingRecipeBuilder.blasting(ingredient, RecipeCategory.MISC, ingot, 0.7f, 100)
                    .unlockedBy("has_raw_ore", InventoryChangeTrigger.TriggerInstance.hasItems(raw))
                    .save(provider, ListMod.rl("ores/" + material.id() + "/blasting"));
        }
        for (Material metal : METAL_MATERIALS) {
            if (metal.id().equals("iron") || metal.id().equals("gold")) continue; // Vanilla already supplies both recipes.
            ItemLike ingot = INGOTS.get(metal.id()).get();
            ItemLike nugget = NUGGETS.get(metal.id()).get();
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ingot)
                    .pattern("NNN").pattern("NNN").pattern("NNN").define('N', nugget)
                    .unlockedBy("has_nugget", InventoryChangeTrigger.TriggerInstance.hasItems(nugget))
                    .save(provider, ListMod.rl("ores/" + metal.id() + "/ingot_from_nuggets"));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, nugget, 9).requires(ingot)
                    .unlockedBy("has_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ingot))
                    .save(provider, ListMod.rl("ores/" + metal.id() + "/nuggets_from_ingot"));
        }
    }
}
