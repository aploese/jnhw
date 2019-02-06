#define _JNHW_COMMON_IMPLEMENTATION_ 1
#include "jnhw.h"

#include "de_ibapl_jnhw_OpaqueMemory.h"
#include <errno.h>
#include <stdlib.h>
#include <stdint.h>


#ifdef __cplusplus
extern "C" {
#endif
    
/*
 * Class:     de_ibapl_jnhw_OpaqueMemory
 * Method:    ENOMEM
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_OpaqueMemory_ENOMEM
  (JNIEnv *env, jclass clazz) {
    return ENOMEM;
}

/*
 * Class:     de_ibapl_jnhw_OpaqueMemory
 * Method:    malloc
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_OpaqueMemory_malloc
  (JNIEnv *env, jclass clazz, jint sizeInBytes) {
    void* result = result = malloc(sizeInBytes);
    if ((result == NULL) && (sizeInBytes > 0)) {
      throw_NativeErrorException(env, errno);  
    } 
    return (uintptr_t)result;
}

/*
 * Class:     de_ibapl_jnhw_OpaqueMemory
 * Method:    calloc
 * Signature: (II)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_OpaqueMemory_calloc
  (JNIEnv *env, jclass clazz, jint numberOfElements, jint sizeInBytes) {
    void* result = result = calloc(numberOfElements, sizeInBytes);
    if ((result == NULL) && (sizeInBytes > 0) && (numberOfElements > 0)) {
      throw_NativeErrorException(env, errno);  
    } 
    return (uintptr_t)result;
}

/*
 * Class:     de_ibapl_jnhw_OpaqueMemory
 * Method:    free
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_OpaqueMemory_free
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    free((void*)(uintptr_t)baseAddress);
}

#ifdef __cplusplus
}
#endif