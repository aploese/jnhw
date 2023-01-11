AM_CPPFLAGS = @JNI_INCLUDE_FLAGS@ -I @JNI_HEADER_DIR@
AM_CFLAGS = -Wall -Wextra -Wconversion -Werror
AM_LDFLAGS = -z noexecstack -no-undefined -version-info @JNHW_VERSION_INFO@

LIB_JNHW_COMMON_NAME=@JNHW_LIB_PREFIX@jnhw-common@JNHW_LIBTOOL_LIB_SUFFIX@
LIB_JNHW_COMMON_RES_NAME=@JNHW_RESOURCES_DIR@/@JNHW_LIB_PREFIX@jnhw-common@JNHW_LIB_SUFFIX@

include_HEADERS = jnhw-common.h

lib_LTLIBRARIES = libjnhw-common.la

libjnhw_common_la_SOURCES = \
 jnhw-common.c\
 JniMi_MA.c\
 JniMi__B.c\
 JniMi__D.c\
 JniMi__I.c\
 JniMi__L.c\
 JniMi__S.c\
 JniMi__V.c\
 JniCallbackFactory__V__MA.c\
 JniCallbackFactory__V___I.c\
 JniCallbackFactory__V___I_MA_MA.c\
 JniCallbackFactory__V___I__I_MA.c\
 JniCallbackFactory__V___L.c

#hook into make all
all-local: $(LIB_JNHW_COMMON_RES_NAME)

clean-generic:
	-test -z "$(LIB_JNHW_COMMON_RES_NAME)" || rm -f $(LIB_JNHW_COMMON_RES_NAME)

install-jnhw-resources: $(LIB_JNHW_COMMON_RES_NAME)

$(LIB_JNHW_COMMON_RES_NAME): libjnhw-common.la
	$(MKDIR_P) @JNHW_RESOURCES_DIR@
	cp ./.libs/$(LIB_JNHW_COMMON_NAME) $(LIB_JNHW_COMMON_RES_NAME)
	$(STRIP) $(JNHW_STRIP_FLAG) $(LIB_JNHW_COMMON_RES_NAME)
