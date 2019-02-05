lib_LTLIBRARIES = libjnhw-posix.la

noinst_LTLIBRARIES = libpoll.la libeventfd.la libfcntl.la libunistd.la libioclt.la libtermios.la liberrno.la

AM_CPPFLAGS = @JNI_INCLUDE_FLAGS@ -I @JNI_HEADER_DIR@ -I @JNHW_COMMON_SRC_DIR@
AM_CFLAGS = -O3 -Wall -Werror
AM_LDFLAGS = -no-undefined

JNHW_RESOURCES_DIR = @JNHW_RESOURCES_DIR@

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
 Isoc_UnistdFunctions.c \
 Posix_UnistdFunctions.c

libfcntl_la_SOURCES = \
 Isoc_FcntlDefines.c \
 Isoc_FcntlFunctions.c \
 Posix_FcntlDefines.c \
 Posix_FcntlFunctions.c

libpoll_la_SOURCES = \
 PollDefines.c \
 PollFunctions.c \
 Poll_PollFd.c 

libeventfd_la_SOURCES = \
 EventFdDefines.c \
 EventFdFunctions.c

#hook into make all
all-local: @JNHW_RESOURCES_DIR@/libjnhw-posix@JNHW_LIB_SUFFIX@ 

install-jnhw-resources: @JNHW_RESOURCES_DIR@/libjnhw-posix@JNHW_LIB_SUFFIX@ 

@JNHW_RESOURCES_DIR@/libjnhw-posix@JNHW_LIB_SUFFIX@: libjnhw-posix.la
	$(MKDIR_P) @JNHW_RESOURCES_DIR@
	cp ./.libs/libjnhw-posix@JNHW_LTLIB_SUFFIX@ @JNHW_RESOURCES_DIR@/libjnhw-posix@JNHW_LIB_SUFFIX@
	$(STRIP) -s @JNHW_RESOURCES_DIR@/libjnhw-posix@JNHW_LIB_SUFFIX@