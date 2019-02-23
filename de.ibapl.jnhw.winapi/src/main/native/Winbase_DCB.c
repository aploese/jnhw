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
#include "de_ibapl_jnhw_winapi_Winbase_DCB.h"

#ifdef HAVE_WINBASE_H
#include <winbase.h>

#ifdef __cplusplus
extern "C" {
#endif

        /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    sizeofDCB
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_sizeofDCB
    (JNIEnv *env, jclass clazz) {
        return sizeof (DCB);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    DCBlength
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_DCBlength__JI
    (JNIEnv *env, jclass clazz, jlong baseAddress, jint value) {
        ((DCB*) (uintptr_t) baseAddress)->DCBlength = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    DCBlength
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_DCBlength__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->DCBlength;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    BaudRate
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_BaudRate__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->BaudRate;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    BaudRate
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_BaudRate__JI
    (JNIEnv *env, jclass clazz, jlong baseAddress, jint value) {
        ((DCB*) (uintptr_t) baseAddress)->BaudRate = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fBinary
     * Signature: (J)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fBinary
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->fBinary;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fParity
     * Signature: (J)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fParity
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->fParity;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fOutxCtsFlow
     * Signature: (J)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fOutxCtsFlow__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->fOutxCtsFlow;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fOutxCtsFlow
     * Signature: (JZ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fOutxCtsFlow__JZ
    (JNIEnv *env, jclass clazz, jlong baseAddress, jboolean value) {
        ((DCB*) (uintptr_t) baseAddress)->fOutxCtsFlow = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fOutxDsrFlow
     * Signature: (J)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fOutxDsrFlow
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->fOutxDsrFlow;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fDtrControl
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fDtrControl
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->fDtrControl;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fDsrSensitivity
     * Signature: (J)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fDsrSensitivity
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->fDsrSensitivity;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fTXContinueOnXoff
     * Signature: (J)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fTXContinueOnXoff
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->fTXContinueOnXoff;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fOutX
     * Signature: (J)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fOutX__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->fOutX;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fOutX
     * Signature: (JZ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fOutX__JZ
    (JNIEnv *env, jclass clazz, jlong baseAddress, jboolean value) {
        ((DCB*) (uintptr_t) baseAddress)->fOutX = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fInX
     * Signature: (J)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fInX__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->fInX;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fInX
     * Signature: (JZ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fInX__JZ
    (JNIEnv *env, jclass clazz, jlong baseAddress, jboolean value) {
        ((DCB*) (uintptr_t) baseAddress)->fInX = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fErrorChar
     * Signature: (J)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fErrorChar
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->fErrorChar;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fNull
     * Signature: (J)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fNull
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->fNull;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fRtsControl
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fRtsControl__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->fRtsControl;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fRtsControl
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fRtsControl__JI
    (JNIEnv *env, jclass clazz, jlong baseAddress, jint value) {
        ((DCB*) (uintptr_t) baseAddress)->fRtsControl = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fAbortOnError
     * Signature: (J)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fAbortOnError
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->fAbortOnError;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fDummy2
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fDummy2
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->fDummy2;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    wReserved
     * Signature: (J)S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_wReserved
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->wReserved;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    XonLim
     * Signature: (J)S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_XonLim
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->XonLim;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    XoffLim
     * Signature: (J)S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_XoffLim
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->XoffLim;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    ByteSize
     * Signature: (J)B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_ByteSize__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->ByteSize;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    ByteSize
     * Signature: (JB)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_ByteSize__JB
    (JNIEnv *env, jclass clazz, jlong baseAddress, jbyte value) {
        ((DCB*) (uintptr_t) baseAddress)->ByteSize = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    Parity
     * Signature: (J)B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_Parity__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->Parity;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    Parity
     * Signature: (JB)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_Parity__JB
    (JNIEnv *env, jclass clazz, jlong baseAddress, jbyte value) {
        ((DCB*) (uintptr_t) baseAddress)->Parity = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    StopBits
     * Signature: (J)B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_StopBits__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->StopBits;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    StopBits
     * Signature: (JB)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_StopBits__JB
    (JNIEnv *env, jclass clazz, jlong baseAddress, jbyte value) {
        ((DCB*) (uintptr_t) baseAddress)->StopBits = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    XonChar
     * Signature: (J)C
     */
    JNIEXPORT jchar JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_XonChar__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->XonChar;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    XonChar
     * Signature: (JC)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_XonChar__JC
    (JNIEnv *env, jclass clazz, jlong baseAddress, jchar value) {
        ((DCB*) (uintptr_t) baseAddress)->XonChar = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    XoffChar
     * Signature: (J)C
     */
    JNIEXPORT jchar JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_XoffChar__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->XoffChar;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    XoffChar
     * Signature: (JC)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_XoffChar__JC
    (JNIEnv *env, jclass clazz, jlong baseAddress, jchar value) {
        ((DCB*) (uintptr_t) baseAddress)->XoffChar = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    ErrorChar
     * Signature: (J)C
     */
    JNIEXPORT jchar JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_ErrorChar
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->ErrorChar;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    EofChar
     * Signature: (J)C
     */
    JNIEXPORT jchar JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_EofChar
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->EofChar;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    EvtChar
     * Signature: (J)C
     */
    JNIEXPORT jchar JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_EvtChar
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->EvtChar;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    wReserved1
     * Signature: (J)S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_wReserved1
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((DCB*) (uintptr_t) baseAddress)->wReserved1;
    }

#ifdef __cplusplus
}
#endif
#endif
