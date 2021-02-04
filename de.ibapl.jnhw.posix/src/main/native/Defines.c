/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2021, Arne Plöse and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
#include "jnhw-posix.h"
#include "de_ibapl_jnhw_util_posix_Defines.h"

#include <stdint.h>
#include <unistd.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_util_posix_Defines_initFields
    (JNIEnv *env, jclass clazz) {

#if defined(_LARGEFILE_SOURCE)
        if (JnhwSetStaticIntDefineField(env, clazz, "_LARGEFILE_SOURCE", _LARGEFILE_SOURCE)) {
            return;
        }
#endif

#if defined(_LARGEFILE64_SOURCE)
        if (JnhwSetStaticIntDefineField(env, clazz, "_LARGEFILE64_SOURCE", _LARGEFILE64_SOURCE)) {
            return;
        }
#endif

#if defined(__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__APPLE__", __APPLE__)) {
            return;
        }
#endif

#if defined(__FreeBSD__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__FreeBSD__", __FreeBSD__)) {
            return;
        }
#endif

#if defined(__OpenBSD__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__OpenBSD__", __OpenBSD__)) {
            return;
        }
#endif

#if defined (__WIN32__) || defined(__OpenBSD__)
#if defined(__WORDSIZE)
#error "__WORDSIZE defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "__WORDSIZE", __WORDSIZE)) {
            return;
        }
#endif

#if defined(__TIMESIZE)
        if (JnhwSetStaticIntDefineField(env, clazz, "__TIMESIZE", __TIMESIZE)) {
            return;
        }
#endif

#if defined(__GNU_LIBRARY__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__GNU_LIBRARY__", __GNU_LIBRARY__)) {
            return;
        }
#endif

#if defined(__GLIBC__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__GLIBC__", __GLIBC__)) {
            return;
        }
#endif

#if defined(__GLIBC_MINOR__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__GLIBC_MINOR__", __GLIBC_MINOR__)) {
            return;
        }
#endif

        if (JnhwSetStaticIntField(env, clazz, "__SIZEOF_POINTER__", __SIZEOF_POINTER__)) {
            return;
        }

        if (JnhwSetStaticIntField(env, clazz, "__SIZEOF_LONG__", __SIZEOF_LONG__)) {
            return;
        }

#if defined (__LP64__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__LP64__", __LP64__)) {
            return;
        }
#endif

#if defined (__ILP32__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__ILP32__", __ILP32__)) {
            return;
        }
#endif

        if (JnhwSetStaticIntField(env, clazz, "__BIGGEST_ALIGNMENT__", __BIGGEST_ALIGNMENT__)) {
            return;
        }

        if (JnhwSetStaticIntField(env, clazz, "__ORDER_LITTLE_ENDIAN__", __ORDER_LITTLE_ENDIAN__)) {
            return;
        }

        if (JnhwSetStaticIntField(env, clazz, "__ORDER_BIG_ENDIAN__", __ORDER_BIG_ENDIAN__)) {
            return;
        }

        if (JnhwSetStaticIntField(env, clazz, "__ORDER_PDP_ENDIAN__", __ORDER_PDP_ENDIAN__)) {
            return;
        }

        if (JnhwSetStaticIntField(env, clazz, "__BYTE_ORDER__", __BYTE_ORDER__)) {
            return;
        }

#if defined (_FILE_OFFSET_BITS)
        return _FILE_OFFSET_BITS;
        if (JnhwSetStaticIntDefineField(env, clazz, "_FILE_OFFSET_BITS", _FILE_OFFSET_BITS)) {
            return;
        }
#endif

#if defined (_BSD_SOURCE)
        if (JnhwSetStaticIntDefineField(env, clazz, "_BSD_SOURCE", _BSD_SOURCE)) {
            return;
        }
#endif

#if defined (_POSIX_C_SOURCE)
        if (JnhwSetStaticIntDefineField(env, clazz, "_POSIX_C_SOURCE", _POSIX_C_SOURCE)) {
            return;
        }
#endif

#if defined (_XOPEN_SOURCE)
        if (JnhwSetStaticIntDefineField(env, clazz, "_XOPEN_SOURCE", _XOPEN_SOURCE)) {
            return;
        }
#endif

#if defined (_XOPEN_SOURCE_EXTENDED)
        if (JnhwSetStaticIntDefineField(env, clazz, "_XOPEN_SOURCE_EXTENDED", _XOPEN_SOURCE_EXTENDED)) {
            return;
        }
#endif

#if defined(__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__linux__", __linux__)) {
            return;
        }
#endif

#if defined(__aarch64__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__aarch64__", __aarch64__)) {
            return;
        }
#endif

#if defined(__alpha__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__alpha__", __alpha__)) {
            return;
        }
#endif

#if defined(__arm__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__arm__", __arm__)) {
            return;
        }
#endif

#if defined(__ARM_ARCH)
        if (JnhwSetStaticIntDefineField(env, clazz, "__ARM_ARCH", __ARM_ARCH)) {
            return;
        }
#endif

#if defined(__powerpc__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__powerpc__", __powerpc__)) {
            return;
        }
#endif

#if defined(__powerpc64__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__powerpc64__", __powerpc64__)) {
            return;
        }
#endif

#if defined(__mips__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__mips__", __mips__)) {
            return;
        }
#endif

#if defined(__mips64)
        if (JnhwSetStaticIntDefineField(env, clazz, "__mips64", __mips64)) {
            return;
        }
#endif

#if defined(__MIPS_ARCH)
        if (JnhwSetStaticIntDefineField(env, clazz, "__MIPS_ARCH", __MIPS_ARCH)) {
            return;
        }
#endif

#if defined(__MIPSEB__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__MIPSEB__", __MIPSEB__)) {
            return;
        }
#endif

#if defined(__MIPSEL__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__MIPSEL__", __MIPSEL__)) {
            return;
        }
#endif

#if defined( __riscv__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__riscv__", __riscv__)) {
            return;
        }
#endif

#if defined(__s390__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__s390__", __s390__)) {
            return;
        }
#endif

#if defined(__s390x__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__s390x__", __s390x__)) {
            return;
        }
#endif

#if defined(__sh__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__sh__", __sh__)) {
            return;
        }
#endif

#if defined(__SH4__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__SH4__", __SH4__)) {
            return;
        }
#endif

#if defined(__sparc__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__sparc__", __sparc__)) {
            return;
        }
#endif

#if defined(__sparc64__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__sparc64__", __sparc64__)) {
            return;
        }
#endif

#if defined(__i386__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__i386__", __i386__)) {
            return;
        }
#endif

#if defined(__i686__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__i686__", __i686__)) {
            return;
        }
#endif

#if defined(__amd64__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__amd64__", __amd64__)) {
            return;
        }
#endif

#if defined(__x86_64__)
        if (JnhwSetStaticIntDefineField(env, clazz, "__x86_64__", __x86_64__)) {
            return;
        }
#endif
    }
#ifdef __cplusplus
}
#endif
