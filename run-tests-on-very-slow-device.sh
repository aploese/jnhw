#!/bin/sh
mvn clean --fail-never test -Dsurefire.exitTimeout=1200 -Dsurefire.timeou6=600
