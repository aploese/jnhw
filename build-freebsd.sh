export JAVA_HOME=/usr/local/openjdk19/

mvn clean compile  || exit 1

./configure --with-jni-include-dir="$JAVA_HOME/include/ $JAVA_HOME/include/freebsd/"  || exit 1
gmake clean  || exit 1
gmake  || exit 1

mvn -fae install || exit 1
mvn -PNativeProvider_JNI -fae test || exit 1
echo "search for crashed tests: *.dump*"
find -name "*.dump*"

