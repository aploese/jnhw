export JAVA_HOME=/usr/local/openjdk14/
mvn clean compile  test-compile && ./configure --with-jni-include-dir="$JAVA_HOME/include/ $JAVA_HOME/include/freebsd/" && gmake clean && gmake && mvn install
