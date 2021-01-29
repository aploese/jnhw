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

#if defined(__LP64__)
  #if __SIZEOF_POINTER__ != 8
    #error __hppa__ and __SIZEOF_POINTER__ != 8
  #endif
#elif defined(__ILP32__)
  #if __SIZEOF_POINTER__ != 4
    #error __hppa__ and __SIZEOF_POINTER__ != 4
  #endif
#else
  #if __SIZEOF_POINTER__ != 4
    #error __hppa__ and __SIZEOF_POINTER__ != 4
  #endif
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_sizeof
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        throw_NoSuchNativeTypeException(env, "struct aiocb");
        return -1;
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct aiocb);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_alignof
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        throw_NoSuchNativeTypeException(env, "struct aiocb");
        return -1;
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct aiocb);
#endif
    }


    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    offsetof_Aio_sigevent
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_offsetof_1Aio_1sigevent
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        throw_NoSuchNativeTypeException(env, "struct aiocb");
        return -1;
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct aiocb, aio_sigevent);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_fildes
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1fildes__
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structAiocb) {
        throw_NoSuchNativeTypeException(env, "struct aiocb");
        return -1;
#else
    (JNIEnv *env, jobject structAiocb) {
        return (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_fildes;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_fildes
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1fildes__I
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structAiocb, __attribute__ ((unused)) jint aio_fildes) {
        throw_NoSuchNativeTypeException(env, "struct aiocb");
#else
    (JNIEnv *env, jobject structAiocb, jint aio_fildes) {
        (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_fildes = aio_fildes;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_offset
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1offset__
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structAiocb) {
        throw_NoSuchNativeTypeException(env, "struct aiocb");
        return -1;
#else
    (JNIEnv *env, jobject structAiocb) {
        return (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_offset;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_offset
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1offset__J
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structAiocb, __attribute__ ((unused)) jlong aio_offset) {
        throw_NoSuchNativeTypeException(env, "struct aiocb");
#else
    (JNIEnv *env, jobject structAiocb, jlong aio_offset) {
#if defined(_JNHW__off_t__IS__int32_t)
        if ((aio_offset > INT32_MAX) || (aio_offset < INT32_MIN)) {
            throw_IllegalArgumentException(env, "aio_offset outside off_t(int32_t)");
            return;
        }
#elif defined(_JNHW__off_t__IS__int64_t)
#else
#error expected off_t is int32_t or int64_t
#endif 
        (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_offset = (off_t)aio_offset;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_buf0
     * Signature: ()Lde/ibapl/jnhw/common/memory/NativeAddressHolder;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1buf0
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structAiocb) {
        throw_NoSuchNativeTypeException(env, "struct aiocb");
        return NULL;
#else
    (JNIEnv *env, jobject structAiocb) {
       return CREATE_NATIVE_ADDRESS_HOLDER((UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_buf);
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
            // lengt cant be < 0
            (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_nbytes = (uint32_t) length;
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_bufOpaqueMemory
     * Signature: (Ljava/nio/ByteBuffer;II)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1bufOpaqueMemory
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structAiocb, __attribute__ ((unused)) jobject bufOpaqueMemory, __attribute__ ((unused)) jint off, __attribute__ ((unused)) jint length) {
        throw_NoSuchNativeTypeException(env, "struct aiocb");
#else
    (JNIEnv *env, jobject structAiocb, jobject bufOpaqueMemory, jint off, jint length) {
        (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_buf = UNWRAP_ABSTRACT_MEM_TO_VOID_PTR_OR_NULL(bufOpaqueMemory) + off;
        // lengt cant be < 0
        (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_nbytes = (uint32_t) length;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_nbytes
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1nbytes
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structAiocb) {
        throw_NoSuchNativeTypeException(env, "struct aiocb");
        return -1;
#else
    (JNIEnv *env, jobject structAiocb) {
        return (int64_t) (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_nbytes;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_reqprio
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1reqprio__
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structAiocb) {
        throw_NoSuchNativeTypeException(env, "struct aiocb");
        return -1;
#else
    (JNIEnv *env, jobject structAiocb) {
        return (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_reqprio;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_reqprio
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1reqprio__I
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structAiocb, __attribute__ ((unused)) jint aio_reqprio) {
        throw_NoSuchNativeTypeException(env, "struct aiocb");
#else
    (JNIEnv *env, jobject structAiocb, jint aio_reqprio) {
        (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_reqprio = aio_reqprio;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_lio_opcode
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1lio_1opcode__
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structAiocb) {
        throw_NoSuchNativeTypeException(env, "struct aiocb");
        return -1;
#else
    (JNIEnv *env, jobject structAiocb) {
        return (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_lio_opcode;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio_Aiocb
     * Method:    aio_lio_opcode
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_00024Aiocb_aio_1lio_1opcode__I
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structAiocb, __attribute__ ((unused)) jint aio_lio_opcode) {
        throw_NoSuchNativeTypeException(env, "struct aiocb");
#else
    (JNIEnv *env, jobject structAiocb, jint aio_lio_opcode) {
        (UNWRAP_STRUCT_AIOCB_PTR(structAiocb))->aio_lio_opcode = aio_lio_opcode;
#endif
    }

#endif
#ifdef __cplusplus
}
#endif
