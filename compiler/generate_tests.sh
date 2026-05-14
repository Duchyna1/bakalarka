#!/bin/bash
set -e

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
CLASSPATH="$SCRIPT_DIR/target/classes:$(cat "$SCRIPT_DIR/target/classpath.txt")"

for dl_file in "$SCRIPT_DIR/tests/"*.dl; do
    # skip expected-error test cases
    [[ "$dl_file" == *_e.dl ]] && continue
    ra_file="${dl_file%.dl}.ra"
    echo "Translating $dl_file -> $ra_file"
    java -cp "$CLASSPATH" TranslateDatalogFile < "$dl_file" > "$ra_file"
done
