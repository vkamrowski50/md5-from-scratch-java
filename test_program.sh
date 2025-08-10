#!/usr/bin/bash

while IFS= read -r line; do
  # Your code to process each line
  make run ARGS="$line";
done < ./shortrockyou.txt
