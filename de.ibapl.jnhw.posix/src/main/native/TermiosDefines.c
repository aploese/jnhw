#include <config.h>
#include "jnhw.h"

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    HAVE_TERMIOS_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Termios_HAVE_1TERMIOS_1H
    (JNIEnv *env, jclass clazz) {
#ifdef HAVE_TERMIOS_H
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

#ifdef HAVE_TERMIOS_H

#include "de_ibapl_jnhw_posix_Termios.h"
#include <termios.h>
#include <errno.h>


    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B0
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B0
    (JNIEnv *env, jclass clazz) {
        return B0;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B50
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B50
    (JNIEnv *env, jclass clazz) {
        return B50;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B75
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B75
    (JNIEnv *env, jclass clazz) {
        return B75;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B110
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B110
    (JNIEnv *env, jclass clazz) {
        return B110;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B134
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B134
    (JNIEnv *env, jclass clazz) {
        return B134;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B150
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B150
    (JNIEnv *env, jclass clazz) {
        return B150;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B200
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B200
    (JNIEnv *env, jclass clazz) {
        return B200;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B300
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B300
    (JNIEnv *env, jclass clazz) {
        return B300;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B600
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B600
    (JNIEnv *env, jclass clazz) {
        return B600;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B1200
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B1200
    (JNIEnv *env, jclass clazz) {
        return B1200;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B1800
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B1800
    (JNIEnv *env, jclass clazz) {
        return B1800;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B2400
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B2400
    (JNIEnv *env, jclass clazz) {
        return B2400;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B4800
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B4800
    (JNIEnv *env, jclass clazz) {
        return B4800;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B9600
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B9600
    (JNIEnv *env, jclass clazz) {
        return B9600;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B19200
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B19200
    (JNIEnv *env, jclass clazz) {
        return B19200;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B38400
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B38400
    (JNIEnv *env, jclass clazz) {
        return B38400;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B57600
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B57600
    (JNIEnv *env, jclass clazz) {
#ifdef B57600
        return B57600;
#else
        throw_NotDefinedException(env, "B57600");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B115200
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B115200
    (JNIEnv *env, jclass clazz) {
#ifdef B115200
        return B115200;
#else
        throw_NotDefinedException(env, "B115200");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B230400
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B230400
    (JNIEnv *env, jclass clazz) {
#ifdef B230400
        return B230400;
#else
        throw_NotDefinedException(env, "B230400");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B460800
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B460800
    (JNIEnv *env, jclass clazz) {
#ifdef B460800
        return B460800;
#else
        throw_NotDefinedException(env, "B460800");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B500000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B500000
    (JNIEnv *env, jclass clazz) {
#ifdef B500000
        return B500000;
#else
        throw_NotDefinedException(env, "B500000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B576000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B576000
    (JNIEnv *env, jclass clazz) {
#ifdef B576000
        return B576000;
#else
        throw_NotDefinedException(env, "B576000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B921600
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B921600
    (JNIEnv *env, jclass clazz) {
#ifdef B921600
        return B921600;
#else
        throw_NotDefinedException(env, "B921600");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B1000000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B1000000
    (JNIEnv *env, jclass clazz) {
#ifdef B1000000
        return B1000000;
#else
        throw_NotDefinedException(env, "B1000000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B1152000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B1152000
    (JNIEnv *env, jclass clazz) {
#ifdef B1152000
        return B1152000;
#else
        throw_NotDefinedException(env, "B1152000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B1500000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B1500000
    (JNIEnv *env, jclass clazz) {
#ifdef B1500000
        return B1500000;
#else
        throw_NotDefinedException(env, "B1500000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B2000000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B2000000
    (JNIEnv *env, jclass clazz) {
#ifdef B2000000
        return B2000000;
#else
        throw_NotDefinedException(env, "B2000000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B2500000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B2500000
    (JNIEnv *env, jclass clazz) {
#ifdef B2500000
        return B2500000;
#else
        throw_NotDefinedException(env, "B2500000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B3000000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B3000000
    (JNIEnv *env, jclass clazz) {
#ifdef B3000000
        return B3000000;
#else
        throw_NotDefinedException(env, "B3000000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B3500000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B3500000
    (JNIEnv *env, jclass clazz) {
#ifdef B3500000
        return B3500000;
#else
        throw_NotDefinedException(env, "B3500000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B4000000
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B4000000
    (JNIEnv *env, jclass clazz) {
#ifdef B4000000
        return B4000000;
#else
        throw_NotDefinedException(env, "B4000000");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CLOCAL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CLOCAL
    (JNIEnv *env, jclass clazz) {
        return CLOCAL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CMSPAR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CMSPAR
    (JNIEnv *env, jclass clazz) {
#ifdef CMSPAR
        return CMSPAR;
#else
        throw_NotDefinedException(env, "CMSPAR");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CREAD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CREAD
    (JNIEnv *env, jclass clazz) {
        return CREAD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CRTSCTS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CRTSCTS
    (JNIEnv *env, jclass clazz) {
        return CRTSCTS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CS5
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CS5
    (JNIEnv *env, jclass clazz) {
        return CS5;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CS6
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CS6
    (JNIEnv *env, jclass clazz) {
        return CS6;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CS7
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CS7
    (JNIEnv *env, jclass clazz) {
        return CS7;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CS8
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CS8
    (JNIEnv *env, jclass clazz) {
        return CS8;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CSIZE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CSIZE
    (JNIEnv *env, jclass clazz) {
        return CSIZE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CSTOPB
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CSTOPB
    (JNIEnv *env, jclass clazz) {
        return CSTOPB;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    INPCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_INPCK
    (JNIEnv *env, jclass clazz) {
        return INPCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    IXOFF
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_IXOFF
    (JNIEnv *env, jclass clazz) {
        return IXOFF;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    IXON
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_IXON
    (JNIEnv *env, jclass clazz) {
        return IXON;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    PARENB
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_PARENB
    (JNIEnv *env, jclass clazz) {
        return PARENB;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    PAREXT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_PAREXT
    (JNIEnv *env, jclass clazz) {
#ifdef PAREXT
        return PAREXT;
#else
        throw_NotDefinedException(env, "PAREXT");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    PARODD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_PARODD
    (JNIEnv *env, jclass clazz) {
        return PARODD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TCIOFLUSH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TCIOFLUSH
    (JNIEnv *env, jclass clazz) {
        return TCIOFLUSH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TCSANOW
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TCSANOW
    (JNIEnv *env, jclass clazz) {
        return TCSANOW;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VMIN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VMIN
    (JNIEnv *env, jclass clazz) {
        return VMIN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VSTART
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VSTART
    (JNIEnv *env, jclass clazz) {
        return VSTART;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VSTOP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VSTOP
    (JNIEnv *env, jclass clazz) {
        return VSTOP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VTIME
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VTIME
    (JNIEnv *env, jclass clazz) {
        return VTIME;
    }

        /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    NCCS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_NCCS
    (JNIEnv *env, jclass clazz) {
        return NCCS;
    }

#ifdef __cplusplus
}
#endif
#endif