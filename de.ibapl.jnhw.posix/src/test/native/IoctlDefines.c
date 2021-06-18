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
#include "de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifndef HAVE_SYS_IOCTL_H

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    HAVE_SYS_IOCTL_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_HAVE_1SYS_1IOCTL_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_FALSE;
    }
#else
#include <sys/ioctl.h>
#ifdef  __OpenBSD__
    // for PAGE_SIZE
#include <sys/param.h>
#endif

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    HAVE_SYS_IOCTL_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_HAVE_1SYS_1IOCTL_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_TRUE;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    FIONREAD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_FIONREAD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__linux__) && defined(__sh__)
        return (int32_t) FIONREAD))
#else
        return FIONREAD;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCCBRK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCCBRK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCCBRK;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCEXCL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCEXCL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCEXCL;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCGICOUNT
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCGICOUNT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, TIOCGICOUNT);
#elif !defined(TIOCGICOUNT)
        return NULL;
#else
#error "TIOCGICOUNT defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCGSOFTCAR
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCGSOFTCAR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
#if defined(__sh__)
        return JnhwWrapInteger(env, (int32_t) TIOCGSOFTCAR);
#else
        return JnhwWrapInteger(env, TIOCGSOFTCAR);
#endif
#elif !defined(TIOCGSOFTCAR)
        return NULL;
#else
#error "TIOCGSOFTCAR defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCMBIC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCMBIC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__) || defined (__FreeBSD__) || defined (__OpenBSD__) || (defined(__linux__) && defined(__sparc__))
        //Just force the conversation or check at runtime sizeof??
        return (int32_t) TIOCMBIC;
#else
        return TIOCMBIC;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCMBIS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCMBIS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__) || defined (__FreeBSD__) || defined (__OpenBSD__) || (defined(__linux__) && defined(__sparc__))
        //Just force the conversation or check at runtime sizeof??
        return (int32_t) TIOCMBIS;
#else
        return TIOCMBIS;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCMGET
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCMGET
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__linux__) && defined(__sh__)
        return (int32_t) TIOCMGET;
#else
        return TIOCMGET;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCMIWAIT
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCMIWAIT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, TIOCMIWAIT);
#elif !defined(TIOCMIWAIT)
        return NULL;
#else
#error "TIOCMIWAIT defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCMSET
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCMSET
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__) || defined (__FreeBSD__) || defined (__OpenBSD__) || (defined(__linux__) && defined(__sparc__))
        //Just force the conversation or check at runtime sizeof??
        return (int32_t) TIOCMSET;
#else
        return TIOCMSET;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCM_CAR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCM_1CAR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCM_CAR;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCM_CD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCM_1CD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCM_CD;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCM_CTS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCM_1CTS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCM_CTS;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCM_DSR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCM_1DSR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCM_DSR;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCM_DTR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCM_1DTR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCM_DTR;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCM_LE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCM_1LE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCM_LE;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCM_RI
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCM_1RI
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCM_RI;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCM_RNG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCM_1RNG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCM_RNG;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCM_RTS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCM_1RTS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCM_RTS;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCM_SR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCM_1SR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCM_SR;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCM_ST
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCM_1ST
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCM_ST;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCOUTQ
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCOUTQ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__linux__) && defined(__sh__)
        return (int32_t) TIOCOUTQ;
#else
        return TIOCOUTQ;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCSBRK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCSBRK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIOCSBRK;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    TIOCSSOFTCAR
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_TIOCSSOFTCAR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
#if defined(__sparc__)
        return JKnhwWrapInteger(env, (int32_t) TIOCSSOFTCAR);
#else
        return JnhwWrapInteger(env, TIOCSSOFTCAR);
#endif
#elif !defined(TIOCSSOFTCAR)
        return NULL;
#error "TIOCSSOFTCAR defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    IOCPARM_MASK
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_IOCPARM_1MASK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__OpenBSD__) || defined (__FreeBSD__)
        return JnhwWrapInteger(env, IOCPARM_MASK);
#elif !defined(IOCPARM_MASK)
        return NULL;
#else
#error "IOCPARM_MASK defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    IOCPARM_MAX
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_IOCPARM_1MAX
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__OpenBSD__) || defined (__FreeBSD__)
        return JnhwWrapInteger(env, IOCPARM_MAX);
#elif !defined(IOCPARM_MAX)
        return NULL;
#else
#error "IOCPARM_MAX defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    IOC_VOID
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_IOC_1VOID
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__OpenBSD__) || defined (__FreeBSD__)
        return JnhwWrapInteger(env, IOC_VOID);
#elif !defined(IOC_VOID)
        return NULL;
#else
#error "IOC_VOID defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    IOC_OUT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_IOC_1OUT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int32_t) IOC_OUT;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    IOC_IN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_IOC_1IN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) && (defined(__mips__) || defined(__powerpc__))
        return (int32_t) IOC_IN;
#else
        return IOC_IN;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    IOC_INOUT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_IOC_1INOUT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int32_t) IOC_INOUT;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    IOC_DIRMASK
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_IOC_1DIRMASK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__OpenBSD__)|| defined (__FreeBSD__)
        return JnhwWrapInteger(env, (int32_t) IOC_DIRMASK);
#elif !defined(IOC_DIRMASK)
        return NULL;
#else
#error "IOC_DIRMASK defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    _IOC_NRBITS
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines__1IOC_1NRBITS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, _IOC_NRBITS);
#elif !defined(_IOC_NRBITS)
        return NULL;
#else
#error "_IOC_NRBITS defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    _IOC_TYPEBITS
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines__1IOC_1TYPEBITS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, _IOC_TYPEBITS);
#elif !defined(_IOC_TYPEBITS)
        return NULL;
#else
#error "_IOC_TYPEBITS defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    _IOC_SIZEBITS
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines__1IOC_1SIZEBITS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, _IOC_SIZEBITS);
#elif !defined(_IOC_SIZEBITS)
        return NULL;
#else
#error "_IOC_SIZEBITS defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    _IOC_DIRBITS
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines__1IOC_1DIRBITS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, _IOC_DIRBITS);
#elif !defined(_IOC_DIRBITS)
        return NULL;
#else
#error "_IOC_DIRBITS defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    _IOC_NRMASK
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines__1IOC_1NRMASK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, _IOC_NRMASK);
#elif !defined(_IOC_NRMASK)
        return NULL;
#else
#error "_IOC_NRMASK defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    _IOC_TYPEMASK
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines__1IOC_1TYPEMASK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, _IOC_TYPEMASK);
#elif !defined(_IOC_TYPEMASK)
        return NULL;
#else
#error "_IOC_TYPEMASK defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    _IOC_SIZEMASK
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines__1IOC_1SIZEMASK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, _IOC_SIZEMASK);
#elif !defined(_IOC_SIZEMASK)
        return NULL;
#else
#error "_IOC_SIZEMASK defined"
#endif

    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    _IOC_DIRMASK
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines__1IOC_1DIRMASK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, _IOC_DIRMASK);
#elif !defined(_IOC_DIRMASK)
        return NULL;
#else
#error "_IOC_DIRMASK defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    _IOC_NRSHIFT
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines__1IOC_1NRSHIFT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, _IOC_NRSHIFT);
#elif !defined(_IOC_NRSHIFT)
        return NULL;
#else
#error "_IOC_NRSHIFT defined"
#endif

    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    _IOC_TYPESHIFT
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines__1IOC_1TYPESHIFT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, _IOC_TYPESHIFT);
#elif !defined(_IOC_TYPESHIFT)
        return NULL;
#else
#error "_IOC_TYPESHIFT defined"
#endif

    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    _IOC_SIZESHIFT
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines__1IOC_1SIZESHIFT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, _IOC_SIZESHIFT);
#elif !defined(_IOC_SIZESHIFT)
        return NULL;
#else
#error "_IOC_SIZESHIFT defined"
#endif

    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    _IOC_DIRSHIFT
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines__1IOC_1DIRSHIFT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, _IOC_DIRSHIFT);
#elif !defined(_IOC_DIRSHIFT)
        return NULL;
#else
#error "_IOC_DIRSHIFT defined"
#endif

    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    _IOC_NONE
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines__1IOC_1NONE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, _IOC_NONE);
#elif !defined(_IOC_NONE)
        return NULL;
#else
#error "_IOC_NONE defined"
#endif

    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    _IOC_READ
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines__1IOC_1READ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, _IOC_READ);
#elif !defined(_IOC_READ)
        return NULL;
#else
#error "_IOC_READ defined"
#endif

    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    _IOC_WRITE
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines__1IOC_1WRITE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, _IOC_WRITE);
#elif !defined(_IOC_WRITE)
        return NULL;
#else
#error "_IOC_WRITE defined"
#endif

    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    IOCSIZE_MASK
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_IOCSIZE_1MASK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, IOCSIZE_MASK);
#elif !defined(IOCSIZE_MASK)
        return NULL;
#else
#error "IOCSIZE_MASK defined"
#endif

    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_IoctlTest_NativeDefines
     * Method:    IOCSIZE_SHIFT
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_unix_sys_IoctlTest_00024NativeDefines_IOCSIZE_1SHIFT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__)
        return JnhwWrapInteger(env, IOCSIZE_SHIFT);
#elif !defined(IOCSIZE_SHIFT)
        return NULL;
#else
#error "IOCSIZE_SHIFT defined"
#endif
    }

#endif


#ifdef __cplusplus
}
#endif
