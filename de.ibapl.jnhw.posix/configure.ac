#                                               -*- Autoconf -*-
# Process this file with autoconf to produce a configure script.

AC_PREREQ([2.69])
AC_INIT([jnhw-posix], [3.0.0], [aploese@gmx.de])
AM_INIT_AUTOMAKE([foreign])
AM_MAINTAINER_MODE

AM_PROG_AR

LT_INIT()
AC_CONFIG_SRCDIR([src/main/native/jnhw-posix-jni.c])
AC_CONFIG_HEADERS([config.h])
AC_CONFIG_MACRO_DIRS([../m4])

# Checks for programs.
AC_PROG_CC
AC_ISC_POSIX

AC_PROG_INSTALL

# Check or manually define jni header files.
AC_ARG_WITH([jni-include-dir],
    [AS_HELP_STRING([--with-jni-include-dir],
    [set the jni include dir manually])],
    [JNI_INCLUDE_DIRS="$with_jni_include_dir"],
    [AX_JNI_INCLUDE_DIR])
AC_SUBST(JNI_INCLUDE_DIRS)
for JNI_INCLUDE_DIR in $JNI_INCLUDE_DIRS
do
    JNI_INCLUDE_FLAGS="$JNI_INCLUDE_FLAGS -I$JNI_INCLUDE_DIR"
done
AC_SUBST(JNI_INCLUDE_FLAGS)

JNHW_VERSION_INFO="3:0:0"
AC_SUBST(JNHW_VERSION_INFO)

#todo generate automatically from JNHW_VERSION_INFO
case "$host_os" in
    openbsd*)
        JNHW_LIBTOOL_LIB_VERSION="3.0"
    ;;
    *)
        JNHW_LIBTOOL_LIB_VERSION="3"
    ;;
esac
AC_SUBST(JNHW_LIBTOOL_LIB_VERSION)

JNHW_VERSION="3"
AC_SUBST(JNHW_VERSION)

JW_MULTIARCHTUPEL()
JW_LIB_PREFIX_SUFFIX()

JNHW_RESOURCES_DIR="\$(top_builddir)/src/main/resources/lib/\$(JNHW_MULTIARCH_TUPEL)"
AC_SUBST(JNHW_RESOURCES_DIR)

JNHW_TEST_RESOURCES_DIR="\$(top_builddir)/src/test/resources/lib/\$(JNHW_MULTIARCH_TUPEL)"
AC_SUBST(JNHW_TEST_RESOURCES_DIR)

JNI_HEADER_DIR="\$(top_builddir)/src/main/native/include"
AC_SUBST(JNI_HEADER_DIR)

JNI_TEST_HEADER_DIR="\$(top_builddir)/src/test/native/include"
AC_SUBST(JNI_TEST_HEADER_DIR)

#get path of jnhw-common.h - The Quick and Dirty way....
JNHW_COMMON_SRC_DIR="\$(top_builddir)/../de.ibapl.jnhw.common/src/main/native"
AC_SUBST(JNHW_COMMON_SRC_DIR)

#get path of jnhw-posix.h - The Quick and Dirty way....
JNHW_POSIX_SRC_DIR="\$(top_builddir)/src/main/native"
AC_SUBST(JNHW_POSIX_SRC_DIR)

# Checks for libraries.
AX_PTHREAD(, [AC_MSG_ERROR([libpthread is required])])
AC_SEARCH_LIBS([timer_create],[rt])

# Checks for header files.
AC_CHECK_HEADERS([aio.h errno.h fcntl.h locale.h poll.h pthread.h sys/ioctl.h sys/eventfd.h sys/types.h sys/stat.h sched.h signal.h stdlib.h stdint.h stdio.h string.h termios.h time.h ucontext.h unistd.h ])

# Checks for typedefs, structures, and compiler characteristics.

# Checks for library functions.

AC_CONFIG_FILES([Makefile src/Makefile src/main/Makefile src/main/native/Makefile src/test/Makefile src/test/native/Makefile])

AC_OUTPUT
