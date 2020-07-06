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
#include "de_ibapl_jnhw_posix_Time.h"

#ifdef HAVE_TIME_H
#include <time.h>
#include <unistd.h>
#endif

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION
#include <errno.h>
#include <signal.h>
#include <stdlib.h>


    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    asctime
     * Signature: (Lde/ibapl/jnhw/posix/Time$Tm;)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_asctime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject structTm) {
        if (structTm == NULL) {
            throw_NullPointerException(env, "tm is NULL");
            return NULL;
        }
        const char *result = asctime(UNWRAP_STRUCT_TM_PTR(structTm));
        if (result == NULL) {
            return NULL;
        } else {
            return (*env)->NewStringUTF(env, result);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    asctime_r
     * Signature: (Lde/ibapl/jnhw/posix/Time$Tm;Lde/ibapl/jnhw/OpaqueMemory;)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_asctime_1r
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject structTm, jobject buf) {
        if (structTm == NULL) {
            throw_NullPointerException(env, "tm is NULL");
            return NULL;
        }
        if (buf == NULL) {
            throw_NullPointerException(env, "buf is NULL");
            return NULL;
        }
        if (SIZE_OF_OPAQUE_MEM(buf) < 26) {
            throw_IllegalArgumentException(env, "buf is too small 26 bytes are the minimum");
            return NULL;
        }
        const char *result = asctime_r(UNWRAP_STRUCT_TM_PTR(structTm), UNWRAP_OPAQUE_MEM_TO_VOID_PTR(buf));
        if (result == NULL) {
            return NULL;
        } else {
            return (*env)->NewStringUTF(env, result);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    clock
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Time_clock
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return clock();
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    clock_getcpuclockid
     * Signature: (ILde/ibapl/jnhw/IntRef;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_clock_1getcpuclockid
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint pid, jobject clock_id) {
        if (clock_id == NULL) {
            throw_NullPointerException(env, "clock_id is NULL");
            return;
        }
        clockid_t _clock_id = GET_INT_REF_VALUE(clock_id);

        if (clock_getcpuclockid(pid, &_clock_id)) {
            throw_NativeErrorException(env, errno);
            return;
        }

        SET_INT_REF_VALUE(clock_id, _clock_id);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    clock_getres
     * Signature: (ILde/ibapl/jnhw/posix/Time$Timespec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_clock_1getres
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint clock_id, jobject timespec) {
        if (clock_getres(clock_id, UNWRAP_STRUCT_TIMESPEC_PTR_OR_NULL(timespec))) {
            throw_NativeErrorException(env, errno);
            return;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    clock_gettime
     * Signature: (ILde/ibapl/jnhw/posix/Time$Timespec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_clock_1gettime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint clock_id, jobject timespec) {
        if (timespec == NULL) {
            throw_NullPointerException(env, "timespec is NULL");
            return;
        }
        if (clock_gettime(clock_id, UNWRAP_STRUCT_TIMESPEC_PTR(timespec))) {
            throw_NativeErrorException(env, errno);
            return;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    clock_nanosleep
     * Signature: (IILde/ibapl/jnhw/posix/Time$Timespec;Lde/ibapl/jnhw/posix/Time$Timespec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_clock_1nanosleep
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint clockid, jint flags, jobject rqtp, jobject rmtp) {
        if (rqtp == NULL) {
            throw_NullPointerException(env, "rqtp is NULL");
            return;
        }
        if (clock_nanosleep(clockid, flags, UNWRAP_STRUCT_TIMESPEC_PTR(rqtp), UNWRAP_STRUCT_TIMESPEC_PTR_OR_NULL(rmtp))) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    clock_settime
     * Signature: (ILde/ibapl/jnhw/posix/Time$Timespec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_clock_1settime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint clock_id, jobject timespec) {
        if (timespec == NULL) {
            throw_NullPointerException(env, "timespec is NULL");
            return;
        }
        if (clock_settime(clock_id, UNWRAP_STRUCT_TIMESPEC_PTR(timespec))) {
            throw_NativeErrorException(env, errno);
            return;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    ctime
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_ctime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong clock) {
#if __WORDSIZE == 64
        const char *result = ctime(&clock);
#elif __WORDSIZE == 32
        //TODO linux arm needs long int int32_t will not suffice Why???
        const char *result = ctime((long int *) &clock);
#else
#error Unknown Wordsize
#endif
        if (result == NULL) {
            return NULL;
        } else {
            return (*env)->NewStringUTF(env, result);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    ctime_r
     * Signature: (JLde/ibapl/jnhw/OpaqueMemory;)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_ctime_1r
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong clock, jobject buf) {
        if (buf == NULL) {
            throw_NullPointerException(env, "buf is NULL");
            return NULL;
        }
        if (SIZE_OF_OPAQUE_MEM(buf) < 26) {
            throw_IllegalArgumentException(env, "buf is too small 26 bytes are the minimum");
            return NULL;
        }
#if __WORDSIZE == 64
        const char *result = ctime_r(&clock, UNWRAP_OPAQUE_MEM_TO_VOID_PTR(buf));
#elif __WORDSIZE == 32
        //TODO linux arm needs long int int32_t will not suffice Why???
        const char *result = ctime_r((long int*) &clock, UNWRAP_OPAQUE_MEM_TO_VOID_PTR(buf));
#else
#error Unknown Wordsize
#endif
        if (result == NULL) {
            return NULL;
        } else {
            return (*env)->NewStringUTF(env, result);
        }

    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    daylight
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_daylight
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return daylight;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    difftime
     * Signature: (JJ)D
     */
    JNIEXPORT jdouble JNICALL Java_de_ibapl_jnhw_posix_Time_difftime
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong time1, jlong time0) {
#if __WORDSIZE == 64
        return difftime(time1, time0);
#elif __WORDSIZE == 32
        //TODO linux arm needs long int int32_t will not suffice Why???
        return difftime((long int) time1, (long int) time0);
#else
#error Unknown Wordsize
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    getdate
     * Signature: (Ljava/lang/String;)Lde/ibapl/jnhw/posix/Time$Tm;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Time_getdate
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring string) {
        if (string == NULL) {
            throw_NullPointerException(env, "string is NULL");
            return NULL;
        }
        const char* _string = (*env)->GetStringUTFChars(env, string, NULL);
        const struct tm *tm = getdate(_string);
        (*env)->ReleaseStringUTFChars(env, string, _string);

        if (tm) {
            return WRAP_STATIC_STRUCT_TM(tm);
        } else {
            throw_NativeErrorException(env, getdate_err);
            return NULL;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    gmtime
     * Signature: (J)Lde/ibapl/jnhw/posix/Time$Tm;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Time_gmtime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong timer) {
#if __WORDSIZE == 64
        const struct tm *tm = gmtime(&timer);
#elif __WORDSIZE == 32
        //TODO linux arm needs long int int32_t will not suffice Why???
        const struct tm *tm = gmtime((long int*) &timer);
#else
#error Unknown Wordsize
#endif
        if (tm) {
            return WRAP_STATIC_STRUCT_TM(tm);
        } else {
            throw_NativeErrorException(env, errno);
            return NULL;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    gmtime_r
     * Signature: (JLde/ibapl/jnhw/posix/Time$Tm;)Lde/ibapl/jnhw/posix/Time$Tm;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Time_gmtime_1r
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong timer, jobject result) {
        if (result == NULL) {
            throw_NullPointerException(env, "result is NULL");
            return NULL;
        }
        struct tm *_result = UNWRAP_STRUCT_TM_PTR(result);
#if __WORDSIZE == 64
        if (gmtime_r(&timer, _result)) {
#elif __WORDSIZE == 32
        //TODO linux arm needs long int int32_t will not suffice Why???
        if (gmtime_r((long int*)&timer, _result)) {
#else
#error Unknown Wordsize
#endif
            return result;
        } else {
            return NULL;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    localtime
     * Signature: (J)Lde/ibapl/jnhw/posix/Time$Tm;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Time_localtime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong timer) {
#if __WORDSIZE == 64
        const struct tm *result = localtime(&timer);
#elif __WORDSIZE == 32
        //TODO linux arm needs long int int32_t will not suffice Why???
        const struct tm *result = localtime((long int*)&timer);
#else
#error Unknown Wordsize
#endif
        if (result) {
            return WRAP_STATIC_STRUCT_TM(result);
        } else {
            return NULL;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    localtime_r
     * Signature: (JLde/ibapl/jnhw/posix/Time$Tm;)Lde/ibapl/jnhw/posix/Time$Tm;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Time_localtime_1r
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong timer, jobject result) {
        if (result == NULL) {
            throw_NullPointerException(env, "result is NULL");
            return NULL;
        }
        struct tm *_result = UNWRAP_STRUCT_TM_PTR(result);
#if __WORDSIZE == 64
        if (localtime_r(&timer, _result)) {
#elif __WORDSIZE == 32
        //TODO linux arm needs long int int32_t will not suffice Why???
        if (localtime_r((long int*)&timer, _result)) {
#else
#error Unknown Wordsize
#endif
            return result;
        } else {
            return NULL;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    mktime
     * Signature: (Lde/ibapl/jnhw/posix/Time$Tm;)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Time_mktime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject timeptr) {
        if (timeptr == NULL) {
            throw_NullPointerException(env, "timeptr is NULL");
            return -1;
        }
        struct tm *_timeptr = UNWRAP_STRUCT_TM_PTR(timeptr);
        const time_t result = mktime(_timeptr);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    nanosleep
     * Signature: (Lde/ibapl/jnhw/posix/Time$Timespec;Lde/ibapl/jnhw/posix/Time$Timespec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_nanosleep
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject rqtp, jobject rmtp) {
        if (rqtp == NULL) {
            throw_NullPointerException(env, "rqtp is NULL");
            return;
        }
        if (nanosleep(UNWRAP_STRUCT_TIMESPEC_PTR(rqtp), UNWRAP_STRUCT_TIMESPEC_PTR_OR_NULL(rmtp))) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    strftime
     * Signature: (JLjava/lang/String;Lde/ibapl/jnhw/posix/Time/Tm;)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_strftime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong maxsize, jstring format, jobject timeptr) {
        if (maxsize < 0) {
            throw_IllegalArgumentException(env, "maxsize < 0");
            return NULL;
        }
        if (format == NULL) {
            throw_NullPointerException(env, "format is NULL");
            return NULL;
        }
        if (timeptr == NULL) {
            throw_NullPointerException(env, "timeptr is NULL");
            return NULL;
        }
        const char* _format = (*env)->GetStringUTFChars(env, format, NULL);
#if __WORDSIZE == 64
        char* _result = malloc((uint64_t) maxsize);
#elif __WORDSIZE == 32
        if ((maxsize > INT32_MAX) || (maxsize < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation maxsize is only an integer with the size of jint");
            return NULL;
        }
        char* _result = malloc((uint32_t) maxsize);
#else
#error Unknown Wordsize
#endif

#if __WORDSIZE == 64
        size_t count = strftime(_result, (uint64_t) maxsize, _format, UNWRAP_STRUCT_TM_PTR(timeptr));
#elif __WORDSIZE == 32
        if ((maxsize > INT32_MAX) || (maxsize < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation maxsize is only an integer with the size of jint");
            return NULL;
        }
        size_t count = strftime(_result, (uint32_t) maxsize, _format, UNWRAP_STRUCT_TM_PTR(timeptr));
#else
#error Unknown Wordsize
#endif

        (*env)->ReleaseStringUTFChars(env, format, _format);

        const jstring result = count == 0 ? NULL : (*env)->NewStringUTF(env, _result);
        free(_result);
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    strftime_l
     * Signature: (JLjava/lang/String;Lde/ibapl/jnhw/posix/Time/Tm;Lde/ibapl/jnhw/posix/Locale/Locale_t;)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_strftime_1l
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong maxsize, jstring format, jobject timeptr, jobject locale) {
        if (maxsize < 0) {
            throw_IllegalArgumentException(env, "maxsize < 0");
            return NULL;
        }
        if (format == NULL) {
            throw_NullPointerException(env, "format is NULL");
            return NULL;
        }
        if (timeptr == NULL) {
            throw_NullPointerException(env, "timeptr is NULL");
            return NULL;
        }
        if (locale == NULL) {
            throw_NullPointerException(env, "locale is NULL");
            return NULL;
        }
        const char* _format = (*env)->GetStringUTFChars(env, format, NULL);
#if __WORDSIZE == 64
        char* _result = malloc((uint64_t) maxsize);
#elif __WORDSIZE == 32
        if ((maxsize > INT32_MAX) || (maxsize < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation maxsize is only an integer with the size of jint");
            return NULL;
        }
        char* _result = malloc((uint32_t) maxsize);
#else
#error Unknown Wordsize
#endif

#if __WORDSIZE == 64
        size_t count = strftime_l(_result, (uint64_t) maxsize, _format, UNWRAP_STRUCT_TM_PTR(timeptr), UNWRAP_LOCALE_T(locale));
#elif __WORDSIZE == 32
        if ((maxsize > INT32_MAX) || (maxsize < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation maxsize is only an integer with the size of jint");
            return NULL;
        }
        size_t count = strftime_l(_result, (uint32_t) maxsize, _format, UNWRAP_STRUCT_TM_PTR(timeptr), UNWRAP_LOCALE_T(locale));
#else
#error Unknown Wordsize
#endif
        (*env)->ReleaseStringUTFChars(env, format, _format);

        const jstring result = count == 0 ? NULL : (*env)->NewStringUTF(env, _result);
        free(_result);
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    strptime
     * Signature: (Ljava/lang/String;Ljava/lang/String;Lde/ibapl/jnhw/posix/Time$Tm;)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_strptime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring buf, jstring format, jobject tm) {
        if (buf == NULL) {
            throw_NullPointerException(env, "buf is NULL");
            return NULL;
        }
        if (format == NULL) {
            throw_NullPointerException(env, "format is NULL");
            return NULL;
        }
        if (tm == NULL) {
            throw_NullPointerException(env, "tm is NULL");
            return NULL;
        }
        const char* _buf = (*env)->GetStringUTFChars(env, buf, NULL);
        const char* _format = (*env)->GetStringUTFChars(env, format, NULL);

        char* result = strptime(_buf, _format, UNWRAP_STRUCT_TM_PTR(tm));

        (*env)->ReleaseStringUTFChars(env, buf, _buf);
        (*env)->ReleaseStringUTFChars(env, format, _format);
        if (result == NULL) {
            return NULL;
        } else {
            return (*env)->NewStringUTF(env, result);
        }

    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    time
     * Signature: (Lde/ibapl/jnhw/LongRef;)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Time_time
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject tloc) {
        time_t result;
        if (tloc) {
#if __WORDSIZE == 64
            time_t _tloc = GET_LONG_REF_VALUE(tloc);
#elif __WORDSIZE == 32
        jlong __tloc = GET_LONG_REF_VALUE(tloc);
        if ((__tloc > INT32_MAX) || (__tloc < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation tloc is only an integer with the size of jint");
            return 0;
        }
        time_t _tloc = (long int)__tloc;
#else
#error Unknown Wordsize
#endif
            result = time(&_tloc);
            SET_LONG_REF_VALUE(tloc, _tloc);
        } else {
            result = time(NULL);
        }
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timer_create
     * Signature: (ILde/ibapl/jnhw/posix/Signal/Sigevent;Lde/ibapl/jnhw/posix/Time/Timer_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1create
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint clockid, jobject evp, jobject timerid) {
        if (timerid == NULL) {
            throw_NullPointerException(env, "timerid is NULL");
            return;
        }
        if (timer_create(clockid, UNWRAP_STRUCT_SIGEVENT_PTR_OR_NULL(evp), UNWRAP_TIMER_T_PTR(timerid))) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timer_delete
     * Signature: (Lde/ibapl/jnhw/posix/Time/Timer_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1delete
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject timerid) {
        if (timerid == NULL) {
            throw_NullPointerException(env, "timerid is NULL");
            return;
        }
        if (timer_delete(*UNWRAP_TIMER_T_PTR(timerid))) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timer_getoverrun
     * Signature: (Lde/ibapl/jnhw/posix/Time/Timer_t;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1getoverrun
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject timerid) {
        if (timerid == NULL) {
            throw_NullPointerException(env, "timerid is NULL");
            return -1;
        }
        int result = timer_getoverrun(*UNWRAP_TIMER_T_PTR(timerid));
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timer_gettime
     * Signature: (Lde/ibapl/jnhw/posix/Time/Timer_t;Lde/ibapl/jnhw/posix/Time/Itimerspec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1gettime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject timerid, jobject value) {
        if (timerid == NULL) {
            throw_NullPointerException(env, "timerid is NULL");
            return;
        }
        if (timer_gettime(*UNWRAP_TIMER_T_PTR(timerid), UNWRAP_STRUCT_ITIMERSPEC_T_PTR(value))) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timer_settime
     * Signature: (Lde/ibapl/jnhw/posix/Time/Timer_t;ILde/ibapl/jnhw/posix/Time/Itimerspec;Lde/ibapl/jnhw/posix/Time/Itimerspec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1settime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject timerid, jint flags, jobject value, jobject ovalue) {
        if (timerid == NULL) {
            throw_NullPointerException(env, "timerid is NULL");
            return;
        }
        if (timer_settime(*UNWRAP_TIMER_T_PTR(timerid), flags, UNWRAP_STRUCT_ITIMERSPEC_T_PTR_OR_NULL(value), UNWRAP_STRUCT_ITIMERSPEC_T_PTR_OR_NULL(ovalue))) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timezone
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Time_timezone
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return timezone;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    tzname
     * Signature: ()[Ljava/lang/String;
     */
    JNIEXPORT jobjectArray JNICALL Java_de_ibapl_jnhw_posix_Time_tzname
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        jclass StringClass = (*env)->FindClass(env, "java/lang/String");
        if (StringClass == NULL) {
            return NULL;
        }
        jobjectArray result = (*env)->NewObjectArray(env, 2, StringClass, NULL);
        if (result == NULL) {
            return NULL;
        }
        (*env)->DeleteLocalRef(env, StringClass);
        (*env)->SetObjectArrayElement(env, result, 0, (*env)->NewStringUTF(env, tzname[0]));
        (*env)->SetObjectArrayElement(env, result, 1, (*env)->NewStringUTF(env, tzname[1]));
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    tzset
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_tzset
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        tzset();
    }

#endif
#ifdef __cplusplus
}
#endif