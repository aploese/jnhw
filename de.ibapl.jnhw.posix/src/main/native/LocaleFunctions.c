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
#include "de_ibapl_jnhw_posix_Locale.h"

#ifdef HAVE_LOCALE_H

#include <locale.h>
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    duplocale
     * Signature: (Lde/ibapl/jnhw/posix/Locale/Locale_t;)Lde/ibapl/jnhw/posix/Locale/Locale_t;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Locale_duplocale
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject locobj) {
        if (locobj == NULL) {
            throw_NullPointerException(env, "locobj is null.");
            return 0;
        }
        const locale_t result = duplocale(UNWRAP_LOCALE_T(locobj));
        if (!result) {
            throw_NativeErrorException(env, errno);
        }
        return CREATE_LOCALE_T(result);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    freelocale
     * Signature: (Lde/ibapl/jnhw/posix/Locale/Locale_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Locale_freelocale
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject locobj) {
        if (locobj == NULL) {
            throw_NullPointerException(env, "locobj is null");
            return;
        }
        freelocale(UNWRAP_LOCALE_T(locobj));
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    localeconv
     * Signature: ()Lde/ibapl/jnhw/posix/Locale/Lconv;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Locale_localeconv
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        struct lconv *lconv = localeconv();
        //prepare the java object tht wraps lconv
        jclass lconvClass = (*env)->FindClass(env, "de/ibapl/jnhw/posix/Locale$Lconv");
        if (lconvClass == NULL) {
            return NULL;
        }
        jobject result = NULL;
        jmethodID lconvInitID = (*env)->GetMethodID(env, lconvClass, "<init>", "(JI)V");
        if (lconvInitID != NULL) {
            result = (*env)->NewObject(env, lconvClass, lconvInitID, (intptr_t) lconv, sizeof (struct lconv));
        }
        (*env)->DeleteLocalRef(env, lconvClass);
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    newlocale
     * Signature: (ILjava/lang/String;Lde/ibapl/jnhw/posix/Locale$Locale_t;)Lde/ibapl/jnhw/posix/Locale$Locale_t;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Locale_newlocale
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint category_mask, jstring locale, jobject base) {
        if (locale == NULL) {
            throw_NullPointerException(env, "locale is null.");
            return 0;
        }
        if (base == NULL) {
            throw_NullPointerException(env, "base is null.");
            return 0;
        }
        const locale_t _base = UNWRAP_LOCALE_T(base);
        if (_base == LC_GLOBAL_LOCALE) {
            throw_IllegalArgumentException(env, "base is LC_GLOBAL_LOCALE");
            return 0;
        }
        const char* _locale = (*env)->GetStringUTFChars(env, locale, NULL);
        locale_t result = newlocale(category_mask, _locale, _base);
        (*env)->ReleaseStringUTFChars(env, locale, _locale);
        if (result == (locale_t) 0) {
            throw_NativeErrorException(env, errno);
        }
        return CREATE_LOCALE_T(result);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    setlocale
     * Signature: (ILjava/lang/String;)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Locale_setlocale
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint category, jstring locale) {
        const char* _locale = locale != NULL ? (*env)->GetStringUTFChars(env, locale, NULL) : NULL;
        char* result = setlocale(category, _locale);
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
     * Signature: (Lde/ibapl/jnhw/posix/Locale/Locale_t;)Lde/ibapl/jnhw/posix/Locale/Locale_t;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Locale_uselocale
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject newloc) {
        if (newloc == NULL) {
            throw_NullPointerException(env, "newloc is null.");
            return 0;
        }
        locale_t result = uselocale(UNWRAP_LOCALE_T(newloc));
        if (result == (locale_t) 0) {
            throw_NativeErrorException(env, errno);
        }
        return CREATE_LOCALE_T(result);
    }


#ifdef __cplusplus
}
#endif
#endif