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
#include "de_ibapl_jnhw_posix_TermiosTest_NativeStructTermios.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION
#include <termios.h>

    //for offsetof
#include <stddef.h>

    JNHW_ASSERT__tcflag_t__IS__uint32_t
    JNHW_ASSERT__cc_t__IS__uint8_t

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeStructTermios
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeStructTermios_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct termios);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeStructTermios
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeStructTermios_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct termios);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeStructTermios
     * Method:    c_iflag
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeStructTermios_c_1iflag
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct termios, c_iflag);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeStructTermios
     * Method:    c_oflag
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeStructTermios_c_1oflag
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct termios, c_oflag);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeStructTermios
     * Method:    c_cflag
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeStructTermios_c_1cflag
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct termios, c_cflag);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeStructTermios
     * Method:    c_lflag
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeStructTermios_c_1lflag
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct termios, c_lflag);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeStructTermios
     * Method:    c_cc
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeStructTermios_c_1cc
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct termios, c_cc);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeStructTermios
     * Method:    c_line
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeStructTermios_c_1line
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__FreeBSD__)
        return -1;
#else
        return offsetof(struct termios, c_line);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeStructTermios
     * Method:    c_ispeed
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeStructTermios_c_1ispeed
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if (defined(_HAVE_STRUCT_TERMIOS_C_ISPEED) && _HAVE_STRUCT_TERMIOS_C_ISPEED != 0) || defined(__APPLE__) || defined(__FreeBSD__)
        return offsetof(struct termios, c_ispeed);
#else
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TermiosTest_NativeStructTermios
     * Method:    c_ospeed
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TermiosTest_00024NativeStructTermios_c_1ospeed
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if (defined(_HAVE_STRUCT_TERMIOS_C_OSPEED) && _HAVE_STRUCT_TERMIOS_C_OSPEED != 0) || defined(__APPLE__) || defined(__FreeBSD__)
        return offsetof(struct termios, c_ospeed);
#else
        return -1;
#endif
    }

#endif
#ifdef __cplusplus
}
#endif
