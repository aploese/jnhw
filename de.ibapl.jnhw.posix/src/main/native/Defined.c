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
#include "de_ibapl_jnhw_util_posix_Defined.h"

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_util_posix_Defined
 * Method:    __linux__
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_Defined__1_1linux_1_1
  (JNIEnv *env, jclass clazz) {
#ifdef __linux__
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}

/*
 * Class:     de_ibapl_jnhw_util_posix_Defined
 * Method:    __APPLE__
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_Defined__1_1APPLE_1_1
  (JNIEnv *env, jclass clazz) {
#ifdef __APPLE__
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}

/*
 * Class:     de_ibapl_jnhw_util_posix_Defined
 * Method:    __FreeBSD__
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_util_posix_Defined__1_1FreeBSD_1_1
  (JNIEnv *env, jclass clazz) {
#ifdef __FreeBSD__
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}
    
    
#ifdef __cplusplus
}
#endif