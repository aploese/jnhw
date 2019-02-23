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

#if HAVE_UNISTD_H
#include <unistd.h>
#endif

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    HAVE_FCNTL_H
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Fcntl_HAVE_1FCNTL_1H
(JNIEnv *env, jclass clazz) {
#ifdef _POSIX_VERSION
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}


#ifdef _POSIX_VERSION

#include "de_ibapl_jnhw_posix_Fcntl.h"
#include <fcntl.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_RDWR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1RDWR
    (JNIEnv *env, jclass clazz) {
        return O_RDWR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    FNONBLOCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_FNONBLOCK
    (JNIEnv *env, jclass clazz) {
        return FNONBLOCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_NOCTTY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1NOCTTY
    (JNIEnv *env, jclass clazz) {
        return O_NOCTTY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_NONBLOCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1NONBLOCK
    (JNIEnv *env, jclass clazz) {
        return O_NONBLOCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_GETFL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1GETFL
    (JNIEnv *env, jclass clazz) {
        return F_GETFL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_SETFL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1SETFL
    (JNIEnv *env, jclass clazz) {
        return F_SETFL;
    }


#ifdef __cplusplus
}
#endif
#endif