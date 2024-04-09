#!/bin/sh
# the long form : mvn -Dde.ibapl.jnhw.common.util.NativeProvider="JAVA_FOREIGN" -fae test && \
# the short form: mvn -PNativeProvider_JAVA_FOREIGN -fae test && \

mvn -PNativeProvider_JAVA_FOREIGN -fae test
