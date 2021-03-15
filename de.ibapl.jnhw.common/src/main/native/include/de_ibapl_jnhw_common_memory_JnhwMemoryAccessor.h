/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class de_ibapl_jnhw_common_memory_JnhwMemoryAccessor */

#ifndef _Included_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
#define _Included_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    ENOMEM
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_ENOMEM
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    malloc
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_malloc
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    free
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_free
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    setMemory0
 * Signature: (JJB)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_setMemory0
  (JNIEnv *, jclass, jlong, jlong, jbyte);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    copyMemory0
 * Signature: ([BIJJI)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_copyMemory0___3BIJJI
  (JNIEnv *, jclass, jbyteArray, jint, jlong, jlong, jint);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    copyMemory0
 * Signature: (JJ[BII)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_copyMemory0__JJ_3BII
  (JNIEnv *, jclass, jlong, jlong, jbyteArray, jint, jint);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uintptr_t0
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uintptr_1t0__J
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uintptr_t0
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uintptr_1t0__JJ
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uintptr_t0
 * Signature: (JLjava/nio/ByteBuffer;I)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uintptr_1t0__JLjava_nio_ByteBuffer_2I
  (JNIEnv *, jclass, jlong, jobject, jint);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uintptr_t_AtIndex0
 * Signature: (JI)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uintptr_1t_1AtIndex0__JI
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uintptr_t_AtIndex0
 * Signature: (JIJ)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uintptr_1t_1AtIndex0__JIJ
  (JNIEnv *, jclass, jlong, jint, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    int8_t0
 * Signature: (J)B
 */
JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int8_1t0__J
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    int8_t0
 * Signature: (JB)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int8_1t0__JB
  (JNIEnv *, jclass, jlong, jbyte);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    int8_t_AsHex0
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int8_1t_1AsHex0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    int8_t_nativeToString0
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int8_1t_1nativeToString0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    int16_t0
 * Signature: (J)S
 */
JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int16_1t0__J
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    int16_t0
 * Signature: (JS)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int16_1t0__JS
  (JNIEnv *, jclass, jlong, jshort);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    int16_t_AsHex0
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int16_1t_1AsHex0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    int16_t_nativeToString0
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int16_1t_1nativeToString0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    int32_t0
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int32_1t0__J
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    int32_t0
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int32_1t0__JI
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    int32_t_AsHex0
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int32_1t_1AsHex0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    int32_t_nativeToString0
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int32_1t_1nativeToString0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    int64_t0
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int64_1t0__J
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    int64_t0
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int64_1t0__JJ
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    int64_t_AsHex0
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int64_1t_1AsHex0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    int64_t_nativeToString0
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int64_1t_1nativeToString0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint8_t0
 * Signature: (J)B
 */
JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint8_1t0__J
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint8_t_AsShort0
 * Signature: (J)S
 */
JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint8_1t_1AsShort0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint8_t0
 * Signature: (JB)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint8_1t0__JB
  (JNIEnv *, jclass, jlong, jbyte);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint8_t_FromShort0
 * Signature: (JS)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint8_1t_1FromShort0
  (JNIEnv *, jclass, jlong, jshort);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint8_t_AsHex0
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint8_1t_1AsHex0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint8_t_nativeToString0
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint8_1t_1nativeToString0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint16_t0
 * Signature: (J)S
 */
JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint16_1t0__J
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint16_t_AsInt0
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint16_1t_1AsInt0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint16_t0
 * Signature: (JS)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint16_1t0__JS
  (JNIEnv *, jclass, jlong, jshort);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint16_t_FromInt0
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint16_1t_1FromInt0
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint16_t_AsHex0
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint16_1t_1AsHex0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint16_t_nativeToString0
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint16_1t_1nativeToString0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint32_t0
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint32_1t0__J
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint32_t_AsLong0
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint32_1t_1AsLong0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint32_t0
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint32_1t0__JI
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint32_t_FromLong0
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint32_1t_1FromLong0
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint32_t_AsHex0
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint32_1t_1AsHex0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint32_t_nativeToString0
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint32_1t_1nativeToString0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint64_t0
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint64_1t0__J
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint64_t0
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint64_1t0__JJ
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint64_t_AsHex0
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint64_1t_1AsHex0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    uint64_t_nativeToString0
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint64_1t_1nativeToString0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    signed_long0
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_signed_1long0__J
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    signed_long0
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_signed_1long0__JJ
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    signed_long_AtIndex0
 * Signature: (JI)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_signed_1long_1AtIndex0__JI
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    signed_long_AtIndex0
 * Signature: (JIJ)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_signed_1long_1AtIndex0__JIJ
  (JNIEnv *, jclass, jlong, jint, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    unsigned_long0
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_unsigned_1long0__J
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    unsigned_long0
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_unsigned_1long0__JJ
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    unsigned_long_AtIndex0
 * Signature: (JI)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_unsigned_1long_1AtIndex0__JI
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    unsigned_long_AtIndex0
 * Signature: (JIJ)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_unsigned_1long_1AtIndex0__JIJ
  (JNIEnv *, jclass, jlong, jint, jlong);

/*
 * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
 * Method:    getStringUTF0
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_getStringUTF0
  (JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif
