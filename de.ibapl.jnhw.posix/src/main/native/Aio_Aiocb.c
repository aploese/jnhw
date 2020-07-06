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
#include "jnhw-posix.h"
#include "de_ibapl_jnhw_posix_Aio_Aiocb.h"

#if defined(HAVE_AIO_H) && defined(_POSIX_VERSION)

#include <aio.h>
//for offsetof
#include <stddef.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    sizeofAiocb
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_sizeofAiocb
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct aiocb);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    _aio_sigevent_value_Offset
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb__1aio_1sigevent_1value_1Offset
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct aiocb, aio_sigevent);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_fildes
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1fildes__
    (JNIEnv *env, jobject structAiocb) {
        return (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_fildes;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_fildes
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1fildes__I
    (JNIEnv *env, jobject structAiocb, jint aio_fildes) {
        (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_fildes = aio_fildes;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_offset
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1offset__
    (JNIEnv *env, jobject structAiocb) {
        return (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_offset;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_offset
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1offset__J
    (JNIEnv *env, jobject structAiocb, jlong aio_offset) {
#if __WORDSIZE == 64
        (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_offset = aio_offset;
#elif __WORDSIZE == 32
        if ((aio_offset > INT32_MAX) || (aio_offset < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation aio_offset is only an integer with the size of jint");
            return;
        }
        (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_offset = (int32_t)aio_offset;
#else
#error Unknown Wordsize
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_bufByteBuffer
     * Signature: (Ljava/nio/ByteBuffer;II)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1bufByteBuffer
    (JNIEnv *env, jobject structAiocb, jobject byteBuffer, jint off, jint length) {
        if (byteBuffer == NULL) {
            (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_buf = NULL;
            (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_nbytes = 0;
        } else {
            (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_buf = (*env)->GetDirectBufferAddress(env, byteBuffer) + off;
            // lengt cant be < 0
            (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_nbytes = (uint32_t) length;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_bufOpaqueMemory
     * Signature: (Ljava/nio/ByteBuffer;II)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1bufOpaqueMemory
    (JNIEnv *env, jobject structAiocb, jobject bufOpaqueMemory, jint off, jint length) {
        (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_buf = UNWRAP_OPAQUE_MEM_TO_VOID_PTR_OR_NULL(bufOpaqueMemory) + off;
        // lengt cant be < 0
        (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_nbytes = (uint32_t) length;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_nbytes
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1nbytes__
    (JNIEnv *env, jobject structAiocb) {
        return (int64_t) (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_nbytes;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_reqprio
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1reqprio__
    (JNIEnv *env, jobject structAiocb) {
        return (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_reqprio;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_reqprio
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1reqprio__I
    (JNIEnv *env, jobject structAiocb, jint aio_reqprio) {
        (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_reqprio = aio_reqprio;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_lio_opcode
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1lio_1opcode__
    (JNIEnv *env, jobject structAiocb) {
        return (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_lio_opcode;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_lio_opcode
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1lio_1opcode__I
    (JNIEnv *env, jobject structAiocb, jint aio_lio_opcode) {
        (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_lio_opcode = aio_lio_opcode;
    }

#ifdef __cplusplus
}
#endif
#endif