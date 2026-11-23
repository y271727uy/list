"""Check isolated Forge outputs; --apply merges only config filters into existing placements."""
import argparse
import json
from pathlib import Path
import tomllib

ROOT = Path(__file__).resolve().parents[1]
SMOKE = ROOT / "build/ore-manage-smoke"
GENERATED = SMOKE / "resources/data/list/worldgen/placed_feature"
TARGET = ROOT / "src/generated/resources/data/list/worldgen/placed_feature"
HOSTS = {
    "stone", "deepslate", "granite", "diorite", "andesite", "tuff", "calcite",
    "netherrack", "end_stone", "sandstone", "gravel", "sand", "red_sand",
    "red_sandstone", "basalt", "blackstone", "bedrock",
}
KEYS = {
    "worldgen_ores", "worldgen_gems", "disabled_ores", "disabled_gems",
    "disabled_base_gems", "disabled_base_ores", "disabled_precise_base_gems",
    "disabled_precise_base_ores",
}
FILTER = "list:ore_config_filter"


def load(path):
    return json.loads(path.read_text(encoding="utf-8-sig"))


def without_filter(value):
    return {**value, "placement": [entry for entry in value["placement"] if entry["type"] != FILTER]}


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("--apply", action="store_true", help="Merge only filter metadata; preserve existing parameters")
    options = parser.parse_args()
    config = SMOKE / "run/config/list/ore_manage.toml"
    text = config.read_text(encoding="utf-8-sig")
    settings = tomllib.loads(text)
    assert set(settings) == KEYS, "Expected exactly eight top-level settings"
    assert settings["worldgen_ores"] is False and settings["worldgen_gems"] is True
    assert settings["disabled_base_gems"] == ["bedrock", "sand", "red_sand", "gravel"]
    assert all(settings[key] == [] for key in KEYS if not key.startswith("worldgen_") and key != "disabled_base_gems")
    assert "矿石生成管理" in text and "Ore generation management" in text
    assert "bedrock=基岩" in text
    assert GENERATED.is_dir(), "Run isolated Forge datagen first"
    records = []
    for source in sorted(GENERATED.glob("*.json")):
        data = load(source)
        filters = [p for p in data["placement"] if p["type"] == FILTER]
        if not filters:
            assert not source.stem.endswith("_ore"), f"Unmanaged ore placement: {source.name}"
            continue
        assert len(filters) == 1 and data["placement"][0] == filters[0], source.name
        gate = filters[0]
        assert gate["base"] in HOSTS and type(gate["gem"]) is bool, source.name
        assert gate["ore"].startswith("list:") and gate["ore"].endswith("_ore"), source.name
        configured = SMOKE / "resources/data/list/worldgen/configured_feature" / source.name
        biome = SMOKE / "resources/data/list/forge/biome_modifier" / f"add_{source.name}"
        assert configured.is_file() and biome.is_file(), f"Worldgen entries must remain present: {source.name}"
        assert data["feature"] == f"list:{source.stem}", source.name
        records.append((source, data, gate))
    assert records and any(gate["gem"] for _, _, gate in records) and any(not gate["gem"] for _, _, gate in records)
    # Preflight every target before any writes, to avoid partial merges for missing declarations.
    for source, _, _ in records:
        assert (TARGET / source.name).is_file(), f"Missing production placement: {source.name}; generate its full worldgen first"
        production_data = ROOT / "src/generated/resources/data/list"
        assert (production_data / "worldgen/configured_feature" / source.name).is_file(), f"Missing configured feature: {source.name}"
        assert (production_data / "forge/biome_modifier" / f"add_{source.name}").is_file(), f"Missing biome modifier: {source.name}"
    changed = 0
    for source, data, gate in records:
        target = TARGET / source.name
        current = load(target)
        expected = without_filter(current)
        merged = {**current, "placement": [gate, *expected["placement"]]}
        assert without_filter(merged) == expected, f"Existing parameters changed: {source.name}"
        if options.apply and current != merged:
            target.write_text(json.dumps(merged, indent=2, ensure_ascii=False) + "\n", encoding="utf-8")
            changed += 1
        final = load(target)
        assert final["placement"][0] == gate, f"Missing/stale filter: {source.name}; rerun with --apply"
        assert without_filter(final) == expected, f"Existing parameters modified: {source.name}"
    print(f"Ore manage: TOML, bilingual comments, {len(records)} registered placements checked; {changed} filter-only updates")


if __name__ == "__main__":
    main()
