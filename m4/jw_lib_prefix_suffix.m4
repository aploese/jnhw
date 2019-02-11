AC_DEFUN([JW_LIB_PREFIX_SUFFIX],
[case "$host_os" in
    mingw32*)
        JNHW_LIB_SUFFIX="-\$(JNHW_VERSION).dll"
        JNHW_LIB_PREFIX="lib"
    ;;
    *)
        JNHW_LIB_PREFIX="lib"
        JNHW_LIB_SUFFIX=".so.\$(JNHW_VERSION)"
    ;;
esac

AC_SUBST(JNHW_LIB_PREFIX)
AC_SUBST(JNHW_LIB_SUFFIX)

])
