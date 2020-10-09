#!/bin/sh

mvn clean compile  test-compile || exit 1
  ./configure --host=x86_64-w64-mingw32 || exit 1
  make clean || exit 1
  make || exit 1
mvn -fae install
