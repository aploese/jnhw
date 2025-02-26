#!/bin/sh

for file in $(find ./src/test/java/ -name "*.java")
do
file=${file##*/}
file=${file%.java}
mvn test -Dtest=$file
done
