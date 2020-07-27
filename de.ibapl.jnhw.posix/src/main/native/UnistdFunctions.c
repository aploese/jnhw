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
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jbyteArray buf, jint off, jint nByte) {
        if (buf == NULL) {
            throw_NullPointerException(env, "buf is null");
            return -1;
        }
        if (outOfBoundsByteArray(env, off, nByte, buf)) {
            throw_ArrayIndexOutOfBoundsException(env, "");
            return -1;
        }

        if (nByte == 0) {
            return 0;
        }

        jbyte* _buf = (*env)->GetPrimitiveArrayCritical(env, buf, 0);
        //result can't be larger then int beacuase nByte is int, so do the conversation
        const ssize_t result = read(fd, _buf + off, (uint32_t) nByte);
        if (result == -1) {
            (*env)->ReleasePrimitiveArrayCritical(env, buf, _buf, JNI_ABORT); // error, so no need to copy back.
            throw_NativeErrorException(env, errno);
        }
        (*env)->ReleasePrimitiveArrayCritical(env, buf, _buf, 0);
        return (int32_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd_JnhwPrimitiveArrayCritical
     * Method:    write
     * Signature: (I[BII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_00024JnhwPrimitiveArrayCritical_write
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jbyteArray buf, jint off, jint nByte) {
        if (buf == NULL) {
            throw_NullPointerException(env, "buf is null");
            return -1;
        }
        if (outOfBoundsByteArray(env, off, nByte, buf)) {
            throw_ArrayIndexOutOfBoundsException(env, "");
            return -1;
        }

        if (nByte == 0) {
            return 0;
        }

        jbyte* _buf = (*env)->GetPrimitiveArrayCritical(env, buf, 0);
        //result can't be larger then int beacuase nByte is int, so do the conversation
        const ssize_t result = write(fd, _buf + off, (uint32_t) nByte);
        if (result == -1) {
            (*env)->ReleasePrimitiveArrayCritical(env, buf, _buf, JNI_ABORT); // data was written out so no need to copy back.
            throw_NativeErrorException(env, errno);
        }
        (*env)->ReleasePrimitiveArrayCritical(env, buf, _buf, JNI_ABORT); // data was written out so no need to copy back.
        return (int32_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    close
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Unistd_close
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd) {
        if (close(fd)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    read
     * Signature: (I[BII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_read__I_3BII
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jbyteArray buf, jint off, jint nByte) {
        if (buf == NULL) {
            throw_NullPointerException(env, "buf is null");
            return -1;
        }

        if (outOfBoundsByteArray(env, off, nByte, buf)) {
            throw_ArrayIndexOutOfBoundsException(env, "");
            return -1;
        }

        jbyte stackBuf[nByte > MAX_STACK_BUF_SIZE ? 0 : nByte];
        jbyte *_buf = NULL;
        if (nByte == 0) {
            return 0;
        } else if (nByte > MAX_STACK_BUF_SIZE) {
            _buf = malloc((uint32_t) nByte);
            if (_buf == NULL) {
                throw_Exception(env, OUT_OF_MEMORY_ERROR_CLASS_NAME, "Can`t aquire %d bytes of memory", nByte);
                return 0;
            }
        } else {
            _buf = stackBuf;
        }

        //result can't be larger then int beacuase nByte is int, so do the conversation
        const ssize_t result = read(fd, _buf, (uint32_t) nByte);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        (*env)->SetByteArrayRegion(env, buf, off, (int32_t) result, _buf);

        if (_buf != stackBuf) {
            free(_buf);
        }
        return (int32_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    read_ArgsOK
     * Signature: (ILjava/nio/ByteBuffer;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_read_1ArgsOK
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jobject byteBuffer, jint off, jint nByte) {
        //result can't be larger then int beacuase nByte is int, so do the conversation
        const ssize_t result = read(fd, (*env)->GetDirectBufferAddress(env, byteBuffer) + off, (uint32_t) nByte);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return (int32_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    read
     * Signature: (ILde/ibapl/jnhw/OpaqueMemory;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_read__ILde_ibapl_jnhw_OpaqueMemory_2II
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jobject opaqueMemory, jint off, jint nByte) {
        if (opaqueMemory == NULL) {
            throw_NullPointerException(env, "buf is null");
            return -1;
        }
        if (outOfBoundsOpaqueMemory(env, off, nByte, opaqueMemory)) {
            throw_ArrayIndexOutOfBoundsException(env, "");
            return -1;
        }
        //result can't be larger then int beacuase nByte is int, so do the conversation
        const ssize_t result = read(fd, UNWRAP_OPAQUE_MEM_TO_VOID_PTR(opaqueMemory) + off, (uint32_t) nByte);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return (int32_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    read
     * Signature: (ILde/ibapl/jnhw/ByteRef;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_read__ILde_ibapl_jnhw_ByteRef_2
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jobject byteRef) {
        jbyte _valueRef;
        //result can't be larger then int beacuase nByte is int, so do the conversation
        const int result = (int) read(fd, &_valueRef, 1);
        SET_BYTE_REF_VALUE(byteRef, _valueRef);
        if (result == -1) {
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
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jbyteArray buf, jint off, jint nByte) {
        if (buf == NULL) {
            throw_NullPointerException(env, "buf is null");
            return -1;
        }

        if (outOfBoundsByteArray(env, off, nByte, buf)) {
            throw_ArrayIndexOutOfBoundsException(env, "");
            return -1;
        }

        jbyte stackBuf[nByte > MAX_STACK_BUF_SIZE ? 0 : nByte];
        jbyte *_buf = NULL;
        if (nByte == 0) {
            return 0;
        } else if (nByte > MAX_STACK_BUF_SIZE) {
            _buf = malloc((uint32_t) nByte);
            if (_buf == NULL) {
                throw_Exception(env, OUT_OF_MEMORY_ERROR_CLASS_NAME, "Can`t aquire %d bytes of memory", nByte);
                return 0;
            }
        } else {
            _buf = stackBuf;
        }

        (*env)->GetByteArrayRegion(env, buf, off, nByte, _buf);
        if ((*env)->ExceptionOccurred(env)) {
            if (_buf != stackBuf) {
                free(_buf);
            }
            return -1;
        }
        //result can't be larger then int beacuase nByte is int, so do the conversation
        const ssize_t result = write(fd, _buf, (uint32_t) nByte);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        if (_buf != stackBuf) {
            free(_buf);
        }
        return (int32_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    write_ArgsOK
     * Signature: (ILjava/nio/ByteBuffer;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_write_1ArgsOK
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jobject byteBuffer, jint off, jint nByte) {
        //result can't be larger then int beacuase nByte is int, so do the conversation
        const ssize_t result = write(fd, (*env)->GetDirectBufferAddress(env, byteBuffer) + off, (uint32_t) nByte);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return (int32_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    write
     * Signature: (ILde/ibapl/jnhw/OpaqueMemory;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_write__ILde_ibapl_jnhw_OpaqueMemory_2II
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jobject buf, jint off, jint nByte) {
        if (buf == NULL) {
            throw_NullPointerException(env, "buf is null");
            return -1;
        }

        if (outOfBoundsOpaqueMemory(env, off, nByte, buf)) {
            throw_ArrayIndexOutOfBoundsException(env, "");
            return -1;
        }

        //result can't be larger then int beacuase nByte is int, so do the conversation
        const ssize_t result = write(fd, UNWRAP_OPAQUE_MEM_TO_VOID_PTR(buf) + off, (uint32_t) nByte);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return (int32_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    write
     * Signature: (IB)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_write__IB
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jbyte data) {
        const int result = (int) write(fd, &data, 1);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    usleep
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Unistd_usleep
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint usec) {
        if (usec == -1) {
            throw_IllegalArgumentException(env, "usec < 0");
            return;
        }
        if (usleep((uint32_t) usec)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    lseek
     * Signature: (III)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_lseek__III
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jint offset, jint whence) {
        const off_t result = lseek(fd, offset, whence);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return (int32_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    lseek
     * Signature: (IJI)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Unistd_lseek__IJI
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jlong offset, jint whence) {
#if __SIZEOF_LONG__ == 8
        const off_t result = lseek(fd, offset, whence);
#elif __SIZEOF_LONG__ == 4
        if ((offset > INT32_MAX) || (offset < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation offset is only an integer with the size of jint");
            return -1;
        }
        const off_t result = lseek(fd, (int32_t) offset, whence);
#endif
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
#ifdef _LARGEFILE64_SOURCE
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jlong offset, jint whence) {
        const off64_t result = lseek64(fd, offset, whence);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint fd, __attribute__ ((unused)) jlong offset, __attribute__ ((unused)) jint whence) {
        throw_NoSuchNativeMethodException(env, "lseek64");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    pipe
     * Signature: (Lde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/IntRef;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Unistd_pipe
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject read_fd_ref, jobject write_fd_ref) {
        if (read_fd_ref == NULL) {
            throw_NullPointerException(env, "read_fd_ref is null");
            return;
        }
        if (write_fd_ref == NULL) {
            throw_NullPointerException(env, "write_fd_ref is null");
            return;
        }
        int fdes[2];
        const int result = pipe(fdes);
        SET_INT_REF_VALUE(read_fd_ref, fdes[0]);
        SET_INT_REF_VALUE(write_fd_ref, fdes[1]);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    fsync
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Unistd_fsync
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd) {
        if (!fsync(fd)) {
            throw_NativeErrorException(env, errno);
        }
    }

        /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    getpid
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_getpid
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return getpid();
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    getppid
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_getppid
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return getppid();
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    getuid
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_getuid
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int) getuid();
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    geteuid
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_geteuid
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int) geteuid();
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    getgid
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_getgid
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int) getgid();
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    getpgrp
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_getpgrp
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int) getpgrp();
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    getegid
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_getegid
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int) getegid();
    }


#ifdef __cplusplus
}
#endif
#endif
