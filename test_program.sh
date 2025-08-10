#!/usr/bin/env bash
set -euo pipefail

input_file="${1:-tests/input.txt}"

if [[ ! -f "$input_file" ]]; then
  echo "Input file '$input_file' not found." >&2
  exit 1
fi

while IFS= read -r line || [[ -n "$line" ]]; do
  echo "$line"
  make run ARGS="$line"
done < "$input_file"
