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
#include "de_ibapl_jnhw_common_downcall_jni_JniMi__L___A.h"
#include "de_ibapl_jnhw_common_downcall_jni_JniMi__L___I.h"
#include "de_ibapl_jnhw_common_downcall_jni_JniMi__L___I__A__L.h"
#include "de_ibapl_jnhw_common_downcall_jni_JniMi__L___I__L__I.h"
#include "de_ibapl_jnhw_common_downcall_jni_JniMi__L___V.h"


#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_common_downcall_jni_JniMi__L___A
 * Method:    invoke__L___A
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_downcall_jni_JniMi_1_1L_1_1_1A_invoke_1_1L_1_1_1A
  (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong address, jlong arg1) {
    return ((int64_t (*)(intptr_t))(intptr_t)address)((intptr_t)arg1);
}

/*
 * Class:     de_ibapl_jnhw_common_downcall_jni_JniMi__L___I
 * Method:    invoke__L___I
 * Signature: (JI)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_downcall_jni_JniMi_1_1L_1_1_1I_invoke_1_1L_1_1_1I
  (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong address, jint arg1) {
    return ((int64_t (*)(int32_t))(intptr_t)address)(arg1);
}

/*
 * Class:     de_ibapl_jnhw_common_downcall_jni_JniMi__L___I__A__L
 * Method:    invoke__L___I__A__L
 * Signature: (JIJJ)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_downcall_jni_JniMi_1_1L_1_1_1I_1_1A_1_1L_invoke_1_1L_1_1_1I_1_1A_1_1L
  (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong address, jint arg1, jlong arg2, jlong arg3) {
    return ((int64_t (*)(int32_t, intptr_t, int64_t))(intptr_t)address)(arg1, (intptr_t)arg2, arg3);
}

/*
 * Class:     de_ibapl_jnhw_common_downcall_jni_JniMi__L___I__L__I
 * Method:    invoke__L___I__L__I
 * Signature: (JIJI)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_downcall_jni_JniMi_1_1L_1_1_1I_1_1L_1_1I_invoke_1_1L_1_1_1I_1_1L_1_1I
  (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong address, jint arg1, jlong arg2, jint arg3) {
    return ((int64_t (*)(int32_t, int64_t, int32_t))(intptr_t)address)(arg1, arg2, arg3);
}

/*
 * Class:     de_ibapl_jnhw_common_downcall_jni_JniMi__L___V
 * Method:    invoke__L___V
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_downcall_jni_JniMi_1_1L_1_1_1V_invoke_1_1L_1_1_1V
  (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong address) {
    return ((int64_t (*)())(intptr_t)address)();
}

#ifdef __cplusplus
}
#endif