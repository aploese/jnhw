#!/bin/sh
mvn clean compile && mvn -fail-never test -Dsurefire.exitTimeout=1200 -Dsurefire.timeou6=600
