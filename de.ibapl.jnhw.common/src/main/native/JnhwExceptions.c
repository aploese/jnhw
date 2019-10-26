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
#include <stdio.h>
#include <stdarg.h>

#ifdef __cplusplus
extern "C" {
#endif


    static jclass NativeErrorExceptionClass = NULL;
    static jmethodID NativeErrorException_Init_ID = NULL;

    static jclass NotDefinedExceptionClass = NULL;
    static jclass NullPointerExceptionClass = NULL;
    static jclass ArrayIndexOutOfBoundsExceptionClass = NULL;
    static jclass IndexOutOfBoundsExceptionClass = NULL;

    jboolean initExceptions(JNIEnv* env) {
        if (NativeErrorExceptionClass == NULL) {
            NativeErrorExceptionClass = getGlobalClassRef(env, NATIVE_ERROR_EXCEPTION);
            if (NativeErrorExceptionClass == NULL) {
                return JNI_FALSE;
            }
        }
        if (NativeErrorException_Init_ID == NULL) {
            NativeErrorException_Init_ID = getMethodIdOfClassRef(env, NativeErrorExceptionClass, "<init>", "(I)V");
            if (NativeErrorException_Init_ID == NULL) {
                return JNI_FALSE;
            }
        }
        if (NotDefinedExceptionClass == NULL) {
            NotDefinedExceptionClass = getGlobalClassRef(env, NOT_DEFINED_EXCEPTION);
            if (NotDefinedExceptionClass == NULL) {
                return JNI_FALSE;
            }
        }
        if (NullPointerExceptionClass == NULL) {
            NullPointerExceptionClass = getGlobalClassRef(env, NULL_POINTER_EXCEPTION);
            if (NullPointerExceptionClass == NULL) {
                return JNI_FALSE;
            }
        }
        if (IndexOutOfBoundsExceptionClass == NULL) {
            IndexOutOfBoundsExceptionClass = getGlobalClassRef(env, INDEX_OUT_OF_BOUNDS_EXCEPTION);
            if (IndexOutOfBoundsExceptionClass == NULL) {
                return JNI_FALSE;
            }
        }
        if (ArrayIndexOutOfBoundsExceptionClass == NULL) {
            ArrayIndexOutOfBoundsExceptionClass = getGlobalClassRef(env, ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION);
            if (ArrayIndexOutOfBoundsExceptionClass == NULL) {
                return JNI_FALSE;
            }
        }

        return JNI_TRUE;
    }

    void releaseExceptions(JNIEnv* env) {
        if (NativeErrorExceptionClass != NULL) {
            deleteGlobalRef(env, NativeErrorExceptionClass);
            NativeErrorExceptionClass = NULL;
        }
        if (NotDefinedExceptionClass != NULL) {
            deleteGlobalRef(env, NotDefinedExceptionClass);
            NotDefinedExceptionClass = NULL;
        }
        if (NullPointerExceptionClass != NULL) {
            deleteGlobalRef(env, NullPointerExceptionClass);
            NullPointerExceptionClass = NULL;
        }
        if (IndexOutOfBoundsExceptionClass != NULL) {
            deleteGlobalRef(env, IndexOutOfBoundsExceptionClass);
            IndexOutOfBoundsExceptionClass = NULL;
        }
        if (ArrayIndexOutOfBoundsExceptionClass != NULL) {
            deleteGlobalRef(env, ArrayIndexOutOfBoundsExceptionClass);
            ArrayIndexOutOfBoundsExceptionClass = NULL;
        }
    }

    JNIEXPORT void JNICALL throw_NotDefinedException(JNIEnv* env, const char* defineName) {
        (*env)->ThrowNew(env, NotDefinedExceptionClass, defineName);
    }

    JNIEXPORT void JNICALL throw_NativeErrorException(JNIEnv* env, int errno) {
        const jobject ioeEx = (*env)->NewObject(env, NativeErrorExceptionClass, NativeErrorException_Init_ID, errno);
        (*env)->Throw(env, ioeEx);
    }

    JNIEXPORT void JNICALL throw_NullPointerException(JNIEnv* env, const char* message) {
        (*env)->ThrowNew(env, NullPointerExceptionClass, message);
    }

    JNIEXPORT void JNICALL throw_IndexOutOfBoundsException(JNIEnv* env, const char* message) {
        (*env)->ThrowNew(env, IndexOutOfBoundsExceptionClass, message);
    }

    JNIEXPORT void JNICALL throw_ArrayIndexOutOfBoundsException(JNIEnv* env, const char* message) {
        (*env)->ThrowNew(env, ArrayIndexOutOfBoundsExceptionClass, message);
    }

    JNIEXPORT void JNICALL throwException(JNIEnv* env, const char* exceptionName, const char* fmt, ...) {
        va_list ap;
        char buf[1024] = {0};
        va_start(ap, fmt);
        vsnprintf(buf, sizeof (buf) - 1, fmt, ap);

        (*env)->PushLocalFrame(env, 10);
        jclass exceptionClass = (*env)->FindClass(env, exceptionName);
        if (exceptionClass != NULL) {
            (*env)->ThrowNew(env, exceptionClass, buf);
        }
        (*env)->PopLocalFrame(env, NULL);
        va_end(ap);
    }
#ifdef __cplusplus
}
#endif
