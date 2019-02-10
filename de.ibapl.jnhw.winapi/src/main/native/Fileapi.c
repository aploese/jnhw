#include <config.h>
#include "jnhw.h"

#ifdef HAVE_MARKER_H
#include <windows.h>

#ifdef __cplusplus
extern "C" {
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
