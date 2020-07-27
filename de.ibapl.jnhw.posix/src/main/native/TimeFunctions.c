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

#if defined (__APPLE__) 
#include <xlocale.h>
#endif

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
#if defined (__APPLE__)
        return (int64_t)clock();
#else
        return clock();
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    clock_getcpuclockid
     * Signature: (ILde/ibapl/jnhw/IntRef;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_clock_1getcpuclockid
#if defined (__APPLE__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint pid, __attribute__ ((unused)) jobject clock_id) {
        throw_NoSuchNativeMethodException(env, "clock_getcpuclockid");
#else
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
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    clock_getres
     * Signature: (ILde/ibapl/jnhw/posix/Time$Timespec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_clock_1getres
#if defined (__APPLE__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint clock_id, __attribute__ ((unused)) jobject timespec) {
        throw_NoSuchNativeMethodException(env, "clock_getres");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint clock_id, jobject timespec) {
        if (clock_getres(clock_id, UNWRAP_STRUCT_TIMESPEC_PTR_OR_NULL(timespec))) {
            throw_NativeErrorException(env, errno);
            return;
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    clock_gettime
     * Signature: (ILde/ibapl/jnhw/posix/Time$Timespec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_clock_1gettime
#if defined (__APPLE__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint clock_id, __attribute__ ((unused)) jobject timespec) {
        throw_NoSuchNativeMethodException(env, "clock_gettime");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint clock_id, jobject timespec) {
        if (timespec == NULL) {
            throw_NullPointerException(env, "timespec is NULL");
            return;
        }
        if (clock_gettime(clock_id, UNWRAP_STRUCT_TIMESPEC_PTR(timespec))) {
            throw_NativeErrorException(env, errno);
            return;
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    clock_nanosleep
     * Signature: (IILde/ibapl/jnhw/posix/Time$Timespec;Lde/ibapl/jnhw/posix/Time$Timespec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_clock_1nanosleep
#if defined (__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint clockid, __attribute__ ((unused)) jint flags, __attribute__ ((unused)) jobject rqtp, __attribute__ ((unused)) jobject rmtp) {
        throw_NoSuchNativeMethodException(env, "clock_nanosleep");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint clockid, jint flags, jobject rqtp, jobject rmtp) {
        if (rqtp == NULL) {
            throw_NullPointerException(env, "rqtp is NULL");
            return;
        }
        if (clock_nanosleep(clockid, flags, UNWRAP_STRUCT_TIMESPEC_PTR(rqtp), UNWRAP_STRUCT_TIMESPEC_PTR_OR_NULL(rmtp))) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    clock_settime
     * Signature: (ILde/ibapl/jnhw/posix/Time$Timespec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_clock_1settime
#if defined (__APPLE__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint clock_id, __attribute__ ((unused)) jobject timespec) {
        throw_NoSuchNativeMethodException(env, "clock_settime");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint clock_id, jobject timespec) {
        if (timespec == NULL) {
            throw_NullPointerException(env, "timespec is NULL");
            return;
        }
        if (clock_settime(clock_id, UNWRAP_STRUCT_TIMESPEC_PTR(timespec))) {
            throw_NativeErrorException(env, errno);
            return;
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    ctime
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_ctime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong clock) {
#if __SIZEOF_LONG__ == 8
#if defined (__APPLE__)
        const char *result = ctime((long *) & clock);
#else
        const char *result = ctime((int64_t *) & clock);
#endif
#elif __SIZEOF_LONG__ == 4
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
#if __SIZEOF_LONG__ == 8
#if defined (__APPLE__)
        const char *result = ctime_r((long *) & clock, UNWRAP_OPAQUE_MEM_TO_VOID_PTR(buf));
#else
        const char *result = ctime_r((int64_t *) & clock, UNWRAP_OPAQUE_MEM_TO_VOID_PTR(buf));
#endif
#elif __SIZEOF_LONG__ == 4
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
#if defined(__FreeBSD__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        throw_NoSuchNativeMethodException(env, "daylight");
        return 0;
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return daylight;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    difftime
     * Signature: (JJ)D
     */
    JNIEXPORT jdouble JNICALL Java_de_ibapl_jnhw_posix_Time_difftime
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong time1, jlong time0) {
#if __SIZEOF_LONG__ == 8
        return difftime(time1, time0);
#elif __SIZEOF_LONG__ == 4
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
#if defined(__FreeBSD__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jstring string) {
        throw_NoSuchNativeMethodException(env, "getdate");
        return NULL;
#else
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
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    gmtime
     * Signature: (J)Lde/ibapl/jnhw/posix/Time$Tm;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Time_gmtime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong timer) {
#if __SIZEOF_LONG__ == 8
#if defined (__APPLE__)
        const struct tm *tm = gmtime((long *) & timer);
#else
        const struct tm *tm = gmtime((int64_t *) & timer);
#endif
#elif __SIZEOF_LONG__ == 4
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
#if __SIZEOF_LONG__ == 8
#if defined (__APPLE__)
        if (gmtime_r((long *) & timer, _result)) {
#else
        if (gmtime_r((int64_t *) & timer, _result)) {
#endif
#elif __SIZEOF_LONG__ == 4
        //TODO linux arm needs long int int32_t will not suffice Why???
        if (gmtime_r((long int*) &timer, _result)) {
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
#if __SIZEOF_LONG__ == 8
#if defined (__APPLE__)
        const struct tm *result = localtime((long *) & timer);
#else
        const struct tm *result = localtime((int64_t *) & timer);
#endif
#elif __SIZEOF_LONG__ == 4
        //TODO linux arm needs long int int32_t will not suffice Why???
        const struct tm *result = localtime((long int*) &timer);
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
#if __SIZEOF_LONG__ == 8
#if defined (__APPLE__)
        if (localtime_r((long *) & timer, _result)) {
#else
        if (localtime_r((int64_t *) & timer, _result)) {
#endif
#elif __SIZEOF_LONG__ == 4
        //TODO linux arm needs long int int32_t will not suffice Why???
        if (localtime_r((long int*) &timer, _result)) {
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
#if __SIZEOF_LONG__ == 8
        char* _result = malloc((uint64_t) maxsize);
#elif __SIZEOF_LONG__ == 4
        if ((maxsize > INT32_MAX) || (maxsize < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation maxsize is only an integer with the size of jint");
            return NULL;
        }
        char* _result = malloc((uint32_t) maxsize);
#else
#error Unknown Wordsize
#endif

#if __SIZEOF_LONG__ == 8
        size_t count = strftime(_result, (uint64_t) maxsize, _format, UNWRAP_STRUCT_TM_PTR(timeptr));
#elif __SIZEOF_LONG__ == 4
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
#if __SIZEOF_LONG__ == 8
        char* _result = malloc((uint64_t) maxsize);
#elif __SIZEOF_LONG__ == 4
        if ((maxsize > INT32_MAX) || (maxsize < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation maxsize is only an integer with the size of jint");
            return NULL;
        }
        char* _result = malloc((uint32_t) maxsize);
#else
#error Unknown Wordsize
#endif

#if __SIZEOF_LONG__ == 8
        size_t count = strftime_l(_result, (uint64_t) maxsize, _format, UNWRAP_STRUCT_TM_PTR(timeptr), UNWRAP_LOCALE_T(locale));
#elif __SIZEOF_LONG__ == 4
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
#if __SIZEOF_LONG__ == 8
            time_t _tloc = GET_LONG_REF_VALUE(tloc);
#elif __SIZEOF_LONG__ == 4
            jlong __tloc = GET_LONG_REF_VALUE(tloc);
            if ((__tloc > INT32_MAX) || (__tloc < INT32_MIN)) {
                throw_IndexOutOfBoundsException(env, "In this native implementation tloc is only an integer with the size of jint");
                return 0;
            }
            time_t _tloc = (long int) __tloc;
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
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint clockid, __attribute__ ((unused)) jobject evp, __attribute__ ((unused)) jobject timerid) {
        throw_NoSuchNativeMethodException(env, "timer_create");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint clockid, jobject evp, jobject timerid) {
        if (timerid == NULL) {
            throw_NullPointerException(env, "timerid is NULL");
            return;
        }
        if (timer_create(clockid, UNWRAP_STRUCT_SIGEVENT_PTR_OR_NULL(evp), UNWRAP_TIMER_T_PTR(timerid))) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timer_delete
     * Signature: (Lde/ibapl/jnhw/posix/Time/Timer_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1delete
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jobject timerid) {
        throw_NoSuchNativeMethodException(env, "timer_delete");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject timerid) {
        if (timerid == NULL) {
            throw_NullPointerException(env, "timerid is NULL");
            return;
        }
        if (timer_delete(*UNWRAP_TIMER_T_PTR(timerid))) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timer_getoverrun
     * Signature: (Lde/ibapl/jnhw/posix/Time/Timer_t;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1getoverrun
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jobject timerid) {
        throw_NoSuchNativeMethodException(env, "timer_getoverrun");
        return -1;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject timerid){
        if (timerid == NULL) {
            throw_NullPointerException(env, "timerid is NULL");
            return -1;
        }
        int result = timer_getoverrun(*UNWRAP_TIMER_T_PTR(timerid));
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timer_gettime
     * Signature: (Lde/ibapl/jnhw/posix/Time/Timer_t;Lde/ibapl/jnhw/posix/Time/Itimerspec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1gettime
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jobject timerid, __attribute__ ((unused)) jobject value) {
        throw_NoSuchNativeMethodException(env, "timer_gettime");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject timerid, jobject value) {
        if (timerid == NULL) {
            throw_NullPointerException(env, "timerid is NULL");
            return;
        }
        if (timer_gettime(*UNWRAP_TIMER_T_PTR(timerid), UNWRAP_STRUCT_ITIMERSPEC_T_PTR(value))) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timer_settime
     * Signature: (Lde/ibapl/jnhw/posix/Time/Timer_t;ILde/ibapl/jnhw/posix/Time/Itimerspec;Lde/ibapl/jnhw/posix/Time/Itimerspec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1settime
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jobject timerid, __attribute__ ((unused)) jint flags, __attribute__ ((unused)) jobject value, __attribute__ ((unused)) jobject ovalue) {
        throw_NoSuchNativeMethodException(env, "timer_settime");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject timerid, jint flags, jobject value, jobject ovalue) {
        if (timerid == NULL) {
            throw_NullPointerException(env, "timerid is NULL");
            return;
        }
        if (timer_settime(*UNWRAP_TIMER_T_PTR(timerid), flags, UNWRAP_STRUCT_ITIMERSPEC_T_PTR_OR_NULL(value), UNWRAP_STRUCT_ITIMERSPEC_T_PTR_OR_NULL(ovalue))) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timezone
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Time_timezone
#if defined(__FreeBSD__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        throw_NoSuchNativeMethodException(env, "timezone");
        return 0;
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return timezone;
#endif
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
