lib_LTLIBRARIES = libjnhw.la

noinst_LTLIBRARIES = libpoll.la libeventfd.la libfcntl.la libunistd.la libioclt.la libtermios.la liberrno.la libjnhwcommon.la 

AM_CPPFLAGS = @JNI_INCLUDE_FLAGS@ -I @JNI_HEADER_DIR@
AM_CFLAGS = -O3 -Wall -Werror
AM_LDFLAGS = --no-undefined 

JNHW_RESOURCES_DIR = @JNHW_RESOURCES_DIR@

libjnhw_la_LIBADD = libpoll.la libeventfd.la libfcntl.la libunistd.la libioclt.la libtermios.la liberrno.la libjnhwcommon.la

libjnhw_la_SOURCES = 

liberrno_la_SOURCES = \
 Errno.c

libjnhwcommon_la_SOURCES = \
 JnhwExceptions.c \
 jnhw.c \
 LibCHeader_OpaqueMemory.c

libtermios_la_SOURCES = \
 TermiosDefines.c \
 TermiosFunctions.c \
 Termios_Termios.c

libioclt_la_SOURCES = \
 IocltDefines.c \
 IoctlFunctions.c

libunistd_la_SOURCES = \
 UnistdFunctions.c

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


install-jnhw-resources: libjnhw.la
	$(MKDIR_P) $(JNHW_RESOURCES_DIR)
	cp ./.libs/libjnhw.so $(JNHW_RESOURCES_DIR)
	$(STRIP) -s $(JNHW_RESOURCES_DIR)/libjnhw.so
