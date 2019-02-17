#include "jnhw-winapi.h"
#include "de_ibapl_jnhw_winapi_Minwinbase_SECURITY_ATTRIBUTES.h"

#ifdef HAVE_MINWINBASE_H
#include <minwinbase.h>

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     de_ibapl_jnhw_winapi_Minwinbase_SECURITY_ATTRIBUTES
 * Method:    sizeofSECURITY_ATTRIBUTES
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024SECURITY_1ATTRIBUTES_sizeofSECURITY_1ATTRIBUTES
  (JNIEnv *env, jclass clazz) {
    return sizeof(SECURITY_ATTRIBUTES);
}

/*
 * Class:     de_ibapl_jnhw_winapi_Minwinbase_SECURITY_ATTRIBUTES
 * Method:    nLength
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024SECURITY_1ATTRIBUTES_nLength
  (JNIEnv *env, jobject clazz,  jlong baseAddress){
       return ((SECURITY_ATTRIBUTES*) (uintptr_t) baseAddress)->nLength;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Minwinbase_SECURITY_ATTRIBUTES
 * Method:    bInheritHandle
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024SECURITY_1ATTRIBUTES_bInheritHandle
  (JNIEnv *env, jobject clazz,  jlong baseAddress){
       return ((SECURITY_ATTRIBUTES*) (uintptr_t) baseAddress)->bInheritHandle;
}

#ifdef __cplusplus
}
#endif
#endif
