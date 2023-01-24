export CC=/usr/bin/cc
export JAVA_HOME=/Users/user/jdk-19/Contents/Home/

/Users/user/maven/bin/mvn clean compile  test-compile -DskipTests || exit 1
./configure --with-jni-include-dir="$JAVA_HOME/include/ $JAVA_HOME/include/darwin/"  || exit 1
 make clean  || exit 1
make  || exit 1
/Users/user/maven/bin/mvn -fae install || exit 1
/Users/user/maven/bin/mvn -fae -Dde.ibapl.jnhw.common.util.NativeProvider="JNI" install || exit 1

