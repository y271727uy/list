"""Shared checks for non-spreading, unbreakable bedrock ore variants."""
from gt5_ore_materials import worldgen_paths


def verify_bedrock_ore(ore, generates, gem, load, check, gen, archive=None):
    loot = f'data/list/loot_tables/blocks/{ore}.json'
    check(not (gen / loot).exists(), ore + ' has no loot table')
    if archive:
        check(loot not in archive.NameToInfo, ore + ' has no packaged loot table')
    for tag in ('wither_immune', 'dragon_immune'):
        values = load(f'data/minecraft/tags/blocks/{tag}.json')['values']
        check('list:' + ore in values, ore + ' boss immunity: ' + tag)
    if not generates:
        for path in worldgen_paths(ore):
            check(not (gen / path).exists(), ore + ' has no natural generation')
            if archive:
                check(path not in archive.NameToInfo, ore + ' has no packaged generation')
        return
    feature = load(f'data/list/worldgen/configured_feature/{ore}.json')
    check(feature == {'type': 'minecraft:simple_block', 'config': {'to_place': {
        'type': 'minecraft:simple_state_provider', 'state': {'Name': 'list:' + ore}}}},
        ore + ' replaces only the origin, never a spreading vein')
    placed = load(f'data/list/worldgen/placed_feature/{ore}.json')
    check(placed['feature'] == 'list:' + ore, ore + ' configured feature')
    filters = {entry['type']: entry for entry in placed['placement']}
    check([entry['type'] for entry in placed['placement']] == [
        'list:ore_config_filter', 'minecraft:count', 'minecraft:rarity_filter',
        'minecraft:in_square', 'minecraft:height_range', 'minecraft:block_predicate_filter',
        'minecraft:biome'], ore + ' protected placement order')
    check(filters['list:ore_config_filter'] == {
        'type': 'list:ore_config_filter', 'ore': 'list:' + ore.removeprefix('bedrock_'),
        'base': 'bedrock', 'gem': gem}, ore + ' retains ore management identity')
    check(filters['minecraft:count']['count'] == 1, ore + ' one placement attempt')
    check(filters['minecraft:rarity_filter']['chance'] == 2, ore + ' 50 percent attempt filter')
    check(filters['minecraft:height_range']['height'] == {
        'type': 'minecraft:uniform', 'min_inclusive': {'above_bottom': 1},
        'max_inclusive': {'above_bottom': 4}}, ore + ' excludes the world floor in every dimension')
    predicate = filters['minecraft:block_predicate_filter']['predicate']
    check(predicate['type'] == 'minecraft:matching_blocks', ore + ' exact block predicate')
    check(predicate['blocks'] in ('minecraft:bedrock', ['minecraft:bedrock']), ore + ' only replaces bedrock')
    check(predicate.get('offset', [0, 0, 0]) == [0, 0, 0], ore + ' matches the actual placement position')
    for suffix, biome in (('', '#minecraft:is_overworld'), ('_nether', '#minecraft:is_nether')):
        modifier = load(f'data/list/forge/biome_modifier/add_{ore}{suffix}.json')
        check(modifier == {'type': 'forge:add_features', 'biomes': biome,
                          'features': 'list:' + ore, 'step': 'underground_ores'},
              ore + ' dimension injection: ' + biome)
