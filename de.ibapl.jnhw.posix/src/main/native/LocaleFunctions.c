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
#include "de_ibapl_jnhw_posix_Locale.h"

#ifdef __cplusplus
extern "C" {
#endif

#if defined(_POSIX_VERSION)
#include <locale.h>

#if defined (__APPLE__)
#include <xlocale.h>
#endif

#include <errno.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    duplocale
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Locale_duplocale
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong nativeLocobj) {
        const locale_t result = duplocale((locale_t) (uintptr_t) nativeLocobj);
        if (!result) {
            throw_NativeErrorException(env, errno);
        }
        return (jlong) (uintptr_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    freelocale
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Locale_freelocale
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong nativeLocobj) {
        freelocale((locale_t) (uintptr_t) nativeLocobj);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    localeconv0
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Locale_localeconv0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (jlong) (uintptr_t) localeconv();
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    newlocale
     * Signature: (ILjava/lang/String;J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Locale_newlocale
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint category_mask, jstring locale, jlong nativeBase) {
        const char* _locale = (*env)->GetStringUTFChars(env, locale, NULL);
        const locale_t result = newlocale(category_mask, _locale, (locale_t) (uintptr_t) nativeBase);
        (*env)->ReleaseStringUTFChars(env, locale, _locale);
        if (result == (locale_t) 0) {
            throw_NativeErrorException(env, errno);
        }
        return (jlong) (uintptr_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    setlocale
     * Signature: (ILjava/lang/String;)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Locale_setlocale
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint category, jstring locale) {
        const char* _locale = locale != NULL ? (*env)->GetStringUTFChars(env, locale, NULL) : NULL;
        const char* result = setlocale(category, _locale);
        if (locale != NULL) {
            (*env)->ReleaseStringUTFChars(env, locale, _locale);
        }
        if (result == NULL) {
            return NULL;
        } else {
            return (*env)->NewStringUTF(env, result);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    uselocale
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Locale_uselocale
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong nativeNewloc) {
        const locale_t result = uselocale((locale_t) (uintptr_t) nativeNewloc);
        if (result == (locale_t) 0) {
            throw_NativeErrorException(env, errno);
        }
        return (jlong) (uintptr_t) result;
    }

#endif
#ifdef __cplusplus
}
#endif