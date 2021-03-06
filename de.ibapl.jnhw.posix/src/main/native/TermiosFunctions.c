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

    JNHW_ASSERT__speed_t__IS__uint32_t__OR__uint64_t
    JNHW_ASSERT__pid_t__IS__int32_t

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfgetispeed
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Termios_cfgetispeed
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrStructTermios) {
        return (int64_t) cfgetispeed((struct termios*) (uintptr_t) ptrStructTermios);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfgetospeed
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Termios_cfgetospeed
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrStructTermios) {
        return (int64_t) cfgetospeed((struct termios*) (uintptr_t) ptrStructTermios);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfsetispeed
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_cfsetispeed
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrStructTermios, jlong speed) {
#if defined(_JNHW__speed_t__IS__uint32_t)
        if ((uint64_t) speed > UINT32_MAX) {
            throw_IllegalArgumentException(env, "speed outside speed_t(uint32_t)");
            return;
        }
        if (cfsetispeed((struct termios*) (uintptr_t) ptrStructTermios, (uint32_t) speed)) {
            throw_NativeErrorException(env, errno);
        }
#elif defined(_JNHW__speed_t__IS__uint64_t)
        if (cfsetispeed((struct termios*) (uintptr_t) ptrStructTermios, (uint64_t) speed)) {
            throw_NativeErrorException(env, errno);
        }
#else
#error neither _JNHW__speed_t__IS__uint64_t nor _JNHW__speed_t__IS__uint32_t are defined
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfsetospeed
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_cfsetospeed
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrStructTermios, jlong speed) {
#if defined(_JNHW__speed_t__IS__uint32_t)
        if ((uint64_t) speed > UINT32_MAX) {
            throw_IllegalArgumentException(env, "speed outside speed_t(uint32_t)");
            return;
        }
        if (cfsetospeed((struct termios*) (uintptr_t) ptrStructTermios, (uint32_t) speed)) {
            throw_NativeErrorException(env, errno);
        }
#elif defined(_JNHW__speed_t__IS__uint64_t)
        if (cfsetospeed((struct termios*) (uintptr_t) ptrStructTermios, (uint64_t) speed)) {
            throw_NativeErrorException(env, errno);
        }
#else
#error neither _JNHW__speed_t__IS__uint64_t nor _JNHW__speed_t__IS__uint32_t are defined
#endif
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
     * Signature: (IJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_tcgetattr
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fildes, jlong ptrStructTermios) {
        if (tcgetattr(fildes, (struct termios*) (uintptr_t) ptrStructTermios)) {
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
     * Signature: (IIJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_tcsetattr
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fildes, jint optional_actions, jlong ptrStructTermios) {
        if (tcsetattr(fildes, optional_actions, (struct termios*) (uintptr_t) ptrStructTermios)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfsetspeed
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_cfsetspeed
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrStructTermios, jlong speed) {
#if defined(_JNHW__speed_t__IS__uint32_t)
        if ((uint64_t) speed > UINT32_MAX) {
            throw_IllegalArgumentException(env, "speed outside speed_t(uint32_t)");
            return;
        }
        if (cfsetspeed((struct termios*) (uintptr_t) ptrStructTermios, (uint32_t) speed)) {
            throw_NativeErrorException(env, errno);
        }
#elif defined(_JNHW__speed_t__IS__uint64_t)
        if (cfsetspeed((struct termios*) (uintptr_t) ptrStructTermios, (uint64_t) speed)) {
            throw_NativeErrorException(env, errno);
        }
#else
#error neither _JNHW__speed_t__IS__uint64_t nor _JNHW__speed_t__IS__uint32_t are defined
#endif
    }


#endif
#ifdef __cplusplus
}
#endif
