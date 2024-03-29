AC_DEFUN([JW_MULTIARCHTUPEL],
[case "$host_os" in
    mingw32*)
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
    darwin*)
	case "$host_cpu" in
	i686)
        	JNHW_MULTIARCH_TUPEL="i386-apple-darwin"
	;;
	arm*)
		JNHW_MULTIARCH_TUPEL="arm-apple-darwin"
	;;
	*)
        	JNHW_MULTIARCH_TUPEL="\$(host_cpu)-apple-darwin"
	;;
	esac
    ;;
    freebsd*)
	case "$host_cpu" in
	i686)
        	JNHW_MULTIARCH_TUPEL="i386-freebsd-bsd"
	;;
	arm*)
		JNHW_MULTIARCH_TUPEL="arm-freebsd-bsd"
	;;
	*)
        	JNHW_MULTIARCH_TUPEL="\$(host_cpu)-freebsd-bsd"
	;;
	esac
    ;;
    openbsd*)
	case "$host_cpu" in
	i686)
        	JNHW_MULTIARCH_TUPEL="i386-openbsd-bsd"
	;;
	arm*)
		JNHW_MULTIARCH_TUPEL="arm-openbsd-bsd"
	;;
	*)
        	JNHW_MULTIARCH_TUPEL="\$(host_cpu)-openbsd-bsd"
	;;
	esac
    ;;
    *)
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

AC_SUBST(JNHW_MULTIARCH_TUPEL)

])
