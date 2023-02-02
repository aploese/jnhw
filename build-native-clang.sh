#!/bin/sh

#autoreconf -i

mvn clean compile  || exit 1 

export CC=clang

./configure || exit 1
make clean || exit 1
make || exit 1

mvn -fae install || exit 1
mvn -PNativeProvider_JNI -fae test || exit 1
echo "search for crashed tests: *.dump*"
find -name "*.dump*"

