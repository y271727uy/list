# 矿石生成配置 / Ore generation configuration

首次启动模组后，Forge 自动生成实例目录下的 `config/list/ore_manage.toml`。每个键都带中英文注释，默认关闭全部普通矿石生成，开启宝石生成，但禁止基岩、沙子、红沙、沙砾宿主的宝石矿石。配置作用于该实例服务端承载的所有世界；联机以服务器配置为准。修改后重新进入世界或重启服务器生效，运行中的世界使用固定规则快照。

```toml
worldgen_ores = false
worldgen_gems = true

disabled_ores = []
disabled_gems = []
disabled_base_gems = ["bedrock", "sand", "red_sand", "gravel"]
disabled_base_ores = []
disabled_precise_base_gems = []
disabled_precise_base_ores = []
```

以上为代码内置默认值，用于首次创建配置或补齐缺失项；已有配置中的有效设置不会被覆盖。用户仍可将 `worldgen_ores` 改为 `true` 开启普通矿石，或清空 `disabled_base_gems` 允许所有宝石宿主。

## 规则与示例

- `worldgen_ores`：普通矿石总开关；关闭时该类所有生成被过滤。
- `worldgen_gems`：宝石矿石总开关；关闭时该类所有生成被过滤。
- `disabled_ores = ["list:titanium_ore"]`：禁止钛矿石全族，覆盖所有宿主。
- `disabled_gems = ["list:ruby_ore"]`：禁止红宝石矿石全族。
- `disabled_base_ores = ["sand"]`：禁止所有沙子基普通矿石。
- `disabled_base_gems = ["gravel", "bedrock"]`：禁止所有沙砾基、基岩基宝石矿石。
- `disabled_precise_base_ores = [["sand", "list:titanium_ore"]]`：只禁止沙子基钛矿石，其他宿主的钛矿石不受此项影响。
- `disabled_precise_base_gems = [["sand", "list:ruby_ore"], ["gravel", "list:sapphire_ore"]]`：分别禁止沙子基红宝石和沙砾基蓝宝石。

所有禁用规则取并集；前面的总开关关闭时，列表不能重新开启生成。全族规则也接受宿主变体 ID，例如 `list:sand_titanium_ore` 会归一为钛矿石全族。精确规则第二项也会归一，第一项宿主决定具体禁止的变体。

精确规则使用 **TOML 二维数组**，每对只能写 `[宿主, 矿石族ID]`。`["sand" = "list:titanium_ore"]` 不是合法 TOML。普通矿石列表不能填写宝石矿石 ID，反之亦然；宿主列表不能填写矿石 ID。未知 ID、错误类别和未知宿主会在加载规则时记录中英双语警告并忽略，不删除注册项。结构错误的列表值由 Forge 配置校验修正。

## 宿主 key

| Key | 中文 |
| --- | --- |
| `stone` | 石头 |
| `deepslate` | 深板岩（也接受“深层”） |
| `granite` | 花岗岩 |
| `diorite` | 闪长岩 |
| `andesite` | 安山岩 |
| `tuff` | 凝灰岩 |
| `calcite` | 方解石 |
| `netherrack` | 下界岩 |
| `end_stone` | 末地石（也接受 `endstone`） |
| `sandstone` | 砂岩 |
| `gravel` | 沙砾 |
| `sand` | 沙子 |
| `red_sand` | 红沙 |
| `red_sandstone` | 红砂岩 |
| `basalt` | 玄武岩 |
| `blackstone` | 黑石 |
| `bedrock` | 基岩 |

支持表中的中文名称、英文 key 及宿主方块 ID，例如 `sand`、`沙子`、`minecraft:sand`。矿物仍填写已声明的完整 `list:..._ore` ID。

## 存档与数据包行为

实现使用原生 `PlacementFilter` 和注册的 `list:ore_config_filter` codec，不使用 mixin。矿石方块、物品、configured feature、placed feature 和 biome modifier 的注册不受配置开关影响。配置仅决定原本已声明的矿石在后续世界生成放置时是否通过；关闭不删除旧矿石，重新开启也不会对旧区块补矿。此配置不控制原版或其他模组的矿石，不会给本来没有自然生成声明的矿物添加生成。

“新区块”指尚未完成对应矿石生成阶段的区域，不能只按玩家是否到访判断；预生成区域不会重跑生成。保留原版矿脉跨区块放置行为，配置过滤器不额外保证新区块边界外绝无生成写入。

数据包仍可调整高度、次数、矿脉大小等。自定义数据包覆盖本模组的 placed feature 时，应保留 `list:ore_config_filter` 项，才继续受配置管理。

## 隔离验证

```powershell
$env:JAVA_HOME = 'D:\java\jdk21' # 使用本机已有 JDK，不下载
$env:GRADLE_USER_HOME = 'D:\document\dev\gradle\.gradle'
.\gradlew.bat --no-daemon --init-script scripts/verify-ore-manage.gradle runData
```

验证源集仅由该 init script 加入，普通构建不包含它。运行目录和资源输出位于 `build/ore-manage-smoke`；验证所有实际宿主变体、类别、全族规则、宿主别名、精确规则、错误类型、双语注释及真实 placement codec。完成后运行普通 `compileJava`，移除编译输出中的测试类。
