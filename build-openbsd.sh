export CC=/usr/local/bin/x86_64-unknown-openbsd6.7-gcc-8.3.0
export JAVA_HOME=/usr/local/jdk-11/
mvn clean compile  test-compile && ./configure --with-jni-include-dir="$JAVA_HOME/include/ $JAVA_HOME/include/openbsd/" && gmake clean && gmake && mvn install