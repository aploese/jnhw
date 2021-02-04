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

#ifdef __cplusplus
extern "C" {
#endif
#if _POSIX_C_SOURCE

    jclass dij_p_Locale_Locale_t__GCR = NULL;
    jfieldID dij_p_Locale_Locale_t_nativeValue__FID = NULL;
    jmethodID dij_p_Locale_Locale_t_init__MID = NULL;

    jclass dij_p_Time_Tm__GCR = NULL;
    jmethodID dij_p_Time_Tm_init__MID = NULL;
#endif

    JNIEXPORT jint JNICALL
    JNI_OnLoad(JavaVM *jvm, __attribute__ ((unused)) void *reserved) {
        JNIEnv *env;
        if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_10)) {
            return JNI_ERR;
        }
#if _POSIX_C_SOURCE

        if (dij_p_Locale_Locale_t__GCR == NULL) {
            dij_p_Locale_Locale_t__GCR = getGlobalClassRef(env, dij_p_Locale_t_CName);
            if (dij_p_Locale_Locale_t__GCR == NULL) {
                return JNI_ERR;
            }
            dij_p_Locale_Locale_t_nativeValue__FID = (*env)->GetFieldID(env, dij_p_Locale_Locale_t__GCR, "nativeValue", "J");
            if (dij_p_Locale_Locale_t_nativeValue__FID == NULL) {
                return JNI_ERR;
            }
            dij_p_Locale_Locale_t_init__MID = (*env)->GetMethodID(env, dij_p_Locale_Locale_t__GCR, "<init>", "(J)V");
            if (dij_p_Locale_Locale_t_init__MID == NULL) {
                return JNI_ERR;
            }
        }

        if (dij_p_Time_Tm__GCR == NULL) {
            dij_p_Time_Tm__GCR = getGlobalClassRef(env, dij_p_Time_Tm_CName);
            if (dij_p_Time_Tm__GCR == NULL) {
                return JNI_ERR;
            }
            dij_p_Time_Tm_init__MID = (*env)->GetMethodID(env, dij_p_Time_Tm__GCR, "<init>", "(Lde/ibapl/jnhw/common/memory/NativeAddressHolder;I)V");
            if (dij_p_Time_Tm_init__MID == NULL) {
                return JNI_ERR;
            }
        }
#endif
        return JNI_VERSION_10;
    }

    JNIEXPORT void JNICALL
    JNI_OnUnload(JavaVM *jvm, __attribute__ ((unused)) void *reserved) {
        JNIEnv *env;

        if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_10)) {
#if _POSIX_C_SOURCE
            deleteGlobalRef(env, &dij_p_Locale_Locale_t__GCR);
            dij_p_Locale_Locale_t__GCR = NULL;
            dij_p_Locale_Locale_t_nativeValue__FID = NULL;
            dij_p_Locale_Locale_t_init__MID = NULL;

            deleteGlobalRef(env, &dij_p_Time_Tm__GCR);
            dij_p_Time_Tm__GCR = NULL;
            dij_p_Time_Tm_init__MID = NULL;
#endif
        }

    }
#ifdef __cplusplus
}
#endif