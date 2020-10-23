#!/bin/sh

#autoreconf -i

mvn clean compile test-compile || exit 1

# "hppa64-linux-gnu"\

for d in\
 "aarch64-linux-gnu"\
 "alpha-linux-gnu"\
 "arm-linux-gnueabi"\
 "arm-linux-gnueabihf"\
 "hppa-linux-gnu"\
 "i686-linux-gnu"\
 "m68k-linux-gnu"\
 "mips-linux-gnu"\
 "mipsel-linux-gnu"\
 "mips64-linux-gnuabi64"\
 "mips64el-linux-gnuabi64"\
 "mipsisa32r6-linux-gnu"\
 "mipsisa32r6el-linux-gnu"\
 "mipsisa64r6-linux-gnuabi64"\
 "mipsisa64r6el-linux-gnuabi64"\
 "powerpc-linux-gnu"\
 "powerpc64-linux-gnu"\
 "powerpc64le-linux-gnu"\
 "riscv64-linux-gnu"\
 "s390x-linux-gnu"\
 "sh4-linux-gnu"\
 "sparc64-linux-gnu"\
 "x86_64-linux-gnu"\
 "x86_64-linux-gnux32"
do
export CC=$d-gcc
  $CC --version || exit 1
  ./configure --host=$d || exit 1
  make clean || exit 1
  make || exit 1
done


export CC=gcc
./configure || exit 1
make clean || exit 1
make || exit 1

mvn -fae install || exit 1
