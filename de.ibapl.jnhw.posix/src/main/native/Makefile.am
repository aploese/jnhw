AM_CPPFLAGS = @JNI_INCLUDE_FLAGS@ -I @JNI_HEADER_DIR@ -I @JNHW_COMMON_SRC_DIR@
AM_CFLAGS = @CFLAGS@ @PTHREAD_CFLAGS@ -Wall -Wextra -Wconversion -Werror
AM_LDFLAGS = -z noexecstack -no-undefined -version-info @JNHW_VERSION_INFO@
AM_LIBS = @PTHREAD_LIBS@ @LIBS@
AM_CC = @PTHREAD_CC@


LIB_JNHW_POSIX_NAME=@JNHW_LIB_PREFIX@jnhw-posix@JNHW_LIBTOOL_LIB_SUFFIX@
LIB_JNHW_POSIX_RES_NAME=@JNHW_RESOURCES_DIR@/@JNHW_LIB_PREFIX@jnhw-posix@JNHW_LIB_SUFFIX@

lib_LTLIBRARIES = libjnhw-posix.la

noinst_LTLIBRARIES =

libjnhw_posix_la_LIBADD = \
 @JNHW_COMMON_SRC_DIR@/libjnhw-common.la

libjnhw_posix_la_SOURCES = \
 jnhw-posix-jni.c \
 AioFunctions.c \
 Isoc_ErrnoFunctions.c \
 EventFdFunctions.c \
 FcntlFunctions.c \
 IoctlDefines.c \
 IoctlFunctions.c \
 LocaleFunctions.c \
 PollFunctions.c \
 PthreadFunctions.c \
 SchedFunctions.c \
 SignalFunctions.c \
 Callback__Sigval_int__V_Impl.c \
 StdioFunctions.c \
 StringHeaderFunctions.c \
 TermiosFunctions.c \
 TimeFunctions.c \
 UcontextFunctions.c \
 UnistdFunctions.c


#hook into make all
all-local: $(LIB_JNHW_POSIX_RES_NAME)

clean-generic:
	-test -z "$(LIB_JNHW_POSIX_RES_NAME)" || rm -f $(LIB_JNHW_POSIX_RES_NAME)

install-jnhw-resources: $(LIB_JNHW_POSIX_RES_NAME)

$(LIB_JNHW_POSIX_RES_NAME): libjnhw-posix.la
	$(MKDIR_P) @JNHW_RESOURCES_DIR@
	cp ./.libs/$(LIB_JNHW_POSIX_NAME) $(LIB_JNHW_POSIX_RES_NAME)
	$(STRIP) $(JNHW_STRIP_FLAG) $(LIB_JNHW_POSIX_RES_NAME)
