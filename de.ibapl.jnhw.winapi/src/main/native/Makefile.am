lib_LTLIBRARIES = libjnhw-winapi.la

noinst_LTLIBRARIES = 

AM_CPPFLAGS = @JNI_INCLUDE_FLAGS@ -I @JNI_HEADER_DIR@ -I @JNHW_COMMON_SRC_DIR@
AM_CFLAGS = -O3 -Wall -Werror
AM_LDFLAGS = -no-undefined

JNHW_RESOURCES_DIR = @JNHW_RESOURCES_DIR@

libjnhw_winapi_la_LIBADD = @JNHW_COMMON_SRC_DIR@/libjnhw-common.la

libjnhw_winapi_la_SOURCES = \
 jnhw-winapi-jni.c

#hook into make all
all-local: @JNHW_RESOURCES_DIR@/libjnhw-winapi@JNHW_LIB_SUFFIX@

install-jnhw-resources: @JNHW_RESOURCES_DIR@/libjnhw-winapi@JNHW_LIB_SUFFIX@

@JNHW_RESOURCES_DIR@/libjnhw-winapi@JNHW_LIB_SUFFIX@: libjnhw-winapi.la
	$(MKDIR_P) @JNHW_RESOURCES_DIR@
	cp ./.libs/libjnhw-winapi@JNHW_LTLIB_SUFFIX@ @JNHW_RESOURCES_DIR@/libjnhw-winapi@JNHW_LIB_SUFFIX@
	$(STRIP) -s @JNHW_RESOURCES_DIR@/libjnhw-winapi@JNHW_LIB_SUFFIX@