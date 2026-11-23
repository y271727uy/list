# 普通矿石 DSL

`OreDsl` 只连接语言、模型、原版 `Feature.ORE` 生成和掉落物，不包含 GTM 的材料系统、机器加工或大型矿脉。

在 `com.list.all.modblock.ModBlockOre` 中添加静态字段；该类已在 mod 初始化期间加载：

```java
public static final BlockEntry<Block> EXAMPLE_ORE = OreDsl.ore("example_ore")
        .names("Example Ore", "示例矿石")
        .texture("block/ore/example_ore")
        .drops(() -> ModItems.EXAMPLE_GEM.get())
        .generation(8, 4, -32, 48)
        .register();
```

示例中的物品与纹理需要自行提供，尚未注册任何正式矿种。返回值为 `BlockEntry<Block>`，可直接用于现有创造模式标签页。

## 配置

- `names(英文, 中文)`：英文由 Registrate 生成到 `en_us`；中文输出为独立片段，由 `processResources` 合并进原有中文语言资源，保留手写译文。
- `texture(资源路径)`：整张矿石贴图，六面相同。省略命名空间时使用 `list:`；支持 `minecraft:block/diamond_ore` 等完整资源 ID。路径不包含 `textures/` 和 `.png`。
- `layeredModel(底图, 透明矿点图, ARGB颜色)`：底图不染色，矿点通过 tint index 0 调色；放置方块与物品使用相同颜色。和 `texture` 二选一。
- `drops(() -> 物品)`：默认基础掉落 1 个；`drops(() -> 物品, 最少, 最多)` 可配置基础数量。供应器延迟到掉落表生成阶段解析，支持引用本模组注册物品。
- `fortune(false)`：关闭时运增产，默认开启。精准采集始终掉矿石方块；普通掉落包含爆炸衰减。
- `generation(大小, 每区块尝试数, 最低Y, 最高Y)`：显式开启原版矿石生成；高度均匀分布、两端包含。大小是原版参数，不保证每次生成该数量的矿石。未调用此方法则不生成任何 feature 或 biome modifier。
- `replaceable(方块标签...)`：按方块标签配置可替换基岩，默认原版石头矿石和深板岩矿石标签。`replaceableBlocks(() -> 方块...)`：改为精确替换列出的方块，适用于外观与宿主不同的矿石；两种方式会互相覆盖。不同宿主的独立贴图需要声明独立矿石。
- `biomes(群系标签)`：默认 `BiomeTags.IS_OVERWORLD`；可改为山地、下界或自定义标签。非主世界还需配置适当的可替换方块标签和高度。
- `toolTier(方块标签)`：默认铁镐等级；同时自动加入可用镐采掘标签并启用正确工具掉落要求。
- `propertiesFrom(() -> 方块)`、`strength(硬度, 抗爆)`：配置基础音效/地图色等属性，以及独立硬度、抗爆。

定义在 `register()` 后冻结；重复 ID、必填项缺失和不合法数值会及时报错。多个矿种不会产生彼此依赖的 feature 排序。

## 数据生成和构建

新增或修改声明后需要重新生成数据，然后构建。`compileJava` 只检查代码，不刷新 JSON。

```powershell
$env:JAVA_HOME = 'D:\Java\jdk21' # 本机已有；仅在默认 JDK 25 无法解析 Gradle 脚本时设置
$env:GRADLE_USER_HOME = 'D:\document\dev\gradle\.gradle'
.\gradlew.bat --no-daemon runData
.\gradlew.bat --no-daemon compileJava processResources
```

资源输出包括：blockstate、方块/物品模型、采掘标签、loot table、英文译文、中文片段，以及启用生成时的 configured feature、placed feature、biome modifier。生成键使用矿石 ID，modifier 使用 `add_<矿石ID>`。

中文手写资源仍在 `src/main/resources/assets/list/lang/zh_cn.json`；DSL 片段在 `src/generated/resources/assets/list/dsl_lang/zh_cn.json`；运行和打包使用合并后的 `build/resources/main/assets/list/lang/zh_cn.json`。不应手工编辑生成片段。

## 验证

隔离冒烟测试只在指定 init 脚本时加入临时测试矿种；正常构建不含这些矿种。输出放在 `build/ore-dsl-smoke/resources`，不写正式生成目录。

```powershell
.\gradlew.bat --no-daemon --init-script scripts/verify-ore-dsl.gradle runData
python scripts/verify_ore_dsl.py
```

校验脚本检查实际 JSON 中的模型、语言、掉落、采掘标签与原版 feature 配置。当前环境在打印 `All providers took` 并写完 HashCache 后，可能被一个空闲的非守护线程阻止退出；本次验证在确认全部文件生成且校验通过后结束了该测试 JVM，因此不把 `runData` 的进程退出状态算作成功构建。

测试运行会改变编译输出；完成后再运行一次普通 `compileJava`，移除编译输出中的测试类。
