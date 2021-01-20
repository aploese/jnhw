/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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
#include "de_ibapl_jnhw_posix_Termios.h"

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    HAVE_TERMIOS_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Termios_HAVE_1TERMIOS_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(HAVE_TERMIOS_H) && defined(_POSIX_VERSION)
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

#ifdef _POSIX_VERSION
#include <termios.h>
#include <errno.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    _HAVE_STRUCT_TERMIOS_C_ISPEED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios__1HAVE_1STRUCT_1TERMIOS_1C_1ISPEED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(_HAVE_STRUCT_TERMIOS_C_ISPEED)
        return _HAVE_STRUCT_TERMIOS_C_ISPEED;
#else
        throw_NotDefinedException(env, "_HAVE_STRUCT_TERMIOS_C_ISPEED");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    _HAVE_STRUCT_TERMIOS_C_OSPEED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios__1HAVE_1STRUCT_1TERMIOS_1C_1OSPEED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(_HAVE_STRUCT_TERMIOS_C_OSPEED)
        return _HAVE_STRUCT_TERMIOS_C_OSPEED;
#else
        throw_NotDefinedException(env, "_HAVE_STRUCT_TERMIOS_C_OSPEED");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B0
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B0;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B50
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B50
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B50;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B75
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B75
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B75;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B110
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B110
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B110;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B134
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B134
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B134;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B150
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B150
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B150;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B200
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B200
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B200;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B300
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B300
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B300;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B600
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B600
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B600;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B1200
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B1200
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B1200;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B1800
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B1800
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B1800;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B2400
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B2400
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B2400;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B4800
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B4800
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B4800;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B9600
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B9600
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B9600;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B19200
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B19200
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B19200;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B38400
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B38400
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B38400;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B57600
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B57600
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B57600;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B115200
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B115200
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B115200;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B230400
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B230400
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B230400;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B460800
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B460800
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__FreeBSD__)
        return B460800;
#elif defined(B460800)
#error "B460800 defined"
#else
        throw_NotDefinedException(env, "B460800");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B500000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B500000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return B500000;
#elif defined(B500000)
#error "B500000 defined"
#else
        throw_NotDefinedException(env, "B500000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B576000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B576000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return B576000;
#elif defined(B576000)
#error "B576000 defined"
#else
        throw_NotDefinedException(env, "B576000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B921600
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B921600
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__FreeBSD__)
        return B921600;
#elif defined(B921600)
#error "B921600 defined"
#else
        throw_NotDefinedException(env, "B921600");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B1000000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B1000000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return B1000000;
#elif defined(B1000000)
#error "B1000000 defined"
#else
        throw_NotDefinedException(env, "B1000000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B1152000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B1152000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return B1152000;
#elif defined(B1152000)
#error "B1152000 defined"
#else
        throw_NotDefinedException(env, "B1152000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B1500000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B1500000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return B1500000;
#elif defined(B1500000)
#error "B1500000 defined"
#else
        throw_NotDefinedException(env, "B1500000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B2000000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B2000000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return B2000000;
#elif defined(B2000000)
#error "B2000000 defined"
#else
        throw_NotDefinedException(env, "B2000000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B2500000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B2500000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) && !defined(__sparc__)
        return B2500000;
#elif defined(B2500000)
#error "B2500000 defined"
#else
        throw_NotDefinedException(env, "B2500000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B3000000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B3000000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) && !defined(__sparc__)
        return B3000000;
#elif defined(B3000000)
#error "B3000000 defined"
#else
        throw_NotDefinedException(env, "B3000000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B3500000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B3500000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) && !defined(__sparc__)
        return B3500000;
#elif defined(B3500000)
#error "B3500000 defined"
#else
        throw_NotDefinedException(env, "B3500000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B4000000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B4000000
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) && !defined(__sparc__)
        return B4000000;
#elif defined(B4000000)
#error "B4000000 defined"
#else
        throw_NotDefinedException(env, "B4000000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CLOCAL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CLOCAL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLOCAL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    ECHO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_ECHO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ECHO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    ECHOE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_ECHOE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ECHOE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    ECHOK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_ECHOK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ECHOK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    ECHONL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_ECHONL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ECHONL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    ICANON
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_ICANON
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ICANON;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    IEXTEN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_IEXTEN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return IEXTEN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    ISIG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_ISIG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ISIG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    NOFLSH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_NOFLSH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__APPLE__) || defined (__FreeBSD__) || defined (__OpenBSD__) || (defined(__linux__) && (defined(__powerpc__) || defined(__alpha__)))
        return (int32_t) NOFLSH;
#else
        return NOFLSH;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TOSTOP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TOSTOP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TOSTOP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CMSPAR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CMSPAR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__linux__) && !defined(__mips__)
        return CMSPAR;
#elif defined(CMSPAR)
#error "CMSPAR defined"
#else
        throw_NotDefinedException(env, "CMSPAR");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CREAD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CREAD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CREAD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CRTSCTS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CRTSCTS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (signed)CRTSCTS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CS5
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CS5
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CS5;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CS6
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CS6
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CS6;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CS7
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CS7
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CS7;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CS8
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CS8
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CS8;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CSIZE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CSIZE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CSIZE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CSTOPB
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CSTOPB
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CSTOPB;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    BRKINT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_BRKINT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return BRKINT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    ICRNL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_ICRNL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ICRNL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    IGNBRK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_IGNBRK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return IGNBRK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    IGNCR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_IGNCR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return IGNCR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    IGNPAR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_IGNPAR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return IGNPAR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    INLCR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_INLCR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return INLCR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    INPCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_INPCK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return INPCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    ISTRIP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_ISTRIP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ISTRIP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    IXANY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_IXANY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return IXANY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    IXOFF
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_IXOFF
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return IXOFF;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    IXON
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_IXON
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return IXON;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    PARENB
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_PARENB
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return PARENB;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    PAREXT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_PAREXT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        //placeholder
#if defined(PAREXT)
#error "PAREXT defined"
#else
        throw_NotDefinedException(env, "PAREXT");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    PARMRK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_PARMRK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return PARMRK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    OPOST
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_OPOST
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return OPOST;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    ONLCR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_ONLCR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ONLCR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    OCRNL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_OCRNL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return OCRNL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    ONOCR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_ONOCR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ONOCR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    ONLRET
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_ONLRET
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ONLRET;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    OFDEL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_OFDEL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return OFDEL;
#elif defined(OFDEL)
#error "OFDEL defined"
#else
        throw_NotDefinedException(env, "OFDEL");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    OFILL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_OFILL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return OFILL;
#elif defined(OFILL)
#error "OFILL defined"
#else
        throw_NotDefinedException(env, "OFILL");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    NLDLY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_NLDLY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return NLDLY;
#elif defined(NLDLY)
#error "NLDLY defined"
#else
        throw_NotDefinedException(env, "NLDLY");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    NL0
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_NL0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return NL0;
#elif defined(NL0)
#error "NL0 defined"
#else
        throw_NotDefinedException(env, "NL0");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    NL1
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_NL1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return NL1;
#elif defined(NL1)
#error "NL1 defined"
#else
        throw_NotDefinedException(env, "NL1");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CRDLY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CRDLY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return CRDLY;
#elif defined(CRDLY)
#error "CRDLY defined"
#else
        throw_NotDefinedException(env, "CRDLY");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CR0
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CR0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return CR0;
#elif defined(CR0)
#error "CR0 defined"
#else
        throw_NotDefinedException(env, "CR0");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CR1
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CR1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return CR1;
#elif defined(CR1)
#error "CR1 defined"
#else
        throw_NotDefinedException(env, "CR1");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CR2
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CR2
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return CR2;
#elif defined(CR2)
#error "CR2 defined"
#else
        throw_NotDefinedException(env, "CR2");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CR3
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CR3
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return CR3;
#elif defined(CR3)
#error "CR3 defined"
#else
        throw_NotDefinedException(env, "CR3");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TABDLY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TABDLY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if defined(TABDLY)
#error "TABDLY defined"
#endif
        throw_NotDefinedException(env, "TABDLY");
        return 0;
#else
        return TABDLY;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TAB0
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TAB0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if defined(TAB0)
#error "TAB0 defined"
#endif
        throw_NotDefinedException(env, "TAB0");
        return 0;
#else
        return TAB0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TAB1
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TAB1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return TAB1;
#elif defined(TAB1)
#error "TAB1 defined"
#else
        throw_NotDefinedException(env, "TAB1");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TAB2
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TAB2
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return TAB2;
#elif defined(TAB2)
#error "TAB2 defined"
#else
        throw_NotDefinedException(env, "TAB2");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TAB3
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TAB3
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if defined(TAB3)
#error "TAB3 defined"
#endif
        throw_NotDefinedException(env, "TAB3");
        return 0;
#else
        return TAB3;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    BSDLY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_BSDLY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return BSDLY;
#elif defined(BSDLY)
#error "BSDLY defined"
#else
        throw_NotDefinedException(env, "BSDLY");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    BS0
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_BS0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return BS0;
#elif defined(BS0)
#error "BS0 defined"
#else
        throw_NotDefinedException(env, "BS0");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    BS1
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_BS1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return BS1;
#elif defined(BS1)
#error "BS1 defined"
#else
        throw_NotDefinedException(env, "BS1");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VTDLY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VTDLY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return VTDLY;
#elif defined(VTDLY)
#error "VTDLY defined"
#else
        throw_NotDefinedException(env, "VTDLY");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VT0
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VT0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return VT0;
#elif defined(VT0)
#error "VT0 defined"
#else
        throw_NotDefinedException(env, "VT0");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VT1
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VT1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return VT1;
#elif defined(VT1)
#error "VT1 defined"
#else
        throw_NotDefinedException(env, "VT1");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    FFDLY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_FFDLY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return FFDLY;
#elif defined(FFDLY)
#error "FFDLY defined"
#else
        throw_NotDefinedException(env, "FFDLY");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    FF0
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_FF0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return FF0;
#elif defined(FF0)
#error "FF0 defined"
#else
        throw_NotDefinedException(env, "FF0");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    FF1
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_FF1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__APPLE__)
        return FF1;
#elif defined(FF1)
#error "FF1 defined"
#else
        throw_NotDefinedException(env, "FF1");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    PARODD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_PARODD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return PARODD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    HUPCL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_HUPCL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return HUPCL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TCSANOW
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TCSANOW
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCSANOW;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TCSADRAIN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TCSADRAIN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCSADRAIN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TCSAFLUSH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TCSAFLUSH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCSAFLUSH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TCIFLUSH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TCIFLUSH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCIFLUSH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TCIOFLUSH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TCIOFLUSH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCIOFLUSH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TCOFLUSH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TCOFLUSH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCOFLUSH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TCIOFF
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TCIOFF
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCIOFF;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TCION
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TCION
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCION;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TCOOFF
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TCOOFF
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCOOFF;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TCOON
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TCOON
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCOON;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VEOF
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VEOF
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VEOF;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VEOL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VEOL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VEOL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VERASE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VERASE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VERASE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VINTR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VINTR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VINTR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VKILL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VKILL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VKILL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VMIN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VMIN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VMIN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VQUIT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VQUIT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VQUIT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VSTART
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VSTART
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VSTART;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VSTOP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VSTOP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VSTOP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VSUSP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VSUSP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VSUSP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VTIME
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VTIME
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VTIME;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    NCCS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_NCCS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return NCCS;
    }

#endif
#ifdef __cplusplus
}
#endif
