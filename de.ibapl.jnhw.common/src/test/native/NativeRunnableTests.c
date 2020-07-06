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
#include "de_ibapl_jnhw_NativeRunnableTest.h"

#ifdef __cplusplus
extern "C" {
#endif

    typedef void (*_callback)(void*);
    static _callback callbackPtr = NULL;

    /*
     * Class:     de_ibapl_jnhw_NativeRunnableTest
     * Method:    getCallbackPtr
     * Signature: ()Lde/ibapl/jnhw/NativeFunctionPointer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_NativeRunnableTest_getCallbackPtr
    (JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return CREATE_NATIVE_FUNCTION_POINTER(callbackPtr);
    }

    /*
     * Class:     de_ibapl_jnhw_NativeRunnableTest
     * Method:    setCallback
     * Signature: (Lde/ibapl/jnhw/NativeFunctionPointer;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_NativeRunnableTest_setCallback
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jobject callback) {
        callbackPtr = UNWRAP_NATIVE_FUNCTION_POINTER(callback);
    }

    /*
     * Class:     de_ibapl_jnhw_NativeRunnableTest
     * Method:    doCallTheCallback
     * Signature: (Lde/ibapl/jnhw/NativeRunnable;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_NativeRunnableTest_doCallTheCallback
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz, jobject a) {
        //TODO deattachCurrentThread?
        callbackPtr(UNWRAP_OPAQUE_MEM_TO_VOID_PTR(a));
        //TODO attachCurrentThread?
    }

    /*
     * Class:     de_ibapl_jnhw_NativeRunnableTest
     * Method:    doCallRunnable
     * Signature: (Ljava/lang/Runnable;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_NativeRunnableTest_doCallRunnable
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz, jobject runnable) {
        //TODO deattachCurrentThread?
        callbackPtr(&runnable);
        //TODO attachCurrentThread?
    }

        /*
     * Class:     de_ibapl_jnhw_NativeRunnableTest
     * Method:    doCallTheWrongCallbackPtr
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_NativeRunnableTest_doCallTheWrongCallbackPtr
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        //TODO deattachCurrentThread?
        callbackPtr(&Java_de_ibapl_jnhw_NativeRunnableTest_doCallTheWrongCallbackPtr);
        //TODO attachCurrentThread?
    }


#ifdef __cplusplus
}
#endif

