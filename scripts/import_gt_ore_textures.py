"""Import ordinary ore textures and metadata from the local GTM reference."""
from pathlib import Path
import hashlib
import json
import re
from gt_normal_materials import ROOT, GT, read_catalog

SOURCE = GT / 'src/main/resources/assets/gtceu/textures'
DEST = ROOT / 'src/main/resources/assets/list/textures'


def icon_parents():
    text = (GT / 'src/main/java/com/gregtechceu/gtceu/api/data/chemical/material/info/MaterialIconSet.java').read_text(encoding='utf-8')
    parents = {}
    for match in re.finditer(r'public static final MaterialIconSet (\w+) = new MaterialIconSet\(GTCEu.id\("([^"]+)"\)([^;]*)\);', text):
        symbol, name, suffix = match.groups()
        parent = re.match(r',\s*(\w+)', suffix)
        parents[name] = None if symbol == 'DULL' else parent[1].lower() if parent else 'dull'
    return parents


PARENTS = icon_parents()


def resolve(kind, icon, filename, required=True):
    current = icon
    while current is not None:
        candidate = SOURCE / kind / 'material_sets' / current / filename
        if candidate.is_file():
            return candidate
        current = PARENTS[current]
    if required:
        raise FileNotFoundError(f'{kind}/{icon}/{filename}')
    return None


def import_textures():
    catalog = read_catalog()
    requests = set()
    for row in catalog['ores']:
        if row['id'] in {'iron', 'copper', 'gold', 'redstone'}:
            continue
        requests.add(('block', row['icon'], 'ore'))
        for suffix in ('', '_secondary'):
            requests.add(('item', row['icon'], 'raw_ore' + suffix))
        if resolve('item', row['icon'], 'raw_ore_overlay.png', False):
            requests.add(('item', row['icon'], 'raw_ore_overlay'))
    for row in catalog['metals']:
        for form in ('ingot', 'nugget'):
            if form == 'ingot' and row['id'] in {'iron', 'copper', 'gold'}:
                continue
            if form == 'nugget' and row['id'] in {'iron', 'gold'}:
                continue
            for suffix in ('', '_secondary'):
                requests.add(('item', row['icon'], form + suffix))
            if resolve('item', row['icon'], form + '_overlay.png', False):
                requests.add(('item', row['icon'], form + '_overlay'))
    manifest = {}
    for kind, icon, name in sorted(requests):
        source = resolve(kind, icon, name + '.png')
        dest = DEST / kind / 'gt_ores' / icon / (name + '.png')
        dest.parent.mkdir(parents=True, exist_ok=True)
        for src, target in ((source, dest), (source.with_suffix('.png.mcmeta'), dest.with_suffix('.png.mcmeta'))):
            if not src.is_file():
                continue
            target.write_bytes(src.read_bytes())
            manifest[target.relative_to(ROOT).as_posix()] = {
                'source': src.relative_to(ROOT).as_posix(),
                'sha256': hashlib.sha256(src.read_bytes()).hexdigest(),
            }
    (ROOT / 'scripts/gt_ore_texture_sources.json').write_text(json.dumps(manifest, indent=2) + '\n', encoding='utf-8')
    print(f'Imported {sum(p.endswith(".png") for p in manifest)} PNGs and {sum(p.endswith(".mcmeta") for p in manifest)} animation metadata files.')


if __name__ == '__main__':
    import_textures()
