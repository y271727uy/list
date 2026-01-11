import os
import json

def check_json_and_time_fields():
    problematic_files = []
    
    for root, dirs, files in os.walk('.'):
        for file in files:
            if file.endswith('.json'):
                filepath = os.path.join(root, file)
                try:
                    with open(filepath, 'r', encoding='utf-8') as f:
                        content = f.read()
                        data = json.loads(content)
                        
                        # 检查time字段是否存在且为数字
                        if 'time' in data:
                            time_value = data['time']
                            if not isinstance(time_value, (int, float)):
                                print(f"File {filepath} has a non-numeric time field: {time_value} (type: {type(time_value).__name__})")
                                problematic_files.append(filepath)
                        else:
                            print(f"File {filepath} is missing the time field entirely!")
                            problematic_files.append(filepath)
                                
                except json.JSONDecodeError as e:
                    print(f"Invalid JSON in file {filepath}: {e}")
                    problematic_files.append(filepath)
                except Exception as e:
                    print(f'Error reading file {filepath}: {e}')
    
    if problematic_files:
        print("\nSummary: Found problematic files:")
        for pf in sorted(set(problematic_files)):
            print(pf)
    else:
        print('No problematic time fields or JSON issues found.')

if __name__ == "__main__":
    check_json_and_time_fields()