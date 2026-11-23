"""Validate actual Forge/Registrate outputs from verify-ore-dsl.gradle (stdlib only)."""
import json
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
OUT = ROOT / "build/ore-dsl-smoke/resources"
checks = 0


def load(path):
    return json.loads((OUT / path).read_text(encoding="utf-8-sig"))


def check(condition, message):
    global checks
    if not condition:
        raise AssertionError(message)
    checks += 1


ids = ["dsl_smoke_layered_ore", "dsl_smoke_plain_ore", "dsl_smoke_no_generation"]
en = load("assets/list/lang/en_us.json")
zh = load("assets/list/dsl_lang/zh_cn.json")
for ore in ids:
    key = f"block.list.{ore}"
    check(key in en and key in zh, f"Both languages required: {ore}")
    item = load(f"assets/list/models/item/{ore}.json")
    check(item["parent"] == f"list:block/{ore}", f"Block item model: {ore}")
    state = load(f"assets/list/blockstates/{ore}.json")
    check(state["variants"][""]["model"] == f"list:block/{ore}", f"Blockstate: {ore}")
    loot = load(f"data/list/loot_tables/blocks/{ore}.json")
    alternative = loot["pools"][0]["entries"][0]
    check(alternative["type"] == "minecraft:alternatives", f"Silk dispatch: {ore}")
    silk, normal = alternative["children"]
    check(silk["name"] == f"list:{ore}", f"Silk Touch returns block: {ore}")
    check("minecraft:silk_touch" in json.dumps(silk["conditions"]), f"Silk Touch condition: {ore}")
    expected_drop = "minecraft:emerald" if ore == "dsl_smoke_plain_ore" else "minecraft:diamond"
    check(normal["name"] == expected_drop, f"Normal drop: {ore}")
    funcs = {f["function"]: f for f in normal["functions"]}
    check("minecraft:explosion_decay" in funcs, f"Explosion decay: {ore}")
    expected_fortune = ore != "dsl_smoke_no_generation"
    check(("minecraft:apply_bonus" in funcs) == expected_fortune, f"Fortune switch: {ore}")
    if expected_fortune:
        bonus = funcs["minecraft:apply_bonus"]
        check(bonus["enchantment"] == "minecraft:fortune" and bonus["formula"] == "minecraft:ore_drops", f"Ore Fortune formula: {ore}")
    if ore == "dsl_smoke_layered_ore":
        check(funcs["minecraft:set_count"]["count"]["min"] == 2 and funcs["minecraft:set_count"]["count"]["max"] == 4, "Base drop range")

model = load("assets/list/models/block/dsl_smoke_layered_ore.json")
check(model["textures"]["all"] == "minecraft:block/stone", "Untinted base texture")
check(model["textures"]["overlay"] == "minecraft:block/glass", "Overlay texture namespace")
check(model["render_type"] == "minecraft:cutout_mipped", "Cutout render type")
check(len(model["elements"]) == 2, "Two model layers")
check(all(v < 0 for v in model["elements"][1]["from"]) and all(v > 16 for v in model["elements"][1]["to"]), "Overlay sits outside base to avoid coplanar faces")
for face in model["elements"][0]["faces"].values():
    check(face.get("tintindex", -1) == -1 and face["texture"] == "#all", "Base must stay untinted")
for face in model["elements"][1]["faces"].values():
    check(face["tintindex"] == 0 and face["texture"] == "#overlay", "Overlay must use tint 0")
plain = load("assets/list/models/block/dsl_smoke_plain_ore.json")
check(plain["textures"]["all"] == "minecraft:block/emerald_ore" and "elements" not in plain, "Plain model has no tint elements")

for ore, size, count, low, high in [(ids[0], 7, 3, -32, 24), (ids[1], 5, 2, -64, 0)]:
    feature = load(f"data/list/worldgen/configured_feature/{ore}.json")
    check(feature["type"] == "minecraft:ore", f"Vanilla Feature.ORE: {ore}")
    check(feature["config"]["size"] == size, f"Vein size: {ore}")
    targets = feature["config"]["targets"]
    tags = [target["target"]["tag"] for target in targets]
    expected_tags = ["minecraft:stone_ore_replaceables"]
    if ore == ids[1]:
        expected_tags.append("minecraft:deepslate_ore_replaceables")
    check(tags == expected_tags, f"Replaceable host tags: {ore}")
    check(all(t["state"]["Name"] == f"list:{ore}" for t in targets), f"Correct ore block: {ore}")
    placement = load(f"data/list/worldgen/placed_feature/{ore}.json")
    check(placement["feature"] == f"list:{ore}", f"Configured feature reference: {ore}")
    modifiers = {p["type"]: p for p in placement["placement"]}
    check(modifiers["minecraft:count"]["count"] == count, f"Attempts per chunk: {ore}")
    height = modifiers["minecraft:height_range"]["height"]
    check(height["type"] == "minecraft:uniform" and height["min_inclusive"]["absolute"] == low and height["max_inclusive"]["absolute"] == high, f"Uniform height range: {ore}")
    modifier = load(f"data/list/forge/biome_modifier/add_{ore}.json")
    check(modifier["type"] == "forge:add_features" and modifier["step"] == "underground_ores", f"Biome integration: {ore}")
    expected_biomes = "#minecraft:is_mountain" if ore == ids[0] else "#minecraft:is_overworld"
    check(modifier["biomes"] == expected_biomes, f"Biome tag: {ore}")

for folder, prefix in [("worldgen/configured_feature", ""), ("worldgen/placed_feature", ""), ("forge/biome_modifier", "add_")]:
    check(not (OUT / f"data/list/{folder}/{prefix}{ids[2]}.json").exists(), "No generation entries unless opted in")
for ore in ids:
    for tier in ["mineable/pickaxe", "needs_iron_tool"]:
        check(f"list:{ore}" in load(f"data/minecraft/tags/blocks/{tier}.json")["values"], f"Mining tag {tier}: {ore}")
check(zh["block.list.dsl_smoke_layered_ore"] == "DSL测试叠层矿石", "Chinese text survives UTF-8 serialization")
print(f"Ore DSL smoke: {checks} output checks passed")
