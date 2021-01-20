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

#ifdef HAVE_SYS_EVENTFD_H

#include "de_ibapl_jnhw_linux_sys_Eventfd.h"
#include <sys/eventfd.h>
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_linux_sys_Eventfd
     * Method:    eventfd
     * Signature: (II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_linux_sys_Eventfd_eventfd
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint count, jint flags) {
        if (count < 0) {
            throw_IllegalArgumentException(env, "count must be >= 0");
            return -1;
        }
        const int result = eventfd((uint32_t) count, flags);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_linux_sys_Eventfd
     * Method:    eventfd_read
     * Signature: (IJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_linux_sys_Eventfd_eventfd_1read
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jobject valueRef) {
        eventfd_t _valueRef = (uint64_t) GET_LONG_REF_VALUE(valueRef);
        const int result = eventfd_read(fd, &_valueRef);
        SET_LONG_REF_VALUE(valueRef, (int64_t) _valueRef);
        if (result) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_linux_sys_Eventfd
     * Method:    eventfd_write
     * Signature: (IJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_linux_sys_Eventfd_eventfd_1write
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jlong value) {
        if (eventfd_write(fd, (uint64_t) value)) {
            throw_NativeErrorException(env, errno);
        }
    }

#ifdef __cplusplus
}
#endif
#endif