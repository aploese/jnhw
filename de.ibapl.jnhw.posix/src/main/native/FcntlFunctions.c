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
#ifdef __APPLE__
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


#ifdef __cplusplus
}
#endif
#endif
