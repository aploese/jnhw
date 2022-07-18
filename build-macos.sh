export CC=/usr/bin/cc
./configure --with-jni-include-dir="$JAVA_HOME/include/ $JAVA_HOME/include/darwin/"  || exit 1
 make clean  || exit 1
make  || exit 1
