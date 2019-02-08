#                                               -*- Autoconf -*-
# Process this file with autoconf to produce a configure script.

AC_PREREQ([2.69])
AC_INIT([jnhw-winapi], [0.0.0], [aploese@gmx.de])
AM_INIT_AUTOMAKE([-Wall -Werror foreign])
AM_MAINTAINER_MODE

AM_PROG_AR

LT_INIT()
AC_CONFIG_SRCDIR([src/main/native/jnhw-winapi-jni.c])
AC_CONFIG_HEADERS([config.h])
AC_CONFIG_MACRO_DIRS([m4])

# Checks for programs.
AC_PROG_CC
AC_PROG_INSTALL

# Check for jni header files.
AX_JNI_INCLUDE_DIR
AC_SUBST(JNI_INCLUDE_DIRS)
for JNI_INCLUDE_DIR in $JNI_INCLUDE_DIRS
do
    JNI_INCLUDE_FLAGS="$JNI_INCLUDE_FLAGS -I$JNI_INCLUDE_DIR"
done
AC_SUBST(JNI_INCLUDE_FLAGS)

JNHW_VERSION_INFO="0:0:0"
AC_SUBST(JNHW_VERSION_INFO)
JNHW_VERSION="0"
AC_SUBST(JNHW_VERSION)

case "$host_os" in
    mingw32*)
        JNHW_LIB_SUFFIX="-\$(JNHW_VERSION).dll"
        JNHW_LIB_PREFIX="lib"
        case "$host_cpu" in
            x86_64)
                JNHW_MULTIARCH_TUPEL="x86_64-windows-pe32+"
            ;;
            i686)
                JNHW_MULTIARCH_TUPEL="x86-windows-pe32"
            ;;
            *)
                fail Unknown CPU
            ;;
        esac
    ;;
    *)
        JNHW_LIB_PREFIX="lib"
        JNHW_LIB_SUFFIX=".so.\$(JNHW_VERSION)"
	case "$host_cpu" in
	i686)
        	JNHW_MULTIARCH_TUPEL="i386-\$(host_os)"
	;;
	arm*)
		JNHW_MULTIARCH_TUPEL="arm-\$(host_os)"
	;;
	*)
        	JNHW_MULTIARCH_TUPEL="\$(host_cpu)-\$(host_os)"
	;;
	esac
    ;;
esac

AC_SUBST(JNHW_LIB_PREFIX)
AC_SUBST(JNHW_LIB_SUFFIX)
AC_SUBST(JNHW_MULTIARCH_TUPEL)

JNHW_RESOURCES_DIR="\$(top_builddir)/src/main/resources/lib/\$(JNHW_MULTIARCH_TUPEL)"
AC_SUBST(JNHW_RESOURCES_DIR)

JNI_HEADER_DIR="\$(top_builddir)/target/generated-sources/include"
AC_SUBST(JNI_HEADER_DIR)

#get path of jnhw.h - The Quick and Dirty way....
JNHW_COMMON_SRC_DIR="\$(top_builddir)/../de.ibapl.jnhw.common/src/main/native"
AC_SUBST(JNHW_COMMON_SRC_DIR)

# Checks for libraries.

# Checks for header files.
AC_CHECK_HEADERS([fileapi.h minwinbase.h  minwindef.h ])

# Checks for typedefs, structures, and compiler characteristics.

# Checks for library functions.

AC_CONFIG_FILES([Makefile src/Makefile src/main/Makefile src/main/native/Makefile])

AC_OUTPUT
