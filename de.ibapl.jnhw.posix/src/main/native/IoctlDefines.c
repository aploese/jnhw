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
#include "de_ibapl_jnhw_unix_sys_Ioctl.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifndef HAVE_SYS_IOCTL_H

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else
#include <sys/ioctl.h>

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_SYS_IOCTL_H", JNI_TRUE)) {
            return;
        }

#if defined(__linux__) && defined(__sh__)
        if (JnhwSetStaticIntField(env, clazz, "FIONREAD", (int32_t) FIONREAD)) {
            return;
        }
#else
        if (JnhwSetStaticIntField(env, clazz, "FIONREAD", FIONREAD)) {
            return;
        }
#endif

        if (JnhwSetStaticIntField(env, clazz, "TIOCM_LE", TIOCM_LE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_ST", TIOCM_ST)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_SR", TIOCM_SR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_CTS", TIOCM_CTS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_DTR", TIOCM_DTR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_CAR", TIOCM_CAR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_CD", TIOCM_CD)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_RTS", TIOCM_RTS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_RNG", TIOCM_RNG)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_RI", TIOCM_RI)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_DSR", TIOCM_DSR)) {
            return;
        }

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "TIOCMIWAIT", TIOCMIWAIT)) {
            return;
        }
#elif defined(TIOCMIWAIT)
#error "TIOCMIWAIT defined"
#else
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "TIOCGICOUNT", TIOCGICOUNT)) {
            return;
        }
#elif defined(TIOCGICOUNT)
#error "TIOCGICOUNT defined"
#else
#endif

#if defined (__linux__)
#if defined(__sh__)
        if (JnhwSetStaticIntDefineField(env, clazz, "TIOCGSOFTCAR", (int32_t) TIOCGSOFTCAR)) {
            return;
        }
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "TIOCGSOFTCAR", TIOCGSOFTCAR)) {
            return;
        }
#endif
#elif defined(TIOCGSOFTCAR)
#error "TIOCGSOFTCAR defined"
#else
#endif

#if defined (__linux__)
#if defined(__sparc__)
        if (JnhwSetStaticIntDefineField(env, clazz, "TIOCSSOFTCAR", (int32_t) TIOCSSOFTCAR)) {
            return;
        }
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "TIOCSSOFTCAR", TIOCSSOFTCAR)) {
            return;
        }
#endif
#elif defined(TIOCSSOFTCAR)
#error "TIOCSSOFTCAR defined"
#else
#endif

        if (JnhwSetStaticIntField(env, clazz, "TIOCEXCL", TIOCEXCL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCSBRK", TIOCSBRK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCCBRK", TIOCCBRK)) {
            return;
        }

#if defined(__linux__) && defined(__sh__)
        if (JnhwSetStaticIntField(env, clazz, "TIOCMGET", (int32_t) TIOCMGET)) {
            return;
        }
#else
        if (JnhwSetStaticIntField(env, clazz, "TIOCMGET", TIOCMGET)) {
            return;
        }
#endif

#if defined(__APPLE__) || defined (__FreeBSD__) || defined (__OpenBSD__) || (defined(__linux__) && defined(__sparc__))
        //Just force the conversation or check at runtime sizeof??
        if (JnhwSetStaticIntField(env, clazz, "TIOCMSET", (int32_t) TIOCMSET)) {
            return;
        }
#else
        if (JnhwSetStaticIntField(env, clazz, "TIOCMSET", TIOCMSET)) {
            return;
        }
#endif

#if defined(__APPLE__) || defined (__FreeBSD__) || defined (__OpenBSD__) || (defined(__linux__) && defined(__sparc__))
        //Just force the conversation or check at runtime sizeof??
        if (JnhwSetStaticIntField(env, clazz, "TIOCMBIC", (int32_t) TIOCMBIC)) {
            return;
        }
#else
        if (JnhwSetStaticIntField(env, clazz, "TIOCMBIC", TIOCMBIC)) {
            return;
        }
#endif

#if defined(__APPLE__) || defined (__FreeBSD__) || defined (__OpenBSD__) || (defined(__linux__) && defined(__sparc__))
        //Just force the conversation or check at runtime sizeof??
        if (JnhwSetStaticIntField(env, clazz, "TIOCMBIS", (int32_t) TIOCMBIS)) {
            return;
        }
#else
        if (JnhwSetStaticIntField(env, clazz, "TIOCMBIS", TIOCMBIS)) {
            return;
        }
#endif

#if defined(__linux__) && defined(__sh__)
        if (JnhwSetStaticIntField(env, clazz, "TIOCOUTQ", (int32_t) TIOCOUTQ)) {
            return;
        }
#else
        if (JnhwSetStaticIntField(env, clazz, "TIOCOUTQ", TIOCOUTQ)) {
            return;
        }
#endif

#if defined (__OpenBSD__) || defined (__FreeBSD__)
        if (JnhwSetStaticIntDefineField(env, clazz, "IOCPARM_MASK", IOCPARM_MASK)) {
            return;
        }
#elif defined(IOCPARM_MASK)
#error "IOCPARM_MASK defined"
#endif

#if defined (__OpenBSD__) || defined (__FreeBSD__)
        if (JnhwSetStaticIntDefineField(env, clazz, "IOCPARM_MAX", IOCPARM_MAX)) {
            return;
        }
#elif defined(IOCPARM_MAX)
#error "IOCPARM_MAX defined"
#endif

#if defined (__OpenBSD__) || defined (__FreeBSD__)
        if (JnhwSetStaticIntDefineField(env, clazz, "IOC_VOID", IOC_VOID)) {
            return;
        }
#elif defined(IOC_VOID)
#error "IOC_VOID defined"
#endif

        if (JnhwSetStaticIntField(env, clazz, "IOC_OUT", (int32_t) IOC_OUT)) {
            return;
        }

        if (JnhwSetStaticIntField(env, clazz, "IOC_IN", (int32_t) IOC_IN)) {
            return;
        }

        if (JnhwSetStaticIntField(env, clazz, "IOC_INOUT", (int32_t) IOC_INOUT)) {
            return;
        }

#if defined (__OpenBSD__)|| defined (__FreeBSD__)
        if (JnhwSetStaticIntDefineField(env, clazz, "IOC_DIRMASK", (int32_t) IOC_DIRMASK)) {
            return;
        }
#elif defined(IOC_DIRMASK)
#error "IOC_DIRMASK defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "_IOC_NRBITS", _IOC_NRBITS)) {
            return;
        }
#elif defined(_IOC_NRBITS)
#error "_IOC_NRBITS defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "_IOC_TYPEBITS", _IOC_TYPEBITS)) {
            return;
        }
#elif defined(_IOC_TYPEBITS)
#error "_IOC_TYPEBITS defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "_IOC_SIZEBITS", _IOC_SIZEBITS)) {
            return;
        }
#elif defined(_IOC_SIZEBITS)
#error "_IOC_SIZEBITS defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "_IOC_DIRBITS", _IOC_DIRBITS)) {
            return;
        }
#elif defined(_IOC_DIRBITS)
#error "_IOC_DIRBITS defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "_IOC_NRMASK", _IOC_NRMASK)) {
            return;
        }
#elif defined(_IOC_NRMASK)
#error "_IOC_NRMASK defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "_IOC_TYPEMASK", _IOC_TYPEMASK)) {
            return;
        }
#elif defined(_IOC_TYPEMASK)
#error "_IOC_TYPEMASK defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "_IOC_SIZEMASK", _IOC_SIZEMASK)) {
            return;
        }
#elif defined(_IOC_SIZEMASK)
#error "_IOC_SIZEMASK defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "_IOC_DIRMASK", _IOC_DIRMASK)) {
            return;
        }
#elif defined(_IOC_DIRMASK)
#error "_IOC_DIRMASK defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "_IOC_NRSHIFT", _IOC_NRSHIFT)) {
            return;
        }
#elif defined(_IOC_NRSHIFT)
#error "_IOC_NRSHIFT defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "_IOC_TYPESHIFT", _IOC_TYPESHIFT)) {
            return;
        }
#elif defined(_IOC_TYPESHIFT)
#error "_IOC_TYPESHIFT defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "_IOC_SIZESHIFT", _IOC_SIZESHIFT)) {
            return;
        }
#elif defined(_IOC_SIZESHIFT)
#error "_IOC_SIZESHIFT defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "_IOC_DIRSHIFT", _IOC_DIRSHIFT)) {
            return;
        }
#elif defined(_IOC_DIRSHIFT)
#error "_IOC_DIRSHIFT defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "_IOC_NONE", _IOC_NONE)) {
            return;
        }
#elif defined(_IOC_NONE)
#error "_IOC_NONE defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "_IOC_READ", _IOC_READ)) {
            return;
        }
#elif defined(_IOC_READ)
#error "_IOC_READ defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "_IOC_WRITE", _IOC_WRITE)) {
            return;
        }
#elif defined(_IOC_WRITE)
#error "_IOC_WRITE defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "IOCSIZE_MASK", IOCSIZE_MASK)) {
            return;
        }
#elif defined(IOCSIZE_MASK)
#error "IOCSIZE_MASK defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "IOCSIZE_SHIFT", IOCSIZE_SHIFT)) {
            return;
        }
#elif defined(IOCSIZE_SHIFT)
#error "IOCSIZE_SHIFT defined"
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    _IOC
     * Signature: (ICII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl__1IOC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint dir, jchar type, jint nr, jint size) {
        return (int32_t) _IOC((uint32_t) dir, (uint32_t) type, (uint32_t) nr, (uint32_t) size);
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    _IO
     * Signature: (CI)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl__1IO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jchar type, jint nr) {
        return (int32_t) _IO((uint32_t) type, (uint32_t) nr);
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    _IOC_DIR
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl__1IOC_1DIR
#if defined(__linux__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint nr) {
        return (int32_t) _IOC_DIR((uint32_t) nr);
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint nr) {
        throw_NoSuchNativeMethodException(env, "_IOC_DIR");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    _IOC_TYPE
     * Signature: (I)C
     */
    JNIEXPORT jchar JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl__1IOC_1TYPE
#if defined(__linux__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint nr) {
        return (uint32_t) _IOC_TYPE((uint32_t) nr);
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint nr) {
        throw_NoSuchNativeMethodException(env, "_IOC_TYPE");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    _IOC_NR
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl__1IOC_1NR
#if defined(__linux__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint nr) {
        return _IOC_NR((uint32_t) nr);
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint nr) {
        throw_NoSuchNativeMethodException(env, "_IOC_NR");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    _IOC_SIZE
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl__1IOC_1SIZE
#if defined(__linux__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint nr) {
        return _IOC_SIZE((uint32_t) nr);
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint nr) {
        throw_NoSuchNativeMethodException(env, "_IOC_SIZE");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    IOCPARM_LEN
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_IOCPARM_1LEN
#if defined(__OpenBSD__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint x) {
        return IOCPARM_LEN((uint_32_t) x);
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint nr) {
        throw_NoSuchNativeMethodException(env, "IOCPARM_LEN");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    IOCBASECMD
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_IOCBASECMD
#if defined(__OpenBSD__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint x) {
        return IOCBASECMD((uint32_t) x)
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint x){
        throw_NoSuchNativeMethodException(env, "IOCBASECMD");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    IOCGROUP
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_IOCGROUP
#if defined(__OpenBSD__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint x) {
        return IOCGROUP((uint32_t) x);
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint x) {
        throw_NoSuchNativeMethodException(env, "IOCGROUP");
        return -1;
#endif
    }



#endif


#ifdef __cplusplus
}
#endif
