#include <config.h>
#include "jnhw.h"

#ifdef HAVE_WINBASE_H
#include <windows.h>

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    CloseHandle
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_CloseHandle
  (JNIEnv *, jclass, jobject) {
    
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    ClearCommBreak
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ClearCommBreak
  (JNIEnv *, jclass, jobject) {
    
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    ClearCommError
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;Lde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/winapi/Winbase/COMSTAT;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ClearCommError
  (JNIEnv *, jclass, jobject, jobject, jobject) {
    
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    EscapeCommFunction
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;I)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_EscapeCommFunction
  (JNIEnv *, jclass, jobject, jint) {
    
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    GetCommModemStatus
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;Lde/ibapl/jnhw/IntRef;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_GetCommModemStatus
  (JNIEnv *, jclass, jobject, jobject) {
    
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    GetCommState
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;Lde/ibapl/jnhw/winapi/Winbase/DCB;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_GetCommState
  (JNIEnv *, jclass, jobject, jobject) {
    
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    GetCommTimeouts
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;Lde/ibapl/jnhw/winapi/Winbase/COMMTIMEOUTS;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_GetCommTimeouts
  (JNIEnv *, jclass, jobject, jobject) {
    
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    SetCommBreak
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SetCommBreak
  (JNIEnv *, jclass, jobject) {
    
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    SetCommState
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;Lde/ibapl/jnhw/winapi/Winbase/DCB;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SetCommState
  (JNIEnv *, jclass, jobject, jobject) {
    
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    SetCommTimeouts
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;Lde/ibapl/jnhw/winapi/Winbase/COMMTIMEOUTS;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SetCommTimeouts
  (JNIEnv *, jclass, jobject, jobject) {
    
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    GetLastError
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_GetLastError
  (JNIEnv *env, jclass clazz) {
    return ;
}

#ifdef __cplusplus
}
#endif
#endif
