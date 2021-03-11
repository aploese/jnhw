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
#include "de_ibapl_jnhw_posix_Aio_Aiocb.h"

#ifdef __cplusplus
extern "C" {
#endif

#if defined(_POSIX_VERSION)
#if defined(__OpenBSD__)
#if defined(HAVE_AIO_H)
#error OpenBSD and aio.h
#endif
#else
#include <aio.h>
#endif
    //for offsetof
#include <stddef.h>

    JNHW_ASSERT__off_t__IS__int64_t__OR__int32_t
    JNHW_ASSERT__size_t__IS__uint64_t__OR__uint32_t

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/posix/Aio/Aiocb/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_native2Layout
#if defined(__OpenBSD__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jclass layoutClass) {
        return NULL;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (struct aiocb), __alignof__ (struct aiocb));
        if (result == NULL) {
            return NULL;
        }
        if (JnhwSetLongField(env, result, "aio_fildes", offsetof(struct aiocb, aio_fildes))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "aio_offset", offsetof(struct aiocb, aio_offset))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "aio_buf", offsetof(struct aiocb, aio_buf))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "aio_nbytes", offsetof(struct aiocb, aio_nbytes))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "aio_reqprio", offsetof(struct aiocb, aio_reqprio))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "aio_sigevent", offsetof(struct aiocb, aio_sigevent))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "aio_lio_opcode", offsetof(struct aiocb, aio_lio_opcode))) {
            return result;
        }
        return result;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_bufByteBuffer
     * Signature: (Ljava/nio/ByteBuffer;II)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1bufByteBuffer
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structAiocb, __attribute__ ((unused)) jobject byteBuffer, __attribute__ ((unused)) jint off, __attribute__ ((unused)) jint length) {
        throw_NoSuchNativeTypeException(env, "struct aiocb");
#else
    (JNIEnv *env, jobject structAiocb, jobject byteBuffer, jint off, jint length) {
        if (byteBuffer == NULL) {
            (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_buf = NULL;
            (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_nbytes = 0;
        } else {
            (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_buf = (*env)->GetDirectBufferAddress(env, byteBuffer) + off;
            // lengt can't be < 0
            (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_nbytes = (uint32_t) length;
        }
#endif
    }
#endif
#ifdef __cplusplus
}
#endif
