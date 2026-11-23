"""Copy the GTM gem textures used by ModOres, following icon-set inheritance."""
from pathlib import Path
import hashlib
import json
import re

ROOT = Path(__file__).resolve().parents[1]
SOURCE = ROOT / 'refar/GregTech-Modern-1.20.1/src/main/resources/assets/gtceu/textures'
DEST = ROOT / 'src/main/resources/assets/list/textures'
JAVA = ROOT / 'src/main/java/com/list/dsl/registrate/ModOres.java'
PARENTS = {
    'dull': None, 'metallic': 'dull', 'shiny': 'metallic', 'diamond': 'shiny',
    'emerald': 'diamond', 'gem_horizontal': 'emerald', 'gem_vertical': 'emerald',
    'ruby': 'emerald', 'opal': 'ruby', 'fine': 'dull', 'rough': 'fine',
    'lignite': 'rough', 'quartz': 'rough', 'certus': 'quartz', 'lapis': 'quartz',
}

def resolve(kind, icon, filename):
    current = icon
    while current is not None:
        candidate = SOURCE / kind / 'material_sets' / current / filename
        if candidate.is_file():
            return candidate
        current = PARENTS[current]
    raise FileNotFoundError(f'{kind}/{icon}/{filename}')

icons = sorted(set(re.findall(r'material\("[^"]+", "[^"]+", "[^"]+", "([^"]+)"', JAVA.read_text(encoding='utf-8'))))
manifest = {}
for icon in icons:
    for grade in ('gem', 'gem_chipped', 'gem_flawed', 'gem_flawless', 'gem_exquisite'):
        for suffix in ('', '_secondary', '_overlay'):
            source = resolve('item', icon, grade + suffix + '.png')
            dest = DEST / 'item/gt_gems' / icon / (grade + suffix + '.png')
            dest.parent.mkdir(parents=True, exist_ok=True)
            dest.write_bytes(source.read_bytes())
            manifest[str(dest.relative_to(ROOT)).replace('\\', '/')] = {
                'source': str(source.relative_to(ROOT)).replace('\\', '/'),
                'sha256': hashlib.sha256(source.read_bytes()).hexdigest(),
            }
            # Metadata belongs to the resolved PNG, including inherited animation frames.
            metadata_source = source.with_suffix('.png.mcmeta')
            if metadata_source.is_file():
                metadata_dest = dest.with_suffix('.png.mcmeta')
                metadata_dest.write_bytes(metadata_source.read_bytes())
                manifest[str(metadata_dest.relative_to(ROOT)).replace('\\', '/')] = {
                    'source': str(metadata_source.relative_to(ROOT)).replace('\\', '/'),
                    'sha256': hashlib.sha256(metadata_source.read_bytes()).hexdigest(),
                }
    source = resolve('block', icon, 'ore.png')
    dest = DEST / 'block/gt_gems' / icon / 'ore.png'
    dest.parent.mkdir(parents=True, exist_ok=True)
    dest.write_bytes(source.read_bytes())
    manifest[str(dest.relative_to(ROOT)).replace('\\', '/')] = {
        'source': str(source.relative_to(ROOT)).replace('\\', '/'),
        'sha256': hashlib.sha256(source.read_bytes()).hexdigest(),
    }
(ROOT / 'scripts/gt_gem_texture_sources.json').write_text(json.dumps(manifest, indent=2) + '\n', encoding='utf-8')
print(f'Copied {sum(p.endswith(".png") for p in manifest)} textures and {sum(p.endswith(".mcmeta") for p in manifest)} metadata files for {len(icons)} icon sets; source hashes recorded.')
