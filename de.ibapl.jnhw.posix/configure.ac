#                                               -*- Autoconf -*-
# Process this file with autoconf to produce a configure script.

AC_PREREQ([2.71])
AC_INIT([jnhw-posix],[4.0.0],[aploese@gmx.de])
AM_INIT_AUTOMAKE([foreign])
AM_MAINTAINER_MODE

AM_PROG_AR

LT_INIT()
AC_CONFIG_SRCDIR([src/test/native/libjnhw-posix-test.c])
AC_CONFIG_HEADERS([config.h])
AC_CONFIG_MACRO_DIRS([../m4])

# Checks for programs.
AC_PROG_CC
AC_SEARCH_LIBS([strerror],[cposix])

AC_PROG_INSTALL

JNHW_VERSION_INFO="4:0:0"
AC_SUBST(JNHW_VERSION_INFO)

#todo generate automatically from JNHW_VERSION_INFO
case "$host_os" in
    openbsd*)
        JNHW_LIBTOOL_LIB_VERSION="4.0"
    ;;
    *)
        JNHW_LIBTOOL_LIB_VERSION="4"
    ;;
esac
AC_SUBST(JNHW_LIBTOOL_LIB_VERSION)

JNHW_VERSION="4"
AC_SUBST(JNHW_VERSION)

JW_MULTIARCHTUPEL()
JW_LIB_PREFIX_SUFFIX()

JNHW_TEST_RESOURCES_DIR="\$(top_builddir)/src/test/resources/lib/\$(JNHW_MULTIARCH_TUPEL)"
AC_SUBST(JNHW_TEST_RESOURCES_DIR)

# Checks for libraries.
AX_PTHREAD(, [AC_MSG_ERROR([libpthread is required])])
AC_SEARCH_LIBS([timer_create],[rt])

# Checks for header files.
AC_CHECK_HEADERS([aio.h errno.h fcntl.h locale.h poll.h pthread.h sys/ioctl.h sys/eventfd.h sys/types.h sys/stat.h sched.h signal.h stdlib.h stdint.h stdio.h string.h termios.h time.h ucontext.h unistd.h ])

# Checks for typedefs, structures, and compiler characteristics.

# Checks for library functions.

AC_CONFIG_FILES([Makefile src/Makefile src/test/Makefile src/test/native/Makefile])

AC_OUTPUT
