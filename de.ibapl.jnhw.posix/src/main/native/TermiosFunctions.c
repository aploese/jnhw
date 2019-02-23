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

#include "de_ibapl_jnhw_posix_Termios.h"
#include <termios.h>
#include <errno.h>
#include <stdint.h>


#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfgetispeed
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_cfgetispeed
    (JNIEnv *env, jclass clazz, jlong termiosBaseAddress) {
        return cfgetispeed((void*) (uintptr_t) termiosBaseAddress);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfgetospeed
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_cfgetospeed
    (JNIEnv *env, jclass clazz, jlong termiosBaseAddress) {
        return cfgetospeed((void*) (uintptr_t) termiosBaseAddress);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfsetispeed
     * Signature: (JI)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_cfsetispeed
    (JNIEnv *env, jclass clazz, jlong termiosBaseAddress, jint speed) {
        int result = cfsetispeed((void*) (uintptr_t) termiosBaseAddress, speed);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfsetospeed
     * Signature: (JI)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_cfsetospeed
    (JNIEnv *env, jclass clazz, jlong termiosBaseAddress, jint speed) {
        int result = cfsetospeed((void*) (uintptr_t) termiosBaseAddress, speed);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    tcdrain
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_tcdrain
    (JNIEnv *env, jclass clazz, jint fildes) {
        int result = tcdrain(fildes);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    tcflush
     * Signature: (II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_tcflush
    (JNIEnv *env, jclass clazz, jint fildes, jint queue_selector) {
        int result = tcflush(fildes, queue_selector);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    tcgetattr
     * Signature: (IJ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_tcgetattr
    (JNIEnv *env, jclass clazz, jint fildes, jlong termiosBaseAddress) {
        int result = tcgetattr(fildes, (void*) (uintptr_t) termiosBaseAddress);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    tcsendbreak
     * Signature: (II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_tcsendbreak
    (JNIEnv *env, jclass clazz, jint fildes, jint duration) {
        int result = tcsendbreak(fildes, duration);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    tcsetattr
     * Signature: (IIJ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_tcsetattr
    (JNIEnv *env, jclass clazz, jint fildes, jint optional_actions, jlong termiosBaseAddress) {
        int result = tcsetattr(fildes, optional_actions, (void*) (uintptr_t) termiosBaseAddress);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfsetspeed
     * Signature: (JI)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_cfsetspeed
    (JNIEnv *env, jclass clazz, jlong termiosBaseAddress, jint speed) {
        int result = cfsetspeed((void*) (uintptr_t) termiosBaseAddress, speed);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

#ifdef __cplusplus
}
#endif
#endif
