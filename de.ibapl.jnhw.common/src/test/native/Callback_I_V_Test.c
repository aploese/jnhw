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
#include "de_ibapl_jnhw_common_test_callbacks_Callback_I_V_Test.h"

//First go for windows.h because mingw has a pthread.h too...
#ifdef HAVE_WINDOWS_H
#include <windows.h>
#elif defined HAVE_PTHREAD_H
#include <pthread.h>
#endif

#ifdef HAVE_SIGNAL_H
#include <signal.h>
#endif

#ifdef __cplusplus
extern "C" {
#endif

    typedef void (*_callback_I_V)(int32_t);
    static _callback_I_V callbackPtr = NULL;

    /*
     * Class:     de_ibapl_jnhw_common_test_callbacks_Callback_I_V_Test
     * Method:    setCallback
     * Signature: (Lde/ibapl/jnhw/common/callbacks/Callback_I_V;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_test_callbacks_Callback_1I_1V_1Test_setCallback
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jobject callback) {
        callbackPtr = UNWRAP_NATIVE_FUNCTION_POINTER_TO(void (*)(int32_t), callback);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_callbacks_Callback_I_V_Tests
     * Method:    getCallbackPtr
     * Signature: ()Lde/ibapl/jnhw/common/memory/NativeFunctionPointer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_common_test_callbacks_Callback_1I_1V_1Test_getCallbackPtr
    (JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return CREATE_NATIVE_FUNCTION_POINTER(callbackPtr);
    }

#ifdef HAVE_WINDOWS_H
    DWORD WINAPI thr_fn_I(LPVOID args) {
            callbackPtr(*((int32_t*)args));
            return 0;
    }
#elif defined HAVE_PTHREAD_H
    void * thr_fn_I(void *args) {
            callbackPtr(*((int32_t*)args));
            return NULL;
    }
#else
    error "Neither pthread.h for POSIX nor windows.h for windows are available ... giving up"
#endif
    
    
    /*
     * Class:     de_ibapl_jnhw_common_test_callbacks_Callback_I_V_Tests
     * Method:    doCallTheCallback
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_test_callbacks_Callback_1I_1V_1Test_doCallTheCallback
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz, jint value) {
#ifdef HAVE_WINDOWS_H
        HANDLE hThread;
        DWORD   dwThreadId;
        
        hThread = CreateThread( 
            NULL,           // default security attributes
            0,              // use default stack size  
            thr_fn_I,         // thread function name
            &value,         // argument to thread function 
            0,              // use default creation flags 
            &dwThreadId);   // returns the thread identifier 
          if (hThread == NULL) 
        {
           ExitProcess(3);
        }
        WaitForSingleObject(hThread, INFINITE);
        CloseHandle(hThread);
#elif defined HAVE_PTHREAD_H
        pthread_t thread;
        pthread_create(&thread, NULL, thr_fn_I, &value);
        pthread_join(thread, NULL);
#else
    error "Neither pthread.h for POSIX nor windows.h for windows are available ... giving up"
#endif
    }


#ifdef __cplusplus
}
#endif

