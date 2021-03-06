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

#if defined (__APPLE__)
#include <xlocale.h>
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest
     * Method:    sizeof__locale_t
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_sizeof_1_1locale_1t
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (locale_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest
     * Method:    testNativelyLC_GLOBAL_LOCALE
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_testNativelyLC_1GLOBAL_1LOCALE
    (JNIEnv *env, __attribute__ ((unused)) jobject clazz, jlong value) {
        locale_t unwrapped = (locale_t) (uintptr_t) value;
        if (LC_GLOBAL_LOCALE != unwrapped) {
            throw_Exception(env, RUNTIME_EXCEPTION_CLASS_NAME, "Java_de_ibapl_jnhw_posix_LocaleTest_testNativelyLC_1GLOBAL_1LOCALE failed expected %p but was %p", LC_GLOBAL_LOCALE, unwrapped);
        }
    }



#ifdef __cplusplus
}
#endif

#endif
