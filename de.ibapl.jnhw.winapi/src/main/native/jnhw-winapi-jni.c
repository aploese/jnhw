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
#include "../../../config.h"
#include "jnhw-winapi.h"

#ifdef __cplusplus
extern "C" {
#endif
    jclass dij_w_Winnt_HANDLE__GCR = NULL;
    jfieldID dij_w_Winnt_HANDLE_value__FID = NULL;
    jmethodID dij_w_Winnt_HANDLE_init__MID = NULL;
    jfieldID dij_w_Winnt_LPWSTR_bufferEnd__FID = NULL;
    jfieldID dij_w_WinDef_LPBYTE_bufferEnd__FID = NULL;

    JNIEXPORT jint JNICALL
    JNI_OnLoad(JavaVM *jvm, __attribute__ ((unused)) void *reserved) {
        JNIEnv *env;
        if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_10)) {
            return JNI_ERR;
        }

        if (dij_w_Winnt_LPWSTR_bufferEnd__FID == NULL) {
            dij_w_Winnt_LPWSTR_bufferEnd__FID = getFieldId(env, dij_w_LPWSTR__CName, "bufferEnd", "I");
            if (dij_w_Winnt_LPWSTR_bufferEnd__FID == NULL) {
                return JNI_ERR;
            }
        }

        if (dij_w_WinDef_LPBYTE_bufferEnd__FID == NULL) {
            dij_w_WinDef_LPBYTE_bufferEnd__FID = getFieldId(env, dij_w_LPBYTE__CName, "bufferEnd", "I");
            if (dij_w_WinDef_LPBYTE_bufferEnd__FID == NULL) {
                return JNI_ERR;
            }
        }

        if (dij_w_Winnt_HANDLE__GCR == NULL) {
            dij_w_Winnt_HANDLE__GCR = getGlobalClassRef(env, dij_w_HANDLE__CName);
            if (dij_w_Winnt_HANDLE__GCR == NULL) {
                return JNI_ERR;
            }
        }

        if (dij_w_Winnt_HANDLE_value__FID == NULL) {
            dij_w_Winnt_HANDLE_value__FID = (*env)->GetFieldID(env, dij_w_Winnt_HANDLE__GCR, "value", "J");
            if (dij_w_Winnt_HANDLE_value__FID == NULL) {
                return JNI_ERR;
            }
        }

        if (dij_w_Winnt_HANDLE_init__MID == NULL) {
            dij_w_Winnt_HANDLE_init__MID = (*env)->GetMethodID(env, dij_w_Winnt_HANDLE__GCR, "<init>", "(J)V");
            if (dij_w_Winnt_HANDLE_init__MID == NULL) {
                return JNI_ERR;
            }
        }

        return JNI_VERSION_10;
    }

    JNIEXPORT void JNICALL
    JNI_OnUnload(JavaVM *jvm, __attribute__ ((unused)) void *reserved) {
        JNIEnv *env;

        if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_10)) {
            deleteGlobalRef(env, &dij_w_Winnt_HANDLE__GCR);
            dij_w_Winnt_HANDLE_value__FID = NULL;
            dij_w_Winnt_HANDLE_init__MID = NULL;
            dij_w_Winnt_LPWSTR_bufferEnd__FID = NULL;
            dij_w_WinDef_LPBYTE_bufferEnd__FID = NULL;
        }
    }


#ifdef __cplusplus
}
#endif
