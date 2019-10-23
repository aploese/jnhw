#                                               -*- Autoconf -*-
# Process this file with autoconf to produce a configure script.

AC_PREREQ([2.69])
AC_INIT([jnhw], [2.0.0], [aploese@gmx.de])
AM_INIT_AUTOMAKE([-Wall -Werror foreign])
AM_MAINTAINER_MODE

AM_PROG_AR

LT_INIT()
AC_CONFIG_MACRO_DIRS([m4])

# Checks for programs.
AC_PROG_CC
AC_PROG_INSTALL

# Checks for libraries.

# Checks for header files.
#put this here so we can provide this toplevel
# Check or manually define jni header files.
AC_ARG_WITH([jni-include-dir],
    [AS_HELP_STRING([--with-jni-include-dir],
    [set the jni include dir manually])],
    [JNI_INCLUDE_DIRS="$with_jni_include_dir"],
    [AX_JNI_INCLUDE_DIR])

# Checks for typedefs, structures, and compiler characteristics.

# Checks for library functions.

AC_CONFIG_SUBDIRS([de.ibapl.jnhw.common de.ibapl.jnhw.posix de.ibapl.jnhw.winapi])

AC_CONFIG_FILES([Makefile])

AC_OUTPUT
