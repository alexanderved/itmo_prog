javac -cp "src/" -d build/classes src/proglab34/Main.java
jar -c -f build/lab34.jar -m META-INF/MANIFEST.MF -C build/classes/ .
java -jar build/lab34.jar
