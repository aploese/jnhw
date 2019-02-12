#include <config.h>
#include "jnhw.h"

#ifdef HAVE_WINNT_H
#include <windows.h>
#include "de_ibapl_jnhw_winapi_Winnt.h"
#include <winnt.h>

#ifdef __cplusplus
extern "C" {
#endif

 /*
 * Class:     de_ibapl_jnhw_winapi_Winnt_LPWSTR
 * Method:    getNullString
 * Signature: (JI)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_winapi_Winnt_00024LPWSTR_getNullString
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    size_t len = wcslen((jchar*)(uintptr_t)baseAddress);
    return (*env)->NewString(env, (jchar*)(uintptr_t)baseAddress, len);
}


#ifdef __cplusplus
}
#endif
#endif