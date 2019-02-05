AM_CPPFLAGS = @JNI_INCLUDE_FLAGS@ -I @JNI_HEADER_DIR@
AM_CFLAGS = -O3 -Wall -Werror
AM_LDFLAGS = -no-undefined

include_HEADERS = jnhw.h

lib_LTLIBRARIES = libjnhw-common.la libjnhw.la

libjnhw_la_LIBADD = ./libjnhw-common.la

libjnhw_common_la_SOURCES = \
 jnhw.c \
 JnhwExceptions.c \
 OpaqueMemory.c

libjnhw_la_SOURCES = \
 jnhw-jni.c

#hook into make all
all-local: @JNHW_RESOURCES_DIR@/libjnhw@JNHW_LIB_SUFFIX@ @JNHW_RESOURCES_DIR@/libjnhw-common@JNHW_LIB_SUFFIX@

install-jnhw-resources: @JNHW_RESOURCES_DIR@/libjnhw@JNHW_LIB_SUFFIX@ @JNHW_RESOURCES_DIR@/libjnhw-common@JNHW_LIB_SUFFIX@

@JNHW_RESOURCES_DIR@/libjnhw@JNHW_LIB_SUFFIX@: libjnhw.la
	$(MKDIR_P) @JNHW_RESOURCES_DIR@
	cp ./.libs/libjnhw@JNHW_LTLIB_SUFFIX@ @JNHW_RESOURCES_DIR@/libjnhw@JNHW_LIB_SUFFIX@
	$(STRIP) -s @JNHW_RESOURCES_DIR@/libjnhw@JNHW_LIB_SUFFIX@

@JNHW_RESOURCES_DIR@/libjnhw-common@JNHW_LIB_SUFFIX@: libjnhw.la
	$(MKDIR_P) @JNHW_RESOURCES_DIR@
	cp ./.libs/libjnhw-common@JNHW_LTLIB_SUFFIX@ @JNHW_RESOURCES_DIR@/libjnhw-common@JNHW_LIB_SUFFIX@
	$(STRIP) -s @JNHW_RESOURCES_DIR@/libjnhw-common@JNHW_LIB_SUFFIX@
