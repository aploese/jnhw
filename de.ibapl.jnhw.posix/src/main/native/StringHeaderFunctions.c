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
#include <unistd.h>

#include "jnhw-posix.h"
#include "de_ibapl_jnhw_posix_StringHeader.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION
#include <string.h>
#include <errno.h>

    /*
     * Class:     de_ibapl_jnhw_posix_StringHeader
     * Method:    strerror
     * Signature: (I)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_StringHeader_strerror
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint errnum) {
        const char *result = strerror(errnum);
        if (result == NULL) {
            return NULL;
        } else {
            return (*env)->NewStringUTF(env, result);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_StringHeader
     * Method:    strerror_l
     * Signature: (IJ)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_StringHeader_strerror_1l
#if defined(__APPLE__) || defined(__FreeBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint errnum, __attribute__ ((unused)) jlong nativeLocale) {
        throw_NoSuchNativeMethodException(env, "strerror_l");
        return NULL;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint errnum, jlong nativeLocale) {
        const char *result = strerror_l(errnum, (locale_t) (uintptr_t) nativeLocale);
        if (result == NULL) {
            return NULL;
        } else {
            return (*env)->NewStringUTF(env, result);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_StringHeader
     * Method:    strsignal
     * Signature: (I)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_StringHeader_strsignal
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint signum) {
        const char *result = strsignal(signum);
        if (result == NULL) {
            return NULL;
        } else {
            return (*env)->NewStringUTF(env, result);
        }
    }

#endif
#ifdef __cplusplus
}
#endif
