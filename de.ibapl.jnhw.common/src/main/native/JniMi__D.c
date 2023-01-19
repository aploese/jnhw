/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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
#include "jnhw-common.h"
#include "de_ibapl_jnhw_common_downcall_jni_JniMi__D___I__I.h"
#include "de_ibapl_jnhw_common_downcall_jni_JniMi__D___L__L.h"

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_common_downcall_jni_JniMi__D___I__I
 * Method:    invoke__D___I__I
 * Signature: (JII)D
 */
JNIEXPORT double JNICALL Java_de_ibapl_jnhw_common_downcall_jni_JniMi_1_1D_1_1_1I_1_1I_invoke_1_1D_1_1_1I_1_1I
  (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong address, jint arg1, jint arg2) {
    return ((double (*)(int32_t, int32_t))(intptr_t)address)(arg1, arg2);
}

/*
 * Class:     de_ibapl_jnhw_common_downcall_jni_JniMi__D___L__L
 * Method:    invoke__D___L__L
 * Signature: (JJJ)D
 */
JNIEXPORT double JNICALL Java_de_ibapl_jnhw_common_downcall_jni_JniMi_1_1D_1_1_1L_1_1L_invoke_1_1D_1_1_1L_1_1L
  (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong address, jlong arg1, jlong arg2) {
    return ((double (*)(int64_t, int64_t))(intptr_t)address)(arg1, arg2);
}

#ifdef __cplusplus
}
#endif