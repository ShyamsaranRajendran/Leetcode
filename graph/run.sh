#!/bin/bash

# Check if the Java file is provided
if [ -z "$1" ]; then
  echo "Usage: $0 <JavaFileNameWithoutExtension>"
  exit 1
fi

JAVA_FILE="$1.java"
CLASS_FILE="$1"

# Compile the Java file
echo "Compiling $JAVA_FILE..."
javac "$JAVA_FILE"

# Check if the compilation was successful
if [ $? -eq 0 ]; then
  echo "Compilation successful."
  # Run the compiled Java class
  echo "Running $CLASS_FILE..."
  java "$CLASS_FILE"
else
  echo "Compilation failed."
fi
