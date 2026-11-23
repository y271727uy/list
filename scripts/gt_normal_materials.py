"""Read the checked-in GTM material declarations without requiring GTM at runtime."""
from pathlib import Path
import json
import re

ROOT = Path(__file__).resolve().parents[1]
GT = ROOT / 'refar/GregTech-Modern-1.20.1'
SOURCES = GT / 'src/main/java/com/gregtechceu/gtceu/common/data/materials'


def read_catalog():
    zh = json.loads((GT / 'src/main/resources/assets/gtceu/lang/zh_cn.json').read_text(encoding='utf-8'))
    materials = {}
    symbols = {}
    for path in sorted(SOURCES.glob('*.java')):
        text = re.sub(r'//[^\n]*|/\*.*?\*/', '', path.read_text(encoding='utf-8'), flags=re.S)
        for match in re.finditer(r'(\w+)\s*=\s*new Material.Builder\(GTCEu.id\("([^"\n]+)"\)\)(.*?)\.buildAndRegister\(\)', text, re.S):
            symbol, id, chain = match.groups()
            def value(pattern, default):
                found = re.search(pattern, chain)
                return found[1] if found else default
            key = 'material.gtceu.' + id
            materials[id] = {
                'id': id, 'english': id.replace('_', ' ').title(),
                'chinese': zh[key], 'icon': value(r'\.iconSet\((\w+)\)', 'DULL').lower(),
                'color': int(value(r'\.color\((0x[\da-fA-F]+)', '0xffffff'), 16) & 0xffffff,
                'secondary': int(value(r'\.secondaryColor\((0x[\da-fA-F]+)', '0xffffff'), 16) & 0xffffff,
                'has_ore': bool(re.search(r'\.ore\(', chain)),
                'has_gem': bool(re.search(r'\.gem\(', chain)),
                'has_ingot': bool(re.search(r'\.ingot\(', chain)),
                'source': str(path.relative_to(ROOT)).replace('\\', '/'),
            }
            symbols[symbol] = id
    flag_text = (SOURCES / 'MaterialFlagAddition.java').read_text(encoding='utf-8')
    flag_text = re.sub(r'//[^\n]*|/\*.*?\*/', '', flag_text, flags=re.S)
    direct = {}
    for block in re.split(r'oreProp\s*=\s*', flag_text)[1:]:
        ore = re.match(r'(\w+)\.getProperty\(PropertyKey.ORE\)', block)
        output = re.search(r'oreProp.setDirectSmeltResult\((\w+)\)', block)
        if ore and output:
            direct[symbols[ore[1]]] = symbols[output[1]]
    ores = []
    for id, material in materials.items():
        if material['has_ore'] and not material['has_gem']:
            output = direct.get(id, id if material['has_ingot'] else '')
            if output and not materials[output]['has_ingot']:
                output = ''
            ores.append({**material, 'output': output})
    metals = [materials[id] for id in sorted({row['output'] for row in ores if row['output']})]
    assert len(ores) == 80 and len(metals) == 20
    return {'ores': ores, 'metals': metals}


def java_catalog(catalog):
    def entry(row, ore):
        strings = ', '.join(json.dumps(row[k], ensure_ascii=False) for k in ('id', 'english', 'chinese', 'icon'))
        output = row.get('output', '') if ore else ''
        return f'        new Material({strings}, 0x{row["color"]:06x}, 0x{row["secondary"]:06x}, "{output}")'
    lines = ['    // BEGIN NORMAL MATERIALS: maintained by scripts/gt_normal_materials.py',
             '    public record Material(String id, String english, String chinese, String icon,',
             '                           int color, int secondary, String output) {}']
    for name, key, is_ore in (('ORE_MATERIALS', 'ores', True), ('METAL_MATERIALS', 'metals', False)):
        lines.append(f'    public static final List<Material> {name} = List.of(')
        lines.append(',\n'.join(entry(row, is_ore) for row in catalog[key]))
        lines.append('    );')
    lines.extend(['    // END NORMAL MATERIALS', ''])
    return '\n'.join(lines)


JAVA_REGISTRY = ROOT / 'src/main/java/com/list/dsl/registrate/ModOres.java'
CATALOG_START = '    // BEGIN NORMAL MATERIALS: maintained by scripts/gt_normal_materials.py\n'
CATALOG_END = '    // END NORMAL MATERIALS\n'


def catalog_bounds(text):
    assert text.count(CATALOG_START) == text.count(CATALOG_END) == 1, 'Expected one marked material catalog'
    start = text.index(CATALOG_START)
    end = text.index(CATALOG_END, start) + len(CATALOG_END)
    return start, end


def read_java_catalog():
    text = JAVA_REGISTRY.read_text(encoding='utf-8')
    start, end = catalog_bounds(text)
    return text[start:end]


def update_java_catalog(catalog):
    text = JAVA_REGISTRY.read_text(encoding='utf-8')
    start, end = catalog_bounds(text)
    JAVA_REGISTRY.write_text(text[:start] + java_catalog(catalog) + text[end:], encoding='utf-8')


if __name__ == '__main__':
    catalog = read_catalog()
    (ROOT / 'scripts/gt_normal_ores.json').write_text(json.dumps(catalog, ensure_ascii=False, indent=2) + '\n', encoding='utf-8')
    update_java_catalog(catalog)
    print(f'Updated {len(catalog["ores"])} ordinary ore declarations and {len(catalog["metals"])} metal outputs in ModOres.')
