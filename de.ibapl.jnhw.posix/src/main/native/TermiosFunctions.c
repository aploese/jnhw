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
     * Signature: (Lde/ibapl/jnhw/posix/Termios/StructTermios;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_cfgetispeed
    (JNIEnv *env, jclass clazz, jobject structTermios) {
        if (structTermios == NULL) {
            throw_NullPointerException(env, "structTermios");
            return -1;
        }
        return cfgetispeed(UNWRAP_STRUCT_TERMIOS_PTR(structTermios));
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfgetospeed
     * Signature: (Lde/ibapl/jnhw/posix/Termios/StructTermios;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_cfgetospeed
    (JNIEnv *env, jclass clazz, jobject structTermios) {
        if (structTermios == NULL) {
            throw_NullPointerException(env, "structTermios");
            return -1;
        }
        return cfgetospeed(UNWRAP_STRUCT_TERMIOS_PTR(structTermios));
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfsetispeed
     * Signature: (Lde/ibapl/jnhw/posix/Termios/StructTermios;I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_cfsetispeed
    (JNIEnv *env, jclass clazz, jobject structTermios, jint speed) {
        if (structTermios == NULL) {
            throw_NullPointerException(env, "structTermios");
            return -1;
        }
        int result = cfsetispeed(UNWRAP_STRUCT_TERMIOS_PTR(structTermios), speed);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfsetospeed
     * Signature: (Lde/ibapl/jnhw/posix/Termios/StructTermios;I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_cfsetospeed
    (JNIEnv *env, jclass clazz, jobject structTermios, jint speed) {
        if (structTermios == NULL) {
            throw_NullPointerException(env, "structTermios");
            return -1;
        }
        int result = cfsetospeed(UNWRAP_STRUCT_TERMIOS_PTR(structTermios), speed);
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
     * Signature: (ILde/ibapl/jnhw/posix/Termios/StructTermios;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_tcgetattr
    (JNIEnv *env, jclass clazz, jint fildes, jobject structTermios) {
        if (structTermios == NULL) {
            throw_NullPointerException(env, "structTermios");
            return -1;
        }
        int result = tcgetattr(fildes, UNWRAP_STRUCT_TERMIOS_PTR(structTermios));
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
     * Signature: (IILde/ibapl/jnhw/posix/Termios/StructTermios;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_tcsetattr
    (JNIEnv *env, jclass clazz, jint fildes, jint optional_actions, jobject structTermios) {
        if (structTermios == NULL) {
            throw_NullPointerException(env, "structTermios");
            return -1;
        }
        int result = tcsetattr(fildes, optional_actions, UNWRAP_STRUCT_TERMIOS_PTR(structTermios));
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfsetspeed
     * Signature: (Lde/ibapl/jnhw/posix/Termios/StructTermios;I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_cfsetspeed
    (JNIEnv *env, jclass clazz, jobject structTermios, jint speed) {
        if (structTermios == NULL) {
            throw_NullPointerException(env, "structTermios");
            return -1;
        }
        int result = cfsetspeed(UNWRAP_STRUCT_TERMIOS_PTR(structTermios), speed);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

#ifdef __cplusplus
}
#endif
#endif
