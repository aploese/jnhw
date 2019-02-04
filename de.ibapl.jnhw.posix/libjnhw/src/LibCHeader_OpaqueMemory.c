#include "jnhw.h"

#include "de_ibapl_jnhw_LibJnhwLoader_OpaqueMemory.h"
#include <errno.h>
#include <stdlib.h>
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif
    
/*
 * Class:     de_ibapl_jnhw_LibJnhwLoader_OpaqueMemory
 * Method:    ENOMEM
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_LibJnhwLoader_00024OpaqueMemory_ENOMEM
  (JNIEnv *env, jclass clazz) {
    return ENOMEM;
}

/*
 * Class:     de_ibapl_jnhw_LibJnhwLoader_OpaqueMemory
 * Method:    allocateMemory
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_LibJnhwLoader_00024OpaqueMemory_allocateMemory
  (JNIEnv *env, jclass clazz, jint sizeInBytes) {
    void* result = result = malloc(sizeInBytes);
    if ((result == NULL) && (sizeInBytes > 0)) {
      throw_NativeErrorException(env, errno);  
    } 
    return (jlong)result;
}

/*
 * Class:     de_ibapl_jnhw_LibJnhwLoader_OpaqueMemory
 * Method:    allocateArrayMemory
 * Signature: (II)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_LibJnhwLoader_00024OpaqueMemory_allocateArrayMemory
  (JNIEnv *env, jclass clazz, jint numberOfElements, jint sizeInBytes) {
    void* result = result = calloc(numberOfElements, sizeInBytes);
    if ((result == NULL) && (sizeInBytes > 0) && (numberOfElements > 0)) {
      throw_NativeErrorException(env, errno);  
    } 
    return (jlong)result;
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