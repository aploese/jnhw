#include <config.h>
#include "jnhw.h"

#ifdef HAVE_MARKER_H

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     de_ibapl_jnhw_winapi_Synchapi
 * Method:    WaitForSingleObject
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;J)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_WaitForSingleObject
  (JNIEnv *, jclass, jobject, jlong);

/*
 * Class:     de_ibapl_jnhw_winapi_Synchapi
 * Method:    CreateEventW
 * Signature: (Lde/ibapl/jnhw/winapi/Minwinbase/SECURITY_ATTRIBUTES;ZZLjava/lang/String;)Lde/ibapl/jnhw/winapi/Minwindef/HANDLE;
 */
JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_CreateEventW
  (JNIEnv *, jclass, jobject, jboolean, jboolean, jstring);

#ifdef __cplusplus
}
#endif
#endif
