#include "jnhw.h"

#ifdef HAVE_MARKER_H

#ifdef __cplusplus
extern "C" {
#endif
#undef de_ibapl_jnhw_winapi_Fileapi_CREATE_NEW
#define de_ibapl_jnhw_winapi_Fileapi_CREATE_NEW 1L
#undef de_ibapl_jnhw_winapi_Fileapi_CREATE_ALWAYS
#define de_ibapl_jnhw_winapi_Fileapi_CREATE_ALWAYS 2L
#undef de_ibapl_jnhw_winapi_Fileapi_OPEN_ALWAYS
#define de_ibapl_jnhw_winapi_Fileapi_OPEN_ALWAYS 4L
#undef de_ibapl_jnhw_winapi_Fileapi_TRUNCATE_EXISTING
#define de_ibapl_jnhw_winapi_Fileapi_TRUNCATE_EXISTING 5L
#undef de_ibapl_jnhw_winapi_Fileapi_INVALID_FILE_SIZE
#define de_ibapl_jnhw_winapi_Fileapi_INVALID_FILE_SIZE -1L
#undef de_ibapl_jnhw_winapi_Fileapi_INVALID_SET_FILE_POINTER
#define de_ibapl_jnhw_winapi_Fileapi_INVALID_SET_FILE_POINTER -1L
#undef de_ibapl_jnhw_winapi_Fileapi_INVALID_FILE_ATTRIBUTES
#define de_ibapl_jnhw_winapi_Fileapi_INVALID_FILE_ATTRIBUTES -1L
/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    OPEN_EXISTING
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_OPEN_1EXISTING
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    CreateFileW
 * Signature: (Ljava/lang/String;IILde/ibapl/jnhw/winapi/Minwinbase/SECURITY_ATTRIBUTES;IILde/ibapl/jnhw/winapi/Minwindef/HANDLE;)Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;
 */
JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_CreateFileW
  (JNIEnv *, jclass, jstring, jint, jint, jobject, jint, jint, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    FlushFileBuffers
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_FlushFileBuffers
  (JNIEnv *, jclass, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    ReadFile
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;[BILde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__Lde_ibapl_jnhw_winapi_Minwindef_HANDLE_2_3BILde_ibapl_jnhw_IntRef_2Lde_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED_2
  (JNIEnv *, jclass, jobject, jbyteArray, jint, jobject, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    ReadFile
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;Ljava/nio/ByteBuffer;ILde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__Lde_ibapl_jnhw_winapi_Minwindef_HANDLE_2Ljava_nio_ByteBuffer_2ILde_ibapl_jnhw_IntRef_2Lde_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED_2
  (JNIEnv *, jclass, jobject, jobject, jint, jobject, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    WriteFile
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;Ljava/nio/ByteBuffer;ILde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__Lde_ibapl_jnhw_winapi_Minwindef_HANDLE_2Ljava_nio_ByteBuffer_2ILde_ibapl_jnhw_IntRef_2Lde_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED_2
  (JNIEnv *, jclass, jobject, jobject, jint, jobject, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    WriteFile
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;[BILde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__Lde_ibapl_jnhw_winapi_Minwindef_HANDLE_2_3BILde_ibapl_jnhw_IntRef_2Lde_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED_2
  (JNIEnv *, jclass, jobject, jbyteArray, jint, jobject, jobject);

#ifdef __cplusplus
}
#endif
