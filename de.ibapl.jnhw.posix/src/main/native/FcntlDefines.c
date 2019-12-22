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

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    HAVE_FCNTL_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Fcntl_HAVE_1FCNTL_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef _POSIX_VERSION
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

#ifdef __cplusplus
}
#endif

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
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return O_RDONLY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_WRONLY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1WRONLY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return O_WRONLY;
    }
    
    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    AT_FDCWD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_AT_1FDCWD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return AT_FDCWD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    AT_EACCESS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_AT_1EACCESS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return AT_EACCESS;
    }
    
    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    AT_SYMLINK_NOFOLLOW
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_AT_1SYMLINK_1NOFOLLOW
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return AT_SYMLINK_NOFOLLOW;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    AT_SYMLINK_FOLLOW
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_AT_1SYMLINK_1FOLLOW
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return AT_SYMLINK_FOLLOW;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    AT_REMOVEDIR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_AT_1REMOVEDIR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return AT_REMOVEDIR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    POSIX_FADV_DONTNEED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_POSIX_1FADV_1DONTNEED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__)
#if defined(POSIX_FADV_DONTNEED)
#error "POSIX_FADV_DONTNEED defined"
#endif
        throw_NotDefinedException(env, "POSIX_FADV_DONTNEED");
        return 0;
#else
        return POSIX_FADV_DONTNEED;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    POSIX_FADV_NOREUSE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_POSIX_1FADV_1NOREUSE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__)
#if defined(POSIX_FADV_NOREUSE)
#error "POSIX_FADV_NOREUSE defined"
#endif
        throw_NotDefinedException(env, "POSIX_FADV_NOREUSE");
        return 0;
#else
        return POSIX_FADV_NOREUSE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    POSIX_FADV_NORMAL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_POSIX_1FADV_1NORMAL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__)
#if defined(POSIX_FADV_NORMAL)
#error "POSIX_FADV_NORMAL defined"
#endif
        throw_NotDefinedException(env, "POSIX_FADV_NORMAL");
        return 0;
#else
        return POSIX_FADV_NORMAL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    POSIX_FADV_RANDOM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_POSIX_1FADV_1RANDOM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__)
#if defined(POSIX_FADV_RANDOM)
#error "POSIX_FADV_RANDOM defined"
#endif
        throw_NotDefinedException(env, "POSIX_FADV_RANDOM");
        return 0;
#else
        return POSIX_FADV_RANDOM;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    POSIX_FADV_SEQUENTIAL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_POSIX_1FADV_1SEQUENTIAL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__)
#if defined(POSIX_FADV_SEQUENTIAL)
#error "POSIX_FADV_SEQUENTIAL defined"
#endif
        throw_NotDefinedException(env, "POSIX_FADV_SEQUENTIAL");
        return 0;
#else
        return POSIX_FADV_SEQUENTIAL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    POSIX_FADV_WILLNEED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_POSIX_1FADV_1WILLNEED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__)
#if defined(POSIX_FADV_WILLNEED)
#error "POSIX_FADV_WILLNEED defined"
#endif
        throw_NotDefinedException(env, "POSIX_FADV_WILLNEED");
        return 0;
#else
        return POSIX_FADV_WILLNEED;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_RDWR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1RDWR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return O_RDWR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_EXEC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1EXEC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined(__APPLE__)
#if defined(O_EXEC)
#error "O_EXEC defined"
#endif
        throw_NotDefinedException(env, "O_EXEC");
        return 0;
#else
        return O_EXEC;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_SEARCH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1SEARCH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined(__APPLE__) || defined(__FreeBSD__)
#if defined(O_SEARCH)
#error "O_SEARCH defined"
#endif
        throw_NotDefinedException(env, "O_SEARCH");
        return 0;
#else
        return O_SEARCH;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_APPEND
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1APPEND
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return O_APPEND;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_CLOEXEC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1CLOEXEC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return O_CLOEXEC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_LARGEFILE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1LARGEFILE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (_LARGEFILE64_SOURCE)
        return O_LARGEFILE;
#else
#if defined(O_LARGEFILE)
#error "O_LARGEFILE defined"
#endif
        throw_NotDefinedException(env, "O_LARGEFILE");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_CREAT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1CREAT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return O_CREAT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_DIRECTORY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1DIRECTORY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return O_DIRECTORY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_EXCL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1EXCL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return O_EXCL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_NOCTTY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1NOCTTY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return O_NOCTTY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_NOFOLLOW
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1NOFOLLOW
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return O_NOFOLLOW;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_NONBLOCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1NONBLOCK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return O_NONBLOCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_SYNC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1SYNC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return O_SYNC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_TRUNC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1TRUNC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return O_TRUNC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_TTY_INIT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1TTY_1INIT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined(__APPLE__)
#if defined(O_TTY_INIT)
#error "O_TTY_INIT defined"
#endif
        throw_NotDefinedException(env, "O_TTY_INIT");
        return 0;
#else
        return O_TTY_INIT;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_DSYNC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1DSYNC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__FreeBSD__)
#if defined(O_DSYNC)
#error "O_DSYNC defined"
#endif
        throw_NotDefinedException(env, "O_DSYNC");
        return 0;
#else
        return O_DSYNC;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_RSYNC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1RSYNC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__APPLE__) || defined (__FreeBSD__)
#if defined(O_RSYNC)
#error "O_RSYNC defined"
#endif
        throw_NotDefinedException(env, "O_RSYNC");
        return 0;
#else
        return O_RSYNC;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_FSYNC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1FSYNC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__WIN32__)
#if defined(O_FSYNC)
#error "O_FSYNC defined"
#endif
        throw_NotDefinedException(env, "O_FSYNC");
        return 0;
#else
        return O_FSYNC;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_ASYNC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1ASYNC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__WIN32__)
#if defined(O_ASYNC)
#error "O_ASYNC defined"
#endif
        throw_NotDefinedException(env, "O_ASYNC");
        return 0;
#else
        return O_ASYNC;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    O_ACCMODE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1ACCMODE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return O_ACCMODE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_DUPFD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1DUPFD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return F_DUPFD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_DUPFD_CLOEXEC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1DUPFD_1CLOEXEC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return F_DUPFD_CLOEXEC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_GETFD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1GETFD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return F_GETFD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_SETFD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1SETFD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return F_SETFD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_GETFL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1GETFL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return F_GETFL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_SETFL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1SETFL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return F_SETFL;
    }
    
    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_GETLK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1GETLK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return F_GETLK;
    }
    

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_SETLK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1SETLK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return F_SETLK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_SETLKW
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1SETLKW
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return F_SETLKW;
    }
    
    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_GETOWN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1GETOWN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return F_GETOWN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_SETOWN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1SETOWN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return F_SETOWN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    FD_CLOEXEC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_FD_1CLOEXEC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FD_CLOEXEC;
    }
    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_RDLCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1RDLCK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return F_RDLCK;
    }
    
    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_UNLCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1UNLCK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return F_UNLCK;
    }
    
    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_WRLCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1WRLCK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return F_WRLCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    SEEK_SET
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_SEEK_1SET
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SEEK_SET;
    }
            
            
    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    SEEK_CUR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_SEEK_1CUR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SEEK_CUR;
    }
            
    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    SEEK_END
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_SEEK_1END
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SEEK_END;
    }
            
            
#ifdef __cplusplus
}
#endif
#endif
