#include <stdio.h>
#include <stdarg.h>
#include "JnhwExceptions.h"

const char* NativeErrorException = "de/ibapl/jnhw/NativeErrorException";
const char* NotDefinedException = "de/ibapl/jnhw/NotDefinedException";
const char* UnsatisfiedLinkException = "java/lang/UnsatisfiedLinkError";

void throwNativeError(JNIEnv* env, int errno) {
    jclass exceptionClass = (*env)->FindClass(env, NativeErrorException);
    if (exceptionClass != NULL) {
        const jmethodID NativeErrorException_Constructor = (*env)->GetMethodID(env, exceptionClass,
                "<init>", "(I)V");
        const jobject ioeEx = (*env)->NewObject(env, exceptionClass, NativeErrorException_Constructor, errno);

        (*env)->Throw(env, ioeEx);

        (*env)->DeleteLocalRef(env, exceptionClass);
    }
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
