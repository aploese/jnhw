#!/bin/sh -x

#!/bin/sh -x

JAVA_HOME=/usr/lib/jvm/java-23-openjdk-

for i in \
 "amd64"\
 "arm64"\
 "armhf"\
 "i386"\
 "mips64el"\
 "powerpc"\
 "ppc64"\
 "riscv64"\
 "s390x"
do
  if [ -d $JAVA_HOME$i ]; then
    export JAVA_HOME=$JAVA_HOME$i
    break
  fi
done

#autoreconf -i
#autoreconf -i -f

#mvn clean compile || exit 1 

echo "JAVA_HOME is: " $JAVA_HOME

export CC=gcc

./configure || exit 1
make clean || exit 1
make || exit 1

mvn -fae install || exit 1
#mvn -PNativeProvider_JNI -fae test || exit 1
echo "search for crashed tests: *.dump*"
find -name "*.dump*"

