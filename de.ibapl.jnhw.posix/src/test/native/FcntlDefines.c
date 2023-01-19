/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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
    //We need the POSIX version ...
#if !defined(HAVE_FCNTL_H) || !defined(_POSIX_VERSION)

int32_t getValueOf_HAVE_FCNTL_H() {
    return 0;
}

#else
#include <fcntl.h>
//#include <unistd.h>
    // include POSIX OH (Optional Header) as well, to make FreeBSD happy.
//#include <sys/stat.h>

int32_t getValueOf_HAVE_FCNTL_H() {
    return 1;
}

int32_t getValueOf_AT_EACCESS() {
    return AT_EACCESS;
}

int32_t getValueOf_AT_FDCWD() {
    return AT_FDCWD;
}

int32_t getValueOf_AT_REMOVEDIR() {
    return AT_REMOVEDIR;
}

int32_t getValueOf_AT_SYMLINK_FOLLOW() {
    return AT_SYMLINK_FOLLOW;
}

int32_t getValueOf_AT_SYMLINK_NOFOLLOW() {
    return AT_SYMLINK_NOFOLLOW;
}

int32_t getValueOf_FD_CLOEXEC() {
    return FD_CLOEXEC;
}

int32_t getValueOf_F_DUPFD() {
    return F_DUPFD;
}

int32_t getValueOf_F_DUPFD_CLOEXEC() {
    return F_DUPFD_CLOEXEC;
}

int32_t getValueOf_F_GETFD() {
    return F_GETFD;
}

int32_t getValueOf_F_GETFL() {
    return F_GETFL;
}

int32_t getValueOf_F_GETLK() {
    return F_GETLK;
}

int32_t getValueOf_F_GETOWN() {
    return F_GETOWN;
}

int32_t getValueOf_F_RDLCK() {
    return F_RDLCK;
}

int32_t getValueOf_F_SETFD() {
    return F_SETFD;
}

int32_t getValueOf_F_SETFL() {
    return F_SETFL;
}

int32_t getValueOf_F_SETLK() {
    return F_SETLK;
}

int32_t getValueOf_F_SETLKW() {
    return F_SETLKW;
}

int32_t getValueOf_F_SETOWN() {
    return F_SETOWN;
}

int32_t getValueOf_F_UNLCK() {
    return F_UNLCK;
}

int32_t getValueOf_F_WRLCK() {
    return F_WRLCK;
}

int32_t getValueOf_O_ACCMODE() {
    return O_ACCMODE;
}

int32_t getValueOf_O_APPEND() {
    return O_APPEND;
}

int32_t* tryGetValueOf_O_ASYNC(int32_t* value) {
#if defined (__linux__) || defined(__FreeBSD__) || defined(__OpenBSD__)  || defined(__APPLE__)
    *value = O_ASYNC;
#else
#if !defined(O_ASYNC)
    value = NULL;
#else
#error "O_ASYNC defined"
#endif
#endif
    return value;
}

int32_t getValueOf_O_CLOEXEC() {
    return O_CLOEXEC;
}

int32_t getValueOf_O_CREAT() {
    return O_CREAT;
}

int32_t getValueOf_O_DIRECTORY() {
    return O_DIRECTORY;
}

int32_t getValueOf_O_DSYNC() {
    return O_DSYNC;
}

int32_t getValueOf_O_EXCL() {
    return O_EXCL;
}

int32_t* tryGetValueOf_O_EXEC(int32_t* value) {
#if defined (__linux__) || defined(__OpenBSD__)
# if !defined(O_EXEC)
    value = NULL;
# else
#  error "O_EXEC defined"
# endif
#else
    *value = O_EXEC;
#endif
    return value;
}

int32_t* tryGetValueOf_O_FSYNC(int32_t* value) {
#if defined (__linux__) || defined(__FreeBSD__)|| defined(__OpenBSD__) || defined(__APPLE__)
    *value = O_FSYNC;
#else
#if !defined(O_FSYNC)
    value = NULL;
#else
#error "O_FSYNC defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_O_LARGEFILE(int32_t* value) {
#if defined (_LARGEFILE64_SOURCE)
    *value = O_LARGEFILE;
#else
#if defined(O_LARGEFILE)
#error "O_LARGEFILE defined"
#endif
    value = NULL;
#endif
    return value;
}

int32_t getValueOf_O_NOCTTY() {
    return O_NOCTTY;
}

int32_t getValueOf_O_NOFOLLOW() {
    return O_NOFOLLOW;
}

int32_t getValueOf_O_NONBLOCK() {
    return O_NONBLOCK;
}

int32_t getValueOf_O_RDONLY() {
    return O_RDONLY;
}

int32_t getValueOf_O_RDWR() {
    return O_RDWR;
}

int32_t* tryGetValueOf_O_RSYNC(int32_t* value) {
#if defined (__APPLE__) || defined (__FreeBSD__)
#if !defined(O_RSYNC)
    value = NULL;
#else
#error "O_RSYNC defined"
#endif
#else
    *value = O_RSYNC;
#endif
    return value;
}

int32_t* tryGetValueOf_O_SEARCH(int32_t* value) {
#if defined (__linux__) || defined(__OpenBSD__)
# if !defined(O_SEARCH)
    value = NULL;
# else
#  error "O_SEARCH defined"
# endif
#else
    *value = O_SEARCH;
#endif
    return value;
}

int32_t getValueOf_O_SYNC() {
    return O_SYNC;
}

int32_t getValueOf_O_TRUNC() {
    return O_TRUNC;
}

int32_t* tryGetValueOf_O_TTY_INIT(int32_t* value) {
#if defined (__linux__) || defined(__APPLE__) || defined(__OpenBSD__)
#if !defined(O_TTY_INIT)
    value = NULL;
#else
#error "O_TTY_INIT defined"
#endif
#else
    *value = O_TTY_INIT;
#endif
    return value;
}

int32_t getValueOf_O_WRONLY() {
    return O_WRONLY;
}

int32_t* tryGetValueOf_POSIX_FADV_DONTNEED(int32_t* value) {
#if defined(__APPLE__) || defined(__OpenBSD__)
#if !defined(POSIX_FADV_DONTNEED)
    value = NULL;
#else
#error "POSIX_FADV_DONTNEED defined"
#endif
#else
    *value = POSIX_FADV_DONTNEED;
#endif
    return value;
}

int32_t* tryGetValueOf_POSIX_FADV_NOREUSE(int32_t* value) {
#if defined(__APPLE__) || defined(__OpenBSD__)
#if !defined(POSIX_FADV_NOREUSE)
    value = NULL;
#else
#error "POSIX_FADV_NOREUSE defined"
#endif
#else
    *value = POSIX_FADV_NOREUSE;
#endif
    return value;
}

int32_t* tryGetValueOf_POSIX_FADV_NORMAL(int32_t* value) {
#if defined(__APPLE__) || defined(__OpenBSD__)
#if !defined(POSIX_FADV_NORMAL)
    value = NULL;
#else
#error "POSIX_FADV_NORMAL defined"
#endif
#else
    *value = POSIX_FADV_NORMAL;
#endif
    return value;
}

int32_t* tryGetValueOf_POSIX_FADV_RANDOM(int32_t* value) {
#if defined(__APPLE__) || defined(__OpenBSD__)
#if !defined(POSIX_FADV_RANDOM)
    value = NULL;
#else
#error "POSIX_FADV_RANDOM defined"
#endif
#else
    *value = POSIX_FADV_RANDOM;
#endif
    return value;
}

int32_t* tryGetValueOf_POSIX_FADV_SEQUENTIAL(int32_t* value) {
#if defined(__APPLE__) || defined(__OpenBSD__)
#if !defined(POSIX_FADV_SEQUENTIAL)
    value = NULL;
#else
#error "POSIX_FADV_SEQUENTIAL defined"
#endif
#else
    *value = POSIX_FADV_SEQUENTIAL;
#endif
    return value;
}

int32_t* tryGetValueOf_POSIX_FADV_WILLNEED(int32_t* value) {
#if defined(__APPLE__) || defined(__OpenBSD__)
#if !defined(POSIX_FADV_WILLNEED)
    value = NULL;
#else
#error "POSIX_FADV_WILLNEED defined"
#endif
#else
    *value = POSIX_FADV_WILLNEED;
#endif
    return value;
}

#endif