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

#ifdef HAVE_SYS_IOCTL_H

#include "de_ibapl_jnhw_unix_sys_Ioctl.h"
#include <sys/ioctl.h>
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    ioctl
     * Signature: (IJ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_ioctl__IJ
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jlong request) {
        int result = ioctl(fd, (uint64_t)request);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    ioctl
     * Signature: (IJLde/ibapl/jnhw/IntRef;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_ioctl__IJLde_ibapl_jnhw_IntRef_2
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint fd, jlong request, jobject intRef) {

        int _intRef = GET_INT_REF_VALUE(intRef);

        int result = ioctl(fd, (uint64_t)request, &_intRef);
        SET_INT_REF_VALUE(intRef, _intRef);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

#ifdef __cplusplus
}
#endif
#endif