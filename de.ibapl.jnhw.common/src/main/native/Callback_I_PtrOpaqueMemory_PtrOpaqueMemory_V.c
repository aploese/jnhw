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


#ifdef __cplusplus
extern "C" {
#endif

#define MAX_CALL_BACKS 8

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

#define TRAMPOLINE(index) \
    void _jnhw_trampoline_I_PtrOpaqueMemory_PtrOpaqueMemory_V__ ## index (int value, void* ptr_a, void* ptr_b) { \
        JNIEnv *env; \
        (*jvm)->AttachCurrentThread(jvm, (void**) &env, NULL); \
        (*env)->CallStaticVoidMethod(env, Callback_Class, trampoline_ID, index, value, (intptr_t) ptr_a, (intptr_t) ptr_b); \
        (*jvm)->DetachCurrentThread(jvm); \
    }

    TRAMPOLINE(0)
    TRAMPOLINE(1)
    TRAMPOLINE(2)
    TRAMPOLINE(3)
    TRAMPOLINE(4)
    TRAMPOLINE(5)
    TRAMPOLINE(6)
    TRAMPOLINE(7)

    /*
     * Class:     de_ibapl_jnhw_Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V
     * Method:    getNativeAddress
     * Signature: (I)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_Callback_1I_1PtrOpaqueMemory_1PtrOpaqueMemory_1V_getNativeAddress
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jint index) {
        switch (index) {
#define TRAMPOLINE_CASE(index) case index: return (intptr_t) &_jnhw_trampoline_I_PtrOpaqueMemory_PtrOpaqueMemory_V__ ## index;
                TRAMPOLINE_CASE(0);
                TRAMPOLINE_CASE(1);
                TRAMPOLINE_CASE(2);
                TRAMPOLINE_CASE(3);
                TRAMPOLINE_CASE(4);
                TRAMPOLINE_CASE(5);
                TRAMPOLINE_CASE(6);
                TRAMPOLINE_CASE(7);
            default:
                throw_IllegalArgumentException(env, "index < 0 or index > MAX_CALL_BACKS");
                return 0L;
        }
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

#ifdef __cplusplus
}
#endif

