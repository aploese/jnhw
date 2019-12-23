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
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    asctime
     * Signature: (Lde/ibapl/jnhw/posix/Time$Tm;)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_asctime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject structTm) {
        if (structTm == NULL) {
            throw_NullPointerException(env, "structTm");
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
            throw_NullPointerException(env, "structTm");
            return NULL;
        }
        if (buf == NULL) {
            throw_NullPointerException(env, "buf");
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
            throw_NullPointerException(env, "clock_id");
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
    (JNIEnv *, jclass, jint, jobject);

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    clock_gettime
     * Signature: (Lde/ibapl/jnhw/posix/sys/Types/clockid_t;Lde/ibapl/jnhw/posix/Time$Timespec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_clock_1gettime
    (JNIEnv *, jclass, jobject, jobject);

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    clock_nanosleep
     * Signature: (IILde/ibapl/jnhw/posix/Time$Timespec;Lde/ibapl/jnhw/posix/Time$Timespec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_clock_1nanosleep
    (JNIEnv *, jclass, jint, jint, jobject, jobject);

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    clock_settime
     * Signature: (Lde/ibapl/jnhw/posix/sys/Types/clockid_t;Lde/ibapl/jnhw/posix/Time$Timespec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_clock_1settime
    (JNIEnv *, jclass, jobject, jobject);

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    ctime
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_ctime
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong clock) {
        const char *result = ctime(&clock);
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
            throw_NullPointerException(env, "buf");
            return NULL;
        }
        if (SIZE_OF_OPAQUE_MEM(buf) < 26) {
            throw_IllegalArgumentException(env, "buf is too small 26 bytes are the minimum");
            return NULL;
        }
        const char *result = ctime_r(&clock, UNWRAP_OPAQUE_MEM_TO_VOID_PTR(buf));
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
        return difftime(time1, time0);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    getdate
     * Signature: (Ljava/lang/String;)Lde/ibapl/jnhw/posix/Time$Tm;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Time_getdate
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring string) {
        if (string == NULL) {
            throw_NullPointerException(env, "string");
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
        const struct tm *tm = gmtime(&timer);
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
            throw_NullPointerException(env, "result");
            return NULL;
        }
        struct tm *_result = UNWRAP_STRUCT_TM_PTR(result);
        if (gmtime_r(&timer, _result)) {
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
        const struct tm *result = localtime(&timer);
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
            throw_NullPointerException(env, "result");
            return NULL;
        }
        struct tm *_result = UNWRAP_STRUCT_TM_PTR(result);
        if (localtime_r(&timer, _result)) {
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
            throw_NullPointerException(env, "timeptr");
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
    (JNIEnv *, jclass, jobject, jobject);

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    strftime
     * Signature: (JLjava/lang/String;Lde/ibapl/jnhw/posix/Time$Tm;)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_strftime__JLjava_lang_String_2Lde_ibapl_jnhw_posix_Time_Tm_2
    (JNIEnv *, jclass, jlong, jstring, jobject);

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    strftime
     * Signature: (JLjava/lang/String;Lde/ibapl/jnhw/posix/Time$Tm;I)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_strftime__JLjava_lang_String_2Lde_ibapl_jnhw_posix_Time_Tm_2I
    (JNIEnv *, jclass, jlong, jstring, jobject, jint);

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    strptime
     * Signature: (Ljava/lang/String;Ljava/lang/String;Lde/ibapl/jnhw/posix/Time$Tm;)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Time_strptime
    (JNIEnv *, jclass, jstring, jstring, jobject);

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    time
     * Signature: (Lde/ibapl/jnhw/LongRef;)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Time_time
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject tloc) {
        time_t result;
        if (tloc) {
            time_t _tloc = GET_LONG_REF_VALUE(tloc);
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
     * Signature: (ILde/ibapl/jnhw/posix/Signal/Sigevent;I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1create
    (JNIEnv *, jclass, jint, jobject, jint);

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timer_delete
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1delete
    (JNIEnv *, jclass, jint);

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timer_getoverrun
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1getoverrun
    (JNIEnv *, jclass, jint);

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timer_gettime
     * Signature: (ILde/ibapl/jnhw/posix/Time$Itimerspec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1gettime
    (JNIEnv *, jclass, jint, jobject);

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    timer_settime
     * Signature: (IILde/ibapl/jnhw/posix/Time$Itimerspec;Lde/ibapl/jnhw/posix/Time$Itimerspec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_timer_1settime
    (JNIEnv *, jclass, jint, jint, jobject, jobject);

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


#ifdef __cplusplus
}
#endif
#endif