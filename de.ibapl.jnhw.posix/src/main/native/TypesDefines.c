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
#ifdef __cplusplus
extern "C" {
#endif

#include "jnhw-posix.h"
#include "de_ibapl_jnhw_posix_sys_Types.h"

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Types
     * Method:    HAVE_SYS_TYPES_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_sys_Types_HAVE_1SYS_1TYPES_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef HAVE_SYS_TYPES_H
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

#if HAVE_SYS_TYPES_H
#include <sys/types.h>
#endif

#ifdef __cplusplus
}
#endif