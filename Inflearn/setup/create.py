import os
import sys

PACKAGE_PREFIX = "Inflearn"
DIRECTORY_PREFIX = "P"
FILE_NAME = "Main.java"
JAVA_TEMPLATE = """package {package_prefix}.{package_name};

import java.util.*;

public class Main {{
    public static void main(String[] args) {{
        Scanner in = new Scanner(System.in);
    }}
}}
"""

def create_java_file(directory_name):
    directory_name = f"{DIRECTORY_PREFIX}{directory_name}"
    os.makedirs(directory_name, exist_ok=True)

    package_name = directory_name.replace("/", ".").replace("\\", ".")
    file_path = os.path.join(directory_name, FILE_NAME)

    content = JAVA_TEMPLATE.format(package_prefix=PACKAGE_PREFIX, package_name=package_name)

    with open(file_path, "w", encoding="utf-8") as file:
        file.write(content)

    print(f"Main.java has been created in {file_path} with package '{PACKAGE_PREFIX}.{package_name}'.")

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: python create.py <directory_name>")
        sys.exit(1)

    directory_name = sys.argv[1]
    create_java_file(directory_name)
