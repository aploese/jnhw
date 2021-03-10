/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class de_ibapl_jnhw_posix_Fcntl */

#ifndef _Included_de_ibapl_jnhw_posix_Fcntl
#define _Included_de_ibapl_jnhw_posix_Fcntl
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    initFields
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Fcntl_initFields
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    creat
 * Signature: (Ljava/lang/String;I)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_creat
  (JNIEnv *, jclass, jstring, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    creat64
 * Signature: (Ljava/lang/String;I)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_creat64
  (JNIEnv *, jclass, jstring, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    fcntl
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_fcntl__II
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    fcntl
 * Signature: (III)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_fcntl__III
  (JNIEnv *, jclass, jint, jint, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    fcntl64
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_fcntl64__II
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    fcntl64
 * Signature: (III)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_fcntl64__III
  (JNIEnv *, jclass, jint, jint, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    open
 * Signature: (Ljava/lang/String;I)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_open__Ljava_lang_String_2I
  (JNIEnv *, jclass, jstring, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    open
 * Signature: (Ljava/lang/String;II)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_open__Ljava_lang_String_2II
  (JNIEnv *, jclass, jstring, jint, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    open64
 * Signature: (Ljava/lang/String;I)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_open64__Ljava_lang_String_2I
  (JNIEnv *, jclass, jstring, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    open64
 * Signature: (Ljava/lang/String;II)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_open64__Ljava_lang_String_2II
  (JNIEnv *, jclass, jstring, jint, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    openat
 * Signature: (ILjava/lang/String;I)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_openat__ILjava_lang_String_2I
  (JNIEnv *, jclass, jint, jstring, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    openat
 * Signature: (ILjava/lang/String;II)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_openat__ILjava_lang_String_2II
  (JNIEnv *, jclass, jint, jstring, jint, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    openat64
 * Signature: (ILjava/lang/String;I)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_openat64__ILjava_lang_String_2I
  (JNIEnv *, jclass, jint, jstring, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    openat64
 * Signature: (ILjava/lang/String;II)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_openat64__ILjava_lang_String_2II
  (JNIEnv *, jclass, jint, jstring, jint, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    posix_fadvise
 * Signature: (IJJI)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Fcntl_posix_1fadvise
  (JNIEnv *, jclass, jint, jlong, jlong, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    posix_fadvise64
 * Signature: (IJJI)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Fcntl_posix_1fadvise64
  (JNIEnv *, jclass, jint, jlong, jlong, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    posix_fallocate
 * Signature: (IJJ)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Fcntl_posix_1fallocate
  (JNIEnv *, jclass, jint, jlong, jlong);

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    posix_fallocate64
 * Signature: (IJJ)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Fcntl_posix_1fallocate64
  (JNIEnv *, jclass, jint, jlong, jlong);

#ifdef __cplusplus
}
#endif
#endif