#!/bin/bash
set -e  # Exit on error

# Compile
javac -d bin ./lab2/*.java

# Move to folder and run files
cd ./bin
java lab2.Main