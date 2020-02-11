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

#ifdef HAVE_TIME_H

#include <time.h>
//for offsetof
#include <stddef.h>
#include <unistd.h>
#include <stdint.h>

#ifdef __cplusplus
extern "C" {
#endif

/*
     * Class:     de_ibapl_jnhw_posix_Time_Timer_t
     * Method:    sizeofTimer_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_00024Timer_1t_sizeofTimer_1t
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (time_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Timer_t
     * Method:    toString
     * Signature: ()Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_00024Timer_1t_toString
    (JNIEnv *env, jobject timer) {
        char buf[1024] = {0};
        snprintf(buf, sizeof (buf) - 1, "%ld", (long) *UNWRAP_TIMER_T_PTR(timer));
        return (*env)->NewStringUTF(env, buf);
    }

#ifdef __cplusplus
}
#endif
#endif