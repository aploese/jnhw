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
     * Method:    _LARGEFILE_SOURCE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1LARGEFILE_1SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(_LARGEFILE_SOURCE)
        return _LARGEFILE_SOURCE;
#else
        throw_NotDefinedException(env, "_LARGEFILE_SOURCE");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    _LARGEFILE64_SOURCE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1LARGEFILE64_1SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(_LARGEFILE64_SOURCE)
        return _LARGEFILE64_SOURCE;
#else
        throw_NotDefinedException(env, "_LARGEFILE64_SOURCE");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __APPLE__
     * Signature: ()Z
     * I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1APPLE_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__)
        return __APPLE__;
#else
        throw_NotDefinedException(env, "__APPLE__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __FreeBSD__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1FreeBSD_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__FreeBSD__)
        return __FreeBSD__;
#else
        throw_NotDefinedException(env, "__FreeBSD__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __OpenBSD__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1OpenBSD_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
        return __OpenBSD__;
#else
        throw_NotDefinedException(env, "__OpenBSD__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __WORDSIZE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1WORDSIZE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__WIN32__) || defined(__OpenBSD__)
#if defined(__WORDSIZE)
#error "__WORDSIZE defined"
#endif
        throw_NotDefinedException(env, "__WORDSIZE");
        return 0;
#else
        return __WORDSIZE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __TIMESIZE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1TIMESIZE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__TIMESIZE)
        return __TIMESIZE;
#else
        throw_NotDefinedException(env, "__TIMESIZE");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __GNU_LIBRARY__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1GNU_1LIBRARY_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__GNU_LIBRARY__)
        return __GNU_LIBRARY__;
#else
        throw_NotDefinedException(env, "__GNU_LIBRARY__");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __GLIBC__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1GLIBC_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__GLIBC__)
        return __GLIBC__;
#else
        throw_NotDefinedException(env, "__GLIBC__");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __GLIBC_MINOR__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1GLIBC_1MINOR_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__GLIBC_MINOR__)
        return __GLIBC_MINOR__;
#else
        throw_NotDefinedException(env, "__GLIBC_MINOR__");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __SIZEOF_POINTER__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1SIZEOF_1POINTER_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __SIZEOF_POINTER__;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __SIZEOF_LONG__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1SIZEOF_1LONG_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __SIZEOF_LONG__;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __LP64__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1LP64_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__LP64__)
        return __LP64__;
#else
        throw_NotDefinedException(env, "__LP64__");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __ILP32__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1ILP32_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__ILP32__)
        return __ILP32__;
#else
        throw_NotDefinedException(env, "__ILP32__");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __BIGGEST_ALIGNMENT__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1BIGGEST_1ALIGNMENT_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __BIGGEST_ALIGNMENT__;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __ORDER_LITTLE_ENDIAN__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1ORDER_1LITTLE_1ENDIAN_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __ORDER_LITTLE_ENDIAN__;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __ORDER_BIG_ENDIAN__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1ORDER_1BIG_1ENDIAN_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __ORDER_BIG_ENDIAN__;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __ORDER_PDP_ENDIAN__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1ORDER_1PDP_1ENDIAN_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __ORDER_PDP_ENDIAN__;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __BYTE_ORDER__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1BYTE_1ORDER_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __BYTE_ORDER__;
    }


    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    _FILE_OFFSET_BITS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1FILE_1OFFSET_1BITS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (_FILE_OFFSET_BITS)
        return _FILE_OFFSET_BITS;
#else
        throw_NotDefinedException(env, "_FILE_OFFSET_BITS");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    _BSD_SOURCE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1BSD_1SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (_BSD_SOURCE)
        return _BSD_SOURCE;
#else
        throw_NotDefinedException(env, "_BSD_SOURCE");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    _POSIX_C_SOURCE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1POSIX_1C_1SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (_POSIX_C_SOURCE)
        return _POSIX_C_SOURCE;
#else
        throw_NotDefinedException(env, "_POSIX_C_SOURCE");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    _XOPEN_SOURCE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1XOPEN_1SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (_XOPEN_SOURCE)
        return _XOPEN_SOURCE;
#else
        throw_NotDefinedException(env, "_XOPEN_SOURCE");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    _XOPEN_SOURCE_EXTENDED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1XOPEN_1SOURCE_1EXTENDED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (_XOPEN_SOURCE_EXTENDED)
        return _XOPEN_SOURCE_EXTENDED;
#else
        throw_NotDefinedException(env, "_XOPEN_SOURCE_EXTENDED");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __linux__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1linux_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__linux__)
        return __linux__;
#else
        throw_NotDefinedException(env, "__linux__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __aarch64__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1aarch64_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__aarch64__)
        return __aarch64__;
#else
        throw_NotDefinedException(env, "__aarch64__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __alpha__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1alpha_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__alpha__)
        return __alpha__;
#else
        throw_NotDefinedException(env, "__alpha__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __arm__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1arm_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__arm__)
        return __arm__;
#else
        throw_NotDefinedException(env, "__arm__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __ARM_ARCH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1ARM_1ARCH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__ARM_ARCH)
        return __ARM_ARCH;
#else
        throw_NotDefinedException(env, "__ARM_ARCH");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __powerpc__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1powerpc_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__powerpc__)
        return __powerpc__;
#else
        throw_NotDefinedException(env, "__powerpc__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __powerpc64__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1powerpc64_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__powerpc64__)
        return __powerpc64__;
#else
        throw_NotDefinedException(env, "__powerpc64__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __mips__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1mips_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__mips__)
        return __mips__;
#else
        throw_NotDefinedException(env, "__mips__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __mips64
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1mips64
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__mips64)
        return __mips64;
#else
        throw_NotDefinedException(env, "__mips64");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __MIPS_ARCH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1MIPS_1ARCH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__MIPS_ARCH)
        return __MIPS_ARCH;
#else
        throw_NotDefinedException(env, "__MIPS_ARCH");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __MIPSEB__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1MIPSEB_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__MIPSEB__)
        return __MIPSEB__;
#else
        throw_NotDefinedException(env, "__MIPSEB__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __MIPSEL__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1MIPSEL_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__MIPSEL__)
        return __MIPSEL__;
#else
        throw_NotDefinedException(env, "__MIPSEL__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __riscv__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1riscv_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined( __riscv__)
        return  __riscv__;
#else
        throw_NotDefinedException(env, " __riscv__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __s390__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1s390_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__s390__)
        return __s390__;
#else
        throw_NotDefinedException(env, "__s390__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __s390x__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1s390x_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__s390x__)
        return __s390x__;
#else
        throw_NotDefinedException(env, "__s390x__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __sh__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1sh_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__sh__)
        return __sh__;
#else
        throw_NotDefinedException(env, "__sh__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __SH4__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1SH4_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__SH4__)
        return __SH4__;
#else
        throw_NotDefinedException(env, "__SH4__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __sparc__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1sparc_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__sparc__)
        return __sparc__;
#else
        throw_NotDefinedException(env, "__sparc__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __sparc64__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1sparc64_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__sparc64__)
        return __sparc64__;
#else
        throw_NotDefinedException(env, "__sparc64__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __i386__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1i386_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__i386__)
        return __i386__;
#else
        throw_NotDefinedException(env, "__i386__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __i686__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1i686_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__i686__)
        return __i686__;
#else
        throw_NotDefinedException(env, "__i686__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __amd64__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1amd64_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__amd64__)
        return __amd64__;
#else
        throw_NotDefinedException(env, "__amd64__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __x86_64__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1x86_164_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__x86_64__)
        return __x86_64__;
#else
        throw_NotDefinedException(env, "__x86_64__");
        return -1;
#endif
    }

#ifdef __cplusplus
}
#endif
