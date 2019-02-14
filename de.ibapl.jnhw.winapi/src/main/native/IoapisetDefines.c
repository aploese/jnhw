#include <config.h>
#include "jnhw.h"

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_winapi_Ioapiset
 * Method:    HAVE_IOAPISET_H
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Ioapiset_HAVE_1IOAPISET_1H
  (JNIEnv *env, jclass clazz) {
#ifdef HAVE_IOAPISET_H
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}

#ifdef HAVE_IOAPISET_H
#include <windows.h>
#include <ioapiset.h>

#endif
#ifdef __cplusplus
}
#endif

