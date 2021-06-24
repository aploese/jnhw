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
#include "de_ibapl_jnhw_posix_ErrnoTest_NativeDefines.h"


#ifdef __cplusplus
extern "C" {
#endif

    //We need the POSIX version ...
#if !defined(HAVE_ERRNO_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    E2BIG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_E2BIG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_FALSE;
    }
#else
#include <errno.h>

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    E2BIG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_E2BIG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_TRUE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EACCES
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EACCES
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EACCES;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EADDRINUSE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EADDRINUSE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EADDRINUSE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EADDRNOTAVAIL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EADDRNOTAVAIL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EADDRNOTAVAIL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EADV
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EADV
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)

        return JnhwWrapInteger(env, EADV);
#elif !defined(EADV)
        return NULL;
#else
#error "EADV defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EAFNOSUPPORT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EAFNOSUPPORT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EAFNOSUPPORT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EAGAIN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EAGAIN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EAGAIN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EALREADY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EALREADY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EALREADY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EBADE
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EBADE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EBADE);
#elif !defined(EBADE)
        return NULL;
#else
#error "EBADE defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EBADF
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EBADF
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EBADF;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EBADFD
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EBADFD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)

        return JnhwWrapInteger(env, EBADFD);
#elif !defined(EBADFD)
        return NULL;
#else
#error "EBADFD defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EBADMSG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EBADMSG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EBADMSG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EBADR
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EBADR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EBADR);
#elif !defined(EBADR)
        return NULL;
#else
#error "EBADR defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EBADRQC
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EBADRQC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EBADRQC);
#elif !defined(EBADRQC)
        return NULL;
#else
#error "EBADRQC defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EBADSLT
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EBADSLT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EBADSLT);
#elif !defined(EBADSLT)
        return NULL;
#else
#error "EBADSLT defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EBFONT
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EBFONT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EBFONT);
#elif !defined(EBFONT)
        return NULL;
#else
#error "EBFONT defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EBUSY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EBUSY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EBUSY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ECANCELED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ECANCELED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ECANCELED;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ECHILD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ECHILD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ECHILD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ECHRNG
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ECHRNG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, ECHRNG);
#elif !defined(ECHRNG)
        return NULL;
#else
#error "ECHRNG defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ECOMM
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ECOMM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)

        return JnhwWrapInteger(env, ECOMM);
#elif !defined(ECOMM)
        return NULL;
#else
#error "ECOMM defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ECONNABORTED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ECONNABORTED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ECONNABORTED;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ECONNREFUSED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ECONNREFUSED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ECONNREFUSED;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ECONNRESET
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ECONNRESET
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ECONNRESET;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EDEADLK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EDEADLK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EDEADLK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EDEADLOCK
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EDEADLOCK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EDEADLOCK);
#elif !defined(EDEADLOCK)
        return NULL;
#else
#error "EDEADLOCK defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EDESTADDRREQ
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EDESTADDRREQ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EDESTADDRREQ;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EDOTDOT
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EDOTDOT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EDOTDOT);
#elif !defined(EDOTDOT)
        return NULL;
#else
#error "EDOTDOT defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EDQUOT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EDQUOT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EDQUOT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EEXIST
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EEXIST
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EEXIST;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EFAULT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EFAULT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EFAULT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EFBIG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EFBIG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EFBIG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EHOSTDOWN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EHOSTDOWN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EHOSTDOWN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EHOSTUNREACH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EHOSTUNREACH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EHOSTUNREACH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EHWPOISON
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EHWPOISON
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EHWPOISON);
#elif !defined(EHWPOISON)
        return NULL;
#else
#error "EHWPOISON defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EIDRM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EIDRM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EIDRM;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EINPROGRESS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EINPROGRESS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EINPROGRESS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EINTR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EINTR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EINTR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EINVAL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EINVAL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EINVAL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EIO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EIO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EIO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EISCONN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EISCONN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EISCONN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EISDIR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EISDIR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EISDIR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EISNAM
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EISNAM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)

        return JnhwWrapInteger(env, EISNAM);
#elif !defined(EISNAM)
        return NULL;
#else
#error "EISNAM defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EKEYEXPIRED
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EKEYEXPIRED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EKEYEXPIRED);
#elif !defined(EKEYEXPIRED)
        return NULL;
#else
#error "EKEYEXPIRED defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EKEYREJECTED
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EKEYREJECTED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EKEYREJECTED);
#elif !defined(EKEYREJECTED)
        return NULL;
#else
#error "EKEYREJECTED defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EKEYREVOKED
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EKEYREVOKED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EKEYREVOKED);
#elif !defined(EKEYREVOKED)
        return NULL;
#else
#error "EKEYREVOKED defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EL2HLT
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EL2HLT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EL2HLT);
#elif !defined(EL2HLT)
        return NULL;
#else
#error "EL2HLT defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EL2NSYNC
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EL2NSYNC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EL2NSYNC);
#elif !defined(EL2NSYNC)
        return NULL;
#else
#error "EL2NSYNC defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EL3HLT
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EL3HLT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EL3HLT);
#elif !defined(EL3HLT)
        return NULL;
#else
#error "EL3HLT defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EL3RST
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EL3RST
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EL3RST);
#elif !defined(EL3RST)
        return NULL;
#else
#error "EL3RST defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ELIBACC
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ELIBACC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)

        return JnhwWrapInteger(env, ELIBACC);
#elif !defined(ELIBACC)
        return NULL;
#else
#error "ELIBACC defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ELIBBAD
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ELIBBAD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)

        return JnhwWrapInteger(env, ELIBBAD);
#elif !defined(ELIBBAD)
        return NULL;
#else
#error "ELIBBAD defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ELIBEXEC
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ELIBEXEC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, ELIBEXEC);
#elif !defined(ELIBEXEC)
        return NULL;
#else
#error "ELIBEXEC defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ELIBMAX
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ELIBMAX
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, ELIBMAX);
#elif !defined(ELIBMAX)
        return NULL;
#else
#error "ELIBMAX defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ELIBSCN
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ELIBSCN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, ELIBSCN);
#elif !defined(ELIBSCN)
        return NULL;
#else
#error "ELIBSCN defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ELNRNG
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ELNRNG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, ELNRNG);
#elif !defined(ELNRNG)
        return NULL;
#else
#error "ELNRNG defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ELOOP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ELOOP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ELOOP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EMEDIUMTYPE
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EMEDIUMTYPE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined(__OpenBSD__)
        return JnhwWrapInteger(env, EMEDIUMTYPE);
#elif !defined(EMEDIUMTYPE)
        return NULL;
#else
#error "EMEDIUMTYPE defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EMFILE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EMFILE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EMFILE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EMLINK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EMLINK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EMLINK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EMSGSIZE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EMSGSIZE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EMSGSIZE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EMULTIHOP
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EMULTIHOP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__OpenBSD__)
#if defined(EMULTIHOP)
        return NULL;
#else
#error "EMULTIHOP defined"
#endif
#else
        return JnhwWrapInteger(env, EMULTIHOP);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENAMETOOLONG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENAMETOOLONG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENAMETOOLONG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENAVAIL
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENAVAIL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, ENAVAIL);
#elif !defined(ENAVAIL)
        return NULL;
#else
#error "ENAVAIL defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENETDOWN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENETDOWN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENETDOWN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENETRESET
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENETRESET
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENETRESET;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENETUNREACH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENETUNREACH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENETUNREACH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENFILE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENFILE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENFILE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOANO
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOANO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, ENOANO);
#elif !defined(ENOANO)
        return NULL;
#else
#error "ENOANO defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOBUFS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOBUFS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOBUFS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOCSI
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOCSI
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, ENOCSI);
#elif !defined(ENOCSI)
        return NULL;
#else
#error "ENOCSI defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENODATA
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENODATA
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__linux__) || defined(__APPLE__)

        return JnhwWrapInteger(env, ENODATA);
#elif !defined(ENODATA)
        return NULL;
#else
#error "ENODATA defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENODEV
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENODEV
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENODEV;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOENT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOENT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOENT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOEXEC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOEXEC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOEXEC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOKEY
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOKEY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, ENOKEY);
#elif !defined(ENOKEY)
        return NULL;
#else
#error "ENOKEY defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOLCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOLCK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOLCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOLINK
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOLINK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__OpenBSD__)
#if defined(ENOLINK)
        return NULL;
#else
#error "ENOLINK defined"
#endif
#else
        return JnhwWrapInteger(env, ENOLINK);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOMEDIUM
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOMEDIUM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined(__OpenBSD__)
        return JnhwWrapInteger(env, ENOMEDIUM);
#elif !defined(ENOMEDIUM)
        return NULL;
#else
#error "ENOMEDIUM defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOMEM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOMEM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOMEM;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOMSG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOMSG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOMSG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENONET
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENONET
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, ENONET);
#elif !defined(ENONET)
        return NULL;
#else
#error "ENONET defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOPKG
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOPKG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)

        return JnhwWrapInteger(env, ENOPKG);
#elif !defined(ENOPKG)
        return NULL;
#else
#error "ENOPKG defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOPROTOOPT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOPROTOOPT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOPROTOOPT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOSPC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOSPC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOSPC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOSR
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOSR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__linux__) || defined(__APPLE__)
        return JnhwWrapInteger(env, ENOSR);
#elif !defined(ENOSR)
        return NULL;
#else
#error "ENOSR defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOSTR
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOSTR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__FreeBSD__) || defined(__OpenBSD__)
#if !defined(ENOSTR)
        return NULL;
#else
#error "ENOSTR defined"
#endif
#else
        return JnhwWrapInteger(env, ENOSTR);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOSYS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOSYS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOSYS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOTBLK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOTBLK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOTBLK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOTCONN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOTCONN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOTCONN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOTDIR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOTDIR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOTDIR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOTEMPTY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOTEMPTY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOTEMPTY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOTNAM
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOTNAM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, ENOTNAM);
#elif !defined(ENOTNAM)
        return NULL;
#else
#error "ENOTNAM defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOTRECOVERABLE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOTRECOVERABLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOTRECOVERABLE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOTSOCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOTSOCK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOTSOCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOTSUP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOTSUP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOTSUP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOTTY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOTTY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENOTTY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENOTUNIQ
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENOTUNIQ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, ENOTUNIQ);
#elif !defined(ENOTUNIQ)
        return NULL;
#else
#error "ENOTUNIQ defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ENXIO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ENXIO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ENXIO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EOPNOTSUPP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EOPNOTSUPP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EOPNOTSUPP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EOVERFLOW
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EOVERFLOW
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EOVERFLOW;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EOWNERDEAD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EOWNERDEAD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EOWNERDEAD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EPERM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EPERM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EPERM;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EPFNOSUPPORT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EPFNOSUPPORT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EPFNOSUPPORT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EPIPE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EPIPE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EPIPE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EPROTO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EPROTO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EPROTO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EPROTONOSUPPORT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EPROTONOSUPPORT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EPROTONOSUPPORT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EPROTOTYPE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EPROTOTYPE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EPROTOTYPE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EREMCHG
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EREMCHG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)

        return JnhwWrapInteger(env, EREMCHG);
#elif !defined(EREMCHG)
        return NULL;
#else
#error "EREMCHG defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EREMOTE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EREMOTE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EREMOTE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EREMOTEIO
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EREMOTEIO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EREMOTEIO);
#elif !defined(EREMOTEIO)
        return NULL;
#else
#error "EREMOTEIO defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ERESTART
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ERESTART
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, ERESTART);
#elif !defined(ERESTART)
        return NULL;
#else
#error "ERESTART defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ERFKILL
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ERFKILL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, ERFKILL);
#elif !defined(ERFKILL)
        return NULL;
#else
#error "ERFKILL defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EROFS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EROFS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EROFS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ESHUTDOWN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ESHUTDOWN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ESHUTDOWN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ESOCKTNOSUPPORT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ESOCKTNOSUPPORT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ESOCKTNOSUPPORT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ESPIPE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ESPIPE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ESPIPE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ESRCH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ESRCH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ESRCH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ESRMNT
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ESRMNT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)

        return JnhwWrapInteger(env, ESRMNT);
#elif !defined(ESRMNT)
        return NULL;
#else
#error "ESRMNT defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ESTALE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ESTALE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ESTALE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ESTRPIPE
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ESTRPIPE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, ESTRPIPE);
#elif !defined(ESTRPIPE)
        return NULL;
#else
#error "ESTRPIPE defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ETIME
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ETIME
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__linux__) || defined(__APPLE__)
        return JnhwWrapInteger(env, ETIME);
#elif !defined(ETIME)
        return NULL;
#else
#error "ETIME defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ETIMEDOUT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ETIMEDOUT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ETIMEDOUT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ETOOMANYREFS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ETOOMANYREFS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ETOOMANYREFS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    ETXTBSY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_ETXTBSY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ETXTBSY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EUCLEAN
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EUCLEAN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EUCLEAN);
#elif !defined(EUCLEAN)
        return NULL;
#else
#error "EUCLEAN defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EUNATCH
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EUNATCH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EUNATCH);
#elif !defined(EUNATCH)
        return NULL;
#else
#error "EUNATCH defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EUSERS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EUSERS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EUSERS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EWOULDBLOCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EWOULDBLOCK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EWOULDBLOCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EXDEV
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EXDEV
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EXDEV;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_ErrnoTest_NativeDefines
     * Method:    EXFULL
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_ErrnoTest_00024NativeDefines_EXFULL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, EXFULL);
#elif !defined(EXFULL)
        return NULL;
#else
#error "EXFULL defined"
#endif
    }

#ifdef __cplusplus
}
#endif
#endif
