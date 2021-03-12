#!/bin/sh

#autoreconf -i

mvn clean compile test-compile || exit 1

./configure || exit 1
make clean || exit 1
make || exit 1
sh test-mem-impls.sh
mvn -fae install
