#!/usr/bin/bash

rm -rf build
mkdir -p build/classes

javac -cp "lib/*:src/" -d build/classes src/proglab2/Main.java
jar -c -f build/lab2.jar -m META-INF/MANIFEST.MF -C build/classes/ .