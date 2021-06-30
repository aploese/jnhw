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
#include <stdio.h>
#include <stdarg.h>

#define NATIVE_ERROR_EXCEPTION "de/ibapl/jnhw/common/exception/NativeErrorException"
#define NO_SUCH_NATIVE_METHOD_EXCEPTION "de/ibapl/jnhw/common/exception/NoSuchNativeMethodException"
#define NO_SUCH_NATIVE_TYPE_EXCEPTION "de/ibapl/jnhw/common/exception/NoSuchNativeTypeException"
#define NO_SUCH_NATIVE_TYPE_MEMBER_EXCEPTION "de/ibapl/jnhw/common/exception/NoSuchNativeTypeMemberException"
#define ILLEGAL_ARGUMENT_EXCEPTION "java/lang/IllegalArgumentException"


#ifdef __cplusplus
extern "C" {
#endif

    jclass JNICALL getGlobalClassRef(JNIEnv *env, const char* className) {
        jclass clazz = (*env)->FindClass(env, className);
        if (clazz == NULL) {
            return NULL;
        }

        jclass result = (*env)->NewGlobalRef(env, clazz);
        (*env)->DeleteLocalRef(env, clazz);
        if (result == NULL) {
            throw_Exception(env, RUNTIME_EXCEPTION_CLASS_NAME, "Cant get global ref for %s", className);
            return NULL;
        }
        return result;

    }

    void JNICALL deleteGlobalRef(JNIEnv *env, jobject * classRef) {
        if (*classRef != NULL) {
            (*env)->DeleteGlobalRef(env, *classRef);
            *classRef = NULL;
        }
    }

    static jclass NativeErrorExceptionClass = NULL;
    static jmethodID NativeErrorException_Init_ID = NULL;

    static jclass NoSuchNativeMethodExceptionClass = NULL;
    static jclass NoSuchNativeTypeExceptionClass = NULL;
    static jclass NoSuchNativeTypeMemberExceptionClass = NULL;
    static jmethodID NoSuchNativeTypeMemberException_Init_ID = NULL;
    static jclass IllegalArgumentExceptionClass = NULL;

    jboolean initExceptions(JNIEnv* env) {
        if (NativeErrorExceptionClass == NULL) {
            NativeErrorExceptionClass = getGlobalClassRef(env, NATIVE_ERROR_EXCEPTION);
            if (NativeErrorExceptionClass == NULL) {
                return JNI_FALSE;
            }
        }
        if (NativeErrorException_Init_ID == NULL) {
            NativeErrorException_Init_ID = (*env)->GetMethodID(env, NativeErrorExceptionClass, "<init>", "(I)V");
            if (NativeErrorException_Init_ID == NULL) {
                return JNI_FALSE;
            }
        }
        if (NoSuchNativeMethodExceptionClass == NULL) {
            NoSuchNativeMethodExceptionClass = getGlobalClassRef(env, NO_SUCH_NATIVE_METHOD_EXCEPTION);
            if (NoSuchNativeMethodExceptionClass == NULL) {
                return JNI_FALSE;
            }
        }

        if (NoSuchNativeTypeExceptionClass == NULL) {
            NoSuchNativeTypeExceptionClass = getGlobalClassRef(env, NO_SUCH_NATIVE_TYPE_EXCEPTION);
            if (NoSuchNativeTypeExceptionClass == NULL) {
                return JNI_FALSE;
            }
        }

        if (NoSuchNativeTypeMemberExceptionClass == NULL) {
            NoSuchNativeTypeMemberExceptionClass = getGlobalClassRef(env, NO_SUCH_NATIVE_TYPE_MEMBER_EXCEPTION);
            if (NoSuchNativeTypeMemberExceptionClass == NULL) {
                return JNI_FALSE;
            }
        }

        if (NoSuchNativeTypeMemberException_Init_ID == NULL) {
            NoSuchNativeTypeMemberException_Init_ID = (*env)->GetMethodID(env, NoSuchNativeTypeMemberExceptionClass, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V");
            if (NoSuchNativeTypeMemberException_Init_ID == NULL) {
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
        deleteGlobalRef(env, &NoSuchNativeMethodExceptionClass);
        deleteGlobalRef(env, &NoSuchNativeTypeExceptionClass);
        deleteGlobalRef(env, &NoSuchNativeTypeMemberExceptionClass);
        deleteGlobalRef(env, &IllegalArgumentExceptionClass);
    }

    JNIEXPORT void JNICALL throw_NoSuchNativeMethodException(JNIEnv* env, const char* methodName) {
        (*env)->ThrowNew(env, NoSuchNativeMethodExceptionClass, methodName);
    }

    JNIEXPORT void JNICALL throw_NoSuchNativeTypeException(JNIEnv* env, const char* typeName) {
        (*env)->ThrowNew(env, NoSuchNativeTypeExceptionClass, typeName);
    }

    JNIEXPORT void JNICALL throw_NoSuchNativeTypeMemberException(JNIEnv* env, const char* typeName, const char* memberName) {
        const jobject ioeEx = (*env)->NewObject(env, NoSuchNativeTypeMemberExceptionClass, NoSuchNativeTypeMemberException_Init_ID, (*env)->NewStringUTF(env, typeName), (*env)->NewStringUTF(env, memberName));
        (*env)->Throw(env, ioeEx);
    }

    JNIEXPORT void JNICALL throw_NativeErrorException(JNIEnv* env, int errorNumber) {
        const jobject ioeEx = (*env)->NewObject(env, NativeErrorExceptionClass, NativeErrorException_Init_ID, errorNumber);
        (*env)->Throw(env, ioeEx);
    }

    JNIEXPORT void JNICALL throw_IllegalArgumentException(JNIEnv* env, const char* message) {
        (*env)->ThrowNew(env, IllegalArgumentExceptionClass, message);
    }

    JNIEXPORT void JNICALL throw_Exception(JNIEnv* env, const char* exceptionName, const char* fmt, ...) {
        va_list ap;
        char buf[1024] = {0};
        va_start(ap, fmt);
        vsnprintf(buf, sizeof (buf) - 1, fmt, ap);
        va_end(ap);

        (*env)->PushLocalFrame(env, 10);
        jclass exceptionClass = (*env)->FindClass(env, exceptionName);
        if (exceptionClass != NULL) {
            (*env)->ThrowNew(env, exceptionClass, buf);
        }
        (*env)->PopLocalFrame(env, NULL);
    }

#ifdef __cplusplus
}
#endif
