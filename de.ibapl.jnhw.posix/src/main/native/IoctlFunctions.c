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

#ifdef HAVE_SYS_IOCTL_H

#include "de_ibapl_jnhw_unix_sys_Ioctl.h"
#include <sys/ioctl.h>
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    _IOC
     * Signature: (ICII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl__1IOC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint dir, jchar type, jint nr, jint size) {
        return (int32_t) _IOC(dir, type, nr, size);
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    _IO
     * Signature: (CI)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl__1IO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jchar type, jint nr) {
        return (int32_t) _IO(type, (uint32_t) nr);
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    _IOC_DIR
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl__1IOC_1DIR
#if defined(__linux__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint nr) {
        return (int32_t) _IOC_DIR(nr);
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
        return (uint32_t) _IOC_TYPE(nr);
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint nr) {
        throw_NoSuchNativeMethodException(env, "_IOC_TYPE");
        return -1;
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
        return _IOC_NR(nr);
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
        return _IOC_SIZE(nr);
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
        return IOCPARM_LEN(x);
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
        return IOCBASECMD(x)
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
        return IOCGROUP(x);
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint x) {
        throw_NoSuchNativeMethodException(env, "IOCGROUP");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    ioctl
     * Signature: (II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_ioctl__II
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jint request) {
        const int result = ioctl(fd, (uint32_t) request);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    ioctl
     * Signature: (IILde/ibapl/jnhw/common/references/IntRef;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_ioctl__IILde_ibapl_jnhw_common_references_IntRef_2
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jint request, jobject value) {

        if (value == NULL) {
            throw_NullPointerException(env, "value is null");
            return -1;
        }
        const int _intRef = GET_INT_REF_VALUE(value);

        const int result = ioctl(fd, (uint32_t) request, &_intRef);
        SET_INT_REF_VALUE(value, _intRef);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    ioctl
     * Signature: (IILde/ibapl/jnhw/common/memory/OpaqueMemory32;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_ioctl__IILde_ibapl_jnhw_common_memory_OpaqueMemory32_2
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jint request, jobject value) {

        if (value == NULL) {
            throw_NullPointerException(env, "value is null");
            return -1;
        }

        const int result = ioctl(fd, (uint32_t) request, UNWRAP_ABSTRACT_MEM_TO(void*, value));
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

#ifdef __cplusplus
}
#endif
#endif
