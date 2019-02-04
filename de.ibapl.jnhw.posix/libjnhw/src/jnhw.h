#ifndef _ljnhw_H
#define _jnhw_H

#include <jni.h>

#include <config.h>

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
jfieldID de_ibapl_jnhw_ByteRef_value_ID;
jfieldID de_ibapl_jnhw_ShortRef_value_ID;
jfieldID de_ibapl_jnhw_IntRef_value_ID;
jfieldID de_ibapl_jnhw_LongRef_value_ID;

//Cached Exceptions
void throw_NativeErrorException(JNIEnv* env, int errno);

void throw_NotDefinedException(JNIEnv* env, const char*  defineName);

void throw_ClassNotFoundException(JNIEnv* env, const char* className);

void throw_NoSuchFieldException(JNIEnv* env, const char* className, const char* fieldName, const char* fieldType);

void throw_NoSuchMethodException(JNIEnv* env, const char* className, const char* fieldName, const char* fieldType);

void throw_NullPointerException(JNIEnv* env, const char* message);

void throw_ArrayIndexOutOfBoundsException(JNIEnv* env, const char* message);

//extern void throwException(JNIEnv* env, const char* exceptionName, const char* fmt, ...);



jclass getGlobalClassRef(JNIEnv *env, const char* className);

jfieldID getFieldId(JNIEnv *env, const char* className, const char* fieldName, const char* fieldType);

jfieldID getFieldIdOfClassRef(JNIEnv *env, jclass clazz, const char* className, const char* fieldName, const char* fieldType);

jmethodID getMethodIdOfClassRef(JNIEnv *env, jclass clazz, const char* className, const char* methodName, const char* methodSignature);

#endif
