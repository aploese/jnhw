#!/bin/sh
mvn clean package -f jna/pom.xml
mvn clean package -f jnhw/pom.xml
mvn clean package -f jnr/pom.xml

ls -lh jn*/target/*-jar-with-dependencies.jar
