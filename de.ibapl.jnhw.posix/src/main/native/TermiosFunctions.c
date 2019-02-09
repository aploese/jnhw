#include <config.h>
#include "jnhw.h"

#ifdef HAVE_TERMIOS_H

#include "de_ibapl_jnhw_posix_Termios.h"
#include <termios.h>
#include <errno.h>
#include <stdint.h>


#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfgetispeed
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_cfgetispeed
    (JNIEnv *env, jclass clazz, jlong termiosBaseAddress) {
        return cfgetispeed((void*)(uintptr_t)termiosBaseAddress);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfgetospeed
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_cfgetospeed
    (JNIEnv *env, jclass clazz, jlong termiosBaseAddress) {
        return cfgetospeed((void*)(uintptr_t)termiosBaseAddress);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfsetispeed
     * Signature: (JI)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_cfsetispeed
    (JNIEnv *env, jclass clazz, jlong termiosBaseAddress, jint speed) {
        int result = cfsetispeed((void*)(uintptr_t)termiosBaseAddress, speed);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfsetospeed
     * Signature: (JI)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_cfsetospeed
    (JNIEnv *env, jclass clazz, jlong termiosBaseAddress, jint speed) {
        int result = cfsetospeed((void*)(uintptr_t)termiosBaseAddress, speed);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    tcdrain
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_tcdrain
    (JNIEnv *env, jclass clazz, jint fildes) {
        int result = tcdrain(fildes);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    tcflush
     * Signature: (II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_tcflush
    (JNIEnv *env, jclass clazz, jint fildes, jint queue_selector) {
        int result = tcflush(fildes, queue_selector);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    tcgetattr
     * Signature: (IJ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_tcgetattr
    (JNIEnv *env, jclass clazz, jint fildes, jlong termiosBaseAddress) {
        int result = tcgetattr(fildes, (void*)(uintptr_t)termiosBaseAddress);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    tcsendbreak
     * Signature: (II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_tcsendbreak
    (JNIEnv *env, jclass clazz, jint fildes, jint duration) {
        int result = tcsendbreak(fildes, duration);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    tcsetattr
     * Signature: (IIJ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_tcsetattr
    (JNIEnv *env, jclass clazz, jint fildes, jint optional_actions, jlong termiosBaseAddress) {
        int result = tcsetattr(fildes, optional_actions, (void*)(uintptr_t)termiosBaseAddress);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    cfsetspeed
     * Signature: (JI)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_cfsetspeed
    (JNIEnv *env, jclass clazz, jlong termiosBaseAddress, jint speed) {
        int result = cfsetspeed((void*)(uintptr_t)termiosBaseAddress, speed);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

#ifdef __cplusplus
}
#endif
#endif
