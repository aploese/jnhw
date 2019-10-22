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
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_DCBlength__I
    (JNIEnv *env, jobject this, jint value) {
        (UNWRAP_DCB(this))->DCBlength = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    DCBlength
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_DCBlength__
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->DCBlength;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    BaudRate
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_BaudRate__J
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->BaudRate;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    BaudRate
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_BaudRate__JI
    (JNIEnv *env, jobject this, jint value) {
        (UNWRAP_DCB(this))->BaudRate = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fBinary
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fBinary
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->fBinary;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fParity
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fParity
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->fParity;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fOutxCtsFlow
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fOutxCtsFlow__J
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->fOutxCtsFlow;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fOutxCtsFlow
     * Signature: (Z)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fOutxCtsFlow__JZ
    (JNIEnv *env, jobject this, jboolean value) {
        (UNWRAP_DCB(this))->fOutxCtsFlow = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fOutxDsrFlow
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fOutxDsrFlow
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->fOutxDsrFlow;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fDtrControl
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fDtrControl
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->fDtrControl;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fDsrSensitivity
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fDsrSensitivity
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->fDsrSensitivity;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fTXContinueOnXoff
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fTXContinueOnXoff
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->fTXContinueOnXoff;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fOutX
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fOutX__J
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->fOutX;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fOutX
     * Signature: (Z)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fOutX__JZ
    (JNIEnv *env, jobject this, jboolean value) {
        (UNWRAP_DCB(this))->fOutX = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fInX
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fInX__J
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->fInX;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fInX
     * Signature: (Z)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fInX__JZ
    (JNIEnv *env, jobject this, jboolean value) {
        (UNWRAP_DCB(this))->fInX = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fErrorChar
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fErrorChar
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->fErrorChar;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fNull
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fNull
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->fNull;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fRtsControl
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fRtsControl__J
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->fRtsControl;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fRtsControl
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fRtsControl__JI
    (JNIEnv *env, jobject this, jint value) {
        (UNWRAP_DCB(this))->fRtsControl = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fAbortOnError
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fAbortOnError
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->fAbortOnError;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fDummy2
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fDummy2
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->fDummy2;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    wReserved
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_wReserved
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->wReserved;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    XonLim
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_XonLim
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->XonLim;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    XoffLim
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_XoffLim
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->XoffLim;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    ByteSize
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_ByteSize__J
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->ByteSize;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    ByteSize
     * Signature: (B)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_ByteSize__JB
    (JNIEnv *env, jobject this, jbyte value) {
        (UNWRAP_DCB(this))->ByteSize = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    Parity
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_Parity__J
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->Parity;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    Parity
     * Signature: (B)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_Parity__JB
    (JNIEnv *env, jobject this, jbyte value) {
        (UNWRAP_DCB(this))->Parity = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    StopBits
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_StopBits__J
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->StopBits;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    StopBits
     * Signature: (B)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_StopBits__JB
    (JNIEnv *env, jobject this, jbyte value) {
        (UNWRAP_DCB(this))->StopBits = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    XonChar
     * Signature: ()C
     */
    JNIEXPORT jchar JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_XonChar__J
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->XonChar;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    XonChar
     * Signature: (C)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_XonChar__JC
    (JNIEnv *env, jobject this, jchar value) {
        (UNWRAP_DCB(this))->XonChar = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    XoffChar
     * Signature: ()C
     */
    JNIEXPORT jchar JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_XoffChar__J
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->XoffChar;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    XoffChar
     * Signature: (C)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_XoffChar__JC
    (JNIEnv *env, jobject this, jchar value) {
        (UNWRAP_DCB(this))->XoffChar = value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    ErrorChar
     * Signature: ()C
     */
    JNIEXPORT jchar JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_ErrorChar
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->ErrorChar;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    EofChar
     * Signature: ()C
     */
    JNIEXPORT jchar JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_EofChar
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->EofChar;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    EvtChar
     * Signature: ()C
     */
    JNIEXPORT jchar JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_EvtChar
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->EvtChar;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    wReserved1
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_wReserved1
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->wReserved1;
    }

#ifdef __cplusplus
}
#endif
#endif
