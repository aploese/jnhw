#include <stdio.h>
#include <stdarg.h>
#include "JnhwExceptions.h"


static jclass NativeErrorExceptionClass;
static jmethodID NativeErrorException_Init_ID;

static jclass NotDefinedExceptionClass;
static jclass ClassNotFoundExceptionClass;
static jclass NoSuchFieldExceptionClass;
static jclass NoSuchMethodExceptionClass;
static jclass NullPointerExceptionClass;
static jclass ArrayIndexOutOfBoundsExceptionClass;

void initExceptions(JNIEnv* env) {
    NativeErrorExceptionClass = getGlobalClassRef(env, NATIVE_ERROR_EXCEPTION);
    NativeErrorException_Init_ID = getMethodIdOfClassRef(env, NativeErrorExceptionClass, NATIVE_ERROR_EXCEPTION, "<init>", "(I)V");
    NotDefinedExceptionClass = getGlobalClassRef(env, NOT_DEFINED_EXCEPTION);
    ClassNotFoundExceptionClass = getGlobalClassRef(env, CLASS_NOT_FOUND_EXCEPTION);
    NoSuchFieldExceptionClass = getGlobalClassRef(env, NO_SUCH_FIELD_EXCEPTION);
    NoSuchMethodExceptionClass = getGlobalClassRef(env, NO_SUCH_METHOD_EXCEPTION);
    NullPointerExceptionClass =  getGlobalClassRef(env, NULL_POINTER_EXCEPTION);
    ArrayIndexOutOfBoundsExceptionClass = getGlobalClassRef(env, ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION);
}

void throw_NotDefinedException(JNIEnv* env, const char* defineName) {
    (*env)->ThrowNew(env, NotDefinedExceptionClass, defineName);
}

void throw_ClassNotFoundException(JNIEnv* env, const char* className) {
    (*env)->ThrowNew(env, ClassNotFoundExceptionClass, className);
}

void throw_NoSuchFieldException(JNIEnv* env, const char* className, const char* fieldName, const char* fieldType) {
    char buf[1024] = {0};
    snprintf(buf, sizeof (buf) - 1, "Get FieldID of (%s) %s.%s", fieldType, className, fieldName);
    (*env)->ThrowNew(env, NoSuchFieldExceptionClass, buf);
}

void throw_NoSuchMethodException(JNIEnv* env, const char* className, const char* methodName, const char* methodSignature) {
    char buf[1024] = {0};
    snprintf(buf, sizeof (buf) - 1, "Get FieldID of (%s) %s.%s", methodSignature, className, methodName);
    (*env)->ThrowNew(env, NoSuchFieldExceptionClass, buf);
}

void throw_NativeErrorException(JNIEnv* env, int errno) {
    const jobject ioeEx = (*env)->NewObject(env, NativeErrorExceptionClass, NativeErrorException_Init_ID, errno);
    (*env)->Throw(env, ioeEx);
}

void throw_NullPointerException(JNIEnv* env, const char* message) {
    (*env)->ThrowNew(env, NullPointerExceptionClass, message);
}

void throw_ArrayIndexOutOfBoundsException(JNIEnv* env, const char* message) {
    (*env)->ThrowNew(env, ArrayIndexOutOfBoundsExceptionClass, message);
}

void
throwException(JNIEnv* env, const char* exceptionName, const char* fmt, ...) {
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
