/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
#include "jnhw-posix.h"

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    HAVE_TERMIOS_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Termios_HAVE_1TERMIOS_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
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
     * Method:    _HAVE_STRUCT_TERMIOS_C_ISPEED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios__1HAVE_1STRUCT_1TERMIOS_1C_1ISPEED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) &&  !defined(__mips__)
        return _HAVE_STRUCT_TERMIOS_C_ISPEED;
#elif defined(_HAVE_STRUCT_TERMIOS_C_ISPEED)
#error "_HAVE_STRUCT_TERMIOS_C_ISPEED defined"
#else
        throw_NotDefinedException(env, "_HAVE_STRUCT_TERMIOS_C_ISPEED");
        return 0;
#endif
}

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    _HAVE_STRUCT_TERMIOS_C_OSPEED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios__1HAVE_1STRUCT_1TERMIOS_1C_1OSPEED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) &&  !defined(__mips__)
        return _HAVE_STRUCT_TERMIOS_C_OSPEED;
#elif defined(_HAVE_STRUCT_TERMIOS_C_OSPEED)
#error "_HAVE_STRUCT_TERMIOS_C_OSPEED defined"
#else
        throw_NotDefinedException(env, "_HAVE_STRUCT_TERMIOS_C_OSPEED");
        return 0;
#endif
}

        /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B0
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B0;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B50
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B50
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B50;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B75
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B75
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B75;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B110
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B110
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B110;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B134
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B134
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B134;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B150
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B150
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B150;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B200
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B200
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B200;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B300
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B300
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B300;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B600
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B600
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B600;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B1200
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B1200
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B1200;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B1800
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B1800
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B1800;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B2400
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B2400
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B2400;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B4800
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B4800
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B4800;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B9600
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B9600
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B9600;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B19200
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B19200
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B19200;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B38400
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B38400
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B38400;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B57600
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B57600
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B57600;
}

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B115200
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B115200
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B115200;
}

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B230400
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B230400
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return B230400;
}

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    B460800
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_B460800
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__FreeBSD__)
        return B460800;
#elif defined(B460800)
#error "B460800 defined"
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
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return B500000;
#elif defined(B500000)
#error "B500000 defined"
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
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return B576000;
#elif defined(B576000)
#error "B576000 defined"
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
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined (__FreeBSD__)
        return B921600;
#elif defined(B921600)
#error "B921600 defined"
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
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return B1000000;
#elif defined(B1000000)
#error "B1000000 defined"
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
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return B1152000;
#elif defined(B1152000)
#error "B1152000 defined"
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
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return B1500000;
#elif defined(B1500000)
#error "B1500000 defined"
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
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return B2000000;
#elif defined(B2000000)
#error "B2000000 defined"
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
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return B2500000;
#elif defined(B2500000)
#error "B2500000 defined"
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
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return B3000000;
#elif defined(B3000000)
#error "B3000000 defined"
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
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return B3500000;
#elif defined(B3500000)
#error "B3500000 defined"
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
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return B4000000;
#elif defined(B4000000)
#error "B4000000 defined"
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
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLOCAL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CMSPAR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CMSPAR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__linux__) &&  !defined(__mips__)
        return CMSPAR;
#elif defined(CMSPAR)
#error "CMSPAR defined"
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
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CREAD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CRTSCTS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CRTSCTS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (signed)CRTSCTS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CS5
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CS5
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CS5;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CS6
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CS6
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CS6;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CS7
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CS7
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CS7;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CS8
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CS8
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CS8;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CSIZE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CSIZE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CSIZE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    CSTOPB
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_CSTOPB
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CSTOPB;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    INPCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_INPCK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return INPCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    IXOFF
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_IXOFF
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return IXOFF;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    IXON
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_IXON
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return IXON;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    PARENB
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_PARENB
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return PARENB;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    PAREXT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_PAREXT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        //placeholder
#if defined(PAREXT)
#error "PAREXT defined"
#else
        throw_NotDefinedException(env, "PAREXT");
        return 0;
#endif
}

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    PARMRK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_PARMRK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return PARMRK;
}

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    PARODD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_PARODD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return PARODD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TCIOFLUSH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TCIOFLUSH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCIOFLUSH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    TCSANOW
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_TCSANOW
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TCSANOW;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VMIN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VMIN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VMIN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VSTART
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VSTART
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VSTART;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VSTOP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VSTOP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VSTOP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    VTIME
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_VTIME
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return VTIME;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    NCCS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_NCCS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return NCCS;
    }

#ifdef __cplusplus
}
#endif
#endif
