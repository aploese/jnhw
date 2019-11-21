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
        throw_NoSuchMethodException(env, "_LARGEFILE64_SOURCE not defined at compile time, so no fcntl64");
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
        throw_NoSuchMethodException(env, "_LARGEFILE64_SOURCE not defined at compile time, so no fcntl64");
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
#if defined(__APPLE__) || defined(__FreeBSD__)
        if ((mode > INT16_MAX) || (mode < INT16_MIN)) {
            throw_IllegalArgumentException(env, "mode outside short int");
            return -1;
        }
        const int result = creat(_path, (uint16_t) mode);
#else
        const int result = creat(_path, (uint32_t) mode);
#endif
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
        throw_NoSuchMethodException(env, "_LARGEFILE64_SOURCE not defined at compile time, so no creat64");
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
        throw_NoSuchMethodException(env, "_LARGEFILE64_SOURCE not defined at compile time, so no open64");
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
        throw_NoSuchMethodException(env, "_LARGEFILE64_SOURCE not defined at compile time, so no open64");
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
        throw_NoSuchMethodException(env, "_LARGEFILE64_SOURCE not defined at compile time, so no openat64");
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
        throw_NoSuchMethodException(env, "_LARGEFILE64_SOURCE not defined at compile time, so no openat64");
        return -1;
#endif        
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    posix_fadvise
     * Signature: (IJJI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Fcntl_posix_1fadvise
#if defined(__APPLE__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) int fildes, __attribute__ ((unused)) jlong offset, __attribute__ ((unused)) jlong len, __attribute__ ((unused)) jint advice) {
        throw_NotDefinedException(env, "posix_fadvise");
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, int fildes, jlong offset, jlong len, jint advice) {
#if __WORDSIZE == 64
        const int result = posix_fadvise(fildes, offset, len, advice);
        if (result) {
              throw_NativeErrorException(env, result);
        }
#elif __WORDSIZE == 32
        if ((offset > INT32_MAX) || (offset < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation offset is only an integer with the size of jint");
            return;
        }
        if ((len > INT32_MAX) || (len < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation len is only an integer with the size of jint");
            return;
        }
        const int result = posix_fadvise(fildes, (int32_t)offset, (int32_t)len, advice);
        if (result) {
              throw_NativeErrorException(env, result);
        }
#endif
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
        throw_NoSuchMethodException(env, "_LARGEFILE64_SOURCE not defined at compile time, so no posix_fadvice");
#endif        
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    posix_fallocate
     * Signature: (IJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Fcntl_posix_1fallocate
#if defined(__APPLE__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) int fildes, __attribute__ ((unused)) jlong offset, __attribute__ ((unused)) jlong len) {
        throw_NotDefinedException(env, "posix_fallocate");
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, int fildes, jlong offset, jlong len) {
#if __WORDSIZE == 64
        const int result = posix_fallocate(fildes, offset, len);
        if (result) {
              throw_NativeErrorException(env, result);
        }
#elif __WORDSIZE == 32
        if ((offset > INT32_MAX) || (offset < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation offset is only an integer with the size of jint");
            return;
        }
        if ((len > INT32_MAX) || (len < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation len is only an integer with the size of jint");
            return;
        }
        const int result = posix_fallocate(fildes, (int32_t)offset, (int32_t)len);
        if (result) {
              throw_NativeErrorException(env, result);
        }
#endif
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
        throw_NoSuchMethodException(env, "_LARGEFILE64_SOURCE not defined at compile time, so no posix_fadvice");
#endif        
    }

#ifdef __cplusplus
}
#endif
#endif
