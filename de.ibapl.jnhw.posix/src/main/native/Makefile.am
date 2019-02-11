AM_CPPFLAGS = @JNI_INCLUDE_FLAGS@ -I @JNI_HEADER_DIR@ -I @JNHW_COMMON_SRC_DIR@
AM_CFLAGS = -Wall -Werror
AM_LDFLAGS = -no-undefined -version-info @JNHW_VERSION_INFO@

LIB_JNHW_POSIX_NAME=@JNHW_LIB_PREFIX@jnhw-posix@JNHW_LIB_SUFFIX@
LIB_JNHW_POSIX_RES_NAME=@JNHW_RESOURCES_DIR@/$(LIB_JNHW_POSIX_NAME)

lib_LTLIBRARIES = libjnhw-posix.la

noinst_LTLIBRARIES = libpoll.la libeventfd.la libfcntl.la libunistd.la libioclt.la libtermios.la liberrno.la

libjnhw_posix_la_LIBADD = libpoll.la libeventfd.la libfcntl.la libunistd.la libioclt.la libtermios.la liberrno.la @JNHW_COMMON_SRC_DIR@/libjnhw-common.la

libjnhw_posix_la_SOURCES = \
 jnhw-posix-jni.c

liberrno_la_SOURCES = \
 Isoc_ErrnoDefines.c \
 Isoc_ErrnoFunctions.c \
 Posix_ErrnoDefines.c

libtermios_la_SOURCES = \
 TermiosDefines.c \
 TermiosFunctions.c \
 Termios_Termios.c

libioclt_la_SOURCES = \
 IocltDefines.c \
 IoctlFunctions.c

libunistd_la_SOURCES = \
 Isoc_UnistdDefines.c \
 Isoc_UnistdFunctions.c \
 Posix_UnistdFunctions.c

libfcntl_la_SOURCES = \
 FcntlDefines.c \
 FcntlFunctions.c

libpoll_la_SOURCES = \
 PollDefines.c \
 PollFunctions.c \
 Poll_PollFd.c 

libeventfd_la_SOURCES = \
 EventFdDefines.c \
 EventFdFunctions.c

#hook into make all
all-local: $(LIB_JNHW_POSIX_RES_NAME)

install-jnhw-resources: $(LIB_JNHW_POSIX_RES_NAME)

$(LIB_JNHW_POSIX_RES_NAME): libjnhw-posix.la
	$(MKDIR_P) @JNHW_RESOURCES_DIR@
	cp ./.libs/$(LIB_JNHW_POSIX_NAME) $(LIB_JNHW_POSIX_RES_NAME)
	$(STRIP) $(JNHW_STRIP_FLAG) $(LIB_JNHW_POSIX_RES_NAME)
