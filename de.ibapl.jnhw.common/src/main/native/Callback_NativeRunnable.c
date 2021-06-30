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
#define _JNHW_COMMON_IMPLEMENTATION_ 1
#include "de_ibapl_jnhw_common_callback_Callback_NativeRunnable.h"

#include "jnhw-common.h"


#ifdef __cplusplus
extern "C" {
#endif

    static JavaVM *jvm;

    static jmethodID callback_ID;

    /*
     * Class:     de_ibapl_jnhw_common_callback_Callback_NativeRunnable
     * Method:    initNative
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_callback_Callback_1NativeRunnable_initNative
    (JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        if ((*env)->GetJavaVM(env, &jvm)) {
            return;
        }
        jclass NativeRunnable_Class = (*env)->FindClass(env, "de/ibapl/jnhw/common/callback/NativeRunnable");
        if (NativeRunnable_Class == NULL) {
            return;
        }
        callback_ID = (*env)->GetMethodID(env, NativeRunnable_Class, "callback", "()V");
        if (callback_ID == NULL) {
            return;
        }
    }

    void _jnhw_callback_NativeRunnable_V__(void* ptr_a) {
        JNIEnv *env;
        (*jvm)->AttachCurrentThread(jvm, (void**) &env, NULL);
        //Do not check with instanceof for NativeRunnable it may be to slow ...
        (*env)->CallVoidMethod(env, *(jobject*) ptr_a, callback_ID);
        (*jvm)->DetachCurrentThread(jvm);
    }

    /*
     * Class:     de_ibapl_jnhw_common_callback_Callback_NativeRunnable
     * Method:    aquire0
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_callback_Callback_1NativeRunnable_aquire0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int64_t) (uintptr_t) & _jnhw_callback_NativeRunnable_V__;
    }

#ifdef __cplusplus
}
#endif

