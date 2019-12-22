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

#ifdef HAVE_AIO_H

#include <aio.h>

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
        (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_offset = aio_offset;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_buf
     * Signature: ()Ljava/nio/ByteBuffer;
     * /
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1buf__
    (JNIEnv *env, jobject structAiocb) {
        return (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->;
    }

    / *
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_buf
     * Signature: (Ljava/nio/ByteBuffer;)V
     * /
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1buf__Ljava_nio_ByteBuffer_2
    (JNIEnv *env, jobject structAiocb) {
        return (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->;
    }
*/
    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_nbytes
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1nbytes__
    (JNIEnv *env, jobject structAiocb) {
        return (int64_t)(UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_nbytes;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_nbytes
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1nbytes__I
    (JNIEnv *env, jobject structAiocb, jlong aio_nbytes) {
        (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_nbytes = (uint64_t)aio_nbytes;
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
        (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_reqprio  = aio_reqprio;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_sigevent
     * Signature: ()Lde/ibapl/jnhw/posix/Signal/Sigevent;
     * /
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1sigevent__
    (JNIEnv *env, jobject structAiocb) {
        return (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->;
    }

    / *
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_sigevent
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Sigevent;)V
     * /
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1sigevent__Lde_ibapl_jnhw_posix_Signal_Sigevent_2
    (JNIEnv *env, jobject structAiocb) {
        return (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->;
    }
*/
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