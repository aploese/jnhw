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
    jclass de_ibapl_jnhw_winapi_Winnt_HANDLE_Class = NULL;
    jfieldID de_ibapl_jnhw_winapi_Winnt_HANDLE_value_ID = NULL;
    jmethodID de_ibapl_jnhw_winapi_Winnt_HANDLE_init_ID = NULL;
    jfieldID de_ibapl_jnhw_winapi_Winnt_LPWSTR_bufferEnd_ID = NULL;
    jfieldID de_ibapl_jnhw_winapi_WinDef_LPBYTE_bufferEnd_ID = NULL;

    JNIEXPORT jint JNICALL
    JNI_OnLoad(JavaVM *jvm, __attribute__ ((unused)) void *reserved) {
        JNIEnv *env;
        if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_10)) {
            return JNI_ERR;
        }

        if (de_ibapl_jnhw_winapi_Winnt_LPWSTR_bufferEnd_ID == NULL) {
            de_ibapl_jnhw_winapi_Winnt_LPWSTR_bufferEnd_ID = getFieldId(env, JNHW_CLASS_NAME_LPWSTR, "bufferEnd", "I");
            if (de_ibapl_jnhw_winapi_Winnt_LPWSTR_bufferEnd_ID == NULL) {
                return JNI_ERR;
            }
        }

        if (de_ibapl_jnhw_winapi_WinDef_LPBYTE_bufferEnd_ID == NULL) {
            de_ibapl_jnhw_winapi_WinDef_LPBYTE_bufferEnd_ID = getFieldId(env, JNHW_CLASS_NAME_LPBYTE, "bufferEnd", "I");
            if (de_ibapl_jnhw_winapi_WinDef_LPBYTE_bufferEnd_ID == NULL) {
                return JNI_ERR;
            }
        }

        if (de_ibapl_jnhw_winapi_Winnt_HANDLE_Class == NULL) {
            de_ibapl_jnhw_winapi_Winnt_HANDLE_Class = getGlobalClassRef(env, JNHW_CLASS_NAME_HANDLE);
            if (de_ibapl_jnhw_winapi_Winnt_HANDLE_Class == NULL) {
                return JNI_ERR;
            }
        }

        if (de_ibapl_jnhw_winapi_Winnt_HANDLE_value_ID == NULL) {
            de_ibapl_jnhw_winapi_Winnt_HANDLE_value_ID = getFieldIdOfClassRef(env, de_ibapl_jnhw_winapi_Winnt_HANDLE_Class, "value", "J");
            if (de_ibapl_jnhw_winapi_Winnt_HANDLE_value_ID == NULL) {
                return JNI_ERR;
            }
        }

        if (de_ibapl_jnhw_winapi_Winnt_HANDLE_init_ID == NULL) {
            de_ibapl_jnhw_winapi_Winnt_HANDLE_init_ID = getMethodIdOfClassRef(env, de_ibapl_jnhw_winapi_Winnt_HANDLE_Class, "<init>", "(J)V");
            if (de_ibapl_jnhw_winapi_Winnt_HANDLE_init_ID == NULL) {
                return JNI_ERR;
            }
        }

        return JNI_VERSION_10;
    }

    JNIEXPORT void JNICALL
    JNI_OnUnload(JavaVM *jvm, __attribute__ ((unused)) void *reserved) {
        JNIEnv *env;

        if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_10)) {
            deleteGlobalRef(env, &de_ibapl_jnhw_winapi_Winnt_HANDLE_Class);
            de_ibapl_jnhw_winapi_Winnt_HANDLE_value_ID = NULL;
            de_ibapl_jnhw_winapi_Winnt_HANDLE_init_ID = NULL;
            de_ibapl_jnhw_winapi_Winnt_LPWSTR_bufferEnd_ID = NULL;
            de_ibapl_jnhw_winapi_WinDef_LPBYTE_bufferEnd_ID = NULL;
        }
    }


#ifdef __cplusplus
}
#endif
