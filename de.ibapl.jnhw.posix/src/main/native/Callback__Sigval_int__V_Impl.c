/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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
#include "de_ibapl_jnhw_util_posix_Callback__Sigval_int__V_Impl.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION
#include <signal.h>
#include <stdlib.h>

#define MAX_CALL_BACKS 8

    static JavaVM *jvm;

    static jclass Callback_Class;
    static jmethodID trampoline_ID;

    /*
     * Class:     de_ibapl_jnhw_util_posix_Callback__Sigval_int__V_Impl
     * Method:    initNative
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_util_posix_Callback_1_1Sigval_1int_1_1V_1Impl_initNative
    (JNIEnv *env, jclass clazz) {
        if ((*env)->GetJavaVM(env, &jvm)) {
            return;
        }
        Callback_Class = (*env)->NewGlobalRef(env, clazz);
        if (Callback_Class == NULL) {
            return;
        }
        trampoline_ID = getStaticMethodIdOfClassRef(env, Callback_Class, "trampoline", "(II)V");
        if (trampoline_ID == NULL) {
            return;
        }
    }

#define TRAMPOLINE(index) \
    void _jnhw_trampoline_I_V__ ## index (union sigval value) {\
    JNIEnv *env;\
        if ((*jvm)->AttachCurrentThread(jvm, (void**) &env, NULL)) {\
            abort();\
        } else {\
            if (*env == NULL) {\
                abort();\
                return;\
            }\
            (*env)->CallStaticVoidMethod(env, Callback_Class, trampoline_ID, index, value.sival_int);\
            (*jvm)->DetachCurrentThread(jvm);\
        }\
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
 * Class:     de_ibapl_jnhw_util_posix_Callback__Sigval_int__V_Impl
 * Method:    getNativeAddress
 * Signature: (I)Lde/ibapl/jnhw/NativePointer;
 */
JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_util_posix_Callback_1_1Sigval_1int_1_1V_1Impl_getNativeAddress
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jint index) {
        switch (index) {
#define TRAMPOLINE_CASE(index) case index: return CREATE_NATIVE_ADDRESS_HOLDER(&_jnhw_trampoline_I_V__ ## index);
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
                return NULL;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Callback__Sigval_int__V_Impl
     * Method:    MAX_CALL_BACKS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Callback_1_1Sigval_1int_1_1V_1Impl_MAX_1CALL_1BACKS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return MAX_CALL_BACKS;
    }

#ifdef __cplusplus
}
#endif

#endif