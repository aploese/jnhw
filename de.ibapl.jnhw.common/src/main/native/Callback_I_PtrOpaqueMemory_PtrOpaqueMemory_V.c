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
#include "de_ibapl_jnhw_Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V.h"

#include "jnhw-common.h"

#define MAX_CALL_BACKS 2


#ifdef __cplusplus
extern "C" {
#endif

    static JavaVM *jvm;

    static jclass Callback_Class;
    static jmethodID trampoline_ID;

/*
 * Class:     de_ibapl_jnhw_Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V
 * Method:    initNative
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_Callback_1I_1PtrOpaqueMemory_1PtrOpaqueMemory_1V_initNative
  (JNIEnv *env, jclass clazz) {
        if ((*env)->GetJavaVM(env, &jvm)) {
            return;
        }
        Callback_Class = (*env)->NewGlobalRef(env, clazz);
        if (Callback_Class == NULL) {
            return;
        }
        trampoline_ID = getStaticMethodIdOfClassRef(env, clazz, "trampoline", "(IIJJ)V");
        if (trampoline_ID == NULL) {
            return;
        }
    }

    void trampoline_0(int value, void* ptr_a, void* ptr_b) {
        JNIEnv *env;
        (*jvm)->AttachCurrentThread(jvm, (void**) &env, NULL);
        (*env)->CallStaticVoidMethod(env, Callback_Class, trampoline_ID, 0, value, (intptr_t) ptr_a, (intptr_t) ptr_b);
        (*jvm)->DetachCurrentThread(jvm);
    }

    void trampoline_1(int value, void* ptr_a, void* ptr_b) {
        JNIEnv *env;
        (*jvm)->AttachCurrentThread(jvm, (void**) &env, NULL);
        (*env)->CallStaticVoidMethod(env, Callback_Class, trampoline_ID, 1, value, (intptr_t) ptr_a, (intptr_t) ptr_b);
        (*jvm)->DetachCurrentThread(jvm);
    }

        /*
     * Class:     de_ibapl_jnhw_Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V
     * Method:    MAX_CALL_BACKS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_Callback_1I_1PtrOpaqueMemory_1PtrOpaqueMemory_1V_MAX_1CALL_1BACKS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return MAX_CALL_BACKS;
    }

    /*
     * Class:     de_ibapl_jnhw_Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V
     * Method:    getNativeAddress
     * Signature: (I)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_Callback_1I_1PtrOpaqueMemory_1PtrOpaqueMemory_1V_getNativeAddress
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jint index) {
        switch (index) {
            case 0: return (intptr_t) & trampoline_0;
            case 1: return (intptr_t) & trampoline_1;
            default:
                throw_IllegalArgumentException(env, "index < 0 or index > MAX_CALL_BACKS");
                return 0L;
        }
    }

#ifdef __cplusplus
}
#endif

