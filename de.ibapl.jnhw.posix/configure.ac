#                                               -*- Autoconf -*-
# Process this file with autoconf to produce a configure script.

AC_PREREQ([2.69])
AC_INIT([jnhw-posix], [2.0.0], [aploese@gmx.de])
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

JNHW_VERSION_INFO="1:0:0"
AC_SUBST(JNHW_VERSION_INFO)
JNHW_VERSION="1"
AC_SUBST(JNHW_VERSION)

JW_MULTIARCHTUPEL()
JW_LIB_PREFIX_SUFFIX()

JNHW_RESOURCES_DIR="\$(top_builddir)/src/main/resources/lib/\$(JNHW_MULTIARCH_TUPEL)"
AC_SUBST(JNHW_RESOURCES_DIR)

JNI_HEADER_DIR="\$(top_builddir)/target/generated-sources/include"
AC_SUBST(JNI_HEADER_DIR)

#get path of jnhw-common.h - The Quick and Dirty way....
JNHW_COMMON_SRC_DIR="\$(top_builddir)/../de.ibapl.jnhw.common/src/main/native"
AC_SUBST(JNHW_COMMON_SRC_DIR)

# Checks for libraries.

# Checks for header files.
AC_CHECK_HEADERS([aio.h errno.h fcntl.h locale.h poll.h pthread.h sys/ioctl.h sys/eventfd.h sys/types.h sys/stat.h signal.h stdlib.h stdint.h stdio.h termios.h time.h unistd.h ])

# Checks for typedefs, structures, and compiler characteristics.

# Checks for library functions.

AC_CONFIG_FILES([Makefile src/Makefile src/main/Makefile src/main/native/Makefile])

AC_OUTPUT
