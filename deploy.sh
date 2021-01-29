#!/bin/bash
mvn clean install
cd it
mvn clean package
cd ..
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
mvn compile javadoc:jar source:jar deploy
