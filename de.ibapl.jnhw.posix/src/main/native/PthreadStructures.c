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
#include "de_ibapl_jnhw_posix_Pthread_Pthread_attr_t.h"
#include "de_ibapl_jnhw_posix_Pthread_Pthread_t.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION
#include <pthread.h>
#include <unistd.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread_Pthread_attr_t
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/posix/Pthread/Pthread_attr_t/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Pthread_00024Pthread_1attr_1t_native2Layout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (pthread_attr_t), __alignof__ (pthread_attr_t));
        if (result == NULL) {
            return NULL;
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread_Pthread_t
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/posix/Pthread/Pthread_t/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Pthread_00024Pthread_1t_native2Layout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (pthread_t), __alignof__ (pthread_t));
        if (result == NULL) {
            return NULL;
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread_Pthread_t
     * Method:    nativeToString
     * Signature: ()Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Pthread_00024Pthread_1t_nativeToString
    (JNIEnv *env, jobject pthread) {
        char buf[1024] = {0};
        static_assert(sizeof (pthread_t) == sizeof (uintptr_t), "sizeof(pthread_t) != sizeof(uintptr_t)");
#if defined(__LP64__)
        snprintf(buf, sizeof (buf) - 1, "0x%016lx", (uintptr_t) * UNWRAP_PTHREAD_T_PTR(pthread));
#else
        snprintf(buf, sizeof (buf) - 1, "0x%08x", (uintptr_t) * UNWRAP_PTHREAD_T_PTR(pthread));
#endif
        return (*env)->NewStringUTF(env, buf);
    }


#endif
#ifdef __cplusplus
}
#endif
