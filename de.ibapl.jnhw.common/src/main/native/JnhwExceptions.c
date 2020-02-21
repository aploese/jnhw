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

#define NATIVE_ERROR_EXCEPTION "de/ibapl/jnhw/NativeErrorException"
#define NOT_DEFINED_EXCEPTION "de/ibapl/jnhw/NotDefinedException"
#define NO_SUCH_NATIVE_METHOD_EXCEPTION "de/ibapl/jnhw/NoSuchNativeMethodException"
#define NO_SUCH_TYPE_MEMBER_EXCEPTION "de/ibapl/jnhw/NoSuchTypeMemberException"
#define NULL_POINTER_EXCEPTION "java/lang/NullPointerException"
#define ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION "java/lang/ArrayIndexOutOfBoundsException"
#define INDEX_OUT_OF_BOUNDS_EXCEPTION "java/lang/IndexOutOfBoundsException"
#define ILLEGAL_ARGUMENT_EXCEPTION "java/lang/IllegalArgumentException"


#ifdef __cplusplus
extern "C" {
#endif


    static jclass NativeErrorExceptionClass = NULL;
    static jmethodID NativeErrorException_Init_ID = NULL;

    static jclass NotDefinedExceptionClass = NULL;
    static jclass NoSuchNativeMethodExceptionClass = NULL;
    static jclass NoSuchTypeMemberExceptionClass = NULL;
    static jmethodID NoSuchTypeMemberException_Init_ID = NULL;
    static jclass NullPointerExceptionClass = NULL;
    static jclass ArrayIndexOutOfBoundsExceptionClass = NULL;
    static jclass IndexOutOfBoundsExceptionClass = NULL;
    static jclass IllegalArgumentExceptionClass = NULL;

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
        if (NoSuchNativeMethodExceptionClass == NULL) {
            NoSuchNativeMethodExceptionClass = getGlobalClassRef(env, NO_SUCH_NATIVE_METHOD_EXCEPTION);
            if (NoSuchNativeMethodExceptionClass == NULL) {
                return JNI_FALSE;
            }
        }
        
        if (NoSuchTypeMemberExceptionClass == NULL) {
            NoSuchTypeMemberExceptionClass = getGlobalClassRef(env, NO_SUCH_TYPE_MEMBER_EXCEPTION);
            if (NoSuchTypeMemberExceptionClass == NULL) {
                return JNI_FALSE;
            }
        }

        if (NoSuchTypeMemberException_Init_ID == NULL) {
            NoSuchTypeMemberException_Init_ID = getMethodIdOfClassRef(env, NoSuchTypeMemberExceptionClass, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V");
            if (NoSuchTypeMemberException_Init_ID == NULL) {
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

        if (IllegalArgumentExceptionClass == NULL) {
            IllegalArgumentExceptionClass = getGlobalClassRef(env, ILLEGAL_ARGUMENT_EXCEPTION);
            if (IllegalArgumentExceptionClass == NULL) {
                return JNI_FALSE;
            }
        }



        return JNI_TRUE;
    }

    void releaseExceptions(JNIEnv* env) {
        deleteGlobalRef(env, &NativeErrorExceptionClass);
        deleteGlobalRef(env, &NotDefinedExceptionClass);
        deleteGlobalRef(env, &NoSuchNativeMethodExceptionClass);
        deleteGlobalRef(env, &NoSuchTypeMemberExceptionClass);
        deleteGlobalRef(env, &NullPointerExceptionClass);
        deleteGlobalRef(env, &IndexOutOfBoundsExceptionClass);
        deleteGlobalRef(env, &ArrayIndexOutOfBoundsExceptionClass);
        deleteGlobalRef(env, &IllegalArgumentExceptionClass);
    }

    JNIEXPORT void JNICALL throw_NotDefinedException(JNIEnv* env, const char* defineName) {
        (*env)->ThrowNew(env, NotDefinedExceptionClass, defineName);
    }

    JNIEXPORT void JNICALL throw_NoSuchNativeMethodException(JNIEnv* env, const char* methodName) {
        (*env)->ThrowNew(env, NoSuchNativeMethodExceptionClass, methodName);
    }

    JNIEXPORT void JNICALL throw_NoSuchTypeMemberException(JNIEnv* env, const char* typeName, const char* memberName) {
        const jobject ioeEx = (*env)->NewObject(env, NoSuchTypeMemberExceptionClass, NoSuchTypeMemberException_Init_ID, (*env)->NewStringUTF(env, typeName), (*env)->NewStringUTF(env, memberName));
        (*env)->Throw(env, ioeEx);
    }

    JNIEXPORT void JNICALL throw_NativeErrorException(JNIEnv* env, int errorNumber) {
        const jobject ioeEx = (*env)->NewObject(env, NativeErrorExceptionClass, NativeErrorException_Init_ID, errorNumber);
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

    JNIEXPORT void JNICALL throw_IllegalArgumentException(JNIEnv* env, const char* message) {
        (*env)->ThrowNew(env, IllegalArgumentExceptionClass, message);
    }

    JNIEXPORT void JNICALL throw_Exception(JNIEnv* env, const char* exceptionName, const char* fmt, ...) {
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
