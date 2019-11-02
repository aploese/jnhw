/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
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

#ifdef HAVE_TERMIOS_H

#include "de_ibapl_jnhw_posix_Termios_StructTermios.h"
#include <termios.h>
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    sizeofTermios
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_sizeofTermios
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct termios);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_iflag
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1iflag__
    (JNIEnv *env, jobject structTermios) {
        return (int32_t)(UNWRAP_STRUCT_TERMIOS_PTR(structTermios))->c_iflag;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_iflag
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1iflag__I
    (JNIEnv *env, jobject structTermios, jint value) {
        (UNWRAP_STRUCT_TERMIOS_PTR(structTermios))->c_iflag = (uint32_t)value;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_oflag
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1oflag__
    (JNIEnv *env, jobject structTermios) {
        return (int32_t)(UNWRAP_STRUCT_TERMIOS_PTR(structTermios))->c_oflag;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_oflag
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1oflag__I
    (JNIEnv *env, jobject structTermios, jint value) {
        (UNWRAP_STRUCT_TERMIOS_PTR(structTermios))->c_oflag = (uint32_t)value;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_cflag
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1cflag__
    (JNIEnv *env, jobject structTermios) {
        return (int32_t)(UNWRAP_STRUCT_TERMIOS_PTR(structTermios))->c_cflag;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_cflag
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1cflag__I
    (JNIEnv *env, jobject structTermios, jint value) {
        (UNWRAP_STRUCT_TERMIOS_PTR(structTermios))->c_cflag = (uint32_t)value;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_lflag
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1lflag__
    (JNIEnv *env, jobject structTermios) {
        return (int32_t)(UNWRAP_STRUCT_TERMIOS_PTR(structTermios))->c_lflag;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_lflag
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1lflag__I
    (JNIEnv *env, jobject structTermios, jint value) {
        (UNWRAP_STRUCT_TERMIOS_PTR(structTermios))->c_lflag = (uint32_t)value;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_cc
     * Signature: (I)B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1cc__I
    (JNIEnv *env, jobject structTermios, jint index) {
        if (index < 0) {
            throw_IllegalArgumentException(env, "index must be >= 0");
            return -1;
        }
        return (signed char) (UNWRAP_STRUCT_TERMIOS_PTR(structTermios))->c_cc[index];
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_cc
     * Signature: (IB)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1cc__IB
    (JNIEnv *env, jobject structTermios, jint index, jbyte value) {
        if (index < 0) {
            throw_IllegalArgumentException(env, "index must be >= 0");
            return;
        }
        (UNWRAP_STRUCT_TERMIOS_PTR(structTermios))->c_cc[index] = (unsigned char) value;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_line
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1line__
    (JNIEnv *env, __attribute__ ((unused)) jobject structTermios) {
#ifdef __APPLE__
        throw_NoSuchMethodException(env, "__APPLE__ no such field termios.c_line");
        return -1;
#else
        return (signed char) (UNWRAP_STRUCT_TERMIOS_PTR(structTermios))->c_line;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_line
     * Signature: (B)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1line__B
    (JNIEnv *env, __attribute__ ((unused)) jobject structTermios, __attribute__ ((unused)) jbyte value) {
#ifdef __APPLE__
        throw_NoSuchMethodException(env, "__APPLE__ no such field termios.c_line");
#else
        (UNWRAP_STRUCT_TERMIOS_PTR(structTermios))->c_line = (unsigned char) value;
#endif
    }

/*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_ispeed
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1ispeed__
    (JNIEnv *env, jobject structTermios) {
#if defined(_HAVE_STRUCT_TERMIOS_C_ISPEED) || defined(__APPLE__) || defined(__FreeBSD__) 
        return (int32_t)(UNWRAP_STRUCT_TERMIOS_PTR(structTermios))->c_ispeed;
#else
        throw_NoSuchMethodException(env, "_HAVE_STRUCT_TERMIOS_C_ISPEED || __APPLE__ || __FreeBSD__");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_ispeed
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1ispeed__I
    (JNIEnv *env, jobject structTermios, jint speed) {
#if defined(_HAVE_STRUCT_TERMIOS_C_ISPEED) || defined(__APPLE__) || defined(__FreeBSD__) 
        if (speed < 0) {
            throw_IllegalArgumentException(env, "speed must be >= 0");
            return;
        }
        (UNWRAP_STRUCT_TERMIOS_PTR(structTermios))->c_ispeed = (uint32_t) speed;
#else
        throw_NoSuchMethodException(env, "_HAVE_STRUCT_TERMIOS_C_ISPEED || __APPLE__ || __FreeBSD__");
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_ospeed
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1ospeed__
    (JNIEnv *env, jobject structTermios) {
#if defined(_HAVE_STRUCT_TERMIOS_C_OSPEED) || defined(__APPLE__) || defined(__FreeBSD__) 
        return (int32_t)(UNWRAP_STRUCT_TERMIOS_PTR(structTermios))->c_ospeed;
#else
        throw_NoSuchMethodException(env, "_HAVE_STRUCT_TERMIOS_C_ISPEED || __APPLE__ || __FreeBSD__");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_ospeed
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1ospeed__I
    (JNIEnv *env, jobject structTermios, jint speed) {
#if defined(_HAVE_STRUCT_TERMIOS_C_OSPEED) || defined(__APPLE__) || defined(__FreeBSD__) 
        if (speed < 0) {
            throw_IllegalArgumentException(env, "speed must be >= 0");
            return;
        }
        (UNWRAP_STRUCT_TERMIOS_PTR(structTermios))->c_ospeed = (uint32_t)speed;
#else
        throw_NoSuchMethodException(env, "_HAVE_STRUCT_TERMIOS_C_OSPEED || __APPLE__ || __FreeBSD__");
#endif
    }

#ifdef __cplusplus
}
#endif
#endif