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
#include "de_ibapl_jnhw_winapi_Winbase_DCB.h"

#ifdef HAVE_WINBASE_H
#include <winbase.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (DCB);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    DCBlength
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_DCBlength__I
    (JNIEnv *env, jobject this, jint value) {
        if (value < 0) {
            throw_IllegalArgumentException(env, "value must not < 0");
        }
        (UNWRAP_DCB(this))->DCBlength = (uint32_t) value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    DCBlength
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_DCBlength__
    (JNIEnv *env, jobject this) {
        return (int32_t) (UNWRAP_DCB(this))->DCBlength;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    BaudRate
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_BaudRate__
    (JNIEnv *env, jobject this) {
        return (int32_t) (UNWRAP_DCB(this))->BaudRate;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    BaudRate
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_BaudRate__I
    (JNIEnv *env, jobject this, jint value) {
        if (value < 0) {
            throw_IllegalArgumentException(env, "value must not < 0");
        }
        (UNWRAP_DCB(this))->BaudRate = (uint32_t) value;
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
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fOutxCtsFlow__
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->fOutxCtsFlow;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fOutxCtsFlow
     * Signature: (Z)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fOutxCtsFlow__Z
    (JNIEnv *env, jobject this, jboolean value) {
        (UNWRAP_DCB(this))->fOutxCtsFlow = value ? TRUE : FALSE;
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
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fDtrControl
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
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fOutX__
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->fOutX;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fOutX
     * Signature: (Z)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fOutX__Z
    (JNIEnv *env, jobject this, jboolean value) {
        (UNWRAP_DCB(this))->fOutX = value ? TRUE : FALSE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fInX
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fInX__
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->fInX;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fInX
     * Signature: (Z)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fInX__Z
    (JNIEnv *env, jobject this, jboolean value) {
        (UNWRAP_DCB(this))->fInX = value ? TRUE : FALSE;
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
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fRtsControl__
    (JNIEnv *env, jobject this) {
        return (UNWRAP_DCB(this))->fRtsControl;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    fRtsControl
     * Signature: (B)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_fRtsControl__B
    (JNIEnv *env, jobject this, jbyte value) {
        switch (value) {
            case RTS_CONTROL_DISABLE:
                (UNWRAP_DCB(this))->fRtsControl = RTS_CONTROL_DISABLE;
                return;
            case RTS_CONTROL_ENABLE:
                (UNWRAP_DCB(this))->fRtsControl = RTS_CONTROL_ENABLE;
                return;
            case RTS_CONTROL_HANDSHAKE:
                (UNWRAP_DCB(this))->fRtsControl = RTS_CONTROL_HANDSHAKE;
                return;
            case RTS_CONTROL_TOGGLE:
                (UNWRAP_DCB(this))->fRtsControl = RTS_CONTROL_TOGGLE;
                return;
            default:
                throw_IllegalArgumentException(env, "value must be in range 0 ...3");
        }
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
        return (int32_t) (UNWRAP_DCB(this))->fDummy2;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    wReserved
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_wReserved
    (JNIEnv *env, jobject this) {
        return (int16_t) (UNWRAP_DCB(this))->wReserved;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    XonLim
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_XonLim
    (JNIEnv *env, jobject this) {
        return (int16_t) (UNWRAP_DCB(this))->XonLim;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    XoffLim
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_XoffLim
    (JNIEnv *env, jobject this) {
        return (int16_t) (UNWRAP_DCB(this))->XoffLim;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    ByteSize
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_ByteSize__
    (JNIEnv *env, jobject this) {
        return (int8_t) (UNWRAP_DCB(this))->ByteSize;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    ByteSize
     * Signature: (B)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_ByteSize__B
    (JNIEnv *env, jobject this, jbyte value) {
        if (value < 0) {
            throw_IllegalArgumentException(env, "value must not < 0");
        }
        (UNWRAP_DCB(this))->ByteSize = (uint8_t) value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    Parity
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_Parity__
    (JNIEnv *env, jobject this) {
        return (int8_t) (UNWRAP_DCB(this))->Parity;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    Parity
     * Signature: (B)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_Parity__B
    (JNIEnv *env, jobject this, jbyte value) {
        if (value < 0) {
            throw_IllegalArgumentException(env, "value must not < 0");
        }
        (UNWRAP_DCB(this))->Parity = (uint8_t) value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    StopBits
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_StopBits__
    (JNIEnv *env, jobject this) {
        return (int8_t) (UNWRAP_DCB(this))->StopBits;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    StopBits
     * Signature: (B)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_StopBits__B
    (JNIEnv *env, jobject this, jbyte value) {
        if (value < 0) {
            throw_IllegalArgumentException(env, "value must not < 0");
        }
        (UNWRAP_DCB(this))->StopBits = (uint8_t) value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    XonChar
     * Signature: ()C
     */
    JNIEXPORT jchar JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_XonChar__
    (JNIEnv *env, jobject this) {
        return (uint8_t) (UNWRAP_DCB(this))->XonChar;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    XonChar
     * Signature: (C)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_XonChar__C
    (JNIEnv *env, jobject this, jchar value) {
        (UNWRAP_DCB(this))->XonChar = (int8_t) value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    XoffChar
     * Signature: ()C
     */
    JNIEXPORT jchar JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_XoffChar__
    (JNIEnv *env, jobject this) {
        return (uint8_t) (UNWRAP_DCB(this))->XoffChar;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    XoffChar
     * Signature: (C)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_XoffChar__C
    (JNIEnv *env, jobject this, jchar value) {
        (UNWRAP_DCB(this))->XoffChar = (int8_t) value;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    ErrorChar
     * Signature: ()C
     */
    JNIEXPORT jchar JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_ErrorChar
    (JNIEnv *env, jobject this) {
        return (uint8_t) (UNWRAP_DCB(this))->ErrorChar;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    EofChar
     * Signature: ()C
     */
    JNIEXPORT jchar JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_EofChar
    (JNIEnv *env, jobject this) {
        return (uint8_t) (UNWRAP_DCB(this))->EofChar;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    EvtChar
     * Signature: ()C
     */
    JNIEXPORT jchar JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_EvtChar
    (JNIEnv *env, jobject this) {
        return (uint8_t) (UNWRAP_DCB(this))->EvtChar;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_DCB
     * Method:    wReserved1
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024DCB_wReserved1
    (JNIEnv *env, jobject this) {
        return (int16_t) (UNWRAP_DCB(this))->wReserved1;
    }

#ifdef __cplusplus
}
#endif
#endif
