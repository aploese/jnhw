#!/bin/sh
autoreconf -i && \
./configure --enable-maintainer-mode --libdir=`pwd`/../src/main/resources/lib/x86_64-linux-gnu/ && \
make && \
make install

