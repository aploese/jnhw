#!/bin/sh
mvn --fail-never surefire:test -Dsurefire.exitTimeout=1200 -Dsurefire.timeou6=600
