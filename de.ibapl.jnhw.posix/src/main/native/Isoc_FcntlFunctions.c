#include <config.h>
#include "jnhw.h"

#ifdef HAVE_FCNTL_H

#include "de_ibapl_jnhw_isoc_Fcntl.h"
#include <fcntl.h>
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_isoc_Fcntl
     * Method:    creat
     * Signature: (Ljava/lang/CharSequence;I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_isoc_Fcntl_creat
    (JNIEnv *env, jclass clazz, jobject file, jint mode) {
        if (file == NULL) {
            throw_NullPointerException(env, "file is null.");
            return -1;
        }
        const char* _file = (*env)->GetStringUTFChars(env, file, NULL);
        int result = creat(_file, mode);
        (*env)->ReleaseStringUTFChars(env, file, _file);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_isoc_Fcntl
     * Method:    open
     * Signature: (Ljava/lang/CharSequence;I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_isoc_Fcntl_open
    (JNIEnv *env, jclass clazz, jobject file, jint oflag) {
        if (file == NULL) {
            throw_NullPointerException(env, "file is null.");
            return -1;
        }

        const char* _file = (*env)->GetStringUTFChars(env, file, NULL);
        int result = open(_file, oflag);
        (*env)->ReleaseStringUTFChars(env, file, _file);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

#ifdef __cplusplus
}
#endif
#endif