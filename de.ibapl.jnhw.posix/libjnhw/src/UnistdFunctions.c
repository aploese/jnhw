#include "jnhw.h"

#include "de_ibapl_jnhw_posix_Unistd.h"
#include <unistd.h>
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    static jfieldID de_ibapl_jnhw_posix_Unistd_IntRef_value = NULL;

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    initNative
     * Signature: (Ljava/lang/Class;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Unistd_initNative
    (JNIEnv *env, jclass clazz, jclass intRef_Class) {
        de_ibapl_jnhw_posix_Unistd_IntRef_value = (*env)->GetFieldID(env,
                intRef_Class, "value", "I");
        if (de_ibapl_jnhw_posix_Unistd_IntRef_value == NULL) {
            throwException(env, UnsatisfiedLinkException, "Get FieldID of IntRef.value");
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    pipe
     * Signature: (Lde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/IntRef;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_pipe
    (JNIEnv *env, jclass clazz, jobject read_fd_ref, jobject write_fd_ref) {
        int fdes[2];
        int result = pipe(fdes);
        (*env)->SetIntField(env, read_fd_ref, de_ibapl_jnhw_posix_Unistd_IntRef_value, fdes[0]);
        (*env)->SetIntField(env, write_fd_ref, de_ibapl_jnhw_posix_Unistd_IntRef_value, fdes[1]);
        if (result < 0) {
            throwNativeError(env, errno);
        }
        return result;

    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    close
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_close
    (JNIEnv *env, jclass clazz, jint fd) {
        int result = close(fd);
        if (result < 0) {
            throwNativeError(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    read
     * Signature: (I[BII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_read__I_3BII
    (JNIEnv *env, jclass clazz, jint fd, jbyteArray buf, jint pos, jint len) {
        jbyte _buf[len];
        int result = read(fd, &_buf, len);
        if (result < 0) {
            throwNativeError(env, errno);
        }
        (*env)->SetByteArrayRegion(env, buf, pos, result, _buf);
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    read
     * Signature: (ILjava/nio/ByteBuffer;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_read__ILjava_nio_ByteBuffer_2II
    (JNIEnv *env, jclass clazz, jint fd, jobject byteBuffer, jint pos, jint len) {
        long result = read(fd, (*env)->GetDirectBufferAddress(env, byteBuffer) + pos, len);
        if (result < 0) {
            throwNativeError(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    write
     * Signature: (I[BII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_write__I_3BII
    (JNIEnv *env, jclass clazz, jint fd, jbyteArray buf, jint pos, jint len) {
        jbyte _buf[len];
        (*env)->GetByteArrayRegion(env, buf, pos, len, _buf);
        if ((*env)->ExceptionOccurred(env)) {
            return -1;
        }
        int result = write(fd, &_buf, len);
        if (result < 0) {
            throwNativeError(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    write
     * Signature: (ILjava/nio/ByteBuffer;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_write__ILjava_nio_ByteBuffer_2II
    (JNIEnv *env, jclass clazz, jint fd, jobject byteBuffer, jint pos, jint len) {
        long result = write(fd, (*env)->GetDirectBufferAddress(env, byteBuffer) + pos, len);
        if (result < 0) {
            throwNativeError(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    usleep
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_usleep
    (JNIEnv *env, jclass clazz, jint usec) {
        int result = usleep(usec);
        if (result < 0) {
            throwNativeError(env, errno);
        }
        return result;
    }

#ifdef __cplusplus
}
#endif
