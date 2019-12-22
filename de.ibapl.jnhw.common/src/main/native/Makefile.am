AM_CPPFLAGS = @JNI_INCLUDE_FLAGS@ -I @JNI_HEADER_DIR@
AM_CFLAGS = -Wall -Wextra -Wconversion -Werror
AM_LDFLAGS = -no-undefined -version-info @JNHW_VERSION_INFO@

LIB_JNHW_COMMON_NAME=@JNHW_LIB_PREFIX@jnhw-common@JNHW_LIB_SUFFIX@
LIB_JNHW_COMMON_RES_NAME=@JNHW_RESOURCES_DIR@/$(LIB_JNHW_COMMON_NAME)
 
include_HEADERS = jnhw-common.h JnhwExceptions.h

lib_LTLIBRARIES = libjnhw-common.la

libjnhw_common_la_SOURCES = \
 jnhw-common.c \
 JnhwExceptions.c \
 OpaqueMemory.c \
 Callback_I_V.c


#hook into make all
all-local: $(LIB_JNHW_COMMON_RES_NAME)

install-jnhw-resources: $(LIB_JNHW_COMMON_RES_NAME)

$(LIB_JNHW_COMMON_RES_NAME): libjnhw-common.la
	$(MKDIR_P) @JNHW_RESOURCES_DIR@
	cp ./.libs/$(LIB_JNHW_COMMON_NAME) $(LIB_JNHW_COMMON_RES_NAME)
	$(STRIP) $(JNHW_STRIP_FLAG) $(LIB_JNHW_COMMON_RES_NAME)