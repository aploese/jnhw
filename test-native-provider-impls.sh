#!/bin/sh
# the long form : mvn -Dde.ibapl.jnhw.common.util.NativeProvider="JNI" -fae test && \
# the short form: mvn -PNativeProvider_JNI -fae test && \

mvn -PNativeProvider_JNI -fae test && \
mvn -fae test
