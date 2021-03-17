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
#include "de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS.h"
#include "de_ibapl_jnhw_winapi_Winbase_COMSTAT.h"
#include "de_ibapl_jnhw_winapi_Winbase_DCB.h"


#ifdef HAVE_WINBASE_H
#include <winbase.h>
#include <assert.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/winapi/Winbase/COMMTIMEOUTS/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_native2Layout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (COMMTIMEOUTS), __alignof__ (COMMTIMEOUTS));
        if (result == NULL) {
            return NULL;
        }
        if (JnhwSetLongField(env, result, "ReadIntervalTimeout", offsetof(COMMTIMEOUTS, ReadIntervalTimeout))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "ReadTotalTimeoutMultiplier", offsetof(COMMTIMEOUTS, ReadTotalTimeoutMultiplier))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "ReadTotalTimeoutConstant", offsetof(COMMTIMEOUTS, ReadTotalTimeoutConstant))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "WriteTotalTimeoutMultiplier", offsetof(COMMTIMEOUTS, WriteTotalTimeoutMultiplier))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "WriteTotalTimeoutConstant", offsetof(COMMTIMEOUTS, WriteTotalTimeoutConstant))) {
            return result;
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/winapi/Winbase/COMSTAT/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_native2Layout
    (

            JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (COMSTAT), __alignof__ (COMSTAT));
        if (result == NULL) {
            return NULL;
        }

        if (JnhwSetLongField(env, result, "BF_0_1__fCtsHold", 0)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_1_1__fDsrHold", 0)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_2_1__fRlsdHold", 0)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_3_1__fXoffHold", 0)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_4_1__fXoffSent", 0)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_5_1__fEof", 0)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_6_1__fTxim", 0)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_7_25__fReserved", 0)) {
            return result;
        }

        static_assert(offsetof(COMSTAT, cbInQue) == 4, "offsetof(COMSTAT, cbInQue) != 4");

        if (JnhwSetLongField(env, result, "cbInQue", offsetof(COMSTAT, cbInQue))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "cbOutQue", offsetof(COMSTAT, cbOutQue))) {

            return result;
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/winapi/Winbase/DCB/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_native2Layout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (DCB), __alignof__ (DCB));
        if (result == NULL) {
            return NULL;
        }
        if (JnhwSetLongField(env, result, "DCBlength", offsetof(DCB, DCBlength))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BaudRate", offsetof(DCB, BaudRate))) {
            return result;
        }

        //TODO get the real size for bitfield....
        static_assert(offsetof(DCB, wReserved) - offsetof(DCB, BaudRate) == 8, "sizeof bitfield != 4");

        if (JnhwSetLongField(env, result, "BF_0_1__fBinary", offsetof(DCB, wReserved) - 4)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_1_1__fParity", offsetof(DCB, wReserved) - 4)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_2_1__fOutxCtsFlow", offsetof(DCB, wReserved) - 4)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_3_1__fOutxDsrFlow", offsetof(DCB, wReserved) - 4)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_4_2__fDtrControl", offsetof(DCB, wReserved) - 4)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_6_1__fDsrSensitivity", offsetof(DCB, wReserved) - 4)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_7_1__fTXContinueOnXoff", offsetof(DCB, wReserved) - 4)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_8_1__fOutX", offsetof(DCB, wReserved) - 4)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_9_1__fInX", offsetof(DCB, wReserved) - 4)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_10_1__fErrorChar", offsetof(DCB, wReserved) - 4)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_11_1__fNull", offsetof(DCB, wReserved) - 4)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_12_2__fRtsControl", offsetof(DCB, wReserved) - 4)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_14_1__fAbortOnError", offsetof(DCB, wReserved) - 4)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "BF_15_17__fDummy2", offsetof(DCB, wReserved) - 4)) {
            return result;
        }
        if (JnhwSetLongField(env, result, "wReserved", offsetof(DCB, wReserved))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "XonLim", offsetof(DCB, XonLim))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "XoffLim", offsetof(DCB, XoffLim))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "ByteSize", offsetof(DCB, ByteSize))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "Parity", offsetof(DCB, Parity))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "StopBits", offsetof(DCB, StopBits))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "XonChar", offsetof(DCB, XonChar))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "XoffChar", offsetof(DCB, XoffChar))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "ErrorChar", offsetof(DCB, ErrorChar))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "EofChar", offsetof(DCB, EofChar))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "EvtChar", offsetof(DCB, EvtChar))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "wReserved1", offsetof(DCB, wReserved1))) {
            return result;
        }
        return result;
    }

#ifdef __cplusplus
}
#endif
#endif
