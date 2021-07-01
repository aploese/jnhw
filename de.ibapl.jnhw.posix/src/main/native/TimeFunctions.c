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

    JNHW_ASSERT__clock_t__IS__int64_t__OR__int32_t
    JNHW_ASSERT__clockid_t__IS__int32_t
    JNHW_ASSERT__pid_t__IS__int32_t
    JNHW_ASSERT__size_t__IS__uint64_t__OR__uint32_t
    JNHW_ASSERT__time_t__IS__int64_t__OR__int32_t

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    asctime
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_asctime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrStructTm) {
        const char *result = asctime((struct tm*) (uintptr_t) ptrStructTm);
        if (result == NULL) {
            return NULL;
        } else {
            return (*env)->NewStringUTF(env, result);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    asctime_r
     * Signature: (JJ)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_asctime_1r
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrStructTm, jlong ptrBuf) {
        const char *result = asctime_r((struct tm*) (uintptr_t) ptrStructTm, (void*) (uintptr_t) ptrBuf);
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
     * Signature: (I)V
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_clock_1getcpuclockid
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint pid) {
        clockid_t _clock_id;

        if (clock_getcpuclockid(pid, &_clock_id)) {
            throw_NativeErrorException(env, errno);
        }

        return _clock_id;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    clock_getres
     * Signature: (IJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_clock_1getres
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint clock_id, jlong ptrTimespec) {
        if (clock_getres(clock_id, (struct timespec*) (uintptr_t) ptrTimespec)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    clock_gettime
     * Signature: (IL)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_clock_1gettime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint clock_id, jlong ptrTimespec) {
        if (clock_gettime(clock_id, (struct timespec*) (uintptr_t) ptrTimespec)) {
            throw_NativeErrorException(env, errno);
            return;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    clock_nanosleep
     * Signature: (IIJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_clock_1nanosleep
#if defined (__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint clockid, __attribute__ ((unused)) jint flags, __attribute__ ((unused)) jlong ptrRqtp, __attribute__ ((unused)) jlong ptrRmtp) {
        throw_NoSuchNativeMethodException(env, "clock_nanosleep");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint clockid, jint flags, jlong ptrRqtp, jlong ptrRmtp) {
        if (clock_nanosleep(clockid, flags, (struct timespec*) (uintptr_t) ptrRqtp, (struct timespec*) (uintptr_t) ptrRmtp)) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    clock_settime
     * Signature: (IJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_clock_1settime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint clock_id, jlong ptrTimespec) {
        if (clock_settime(clock_id, (struct timespec*) (uintptr_t) ptrTimespec)) {
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
#if defined(_JNHW__time_t__IS__int64_t)
        const char *result = ctime((int64_t *) & clock);
#elif defined(_JNHW__time_t__IS__int32_t)
        if ((clock > INT32_MAX) || (clock < INT32_MIN)) {
            throw_IllegalArgumentException(env, "clock outside time_t(int32_t)");
            return NULL;
        }
        const char *result = ctime(__jlong2long_PTR(clock));
#else
#error expected time_t is int32_t or int64_t
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
     * Signature: (JJ)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_ctime_1r
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong clock, jlong ptrBuf) {
#if defined(_JNHW__time_t__IS__int64_t)
        const char *result = ctime_r((int64_t *) & clock, (void*) (uintptr_t) ptrBuf);
#elif defined(_JNHW__time_t__IS__int32_t)
        if ((clock > INT32_MAX) || (clock < INT32_MIN)) {
            throw_IllegalArgumentException(env, "clock outside time_t(int32_t)");
            return NULL;
        }
        const char *result = ctime_r(__jlong2long_PTR(clock), (void*) (uintptr_t) ptrBuf);
#else
#error expected time_t is int32_t or int64_t
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
#if defined(_JNHW__time_t__IS__int32_t)
        if ((time1 > INT32_MAX) || (time1 < INT32_MIN)) {
            throw_IllegalArgumentException(env, "time1 outside time_t(int32_t)");
            return 0;
        }
        if ((time0 > INT32_MAX) || (time0 < INT32_MIN)) {
            throw_IllegalArgumentException(env, "time0 outside time_t(int32_t)");
            return 0;
        }
#elif defined(_JNHW__time_t__IS__int64_t)
#else
#error expected time_t is int32_t or int64_t
#endif
        return difftime((time_t) time1, (time_t) time0);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    getdate0
     * Signature: (Ljava/lang/String;)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Time_getdate0
#if defined(__FreeBSD__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jstring string) {
        throw_NoSuchNativeMethodException(env, "getdate");
        return (jlong) (uintptr_t) NULL;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring string) {
        const char* _string = (*env)->GetStringUTFChars(env, string, NULL);
        const struct tm *tm = getdate(_string);
        (*env)->ReleaseStringUTFChars(env, string, _string);

        if (tm) {
            return (jlong) (uintptr_t) tm;
        } else {
            throw_NativeErrorException(env, getdate_err);
            return (jlong) (uintptr_t) NULL;
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    gmtime0
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Time_gmtime0
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong timer) {
#if defined(_JNHW__time_t__IS__int64_t)
        const struct tm *tm = gmtime((int64_t *) & timer);
#elif defined(_JNHW__time_t__IS__int32_t)
        if ((timer > INT32_MAX) || (timer < INT32_MIN)) {
            throw_IllegalArgumentException(env, "timer outside time_t(int32_t)");
            return (jlong) (uintptr_t) NULL;
        }
        const struct tm *tm = gmtime(__jlong2long_PTR(timer));
#else
#error expected time_t is int32_t or int64_t
#endif
        if (tm) {
            return (jlong) (uintptr_t) tm;
        } else {
            throw_NativeErrorException(env, errno);
            return (jlong) (uintptr_t) NULL;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    gmtime_r
     * Signature: (JJ)
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_gmtime_1r
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong timer, jlong ptrResult) {
#if defined(_JNHW__time_t__IS__int64_t)
        if (gmtime_r((int64_t *) & timer, (struct tm*) (uintptr_t) ptrResult)) {
#elif defined(_JNHW__time_t__IS__int32_t)
        if ((timer > INT32_MAX) || (timer < INT32_MIN)) {
            throw_IllegalArgumentException(env, "timer outside time_t(int32_t)");
            return;
        }
        if (gmtime_r(__jlong2long_PTR(timer), (struct tm*) (uintptr_t) ptrResult)) {
#else
#error expected time_t is int32_t or int64_t
#endif
        } else {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    localtime0
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Time_localtime0
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong timer) {
#if defined(_JNHW__time_t__IS__int64_t)
        const struct tm *result = localtime((int64_t *) & timer);
#elif defined(_JNHW__time_t__IS__int32_t)
        if ((timer > INT32_MAX) || (timer < INT32_MIN)) {
            throw_IllegalArgumentException(env, "timer outside time_t(int32_t)");
            return (jlong) (uintptr_t) NULL;
        }
        const struct tm *result = localtime(__jlong2long_PTR(timer));
#else
#error expected time_t is int32_t or int64_t
#endif
        if (result) {
            return (jlong) (uintptr_t) result;
        } else {
            throw_NativeErrorException(env, errno);
            return (jlong) (uintptr_t) NULL;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    localtime_r
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_localtime_1r
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong timer, jlong ptrResult) {
#if defined(_JNHW__time_t__IS__int64_t)
        if (localtime_r((int64_t *) & timer, (struct tm*) (uintptr_t) ptrResult)) {
#elif defined(_JNHW__time_t__IS__int32_t)
        if ((timer > INT32_MAX) || (timer < INT32_MIN)) {
            throw_IllegalArgumentException(env, "timer outside time_t(int32_t)");
            return;
        }
        if (localtime_r(__jlong2long_PTR(timer), (struct tm*) (uintptr_t) ptrResult)) {
#else
#error expected time_t is int32_t or int64_t
#endif
        } else {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    mktime
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Time_mktime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrTimeptr) {
        const time_t result = mktime((struct tm*) (uintptr_t) ptrTimeptr);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    nanosleep
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_nanosleep
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrRqtp, jlong ptrRmtp) {

        if (nanosleep((struct timespec*) (uintptr_t) ptrRqtp, (struct timespec*) (uintptr_t) ptrRmtp)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    strftime
     * Signature: (JLjava/lang/String;J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_strftime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong maxsize, jstring format, jlong ptrTimeptr) {
        const char* _format = (*env)->GetStringUTFChars(env, format, NULL);
#if defined(_JNHW__size_t__IS__uint64_t)
        char* _result = malloc((uint64_t) maxsize);
        size_t count = strftime(_result, (uint64_t) maxsize, _format, (struct tm*) (uintptr_t) ptrTimeptr);
#elif defined(_JNHW__size_t__IS__uint32_t)
        if ((maxsize > UINT32_MAX) || (maxsize < 0)) {
            //release to avoid memory leaks
            (*env)->ReleaseStringUTFChars(env, format, _format);
            throw_IllegalArgumentException(env, "maxsize outside size_t(int32_t)");
            return NULL;
        }
        char* _result = malloc((uint32_t) maxsize);
        size_t count = strftime(_result, (uint32_t) maxsize, _format, (struct tm*) (uintptr_t) ptrTimeptr);
#else
#error expected size_t is uint32_t or uint64_t
#endif
        (*env)->ReleaseStringUTFChars(env, format, _format);
        const jstring result = count == 0 ? NULL : (*env)->NewStringUTF(env, _result);
        free(_result);
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    strftime_l
     * Signature: (JLjava/lang/String;JJ)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_strftime_1l
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong maxsize, jstring format, jlong ptrTimeptr, jlong ptrLocale) {
        const char* _format = (*env)->GetStringUTFChars(env, format, NULL);
#if defined(_JNHW__size_t__IS__uint64_t)
        char* _result = malloc((uint64_t) maxsize);
        size_t count = strftime_l(_result, (uint64_t) maxsize, _format, (struct tm*) (uintptr_t) ptrTimeptr, (locale_t) (uintptr_t) ptrLocale);
#elif defined(_JNHW__size_t__IS__uint32_t)
        if ((maxsize > UINT32_MAX) || (maxsize < 0)) {
            //release to avoid memory leaks
            (*env)->ReleaseStringUTFChars(env, format, _format);
            throw_IllegalArgumentException(env, "maxsize outside size_t(int32_t)");
            return NULL;
        }
        char* _result = malloc((uint32_t) maxsize);
        size_t count = strftime_l(_result, (uint32_t) maxsize, _format, (struct tm*) (uintptr_t) ptrTimeptr, (locale_t) (uintptr_t) ptrLocale);
#else
#error expected size_t is uint32_t or uint64_t
#endif
        (*env)->ReleaseStringUTFChars(env, format, _format);

        const jstring result = count == 0 ? NULL : (*env)->NewStringUTF(env, _result);
        free(_result);
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    strptime
     * Signature: (Ljava/lang/String;Ljava/lang/String;J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_strptime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring buf, jstring format, jlong ptrTm) {
        const char* _buf = (*env)->GetStringUTFChars(env, buf, NULL);
        const char* _format = (*env)->GetStringUTFChars(env, format, NULL);

        const char* ptrResult = strptime(_buf, _format, (struct tm*) (uintptr_t) ptrTm);
        const intptr_t result = ptrResult - _buf;
        (*env)->ReleaseStringUTFChars(env, buf, _buf);
        (*env)->ReleaseStringUTFChars(env, format, _format);
        return (jint) result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    time
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Time_time
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        time_t result = time(NULL);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timer_create
     * Signature: (IJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1create
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint clockid, __attribute__ ((unused)) jlong ptrEvp, __attribute__ ((unused)) jlong ptrTimerid) {
        throw_NoSuchNativeMethodException(env, "timer_create");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint clockid, jlong ptrEvp, jlong ptrTimerid) {
        if (timer_create(clockid, (struct sigevent*) (uintptr_t) ptrEvp, (timer_t*) (uintptr_t) ptrTimerid)) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timer_delete
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1delete
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jlong ptrTimerid) {
        throw_NoSuchNativeMethodException(env, "timer_delete");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrTimerid) {
        if (timer_delete(*((timer_t*) (uintptr_t) ptrTimerid))) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timer_getoverrun
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1getoverrun
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jlong ptrTimerid) {
        throw_NoSuchNativeMethodException(env, "timer_getoverrun");
        return -1;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrTimerid) {
        int result = timer_getoverrun(*((timer_t*) (uintptr_t) ptrTimerid));
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timer_gettime
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1gettime
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jlong ptrTimerid, __attribute__ ((unused)) jlong ptrValue) {
        throw_NoSuchNativeMethodException(env, "timer_gettime");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrTimerid, jlong ptrValue) {
        if (timer_gettime(*((timer_t*) (uintptr_t) ptrTimerid), (struct itimerspec*) (uintptr_t) ptrValue)) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timer_settime
     * Signature: (JIJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1settime
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jlong ptrTimerid, __attribute__ ((unused)) jint flags, __attribute__ ((unused)) jlong ptrValue, __attribute__ ((unused)) jlong ptrOvalue) {
        throw_NoSuchNativeMethodException(env, "timer_settime");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrTimerid, jint flags, jlong ptrValue, jlong ptrOvalue) {
        if (timer_settime(*((timer_t*) (uintptr_t) ptrTimerid), flags, (struct itimerspec*) (uintptr_t) ptrValue, (struct itimerspec*) (uintptr_t) ptrOvalue)) {
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
