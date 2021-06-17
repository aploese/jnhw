AM_CPPFLAGS = @JNI_INCLUDE_FLAGS@ -I @JNI_HEADER_DIR@ -I @JNHW_COMMON_SRC_DIR@
AM_CFLAGS = @CFLAGS@ @PTHREAD_CFLAGS@ -Wall -Wextra -Wconversion -Werror
AM_LDFLAGS = -z noexecstack -no-undefined -static-libgcc -version-info @JNHW_VERSION_INFO@
AM_LIBS = @PTHREAD_LIBS@ @LIBS@
AM_CC = @PTHREAD_CC@


LIB_JNHW_POSIX_NAME=@JNHW_LIB_PREFIX@jnhw-posix@JNHW_LIBTOOL_LIB_SUFFIX@
LIB_JNHW_POSIX_RES_NAME=@JNHW_RESOURCES_DIR@/@JNHW_LIB_PREFIX@jnhw-posix@JNHW_LIB_SUFFIX@

lib_LTLIBRARIES = libjnhw-posix.la

noinst_LTLIBRARIES = \
 libaio.la \
 liberrno.la \
 libeventfd.la \
 libfcntl.la \
 libioclt.la \
 liblocale.la \
 libpoll.la \
 libpthread.la \
 libsched.la \
 libsignal.la \
 libstdio.la \
 libstring.la \
 libsysstat.la \
 libsystypes.la \
 libtermios.la \
 libtime.la \
 libucontext.la \
 libunistd.la \
 libposixutils.la

libjnhw_posix_la_LIBADD = \
 libaio.la \
 liberrno.la \
 libeventfd.la \
 libfcntl.la \
 libioclt.la \
 liblocale.la \
 libpoll.la \
 libpthread.la \
 libsched.la \
 libsignal.la \
 libstdio.la \
 libstring.la \
 libsysstat.la \
 libsystypes.la \
 libtermios.la \
 libtime.la \
 libucontext.la \
 libunistd.la \
 libposixutils.la \
 @JNHW_COMMON_SRC_DIR@/libjnhw-common.la

libjnhw_posix_la_SOURCES = \
 PosixDataType.c \
 jnhw-posix-jni.c

libaio_la_SOURCES = \
 AioFunctions.c

liberrno_la_SOURCES = \
 Isoc_ErrnoDefines.c \
 Isoc_ErrnoFunctions.c \
 Posix_ErrnoDefines.c

libeventfd_la_SOURCES = \
 EventFdFunctions.c

libfcntl_la_SOURCES = \
 FcntlFunctions.c

libioclt_la_SOURCES = \
 IoctlDefines.c \
 IoctlFunctions.c

liblocale_la_SOURCES = \
 LocaleFunctions.c

libpoll_la_SOURCES = \
 PollFunctions.c

libposixutils_la_SOURCES = \
 Defines.c

libpthread_la_SOURCES = \
 PthreadFunctions.c

libsched_la_SOURCES = \
 SchedFunctions.c

libsignal_la_SOURCES = \
 SignalFunctions.c \
 Callback__Sigval_int__V_Impl.c

libstdio_la_SOURCES = \
 StdioFunctions.c

libstring_la_SOURCES = \
 StringHeaderFunctions.c

libsystypes_la_SOURCES =

libsysstat_la_SOURCES = \
 StatFunctions.c

libtermios_la_SOURCES = \
 TermiosFunctions.c

libtime_la_SOURCES = \
 TimeFunctions.c

libucontext_la_SOURCES = \
 UcontextFunctions.c

libunistd_la_SOURCES = \
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
