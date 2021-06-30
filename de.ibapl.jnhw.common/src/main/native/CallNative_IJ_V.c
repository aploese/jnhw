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
#define _JNHW_COMMON_IMPLEMENTATION_ 1
#include "de_ibapl_jnhw_common_nativecall_CallNative_IJ_V.h"


#include "jnhw-common.h"

#include <stdlib.h>

#include <assert.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_common_nativecall_CallNative_IJ_V
     * Method:    call
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_nativecall_CallNative_1IJ_1V_call
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz, jlong ptrAddress, jlong value) {
#if defined(__LP64__) || defined(_WIN64)
        static_assert(sizeof (intptr_t) == 8, "sizeof(intptr_t) != 8)");
        ((void (*)(int64_t))(uintptr_t) ptrAddress)(value);
#else
        static_assert(sizeof (intptr_t) == 4, "sizeof(intptr_t) != 4)");
        if (value > INT32_MAX) {
            throw_IllegalArgumentException(env, "value > INT32_MAX!");
        } else if (value < INT32_MIN) {
            throw_IllegalArgumentException(env, "value < INT32_MIN!");
        } else {
            ((void (*)(int32_t))(uintptr_t) ptrAddress)((int32_t) value);
        }
#endif
    }


#ifdef __cplusplus
}
#endif
