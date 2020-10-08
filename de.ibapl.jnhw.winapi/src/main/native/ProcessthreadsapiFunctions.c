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
#include "jnhw-winapi.h"
#include "de_ibapl_jnhw_winapi_Processthreadsapi.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef HAVE_PROCESSTHREADSAPI_H
#include <processthreadsapi.h>

/*
 * Class:     de_ibapl_jnhw_winapi_Processthreadsapi
 * Method:    QueueUserAPC
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/PAPCFUNC;Lde/ibapl/jnhw/winapi/Winnt/HANDLE;J)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Processthreadsapi_QueueUserAPC(
JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject pfnAPC, jobject hThread, jlong dwData) {
        if (pfnAPC == NULL) {
            throw_NullPointerException(env, "pfnAPC is null.");
            return;
        }
        if (hThread == NULL) {
            throw_NullPointerException(env, "hThread is null.");
            return;
        }

        if(QueueUserAPC(UNWRAP_NATIVE_FUNCTION_POINTER_TO(PAPCFUNC, pfnAPC), UNWRAP_HANDLE(hThread), (uint64_t)dwData)) {
            return;
        } else {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
    }

#endif
#ifdef __cplusplus
}
#endif
