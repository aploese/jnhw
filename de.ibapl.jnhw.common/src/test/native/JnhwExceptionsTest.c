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
#include "jnhw-common.h"
#include "de_ibapl_jnhw_JnhwExceptionsTest.h"

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_JnhwExceptionsTest
     * Method:    throwNativeErrorException
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_JnhwExceptionsTest_throwNativeErrorException
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jint errorNumber) {
        throw_NativeErrorException(env, errorNumber);
    }

    /*
     * Class:     de_ibapl_jnhw_JnhwExceptionsTest
     * Method:    throwNotDefinedException
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_JnhwExceptionsTest_throwNotDefinedException
    (JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        throw_NotDefinedException(env, "TEST_DEFINE");
    }

    /*
     * Class:     de_ibapl_jnhw_JnhwExceptionsTest
     * Method:    throwNoSuchNativeMethodException
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_JnhwExceptionsTest_throwNoSuchNativeMethodException
    (JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        throw_NoSuchNativeMethodException(env, "a_native_method");
    }

    /*
     * Class:     de_ibapl_jnhw_JnhwExceptionsTest
     * Method:    throwNoSuchTypeMemberException
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_JnhwExceptionsTest_throwNoSuchTypeMemberException
    (JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        throw_NoSuchTypeMemberException(env, "a_type", "a_member");
    }

    /*
     * Class:     de_ibapl_jnhw_JnhwExceptionsTest
     * Method:    throwNullPointerException
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_JnhwExceptionsTest_throwNullPointerException
    (JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        throw_NullPointerException(env, "arg0");
    }

    /*
     * Class:     de_ibapl_jnhw_JnhwExceptionsTest
     * Method:    throwArrayIndexOutOfBoundsException
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_JnhwExceptionsTest_throwArrayIndexOutOfBoundsException
    (JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        throw_ArrayIndexOutOfBoundsException(env, "arg_array_index");
    }

    /*
     * Class:     de_ibapl_jnhw_JnhwExceptionsTest
     * Method:    throwIndexOutOfBoundsException
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_JnhwExceptionsTest_throwIndexOutOfBoundsException
    (JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        throw_IndexOutOfBoundsException(env, "arg_index");
    }

    /*
     * Class:     de_ibapl_jnhw_JnhwExceptionsTest
     * Method:    throwIllegalArgumentException
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_JnhwExceptionsTest_throwIllegalArgumentException
    (JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        throw_IllegalArgumentException(env, "arg_illegal");
    }

    /*
     * Class:     de_ibapl_jnhw_JnhwExceptionsTest
     * Method:    throwException
     * Signature: (Ljava/lang/String;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_JnhwExceptionsTest_throwException
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jstring className) {
        const char* _className = (*env)->GetStringUTFChars(env, className, NULL);
        throw_Exception(env, _className, "rte %d", 42);
        (*env)->ReleaseStringUTFChars(env, className, _className);
    }


#ifdef __cplusplus
}
#endif