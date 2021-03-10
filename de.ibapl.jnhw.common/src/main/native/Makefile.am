AM_CPPFLAGS = @JNI_INCLUDE_FLAGS@ -I @JNI_HEADER_DIR@
AM_CFLAGS = -Wall -Wextra -Wconversion -Werror
AM_LDFLAGS = -z noexecstack -no-undefined -static-libgcc -version-info @JNHW_VERSION_INFO@

LIB_JNHW_COMMON_NAME=@JNHW_LIB_PREFIX@jnhw-common@JNHW_LIBTOOL_LIB_SUFFIX@
LIB_JNHW_COMMON_RES_NAME=@JNHW_RESOURCES_DIR@/@JNHW_LIB_PREFIX@jnhw-common@JNHW_LIB_SUFFIX@

include_HEADERS = jnhw-common.h JnhwExceptions.h

lib_LTLIBRARIES = libjnhw-common.la

noinst_LTLIBRARIES = \
 libexceptions.la \
 libmemory.la \
 libcallbacks.la \
 libcallnative.la

libjnhw_common_la_LIBADD = \
 libexceptions.la \
 libmemory.la \
 libcallbacks.la \
 libcallnative.la

libexceptions_la_SOURCES = \
 JnhwExceptions.c

libcallbacks_la_SOURCES = \
 Callback_I_V_Impl.c \
 Callback_J_V_Impl.c \
 Callback_IJ_V.c \
 Callback_IJ_V_Impl.c \
 Callback_I_I_Mem_V_Impl.c \
 Callback_I_Mem_Mem_V_Impl.c \
 Callback_Mem_V_Impl.c \
 Callback_NativeRunnable.c \
 NativeRunnable.c

libcallnative_la_SOURCES = \
 CallNative_I_V.c \
 CallNative_J_V.c \
 CallNative_IJ_V.c \
 CallNative_I_I_Mem_V.c \
 CallNative_I_Mem_Mem_V.c \
 CallNative_Mem_V.c

libmemory_la_SOURCES = \
 BaseDataType.c \
 JnhwMemoryAccessor.c

libjnhw_common_la_SOURCES = \
 jnhw-common.c

#hook into make all
all-local: $(LIB_JNHW_COMMON_RES_NAME)

clean-generic:
	-test -z "$(LIB_JNHW_COMMON_RES_NAME)" || rm -f $(LIB_JNHW_COMMON_RES_NAME)

install-jnhw-resources: $(LIB_JNHW_COMMON_RES_NAME)

$(LIB_JNHW_COMMON_RES_NAME): libjnhw-common.la
	$(MKDIR_P) @JNHW_RESOURCES_DIR@
	cp ./.libs/$(LIB_JNHW_COMMON_NAME) $(LIB_JNHW_COMMON_RES_NAME)
	$(STRIP) $(JNHW_STRIP_FLAG) $(LIB_JNHW_COMMON_RES_NAME)