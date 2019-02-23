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
#include "../../../config.h"
#include "jnhw.h"

#ifdef HAVE_TERMIOS_H

#include "de_ibapl_jnhw_posix_Termios_StructTermios.h"
#include <termios.h>
#include <errno.h>
#include <stdint.h>


#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    sizeofTermios
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_sizeofTermios
    (JNIEnv *env, jclass clazz) {
        return sizeof (struct termios);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_iflag
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1iflag__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((struct termios*) (uintptr_t) baseAddress)->c_iflag;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_iflag
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1iflag__JI
    (JNIEnv *env, jclass clazz, jlong baseAddress, jint value) {
        ((struct termios*) (uintptr_t) baseAddress)->c_iflag = value;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_oflag
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1oflag__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((struct termios*) (uintptr_t) baseAddress)->c_oflag;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_oflag
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1oflag__JI
    (JNIEnv *env, jclass clazz, jlong baseAddress, jint value) {
        ((struct termios*) (uintptr_t) baseAddress)->c_oflag = value;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_cflag
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1cflag__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((struct termios*) (uintptr_t) baseAddress)->c_cflag;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_cflag
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1cflag__JI
    (JNIEnv *env, jclass clazz, jlong baseAddress, jint value) {
        ((struct termios*) (uintptr_t) baseAddress)->c_cflag = value;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_lflag
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1lflag__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((struct termios*) (uintptr_t) baseAddress)->c_lflag;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_lflag
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1lflag__JI
    (JNIEnv *env, jclass clazz, jlong baseAddress, jint value) {
        ((struct termios*) (uintptr_t) baseAddress)->c_lflag = value;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_cc
     * Signature: (JI)B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1cc__JI
    (JNIEnv *env, jclass clazz, jlong baseAddress, jint index) {
        return ((struct termios*) (uintptr_t) baseAddress)->c_cc[index];
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    c_cc
     * Signature: (JIB)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1cc__JIB
    (JNIEnv *env, jclass clazz, jlong baseAddress, jint index, jbyte value) {
        ((struct termios*) (uintptr_t) baseAddress)->c_cc[index] = value;
    }

#ifdef __cplusplus
}
#endif
#endif
