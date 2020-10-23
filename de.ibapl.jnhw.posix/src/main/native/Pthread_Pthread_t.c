/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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
#include "de_ibapl_jnhw_posix_Pthread_Pthread_t.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION
#include <pthread.h>
//for offsetof
#include <stddef.h>
#include <unistd.h>

/*
     * Class:     de_ibapl_jnhw_posix_Pthread_Pthread_t
     * Method:    sizeofPthread_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Pthread_00024Pthread_1t_sizeofPthread_1t
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (pthread_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread_Pthread_t
     * Method:    toString
     * Signature: ()Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Pthread_00024Pthread_1t_toString
    (JNIEnv *env, jobject pthread) {
        char buf[1024] = {0};
#if defined(__LP64__)
        snprintf(buf, sizeof (buf) - 1, "%ld", (uintptr_t)*UNWRAP_PTHREAD_T_PTR(pthread));
#else
        snprintf(buf, sizeof (buf) - 1, "%d", (uintptr_t)*UNWRAP_PTHREAD_T_PTR(pthread));
#endif
        return (*env)->NewStringUTF(env, buf);
    }

#endif
#ifdef __cplusplus
}
#endif
