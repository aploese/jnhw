#include "jnhw.h"

#include "de_ibapl_jnhw_posix_Fcntl.h"
#include <fcntl.h>
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    creat
     * Signature: (Ljava/lang/CharSequence;I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_creat
    (JNIEnv *env, jclass clazz, jobject file, jint mode) {
        const char* _file = (*env)->GetStringUTFChars(env, file, NULL);
        int result = creat(_file, mode);
        (*env)->ReleaseStringUTFChars(env, file, _file);
        if (result < 0) {
            throwNativeError(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    open
     * Signature: (Ljava/lang/CharSequence;I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_open
    (JNIEnv *env, jclass clazz, jobject file, jint oflag) {
        const char* _file = (*env)->GetStringUTFChars(env, file, NULL);
        int result = open(_file, oflag);
        (*env)->ReleaseStringUTFChars(env, file, _file);
        if (result < 0) {
            throwNativeError(env, errno);
        }
        return result;
    }
   
#ifdef __cplusplus
}
#endif