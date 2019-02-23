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
#include "de_ibapl_jnhw_winapi_Ioapiset.h"

#ifdef HAVE_IOAPISET_H
#include <ioapiset.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Ioapiset
     * Method:    GetOverlappedResult
     * Signature: (JJLde/ibapl/jnhw/IntRef;Z)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Ioapiset_GetOverlappedResult
    (JNIEnv *env, jclass clazz, jlong hFile, jlong lpOverlapped, jobject lpNumberOfBytesTransferred, jboolean bWait) {

        DWORD _lpNumberOfBytesTransferred = (*env)->GetIntField(env, lpNumberOfBytesTransferred, de_ibapl_jnhw_IntRef_value_ID);

        BOOL result = GetOverlappedResult((HANDLE) (uintptr_t) hFile,
                (LPOVERLAPPED) (uintptr_t) lpOverlapped,
                &_lpNumberOfBytesTransferred,
                bWait);

        (*env)->SetIntField(env, lpNumberOfBytesTransferred, de_ibapl_jnhw_IntRef_value_ID, _lpNumberOfBytesTransferred);
        if (!result) {
            throw_NativeErrorException(env, GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Ioapiset
     * Method:    CancelIoEx
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Ioapiset_CancelIoEx
    (JNIEnv *env, jclass clazz, jlong hFile, jlong lpOverlapped) {
        if (!CancelIoEx((HANDLE) (uintptr_t) hFile,
                (LPOVERLAPPED) (uintptr_t) lpOverlapped)) {
            throw_NativeErrorException(env, GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Ioapiset
     * Method:    CancelIo
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Ioapiset_CancelIo
    (JNIEnv *env, jclass clazz, jlong hFile) {
        if (!CancelIo((HANDLE) (uintptr_t) hFile)) {
            throw_NativeErrorException(env, GetLastError());
        }
    }


#ifdef __cplusplus
}
#endif
#endif

