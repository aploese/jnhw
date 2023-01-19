/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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
#include "jnhw-common.h"
#include "de_ibapl_jnhw_common_upcall_jni_JniCallbackFactory__V___I__I_MA.h"

#include <stdlib.h>

#ifdef __cplusplus
extern "C" {
#endif

#define MAX_CALL_BACKS 16

#if defined(__LP64__)
 #define MSG_UNASSIGNED "From C code: unassigned Callback__V___I__I_MA %d @0x%08lx no upcall handle!\n"
 #define MSG_ATTACH_THREAD_FAILED "From C code: Callback__V___I__I_MA %d @0x%08lx can't attach to thread!\n"
 #define MSG_NO_UPCALL "From C code: Callback__V___I__I_MA %d @0x%08lx can't get env!\n"
#elif defined(__WIN64__)
 #define MSG_UNASSIGNED "From C code: unassigned Callback__V___I__I_MA %d @0x%08Lx no upcall handle!\n"
 #define MSG_ATTACH_THREAD_FAILED "From C code: Callback__V___I__I_MA %d @0x%08Lx can't attach to thread!\n"
 #define MSG_NO_UPCALL "From C code: Callback__V___I__I_MA %d @0x%08Lx can't get env!\n"
#else 
 #define MSG_UNASSIGNED "From C code: unassigned Callback__V___I__I_MA %d @0x%04x no upcall handle!\n"
 #define MSG_ATTACH_THREAD_FAILED "From C code: Callback__V___I__I_MA %d @0x%04x can't attach to thread!\n"
 #define MSG_NO_UPCALL "From C code: Callback__V___I__I_MA %d @0x%04x can't get env!\n"
#endif 

#define TRAMPOLINE(index) \
    static struct cb_refs callback_refs_ ## index; \
    void _jnhw_trampoline__V___I__I_MA__ ## index (int32_t a, int32_t b, void* c) {\
        struct  cb_refs callback_refs = callback_refs_ ## index; \
        if ((callback_refs.callbackClassRef == NULL) || (callback_refs.trampolineMethodID == 0)) { \
            jnhw_log_stderr(MSG_UNASSIGNED, index, (uintptr_t)&_jnhw_trampoline__V___I__I_MA__ ## index); \
            return; \
        } \
        JNIEnv *env;\
        if ((*common_jvm)->AttachCurrentThread(common_jvm, (void**) &env, NULL)) {\
            jnhw_log_stderr(MSG_ATTACH_THREAD_FAILED, index, (uintptr_t)&_jnhw_trampoline__V___I__I_MA__ ## index); \
            return;\
        } else {\
            if (*env == NULL) {\
            jnhw_log_stderr(MSG_NO_UPCALL, index, (uintptr_t)&_jnhw_trampoline__V___I__I_MA__ ## index); \
                return;\
            }\
            (*env)->CallStaticVoidMethod(env, callback_refs.callbackClassRef, callback_refs.trampolineMethodID, a, b, (int64_t)(uintptr_t)c);\
            (*common_jvm)->DetachCurrentThread(common_jvm);\
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
TRAMPOLINE(8)
TRAMPOLINE(9)
TRAMPOLINE(10)
TRAMPOLINE(11)
TRAMPOLINE(12)
TRAMPOLINE(13)
TRAMPOLINE(14)
TRAMPOLINE(15)

    /*
     * Class:     de_ibapl_jnhw_common_upcall_jni_JniCallbackFactory__V___I__I_MA
     * Method:    registerCallBack
     * Signature: (ILjava/lang/Class;Ljava/lang/String;)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_upcall_jni_JniCallbackFactory_1_1V_1_1_1I_1_1I_1MA_registerCallBack
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint index, jclass callbackClass, jstring callBackMethodName) {
        const jclass callbackClassRef = (*env)->NewWeakGlobalRef(env, callbackClass);
        if (callbackClassRef == NULL) {
            return (int64_t)(uintptr_t)NULL;
        }
        const char* _callBackMethodName = (*env)->GetStringUTFChars(env, callBackMethodName, NULL);
        const jmethodID trampolineMethodID = (*env)->GetStaticMethodID(env, callbackClassRef, _callBackMethodName , "(IIJ)V");
        (*env)->ReleaseStringUTFChars(env, callBackMethodName, _callBackMethodName);
        if (trampolineMethodID == NULL) {
            return (int64_t)(uintptr_t)NULL;
        }
        switch (index) {

#define TRAMPOLINE_REGISTER_CASE(index) case index: \
                (*env)->DeleteWeakGlobalRef(env, callback_refs_ ## index .callbackClassRef);\
                callback_refs_ ## index .callbackClassRef = callbackClassRef; \
                callback_refs_ ## index .trampolineMethodID = trampolineMethodID; \
                return (int64_t)(uintptr_t)&_jnhw_trampoline__V___I__I_MA__ ## index;
                
                //create the 16 trampoline cases
                TRAMPOLINE_REGISTER_CASE(0)
                TRAMPOLINE_REGISTER_CASE(1)
                TRAMPOLINE_REGISTER_CASE(2)
                TRAMPOLINE_REGISTER_CASE(3)
                TRAMPOLINE_REGISTER_CASE(4)
                TRAMPOLINE_REGISTER_CASE(5)
                TRAMPOLINE_REGISTER_CASE(6)
                TRAMPOLINE_REGISTER_CASE(7)
                TRAMPOLINE_REGISTER_CASE(8)
                TRAMPOLINE_REGISTER_CASE(9)
                TRAMPOLINE_REGISTER_CASE(10)
                TRAMPOLINE_REGISTER_CASE(11)
                TRAMPOLINE_REGISTER_CASE(12)
                TRAMPOLINE_REGISTER_CASE(13)
                TRAMPOLINE_REGISTER_CASE(14)
                TRAMPOLINE_REGISTER_CASE(15)
            default:
                return (int64_t) (uintptr_t) NULL;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_common_upcall_jni_JniCallbackFactory__V___I__I_MA
     * Method:    releaseCallBack
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_upcall_jni_JniCallbackFactory_1_1V_1_1_1I_1_1I_1MA_releaseCallBack
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint index) {
        switch (index) {
#define TRAMPOLINE_RELEASE_CASE(index) case index: \
                callback_refs_ ## index .callbackClassRef = NULL; \
                callback_refs_ ## index .trampolineMethodID = 0; \
                break;
                
                //create the 16 trampoline cases
                TRAMPOLINE_RELEASE_CASE(0)
                TRAMPOLINE_RELEASE_CASE(1)
                TRAMPOLINE_RELEASE_CASE(2)
                TRAMPOLINE_RELEASE_CASE(3)
                TRAMPOLINE_RELEASE_CASE(4)
                TRAMPOLINE_RELEASE_CASE(5)
                TRAMPOLINE_RELEASE_CASE(6)
                TRAMPOLINE_RELEASE_CASE(7)
                TRAMPOLINE_RELEASE_CASE(8)
                TRAMPOLINE_RELEASE_CASE(9)
                TRAMPOLINE_RELEASE_CASE(10)
                TRAMPOLINE_RELEASE_CASE(11)
                TRAMPOLINE_RELEASE_CASE(12)
                TRAMPOLINE_RELEASE_CASE(13)
                TRAMPOLINE_RELEASE_CASE(14)
                TRAMPOLINE_RELEASE_CASE(15)
            default:
        }
        return 0;
    }

    /*
     * Class:     de_ibapl_jnhw_common_upcall_jni_JniCallbackFactory__V___I__I_MA
     * Method:    getMaxCallBacks
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_upcall_jni_JniCallbackFactory_1_1V_1_1_1I_1_1I_1MA_getMaxCallBacks
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return MAX_CALL_BACKS;
    }

#ifdef __cplusplus
}
#endif
