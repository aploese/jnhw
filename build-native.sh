#!/bin/sh

#autoreconf -i

mvn clean compile test-compile 

./configure || exit 1
make clean || exit 1
make || exit 1
mvn install
