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
#include "../../../config.h"
#include "jnhw.h"
#if HAVE_UNISTD_H
# include <unistd.h>
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
    (JNIEnv *env, jclass clazz) {
        return EPERM;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOENT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOENT
    (JNIEnv *env, jclass clazz) {
        return ENOENT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ESRCH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ESRCH
    (JNIEnv *env, jclass clazz) {
        return ESRCH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EINTR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EINTR
    (JNIEnv *env, jclass clazz) {
        return EINTR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EIO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EIO
    (JNIEnv *env, jclass clazz) {
        return EIO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENXIO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENXIO
    (JNIEnv *env, jclass clazz) {
        return ENXIO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    E2BIG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_E2BIG
    (JNIEnv *env, jclass clazz) {
        return E2BIG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOEXEC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOEXEC
    (JNIEnv *env, jclass clazz) {
        return ENOEXEC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EBADF
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EBADF
    (JNIEnv *env, jclass clazz) {
        return EBADF;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ECHILD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ECHILD
    (JNIEnv *env, jclass clazz) {
        return ECHILD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EAGAIN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EAGAIN
    (JNIEnv *env, jclass clazz) {
        return EAGAIN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOMEM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOMEM
    (JNIEnv *env, jclass clazz) {
        return ENOMEM;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EACCES
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EACCES
    (JNIEnv *env, jclass clazz) {
        return EACCES;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EFAULT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EFAULT
    (JNIEnv *env, jclass clazz) {
        return EFAULT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOTBLK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOTBLK
    (JNIEnv *env, jclass clazz) {
        return ENOTBLK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EBUSY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EBUSY
    (JNIEnv *env, jclass clazz) {
        return EBUSY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EEXIST
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EEXIST
    (JNIEnv *env, jclass clazz) {
        return EEXIST;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EXDEV
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EXDEV
    (JNIEnv *env, jclass clazz) {
        return EXDEV;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENODEV
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENODEV
    (JNIEnv *env, jclass clazz) {
        return ENODEV;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOTDIR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOTDIR
    (JNIEnv *env, jclass clazz) {
        return ENOTDIR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EISDIR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EISDIR
    (JNIEnv *env, jclass clazz) {
        return EISDIR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EINVAL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EINVAL
    (JNIEnv *env, jclass clazz) {
        return EINVAL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENFILE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENFILE
    (JNIEnv *env, jclass clazz) {
        return ENFILE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EMFILE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EMFILE
    (JNIEnv *env, jclass clazz) {
        return EMFILE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOTTY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOTTY
    (JNIEnv *env, jclass clazz) {
        return ENOTTY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ETXTBSY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ETXTBSY
    (JNIEnv *env, jclass clazz) {
        return ETXTBSY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EFBIG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EFBIG
    (JNIEnv *env, jclass clazz) {
        return EFBIG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOSPC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOSPC
    (JNIEnv *env, jclass clazz) {
        return ENOSPC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ESPIPE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ESPIPE
    (JNIEnv *env, jclass clazz) {
        return ESPIPE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EROFS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EROFS
    (JNIEnv *env, jclass clazz) {
        return EROFS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EMLINK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EMLINK
    (JNIEnv *env, jclass clazz) {
        return EMLINK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EPIPE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EPIPE
    (JNIEnv *env, jclass clazz) {
        return EPIPE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EDEADLK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EDEADLK
    (JNIEnv *env, jclass clazz) {
        return EDEADLK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENAMETOOLONG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENAMETOOLONG
    (JNIEnv *env, jclass clazz) {
        return ENAMETOOLONG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOLCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOLCK
    (JNIEnv *env, jclass clazz) {
        return ENOLCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOSYS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOSYS
    (JNIEnv *env, jclass clazz) {
        return ENOSYS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOTEMPTY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOTEMPTY
    (JNIEnv *env, jclass clazz) {
        return ENOTEMPTY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ELOOP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ELOOP
    (JNIEnv *env, jclass clazz) {
        return ELOOP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EWOULDBLOCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EWOULDBLOCK
    (JNIEnv *env, jclass clazz) {
        return EWOULDBLOCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOMSG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOMSG
    (JNIEnv *env, jclass clazz) {
        return ENOMSG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EIDRM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EIDRM
    (JNIEnv *env, jclass clazz) {
        return EIDRM;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ECHRNG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ECHRNG
    (JNIEnv *env, jclass clazz) {
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
    (JNIEnv *env, jclass clazz) {
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
    (JNIEnv *env, jclass clazz) {
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
    (JNIEnv *env, jclass clazz) {
#ifdef EL3RST
                return  EL3RST;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ELNRNG
                return  ELNRNG;
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
    (JNIEnv *env, jclass clazz) {
#ifdef EUNATCH
        return  EUNATCH;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ENOCSI
        return  ENOCSI;
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
    (JNIEnv *env, jclass clazz) {
#ifdef EL2HLT
        return  EL2HLT;
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
    (JNIEnv *env, jclass clazz) {
#ifdef EBADE
        return  EBADE;
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
    (JNIEnv *env, jclass clazz) {
#ifdef EBADR
        return  EBADR;
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
    (JNIEnv *env, jclass clazz) {
#ifdef EXFULL
        return  EXFULL;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ENOANO
        return  ENOANO;
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
    (JNIEnv *env, jclass clazz) {
#ifdef EBADRQC
        return  EBADRQC;
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
    (JNIEnv *env, jclass clazz) {
#ifdef EBADSLT
        return  EBADSLT;
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
    (JNIEnv *env, jclass clazz) {
#ifdef EDEADLOCK
        return  EDEADLOCK;
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
    (JNIEnv *env, jclass clazz) {
#ifdef EBFONT
        return  EBFONT;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ENOSTR
        return  ENOSTR;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ENODATA
        return  ENODATA;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ETIME
        return  ETIME;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ENOSR
        return  ENOSR;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ENONET
        return  ENONET;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ENOPKG
        return  ENOPKG;
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
    (JNIEnv *env, jclass clazz) {
        return EREMOTE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOLINK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOLINK
    (JNIEnv *env, jclass clazz) {
        return ENOLINK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EADV
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EADV
    (JNIEnv *env, jclass clazz) {
#ifdef EADV
        return  EADV;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ESRMNT
        return  ESRMNT;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ECOMM
        return  ECOMM;
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
    (JNIEnv *env, jclass clazz) {
        return EPROTO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EMULTIHOP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EMULTIHOP
    (JNIEnv *env, jclass clazz) {
        return EMULTIHOP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EDOTDOT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EDOTDOT
    (JNIEnv *env, jclass clazz) {
#ifdef EDOTDOT
        return  EDOTDOT;
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
    (JNIEnv *env, jclass clazz) {
        return EBADMSG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EOVERFLOW
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EOVERFLOW
    (JNIEnv *env, jclass clazz) {
        return EOVERFLOW;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOTUNIQ
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOTUNIQ
    (JNIEnv *env, jclass clazz) {
#ifdef ENOTUNIQ
        return  ENOTUNIQ;
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
    (JNIEnv *env, jclass clazz) {
#ifdef  EBADFD
        return  EBADFD;
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
    (JNIEnv *env, jclass clazz) {
#ifdef EREMCHG
        return  EREMCHG;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ELIBACC
        return  ELIBACC;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ELIBBAD
        return  ELIBBAD;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ELIBSCN
        return  ELIBSCN;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ELIBMAX
        return  ELIBMAX;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ELIBEXEC
        return  ELIBEXEC;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ERESTART
        return  ERESTART;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ESTRPIPE
        return  ESTRPIPE;
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
    (JNIEnv *env, jclass clazz) {
        return EUSERS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOTSOCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOTSOCK
    (JNIEnv *env, jclass clazz) {
        return ENOTSOCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EDESTADDRREQ
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EDESTADDRREQ
    (JNIEnv *env, jclass clazz) {
        return EDESTADDRREQ;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EMSGSIZE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EMSGSIZE
    (JNIEnv *env, jclass clazz) {
        return EMSGSIZE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EPROTOTYPE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EPROTOTYPE
    (JNIEnv *env, jclass clazz) {
        return EPROTOTYPE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOPROTOOPT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOPROTOOPT
    (JNIEnv *env, jclass clazz) {
        return ENOPROTOOPT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EPROTONOSUPPORT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EPROTONOSUPPORT
    (JNIEnv *env, jclass clazz) {
        return EPROTONOSUPPORT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ESOCKTNOSUPPORT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ESOCKTNOSUPPORT
    (JNIEnv *env, jclass clazz) {
        return ESOCKTNOSUPPORT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EOPNOTSUPP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EOPNOTSUPP
    (JNIEnv *env, jclass clazz) {
        return EOPNOTSUPP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EPFNOSUPPORT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EPFNOSUPPORT
    (JNIEnv *env, jclass clazz) {
        return EPFNOSUPPORT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EAFNOSUPPORT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EAFNOSUPPORT
    (JNIEnv *env, jclass clazz) {
        return EAFNOSUPPORT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EADDRINUSE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EADDRINUSE
    (JNIEnv *env, jclass clazz) {
        return EADDRINUSE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EADDRNOTAVAIL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EADDRNOTAVAIL
    (JNIEnv *env, jclass clazz) {
        return EADDRNOTAVAIL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENETDOWN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENETDOWN
    (JNIEnv *env, jclass clazz) {
        return ENETDOWN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENETUNREACH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENETUNREACH
    (JNIEnv *env, jclass clazz) {
        return ENETUNREACH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENETRESET
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENETRESET
    (JNIEnv *env, jclass clazz) {
        return ENETRESET;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ECONNABORTED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ECONNABORTED
    (JNIEnv *env, jclass clazz) {
        return ECONNABORTED;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ECONNRESET
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ECONNRESET
    (JNIEnv *env, jclass clazz) {
        return ECONNRESET;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOBUFS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOBUFS
    (JNIEnv *env, jclass clazz) {
        return ENOBUFS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EISCONN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EISCONN
    (JNIEnv *env, jclass clazz) {
        return EISCONN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOTCONN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOTCONN
    (JNIEnv *env, jclass clazz) {
        return ENOTCONN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ESHUTDOWN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ESHUTDOWN
    (JNIEnv *env, jclass clazz) {
        return ESHUTDOWN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ETOOMANYREFS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ETOOMANYREFS
    (JNIEnv *env, jclass clazz) {
        return ETOOMANYREFS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ETIMEDOUT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ETIMEDOUT
    (JNIEnv *env, jclass clazz) {
        return ETIMEDOUT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ECONNREFUSED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ECONNREFUSED
    (JNIEnv *env, jclass clazz) {
        return ECONNREFUSED;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EHOSTDOWN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EHOSTDOWN
    (JNIEnv *env, jclass clazz) {
        return EHOSTDOWN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EHOSTUNREACH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EHOSTUNREACH
    (JNIEnv *env, jclass clazz) {
        return EHOSTUNREACH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EALREADY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EALREADY
    (JNIEnv *env, jclass clazz) {
        return EALREADY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EINPROGRESS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EINPROGRESS
    (JNIEnv *env, jclass clazz) {
        return EINPROGRESS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ESTALE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ESTALE
    (JNIEnv *env, jclass clazz) {
        return ESTALE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    EUCLEAN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_EUCLEAN
    (JNIEnv *env, jclass clazz) {
#ifdef EUCLEAN
        return  EUCLEAN;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ENOTNAM
        return  ENOTNAM;
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
    (JNIEnv *env, jclass clazz) {
#ifdef ENAVAIL
        return  ENAVAIL;
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
    (JNIEnv *env, jclass clazz) {
#ifdef EISNAM
        return  EISNAM;
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
    (JNIEnv *env, jclass clazz) {
#ifdef EREMOTEIO
        return  EREMOTEIO;
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
    (JNIEnv *env, jclass clazz) {
        return EDQUOT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOMEDIUM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOMEDIUM
    (JNIEnv *env, jclass clazz) {
#ifdef ENOMEDIUM
        return  ENOMEDIUM;
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
    (JNIEnv *env, jclass clazz) {
#ifdef EMEDIUMTYPE
        return  EMEDIUMTYPE;
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
    (JNIEnv *env, jclass clazz) {
        return ECANCELED;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOKEY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOKEY
    (JNIEnv *env, jclass clazz) {
#ifdef ENOKEY
        return  ENOKEY;
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
    (JNIEnv *env, jclass clazz) {
#ifdef EKEYEXPIRED
        return  EKEYEXPIRED;
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
    (JNIEnv *env, jclass clazz) {
#ifdef EKEYREVOKED
        return  EKEYREVOKED;
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
    (JNIEnv *env, jclass clazz) {
#ifdef EKEYREJECTED
        return  EKEYREJECTED;
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
    (JNIEnv *env, jclass clazz) {
        return EOWNERDEAD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ENOTRECOVERABLE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ENOTRECOVERABLE
    (JNIEnv *env, jclass clazz) {
        return ENOTRECOVERABLE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    ERFKILL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Errno_ERFKILL
    (JNIEnv *env, jclass clazz) {
#ifdef ERFKILL
        return  ERFKILL;
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
    (JNIEnv *env, jclass clazz) {
#ifdef EHWPOISON
        return  EHWPOISON;
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
    (JNIEnv *env, jclass clazz) {
        return ENOTSUP;
    }

#ifdef __cplusplus
}
#endif
#endif