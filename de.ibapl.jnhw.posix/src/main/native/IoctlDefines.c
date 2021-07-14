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

#else
#include <sys/ioctl.h>

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
#if defined(__FreeBSD__) || defined(__OpenBSD__) || defined(__APPLE__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint x) {
        return IOCPARM_LEN((uint32_t) x);
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
#if defined(__FreeBSD__)|| defined(__APPLE__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint x) {
        return IOCBASECMD(x);
#elif defined(__OpenBSD__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint x) {
        return (int32_t) IOCBASECMD((uint32_t) x);
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint x) {
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
#if defined(__FreeBSD__) || defined(__OpenBSD__)|| defined(__APPLE__)
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
