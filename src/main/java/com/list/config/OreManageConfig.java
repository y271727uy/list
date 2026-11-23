package com.list.config;

import com.list.ListMod;
import com.list.dsl.OreDsl;
import com.list.dsl.OreHost;
import com.list.worldgen.OreKind;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Global configuration. Registration and datagen never depend on these values. */
public final class OreManageConfig {
    public static final String FILE_NAME = "list/ore_manage.toml";
    static final Settings SETTINGS = new Settings();
    private static volatile Rules active = Rules.DEFAULTS;

    private OreManageConfig() {}

    @SuppressWarnings("removal")
    public static void register() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SETTINGS.spec, FILE_NAME);
        MinecraftForge.EVENT_BUS.addListener(OreManageConfig::onServerAboutToStart);
        MinecraftForge.EVENT_BUS.addListener(OreManageConfig::onServerStopped);
    }

    private static void onServerAboutToStart(ServerAboutToStartEvent event) {
        // Published before chunk generation starts; worldgen threads only read immutable sets.
        active = SETTINGS.snapshot();
        ListMod.LOGGER.info("Ore generation rules loaded from config/{}; changes take effect next world start", FILE_NAME);
    }

    private static void onServerStopped(ServerStoppedEvent event) {
        active = Rules.DEFAULTS;
    }

    public static boolean allows(OreKind kind, String family, String base) {
        return active.allows(kind, family, base);
    }

    static final class Settings {
        final ForgeConfigSpec spec;
        final ForgeConfigSpec.BooleanValue ores;
        final ForgeConfigSpec.BooleanValue gems;
        final ForgeConfigSpec.ConfigValue<List<? extends String>> disabledOres;
        final ForgeConfigSpec.ConfigValue<List<? extends String>> disabledGems;
        final ForgeConfigSpec.ConfigValue<List<? extends String>> baseGems;
        final ForgeConfigSpec.ConfigValue<List<? extends String>> baseOres;
        final ForgeConfigSpec.ConfigValue<List<? extends List<String>>> preciseGems;
        final ForgeConfigSpec.ConfigValue<List<? extends List<String>>> preciseOres;

        Settings() {
            var builder = new ForgeConfigSpec.Builder();
            ores = builder.comment(
                    "矿石生成管理 / Ore generation management (List mod ores only).",
                    "仅控制后续矿石放置，不取消方块、物品或世界生成条目注册，不删除旧矿石、不补矿。",
                    "Only gates future placement. All registry entries and existing blocks are preserved; no retrogen.",
                    "修改后重新进入世界或重启服务器生效；预生成/已完成矿石生成的区块不会重新生成。",
                    "Restart the world/server to apply changes; already decorated or pregenerated chunks are unchanged.",
                    "本文件为全局配置，作用于本实例服务端的所有存档；不控制原版或其他模组的生成。",
                    "Global config for all worlds hosted by this instance. Vanilla/other mods' generation is not managed.",
                    "矿脉仍遵循原版跨区块放置规则；不执行旧区块清理或逐区块重写。",
                    "Ore veins retain vanilla cross-chunk placement behavior; no old-chunk cleanup or rewrite is performed.",
                    "是否允许普通矿石自然生成；false 时下列普通矿石禁用列表不再影响结果。",
                    "Enable ordinary ore generation; false overrides all ordinary-ore lists below.",
                    "默认关闭普通矿石自然生成。 / Ordinary ore generation is disabled by default.")
                    .worldRestart().define("worldgen_ores", false);
            gems = builder.comment(
                    "是否允许宝石矿石自然生成；false 时下列宝石禁用列表不再影响结果。",
                    "Enable gem ore generation; false overrides all gem lists below.")
                    .worldRestart().define("worldgen_gems", true);
            disabledOres = builder.comment(
                    "禁止普通矿石全族：同一矿物的所有宿主变体都会停止生成。",
                    "Disable entire ordinary ore families, across every host variant.",
                    "填写本模组矿石族 ID，例如 [\"list:titanium_ore\"]；宿主变体 ID 也会归一到全族。",
                    "Use List family IDs, e.g. [\"list:titanium_ore\"]. Variant IDs also disable their entire family.",
                    "无效 ID 或类别不匹配会记录警告并忽略，不会取消注册。",
                    "Unknown IDs or wrong categories are warned and ignored; registry entries are never removed.")
                    .worldRestart().defineListAllowEmpty("disabled_ores", List.<String>of(), Settings::isText);
            disabledGems = builder.comment(
                    "禁止宝石矿石全族；例如 [\"list:ruby_ore\"] 禁止所有宿主的红宝石矿石。",
                    "Disable gem ore families; e.g. [\"list:ruby_ore\"] disables ruby ore in every host.",
                    "这里只接受本模组宝石矿石 ID，不接受宝石物品 ID 或普通矿石 ID。",
                    "Only List gem ore IDs are accepted, not gem item IDs or ordinary ore IDs.")
                    .worldRestart().defineListAllowEmpty("disabled_gems", List.<String>of(), Settings::isText);
            String[] hosts = {
                    "宿主英文 key / Host keys (Chinese aliases are also accepted):",
                    "stone=石头, deepslate=深板岩, granite=花岗岩, diorite=闪长岩, andesite=安山岩, tuff=凝灰岩, calcite=方解石",
                    "netherrack=下界岩, end_stone=末地石, sandstone=砂岩, gravel=沙砾, sand=沙子, red_sand=红沙",
                    "red_sandstone=红砂岩, basalt=玄武岩, blackstone=黑石, bedrock=基岩",
                    "只接受宿主名称，不接受矿石或宝石 ID；也可填写 minecraft:sand 这样的宿主方块 ID。",
                    "Only hosts are accepted, never ore/gem IDs. Host block IDs such as minecraft:sand are also accepted."
            };
            baseGems = builder.comment(hosts).comment(
                    "禁止指定宿主的全部宝石矿石；例如 [\"sand\"] 或 [\"沙子\"]。",
                    "Disable all gem ores in selected hosts; e.g. [\"sand\"] or [\"沙子\"].",
                    "默认禁止基岩、沙子、红沙、沙砾宿主；清空列表可允许这些宿主。",
                    "Bedrock, sand, red sand and gravel hosts are disabled by default; clear this list to allow them.")
                    .worldRestart().defineListAllowEmpty("disabled_base_gems", List.of("bedrock", "sand", "red_sand", "gravel"), Settings::isText);
            baseOres = builder.comment(hosts).comment(
                    "禁止指定宿主的全部普通矿石；例如 [\"sand\"]。",
                    "Disable all ordinary ores in selected hosts; e.g. [\"sand\"].")
                    .worldRestart().defineListAllowEmpty("disabled_base_ores", List.<String>of(), Settings::isText);
            preciseGems = builder.comment(
                    "仅禁止某个宿主中的某个宝石矿石族，不影响其他宿主或其他矿物。",
                    "Disable a gem family only in the specified host, leaving all other combinations enabled.",
                    "格式 / Format: [[\"sand\", \"list:ruby_ore\"], [\"gravel\", \"list:sapphire_ore\"]]",
                    "每对第一项必须是宿主，第二项必须是宝石矿石 ID，不能反过来。",
                    "Each pair must be [host, gem ore ID], in that order."
            ).worldRestart().defineListAllowEmpty("disabled_precise_base_gems", List.<List<String>>of(), Settings::isPair);
            preciseOres = builder.comment(
                    "仅禁止某个宿主中的某个普通矿石族；例如只禁止沙子基钛矿石。",
                    "Disable an ordinary ore family only in the specified host, e.g. sand-hosted titanium.",
                    "格式 / Format: [[\"sand\", \"list:titanium_ore\"]]",
                    "每对第一项必须是宿主，第二项必须是普通矿石 ID，不能反过来。",
                    "Each pair must be [host, ordinary ore ID], in that order.",
                    "未声明自然生成的矿物不会因为开启本配置而自动获得生成。",
                    "Enabling this config does not add worldgen to materials that have no generation definition."
            ).worldRestart().defineListAllowEmpty("disabled_precise_base_ores", List.<List<String>>of(), Settings::isPair);
            spec = builder.build();
        }

        private static boolean isText(Object value) {
            return value instanceof String text && !text.isBlank();
        }

        private static boolean isPair(Object value) {
            return value instanceof List<?> pair && pair.size() == 2 && pair.stream().allMatch(Settings::isText);
        }

        Rules snapshot() {
            var catalog = new Catalog(OreDsl.definitions());
            return new Rules(ores.get(), gems.get(),
                    catalog.families(disabledOres.get(), OreKind.ORE, "disabled_ores"),
                    catalog.families(disabledGems.get(), OreKind.GEM, "disabled_gems"),
                    catalog.bases(baseOres.get(), "disabled_base_ores"),
                    catalog.bases(baseGems.get(), "disabled_base_gems"),
                    catalog.pairs(preciseOres.get(), OreKind.ORE, "disabled_precise_base_ores"),
                    catalog.pairs(preciseGems.get(), OreKind.GEM, "disabled_precise_base_gems"));
        }
    }

    record Pair(String base, String family) {}

    record Rules(boolean ores, boolean gems, Set<String> disabledOres, Set<String> disabledGems,
                 Set<String> baseOres, Set<String> baseGems, Set<Pair> preciseOres, Set<Pair> preciseGems) {
        static final Rules DEFAULTS = new Rules(false, true, Set.of(), Set.of(), Set.of(),
                Set.of("bedrock", "sand", "red_sand", "gravel"), Set.of(), Set.of());

        Rules {
            disabledOres = Set.copyOf(disabledOres);
            disabledGems = Set.copyOf(disabledGems);
            baseOres = Set.copyOf(baseOres);
            baseGems = Set.copyOf(baseGems);
            preciseOres = Set.copyOf(preciseOres);
            preciseGems = Set.copyOf(preciseGems);
        }

        boolean allows(OreKind kind, String family, String base) {
            return kind == OreKind.GEM
                    ? gems && !disabledGems.contains(family) && !baseGems.contains(base) && !preciseGems.contains(new Pair(base, family))
                    : ores && !disabledOres.contains(family) && !baseOres.contains(base) && !preciseOres.contains(new Pair(base, family));
        }
    }

    static final class Catalog {
        private final Map<String, OreDsl.Definition> definitions = new HashMap<>();

        Catalog(List<OreDsl.Definition> entries) {
            for (var entry : entries) definitions.put(ListMod.rl(entry.id()).toString(), entry);
        }

        private String family(String text, OreKind kind, String key) {
            var definition = definitions.get(text);
            if (definition != null && definition.kind() == kind) return definition.family();
            ListMod.LOGGER.warn("{}: 无效矿石族或类别不匹配 / Unknown ore ID or wrong category: {}", key, text);
            return null;
        }

        private String base(String text, String key) {
            for (var host : OreHost.values()) if (host.matchesConfig(text)) return host.configKey();
            ListMod.LOGGER.warn("{}: 无效宿主 / Unknown host: {}", key, text);
            return null;
        }

        Set<String> families(List<? extends String> entries, OreKind kind, String key) {
            var result = new HashSet<String>();
            for (String entry : entries) {
                String family = family(entry, kind, key);
                if (family != null) result.add(family);
            }
            return Set.copyOf(result);
        }

        Set<String> bases(List<? extends String> entries, String key) {
            var result = new HashSet<String>();
            for (String entry : entries) {
                String base = base(entry, key);
                if (base != null) result.add(base);
            }
            return Set.copyOf(result);
        }

        Set<Pair> pairs(List<? extends List<String>> entries, OreKind kind, String key) {
            var result = new HashSet<Pair>();
            for (List<String> entry : entries) {
                String base = base(entry.get(0), key);
                String family = family(entry.get(1), kind, key);
                if (base != null && family != null) result.add(new Pair(base, family));
            }
            return Set.copyOf(result);
        }
    }
}
