#ifndef _ljnhw_H
#define _jnhw_H

#include <jni.h>

#include <config.h>

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _JNHW_COMMON_IMPLEMENTATION_
#define _JNHW_IMPORT_OR_EXPORT_ JNIEXPORT
#else
#define _JNHW_IMPORT_OR_EXPORT_ JNIIMPORT
#endif   

//Init exceptions ant Refs
_JNHW_IMPORT_OR_EXPORT_ void jnhw_common_init(JNIEnv *env);

//Exception names

#define NATIVE_ERROR_EXCEPTION "de/ibapl/jnhw/NativeErrorException"
#define NOT_DEFINED_EXCEPTION "de/ibapl/jnhw/NotDefinedException"
#define UNSATISFIED_LINK_EXCEPTION "java/lang/UnsatisfiedLinkError"
#define NULL_POINTER_EXCEPTION "java/lang/NullPointerException"
#define CLASS_NOT_FOUND_EXCEPTION "java/lang/ClassNotFoundException"
#define NO_SUCH_FIELD_EXCEPTION "java/lang/NoSuchFieldException"
#define NO_SUCH_METHOD_EXCEPTION "java/lang/NoSuchMethodException"
#define ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION "java/lang/ArrayIndexOutOfBoundsException"

//Important class names
#define JNHW_CLASS_NAME_BYTE_REF "de/ibapl/jnhw/ByteRef"
#define JNHW_CLASS_NAME_SHORT_REF "de/ibapl/jnhw/ShortRef"
#define JNHW_CLASS_NAME_INT_REF "de/ibapl/jnhw/IntRef"
#define JNHW_CLASS_NAME_LONG_REF "de/ibapl/jnhw/LongRef"

//Cached
_JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_ByteRef_value_ID;
_JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_ShortRef_value_ID;
_JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_IntRef_value_ID;
_JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_LongRef_value_ID;

//Cached Exceptions
_JNHW_IMPORT_OR_EXPORT_ void throw_NativeErrorException(JNIEnv* env, int errno);

_JNHW_IMPORT_OR_EXPORT_ void throw_NotDefinedException(JNIEnv* env, const char*  defineName);

_JNHW_IMPORT_OR_EXPORT_ void throw_ClassNotFoundException(JNIEnv* env, const char* className);

_JNHW_IMPORT_OR_EXPORT_ void throw_NoSuchFieldException(JNIEnv* env, const char* className, const char* fieldName, const char* fieldType);

_JNHW_IMPORT_OR_EXPORT_ void throw_NoSuchMethodException(JNIEnv* env, const char* className, const char* fieldName, const char* fieldType);

_JNHW_IMPORT_OR_EXPORT_ void throw_NullPointerException(JNIEnv* env, const char* message);

_JNHW_IMPORT_OR_EXPORT_ void throw_ArrayIndexOutOfBoundsException(JNIEnv* env, const char* message);

//extern void throwException(JNIEnv* env, const char* exceptionName, const char* fmt, ...);



_JNHW_IMPORT_OR_EXPORT_ jclass getGlobalClassRef(JNIEnv *env, const char* className);

_JNHW_IMPORT_OR_EXPORT_ jfieldID getFieldId(JNIEnv *env, const char* className, const char* fieldName, const char* fieldType);

_JNHW_IMPORT_OR_EXPORT_ jfieldID getFieldIdOfClassRef(JNIEnv *env, jclass clazz, const char* className, const char* fieldName, const char* fieldType);

_JNHW_IMPORT_OR_EXPORT_ jmethodID getMethodIdOfClassRef(JNIEnv *env, jclass clazz, const char* className, const char* methodName, const char* methodSignature);

#ifdef __cplusplus
}
#endif

#endif
