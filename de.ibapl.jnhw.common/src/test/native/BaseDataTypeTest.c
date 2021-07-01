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
#define _JNHW_COMMON_IMPLEMENTATION_ 1
#include "jnhw-common.h"

#include "de_ibapl_jnhw_common_test_datatypes_BaseDataTypeTest.h"

#ifdef __cplusplus
extern "C" {
#endif

    /* ON Win long is always int22_t
    #if __SIZEOF_POINTER__ != __SIZEOF_LONG__
    #error expected not to happen: __SIZEOF_POINTER__ != __SIZEOF_LONG__
    #endif
     */

    /*
     * Class:     de_ibapl_jnhw_common_test_datatypes_BaseDataTypeTest
     * Method:    getSizeOfPointer
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_test_datatypes_BaseDataTypeTest_getSizeOfPointer
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return sizeof (void*);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_datatypes_BaseDataTypeTest
     * Method:    getSizeOf_long
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_test_datatypes_BaseDataTypeTest_getSizeOf_1long
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return sizeof (long);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_datatypes_BaseDataTypeTest
     * Method:    getSizeOf_float
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_test_datatypes_BaseDataTypeTest_getSizeOf_1float
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return sizeof (float);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_datatypes_BaseDataTypeTest
     * Method:    getSizeOf_double
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_test_datatypes_BaseDataTypeTest_getSizeOf_1double
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return sizeof (double);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_datatypes_BaseDataTypeTest
     * Method:    getSizeOf_long_double
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_test_datatypes_BaseDataTypeTest_getSizeOf_1long_1double
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return sizeof (long double);
    }


#ifdef __cplusplus
}
#endif
