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
#include "jnhw-common.h"
#include "de_ibapl_jnhw_common_test_callbacks_Callback_I_Mem_Mem_V_Test.h"

#ifdef __cplusplus
extern "C" {
#endif

    typedef void (*_callback)(int32_t, void*, void*);
    static _callback callbackPtr = NULL;

    /*
     * Class:     de_ibapl_jnhw_common_test_callbacks_Callback_I_Mem_Mem_V_Test
     * Method:    getCallbackPtr0
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_test_callbacks_Callback_1I_1Mem_1Mem_1V_1Test_getCallbackPtr0
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return (int64_t) (uintptr_t) (callbackPtr);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_callbacks_Callback_I_Mem_Mem_V_Test
     * Method:    setCallback
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_test_callbacks_Callback_1I_1Mem_1Mem_1V_1Test_setCallback
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz, jlong ptrCallback) {
        callbackPtr = (void (*)(int32_t, void*, void*))(uintptr_t) ptrCallback;
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_callbacks_Callback_I_Mem_Mem_V_Test
     * Method:    doCallTheCallback
     * Signature: (IJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_test_callbacks_Callback_1I_1Mem_1Mem_1V_1Test_doCallTheCallback
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz, jint value, jlong ptrA, jlong ptrB) {
        callbackPtr(value, (void*) (uintptr_t) ptrA, (void*) (uintptr_t) ptrB);
    }


#ifdef __cplusplus
}
#endif

