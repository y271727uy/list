import os
import re
import json

def check_time_fields():
    # 遍历所有JSON文件
    problematic_files = []
    
    for root, dirs, files in os.walk('.'):
        for file in files:
            if file.endswith('.json'):
                filepath = os.path.join(root, file)
                try:
                    with open(filepath, 'r', encoding='utf-8') as f:
                        content = f.read()
                        
                    # 查找time字段
                    time_matches = re.findall(r'"time"\s*:\s*([^\s,\}\]\r\n]+)', content)
                    if time_matches:
                        for time_value in time_matches:
                            time_value = time_value.rstrip(' ,]}')  # 移除可能的结尾字符
                            
                            # 尝试解析为数字
                            try:
                                num_val = float(time_value)
                                # 如果是数字，继续下一个匹配
                                continue
                            except ValueError:
                                # 不是数字，添加到问题文件列表
                                problematic_files.append(filepath)
                                break  # 找到一个问题就够了
                                
                except Exception as e:
                    print(f'Error reading file {filepath}: {e}')
    
    if problematic_files:
        print("Files with problematic time fields:")
        for pf in sorted(set(problematic_files)):  # 使用set去重
            print(pf)
    else:
        print('No problematic time fields found.')

if __name__ == "__main__":
    check_time_fields()