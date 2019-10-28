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

#if HAVE_UNISTD_H
#include <unistd.h>
// include POSIX OH (Optional Header) as well, to make FreeBSD happy. 
#include <sys/stat.h>
#endif

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    HAVE_FCNTL_H
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Fcntl_HAVE_1FCNTL_1H
(JNIEnv *env, jclass clazz) {
#ifdef _POSIX_VERSION
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}


#ifdef _POSIX_VERSION

#include "de_ibapl_jnhw_posix_Fcntl.h"
#include <fcntl.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_RDONLY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1RDONLY
    (JNIEnv *env, jclass clazz) {
        return O_RDONLY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_WRONLY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1WRONLY
    (JNIEnv *env, jclass clazz) {
        return O_WRONLY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_RDWR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1RDWR
    (JNIEnv *env, jclass clazz) {
        return O_RDWR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_EXEC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1EXEC
    (JNIEnv *env, jclass clazz) {
#ifdef O_EXEC
        return O_EXEC;
#else
        throw_NotDefinedException(env, "O_EXEC");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_SEARCH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1SEARCH
    (JNIEnv *env, jclass clazz) {
#ifdef O_SEARCH
        return O_SEARCH;
#else
        throw_NotDefinedException(env, "O_SEARCH");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_APPEND
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1APPEND
    (JNIEnv *env, jclass clazz) {
        return O_APPEND;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_CLOEXEC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1CLOEXEC
    (JNIEnv *env, jclass clazz) {
        return O_CLOEXEC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_CREAT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1CREAT
    (JNIEnv *env, jclass clazz) {
        return O_CREAT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_DIRECTORY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1DIRECTORY
    (JNIEnv *env, jclass clazz) {
        return O_DIRECTORY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_EXCL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1EXCL
    (JNIEnv *env, jclass clazz) {
        return O_EXCL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_NOCTTY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1NOCTTY
    (JNIEnv *env, jclass clazz) {
        return O_NOCTTY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_NOFOLLOW
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1NOFOLLOW
    (JNIEnv *env, jclass clazz) {
        return O_NOFOLLOW;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_NONBLOCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1NONBLOCK
    (JNIEnv *env, jclass clazz) {
        return O_NONBLOCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_SYNC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1SYNC
    (JNIEnv *env, jclass clazz) {
        return O_SYNC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_TRUNC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1TRUNC
    (JNIEnv *env, jclass clazz) {
        return O_TRUNC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_TTY_INIT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1TTY_1INIT
    (JNIEnv *env, jclass clazz) {
#ifdef O_TTY_INIT
        return O_TTY_INIT;
#else
        throw_NotDefinedException(env, "O_TTY_INIT");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_DSYNC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1DSYNC
    (JNIEnv *env, jclass clazz) {
#ifdef O_DSYNC
        return O_DSYNC;
#else
        throw_NotDefinedException(env, "O_DSYNC");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_RSYNC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1RSYNC
    (JNIEnv *env, jclass clazz) {
#ifdef O_RSYNC
        return O_RSYNC;
#else
        throw_NotDefinedException(env, "O_RSYNC");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_FSYNC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1FSYNC
    (JNIEnv *env, jclass clazz) {
#ifdef O_FSYNC
        return O_FSYNC;
#else
        throw_NotDefinedException(env, "O_FSYNC");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_ASYNC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1ASYNC
    (JNIEnv *env, jclass clazz) {
#ifdef O_ASYNC
        return O_ASYNC;
#else
        throw_NotDefinedException(env, "O_ASYNC");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_ACCMODE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1ACCMODE
    (JNIEnv *env, jclass clazz) {
        return O_ACCMODE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_DUPFD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1DUPFD
    (JNIEnv *env, jclass clazz) {
        return F_DUPFD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_DUPFD_CLOEXEC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1DUPFD_1CLOEXEC
    (JNIEnv *env, jclass clazz) {
        return F_DUPFD_CLOEXEC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_GETFD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1GETFD
    (JNIEnv *env, jclass clazz) {
        return F_GETFD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_SETFD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1SETFD
    (JNIEnv *env, jclass clazz) {
        return F_SETFD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_GETFL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1GETFL
    (JNIEnv *env, jclass clazz) {
        return F_GETFL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_SETFL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1SETFL
    (JNIEnv *env, jclass clazz) {
        return F_SETFL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_GETOWN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1GETOWN
    (JNIEnv *env, jclass clazz) {
        return F_GETOWN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_SETOWN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1SETOWN
    (JNIEnv *env, jclass clazz) {
        return F_SETOWN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    FNONBLOCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_FNONBLOCK
    (JNIEnv *env, jclass clazz) {
        return FNONBLOCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    FD_CLOEXEC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_FD_1CLOEXEC
    (JNIEnv *env, jclass clazz) {
        return FD_CLOEXEC;
    }

#ifdef __cplusplus
}
#endif
#endif