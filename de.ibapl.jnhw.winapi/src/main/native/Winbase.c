#include <config.h>
#include "jnhw.h"

#ifdef HAVE_MARKER_H
#include <windows.h>

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    WAIT_FAILED
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_WAIT_1FAILED
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    WAIT_OBJECT_0
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_WAIT_1OBJECT_10
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    WAIT_ABANDONED
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_WAIT_1ABANDONED
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    WAIT_TIMEOUT
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_WAIT_1TIMEOUT
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    FILE_FLAG_OVERLAPPED
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1FLAG_1OVERLAPPED
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    RTS_CONTROL_DISABLE
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_RTS_1CONTROL_1DISABLE
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    RTS_CONTROL_HANDSHAKE
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_RTS_1CONTROL_1HANDSHAKE
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    INVALID_HANDLE_VALUE
 * Signature: ()Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;
 */
JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Winbase_INVALID_1HANDLE_1VALUE
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    CloseHandle
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_CloseHandle
  (JNIEnv *, jclass, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    ClearCommBreak
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ClearCommBreak
  (JNIEnv *, jclass, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    ClearCommError
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;Lde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/winapi/Winbase/COMSTAT;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ClearCommError
  (JNIEnv *, jclass, jobject, jobject, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    EscapeCommFunction
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;I)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_EscapeCommFunction
  (JNIEnv *, jclass, jobject, jint);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    GetCommModemStatus
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;Lde/ibapl/jnhw/IntRef;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_GetCommModemStatus
  (JNIEnv *, jclass, jobject, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    GetCommState
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;Lde/ibapl/jnhw/winapi/Winbase/DCB;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_GetCommState
  (JNIEnv *, jclass, jobject, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    GetCommTimeouts
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;Lde/ibapl/jnhw/winapi/Winbase/COMMTIMEOUTS;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_GetCommTimeouts
  (JNIEnv *, jclass, jobject, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    SetCommBreak
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SetCommBreak
  (JNIEnv *, jclass, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    SetCommState
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;Lde/ibapl/jnhw/winapi/Winbase/DCB;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SetCommState
  (JNIEnv *, jclass, jobject, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    SetCommTimeouts
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;Lde/ibapl/jnhw/winapi/Winbase/COMMTIMEOUTS;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SetCommTimeouts
  (JNIEnv *, jclass, jobject, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    NOPARITY
 * Signature: ()B
 */
JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_NOPARITY
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    ODDPARITY
 * Signature: ()B
 */
JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ODDPARITY
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    EVENPARITY
 * Signature: ()B
 */
JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_EVENPARITY
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    MARKPARITY
 * Signature: ()B
 */
JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_MARKPARITY
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    SPACEPARITY
 * Signature: ()B
 */
JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SPACEPARITY
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    ONESTOPBIT
 * Signature: ()B
 */
JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ONESTOPBIT
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    ONE5STOPBITS
 * Signature: ()B
 */
JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ONE5STOPBITS
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    TWOSTOPBITS
 * Signature: ()B
 */
JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_TWOSTOPBITS
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    INFINITE
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_INFINITE
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    SETRTS
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SETRTS
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    CLRRTS
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_CLRRTS
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    SETDTR
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SETDTR
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    CLRDTR
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_CLRDTR
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    SETBREAK
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SETBREAK
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    CLRBREAK
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_CLRBREAK
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    MS_CTS_ON
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_MS_1CTS_1ON
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    MS_DSR_ON
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_MS_1DSR_1ON
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    MS_RING_ON
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_MS_1RING_1ON
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    MS_RLSD_ON
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_MS_1RLSD_1ON
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    GetLastError
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_GetLastError
  (JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif
