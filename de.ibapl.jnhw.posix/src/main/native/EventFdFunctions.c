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
    (JNIEnv *env, jclass clazz, jint count, jint flags) {
        int result = eventfd(count, flags);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_linux_sys_Eventfd
     * Method:    eventfd_read
     * Signature: (IJ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_linux_sys_Eventfd_eventfd_1read
    (JNIEnv *env, jclass clazz, jint fd, jobject valueRef) {
        eventfd_t _valueRef = GET_LONG_REF_VALUE(valueRef);
        int result = eventfd_read(fd, &_valueRef);
        SET_LONG_REF_VALUE(valueRef, _valueRef);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_linux_sys_Eventfd
     * Method:    eventfd_write
     * Signature: (IJ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_linux_sys_Eventfd_eventfd_1write
    (JNIEnv *env, jclass clazz, jint fd, jlong value) {
        int result = eventfd_write(fd, value);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

#ifdef __cplusplus
}
#endif
#endif