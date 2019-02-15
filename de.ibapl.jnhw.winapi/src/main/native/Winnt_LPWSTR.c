#include "../../../config.h"
#include "jnhw.h"
#include "de_ibapl_jnhw_winapi_Winnt.h"

#ifdef HAVE_WINNT_H
#include <windows.h>
#include <winnt.h>

#ifdef __cplusplus
extern "C" {
#endif

 /*
 * Class:     de_ibapl_jnhw_winapi_Winnt_LPWSTR
 * Method:    getString
 * Signature: (JI)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_winapi_Winnt_00024LPWSTR_getString
  (JNIEnv *env, jclass clazz, jlong baseAddress, jint len) {
    return (*env)->NewString(env, (jchar*)(uintptr_t)baseAddress, len);
}


#ifdef __cplusplus
}
#endif
#endif