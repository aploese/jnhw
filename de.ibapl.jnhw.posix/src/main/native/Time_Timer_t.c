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
#include "de_ibapl_jnhw_posix_Time_Timer_t.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION
#include <time.h>
//for offsetof
#include <stddef.h>
#include <unistd.h>
#include <stdint.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Timer_t
     * Method:    sizeofTimer_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_00024Timer_1t_sizeofTimer_1t
#if defined(__APPLE__) 
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        throw_NoSuchNativeTypeException(env, "timer_t");
        return -1;
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (timer_t);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Timer_t
     * Method:    toString
     * Signature: ()Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_00024Timer_1t_toString
#if defined(__APPLE__) 
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        throw_Exception(env, RUNTIME_EXCEPTION_CLASS_NAME, "No such typedef timer_t");
        return NULL;
#else
    (JNIEnv *env, jobject timer) {
        char buf[1024] = {0};
#if __SIZEOF_LONG__ == 8
        snprintf(buf, sizeof (buf) - 1, "0x%016lx", (uintptr_t) *UNWRAP_TIMER_T_PTR(timer));
#elif __SIZEOF_LONG__ == 4
        snprintf(buf, sizeof (buf) - 1, "0x%08x", (uintptr_t) *UNWRAP_TIMER_T_PTR(timer));
#else
#error Unknown Wordsize
#endif
        return (*env)->NewStringUTF(env, buf);
#endif
    }

#endif
#ifdef __cplusplus
}
#endif
