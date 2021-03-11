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
#include "jnhw-common.h"
#include "de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest.h"
//for offsetof
#include <stddef.h>

#ifdef __cplusplus
extern "C" {
#endif

    struct EmptyStruct {
    };

    struct Struct_Int8_t {
        int8_t first;
    };

    struct Struct_Int16_t {
        int16_t first;
    };

    struct Struct_Int32_t {
        int32_t first;
    };

    struct Struct_Int64_t {
        int64_t first;
    };

        /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest
     * Method:    getAlignOfEmptyStruct
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest_getAlignOfEmptyStruct
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct EmptyStruct);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest
     * Method:    getAlignOfStruct_Int8_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest_getAlignOfStruct_1Int8_1t
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct Struct_Int8_t);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest
     * Method:    getAlignOfStruct_Int16_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest_getAlignOfStruct_1Int16_1t
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct Struct_Int16_t);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest
     * Method:    getAlignOfStruct_Int32_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest_getAlignOfStruct_1Int32_1t
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct Struct_Int32_t);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest
     * Method:    getAlignOfStruct_Int64_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest_getAlignOfStruct_1Int64_1t
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct Struct_Int64_t);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest
     * Method:    getAlignOf_Int8_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest_getAlignOf_1Int8_1t
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (int8_t);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest
     * Method:    getAlignOf_Int16_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest_getAlignOf_1Int16_1t
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (int16_t);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest
     * Method:    getAlignOf_Int32_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest_getAlignOf_1Int32_1t
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (int32_t);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest
     * Method:    getAlignOf_Int64_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_StructLayoutTest_getAlignOf_1Int64_1t
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (int64_t);
    }

#ifdef __cplusplus
}
#endif
