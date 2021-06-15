from pathlib import Path
import sys


'''
This script is used to write
all of the source files to a text file, sources.txt, 
in the root project directory.

The pattern of any files or folders is passed via CLI arguments.

    ex. python source_builder.py *.java

The paths to the target files relative to the root folder are written.
The directory is searched recursively and any item that matches the pattern is written.

To then build the project, run the Makefile build command:

    ex. make build  (on Linux)
    ex. mingw32-make build  (on Windows, if using mingw)

To run, use Makefile run command.

Note, source_builder.py and Makefile are to help in the build and run process.
Building and running the program is still very possible without them.
'''

def recursive_search(target):
    current_dir = Path(".")

    with open("sources.txt", 'w') as f:
        # be sure to append newline to end of each path
        files = ((str(file) + '\n') for file in current_dir.rglob(target))
        f.writelines(files)


if __name__ == "__main__":
    recursive_search(sys.argv[1])