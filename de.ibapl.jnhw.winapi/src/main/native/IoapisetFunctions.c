#include <config.h>
#include "jnhw.h"

#ifdef HAVE_IOAPISET_H
#include <windows.h>
#include <ioapiset.h>

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     de_ibapl_jnhw_winapi_Ioapiset
 * Method:    GetOverlappedResult
 * Signature: (JJLde/ibapl/jnhw/IntRef;Z)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Ioapiset_GetOverlappedResult
  (JNIEnv *env, jclass clazz, jlong hFile, jlong lpOverlapped, jobject lpNumberOfBytesTransferred, jboolean bWait) {
    
    DWORD _lpNumberOfBytesTransferred = (*env)->GetIntField(env, lpNumberOfBytesTransferred, de_ibapl_jnhw_IntRef_value_ID);

    BOOL result = GetOverlappedResult((HANDLE)(uintptr_t)hFile,
            (LPOVERLAPPED)(uintptr_t)lpOverlapped,
            &_lpNumberOfBytesTransferred,
            bWait);

    (*env)->SetIntField(env, lpNumberOfBytesTransferred, de_ibapl_jnhw_IntRef_value_ID, _lpNumberOfBytesTransferred);
    if (!result) {
            throw_NativeErrorException(env, GetLastError());
    }
}



#ifdef __cplusplus
}
#endif
#endif

