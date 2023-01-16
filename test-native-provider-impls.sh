#!/bin/sh
mvn -Dde.ibapl.jnhw.common.util.NativeProvider="JNI" -fae test && \
mvn -fae test
