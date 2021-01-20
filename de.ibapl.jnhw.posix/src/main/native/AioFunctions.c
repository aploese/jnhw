/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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
#include "de_ibapl_jnhw_posix_Aio.h"

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
#include <errno.h>
#include <unistd.h>

  JNHW_ASSERT__ssize_t__IS__int64_t__OR__int32_t

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    aio_cancel
     * Signature: (Lde/ibapl/jnhw/posix/Aio/Aiocb;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_aio_1cancel__Lde_ibapl_jnhw_posix_Aio_00024Aiocb_2
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jobject aiocb) {
        throw_NoSuchNativeMethodException(env, "aio_cancel");
        return -1;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject aiocb) {
        if (aiocb == NULL) {
            throw_NullPointerException(env, "aiocb is null");
            return -1;
        }
        struct aiocb *_aiocb = UNWRAP_STRUCT_AIOCB_PTR(aiocb);
        const int result = aio_cancel(_aiocb->aio_fildes, _aiocb);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    aio_cancel
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_aio_1cancel__I
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint fildes) {
        throw_NoSuchNativeMethodException(env, "aio_cancel");
        return -1;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fildes) {
        const int result = aio_cancel(fildes, NULL);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    aio_error
     * Signature: (Lde/ibapl/jnhw/posix/Aio/Aiocb;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_aio_1error
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jobject aiocb) {
        throw_NoSuchNativeMethodException(env, "aio_error");
        return -1;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject aiocb) {
        if (aiocb == NULL) {
            throw_NullPointerException(env, "aiocb is null");
            return -1;
        }
        const int result = aio_error(UNWRAP_STRUCT_AIOCB_PTR(aiocb));
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    aio_fsync
     * Signature: (ILde/ibapl/jnhw/posix/Aio/Aiocb;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_aio_1fsync
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint op, __attribute__ ((unused)) jobject aiocb) {
        throw_NoSuchNativeMethodException(env, "aio_fsync");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint op, jobject aiocb) {
        if (aiocb == NULL) {
            throw_NullPointerException(env, "aiocb is null");
            return;
        }
        if (aio_fsync(op, UNWRAP_STRUCT_AIOCB_PTR(aiocb))) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    aio_read
     * Signature: (Lde/ibapl/jnhw/posix/Aio/Aiocb;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_aio_1read
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jobject aiocb) {
        throw_NoSuchNativeMethodException(env, "aio_read");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject aiocb) {
        if (aiocb == NULL) {
            throw_NullPointerException(env, "aiocb is null");
            return;
        }
        if (aio_read(UNWRAP_STRUCT_AIOCB_PTR(aiocb))) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    aio_return
     * Signature: (Lde/ibapl/jnhw/posix/Aio/Aiocb;)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Aio_aio_1return
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jobject aiocb) {
        throw_NoSuchNativeMethodException(env, "aio_return");
        return -1;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject aiocb) {
        if (aiocb == NULL) {
            throw_NullPointerException(env, "aiocb is null");
            return -1;
        }
        const ssize_t result = aio_return(UNWRAP_STRUCT_AIOCB_PTR(aiocb));
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    aio_suspend
     * Signature: (Lde/ibapl/jnhw/posix/Aio/Aiocbs;Lde/ibapl/jnhw/posix/Time/Timespec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_aio_1suspend
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jobject list, __attribute__ ((unused)) jobject timeout) {
        throw_NoSuchNativeMethodException(env, "aio_suspend");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject list, jobject timeout) {
        if (list == NULL) {
            throw_NullPointerException(env, "list is null");
            return;
        }
        if (timeout == NULL) {
            throw_NullPointerException(env, "timeout is null");
            return;
        }

        if (aio_suspend(UNWRAP_CONST_STRUCT_AIOCBS_PTR_PTR(list), LENGTH_OF_AIOCBS(list), UNWRAP_STRUCT_TIMESPEC_PTR(timeout))) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    aio_write
     * Signature: (Lde/ibapl/jnhw/posix/Aio/Aiocb;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_aio_1write
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jobject aiocb) {
        throw_NoSuchNativeMethodException(env, "aio_write");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject aiocb) {
        if (aiocb == NULL) {
            throw_NullPointerException(env, "aiocb is null");
            return;
        }
        if (aio_write(UNWRAP_STRUCT_AIOCB_PTR(aiocb))) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    lio_listio
     * Signature: (ILde/ibapl/jnhw/posix/Aio/Aiocbs;Lde/ibapl/jnhw/posix/Signal/Sigevent;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_lio_1listio
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint mode, __attribute__ ((unused)) jobject list, __attribute__ ((unused)) jobject sig) {
        throw_NoSuchNativeMethodException(env, "lio_listio");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint mode, jobject list, jobject sig) {
        if (list == NULL) {
            throw_NullPointerException(env, "list is null");
            return;
        }
        if (lio_listio(mode, UNWRAP_STRUCT_AIOCBS_PTR_PTR(list), LENGTH_OF_AIOCBS(list), UNWRAP_STRUCT_SIGEVENT_PTR_OR_NULL(sig))) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

#endif    
#ifdef __cplusplus
}
#endif