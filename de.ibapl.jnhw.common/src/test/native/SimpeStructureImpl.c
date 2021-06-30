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
#include "de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl.h"
//for offsetof
#include <stddef.h>

#ifdef __cplusplus
extern "C" {
#endif

    struct SimpleStructure {
        int8_t first;
        int16_t second;
        int8_t third;
        int32_t forth;
        int8_t fifth;
        int64_t sixth;
        int8_t seventh;
        int64_t eigth;
    };

        /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl
     * Method:    offsetFirst
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl_offsetFirst
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct SimpleStructure, first);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl
     * Method:    offsetSecond
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl_offsetSecond
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct SimpleStructure, second);

    }

    /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl
     * Method:    offsetThird
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl_offsetThird
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct SimpleStructure, third);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl
     * Method:    offsetForth
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl_offsetForth
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct SimpleStructure, forth);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl
     * Method:    offsetFifth
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl_offsetFifth
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct SimpleStructure, fifth);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl
     * Method:    offsetSixth
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl_offsetSixth
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct SimpleStructure, sixth);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl
     * Method:    offsetSeventh
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl_offsetSeventh
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct SimpleStructure, seventh);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl
     * Method:    offsetEigth
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl_offsetEigth
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct SimpleStructure, eigth);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct SimpleStructure);
    }

    /*
     * Class:     de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct SimpleStructure);

    }

#ifdef __cplusplus
}
#endif
