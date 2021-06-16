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
#include "de_ibapl_jnhw_posix_TimeTest_NativeTimespec.h"
#include "de_ibapl_jnhw_posix_TimeTest_NativeItimerspec.h"
#include "de_ibapl_jnhw_posix_TimeTest_NativeTimer_t.h"
#include "de_ibapl_jnhw_posix_TimeTest_NativeTm.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION
#include <time.h>

    //for offsetof
#include <stddef.h>

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeTimespec
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeTimespec_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct timespec);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeTimespec
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeTimespec_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct timespec);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeTimespec
     * Method:    tv_sec
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeTimespec_tv_1sec
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct timespec, tv_sec);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeTimespec
     * Method:    tv_nsec
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeTimespec_tv_1nsec
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct timespec, tv_nsec);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeItimerspec
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeItimerspec_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct itimerspec);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeItimerspec
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeItimerspec_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct itimerspec);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeItimerspec
     * Method:    it_interval
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeItimerspec_it_1interval
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct itimerspec, it_interval);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeItimerspec
     * Method:    it_value
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeItimerspec_it_1value
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct itimerspec, it_value);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeTimer_t
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeTimer_1t_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (timer_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeTimer_t
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeTimer_1t_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (timer_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeTm
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeTm_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct tm);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeTm
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeTm_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct tm);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeTm
     * Method:    tm_sec
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeTm_tm_1sec
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct tm, tm_sec);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeTm
     * Method:    tm_min
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeTm_tm_1min
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct tm, tm_min);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeTm
     * Method:    tm_hour
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeTm_tm_1hour
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct tm, tm_hour);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeTm
     * Method:    tm_mday
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeTm_tm_1mday
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct tm, tm_mday);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeTm
     * Method:    tm_mon
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeTm_tm_1mon
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct tm, tm_mon);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeTm
     * Method:    tm_year
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeTm_tm_1year
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct tm, tm_year);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeTm
     * Method:    tm_wday
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeTm_tm_1wday
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct tm, tm_wday);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeTm
     * Method:    tm_yday
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeTm_tm_1yday
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct tm, tm_yday);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeTm
     * Method:    tm_isdst
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeTm_tm_1isdst
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct tm, tm_isdst);
    }

#endif
#ifdef __cplusplus
}
#endif
