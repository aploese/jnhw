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

/*
 * Class:     de_ibapl_jnhw_unix_sys_Ioctl
 * Method:    HAVE_SYS_IOCTL_H
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_HAVE_1SYS_1IOCTL_1H
(__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef HAVE_SYS_IOCTL_H
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}


#ifdef HAVE_SYS_IOCTL_H

#include "de_ibapl_jnhw_unix_sys_Ioctl.h"
#include <sys/ioctl.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    FIONREAD
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_FIONREAD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FIONREAD;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    TIOCM_CTS
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCM_1CTS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCM_CTS;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    TIOCM_DTR
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCM_1DTR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCM_DTR;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    TIOCM_CAR
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCM_1CAR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCM_CAR;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    TIOCM_RTS
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCM_1RTS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCM_RTS;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    TIOCM_RNG
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCM_1RNG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCM_RNG;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    TIOCM_DSR
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCM_1DSR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCM_DSR;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    TIOCEXCL
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCEXCL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCEXCL;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    TIOCSBRK
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCSBRK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCSBRK;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    TIOCCBRK
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCCBRK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCCBRK;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    TIOCMGET
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCMGET
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCMGET;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    TIOCMSET
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCMSET
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCMSET;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    TIOCOUTQ
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCOUTQ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCOUTQ;
    }

#ifdef __cplusplus
}
#endif
#endif