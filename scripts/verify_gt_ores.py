"""Validate the active aluminium content and retired ordinary ore resources, with optional final-JAR verification."""
from pathlib import Path
import argparse
import hashlib
import json
import struct
import zipfile
from gt_normal_materials import ROOT, read_catalog, java_catalog, read_java_catalog
from gt5_ore_materials import read_gt5_ores
from import_gt_ore_textures import resolve

parser = argparse.ArgumentParser(description=__doc__)
parser.add_argument('--jar', type=Path)
args = parser.parse_args()
GEN = ROOT / 'src/generated/resources'
archive = zipfile.ZipFile(args.jar) if args.jar else None
checked_paths = set()
checks = 0


def check(condition, message):
    global checks
    assert condition, message
    checks += 1


def load(path):
    path = str(path).replace('\\', '/')
    file = GEN / path
    check(file.is_file(), 'Missing generated resource: ' + path)
    data = file.read_bytes()
    if archive:
        check(archive.read(path) == data, 'JAR mismatch: ' + path)
    checked_paths.add(path)
    return json.loads(data.decode('utf-8-sig'))


catalog = read_catalog()
check(json.loads((ROOT / 'scripts/gt_normal_ores.json').read_text(encoding='utf-8')) == catalog, 'Catalog matches current GTM declarations')
check(read_java_catalog() == java_catalog(catalog), 'Java catalog matches GTM declarations')
check(len(catalog['ores']) == 80 and len(catalog['metals']) == 20, '80 ordinary materials and 20 metal outputs')
gt5 = read_gt5_ores()['ORDINARY']
check(not {row['id'] for row in gt5} & {row['id'] for row in catalog['ores']}, 'No duplicate GTM ordinary ores')
zh = load('assets/list/dsl_lang/zh_cn.json')
en = load('assets/list/lang/en_us.json')
manifest = json.loads((ROOT / 'scripts/gt_ore_texture_sources.json').read_text())
new_items = []


def model(item, row, form, english, chinese):
    new_items.append(item)
    path = f'assets/list/models/item/{item}.json'
    result = load(path)
    check(result['parent'] == 'minecraft:item/generated', item + ' generated model')
    textures = result['textures']
    expected = {'layer0': f'list:item/gt_ores/{row["icon"]}/{form}',
                'layer1': f'list:item/gt_ores/{row["icon"]}/{form}_secondary'}
    if resolve('item', row['icon'], form + '_overlay.png', False):
        expected['layer2'] = f'list:item/gt_ores/{row["icon"]}/{form}_overlay'
    check(textures == expected, item + ' resolved GT layers')
    for texture in textures.values():
        png = 'src/main/resources/assets/list/textures/' + texture.removeprefix('list:') + '.png'
        check(png in manifest, item + ' texture in source manifest')
    check(zh['item.list.' + item] == chinese, item + ' Chinese')
    check(en['item.list.' + item] == english, item + ' English')


def item_tag(form, material, item):
    check(item in load(f'data/forge/tags/items/{form}.json')['values'], f'{item} general {form} tag')
    check(item in load(f'data/forge/tags/items/{form}/{material}.json')['values'], f'{item} material {form} tag')


aluminium_ore = next(row for row in catalog['ores'] if row['id'] == 'aluminium')
aluminium_metal = next(row for row in catalog['metals'] if row['id'] == 'aluminium')
raw, ingot, nugget = 'list:raw_aluminium', 'list:aluminium_ingot', 'list:aluminium_nugget'
model('raw_aluminium', aluminium_ore, 'raw_ore', 'Raw Aluminium', '粗铝')
model('aluminium_ingot', aluminium_metal, 'ingot', 'Aluminium Ingot', '铝锭')
model('aluminium_nugget', aluminium_metal, 'nugget', 'Aluminium Nugget', '铝粒')
item_tag('raw_materials', 'aluminium', raw)
for spelling in ('aluminium', 'aluminum'):
    item_tag('ingots', spelling, ingot)
    item_tag('nuggets', spelling, nugget)

ordinary_ore_ids = {row['id'] for row in catalog['ores'] + gt5}
metal_ids = {row['id'] for row in catalog['metals']}
retired = {'raw_' + material for material in ordinary_ore_ids - {'aluminium', 'iron', 'copper', 'gold', 'redstone'}}
retired.update(material + '_ingot' for material in metal_ids - {'aluminium', 'iron', 'copper', 'gold'})
retired.update(material + '_nugget' for material in metal_ids - {'aluminium', 'iron', 'gold'})
for item in retired:
    model_path = 'assets/list/models/item/' + item + '.json'
    check(not (GEN / model_path).exists(), item + ' retired model')
    check('item.list.' + item not in en and 'item.list.' + item not in zh, item + ' retired translations')
    if archive:
        check(model_path not in archive.namelist(), item + ' retired JAR model')

active_items = {raw, ingot, nugget}
for form in ('raw_materials', 'ingots', 'nuggets'):
    paths = [GEN / f'data/forge/tags/items/{form}.json', *(GEN / f'data/forge/tags/items/{form}').glob('*.json')]
    for path in paths:
        values = load(path.relative_to(GEN))['values']
        check({value for value in values if value.startswith('list:')} <= active_items,
              str(path) + ' only active List items')

recipes = 'data/list/recipes/ores'
unlocks = 'data/list/advancements/recipes/misc/ores'
expected = {'smelting.json', 'blasting.json', 'ingot_from_nuggets.json', 'nuggets_from_ingot.json'}
for folder in (recipes, unlocks):
    check({p.relative_to(GEN / folder).as_posix() for p in (GEN / folder).rglob('*.json')}
          == {'aluminium/' + name for name in expected}, folder + ' only aluminium files')
    for name in expected:
        load(f'{folder}/aluminium/{name}')

for mode, ticks in (('smelting', 200), ('blasting', 100)):
    recipe = load(f'{recipes}/aluminium/{mode}.json')
    check(recipe['type'] == 'minecraft:' + mode and recipe['cookingtime'] == ticks, mode + ' timing')
    check(recipe['ingredient'] == {'item': raw} and recipe['result'] == ingot, mode + ' input and output')

combine = load(f'{recipes}/aluminium/ingot_from_nuggets.json')
check(combine['type'] == 'minecraft:crafting_shaped' and combine['pattern'] == ['NNN'] * 3, '3x3 ingot recipe')
check(combine['key']['N']['item'] == nugget and combine['result'] == {'item': ingot}, 'Nine nuggets to one ingot')
split = load(f'{recipes}/aluminium/nuggets_from_ingot.json')
check(split['type'] == 'minecraft:crafting_shapeless', 'Shapeless nugget recipe')
check(split['ingredients'] == [{'item': ingot}] and split['result'] == {'item': nugget, 'count': 9},
      'One ingot to nine nuggets')

animated = 0
for path, source in manifest.items():
    data = (ROOT / path).read_bytes()
    check(data == (ROOT / source['source']).read_bytes(), path + ' source bytes')
    check(hashlib.sha256(data).hexdigest() == source['sha256'], path + ' source hash')
    if archive:
        check(archive.read(path.removeprefix('src/main/resources/')) == data, path + ' JAR bytes')
    if not path.endswith('.png'):
        continue
    original_metadata = Path(str(ROOT / source['source']) + '.mcmeta')
    metadata = Path(str(ROOT / path) + '.mcmeta')
    if original_metadata.is_file():
        check(path + '.mcmeta' in manifest and metadata.read_bytes() == original_metadata.read_bytes(), path + ' animation metadata')
    width, height = struct.unpack('>II', data[16:24])
    if width != height:
        animation = json.loads(metadata.read_text())['animation']
        fw = animation.get('width', width)
        fh = animation.get('height', fw)
        check(width % fw == 0 and height % fh == 0, path + ' animation frame geometry')
        frames = width // fw * (height // fh)
        for frame in animation.get('frames', range(frames)):
            index = frame['index'] if isinstance(frame, dict) else frame
            check(0 <= index < frames, path + ' animation frame index')
        animated += 1
check(animated >= 3, 'Radioactive raw, ingot and nugget animations')
tabs = (ROOT / 'src/main/java/com/list/all/ModCreativeModeTabs.java').read_text(encoding='utf-8')
check(tabs.index('ModOres.displayItems(output)') > tabs.index('ModOres.gemOres().forEach'), 'Ordinary items follow existing items and gems in miscellaneous')
items_source = (ROOT / 'src/main/java/com/list/all/ModItems.java').read_text(encoding='utf-8')
check('ALUMINUM_INGOT' not in items_source and 'NAQUADAH_INGOT' not in items_source, 'Legacy standalone ingot registrations removed')
check('ModItems.ALUMINUM_INGOT' not in tabs and 'ModItems.NAQUADAH_INGOT' not in tabs, 'Legacy manual creative entries removed')
check(not (GEN / 'assets/list/models/item/aluminum_ingot.json').exists(), 'Legacy aluminum model removed by datagen')
check('item.list.aluminum_ingot' not in en, 'Legacy aluminum language entry removed')
check('itemGroup.list.industrial_ores' not in en, 'No extra creative tab')
if archive:
    check('assets/list/models/item/aluminum_ingot.json' not in archive.namelist(), 'Legacy aluminum model absent from final JAR')
    merged = json.loads(archive.read('assets/list/lang/zh_cn.json'))
    original = json.loads((ROOT / 'src/main/resources/assets/list/lang/zh_cn.json').read_text(encoding='utf-8-sig'))
    check(all(merged[k] == v for k, v in original.items()), 'Original Chinese translations preserved')
    check(all(merged[k] == v for k, v in zh.items()), 'All generated Chinese translations merged')
    archive.close()
print(f'PASS: {checks} assertions; {len(new_items)} active ordinary items, '
      f'{len(expected)} recipes, {len(retired)} retired items; {len(checked_paths)} generated resources verified'
      + (' against final JAR.' if args.jar else '.'))
