import os
import json


def generate_recipe_file(item_name, directory="."):
    """根据物品名称生成鱼塘配方JSON文件"""
    
    # 提取名称（去除list:前缀和引号）
    if item_name.startswith('"'):
        item_name = item_name.strip('"')
    if item_name.startswith('list:'):
        clean_name = item_name.replace('list:', '')
    else:
        clean_name = item_name
    
    # 检查是否存在同名文件，如存在则使用递增命名
    base_filename = f"{clean_name}.json"
    full_path = os.path.join(directory, base_filename)
    counter = 2
    
    while os.path.exists(full_path):
        filename = f"{clean_name}_{counter}.json"
        full_path = os.path.join(directory, filename)
        counter += 1
    
    # 创建配方模板
    recipe_template = {
        "type": "list:fish_pond",
        "ingredients": [
            {"item": f"list:{clean_name}_egg"},
            {"tag": "list:sea_veg"}
        ],
        "isLava": False,
        "results": [
            {"count": 1, "item": f"list:{clean_name}"},
            {"count": 1, "chance": 0.05, "item": f"list:{clean_name}_egg"}
        ],
        "time": 3200
    }
    
    # 写入文件
    with open(full_path, 'w', encoding='utf-8') as f:
        json.dump(recipe_template, f, indent=2, ensure_ascii=False)
    
    print(f"已创建文件: {full_path}")
    return full_path


if __name__ == "__main__":
    print("鱼塘配方生成器")
    print("请输入物品名称（如 'list:pelagic_swimming_crab'），每行一个:")
    
    while True:
        try:
            item_input = input().strip()
            if not item_input:
                break
            
            generate_recipe_file(item_input)
        except EOFError:
            break