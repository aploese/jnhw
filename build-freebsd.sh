export JAVA_HOME=/usr/local/openjdk11/
mvn clean compile  test-compile && ./configure --with-jni-include-dir="/usr/local/openjdk11/include/ /usr/local/openjdk11/include/freebsd/" && gmake clean && gmake && mvn install
