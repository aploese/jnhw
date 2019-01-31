#                                               -*- Autoconf -*-
# Process this file with autoconf to produce a configure script.

AC_PREREQ([2.69])
AC_INIT([jnhw], [0.0.0], [aploese@gmx.de])
AM_INIT_AUTOMAKE([-Wall -Werror])
AM_MAINTAINER_MODE

AM_PROG_AR

LT_INIT([disable-static])
AC_CONFIG_SRCDIR([src/jnhw.c])
AC_CONFIG_HEADERS([config.h])
AC_CONFIG_MACRO_DIRS([m4])

AC_CHECK_SIZEOF([size_t])
AC_C_BIGENDIAN


# Checks for programs.
AC_PROG_CC
AC_PROG_CC_C_O
AC_PROG_INSTALL

AC_ARG_WITH([jni-header-dir],
  [AS_HELP_STRING([--with-jni-header-dir],
    [dir of generated jni headers (default ../target/gnererates-sources/include)])],
  [JNI_HEADER_DIR="$withval"], [JNI_HEADER_DIR="\$(top_builddir)/../target/generated-sources/include"])

#TODO check and make absolute path
AC_SUBST(JNI_HEADER_DIR)

JNHW_RESOURCES_DIR="\$(top_builddir)/../src/main/resources/lib/\$(build_cpu)-\$(build_os)"
AC_SUBST(JNHW_RESOURCES_DIR)

# Checks for libraries.

# Checks for header files.
AC_CHECK_HEADERS([errno.h fcntl.h unistd.h alloca.h poll.h stdlib.h stdint.h sys/ioctl.h sys/eventfd.h termios.h])


# Check for jni header files.
AX_JNI_INCLUDE_DIR
AC_SUBST(JNI_INCLUDE_DIRS)
for JNI_INCLUDE_DIR in $JNI_INCLUDE_DIRS
do
    JNI_INCLUDE_FLAGS="$JNI_INCLUDE_FLAGS -I$JNI_INCLUDE_DIR"
done
AC_SUBST(JNI_INCLUDE_FLAGS)

# Checks for typedefs, structures, and compiler characteristics.

# Checks for library functions.


AC_CONFIG_FILES([Makefile src/Makefile])

AC_OUTPUT
