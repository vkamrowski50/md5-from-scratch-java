#!/usr/bin/env bash
set -euo pipefail

input_file="${1:-tests/input.txt}"

if [[ ! -f "$input_file" ]]; then
  echo "Input file '$input_file' not found." >&2
  exit 1
fi

# Prefer md5sum; fall back to macOS 'md5 -q'
if command -v md5sum >/dev/null 2>&1; then
  while IFS= read -r line || [[ -n "$line" ]]; do
    echo "$line"
    printf "%s" "$line" | md5sum
  done < "$input_file"
elif command -v md5 >/dev/null 2>&1; then
  while IFS= read -r line || [[ -n "$line" ]]; do
    echo "$line"
    printf "%s" "$line" | md5 -q
  done < "$input_file"
else
  echo "Neither 'md5sum' nor 'md5' found on PATH." >&2
  exit 1
fi
