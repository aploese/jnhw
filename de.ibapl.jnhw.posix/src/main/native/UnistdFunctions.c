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
#include "../../../config.h"
#include "jnhw-posix.h"
#if HAVE_UNISTD_H
#include <unistd.h>
#endif

#ifdef _POSIX_VERSION

#include "de_ibapl_jnhw_posix_Unistd.h"
#include <errno.h>
#include <stdlib.h>
#include <stdint.h>

/* The maximum size of a stack-allocated buffer.
 */
#define MAX_STACK_BUF_SIZE 8192


#ifdef __cplusplus
extern "C" {
#endif

/*
     * Class:     de_ibapl_jnhw_posix_Unistd_JnhwPrimitiveArrayCritical
     * Method:    read
     * Signature: (I[BII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_00024JnhwPrimitiveArrayCritical_read
    (JNIEnv *env, jclass clazz, jint fd, jbyteArray buf, jint pos, jint len) {
        if (buf == NULL) {
            throw_NullPointerException(env, "buf is null");
            return -1;
        }
        if (outOfBoundsByteArray(env, pos, len, buf)) {
            throw_ArrayIndexOutOfBoundsException(env, "");
            return -1;
        }

        if (len == 0) {
            return 0;
        }

        jbyte* _buf = (*env)->GetPrimitiveArrayCritical(env, buf, 0);
        int result = read(fd, _buf + pos, len);
        if (result < 0) {
            (*env)->ReleasePrimitiveArrayCritical(env, buf, _buf, JNI_ABORT); // error, so no need to copy back.
            throw_NativeErrorException(env, errno);
        }
        (*env)->ReleasePrimitiveArrayCritical(env, buf, _buf, 0);
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd_JnhwPrimitiveArrayCritical
     * Method:    write
     * Signature: (I[BII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_00024JnhwPrimitiveArrayCritical_write
    (JNIEnv *env, jclass clazz, jint fd, jbyteArray buf, jint pos, jint len) {
        if (buf == NULL) {
            throw_NullPointerException(env, "buf is null");
            return -1;
        }
        if (outOfBoundsByteArray(env, pos, len, buf)) {
            throw_ArrayIndexOutOfBoundsException(env, "");
            return -1;
        }

        if (len == 0) {
            return 0;
        }

        jbyte* _buf = (*env)->GetPrimitiveArrayCritical(env, buf, 0);
        int result = write(fd, _buf + pos, len);
        if (result < 0) {
            (*env)->ReleasePrimitiveArrayCritical(env, buf, _buf, JNI_ABORT); // data was written out so no need to copy back.
            throw_NativeErrorException(env, errno);
        }
        (*env)->ReleasePrimitiveArrayCritical(env, buf, _buf, JNI_ABORT); // data was written out so no need to copy back.
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    close
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_close
    (JNIEnv *env, jclass clazz, jint fd) {
        int result = close(fd);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    read
     * Signature: (I[BII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_read__I_3BII
    (JNIEnv *env, jclass clazz, jint fd, jbyteArray buf, jint pos, jint len) {
        if (buf == NULL) {
            throw_NullPointerException(env, "buf is null");
            return -1;
        }

        if (outOfBoundsByteArray(env, pos, len, buf)) {
            throw_ArrayIndexOutOfBoundsException(env, "");
            return -1;
        }

        jbyte stackBuf[len > MAX_STACK_BUF_SIZE ? 0 : len];
        jbyte *_buf = NULL;
        if (len == 0) {
            return 0;
        } else if (len > MAX_STACK_BUF_SIZE) {
            _buf = malloc(len);
            if (_buf == NULL) {
                throwException(env, "java.lang.OutOfMemoryError", "Can`t aquire %d bytes of memory", len);
                return 0;
            }
        } else {
            _buf = stackBuf;
        }

        int result = read(fd, _buf, len);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        (*env)->SetByteArrayRegion(env, buf, pos, result, _buf);

        if (_buf != stackBuf) {
            free(_buf);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    read
     * Signature: (ILjava/nio/ByteBuffer;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_read__ILjava_nio_ByteBuffer_2II
    (JNIEnv *env, jclass clazz, jint fd, jobject byteBuffer, jint pos, jint len) {
        //TODO handle the complete Bytebuffer here???
        long result = read(fd, (*env)->GetDirectBufferAddress(env, byteBuffer) + pos, len);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    read
     * Signature: (ILde/ibapl/jnhw/OpaqueMemory;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_read__ILde_ibapl_jnhw_OpaqueMemory_2II
    (JNIEnv *env, jclass clazz, jint fd, jobject opaqueMemory, jint pos, jint len) {
        if (opaqueMemory == NULL) {
            throw_NullPointerException(env, "buf is null");
            return -1;
        }
        if (outOfBoundsOpaqueMemory(env, pos, len, opaqueMemory)) {
            throw_ArrayIndexOutOfBoundsException(env, "");
            return -1;
        }
        int result =  read(fd, UNWRAP_OPAQUE_MEM_TO_VOID_PTR(opaqueMemory), len);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    read
     * Signature: (ILde/ibapl/jnhw/ByteRef;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_read__ILde_ibapl_jnhw_ByteRef_2
    (JNIEnv *env, jclass clazz, jint fd, jobject byteRef) {
        jbyte _valueRef;
        int result = read(fd, &_valueRef, 1);
        SET_BYTE_REF_VALUE(byteRef, _valueRef);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    write
     * Signature: (I[BII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_write__I_3BII
    (JNIEnv *env, jclass clazz, jint fd, jbyteArray buf, jint pos, jint len) {
        if (outOfBoundsByteArray(env, pos, len, buf)) {
            throw_ArrayIndexOutOfBoundsException(env, "");
            return -1;
        }

        jbyte stackBuf[len > MAX_STACK_BUF_SIZE ? 0 : len];
        jbyte *_buf = NULL;
        if (len == 0) {
            return 0;
        } else if (len > MAX_STACK_BUF_SIZE) {
            _buf = malloc(len);
            if (_buf == NULL) {
                throwException(env, "java.lang.OutOfMemoryError", "Can`t aquire %d bytes of memory", len);
                return 0;
            }
        } else {
            _buf = stackBuf;
        }

        (*env)->GetByteArrayRegion(env, buf, pos, len, _buf);
        if ((*env)->ExceptionOccurred(env)) {
            if (_buf != stackBuf) {
                free(_buf);
            }
            return -1;
        }
        int result = write(fd, _buf, len);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        if (_buf != stackBuf) {
            free(_buf);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    write
     * Signature: (ILjava/nio/ByteBuffer;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_write__ILjava_nio_ByteBuffer_2II
    (JNIEnv *env, jclass clazz, jint fd, jobject byteBuffer, jint pos, jint len) {
        long result = write(fd, (*env)->GetDirectBufferAddress(env, byteBuffer) + pos, len);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

/*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    write
     * Signature: (ILde/ibapl/jnhw/OpaqueMemory;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_write__ILde_ibapl_jnhw_OpaqueMemory_2II
    (JNIEnv *env, jclass clazz, jint fd, jobject opaqueMemory, jint pos, jint len) {
        if (outOfBoundsOpaqueMemory(env, pos, len, opaqueMemory)) {
            throw_ArrayIndexOutOfBoundsException(env, "");
            return -1;
        }
        int result =  write(fd, (void*)(uintptr_t)(*env)->GetLongField(env, opaqueMemory, de_ibapl_jnhw_OpaqueMemory_baseAddress_ID), len);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    write
     * Signature: (IB)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_write__IB
    (JNIEnv *env, jclass clazz, jint fd, jbyte data) {
        int result = write(fd, &data, 1);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    usleep
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_usleep
    (JNIEnv *env, jclass clazz, jint usec) {
        int result = usleep(usec);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    lseek
     * Signature: (III)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_lseek
    (JNIEnv *env, jclass clazz, jint fd, jint offset, jint whence) {
        __off_t result = lseek(fd, offset, whence);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    lseek64
     * Signature: (IJI)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Unistd_lseek64
    (JNIEnv *env, jclass clazz, jint fd, jlong offset, jint whence) {
        __off64_t result = lseek64(fd, offset, whence);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    pipe
     * Signature: (Lde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/IntRef;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Unistd_pipe
    (JNIEnv *env, jclass clazz, jobject read_fd_ref, jobject write_fd_ref) {
        if (read_fd_ref == NULL) {
            throw_NullPointerException(env, "read_fd_ref is null");
            return;
        }
        if (write_fd_ref == NULL) {
            throw_NullPointerException(env, "write_fd_ref is null");
            return;
        }
        int fdes[2];
        int result = pipe(fdes);
        SET_INT_REF_VALUE(read_fd_ref, fdes[0]);
        SET_INT_REF_VALUE(write_fd_ref, fdes[1]);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
    }


#ifdef __cplusplus
}
#endif
#endif