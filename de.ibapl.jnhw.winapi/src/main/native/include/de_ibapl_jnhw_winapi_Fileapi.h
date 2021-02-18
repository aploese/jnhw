/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class de_ibapl_jnhw_winapi_Fileapi */

#ifndef _Included_de_ibapl_jnhw_winapi_Fileapi
#define _Included_de_ibapl_jnhw_winapi_Fileapi
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    initFields
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_initFields
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    CreateFileW
 * Signature: (Ljava/lang/String;IILde/ibapl/jnhw/winapi/Minwinbase/SECURITY_ATTRIBUTES;IILde/ibapl/jnhw/winapi/Winnt/HANDLE;)Lde/ibapl/jnhw/winapi/Winnt/HANDLE;
 */
JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_CreateFileW
  (JNIEnv *, jclass, jstring, jint, jint, jobject, jint, jint, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    FlushFileBuffers
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_FlushFileBuffers
  (JNIEnv *, jclass, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    ReadFile
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;[BII)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2_3BII
  (JNIEnv *, jclass, jobject, jbyteArray, jint, jint);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    ReadFile
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/common/memory/OpaqueMemory32;II)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2Lde_ibapl_jnhw_common_memory_OpaqueMemory32_2II
  (JNIEnv *, jclass, jobject, jobject, jint, jint);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    ReadFile
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/common/memory/OpaqueMemory64;JI)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2Lde_ibapl_jnhw_common_memory_OpaqueMemory64_2JI
  (JNIEnv *, jclass, jobject, jobject, jlong, jint);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    ReadFile
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/common/references/ByteRef;)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2Lde_ibapl_jnhw_common_references_ByteRef_2
  (JNIEnv *, jclass, jobject, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    ReadFile
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/common/memory/OpaqueMemory32;IILde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2Lde_ibapl_jnhw_common_memory_OpaqueMemory32_2IILde_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED_2
  (JNIEnv *, jclass, jobject, jobject, jint, jint, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    ReadFile
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/common/memory/OpaqueMemory64;JILde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2Lde_ibapl_jnhw_common_memory_OpaqueMemory64_2JILde_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED_2
  (JNIEnv *, jclass, jobject, jobject, jlong, jint, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    ReadFileEx
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/common/memory/OpaqueMemory32;IILde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;Lde/ibapl/jnhw/winapi/Minwinbase/LPOVERLAPPED_COMPLETION_ROUTINE;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFileEx__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2Lde_ibapl_jnhw_common_memory_OpaqueMemory32_2IILde_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED_2Lde_ibapl_jnhw_winapi_Minwinbase_LPOVERLAPPED_1COMPLETION_1ROUTINE_2
  (JNIEnv *, jclass, jobject, jobject, jint, jint, jobject, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    ReadFileEx
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/common/memory/OpaqueMemory64;JILde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;Lde/ibapl/jnhw/winapi/Minwinbase/LPOVERLAPPED_COMPLETION_ROUTINE;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFileEx__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2Lde_ibapl_jnhw_common_memory_OpaqueMemory64_2JILde_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED_2Lde_ibapl_jnhw_winapi_Minwinbase_LPOVERLAPPED_1COMPLETION_1ROUTINE_2
  (JNIEnv *, jclass, jobject, jobject, jlong, jint, jobject, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    ReadFile_ArgsOK
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Ljava/nio/ByteBuffer;II)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile_1ArgsOK__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2Ljava_nio_ByteBuffer_2II
  (JNIEnv *, jclass, jobject, jobject, jint, jint);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    ReadFile_ArgsOK
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Ljava/nio/ByteBuffer;IILde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile_1ArgsOK__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2Ljava_nio_ByteBuffer_2IILde_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED_2
  (JNIEnv *, jclass, jobject, jobject, jint, jint, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    ReadFileEx_ArgsOK
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Ljava/nio/ByteBuffer;IILde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;Lde/ibapl/jnhw/winapi/Minwinbase/LPOVERLAPPED_COMPLETION_ROUTINE;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFileEx_1ArgsOK
  (JNIEnv *, jclass, jobject, jobject, jint, jint, jobject, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    WriteFile
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;[BII)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2_3BII
  (JNIEnv *, jclass, jobject, jbyteArray, jint, jint);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    WriteFile
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/common/memory/OpaqueMemory32;II)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2Lde_ibapl_jnhw_common_memory_OpaqueMemory32_2II
  (JNIEnv *, jclass, jobject, jobject, jint, jint);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    WriteFile
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/common/memory/OpaqueMemory64;JI)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2Lde_ibapl_jnhw_common_memory_OpaqueMemory64_2JI
  (JNIEnv *, jclass, jobject, jobject, jlong, jint);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    WriteFile
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;B)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2B
  (JNIEnv *, jclass, jobject, jbyte);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    WriteFile
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/common/memory/OpaqueMemory32;IILde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2Lde_ibapl_jnhw_common_memory_OpaqueMemory32_2IILde_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED_2
  (JNIEnv *, jclass, jobject, jobject, jint, jint, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    WriteFile
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/common/memory/OpaqueMemory64;JILde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2Lde_ibapl_jnhw_common_memory_OpaqueMemory64_2JILde_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED_2
  (JNIEnv *, jclass, jobject, jobject, jlong, jint, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    WriteFileEx
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/common/memory/OpaqueMemory32;IILde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;Lde/ibapl/jnhw/winapi/Minwinbase/LPOVERLAPPED_COMPLETION_ROUTINE;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFileEx__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2Lde_ibapl_jnhw_common_memory_OpaqueMemory32_2IILde_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED_2Lde_ibapl_jnhw_winapi_Minwinbase_LPOVERLAPPED_1COMPLETION_1ROUTINE_2
  (JNIEnv *, jclass, jobject, jobject, jint, jint, jobject, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    WriteFileEx
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/common/memory/OpaqueMemory64;JILde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;Lde/ibapl/jnhw/winapi/Minwinbase/LPOVERLAPPED_COMPLETION_ROUTINE;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFileEx__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2Lde_ibapl_jnhw_common_memory_OpaqueMemory64_2JILde_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED_2Lde_ibapl_jnhw_winapi_Minwinbase_LPOVERLAPPED_1COMPLETION_1ROUTINE_2
  (JNIEnv *, jclass, jobject, jobject, jlong, jint, jobject, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    WriteFile_ArgsOK
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Ljava/nio/ByteBuffer;II)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile_1ArgsOK__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2Ljava_nio_ByteBuffer_2II
  (JNIEnv *, jclass, jobject, jobject, jint, jint);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    WriteFile_ArgsOK
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Ljava/nio/ByteBuffer;IILde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile_1ArgsOK__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2Ljava_nio_ByteBuffer_2IILde_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED_2
  (JNIEnv *, jclass, jobject, jobject, jint, jint, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    WriteFileEx_ArgsOK
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Ljava/nio/ByteBuffer;IILde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;Lde/ibapl/jnhw/winapi/Minwinbase/LPOVERLAPPED_COMPLETION_ROUTINE;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFileEx_1ArgsOK
  (JNIEnv *, jclass, jobject, jobject, jint, jint, jobject, jobject);

#ifdef __cplusplus
}
#endif
#endif
