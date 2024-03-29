#                                               -*- Autoconf -*-
# Process this file with autoconf to produce a configure script.

AC_PREREQ([2.71])
AC_INIT([jnhw],[4.0.0],[aploese@gmx.de])
AM_INIT_AUTOMAKE([foreign])
AM_MAINTAINER_MODE

AM_PROG_AR

LT_INIT()
AC_CONFIG_SRCDIR([src/test/native/libjnhw-common-test.c])
AC_CONFIG_HEADERS([config.h])
AC_CONFIG_MACRO_DIRS([../m4])

# Checks for programs.
AC_PROG_CC
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

JNHW_RESOURCES_DIR="\$(top_builddir)/src/main/resources/lib/\$(JNHW_MULTIARCH_TUPEL)"
AC_SUBST(JNHW_RESOURCES_DIR)

JNHW_TEST_RESOURCES_DIR="\$(top_builddir)/src/test/resources/lib/\$(JNHW_MULTIARCH_TUPEL)"
AC_SUBST(JNHW_TEST_RESOURCES_DIR)

# Checks for libraries.

# Checks for header files.
AC_CHECK_HEADERS([sys/types.h errno.h pthread.h windows.h])

# Checks for typedefs, structures, and compiler characteristics.

# Checks for library functions.

AC_CONFIG_FILES([Makefile src/Makefile src/main/Makefile src/main/native/Makefile src/test/Makefile src/test/native/Makefile])

AC_OUTPUT
