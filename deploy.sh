#!/bin/bash
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
mvn versions:display-plugin-updates -U -N
mvn clean compile javadoc:jar source:jar deploy
