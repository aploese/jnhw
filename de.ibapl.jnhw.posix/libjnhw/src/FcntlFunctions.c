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
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    open
     * Signature: (Ljava/lang/CharSequence;I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_open
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

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    fcntl
     * Signature: (II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_fcntl__II
    (JNIEnv *env, jclass clazz, jint fd, jint cmd) {
        int result = fcntl(fd, cmd);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    fcntl
     * Signature: (III)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_fcntl__III
    (JNIEnv *env, jclass clazz, jint fd, jint cmd, jint vararg_0) {
        int result = fcntl(fd, cmd, vararg_0);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

#ifdef __cplusplus
}
#endif