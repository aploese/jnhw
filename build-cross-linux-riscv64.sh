#!/bin/sh

#autoreconf -i

mvn clean compile test-compile || exit 1

for d in\
 "riscv64-linux-gnu"
do
export CC=$d-gcc
  $CC --version || exit 1
  ./configure --host=$d || exit 1
  make clean || exit 1
  make || exit 1
done