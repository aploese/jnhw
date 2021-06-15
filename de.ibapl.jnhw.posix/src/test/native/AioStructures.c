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
#include "de_ibapl_jnhw_posix_AioTest_NativeAiocb.h"

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
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeAiocb
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeAiocb_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct aiocb);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeAiocb
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeAiocb_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct aiocb);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeAiocb
     * Method:    aio_fildes
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeAiocb_aio_1fildes
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct aiocb, aio_fildes);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeAiocb
     * Method:    aio_offset
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeAiocb_aio_1offset
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct aiocb, aio_offset);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeAiocb
     * Method:    aio_buf
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeAiocb_aio_1buf
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct aiocb, aio_buf);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeAiocb
     * Method:    aio_nbytes
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeAiocb_aio_1nbytes
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct aiocb, aio_nbytes);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeAiocb
     * Method:    aio_reqprio
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeAiocb_aio_1reqprio
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct aiocb, aio_reqprio);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeAiocb
     * Method:    aio_sigevent
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeAiocb_aio_1sigevent
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct aiocb, aio_sigevent);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeAiocb
     * Method:    aio_lio_opcode
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeAiocb_aio_1lio_1opcode
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct aiocb, aio_lio_opcode);
    }

#endif

#ifdef __cplusplus
}
#endif
