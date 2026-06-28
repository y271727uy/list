# List/列表

将要实现的多方块结构： 珠海渔场、温室


新大饼：林业新机器   （完成好几个月了 ）    
杂交机（暂定）     
目的：林业本体的杂交太狗屎+摸不清楚如何自定义  
功能：两个树苗+一个蜜蜂，杂交出树苗

培养机（暂定 另一个名字微型温室？）  
目的：培养农作物，~~不受季节影响~~，植物盆太傻逼且简陋  
功能：农作物+水+肥料


## 果冻调色约定

- 结构：`layer0` 为底图，`layer1` 为上层调色图。
- 运行时：`tintIndex=0` 不变色，`tintIndex=1` 只吃单个 ARGB tint 常量。


要引用别的模组资源，不要再局限于 provider.mcLoc(...) / provider.modLoc(...)，直接传字符串即可：
ItemModelUtil.textureOrFallback("othermod:item/cod", provider.mcLoc("item/cod"))
或者
ItemModelUtil.textureOrFallback("othermod:item/food/component/smoke_lite", ListMod.rl("item/food/component/smoke_lite"))