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
#include "de_ibapl_jnhw_util_posix_PosixDataTypeTest.h"

#ifdef __cplusplus
extern "C" {
#endif
    //We need the POSIX version ...
#if defined(HAVE_SYS_TYPES_H) && defined(_POSIX_VERSION)
#include <sys/types.h>
#include <termios.h>
#endif

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    JNHW__cc_t__IS__uint8_t
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_JNHW_1_1cc_1t_1_1IS_1_1uint8_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
#ifdef _JNHW__cc_t__IS__uint8_t
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    JNHW__clock_t__IS__int64_t
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_JNHW_1_1clock_1t_1_1IS_1_1int64_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
#ifdef _JNHW__clock_t__IS__int64_t
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    JNHW__clock_t__IS__int32_t
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_JNHW_1_1clock_1t_1_1IS_1_1int32_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
#ifdef _JNHW__clock_t__IS__int32_t
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    JNHW__off_t__IS__int64_t
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_JNHW_1_1off_1t_1_1IS_1_1int64_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
#ifdef _JNHW__off_t__IS__int64_t
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    JNHW__off_t__IS__int32_t
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_JNHW_1_1off_1t_1_1IS_1_1int32_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
#ifdef _JNHW__off_t__IS__int32_t
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    JNHW__mode_t__IS__uint16_t
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_JNHW_1_1mode_1t_1_1IS_1_1uint16_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
#ifdef _JNHW__mode_t__IS__uint16_t
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    JNHW__mode_t__IS__uint32_t
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_JNHW_1_1mode_1t_1_1IS_1_1uint32_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
#ifdef _JNHW__mode_t__IS__uint32_t
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    JNHW__pid_t__IS__int32_t
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_JNHW_1_1pid_1t_1_1IS_1_1int32_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
#ifdef _JNHW__pid_t__IS__int32_t
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    JNHW__speed_t__IS__uint32_t
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_JNHW_1_1speed_1t_1_1IS_1_1uint32_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
#ifdef _JNHW__speed_t__IS__uint32_t
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    JNHW__size_t__IS__uint64_t
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_JNHW_1_1size_1t_1_1IS_1_1uint64_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
#ifdef _JNHW__size_t__IS__uint64_t
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    JNHW__size_t__IS__uint32_t
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_JNHW_1_1size_1t_1_1IS_1_1uint32_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
#ifdef _JNHW__size_t__IS__uint32_t
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    JNHW__ssize_t__IS__int64_t
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_JNHW_1_1ssize_1t_1_1IS_1_1int64_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
#ifdef _JNHW__ssize_t__IS__int64_t
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    JNHW__ssize_t__IS__int32_t
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_JNHW_1_1ssize_1t_1_1IS_1_1int32_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
#ifdef _JNHW__ssize_t__IS__int32_t
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    JNHW__tcflag_t__IS__uint32_t
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_JNHW_1_1tcflag_1t_1_1IS_1_1uint32_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
#ifdef _JNHW__tcflag_t__IS__uint32_t
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    JNHW__time_t__IS__int64_t
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_JNHW_1_1time_1t_1_1IS_1_1int64_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
#ifdef _JNHW__time_t__IS__int64_t
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    JNHW__time_t__IS__int32_t
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_JNHW_1_1time_1t_1_1IS_1_1int32_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
#ifdef _JNHW__time_t__IS__int32_t
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    JNHW__uid_t__IS__uint32_t
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_JNHW_1_1uid_1t_1_1IS_1_1uint32_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
#ifdef _JNHW__uid_t__IS__uint32_t
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

#define TEST_PATTERN 0x8000000080008080L;

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    cc_t__isUnsigned
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_cc_1t_1_1isUnsigned
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return 0 < (cc_t) - 1;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    cc_t__AS_Uint64_t
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_cc_1t_1_1AS_1Uint64_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return (int64_t) (uint64_t) (cc_t) TEST_PATTERN;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    clock_t__isSigned
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_clock_1t_1_1isSigned
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return 0 > (clock_t) - 1;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    clock_t__AS_Uint64_t
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_clock_1t_1_1AS_1Uint64_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return (int64_t) (uint64_t) (clock_t) TEST_PATTERN;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    mode_t__isUnsigned
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_mode_1t_1_1isUnsigned
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return 0 < (mode_t) - 1;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    mode_t__AS_Uint64_t
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_mode_1t_1_1AS_1Uint64_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return (int64_t) (uint64_t) (mode_t) TEST_PATTERN;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    off_t__isSigned
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_off_1t_1_1isSigned
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return 0 > (off_t) - 1;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    off_t__AS_Uint64_t
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_off_1t_1_1AS_1Uint64_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return (int64_t) (uint64_t) (off_t) TEST_PATTERN;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    pid_t__isSigned
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_pid_1t_1_1isSigned
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return 0 > (pid_t) - 1;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    pid_t__AS_Uint64_t
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_pid_1t_1_1AS_1Uint64_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return (int64_t) (uint64_t) (pid_t) TEST_PATTERN;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    size_t__isUnsigned
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_size_1t_1_1isUnsigned
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return 0 < (size_t) - 1;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    size_t__AS_Uint64_t
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_size_1t_1_1AS_1Uint64_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return (int64_t) (uint64_t) (size_t) TEST_PATTERN;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    speed_t__isUnsigned
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_speed_1t_1_1isUnsigned
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return 0 < (speed_t) - 1;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    speed_t__AS_Uint64_t
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_speed_1t_1_1AS_1Uint64_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return (int64_t) (uint64_t) (speed_t) TEST_PATTERN;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    ssize_t__isSigned
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_ssize_1t_1_1isSigned
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return 0 > (ssize_t) - 1;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    ssize_t__AS_Uint64_t
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_ssize_1t_1_1AS_1Uint64_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return (int64_t) (uint64_t) (ssize_t) TEST_PATTERN;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    tcflag_t__isUnsigned
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_tcflag_1t_1_1isUnsigned
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return 0 < (tcflag_t) - 1;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    tcflag_t__AS_Uint64_t
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_tcflag_1t_1_1AS_1Uint64_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return (int64_t) (uint64_t) (tcflag_t) TEST_PATTERN;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    time_t__isSigned
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_time_1t_1_1isSigned
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return 0 > (time_t) - 1;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    time_t__AS_Uint64_t
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_time_1t_1_1AS_1Uint64_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return (int64_t) (uint64_t) (time_t) TEST_PATTERN;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    uid_t__isUnsigned
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_uid_1t_1_1isUnsigned
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return 0 < (uid_t) - 1;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_PosixDataTypeTest
     * Method:    uid_t__AS_Uint64_t
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_util_posix_PosixDataTypeTest_uid_1t_1_1AS_1Uint64_1t
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return (int64_t) (uint64_t) (uid_t) TEST_PATTERN;
    }

#ifdef __cplusplus
}
#endif