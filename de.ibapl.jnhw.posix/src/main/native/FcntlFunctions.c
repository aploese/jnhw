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
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jint cmd) {
        int result = fcntl(fd, cmd);
        if (result < 0) {
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
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jint cmd) {
        int result = fcntl64(fd, cmd);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint fd, __attribute__ ((unused)) jint cmd) {
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
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jint cmd, jint vararg_0) {
        int result = fcntl(fd, cmd, vararg_0);
        if (result < 0) {
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
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jint cmd, jint vararg_0) {
        int result = fcntl64(fd, cmd, vararg_0);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint fd, __attribute__ ((unused)) jint cmd, __attribute__ ((unused)) jint vararg_0) {
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
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring file, jint mode) {
        if (file == NULL) {
            throw_NullPointerException(env, "file is null.");
            return -1;
        }
        const char* _file = (*env)->GetStringUTFChars(env, file, NULL);
#if defined(__APPLE__) || defined(__FreeBSD__)
        if ((mode > INT16_MAX) || (mode < INT16_MIN)) {
            throw_IllegalArgumentException(env, "mode outside short int");
            return -1;
        }
        int result = creat(_file, (uint16_t) mode);
#else
        int result = creat(_file, (uint32_t) mode);
#endif
        (*env)->ReleaseStringUTFChars(env, file, _file);
        if (result < 0) {
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
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring file, jint mode) {
        if (file == NULL) {
            throw_NullPointerException(env, "file is null.");
            return -1;
        }
        const char* _file = (*env)->GetStringUTFChars(env, file, NULL);
        int result = creat64(_file, (uint32_t) mode);

        (*env)->ReleaseStringUTFChars(env, file, _file);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) __attribute__ ((unused)) jstring file, __attribute__ ((unused)) jint mode) {
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
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring file, jint oflag) {
        if (file == NULL) {
            throw_NullPointerException(env, "file is null.");
            return -1;
        }

        const char* _file = (*env)->GetStringUTFChars(env, file, NULL);
        int result = open(_file, oflag);
        (*env)->ReleaseStringUTFChars(env, file, _file);
        if (result < 0) {
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
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring file, jint oflag, jint mode) {
        if (file == NULL) {
            throw_NullPointerException(env, "file is null.");
            return -1;
        }

        const char* _file = (*env)->GetStringUTFChars(env, file, NULL);
        int result = open(_file, oflag, mode);
        (*env)->ReleaseStringUTFChars(env, file, _file);
        if (result < 0) {
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
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, int fd, jstring file, jint oflag) {
        if (file == NULL) {
            throw_NullPointerException(env, "file is null.");
            return -1;
        }

        const char* _file = (*env)->GetStringUTFChars(env, file, NULL);
        int result = openat(fd, _file, oflag);
        (*env)->ReleaseStringUTFChars(env, file, _file);
        if (result < 0) {
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
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, int fd, jstring file, jint oflag, jint mode) {
        if (file == NULL) {
            throw_NullPointerException(env, "file is null.");
            return -1;
        }

        const char* _file = (*env)->GetStringUTFChars(env, file, NULL);
        int result = openat(fd, _file, oflag, mode);
        (*env)->ReleaseStringUTFChars(env, file, _file);
        if (result < 0) {
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
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring file, jint oflag) {
        if (file == NULL) {
            throw_NullPointerException(env, "file is null.");
            return -1;
        }

        const char* _file = (*env)->GetStringUTFChars(env, file, NULL);
        int result = open64(_file, oflag);
        (*env)->ReleaseStringUTFChars(env, file, _file);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jstring file, __attribute__ ((unused)) jint oflag) {
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
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring file, jint oflag, jint mode) {
        if (file == NULL) {
            throw_NullPointerException(env, "file is null.");
            return -1;
        }

        const char* _file = (*env)->GetStringUTFChars(env, file, NULL);
        int result = open64(_file, oflag, mode);
        (*env)->ReleaseStringUTFChars(env, file, _file);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jstring file, __attribute__ ((unused)) jint oflag, __attribute__ ((unused)) jint mode) {
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
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, int fd, jstring file, jint oflag) {
        if (file == NULL) {
            throw_NullPointerException(env, "file is null.");
            return -1;
        }

        const char* _file = (*env)->GetStringUTFChars(env, file, NULL);
        int result = openat64(fd, _file, oflag);
        (*env)->ReleaseStringUTFChars(env, file, _file);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) int fd, __attribute__ ((unused)) jstring file, __attribute__ ((unused)) jint oflag) {
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
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, int fd, jstring file, jint oflag, jint mode) {
        if (file == NULL) {
            throw_NullPointerException(env, "file is null.");
            return -1;
        }

        const char* _file = (*env)->GetStringUTFChars(env, file, NULL);
        int result = openat64(fd, _file, oflag, mode);
        (*env)->ReleaseStringUTFChars(env, file, _file);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) int fd, __attribute__ ((unused)) jstring file, __attribute__ ((unused)) jint oflag, __attribute__ ((unused)) jint mode) {
        throw_NoSuchMethodException(env, "_LARGEFILE64_SOURCE not defined at compile time, so no openat64");
        return -1;
#endif        
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    posix_fadvise
     * Signature: (IJJI)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_posix_1fadvise
#if defined(__APPLE__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) int fd, __attribute__ ((unused)) jlong offset, __attribute__ ((unused)) jlong len, __attribute__ ((unused)) jint advice) {
        throw_NotDefinedException(env, "posix_fadvise");
        return 0;
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, int fd, jlong offset, jlong len, jint advice) {
#if __WORDSIZE == 64
        return posix_fadvise(fd, offset, len, advice);
#elif __WORDSIZE == 32
        if ((offset > INT32_MAX) || (offset < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation offset is only an integer with the size of jint");
            return -1;
        }
        if ((len > INT32_MAX) || (len < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation len is only an integer with the size of jint");
            return -1;
        }
        return posix_fadvise(fd, (int32_t)offset, (int32_t)len, advice);
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    posix_fadvise64
     * Signature: (IJJI)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_posix_1fadvise64
#ifdef _LARGEFILE64_SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, int fd, jlong offset, jlong len, jint advice) {
        return posix_fadvise64(fd, offset, len, advice);
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) int fd, __attribute__ ((unused)) jlong offset, __attribute__ ((unused)) jlong len, __attribute__ ((unused)) jint advice) {
        throw_NoSuchMethodException(env, "_LARGEFILE64_SOURCE not defined at compile time, so no posix_fadvice");
        return -1;
#endif        
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    posix_fallocate
     * Signature: (IJJ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_posix_1fallocate
#if defined(__APPLE__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) int fd, __attribute__ ((unused)) jlong offset, __attribute__ ((unused)) jlong len) {
        throw_NotDefinedException(env, "posix_fallocate");
        return 0;
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, int fd, jlong offset, jlong len) {
#if __WORDSIZE == 64
        return posix_fallocate(fd, offset, len);
#elif __WORDSIZE == 32
        if ((offset > INT32_MAX) || (offset < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation offset is only an integer with the size of jint");
            return -1;
        }
        if ((len > INT32_MAX) || (len < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation len is only an integer with the size of jint");
            return -1;
        }
        return posix_fallocate(fd, (int32_t)offset, (int32_t)len);
#endif
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    posix_fallocate64
     * Signature: (IJJ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_posix_1fallocate64
#ifdef _LARGEFILE64_SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, int fd, jlong offset, jlong len) {
        return posix_fallocate64(fd, offset, len);
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) int fd, __attribute__ ((unused)) jlong offset, __attribute__ ((unused)) jlong len) {
        throw_NoSuchMethodException(env, "_LARGEFILE64_SOURCE not defined at compile time, so no posix_fadvice");
        return -1;
#endif        
    }

#ifdef __cplusplus
}
#endif
#endif
