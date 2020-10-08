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
#define _JNHW_COMMON_IMPLEMENTATION_ 1
#include "jnhw-common.h"
#include "de_ibapl_jnhw_Callback_I_PtrOpaquememory_PtrOpaquememory_V_Test.h"

#ifdef __cplusplus
extern "C" {
#endif

    typedef void (*_callback)(int32_t, void*, void*);
    static _callback callbackPtr = NULL;

    /*
     * Class:     de_ibapl_jnhw_Callback_I_PtrOpaquememory_PtrOpaquememory_V_Test
     * Method:    getCallbackPtr
     * Signature: ()Lde/ibapl/jnhw/NativeFunctionPointer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_Callback_1I_1PtrOpaquememory_1PtrOpaquememory_1V_1Test_getCallbackPtr
    (JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return CREATE_NATIVE_FUNCTION_POINTER(callbackPtr);
    }

    /*
     * Class:     de_ibapl_jnhw_Callback_I_PtrOpaquememory_PtrOpaquememory_V_Test
     * Method:    setCallback
     * Signature: (Lde/ibapl/jnhw/NativeFunctionPointer;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_Callback_1I_1PtrOpaquememory_1PtrOpaquememory_1V_1Test_setCallback
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jobject callback) {
        callbackPtr = UNWRAP_NATIVE_FUNCTION_POINTER_TO(void (*)(int32_t, void*, void*), callback);
    }

    /*
     * Class:     de_ibapl_jnhw_Callback_I_PtrOpaquememory_PtrOpaquememory_V_Test
     * Method:    doCallTheCallback
     * Signature: (ILde/ibapl/jnhw/Callback_I_PtrOpaquememory_PtrOpaquememory_V_Test/A;Lde/ibapl/jnhw/Callback_I_PtrOpaquememory_PtrOpaquememory_V_Test/B;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_Callback_1I_1PtrOpaquememory_1PtrOpaquememory_1V_1Test_doCallTheCallback
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz, jint value, jobject a, jobject b) {
        callbackPtr(value, UNWRAP_OPAQUE_MEM_TO_VOID_PTR(a), UNWRAP_OPAQUE_MEM_TO_VOID_PTR(b));
    }


#ifdef __cplusplus
}
#endif

