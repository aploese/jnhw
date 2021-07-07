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
#include "de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines.h"

#include <stdint.h>
#include <unistd.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    _BSD_SOURCE
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1BSD_1SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (_BSD_SOURCE)
        return JnhwWrapInteger(env, _BSD_SOURCE);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    _FILE_OFFSET_BITS
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1FILE_1OFFSET_1BITS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (_FILE_OFFSET_BITS)
        return JnhwWrapInteger(env, _FILE_OFFSET_BITS);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    _LARGEFILE64_SOURCE
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1LARGEFILE64_1SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(_LARGEFILE64_SOURCE)
        return JnhwWrapInteger(env, _LARGEFILE64_SOURCE);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    _LARGEFILE_SOURCE
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1LARGEFILE_1SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(_LARGEFILE_SOURCE)
        return JnhwWrapInteger(env, _LARGEFILE_SOURCE);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    _POSIX_C_SOURCE
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1POSIX_1C_1SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (_POSIX_C_SOURCE)
        return JnhwWrapInteger(env, _POSIX_C_SOURCE);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    _XOPEN_SOURCE
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1XOPEN_1SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (_XOPEN_SOURCE)
        return JnhwWrapInteger(env, _XOPEN_SOURCE);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    _XOPEN_SOURCE_EXTENDED
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1XOPEN_1SOURCE_1EXTENDED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (_XOPEN_SOURCE_EXTENDED)
        return JnhwWrapInteger(env, _XOPEN_SOURCE_EXTENDED);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __aarch64__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1aarch64_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__aarch64__)
        return JnhwWrapInteger(env, __aarch64__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __alpha__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1alpha_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__alpha__)
        return JnhwWrapInteger(env, __alpha__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __amd64__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1amd64_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__amd64__)
        return JnhwWrapInteger(env, __amd64__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __APPLE__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1APPLE_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__)
        return JnhwWrapInteger(env, __APPLE__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __arm__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1arm_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__arm__)
        return JnhwWrapInteger(env, __arm__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __ARM_ARCH
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1ARM_1ARCH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__ARM_ARCH)
        return JnhwWrapInteger(env, __ARM_ARCH);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __BIGGEST_ALIGNMENT__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1BIGGEST_1ALIGNMENT_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __BIGGEST_ALIGNMENT__;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __BYTE_ORDER__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1BYTE_1ORDER_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __BYTE_ORDER__;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __FreeBSD__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1FreeBSD_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__FreeBSD__)
        return JnhwWrapInteger(env, __FreeBSD__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __GLIBC_MINOR__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1GLIBC_1MINOR_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__GLIBC_MINOR__)
        return JnhwWrapInteger(env, __GLIBC_MINOR__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __GLIBC__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1GLIBC_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__GLIBC__)
        return JnhwWrapInteger(env, __GLIBC__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __GNU_LIBRARY__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1GNU_1LIBRARY_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__GNU_LIBRARY__)
        return JnhwWrapInteger(env, __GNU_LIBRARY__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __i386__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1i386_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__i386__)
        return JnhwWrapInteger(env, __i386__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __i686__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1i686_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__i686__)
        return JnhwWrapInteger(env, __i686__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __ILP32__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1ILP32_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__ILP32__)
        return JnhwWrapInteger(env, __ILP32__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __linux__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1linux_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__linux__)
        return JnhwWrapInteger(env, __linux__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __LP64__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1LP64_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__LP64__)
        return JnhwWrapInteger(env, __LP64__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __mips__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1mips_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__mips__)
        return JnhwWrapInteger(env, __mips__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __mips64
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1mips64
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__mips64)
        return JnhwWrapInteger(env, __mips64);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __MIPSEB__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1MIPSEB_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__MIPSEB__)
        return JnhwWrapInteger(env, __MIPSEB__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __MIPSEL__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1MIPSEL_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__MIPSEL__)
        return JnhwWrapInteger(env, __MIPSEL__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __ORDER_BIG_ENDIAN__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1ORDER_1BIG_1ENDIAN_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __ORDER_BIG_ENDIAN__;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __ORDER_LITTLE_ENDIAN__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1ORDER_1LITTLE_1ENDIAN_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __ORDER_LITTLE_ENDIAN__;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __ORDER_PDP_ENDIAN__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1ORDER_1PDP_1ENDIAN_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __ORDER_PDP_ENDIAN__;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __OpenBSD__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1OpenBSD_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
        return JnhwWrapInteger(env, __OpenBSD__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __powerpc__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1powerpc_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__powerpc__)
        return JnhwWrapInteger(env, __powerpc__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __powerpc64__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1powerpc64_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__powerpc64__)
        return JnhwWrapInteger(env, __powerpc64__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __riscv
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1riscv
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined( __riscv)
        return JnhwWrapInteger(env, __riscv);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __SH4__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1SH4_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__SH4__)
        return JnhwWrapInteger(env, __SH4__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __SIZEOF_LONG__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1SIZEOF_1LONG_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __SIZEOF_LONG__;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __SIZEOF_POINTER__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1SIZEOF_1POINTER_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __SIZEOF_POINTER__;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __s390__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1s390_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__s390__)
        return JnhwWrapInteger(env, __s390__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __s390x__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1s390x_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__s390x__)
        return JnhwWrapInteger(env, __s390x__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __sh__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1sh_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__sh__)
        return JnhwWrapInteger(env, __sh__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __sparc64__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1sparc64_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__sparc64__)
        return JnhwWrapInteger(env, __sparc64__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __sparc__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1sparc_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__sparc__)
        return JnhwWrapInteger(env, __sparc__);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __TIMESIZE
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1TIMESIZE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__TIMESIZE)
        return JnhwWrapInteger(env, __TIMESIZE);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __WORDSIZE
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1WORDSIZE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__WIN32__) || defined(__OpenBSD__)
#if !defined(__WORDSIZE)
        return NULL;
#else
#error "__WORDSIZE defined"
#endif
#else
        return JnhwWrapInteger(env, __WORDSIZE);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_DefinesTest_NativeDefines
     * Method:    __x86_64__
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_DefinesTest_00024NativeDefines__1_1x86_164_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__x86_64__)
        return JnhwWrapInteger(env, __x86_64__);
#else
        return NULL;
#endif
    }

#ifdef __cplusplus
}
#endif
