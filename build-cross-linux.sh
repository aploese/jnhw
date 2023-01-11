#!/bin/sh

#autoreconf -i

# no need to compile java anymore 
#mvn clean compile test-compile || exit 1

# "x86_64-linux-gnu"
# "i386-linux-gnu"

# here the compiler produces garbage
# "mipsisa32r6el-linux-gnu"\
# "mipsisa32r6-linux-gnu"\
# "mipsisa64r6el-linux-gnuabi64"\
# "mipsisa64r6-linux-gnuabi64"
# "mips64-linux-gnuabin32"\
# "mips64el-linux-gnuabin32"\
#sparc is not tested...
# "sparc64-linux-gnu"

#not supported anymore by debian - no OpenJDK > 19
# "mips-linux-gnu"\
# "mips64-linux-gnuabi64"\

#not testable so we do not build this...
# Fcntl.open will crash VM
# "powerpc64le-linux-gnu"\

for d in\
 "aarch64-linux-gnu"\
 "arm-linux-gnueabi"\
 "arm-linux-gnueabihf"\
 "mipsel-linux-gnu"\
 "mips64el-linux-gnuabi64"\
 "riscv64-linux-gnu"\
 "s390x-linux-gnu"
do
export CC=$d-gcc-12
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
