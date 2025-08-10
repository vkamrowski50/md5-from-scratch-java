#!/usr/bin/bash

while IFS= read -r line; do
  # Your code to process each line
  echo -n "$line" | md5sum;
done < ./shortrockyou.txt
