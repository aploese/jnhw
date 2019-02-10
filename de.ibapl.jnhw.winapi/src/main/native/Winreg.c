#include <config.h>
#include "jnhw.h"

#ifdef HAVE_MARKER_H
#include <windows.h>

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     de_ibapl_jnhw_winapi_Winreg
 * Method:    HKEY_LOCAL_MACHINE
 * Signature: ()Lde/ibapl/jnhw/winapi/Minwindef/HKEY;
 */
JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Winreg_HKEY_1LOCAL_1MACHINE
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_winapi_Winreg
 * Method:    RegEnumValueW
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HKEY;ILde/ibapl/jnhw/winapi/Minwindef/LPWSTR;Lde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/winapi/Minwindef/LPBYTE;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winreg_RegEnumValueW
  (JNIEnv *, jclass, jobject, jint, jobject, jobject, jobject);

/*
 * Class:     de_ibapl_jnhw_winapi_Winreg
 * Method:    RegOpenKeyExW
 * Signature: (Lde/ibapl/jnhw/winapi/Minwindef/HKEY;Ljava/lang/String;ILde/ibapl/jnhw/winapi/Winreg/REGSAM;Lde/ibapl/jnhw/winapi/Minwindef/PHKEY;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winreg_RegOpenKeyExW
  (JNIEnv *, jclass, jobject, jstring, jint, jobject, jobject);

#ifdef __cplusplus
}
#endif
#endif
