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
#include "jnhw.h"
/*
 * Class:     de_ibapl_jnhw_isoc_Errno
 * Method:    HAVE_ERRNO_H
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_isoc_Errno_HAVE_1ERRNO_1H
    (JNIEnv *env, jclass clazz) {
#ifdef HAVE_ERRNO_H
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }


#ifdef HAVE_ERRNO_H

#include "de_ibapl_jnhw_isoc_Errno.h"
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_isoc_Errno
     * Method:    EDOM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_isoc_Errno_EDOM
    (JNIEnv *env, jclass clazz) {
        return EDOM;
    }

    /*
     * Class:     de_ibapl_jnhw_isoc_Errno
     * Method:    ERANGE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_isoc_Errno_ERANGE
    (JNIEnv *env, jclass clazz) {
        return ERANGE;
    }

    /*
     * Class:     de_ibapl_jnhw_isoc_Errno
     * Method:    EILSEQ
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_isoc_Errno_EILSEQ
    (JNIEnv *env, jclass clazz) {
        return EILSEQ;
    }

#ifdef __cplusplus
}
#endif
#endif