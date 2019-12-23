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
#include "de_ibapl_jnhw_posix_Time_Tm.h"

#ifdef HAVE_TIME_H

#include <time.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    sizeofTm
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_sizeofTm
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct tm);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    tm_sec
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_tm_1sec__
    (JNIEnv *env, jobject structTm) {
        return (UNWRAP_STRUCT_TM_PTR(structTm))->tm_sec;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    tm_min
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_tm_1min__
    (JNIEnv *env, jobject structTm) {
        return (UNWRAP_STRUCT_TM_PTR(structTm))->tm_min;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    tm_hour
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_tm_1hour__
    (JNIEnv *env, jobject structTm) {
        return (UNWRAP_STRUCT_TM_PTR(structTm))->tm_hour;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    tm_mday
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_tm_1mday__
    (JNIEnv *env, jobject structTm) {
        return (UNWRAP_STRUCT_TM_PTR(structTm))->tm_mday;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    tm_mon
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_tm_1mon__
    (JNIEnv *env, jobject structTm) {
        return (UNWRAP_STRUCT_TM_PTR(structTm))->tm_mon;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    tm_year
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_tm_1year__
    (JNIEnv *env, jobject structTm) {
        return (UNWRAP_STRUCT_TM_PTR(structTm))->tm_year;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    tm_wday
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_tm_1wday__
    (JNIEnv *env, jobject structTm) {
        return (UNWRAP_STRUCT_TM_PTR(structTm))->tm_wday;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    tm_yday
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_tm_1yday__
    (JNIEnv *env, jobject structTm) {
        return (UNWRAP_STRUCT_TM_PTR(structTm))->tm_yday;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    tm_isdst
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_tm_1isdst__
    (JNIEnv *env, jobject structTm) {
        return (UNWRAP_STRUCT_TM_PTR(structTm))->tm_isdst;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    tm_sec
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_tm_1sec__I
    (JNIEnv *env, jobject structTm, jint tm_sec) {
        (UNWRAP_STRUCT_TM_PTR(structTm))->tm_sec = tm_sec;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    tm_min
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_tm_1min__I
    (JNIEnv *env, jobject structTm, jint tm_min) {
        (UNWRAP_STRUCT_TM_PTR(structTm))->tm_min = tm_min;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    tm_hour
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_tm_1hour__I
    (JNIEnv *env, jobject structTm, jint tm_hour) {
        (UNWRAP_STRUCT_TM_PTR(structTm))->tm_hour = tm_hour;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    tm_mday
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_tm_1mday__I
    (JNIEnv *env, jobject structTm, jint tm_mday) {
        (UNWRAP_STRUCT_TM_PTR(structTm))->tm_mday = tm_mday;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    tm_mon
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_tm_1mon__I
    (JNIEnv *env, jobject structTm, jint tm_mon) {
        (UNWRAP_STRUCT_TM_PTR(structTm))->tm_mon = tm_mon;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    tm_year
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_tm_1year__I
    (JNIEnv *env, jobject structTm, jint tm_year) {
        (UNWRAP_STRUCT_TM_PTR(structTm))->tm_year = tm_year;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    tm_wday
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_tm_1wday__I
    (JNIEnv *env, jobject structTm, jint tm_wday) {
        (UNWRAP_STRUCT_TM_PTR(structTm))->tm_wday = tm_wday;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    tm_yday
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_tm_1yday__I
    (JNIEnv *env, jobject structTm, jint tm_yday) {
        (UNWRAP_STRUCT_TM_PTR(structTm))->tm_yday = tm_yday;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    tm_isdst
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_tm_1isdst__I
    (JNIEnv *env, jobject structTm, jint tm_isdst) {
        (UNWRAP_STRUCT_TM_PTR(structTm))->tm_isdst = tm_isdst;
    }

#ifdef __cplusplus
}
#endif
#endif
