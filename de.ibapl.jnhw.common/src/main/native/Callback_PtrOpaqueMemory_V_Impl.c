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
#include "de_ibapl_jnhw_Callback_PtrOpaqueMemory_V_Impl.h"

#include "jnhw-common.h"


#ifdef __cplusplus
extern "C" {
#endif

#define MAX_CALL_BACKS 32

    static JavaVM *jvm;

    static jclass Callback_Class;
    static jmethodID trampoline_ID;

    /*
     * Class:     de_ibapl_jnhw_Callback_PtrOpaqueMemory_V_Impl
     * Method:    initNative
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_Callback_1PtrOpaqueMemory_1V_1Impl_initNative
    (JNIEnv *env, jclass clazz) {
        if ((*env)->GetJavaVM(env, &jvm)) {
            return;
        }
        Callback_Class = (*env)->NewGlobalRef(env, clazz);
        if (Callback_Class == NULL) {
            return;
        }
        trampoline_ID = getStaticMethodIdOfClassRef(env, clazz, "trampoline", "(IJ)V");
        if (trampoline_ID == NULL) {
            return;
        }
    }

#define TRAMPOLINE(index) \
    void _jnhw_trampoline_PtrOpaqueMemory_V__ ## index (void* ptr_a) { \
        JNIEnv *env; \
        (*jvm)->AttachCurrentThread(jvm, (void**) &env, NULL); \
        (*env)->CallStaticVoidMethod(env, Callback_Class, trampoline_ID, index, (intptr_t) ptr_a); \
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
    TRAMPOLINE(8)
    TRAMPOLINE(9)
    TRAMPOLINE(10)
    TRAMPOLINE(11)
    TRAMPOLINE(12)
    TRAMPOLINE(13)
    TRAMPOLINE(14)
    TRAMPOLINE(15)
    TRAMPOLINE(16)
    TRAMPOLINE(17)
    TRAMPOLINE(18)
    TRAMPOLINE(19)
    TRAMPOLINE(20)
    TRAMPOLINE(21)
    TRAMPOLINE(22)
    TRAMPOLINE(23)
    TRAMPOLINE(24)
    TRAMPOLINE(25)
    TRAMPOLINE(26)
    TRAMPOLINE(27)
    TRAMPOLINE(28)
    TRAMPOLINE(29)
    TRAMPOLINE(30)
    TRAMPOLINE(31)

    /*
     * Class:     de_ibapl_jnhw_Callback_PtrOpaqueMemory_V_Impl
     * Method:    getNativeAddress
     * Signature: (I)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_Callback_1PtrOpaqueMemory_1V_1Impl_getNativeAddress
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jint index) {
        switch (index) {
#define TRAMPOLINE_CASE(index) case index: return (intptr_t) &_jnhw_trampoline_PtrOpaqueMemory_V__ ## index;
                TRAMPOLINE_CASE(0);
                TRAMPOLINE_CASE(1);
                TRAMPOLINE_CASE(2);
                TRAMPOLINE_CASE(3);
                TRAMPOLINE_CASE(4);
                TRAMPOLINE_CASE(5);
                TRAMPOLINE_CASE(6);
                TRAMPOLINE_CASE(7);
                TRAMPOLINE_CASE(8);
                TRAMPOLINE_CASE(9);
                TRAMPOLINE_CASE(10);
                TRAMPOLINE_CASE(11);
                TRAMPOLINE_CASE(12);
                TRAMPOLINE_CASE(13);
                TRAMPOLINE_CASE(14);
                TRAMPOLINE_CASE(15);
                TRAMPOLINE_CASE(16);
                TRAMPOLINE_CASE(17);
                TRAMPOLINE_CASE(18);
                TRAMPOLINE_CASE(19);
                TRAMPOLINE_CASE(20);
                TRAMPOLINE_CASE(21);
                TRAMPOLINE_CASE(22);
                TRAMPOLINE_CASE(23);
                TRAMPOLINE_CASE(24);
                TRAMPOLINE_CASE(25);
                TRAMPOLINE_CASE(26);
                TRAMPOLINE_CASE(27);
                TRAMPOLINE_CASE(28);
                TRAMPOLINE_CASE(29);
                TRAMPOLINE_CASE(30);
                TRAMPOLINE_CASE(31);
            default:
                throw_IllegalArgumentException(env, "index < 0 or index > MAX_CALL_BACKS");
                return 0L;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_Callback_PtrOpaqueMemory_V_Impl
     * Method:    MAX_CALL_BACKS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_Callback_1PtrOpaqueMemory_1V_1Impl_MAX_1CALL_1BACKS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return MAX_CALL_BACKS;
    }

#ifdef __cplusplus
}
#endif

