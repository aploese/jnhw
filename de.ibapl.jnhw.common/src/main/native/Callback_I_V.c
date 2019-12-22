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
#include "Callback_I_V.h"

#include "de_ibapl_jnhw_Callback_I_V.h"
#include "jnhw-common.h"


#define JNHW_CLASS_NAME_CALL_BACK "de/ibapl/jnhw/Callback_I_V"

#define MAX_CALL_BACKS 2


#ifdef __cplusplus
extern "C" {
#endif

    static JavaVM *jvm;

    static jclass Callback_I_V_Class;
    static jmethodID cb_0_ID;
    static jmethodID cb_1_ID;

    jboolean initCallback_I_V(JNIEnv* env) {
        if ((*env)->GetJavaVM(env, &jvm)) {
            return JNI_FALSE;
        }
        Callback_I_V_Class = getGlobalClassRef(env, JNHW_CLASS_NAME_CALL_BACK);

        cb_0_ID = getStaticMethodIdOfClassRef(env, Callback_I_V_Class, "cb_0", "(I)V");
        if (cb_0_ID == NULL) {
            return JNI_FALSE;
        }
        cb_1_ID = getStaticMethodIdOfClassRef(env, Callback_I_V_Class, "cb_1", "(I)V");
        if (cb_1_ID == NULL) {
            return JNI_FALSE;
        }
        return JNI_TRUE;
    }

    void releaseCallback_I_V(JNIEnv* env) {
        deleteGlobalRef(env, &Callback_I_V_Class);
        cb_0_ID = NULL;
        cb_1_ID = NULL;
    }

    void cb_0(int value) {
        JNIEnv *env;
        (*jvm)->AttachCurrentThread(jvm, (void**) &env, NULL);
        (*env)->CallStaticVoidMethod(env, Callback_I_V_Class, cb_0_ID, value);
        (*jvm)->DetachCurrentThread(jvm);
    }

    void cb_1(int value) {
        JNIEnv *env;
        (*jvm)->AttachCurrentThread(jvm, (void**) &env, NULL);
        (*env)->CallStaticVoidMethod(env, Callback_I_V_Class, cb_1_ID, value);
        (*jvm)->DetachCurrentThread(jvm);
    }

    /*
     * Class:     de_ibapl_jnhw_Callback_I_V
     * Method:    MAX_CALL_BACKS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_Callback_1I_1V_MAX_1CALL_1BACKS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return MAX_CALL_BACKS;
    }

    /*
     * Class:     de_ibapl_jnhw_Callback_I_V
     * Method:    getNativeAddress_0
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_Callback_1I_1V_getNativeAddress_10
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return (intptr_t)&cb_0;
    }

    /*
     * Class:     de_ibapl_jnhw_Callback_I_V
     * Method:    getNativeAddress_1
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_Callback_1I_1V_getNativeAddress_11
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return (intptr_t)&cb_1;
    }

#ifdef __cplusplus
}
#endif

