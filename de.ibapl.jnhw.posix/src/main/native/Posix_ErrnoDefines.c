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
#endif

#ifdef _POSIX_VERSION

#include "de_ibapl_jnhw_posix_Errno.h"
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EPERM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EPERM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EPERM;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOENT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOENT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOENT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ESRCH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ESRCH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ESRCH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EINTR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EINTR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EINTR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EIO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EIO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EIO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENXIO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENXIO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENXIO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    E2BIG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_E2BIG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return E2BIG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOEXEC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOEXEC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOEXEC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EBADF
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EBADF
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EBADF;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ECHILD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ECHILD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ECHILD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EAGAIN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EAGAIN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EAGAIN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOMEM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOMEM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOMEM;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EACCES
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EACCES
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EACCES;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EFAULT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EFAULT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EFAULT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOTBLK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOTBLK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOTBLK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EBUSY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EBUSY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EBUSY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EEXIST
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EEXIST
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EEXIST;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EXDEV
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EXDEV
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EXDEV;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENODEV
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENODEV
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENODEV;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOTDIR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOTDIR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOTDIR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EISDIR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EISDIR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EISDIR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EINVAL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EINVAL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EINVAL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENFILE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENFILE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENFILE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EMFILE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EMFILE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EMFILE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOTTY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOTTY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOTTY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ETXTBSY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ETXTBSY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ETXTBSY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EFBIG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EFBIG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EFBIG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOSPC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOSPC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOSPC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ESPIPE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ESPIPE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ESPIPE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EROFS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EROFS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EROFS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EMLINK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EMLINK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EMLINK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EPIPE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EPIPE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EPIPE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EDEADLK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EDEADLK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EDEADLK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENAMETOOLONG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENAMETOOLONG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENAMETOOLONG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOLCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOLCK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOLCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOSYS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOSYS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOSYS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOTEMPTY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOTEMPTY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOTEMPTY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ELOOP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ELOOP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ELOOP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EWOULDBLOCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EWOULDBLOCK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EWOULDBLOCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOMSG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOMSG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOMSG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EIDRM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EIDRM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EIDRM;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ECHRNG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ECHRNG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ECHRNG
        return ECHRNG;
#else 
        throw_NotDefinedException(env, "ECHRNG");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EL2NSYNC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EL2NSYNC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EL2NSYNC
        return EL2NSYNC;
#else 
        throw_NotDefinedException(env, "EL2NSYNC");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EL3HLT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EL3HLT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EL3HLT  
        return EL3HLT;
#else 
        throw_NotDefinedException(env, "EL3HLT");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EL3RST
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EL3RST
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EL3RST
        return EL3RST;
#else 
        throw_NotDefinedException(env, "EL3RST");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ELNRNG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ELNRNG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ELNRNG
        return ELNRNG;
#else 
        throw_NotDefinedException(env, "ELNRNG");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EUNATCH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EUNATCH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EUNATCH
        return EUNATCH;
#else 
        throw_NotDefinedException(env, "EUNATCH");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOCSI
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOCSI
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ENOCSI
        return ENOCSI;
#else 
        throw_NotDefinedException(env, "ENOCSI");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EL2HLT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EL2HLT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EL2HLT
        return EL2HLT;
#else 
        throw_NotDefinedException(env, "EL2HLT");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EBADE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EBADE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EBADE
        return EBADE;
#else 
        throw_NotDefinedException(env, "EBADE");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EBADR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EBADR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EBADR
        return EBADR;
#else 
        throw_NotDefinedException(env, "EBADR");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EXFULL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EXFULL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EXFULL
        return EXFULL;
#else 
        throw_NotDefinedException(env, "EXFULL");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOANO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOANO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ENOANO
        return ENOANO;
#else 
        throw_NotDefinedException(env, "ENOANO");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EBADRQC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EBADRQC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EBADRQC
        return EBADRQC;
#else 
        throw_NotDefinedException(env, "EBADRQC");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EBADSLT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EBADSLT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EBADSLT
        return EBADSLT;
#else 
        throw_NotDefinedException(env, "EBADSLT");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EDEADLOCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EDEADLOCK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EDEADLOCK
        return EDEADLOCK;
#else 
        throw_NotDefinedException(env, "EDEADLOCK");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EBFONT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EBFONT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EBFONT
        return EBFONT;
#else 
        throw_NotDefinedException(env, "EBFONT");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOSTR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOSTR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ENOSTR
        return ENOSTR;
#else 
        throw_NotDefinedException(env, "ENOSTR");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENODATA
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENODATA
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ENODATA
        return ENODATA;
#else 
        throw_NotDefinedException(env, "ENODATA");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ETIME
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ETIME
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ETIME
        return ETIME;
#else 
        throw_NotDefinedException(env, "ETIME");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOSR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOSR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ENOSR
        return ENOSR;
#else 
        throw_NotDefinedException(env, "ENOSR");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENONET
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENONET
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ENONET
        return ENONET;
#else 
        throw_NotDefinedException(env, "ENONET");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOPKG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOPKG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ENOPKG
        return ENOPKG;
#else 
        throw_NotDefinedException(env, "ENOPKG");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EREMOTE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EREMOTE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EREMOTE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOLINK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOLINK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOLINK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EADV
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EADV
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EADV
        return EADV;
#else 
        throw_NotDefinedException(env, "EADV");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ESRMNT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ESRMNT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ESRMNT
        return ESRMNT;
#else 
        throw_NotDefinedException(env, "ESRMNT");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ECOMM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ECOMM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ECOMM
        return ECOMM;
#else 
        throw_NotDefinedException(env, "ECOMM");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EPROTO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EPROTO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EPROTO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EMULTIHOP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EMULTIHOP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EMULTIHOP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EDOTDOT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EDOTDOT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EDOTDOT
        return EDOTDOT;
#else 
        throw_NotDefinedException(env, "EDOTDOT");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EBADMSG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EBADMSG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EBADMSG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EOVERFLOW
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EOVERFLOW
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EOVERFLOW;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOTUNIQ
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOTUNIQ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ENOTUNIQ
        return ENOTUNIQ;
#else 
        throw_NotDefinedException(env, "ENOTUNIQ");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EBADFD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EBADFD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef  EBADFD
        return EBADFD;
#else 
        throw_NotDefinedException(env, "EBADFD");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EREMCHG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EREMCHG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EREMCHG
        return EREMCHG;
#else 
        throw_NotDefinedException(env, "EREMCHG");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ELIBACC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ELIBACC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ELIBACC
        return ELIBACC;
#else 
        throw_NotDefinedException(env, "ELIBACC");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ELIBBAD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ELIBBAD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ELIBBAD
        return ELIBBAD;
#else 
        throw_NotDefinedException(env, "ELIBBAD");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ELIBSCN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ELIBSCN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ELIBSCN
        return ELIBSCN;
#else 
        throw_NotDefinedException(env, "ELIBSCN");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ELIBMAX
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ELIBMAX
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ELIBMAX
        return ELIBMAX;
#else 
        throw_NotDefinedException(env, "ELIBMAX");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ELIBEXEC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ELIBEXEC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ELIBEXEC
        return ELIBEXEC;
#else 
        throw_NotDefinedException(env, "ELIBEXEC");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ERESTART
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ERESTART
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ERESTART
        return ERESTART;
#else 
        throw_NotDefinedException(env, "ERESTART");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ESTRPIPE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ESTRPIPE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ESTRPIPE
        return ESTRPIPE;
#else 
        throw_NotDefinedException(env, "ESTRPIPE");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EUSERS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EUSERS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EUSERS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOTSOCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOTSOCK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOTSOCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EDESTADDRREQ
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EDESTADDRREQ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EDESTADDRREQ;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EMSGSIZE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EMSGSIZE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EMSGSIZE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EPROTOTYPE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EPROTOTYPE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EPROTOTYPE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOPROTOOPT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOPROTOOPT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOPROTOOPT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EPROTONOSUPPORT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EPROTONOSUPPORT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EPROTONOSUPPORT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ESOCKTNOSUPPORT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ESOCKTNOSUPPORT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ESOCKTNOSUPPORT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EOPNOTSUPP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EOPNOTSUPP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EOPNOTSUPP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EPFNOSUPPORT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EPFNOSUPPORT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EPFNOSUPPORT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EAFNOSUPPORT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EAFNOSUPPORT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EAFNOSUPPORT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EADDRINUSE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EADDRINUSE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EADDRINUSE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EADDRNOTAVAIL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EADDRNOTAVAIL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EADDRNOTAVAIL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENETDOWN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENETDOWN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENETDOWN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENETUNREACH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENETUNREACH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENETUNREACH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENETRESET
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENETRESET
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENETRESET;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ECONNABORTED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ECONNABORTED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ECONNABORTED;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ECONNRESET
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ECONNRESET
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ECONNRESET;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOBUFS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOBUFS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOBUFS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EISCONN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EISCONN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EISCONN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOTCONN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOTCONN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOTCONN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ESHUTDOWN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ESHUTDOWN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ESHUTDOWN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ETOOMANYREFS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ETOOMANYREFS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ETOOMANYREFS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ETIMEDOUT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ETIMEDOUT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ETIMEDOUT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ECONNREFUSED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ECONNREFUSED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ECONNREFUSED;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EHOSTDOWN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EHOSTDOWN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EHOSTDOWN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EHOSTUNREACH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EHOSTUNREACH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EHOSTUNREACH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EALREADY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EALREADY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EALREADY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EINPROGRESS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EINPROGRESS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EINPROGRESS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ESTALE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ESTALE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ESTALE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EUCLEAN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EUCLEAN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EUCLEAN
        return EUCLEAN;
#else 
        throw_NotDefinedException(env, "EUCLEAN");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOTNAM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOTNAM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ENOTNAM
        return ENOTNAM;
#else 
        throw_NotDefinedException(env, "ENOTNAM");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENAVAIL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENAVAIL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ENAVAIL
        return ENAVAIL;
#else 
        throw_NotDefinedException(env, "ENAVAIL");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EISNAM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EISNAM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EISNAM
        return EISNAM;
#else 
        throw_NotDefinedException(env, "EISNAM");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EREMOTEIO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EREMOTEIO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EREMOTEIO
        return EREMOTEIO;
#else 
        throw_NotDefinedException(env, "EREMOTEIO");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EDQUOT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EDQUOT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EDQUOT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOMEDIUM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOMEDIUM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ENOMEDIUM
        return ENOMEDIUM;
#else 
        throw_NotDefinedException(env, "ENOMEDIUM");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EMEDIUMTYPE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EMEDIUMTYPE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EMEDIUMTYPE
        return EMEDIUMTYPE;
#else 
        throw_NotDefinedException(env, "EMEDIUMTYPE");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ECANCELED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ECANCELED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ECANCELED;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOKEY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOKEY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ENOKEY
        return ENOKEY;
#else 
        throw_NotDefinedException(env, "ENOKEY");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EKEYEXPIRED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EKEYEXPIRED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EKEYEXPIRED
        return EKEYEXPIRED;
#else 
        throw_NotDefinedException(env, "EKEYEXPIRED");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EKEYREVOKED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EKEYREVOKED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EKEYREVOKED
        return EKEYREVOKED;
#else 
        throw_NotDefinedException(env, "EKEYREVOKED");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EKEYREJECTED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EKEYREJECTED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EKEYREJECTED
        return EKEYREJECTED;
#else 
        throw_NotDefinedException(env, "EKEYREJECTED");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EOWNERDEAD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EOWNERDEAD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EOWNERDEAD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOTRECOVERABLE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOTRECOVERABLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOTRECOVERABLE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ERFKILL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ERFKILL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef ERFKILL
        return ERFKILL;
#else 
        throw_NotDefinedException(env, "ERFKILL");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EHWPOISON
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EHWPOISON
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef EHWPOISON
        return EHWPOISON;
#else 
        throw_NotDefinedException(env, "EHWPOISON");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOTSUP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOTSUP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOTSUP;
    }

#ifdef __cplusplus
}
#endif
#endif