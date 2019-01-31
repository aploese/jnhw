#ifndef JnhwExceptions_h
#define JnhwExceptions_h

#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif



    extern const char* NotDefinedException;

    extern const char* IllegalArgumentException;
    extern const char* NullPointerException;
    extern const char* UnsatisfiedLinkException;

    extern void throwNativeError(JNIEnv* env, int errno);

    extern void throwException(JNIEnv* env, const char* exceptionName, const char* fmt, ...);

#ifdef __cplusplus
}
#endif

#endif

