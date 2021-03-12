#!/bin/sh
mvn -Dde.ibapl.jnhw.common.memory.MEMORY_ACCESSSOR="Jnhw" -fae test
mvn -Dde.ibapl.jnhw.common.memory.MEMORY_ACCESSSOR="Unsafe" -fae test
