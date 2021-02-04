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
#include "de_ibapl_jnhw_winapi_Winbase.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifndef HAVE_WINBASE_H

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else
#include <winbase.h>

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_WINBASE_H", JNI_TRUE)) {
            return;
        }

        if (JnhwSetStaticByteField(env, clazz, "FILE_SKIP_SET_EVENT_ON_HANDLE", FILE_SKIP_SET_EVENT_ON_HANDLE)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "FILE_SKIP_COMPLETION_PORT_ON_SUCCESS", FILE_SKIP_COMPLETION_PORT_ON_SUCCESS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "STD_INPUT_HANDLE", (int32_t) STD_INPUT_HANDLE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "STD_OUTPUT_HANDLE", (int32_t) STD_OUTPUT_HANDLE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "STD_ERROR_HANDLE", (int32_t) STD_ERROR_HANDLE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "WAIT_FAILED", (int32_t) WAIT_FAILED)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "WAIT_OBJECT_0", WAIT_OBJECT_0)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "WAIT_IO_COMPLETION", WAIT_IO_COMPLETION)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "MAXIMUM_WAIT_OBJECTS", MAXIMUM_WAIT_OBJECTS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "WAIT_ABANDONED", WAIT_ABANDONED)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "WAIT_TIMEOUT", WAIT_TIMEOUT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_ATTRIBUTE_ARCHIVE", FILE_ATTRIBUTE_ARCHIVE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_ATTRIBUTE_ENCRYPTED", FILE_ATTRIBUTE_ENCRYPTED)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_ATTRIBUTE_HIDDEN", FILE_ATTRIBUTE_HIDDEN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_ATTRIBUTE_NORMAL", FILE_ATTRIBUTE_NORMAL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_ATTRIBUTE_OFFLINE", FILE_ATTRIBUTE_OFFLINE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_ATTRIBUTE_READONLY", FILE_ATTRIBUTE_READONLY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_ATTRIBUTE_SYSTEM", FILE_ATTRIBUTE_SYSTEM)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_ATTRIBUTE_TEMPORARY", FILE_ATTRIBUTE_TEMPORARY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_FLAG_BACKUP_SEMANTICS", FILE_FLAG_BACKUP_SEMANTICS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_FLAG_DELETE_ON_CLOSE", FILE_FLAG_DELETE_ON_CLOSE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_FLAG_NO_BUFFERING", FILE_FLAG_NO_BUFFERING)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_FLAG_OPEN_NO_RECALL", FILE_FLAG_OPEN_NO_RECALL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_FLAG_OPEN_REPARSE_POINT", FILE_FLAG_OPEN_REPARSE_POINT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_FLAG_OVERLAPPED", FILE_FLAG_OVERLAPPED)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_FLAG_POSIX_SEMANTICS", FILE_FLAG_POSIX_SEMANTICS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_FLAG_RANDOM_ACCESS", FILE_FLAG_RANDOM_ACCESS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_FLAG_SESSION_AWARE", FILE_FLAG_SESSION_AWARE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_FLAG_SEQUENTIAL_SCAN", FILE_FLAG_SEQUENTIAL_SCAN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_FLAG_WRITE_THROUGH", (int32_t) FILE_FLAG_WRITE_THROUGH)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SECURITY_ANONYMOUS", SECURITY_ANONYMOUS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SECURITY_CONTEXT_TRACKING", SECURITY_CONTEXT_TRACKING)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SECURITY_DELEGATION", SECURITY_DELEGATION)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SECURITY_EFFECTIVE_ONLY", SECURITY_EFFECTIVE_ONLY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SECURITY_IDENTIFICATION", SECURITY_IDENTIFICATION)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SECURITY_IMPERSONATION", SECURITY_IMPERSONATION)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "RTS_CONTROL_DISABLE", RTS_CONTROL_DISABLE)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "RTS_CONTROL_ENABLE", RTS_CONTROL_ENABLE)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "RTS_CONTROL_TOGGLE", RTS_CONTROL_TOGGLE)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "RTS_CONTROL_HANDSHAKE", RTS_CONTROL_HANDSHAKE)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "DTR_CONTROL_DISABLE", DTR_CONTROL_DISABLE)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "DTR_CONTROL_ENABLE", DTR_CONTROL_ENABLE)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "DTR_CONTROL_HANDSHAKE", DTR_CONTROL_HANDSHAKE)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "NOPARITY", NOPARITY)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "ODDPARITY", ODDPARITY)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "EVENPARITY", EVENPARITY)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "MARKPARITY", MARKPARITY)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "SPACEPARITY", SPACEPARITY)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "ONESTOPBIT", ONESTOPBIT)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "ONE5STOPBITS", ONE5STOPBITS)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "TWOSTOPBITS", TWOSTOPBITS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "INFINITE", (int32_t) INFINITE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SETRTS", SETRTS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SETXOFF", SETXOFF)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SETXON", SETXON)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CLRRTS", CLRRTS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SETDTR", SETDTR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CLRDTR", CLRDTR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SETBREAK", SETBREAK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CLRBREAK", CLRBREAK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "MS_CTS_ON", MS_CTS_ON)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "MS_DSR_ON", MS_DSR_ON)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "MS_RING_ON", MS_RING_ON)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "MS_RLSD_ON", MS_RLSD_ON)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "CE_BREAK", CE_BREAK)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "CE_FRAME", CE_FRAME)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "CE_OVERRUN", CE_OVERRUN)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "CE_RXOVER", CE_RXOVER)) {
            return;
        }
        if (JnhwSetStaticByteField(env, clazz, "CE_RXPARITY", CE_RXPARITY)) {
            return;
        }
    }

#endif

#ifdef __cplusplus
}
#endif
