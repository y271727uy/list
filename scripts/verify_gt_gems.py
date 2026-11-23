"""Validate generated gems against GT declarations, loot, recipes, models and worldgen."""
from pathlib import Path
import hashlib
import json
import re
from gt5_ore_materials import read_gt5_ores, worldgen_paths
from verify_protected_bedrock import verify_bedrock_ore

ROOT = Path(__file__).resolve().parents[1]
GEN = ROOT / 'src/generated/resources'
checks = 0

def check(condition, message):
    global checks
    assert condition, message
    checks += 1

def load(path):
    path = Path(path)
    check(path.is_file(), f'Missing {path}')
    return json.loads(path.read_text(encoding='utf-8-sig'))

java = (ROOT / 'src/main/java/com/list/dsl/registrate/ModOres.java').read_text(encoding='utf-8')
rows = re.findall(r'material\("([^"]+)", "([^"]+)", "([^"]+)", "([^"]+)", (0x[\da-f]+), (0x[\da-f]+), (.*?), (true|false)\);', java)
reference = set()
for path in (ROOT / 'refar/GregTech-Modern-1.20.1/src/main/java/com/gregtechceu/gtceu/common/data/materials').glob('*.java'):
    for m in re.finditer(r'\w+\s*=\s*new Material.Builder\(GTCEu.id\("([^"\n]+)"\)\)(.*?)\.buildAndRegister\(\)', path.read_text(encoding='utf-8'), re.S):
        if re.search(r'\.gem\(', m[2]) and re.search(r'\.ore\(', m[2]): reference.add(m[1])
check({r[0] for r in rows} == reference, f'GT gem ore mismatch: {reference ^ {r[0] for r in rows}}')
check(len(rows) == 30, 'Expected 30 GT gem ore materials')
gt5 = read_gt5_ores()['GEMS']
check(not {row['id'] for row in gt5} & reference, 'No duplicate GTM gem ores')
without_worldgen = {row['id'] for row in gt5 if not row['generates']}
rows.extend((row['id'], row['english'], row['chinese'], row['icon'], '', '', 'null', 'false') for row in gt5)
grades = [('chipped_', '破碎的', 1), ('flawed_', '有瑕的', 2), ('', '', 4), ('flawless_', '无瑕的', 8), ('exquisite_', '精致的', 16)]
vanilla = {'diamond':'diamond', 'emerald':'emerald', 'lapis':'lapis_lazuli', 'coal':'coal', 'nether_quartz':'quartz', 'amethyst':'amethyst_shard'}
zh = load(GEN / 'assets/list/dsl_lang/zh_cn.json')
en = load(GEN / 'assets/list/lang/en_us.json')
items = {}; ore_ids = []; item_count = 0
item_suffixes = {
    'vinteum': '晶石', 'dilithium': '晶体',
}
for id, english, chinese, icon, color, secondary, supplier, has_vanilla_ore in rows:
    ids = []
    for prefix, cn, units in grades:
        name = prefix + id + '_gem'
        if not prefix and id in vanilla:
            ids.append('minecraft:' + vanilla[id]); continue
        ids.append('list:' + name); items['list:' + name] = units; item_count += 1
        model = load(GEN / f'assets/list/models/item/{name}.json')
        check(model['parent'] == 'minecraft:item/generated', name + ' model parent')
        check(len(model['textures']) == 3, name + ' three layers')
        for texture in model['textures'].values():
            check(texture.startswith('list:'), name + ' namespace')
            check((ROOT / ('src/main/resources/assets/list/textures/' + texture.split(':')[1] + '.png')).is_file(), texture)
        check(zh['item.list.' + name] == cn + chinese + item_suffixes.get(id, ''), name + ' Chinese')
        check('item.list.' + name in en, name + ' English')
    for index in range(4):
        grade = ['flawed', 'normal', 'flawless', 'exquisite'][index]
        for direction in ('combine', 'split'):
            recipe = load(GEN / f'data/list/recipes/gems/{id}/{direction}_{grade}.json')
            check(recipe['type'] == 'minecraft:crafting_shapeless', id + ' recipe type')
            expected_input = [ids[index], ids[index]] if direction == 'combine' else [ids[index + 1]]
            expected_output = ids[index + 1] if direction == 'combine' else ids[index]
            check([x['item'] for x in recipe['ingredients']] == expected_input, id + ' recipe ingredients')
            check(recipe['result']['item'] == expected_output, id + ' recipe result')
            check(recipe['result'].get('count', 1) == (1 if direction == 'combine' else 2), id + ' recipe count')
    if has_vanilla_ore == 'true': continue
    hosts = [
        ('', 'stone', 'minecraft:block/stone', 'minecraft:stone', 0, 64, '#minecraft:is_overworld', 4, 1),
        ('deepslate_', 'deepslate', 'minecraft:block/deepslate', 'minecraft:deepslate', -64, -1, '#minecraft:is_overworld', 4, 1),
        ('granite_', 'granite', 'minecraft:block/granite', 'minecraft:granite', -64, 64, '#minecraft:is_overworld', 4, 1),
        ('diorite_', 'diorite', 'minecraft:block/diorite', 'minecraft:diorite', -64, 64, '#minecraft:is_overworld', 4, 1),
        ('andesite_', 'andesite', 'minecraft:block/andesite', 'minecraft:andesite', -64, 64, '#minecraft:is_overworld', 4, 1),
        ('tuff_', 'tuff', 'minecraft:block/tuff', 'minecraft:tuff', -64, 0, '#minecraft:is_overworld', 4, 1),
        ('calcite_', 'calcite', 'minecraft:block/calcite', 'minecraft:calcite', -64, 256, '#minecraft:is_overworld', 4, 1),
        ('netherrack_', 'netherrack', 'minecraft:block/netherrack', 'minecraft:netherrack', 8, 120, '#minecraft:is_nether', 6, 2),
        ('endstone_', 'endstone', 'minecraft:block/end_stone', 'minecraft:end_stone', 0, 96, '#minecraft:is_end', 6, 2),
        ('sandstone_', 'sandstone', 'minecraft:block/sandstone', 'minecraft:sandstone', -64, 256, '#minecraft:is_overworld', 4, 1),
        ('gravel_', 'gravel', 'minecraft:block/gravel', 'minecraft:gravel', -64, 256, '#minecraft:is_overworld', 4, 1),
        ('sand_', 'sand', 'minecraft:block/sand', 'minecraft:sand', -64, 256, '#minecraft:is_overworld', 4, 1),
        ('red_sand_', 'red_sand', 'minecraft:block/red_sand', 'minecraft:red_sand', -64, 256, '#minecraft:is_overworld', 4, 1),
        ('red_sandstone_', 'red_sandstone', 'minecraft:block/red_sandstone', 'minecraft:red_sandstone', -64, 256, '#minecraft:is_overworld', 4, 1),
        ('basalt_', 'basalt', 'minecraft:block/basalt_side', 'minecraft:basalt', 8, 120, '#minecraft:is_nether', 6, 2),
        ('blackstone_', 'blackstone', 'minecraft:block/blackstone', 'minecraft:blackstone', 8, 120, '#minecraft:is_nether', 6, 2),
        ('bedrock_', 'bedrock', 'minecraft:block/bedrock', 'minecraft:bedrock', 1, 4, '#minecraft:is_overworld', 1, 1),
    ]
    for prefix, host, base_texture, replace_target, min_y, max_y, biome_tag, vein_size, attempts in hosts:
        ore = prefix + id + '_ore'; ore_ids.append(ore)
        model = load(GEN / f'assets/list/models/block/{ore}.json')
        check(model['textures']['all'] == base_texture, ore + ' base')
        check(len(model['elements']) == 2, ore + ' layers')
        check(model['textures']['overlay'] == f'list:block/gt_gems/{icon}/ore', ore + ' overlay')
        state = load(GEN / f'assets/list/blockstates/{ore}.json')
        check(state['variants']['']['model'] == 'list:block/' + ore, ore + ' blockstate')
        item_model = load(GEN / f'assets/list/models/item/{ore}.json')
        check(item_model['parent'] == 'list:block/' + ore, ore + ' item model')
        check('block.list.' + ore in en, ore + ' English')
        if host == 'bedrock':
            check(zh['block.list.' + ore] == '基岩' + chinese + '矿石', ore + ' Chinese')
            verify_bedrock_ore(ore, id not in without_worldgen, True, lambda path: load(GEN / path), check, GEN)
            continue
        loot = load(GEN / f'data/list/loot_tables/blocks/{ore}.json')
        text = json.dumps(loot)
        check('silk_touch' in text and 'fortune' in text and 'explosion_decay' in text, ore + ' loot functions')
        check(ids[2] in text, ore + ' ordinary gem drop')
        prefix_cn = {'deepslate_':'深层', 'granite_':'花岗岩', 'diorite_':'闪长岩', 'andesite_':'安山岩', 'tuff_':'凝灰岩', 'calcite_':'方解石', 'netherrack_':'下界岩', 'endstone_':'末地石', 'sandstone_':'砂岩', 'gravel_':'沙砾', 'sand_':'沙子', 'red_sand_':'红沙', 'red_sandstone_':'红砂岩', 'basalt_':'玄武岩', 'blackstone_':'黑石'}.get(prefix, '')
        check(zh['block.list.' + ore] == prefix_cn + chinese + '矿石', ore + ' Chinese')
        if id in without_worldgen:
            for path in worldgen_paths(ore):
                check(not (GEN / path).exists(), ore + ' has no worldgen resource')
            continue
        feature = load(GEN / f'data/list/worldgen/configured_feature/{ore}.json')
        check(feature['type'] == 'minecraft:ore', ore + ' vanilla feature')
        config = feature['config']; check(config['size'] == vein_size, ore + ' size')
        check(len(config['targets']) == 1, ore + ' single host')
        target = config['targets'][0]['target']
        check(target['predicate_type'] == 'minecraft:block_match' and target['block'] == replace_target, ore + ' exact host')
        placed = load(GEN / f'data/list/worldgen/placed_feature/{ore}.json')
        management = next(x for x in placed['placement'] if x['type'] == 'list:ore_config_filter')
        check(management == {'type': 'list:ore_config_filter', 'ore': 'list:' + id + '_ore', 'base': replace_target.split(':', 1)[1], 'gem': True}, ore + ' ore management identity')
        height = next(x for x in placed['placement'] if x['type'] == 'minecraft:height_range')['height']
        check(height['min_inclusive']['absolute'] == min_y, ore + ' minY')
        check(height['max_inclusive']['absolute'] == max_y, ore + ' maxY')
        modifier = load(GEN / f'data/list/forge/biome_modifier/add_{ore}.json')
        check(modifier['biomes'] == biome_tag, ore + ' dimension biomes')
        check(modifier['features'] == 'list:' + ore, ore + ' modifier feature')
        check(modifier['step'] == 'underground_ores', ore + ' generation step')
        check(config['targets'][0]['state']['Name'] == 'list:' + ore, ore + ' target result')
        check(next(x for x in placed['placement'] if x['type'] == 'minecraft:count')['count'] == attempts, ore + ' attempts')
        rarity = next(x for x in placed['placement'] if x['type'] == 'minecraft:rarity_filter')
        check(rarity['chance'] == 2, ore + ' 50 percent attempt filter')
        check([x['type'] for x in placed['placement']] == ['list:ore_config_filter', 'minecraft:count', 'minecraft:rarity_filter', 'minecraft:in_square', 'minecraft:height_range', 'minecraft:biome'], ore + ' each attempt filtered after count')
check(item_count == 144 + 5 * len(gt5), 'Gem quality item count')
check(len(ore_ids) == (25 + len(gt5)) * 17, 'One gem ore block per material and host')
shovel_ores = {'list:' + ore for ore in ore_ids if ore.startswith(('sand_', 'red_sand_', 'gravel_'))}
all_ore_items = {'list:' + ore for ore in ore_ids}
for tag, expected in (('mineable/pickaxe', all_ore_items - shovel_ores), ('mineable/shovel', shovel_ores), ('needs_iron_tool', all_ore_items)):
    values = set(load(GEN / f'data/minecraft/tags/blocks/{tag}.json')['values'])
    check(expected <= values, tag + ' correct ore variants')
    if tag == 'mineable/pickaxe': check(not shovel_ores & values, 'loose hosts not pickaxe ores')
    if tag == 'mineable/shovel': check(not (all_ore_items - shovel_ores) & values, 'stone hosts not shovel ores')
recipe_count = len(rows) * (len(grades) - 1) * 2
check(len(list((GEN / 'data/list/recipes/gems').glob('*/*.json'))) == recipe_count, 'No stale gem recipes')
manifest = load(ROOT / 'scripts/gt_gem_texture_sources.json')
animated = 0
for path, source in manifest.items():
    dest = ROOT / path
    check(hashlib.sha256(dest.read_bytes()).hexdigest() == source['sha256'], path + ' hash')
    check(dest.read_bytes() == (ROOT / source['source']).read_bytes(), path + ' source')
    if not path.endswith('.png'): continue
    original_metadata = Path(str(ROOT / source['source']) + '.mcmeta')
    metadata = Path(str(dest) + '.mcmeta')
    if original_metadata.is_file():
        check(path + '.mcmeta' in manifest, path + ' metadata tracked')
        check(metadata.is_file(), path + ' metadata exists')
        check(metadata.read_bytes() == original_metadata.read_bytes(), path + ' metadata matches source')
    import struct
    width, height = struct.unpack('>II', dest.read_bytes()[16:24])
    if width != height:
        animation = load(metadata)['animation']
        frame_width = animation.get('width', width)
        frame_height = animation.get('height', frame_width)
        check(width % frame_width == 0 and height % frame_height == 0, path + ' frame dimensions')
        frame_count = (width // frame_width) * (height // frame_height)
        check(frame_count > 1, path + ' multiple frames')
        for frame in animation.get('frames', range(frame_count)):
            index = frame.get('index') if isinstance(frame, dict) else frame
            check(0 <= index < frame_count, path + ' valid frame index')
        animated += 1
check(animated > 0, 'animated gem textures validated')
check('itemGroup.list.gemstones' not in zh and 'itemGroup.list.gemstones' not in en, 'removed tab translations')
tabs = (ROOT / 'src/main/java/com/list/all/ModCreativeModeTabs.java').read_text(encoding='utf-8')
check('GEMSTONES_TAB' not in tabs and 'CREATIVE_TABS.register("gemstones"' not in tabs, 'no standalone gem tab')
misc = tabs[tabs.index('MANMADETAB ='):]
check('for (ModOres.Gem gem : ModOres.gems())' in misc and 'ModOres.gemOres().forEach' in misc, 'gems and ores in miscellaneous tab')
active_misc = '\n'.join(line.split('//', 1)[0] for line in misc.split('.build()', 1)[0].splitlines())
gem_start = active_misc.index('for (ModOres.Gem gem : ModOres.gems())')
check(active_misc.rfind('output.accept(ModItems.') < gem_start and active_misc.rfind('output.accept(ModBlocks.') < gem_start, 'existing miscellaneous contents precede gems and ores')
print(f'PASS: {checks} assertions; {len(rows)} gem materials, {item_count} items, '
      f'{len(ore_ids)} ore blocks, {recipe_count} recipes; GT source list and texture hashes match.')
