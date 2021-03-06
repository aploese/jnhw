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
#include "de_ibapl_jnhw_linux_sys_EventfdTest_NativeDefines.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifndef HAVE_SYS_EVENTFD_H

    /*
     * Class:     de_ibapl_jnhw_linux_sys_EventfdTest_NativeDefines
     * Method:    HAVE_SYS_EVENTFD_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_linux_sys_EventfdTest_00024NativeDefines_HAVE_1SYS_1EVENTFD_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_FALSE;
    }
#else
#include <sys/eventfd.h>

    /*
     * Class:     de_ibapl_jnhw_linux_sys_EventfdTest_NativeDefines
     * Method:    HAVE_SYS_EVENTFD_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_linux_sys_EventfdTest_00024NativeDefines_HAVE_1SYS_1EVENTFD_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_TRUE;
    }

    /*
     * Class:     de_ibapl_jnhw_linux_sys_EventfdTest_NativeDefines
     * Method:    EFD_CLOEXEC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_linux_sys_EventfdTest_00024NativeDefines_EFD_1CLOEXEC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EFD_CLOEXEC;
    }

    /*
     * Class:     de_ibapl_jnhw_linux_sys_EventfdTest_NativeDefines
     * Method:    EFD_NONBLOCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_linux_sys_EventfdTest_00024NativeDefines_EFD_1NONBLOCK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EFD_NONBLOCK;
    }

    /*
     * Class:     de_ibapl_jnhw_linux_sys_EventfdTest_NativeDefines
     * Method:    EFD_SEMAPHORE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_linux_sys_EventfdTest_00024NativeDefines_EFD_1SEMAPHORE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EFD_SEMAPHORE;
    }


#endif

#ifdef __cplusplus
}
#endif

