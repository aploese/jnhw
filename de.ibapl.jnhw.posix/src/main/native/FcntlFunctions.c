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
#if HAVE_UNISTD_H
#include <unistd.h>
#endif

#ifdef _POSIX_VERSION

#include "de_ibapl_jnhw_posix_Fcntl.h"
#include <fcntl.h>
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    JNHW_ASSERT__mode_t__IS__uint16_t__OR__uint32_t

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    fcntl
     * Signature: (II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_fcntl__II
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fildes, jint cmd) {
        const int result = fcntl(fildes, cmd);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    fcntl64
     * Signature: (II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_fcntl64__II
#ifdef _LARGEFILE64_SOURCE
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fildes, jint cmd) {
        const int result = fcntl64(fildes, cmd);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint fildes, __attribute__ ((unused)) jint cmd) {
        throw_NoSuchNativeMethodException(env, "fcntl64");
        return -1;
#endif        
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    fcntl
     * Signature: (III)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_fcntl__III
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fildes, jint cmd, jint vararg_0) {
        const int result = fcntl(fildes, cmd, vararg_0);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    fcntl64
     * Signature: (III)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_fcntl64__III
#ifdef _LARGEFILE64_SOURCE
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fildes, jint cmd, jint vararg_0) {
        const int result = fcntl64(fildes, cmd, vararg_0);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint fildes, __attribute__ ((unused)) jint cmd, __attribute__ ((unused)) jint vararg_0) {
        throw_NoSuchNativeMethodException(env, "fcntl64");
        return -1;
#endif        
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    creat
     * Signature: (Ljava/lang/String;I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_creat
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring path, jint mode) {
        if (path == NULL) {
            throw_NullPointerException(env, "path is null.");
            return -1;
        }
        const char* _path = (*env)->GetStringUTFChars(env, path, NULL);
#if defined(_JNHW__mode_t__IS__uint16_t)
        if ((mode > UINT16_MAX) || (mode < 0)) {
            throw_IllegalArgumentException(env, "value outside mode_t(uint16_t)");
            return -1;
        }
#elif defined(_JNHW__mode_t__IS__uint32_t)
#else
#error expected mode_t uint16_t or uint32_t
#endif 
        const int result = creat(_path, (mode_t) mode);
        (*env)->ReleaseStringUTFChars(env, path, _path);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    creat64
     * Signature: (Ljava/lang/String;I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_creat64
#ifdef _LARGEFILE64_SOURCE
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring path, jint mode) {
        if (path == NULL) {
            throw_NullPointerException(env, "path is null.");
            return -1;
        }
        const char* _path = (*env)->GetStringUTFChars(env, path, NULL);
        const int result = creat64(_path, (uint32_t) mode);

        (*env)->ReleaseStringUTFChars(env, path, _path);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) __attribute__ ((unused)) jstring path, __attribute__ ((unused)) jint mode) {
        throw_NoSuchNativeMethodException(env, "creat64");
        return -1;
#endif        
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    open
     * Signature: (Ljava/lang/String;I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_open__Ljava_lang_String_2I
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring path, jint oflag) {
        if (path == NULL) {
            throw_NullPointerException(env, "path is null.");
            return -1;
        }

        const char* _path = (*env)->GetStringUTFChars(env, path, NULL);
        const int result = open(_path, oflag);
        (*env)->ReleaseStringUTFChars(env, path, _path);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    open
     * Signature: (Ljava/lang/String;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_open__Ljava_lang_String_2II
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring path, jint oflag, jint mode) {
        if (path == NULL) {
            throw_NullPointerException(env, "path is null.");
            return -1;
        }

        const char* _path = (*env)->GetStringUTFChars(env, path, NULL);
        const int result = open(_path, oflag, mode);
        (*env)->ReleaseStringUTFChars(env, path, _path);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    openat
     * Signature: (ILjava/lang/String;I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_openat__ILjava_lang_String_2I
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, int fd, jstring path, jint oflag) {
        if (path == NULL) {
            throw_NullPointerException(env, "path is null.");
            return -1;
        }

        const char* _path = (*env)->GetStringUTFChars(env, path, NULL);
        const int result = openat(fd, _path, oflag);
        (*env)->ReleaseStringUTFChars(env, path, _path);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    openat
     * Signature: (ILjava/lang/String;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_openat__ILjava_lang_String_2II
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, int fd, jstring path, jint oflag, jint mode) {
        if (path == NULL) {
            throw_NullPointerException(env, "path is null.");
            return -1;
        }

        const char* _path = (*env)->GetStringUTFChars(env, path, NULL);
        const int result = openat(fd, _path, oflag, mode);
        (*env)->ReleaseStringUTFChars(env, path, _path);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    open64
     * Signature: (Ljava/lang/String;I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_open64__Ljava_lang_String_2I
#ifdef _LARGEFILE64_SOURCE
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring path, jint oflag) {
        if (path == NULL) {
            throw_NullPointerException(env, "path is null.");
            return -1;
        }

        const char* _path = (*env)->GetStringUTFChars(env, path, NULL);
        const int result = open64(_path, oflag);
        (*env)->ReleaseStringUTFChars(env, path, _path);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jstring path, __attribute__ ((unused)) jint oflag) {
        throw_NoSuchNativeMethodException(env, "open64");
        return -1;
#endif        
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    open64
     * Signature: (Ljava/lang/String;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_open64__Ljava_lang_String_2II
#ifdef _LARGEFILE64_SOURCE
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring path, jint oflag, jint mode) {
        if (path == NULL) {
            throw_NullPointerException(env, "path is null.");
            return -1;
        }

        const char* _path = (*env)->GetStringUTFChars(env, path, NULL);
        const int result = open64(_path, oflag, mode);
        (*env)->ReleaseStringUTFChars(env, path, _path);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jstring path, __attribute__ ((unused)) jint oflag, __attribute__ ((unused)) jint mode) {
        throw_NoSuchNativeMethodException(env, "open64");
        return -1;
#endif        
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    openat64
     * Signature: (ILjava/lang/String;I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_openat64__ILjava_lang_String_2I
#ifdef _LARGEFILE64_SOURCE
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, int fd, jstring path, jint oflag) {
        if (path == NULL) {
            throw_NullPointerException(env, "path is null.");
            return -1;
        }

        const char* _path = (*env)->GetStringUTFChars(env, path, NULL);
        const int result = openat64(fd, _path, oflag);
        (*env)->ReleaseStringUTFChars(env, path, _path);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) int fd, __attribute__ ((unused)) jstring path, __attribute__ ((unused)) jint oflag) {
        throw_NoSuchNativeMethodException(env, "openat64");
        return -1;
#endif        
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    openat64
     * Signature: (ILjava/lang/String;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_openat64__ILjava_lang_String_2II
#ifdef _LARGEFILE64_SOURCE
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, int fd, jstring path, jint oflag, jint mode) {
        if (path == NULL) {
            throw_NullPointerException(env, "path is null.");
            return -1;
        }

        const char* _path = (*env)->GetStringUTFChars(env, path, NULL);
        const int result = openat64(fd, _path, oflag, mode);
        (*env)->ReleaseStringUTFChars(env, path, _path);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) int fd, __attribute__ ((unused)) jstring path, __attribute__ ((unused)) jint oflag, __attribute__ ((unused)) jint mode) {
        throw_NoSuchNativeMethodException(env, "openat64");
        return -1;
#endif        
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    posix_fadvise
     * Signature: (IJJI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Fcntl_posix_1fadvise
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) int fildes, __attribute__ ((unused)) jlong offset, __attribute__ ((unused)) jlong len, __attribute__ ((unused)) jint advice) {
        throw_NoSuchNativeMethodException(env, "posix_fadvise");
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, int fildes, jlong offset, jlong len, jint advice) {
#if defined(_JNHW__off_t__IS__int32_t)
        if ((offset > INT32_MAX) || (offset < INT32_MIN)) {
            throw_IllegalArgumentException(env, "offset outside off_t(int32_t)");
            return;
        }
        if ((len > INT32_MAX) || (len < INT32_MIN)) {
            throw_IllegalArgumentException(env, "len outside off_t(int32_t)");
            return;
        }
#elif defined(_JNHW__off_t__IS__int64_t)
#else
#error expected off_t is int32_t or int64_t
#endif 
        const int result = posix_fadvise(fildes, (off_t) offset, (off_t) len, advice);
        if (result) {
            throw_NativeErrorException(env, result);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    posix_fadvise64
     * Signature: (IJJI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Fcntl_posix_1fadvise64
#ifdef _LARGEFILE64_SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, int fildes, jlong offset, jlong len, jint advice) {
        const int result = posix_fadvise64(fildes, offset, len, advice);
        if (result) {
            throw_NativeErrorException(env, result);
        }
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) int fildes, __attribute__ ((unused)) jlong offset, __attribute__ ((unused)) jlong len, __attribute__ ((unused)) jint advice) {
        throw_NoSuchNativeMethodException(env, "posix_fadvice");
#endif        
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    posix_fallocate
     * Signature: (IJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Fcntl_posix_1fallocate
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) int fildes, __attribute__ ((unused)) jlong offset, __attribute__ ((unused)) jlong len) {
        throw_NoSuchNativeMethodException(env, "posix_fallocate");
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, int fildes, jlong offset, jlong len) {
#if defined(_JNHW__off_t__IS__int32_t)
        if ((offset > INT32_MAX) || (offset < INT32_MIN)) {
            throw_IllegalArgumentException(env, "offset outside off_t(int32_t)");
            return;
        }
        if ((len > INT32_MAX) || (len < INT32_MIN)) {
            throw_IllegalArgumentException(env, "len outside off_t(int32_t)");
            return;
        }
#elif defined(_JNHW__off_t__IS__int64_t)
#else
#error expected off_t is int32_t or int64_t
#endif 
        const int result = posix_fallocate(fildes, (off_t) offset, (off_t) len);
        if (result) {
            throw_NativeErrorException(env, result);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    posix_fallocate64
     * Signature: (IJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Fcntl_posix_1fallocate64
#ifdef _LARGEFILE64_SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, int fildes, jlong offset, jlong len) {
        const int result = posix_fallocate64(fildes, offset, len);
        if (result) {
            throw_NativeErrorException(env, result);
        }
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) int fildes, __attribute__ ((unused)) jlong offset, __attribute__ ((unused)) jlong len) {
        throw_NoSuchNativeMethodException(env, "posix_fadvice");
#endif        
    }

#ifdef __cplusplus
}
#endif
#endif
