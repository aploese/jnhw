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
#include "de_ibapl_jnhw_posix_Termios.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION    
#include <termios.h>
#include <errno.h>

JNHW_ASSERT__speed_t__IS__uint32_t
JNHW_ASSERT__pid_t__IS__int32_t

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfgetispeed
     * Signature: (Lde/ibapl/jnhw/posix/Termios/StructTermios;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_cfgetispeed
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject structTermios) {
        if (structTermios == NULL) {
            throw_NullPointerException(env, "structTermios");
            return -1;
        }
        return (int32_t) cfgetispeed(UNWRAP_STRUCT_TERMIOS_PTR(structTermios));
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfgetospeed
     * Signature: (Lde/ibapl/jnhw/posix/Termios/StructTermios;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_cfgetospeed
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject structTermios) {
        if (structTermios == NULL) {
            throw_NullPointerException(env, "structTermios");
            return -1;
        }
        return (int32_t) cfgetospeed(UNWRAP_STRUCT_TERMIOS_PTR(structTermios));
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfsetispeed
     * Signature: (Lde/ibapl/jnhw/posix/Termios/StructTermios;I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_cfsetispeed
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject structTermios, jint speed) {
        if (structTermios == NULL) {
            throw_NullPointerException(env, "structTermios");
            return;
        }
        if (cfsetispeed(UNWRAP_STRUCT_TERMIOS_PTR(structTermios), (uint32_t) speed)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfsetospeed
     * Signature: (Lde/ibapl/jnhw/posix/Termios/StructTermios;I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_cfsetospeed
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject structTermios, jint speed) {
        if (structTermios == NULL) {
            throw_NullPointerException(env, "structTermios");
            return;
        }
        if (cfsetospeed(UNWRAP_STRUCT_TERMIOS_PTR(structTermios), (uint32_t) speed)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    tcdrain
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_tcdrain
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fildes) {
        if (tcdrain(fildes)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    tcflow
     * Signature: (II)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_tcflow
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fildes, jint action) {
        if (tcflow(fildes, action)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    tcflush
     * Signature: (II)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_tcflush
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fildes, jint queue_selector) {
        if (tcflush(fildes, queue_selector)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    tcgetattr
     * Signature: (ILde/ibapl/jnhw/posix/Termios/StructTermios;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_tcgetattr
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fildes, jobject structTermios) {
        if (structTermios == NULL) {
            throw_NullPointerException(env, "structTermios");
            return;
        }
        if (tcgetattr(fildes, UNWRAP_STRUCT_TERMIOS_PTR(structTermios))) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    tcgetsid
     * Signature: (II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_tcgetsid
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fildes) {
        const pid_t result = tcgetsid(fildes);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    tcsendbreak
     * Signature: (II)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_tcsendbreak
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fildes, jint duration) {
        if (tcsendbreak(fildes, duration)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    tcsetattr
     * Signature: (IILde/ibapl/jnhw/posix/Termios/StructTermios;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_tcsetattr
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fildes, jint optional_actions, jobject structTermios) {
        if (structTermios == NULL) {
            throw_NullPointerException(env, "structTermios");
            return;
        }
        if (tcsetattr(fildes, optional_actions, UNWRAP_STRUCT_TERMIOS_PTR(structTermios))) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfsetspeed
     * Signature: (Lde/ibapl/jnhw/posix/Termios/StructTermios;I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_cfsetspeed
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject structTermios, jint speed) {
        if (structTermios == NULL) {
            throw_NullPointerException(env, "structTermios");
            return;
        }
        if (cfsetspeed(UNWRAP_STRUCT_TERMIOS_PTR(structTermios), (uint32_t) speed)) {
            throw_NativeErrorException(env, errno);
        }
    }


#endif
#ifdef __cplusplus
}
#endif
