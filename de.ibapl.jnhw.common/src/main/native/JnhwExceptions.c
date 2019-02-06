#define _JNHW_COMMON_IMPLEMENTATION_ 1
#include "jnhw.h"
#include <stdio.h>
#include <stdarg.h>
#include "JnhwExceptions.h"

#ifdef __cplusplus
extern "C" {
#endif


    static jclass NativeErrorExceptionClass = NULL;
    static jmethodID NativeErrorException_Init_ID = NULL;

    static jclass NotDefinedExceptionClass = NULL;
    static jclass ClassNotFoundExceptionClass = NULL;
    static jclass NoSuchFieldExceptionClass = NULL;
    static jclass NoSuchMethodExceptionClass = NULL;
    static jclass NullPointerExceptionClass = NULL;
    static jclass ArrayIndexOutOfBoundsExceptionClass = NULL;

    void initExceptions(JNIEnv* env) {
        if (NativeErrorExceptionClass == NULL) {
            NativeErrorExceptionClass = getGlobalClassRef(env, NATIVE_ERROR_EXCEPTION);
        }
        if (NativeErrorException_Init_ID == NULL) {
            NativeErrorException_Init_ID = getMethodIdOfClassRef(env, NativeErrorExceptionClass, NATIVE_ERROR_EXCEPTION, "<init>", "(I)V");
        }
        if (NotDefinedExceptionClass == NULL) {
            NotDefinedExceptionClass = getGlobalClassRef(env, NOT_DEFINED_EXCEPTION);
        }
        if (ClassNotFoundExceptionClass == NULL) {
            ClassNotFoundExceptionClass = getGlobalClassRef(env, CLASS_NOT_FOUND_EXCEPTION);
        }
        if (NoSuchFieldExceptionClass == NULL) {
            NoSuchFieldExceptionClass = getGlobalClassRef(env, NO_SUCH_FIELD_EXCEPTION);
        }
        if (NoSuchMethodExceptionClass == NULL) {
            NoSuchMethodExceptionClass = getGlobalClassRef(env, NO_SUCH_METHOD_EXCEPTION);
        }
        if (NullPointerExceptionClass == NULL) {
            NullPointerExceptionClass = getGlobalClassRef(env, NULL_POINTER_EXCEPTION);
        }
        if (ArrayIndexOutOfBoundsExceptionClass == NULL) {
            ArrayIndexOutOfBoundsExceptionClass = getGlobalClassRef(env, ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION);
        }
    }

JNIEXPORT void throw_NotDefinedException(JNIEnv* env, const char* defineName) {
        (*env)->ThrowNew(env, NotDefinedExceptionClass, defineName);
    }

JNIEXPORT void throw_ClassNotFoundException(JNIEnv* env, const char* className) {
        (*env)->ThrowNew(env, ClassNotFoundExceptionClass, className);
    }

JNIEXPORT void throw_NoSuchFieldException(JNIEnv* env, const char* className, const char* fieldName, const char* fieldType) {
        char buf[1024] = {0};
        snprintf(buf, sizeof (buf) - 1, "Get FieldID of (%s) %s.%s", fieldType, className, fieldName);
        (*env)->ThrowNew(env, NoSuchFieldExceptionClass, buf);
    }

JNIEXPORT void throw_NoSuchMethodException(JNIEnv* env, const char* className, const char* methodName, const char* methodSignature) {
        char buf[1024] = {0};
        snprintf(buf, sizeof (buf) - 1, "Get FieldID of (%s) %s.%s", methodSignature, className, methodName);
        (*env)->ThrowNew(env, NoSuchFieldExceptionClass, buf);
    }

JNIEXPORT void throw_NativeErrorException(JNIEnv* env, int errno) {
        const jobject ioeEx = (*env)->NewObject(env, NativeErrorExceptionClass, NativeErrorException_Init_ID, errno);
        (*env)->Throw(env, ioeEx);
    }

JNIEXPORT void throw_NullPointerException(JNIEnv* env, const char* message) {
        (*env)->ThrowNew(env, NullPointerExceptionClass, message);
    }

JNIEXPORT void throw_ArrayIndexOutOfBoundsException(JNIEnv* env, const char* message) {
        (*env)->ThrowNew(env, ArrayIndexOutOfBoundsExceptionClass, message);
    }

JNIEXPORT void throwException(JNIEnv* env, const char* exceptionName, const char* fmt, ...) {
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
