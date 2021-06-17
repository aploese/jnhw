/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class de_ibapl_jnhw_posix_Locale */

#ifndef _Included_de_ibapl_jnhw_posix_Locale
#define _Included_de_ibapl_jnhw_posix_Locale
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     de_ibapl_jnhw_posix_Locale
 * Method:    duplocale
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Locale_duplocale
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_posix_Locale
 * Method:    freelocale
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Locale_freelocale
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_posix_Locale
 * Method:    localeconv0
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Locale_localeconv0
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_posix_Locale
 * Method:    newlocale
 * Signature: (ILjava/lang/String;J)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Locale_newlocale
  (JNIEnv *, jclass, jint, jstring, jlong);

/*
 * Class:     de_ibapl_jnhw_posix_Locale
 * Method:    setlocale
 * Signature: (ILjava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Locale_setlocale
  (JNIEnv *, jclass, jint, jstring);

/*
 * Class:     de_ibapl_jnhw_posix_Locale
 * Method:    uselocale
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Locale_uselocale
  (JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif
