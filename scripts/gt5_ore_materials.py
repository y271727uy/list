"""Read the GT5 additions for the ore resource verifiers."""
from pathlib import Path
import re


ROOT = Path(__file__).resolve().parents[1]
CATALOG = ROOT / 'src/main/java/com/list/dsl/registrate/ModOres.java'
NATURAL = {
    'amber', 'bismuth', 'fools_ruby', 'glauconite', 'iridium', 'jasper', 'lignite',
    'enriched_naquadah', 'phosphate', 'phosphorus', 'tanzanite', 'uranium', 'zinc',
}


def read_gt5_ores():
    text = CATALOG.read_text(encoding='utf-8')
    rows = {}
    for group, body in re.findall(r'List<ExtraOre> (EXTRA_ORDINARY|EXTRA_GEM_ORES) = List.of\((.*?)\n    \);', text, re.S):
        rows[{'EXTRA_ORDINARY': 'ORDINARY', 'EXTRA_GEM_ORES': 'GEMS'}[group]] = [
            dict(id=id, english=english, chinese=chinese, icon=icon, generates=generates == 'true', output='')
            for id, english, chinese, icon, generates in re.findall(
                r'extraOre\("([^"]+)", "([^"]+)", "([^"]+)", "([^"]+)", 0x[\da-f]+, 0x[\da-f]+, (true|false)\)', body
            )
        ]
    assert len(rows['ORDINARY']) == 79 and len(rows['GEMS']) == 20
    all_rows = rows['ORDINARY'] + rows['GEMS']
    assert len({row['id'] for row in all_rows}) == len(all_rows), 'Duplicate GT5 material ID'
    assert {row['id'] for row in all_rows if row['generates']} == NATURAL, 'GT5 worldgen material set'
    return rows


def worldgen_paths(ore):
    paths = (
        f'data/list/worldgen/configured_feature/{ore}.json',
        f'data/list/worldgen/placed_feature/{ore}.json',
        f'data/list/forge/biome_modifier/add_{ore}.json',
    )
    return paths + ((f'data/list/forge/biome_modifier/add_{ore}_nether.json',) if ore.startswith('bedrock_') else ())
