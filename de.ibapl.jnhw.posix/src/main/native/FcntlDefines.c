/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2021, Arne Plöse and individual contributors as indicated
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
#include "de_ibapl_jnhw_posix_Fcntl.h"

#ifdef __cplusplus
extern "C" {
#endif

    //We need the POSIX version ...    
#if !defined(HAVE_FCNTL_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Fcntl_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else
#include <fcntl.h>
#include <unistd.h>
    // include POSIX OH (Optional Header) as well, to make FreeBSD happy.
#include <sys/stat.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Fcntl_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_FCNTL_H", JNI_TRUE)) {
            return;
        }

        if (JnhwSetStaticIntField(env, clazz, "O_RDONLY", O_RDONLY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "O_WRONLY", O_WRONLY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "AT_FDCWD", AT_FDCWD)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "AT_EACCESS", AT_EACCESS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "AT_SYMLINK_NOFOLLOW", AT_SYMLINK_NOFOLLOW)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "AT_SYMLINK_FOLLOW", AT_SYMLINK_FOLLOW)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "AT_REMOVEDIR", AT_REMOVEDIR)) {
            return;
        }

#if defined(__APPLE__) || defined(__OpenBSD__)
#if defined(POSIX_FADV_DONTNEED)
#error "POSIX_FADV_DONTNEED defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "POSIX_FADV_DONTNEED", POSIX_FADV_DONTNEED)) {
            return;
        }
#endif

#if defined(__APPLE__) || defined(__OpenBSD__)
#if defined(POSIX_FADV_NOREUSE)
#error "POSIX_FADV_NOREUSE defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "POSIX_FADV_NOREUSE", POSIX_FADV_NOREUSE)) {
            return;
        }
#endif

#if defined(__APPLE__) || defined(__OpenBSD__)
#if defined(POSIX_FADV_NORMAL)
#error "POSIX_FADV_NORMAL defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "POSIX_FADV_NORMAL", POSIX_FADV_NORMAL)) {
            return;
        }
#endif

#if defined(__APPLE__) || defined(__OpenBSD__)
#if defined(POSIX_FADV_RANDOM)
#error "POSIX_FADV_RANDOM defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "POSIX_FADV_RANDOM", POSIX_FADV_RANDOM)) {
            return;
        }
#endif

#if defined(__APPLE__) || defined(__OpenBSD__)
#if defined(POSIX_FADV_SEQUENTIAL)
#error "POSIX_FADV_SEQUENTIAL defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "POSIX_FADV_SEQUENTIAL", POSIX_FADV_SEQUENTIAL)) {
            return;
        }
#endif

#if defined(__APPLE__) || defined(__OpenBSD__)
#if defined(POSIX_FADV_WILLNEED)
#error "POSIX_FADV_WILLNEED defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "POSIX_FADV_WILLNEED", POSIX_FADV_WILLNEED)) {
            return;
        }
#endif

        if (JnhwSetStaticIntField(env, clazz, "O_RDWR", O_RDWR)) {
            return;
        }

#if defined (__linux__) || defined(__APPLE__) || defined(__OpenBSD__)
#if defined(O_EXEC)
#error "O_EXEC defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "O_EXEC", O_EXEC)) {
            return;
        }
#endif

#if defined (__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
#if defined(O_SEARCH)
#error "O_SEARCH defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "O_SEARCH", O_SEARCH)) {
            return;
        }
#endif

        if (JnhwSetStaticIntField(env, clazz, "O_APPEND", O_APPEND)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "O_CLOEXEC", O_CLOEXEC)) {
            return;
        }

#if defined (_LARGEFILE64_SOURCE)
        if (JnhwSetStaticIntDefineField(env, clazz, "O_LARGEFILE", O_LARGEFILE)) {
            return;
        }
#else
#if defined(O_LARGEFILE)
#error "O_LARGEFILE defined"
#endif
#endif

        if (JnhwSetStaticIntField(env, clazz, "O_CREAT", O_CREAT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "O_DIRECTORY", O_DIRECTORY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "O_EXCL", O_EXCL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "O_NOCTTY", O_NOCTTY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "O_NOFOLLOW", O_NOFOLLOW)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "O_NONBLOCK", O_NONBLOCK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "O_SYNC", O_SYNC)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "O_TRUNC", O_TRUNC)) {
            return;
        }

#if defined (__linux__) || defined(__APPLE__) || defined(__OpenBSD__)
#if defined(O_TTY_INIT)
#error "O_TTY_INIT defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "O_TTY_INIT", O_TTY_INIT)) {
            return;
        }
#endif

#if defined (__FreeBSD__)
#if defined(O_DSYNC)
#error "O_DSYNC defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "O_DSYNC", O_DSYNC)) {
            return;
        }
#endif

#if defined (__APPLE__) || defined (__FreeBSD__)
#if defined(O_RSYNC)
#error "O_RSYNC defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "O_RSYNC", O_RSYNC)) {
            return;
        }
#endif

#if defined (__WIN32__) 
#if defined(O_FSYNC)
#error "O_FSYNC defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "O_FSYNC", O_FSYNC)) {
            return;
        }
#endif

#if defined (__WIN32__)
#if defined(O_ASYNC)
#error "O_ASYNC defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "O_ASYNC", O_ASYNC)) {
            return;
        }
#endif

        if (JnhwSetStaticIntField(env, clazz, "O_ACCMODE", O_ACCMODE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "F_DUPFD", F_DUPFD)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "F_DUPFD_CLOEXEC", F_DUPFD_CLOEXEC)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "F_GETFD", F_GETFD)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "F_SETFD", F_SETFD)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "F_GETFL", F_GETFL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "F_SETFL", F_SETFL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "F_GETLK", F_GETLK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "F_SETLK", F_SETLK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "F_SETLKW", F_SETLKW)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "F_GETOWN", F_GETOWN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "F_SETOWN", F_SETOWN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FD_CLOEXEC", FD_CLOEXEC)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "F_RDLCK", F_RDLCK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "F_UNLCK", F_UNLCK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "F_WRLCK", F_WRLCK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SEEK_SET", SEEK_SET)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SEEK_CUR", SEEK_CUR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SEEK_END", SEEK_END)) {
            return;
        }

    }


#endif
#ifdef __cplusplus
}
#endif