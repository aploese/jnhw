
#include <stddef.h>

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
#include "de_ibapl_jnhw_posix_TermiosTest_NativeDefines.h"

#ifdef __cplusplus
extern "C" {
#endif

    //We need the POSIX version ...
#if !defined(HAVE_TERMIOS_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    HAVE_TERMIOS_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_HAVE_1TERMIOS_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_FALSE;
    }
#else
#include <termios.h>
#include <errno.h>

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    HAVE_TERMIOS_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_HAVE_1TERMIOS_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_TRUE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    _HAVE_STRUCT_TERMIOS_C_ISPEED
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines__1HAVE_1STRUCT_1TERMIOS_1C_1ISPEED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(_HAVE_STRUCT_TERMIOS_C_ISPEED)
        return JnhwWrapInteger(env, _HAVE_STRUCT_TERMIOS_C_ISPEED);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    _HAVE_STRUCT_TERMIOS_C_OSPEED
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines__1HAVE_1STRUCT_1TERMIOS_1C_1OSPEED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(_HAVE_STRUCT_TERMIOS_C_OSPEED)
        return JnhwWrapInteger(env, _HAVE_STRUCT_TERMIOS_C_OSPEED);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B0
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B0;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B1000000
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B1000000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, B1000000);
#else
#if !defined(B1000000)
        return NULL;
#else
#error "B1000000 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B110
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B110
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B110;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B115200
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B115200
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B115200;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B1152000
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B1152000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, B1152000);
#else
#if !defined(B1152000)
        return NULL;
#else
#error "B1152000 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B1200
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B1200
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B1200;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B134
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B134
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B134;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B150
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B150
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B150;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B1500000
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B1500000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, B1500000);
#else
#if !defined(B1500000)
        return NULL;
#else
#error "B1500000 defined"
#endif
#endif

    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B1800
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B1800
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B1800;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B19200
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B19200
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B19200;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B200
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B200
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B200;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B2000000
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B2000000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, B2000000);
#else
#if !defined(B2000000)
        return NULL;
#else
#error "B2000000 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B230400
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B230400
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B230400;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B2400
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B2400
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B2400;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B2500000
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B2500000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) && !defined(__sparc__)
        return JnhwWrapInteger(env, B2500000);
#else
#if !defined(B2500000)
        return NULL;
#else
#error "B2500000 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B300
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B300
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B300;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B3000000
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B3000000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) && !defined(__sparc__)
        return JnhwWrapInteger(env, B3000000);
#else
#if !defined(B3000000)
        return NULL;
#else
#error "B3000000 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B3500000
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B3500000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) && !defined(__sparc__)
        return JnhwWrapInteger(env, B3500000);
#else
#if !defined(B3500000)
        return NULL;
#else
#error "B3500000 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B38400
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B38400
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B38400;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B4000000
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B4000000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) && !defined(__sparc__)
        return JnhwWrapInteger(env, B4000000);
#else
#if !defined(B4000000)
        return NULL;
#else
#error "B4000000 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B460800
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B460800
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__FreeBSD__)
        return JnhwWrapInteger(env, B460800);
#else
#if !defined(B460800)
        return NULL;
#else
#error "B460800 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B4800
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B4800
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B4800;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B50
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B50
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B50;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B500000
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B500000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, B500000);
#else
#if !defined(B500000)
        return NULL;
#else
#error "B500000 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B57600
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B57600
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B57600;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B576000
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B576000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, B576000);
#else
#if !defined(B576000)
        returnNULL;
#else
#error "B576000 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B600
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B600
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B600;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B75
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B75
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B75;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B921600
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B921600
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__FreeBSD__)
        return JnhwWrapInteger(env, B921600);
#else
#if !defined(B921600)
        return NULL;
#else
#error "B921600 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    B9600
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_B9600
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B9600;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    BRKINT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_BRKINT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return BRKINT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    BS0
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_BS0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, BS0);
#else
#if !defined(BS0)
        return NULL;
#else
#error "BS0 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    BS1
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_BS1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, BS1);
#else
#if !defined(BS1)
        return NULL;
#else
#error "BS1 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    BSDLY
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_BSDLY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, BSDLY);
#else
#if !defined(BSDLY)
        return NULL;
#else
#error "BSDLY defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    CLOCAL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_CLOCAL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLOCAL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    CMSPAR
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_CMSPAR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__linux__)
#if defined(CMSPAR)
        //it is defined for mips at least since glibc 2.31
        return JnhwWrapInteger(env, CMSPAR);
#else
        return NULL;
#endif
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    CR0
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_CR0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, CR0);
#else
#if !defined(CR0)
        return NULL;
#else
#error "CR0 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    CR1
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_CR1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, CR1);
#else
#if !defined(CR1)
        return NULL;
#else
#error "CR1 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    CR2
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_CR2
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, CR2);
#else
#if !defined(CR2)
        return NULL;
#else
#error "CR2 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    CR3
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_CR3
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, CR3);
#else
#if !defined(CR3)
        return NULL;
#else
#error "CR3 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    CRDLY
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_CRDLY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, CRDLY);
#else
#if !defined(CRDLY)
        return NULL;
#else
#error "CRDLY defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    CREAD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_CREAD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CREAD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    CRTSCTS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_CRTSCTS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int32_t) CRTSCTS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    CS5
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_CS5
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CS5;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    CS6
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_CS6
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CS6;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    CS7
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_CS7
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CS7;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    CS8
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_CS8
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CS8;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    CSIZE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_CSIZE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CSIZE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    CSTOPB
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_CSTOPB
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CSTOPB;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    ECHO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_ECHO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ECHO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    ECHOE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_ECHOE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ECHOE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    ECHOK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_ECHOK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ECHOK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    ECHONL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_ECHONL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ECHONL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    FF0
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_FF0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, FF0);
#else
#if !defined(FF0)
        return NULL;
#else
#error "FF0 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    FF1
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_FF1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, FF1);
#else
#if !defined(FF1)
        return NULL;
#else
#error "FF1 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    FFDLY
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_FFDLY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, FFDLY);
#else
#if !defined(FFDLY)
        return NULL;
#else
#error "FFDLY defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    HUPCL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_HUPCL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return HUPCL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    ICANON
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_ICANON
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ICANON;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    ICRNL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_ICRNL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ICRNL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    IEXTEN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_IEXTEN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return IEXTEN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    IGNBRK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_IGNBRK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return IGNBRK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    IGNCR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_IGNCR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return IGNCR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    IGNPAR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_IGNPAR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return IGNPAR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    INLCR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_INLCR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return INLCR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    INPCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_INPCK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return INPCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    ISIG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_ISIG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ISIG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    ISTRIP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_ISTRIP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ISTRIP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    IXANY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_IXANY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return IXANY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    IXOFF
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_IXOFF
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return IXOFF;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    IXON
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_IXON
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return IXON;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    NCCS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_NCCS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return NCCS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    NL0
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_NL0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, NL0);
#else
#if !defined(NL0)
        return NULL;
#else
#error "NL0 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    NL1
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_NL1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, NL1);
#else
#if !defined(NL1)
        return NULL;
#else
#error "NL1 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    NLDLY
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_NLDLY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, NLDLY);
#else
#if !defined(NLDLY)
        return NULL;
#else
#error "NLDLY defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    NOFLSH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_NOFLSH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__APPLE__) || defined (__FreeBSD__) || defined (__OpenBSD__) || (defined(__linux__) && (defined(__powerpc__) || defined(__alpha__)))
        return (int32_t) NOFLSH;
#else
        return NOFLSH;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    OCRNL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_OCRNL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return OCRNL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    OFDEL
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_OFDEL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, OFDEL);
#else
#if !defined(OFDEL)
        return NULL;
#else
#error "OFDEL defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    OFILL
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_OFILL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, OFILL);
#else
#if !defined(OFILL)
        return NULL;
#else
#error "OFILL defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    ONLCR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_ONLCR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ONLCR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    ONLRET
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_ONLRET
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ONLRET;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    ONOCR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_ONOCR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ONOCR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    OPOST
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_OPOST
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return OPOST;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    PARENB
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_PARENB
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return PARENB;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    PAREXT
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_PAREXT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if !defined(PAREXT)
        return NULL;
#else
#error "PAREXT defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    PARMRK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_PARMRK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return PARMRK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    PARODD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_PARODD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return PARODD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    TAB0
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_TAB0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if !defined(TAB0)
        return NULL;
#else
#error "TAB0 defined"
#endif
#else
        return JnhwWrapInteger(env, TAB0);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    TAB1
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_TAB1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, TAB1);
#else
#if !defined(TAB1)
        return NULL;
#else
#error "TAB1 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    TAB2
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_TAB2
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, TAB2);
#else
#if !defined(TAB2)
        return NULL;
#else
#error "TAB2 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    TAB3
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_TAB3
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if !defined(TAB3)
        return NULL;
#else
#error "TAB3 defined"
#endif
#else
        return JnhwWrapInteger(env, TAB3);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    TABDLY
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_TABDLY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if !defined(TABDLY)
        return NULL;
#else
#error "TABDLY defined"
#endif
#else
        return JnhwWrapInteger(env, TABDLY);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    TCIFLUSH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_TCIFLUSH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCIFLUSH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    TCIOFF
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_TCIOFF
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCIOFF;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    TCIOFLUSH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_TCIOFLUSH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCIOFLUSH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    TCION
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_TCION
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCION;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    TCOFLUSH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_TCOFLUSH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCOFLUSH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    TCOOFF
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_TCOOFF
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCOOFF;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    TCOON
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_TCOON
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCOON;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    TCSADRAIN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_TCSADRAIN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCSADRAIN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    TCSAFLUSH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_TCSAFLUSH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCSAFLUSH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    TCSANOW
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_TCSANOW
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCSANOW;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    TOSTOP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_TOSTOP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TOSTOP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    VEOF
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_VEOF
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VEOF;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    VEOL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_VEOL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VEOL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    VERASE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_VERASE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VERASE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    VINTR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_VINTR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VINTR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    VKILL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_VKILL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VKILL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    VMIN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_VMIN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VMIN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    VQUIT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_VQUIT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VQUIT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    VSTART
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_VSTART
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VSTART;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    VSTOP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_VSTOP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VSTOP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    VSUSP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_VSUSP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VSUSP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    VT0
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_VT0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, VT0);
#else
#if !defined(VT0)
        return NULL;
#else
#error "VT0 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    VT1
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_VT1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, VT1);
#else
#if !defined(VT1)
        return NULL;
#else
#error "VT1 defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    VTDLY
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_VTDLY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return JnhwWrapInteger(env, VTDLY);
#else
#if !defined(VTDLY)
        return NULL;
#else
#error "VTDLY defined"
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeDefines
     * Method:    VTIME
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeDefines_VTIME
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VTIME;
    }

#endif

#ifdef __cplusplus
}
#endif
