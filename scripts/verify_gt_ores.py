"""Validate generated ordinary ores against GTM, with optional final-JAR verification."""
from pathlib import Path
from collections import Counter
import argparse
import hashlib
import json
import struct
import zipfile
from gt_normal_materials import ROOT, read_catalog, java_catalog, read_java_catalog
from gt5_ore_materials import read_gt5_ores, worldgen_paths
from verify_protected_bedrock import verify_bedrock_ore
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
vanilla = {'iron', 'copper', 'gold', 'redstone'}
vanilla_ingots = {'iron': 'minecraft:iron_ingot', 'gold': 'minecraft:gold_ingot', 'copper': 'minecraft:copper_ingot'}
hosts = [
    ('', 'stone', 'stone', '', '#minecraft:is_overworld', 0, 64, 4, 1),
    ('deepslate_', 'deepslate', 'deepslate', '深层', '#minecraft:is_overworld', -64, -1, 4, 1),
    ('granite_', 'granite', 'granite', '花岗岩', '#minecraft:is_overworld', -64, 64, 4, 1),
    ('diorite_', 'diorite', 'diorite', '闪长岩', '#minecraft:is_overworld', -64, 64, 4, 1),
    ('andesite_', 'andesite', 'andesite', '安山岩', '#minecraft:is_overworld', -64, 64, 4, 1),
    ('tuff_', 'tuff', 'tuff', '凝灰岩', '#minecraft:is_overworld', -64, 0, 4, 1),
    ('calcite_', 'calcite', 'calcite', '方解石', '#minecraft:is_overworld', -64, 256, 4, 1),
    ('netherrack_', 'netherrack', 'netherrack', '下界岩', '#minecraft:is_nether', 8, 120, 6, 2),
    ('endstone_', 'end_stone', 'end_stone', '末地石', '#minecraft:is_end', 0, 96, 6, 2),
    ('sandstone_', 'sandstone', 'sandstone', '砂岩', '#minecraft:is_overworld', -64, 256, 4, 1),
    ('gravel_', 'gravel', 'gravel', '沙砾', '#minecraft:is_overworld', -64, 256, 4, 1),
    ('sand_', 'sand', 'sand', '沙子', '#minecraft:is_overworld', -64, 256, 4, 1),
    ('red_sand_', 'red_sand', 'red_sand', '红沙', '#minecraft:is_overworld', -64, 256, 4, 1),
    ('red_sandstone_', 'red_sandstone', 'red_sandstone', '红砂岩', '#minecraft:is_overworld', -64, 256, 4, 1),
    ('basalt_', 'basalt', 'basalt_side', '玄武岩', '#minecraft:is_nether', 8, 120, 6, 2),
    ('blackstone_', 'blackstone', 'blackstone', '黑石', '#minecraft:is_nether', 8, 120, 6, 2),
    ('bedrock_', 'bedrock', 'bedrock', '基岩', '#minecraft:is_overworld', 1, 4, 1, 1),
]
zh = load('assets/list/dsl_lang/zh_cn.json')
en = load('assets/list/lang/en_us.json')
manifest = json.loads((ROOT / 'scripts/gt_ore_texture_sources.json').read_text())
new_items = []
all_ores = []
expected_recipes = set()
dimensions = Counter()


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


for row in catalog['ores'] + gt5:
    id = row['id']
    if id in vanilla:
        check('item.list.raw_' + id not in zh, id + ' no duplicate vanilla raw item')
        check('block.list.' + id + '_ore' not in zh, id + ' no duplicate vanilla ore')
        continue
    raw = 'raw_' + id
    model(raw, row, 'raw_ore', 'Raw ' + row['english'], '粗' + row['chinese'])
    item_tag('raw_materials', id, 'list:' + raw)
    variants = []
    for prefix, host, texture, cn, biome, min_y, max_y, size, attempts in hosts:
        ore = prefix + id + '_ore'
        all_ores.append(ore)
        variants.append('list:' + ore)
        block_model = load(f'assets/list/models/block/{ore}.json')
        check(block_model['textures']['all'] == 'minecraft:block/' + texture, ore + ' base texture')
        check(block_model['textures']['overlay'] == f'list:block/gt_ores/{row["icon"]}/ore', ore + ' GT overlay')
        check(len(block_model['elements']) == 2, ore + ' two cube layers')
        check(all(face['tintindex'] == 0 for face in block_model['elements'][1]['faces'].values()), ore + ' overlay tint index')
        check(load(f'assets/list/blockstates/{ore}.json')['variants']['']['model'] == 'list:block/' + ore, ore + ' blockstate')
        check(load(f'assets/list/models/item/{ore}.json')['parent'] == 'list:block/' + ore, ore + ' item model')
        check(zh['block.list.' + ore] == cn + row['chinese'] + '矿石', ore + ' Chinese')
        check(row['english'] in en['block.list.' + ore], ore + ' English')
        if host == 'bedrock':
            verify_bedrock_ore(ore, row.get('generates', True), False, load, check, GEN, archive)
            if row.get('generates', True):
                dimensions[biome] += 1
                dimensions['#minecraft:is_nether'] += 1
            continue
        loot = json.dumps(load(f'data/list/loot_tables/blocks/{ore}.json'))
        for value in ('minecraft:silk_touch', 'minecraft:fortune', 'minecraft:explosion_decay', 'list:' + raw, 'list:' + ore):
            check(value in loot, ore + ' loot ' + value)
        if not row.get('generates', True):
            for path in worldgen_paths(ore):
                check(not (GEN / path).exists(), ore + ' has no worldgen resource')
                if archive:
                    check(path not in archive.NameToInfo, ore + ' has no packaged worldgen resource')
            continue
        cfg = load(f'data/list/worldgen/configured_feature/{ore}.json')
        check(cfg['type'] == 'minecraft:ore', ore + ' ordinary ore feature')
        check(cfg['config']['size'] == size, ore + ' vein size')
        check(cfg['config']['targets'] == [{'target': {'predicate_type': 'minecraft:block_match', 'block': 'minecraft:' + host}, 'state': {'Name': 'list:' + ore}}], ore + ' exact host/result')
        placed = load(f'data/list/worldgen/placed_feature/{ore}.json')
        check(placed['feature'] == 'list:' + ore, ore + ' configured feature reference')
        placement = {p['type']: p for p in placed['placement']}
        check(placement['list:ore_config_filter'] == {'type': 'list:ore_config_filter', 'ore': 'list:' + id + '_ore', 'base': host, 'gem': False}, ore + ' ore management identity')
        check(placement['minecraft:count']['count'] == attempts, ore + ' attempts')
        check(placement['minecraft:rarity_filter']['chance'] == 2, ore + ' 50 percent attempt filter')
        check([p['type'] for p in placed['placement']] == ['list:ore_config_filter', 'minecraft:count', 'minecraft:rarity_filter', 'minecraft:in_square', 'minecraft:height_range', 'minecraft:biome'], ore + ' rarity applied per attempt')
        check(placement['minecraft:height_range']['height'] == {'type': 'minecraft:uniform', 'min_inclusive': {'absolute': min_y}, 'max_inclusive': {'absolute': max_y}}, ore + ' height distribution')
        check('minecraft:biome' in placement and 'minecraft:in_square' in placement, ore + ' placement filters')
        modifier = load(f'data/list/forge/biome_modifier/add_{ore}.json')
        check(modifier == {'type': 'forge:add_features', 'biomes': biome, 'features': 'list:' + ore, 'step': 'underground_ores'}, ore + ' dimension injection')
        dimensions[biome] += 1
    for form in ('items', 'blocks'):
        tag = set(load(f'data/forge/tags/{form}/ores/{id}.json')['values'])
        check(set(variants) <= tag, id + ' material ore tag ' + form)
    for mode, ticks in (('smelting', 200), ('blasting', 100)):
        path = f'data/list/recipes/ores/{id}/{mode}.json'
        if not row['output']:
            check(not (GEN / path).exists(), id + ' no invented smelting target')
            continue
        expected_recipes.add(path)
        recipe = load(path)
        check(recipe['type'] == 'minecraft:' + mode, id + ' cooking recipe type')
        output = vanilla_ingots.get(row['output'], 'list:' + row['output'] + '_ingot')
        check(recipe['result'] == output, id + ' exact GT smelt result')
        check(recipe['cookingtime'] == ticks and recipe['experience'] == 0.7, id + ' cooking timing and experience')
        check({i['item'] for i in recipe['ingredient']} == {'list:' + raw, *variants}, id + ' raw and all silk-touched hosts can smelt')

for row in catalog['metals']:
    id = row['id']
    ingot = vanilla_ingots.get(id, 'list:' + id + '_ingot')
    nugget = 'minecraft:' + id + '_nugget' if id in {'iron', 'gold'} else 'list:' + id + '_nugget'
    if id not in vanilla_ingots:
        model(id + '_ingot', row, 'ingot', row['english'] + ' Ingot', row['chinese'] + '锭')
    if id not in {'iron', 'gold'}:
        model(id + '_nugget', row, 'nugget', row['english'] + ' Nugget', row['chinese'] + '粒')
    item_tag('ingots', id, ingot)
    item_tag('nuggets', id, nugget)
    if id == 'aluminium':
        item_tag('ingots', 'aluminum', ingot)
        item_tag('nuggets', 'aluminum', nugget)
    if id in {'iron', 'gold'}:
        continue
    combine = f'data/list/recipes/ores/{id}/ingot_from_nuggets.json'
    split = f'data/list/recipes/ores/{id}/nuggets_from_ingot.json'
    expected_recipes.update((combine, split))
    recipe = load(combine)
    check(recipe['type'] == 'minecraft:crafting_shaped' and recipe['pattern'] == ['NNN'] * 3, id + ' 3x3 ingot recipe')
    check(recipe['key']['N']['item'] == nugget and recipe['result']['item'] == ingot, id + ' nugget compression target')
    check(recipe['result'].get('count', 1) == 1, id + ' one ingot')
    recipe = load(split)
    check(recipe['type'] == 'minecraft:crafting_shapeless', id + ' nugget recipe type')
    check(recipe['ingredients'] == [{'item': ingot}], id + ' nugget recipe source')
    check(recipe['result'] == {'item': nugget, 'count': 9}, id + ' nine nuggets')

check(len(all_ores) == (76 + len(gt5)) * len(hosts), 'One ordinary block per material and host')
check(len(new_items) == len(set(new_items)) == 111 + len(gt5), 'Raw items, ingots and nuggets')
check(len(expected_recipes) == 106, '70 cooking + 36 nugget conversion recipes')
actual_recipes = {p.relative_to(GEN).as_posix() for p in (GEN / 'data/list/recipes/ores').glob('**/*.json')}
check(expected_recipes == actual_recipes, 'Exact ordinary recipe set, no duplicate or stale recipes')
generating = 76 + sum(row['generates'] for row in gt5)
check(dimensions == {'#minecraft:is_overworld': 13 * generating, '#minecraft:is_nether': 4 * generating,
                     '#minecraft:is_end': generating}, 'Ordinary dimension counts')
check(not any('dust' in item or item.startswith('gt_') for item in new_items), 'No new dusts or duplicate gt-prefixed metal items')
shovel_ores = {'list:' + ore for ore in all_ores if ore.startswith(('sand_', 'red_sand_', 'gravel_'))}
all_ore_items = {'list:' + ore for ore in all_ores}
for tag, expected in (('mineable/pickaxe', all_ore_items - shovel_ores), ('mineable/shovel', shovel_ores), ('needs_iron_tool', all_ore_items)):
    values = set(load(f'data/minecraft/tags/blocks/{tag}.json')['values'])
    check(expected <= values, 'Correct ordinary ores in ' + tag)
    if tag == 'mineable/pickaxe': check(not shovel_ores & values, 'Loose hosts not pickaxe ores')
    if tag == 'mineable/shovel': check(not (all_ore_items - shovel_ores) & values, 'Stone hosts not shovel ores')
for form in ('blocks', 'items'):
    check({'list:' + ore for ore in all_ores} <= set(load(f'data/forge/tags/{form}/ores.json')['values']), 'All ordinary ores in Forge ' + form + ' ores')
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
print(f'PASS: {checks} assertions; {len(all_ores)} ordinary ore blocks, {len(new_items)} items, '
      f'{len(expected_recipes)} recipes; {len(checked_paths)} generated resources verified'
      + (' against final JAR.' if args.jar else '.'))
