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
#include "de_ibapl_jnhw_posix_LocaleTest.h"

#ifdef __cplusplus
extern "C" {
#endif
#if defined(_POSIX_VERSION)

#include <locale.h>
    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest
     * Method:    nativeLocale_t
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_nativeLocale_1t
    (JNIEnv *env, __attribute__ ((unused)) jobject clazz, jlong value) {
        locale_t _value = (locale_t)(intptr_t)value;
        jobject __value = CREATE_LOCALE_T(_value);
        locale_t result = UNWRAP_LOCALE_T(__value);
        if (result != _value) {
            throw_Exception(env, RUNTIME_EXCEPTION_CLASS_NAME, "Java_de_ibapl_jnhw_posix_LocaleTest_nativeLocale_1t failed expected %p but was %p", value, result);
        }
        return (intptr_t)result;
    }   

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest
     * Method:    testNativelyLC_GLOBAL_LOCALE
     * Signature: (Lde/ibapl/jnhw/posix/Locale/Locale_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_testNativelyLC_1GLOBAL_1LOCALE
    (JNIEnv *env, __attribute__ ((unused)) jobject clazz, jobject value) {
        locale_t unwrapped = UNWRAP_LOCALE_T(value);
        if (LC_GLOBAL_LOCALE != unwrapped) {
            throw_Exception(env, RUNTIME_EXCEPTION_CLASS_NAME, "Java_de_ibapl_jnhw_posix_LocaleTest_testNativelyLC_1GLOBAL_1LOCALE failed expected %p but was %p", LC_GLOBAL_LOCALE, unwrapped);
        } 
    }



#ifdef __cplusplus
}
#endif

#endif
