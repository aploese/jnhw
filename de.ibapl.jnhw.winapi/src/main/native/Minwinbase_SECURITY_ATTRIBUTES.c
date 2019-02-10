#include <config.h>
#include "jnhw.h"

#ifdef HAVE_MINWINBASE_H
#include <windows.h>
#include <minwinbase.h>
#include "de_ibapl_jnhw_winapi_Minwinbase_SECURITY_ATTRIBUTES.h"

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     de_ibapl_jnhw_winapi_Minwinbase_SECURITY_ATTRIBUTES
 * Method:    sizeofSECURITY_ATTRIBUTES
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024SECURITY_1ATTRIBUTES_sizeofSECURITY_1ATTRIBUTES
  (JNIEnv *env, jclass clazz);

/*
 * Class:     de_ibapl_jnhw_winapi_Minwinbase_SECURITY_ATTRIBUTES
 * Method:    nLength
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024SECURITY_1ATTRIBUTES_nLength
  (JNIEnv *, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Minwinbase_SECURITY_ATTRIBUTES
 * Method:    bInheritHandle0
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024SECURITY_1ATTRIBUTES_bInheritHandle0
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
