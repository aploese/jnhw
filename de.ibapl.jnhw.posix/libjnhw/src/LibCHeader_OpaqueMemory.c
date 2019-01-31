#include "jnhw.h"

#include "de_ibapl_jnhw_LibJnhwLoader_OpaqueMemory.h"
#include <errno.h>
#include <stdlib.h>


#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     de_ibapl_jnhw_LibJnhwLoader_OpaqueMemory
 * Method:    allocateMemory
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_LibJnhwLoader_00024OpaqueMemory_allocateMemory
  (JNIEnv *env, jclass clazz, jint sizeInBytes) {
    return (jlong)malloc(sizeInBytes);
}

/*
 * Class:     de_ibapl_jnhw_LibJnhwLoader_OpaqueMemory
 * Method:    freeMemory
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_LibJnhwLoader_00024OpaqueMemory_freeMemory
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    free((void*)baseAddress);
}

#ifdef __cplusplus
}
#endif