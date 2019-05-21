#!/bin/sh

#autoreconf -i

mvn compile

./configure --prefix=$PWD/target
make clean
make
make install

mvn install


