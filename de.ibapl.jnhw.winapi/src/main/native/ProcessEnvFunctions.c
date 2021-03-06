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
#include "jnhw-winapi.h"
#include "de_ibapl_jnhw_winapi_ProcessEnv.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef HAVE_PROCESSENV_H
#include <processenv.h>

    /*
     * Class:     de_ibapl_jnhw_winapi_ProcessEnv
     * Method:    GetStdHandle
     * Signature: (IZ)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_ProcessEnv_GetStdHandle
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint nStdHandle) {
        HANDLE result = GetStdHandle((uint32_t) nStdHandle);
        if (result == INVALID_HANDLE_VALUE) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
            return (int64_t) (uintptr_t) NULL;
        }
        return (int64_t) (uintptr_t) result;
    }

#endif
#ifdef __cplusplus
}
#endif
