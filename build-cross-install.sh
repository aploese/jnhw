#!/bin/sh

autoreconf -i

mvn clean compile

# "x86_64-linux-gnu"
# "i386-linux-gnu"

for d in\
 "x86_64-w64-mingw32"\
 "i686-w64-mingw32"\
 "aarch64-linux-gnu"\
 "arm-linux-gnueabi"\
 "arm-linux-gnueabihf"\
 "mips-linux-gnu"\
 "mips64-linux-gnuabi64"\
 "mips64el-linux-gnuabi64"\
 "mipsel-linux-gnu"
do
  ./configure --host=$d --prefix=`pwd`/target/$d && make clean && make && make install
done

./configure --prefix=`pwd`/target && make clean && make && make install

mvn install


