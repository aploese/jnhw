/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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

#include "de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment.h"
#include <stdlib.h>
//for offsetof
#include <stddef.h>


#ifdef __cplusplus
extern "C" {
#endif

struct s_i8 {
    int8_t _0_i8;
};

struct s_3xi8 {
    int8_t _0_i8;
    int8_t _1_i8;
    int8_t _2_i8;
};

struct s_2xsi8 {
    struct s_i8 _0_si8;
    struct s_i8 _1_si8;
};

struct s_si8_s3xi8 {
    struct s_i8 _0_si8;
    struct s_3xi8 _1_s3xi8;
};

struct s_s3xi8_si8 {
    struct s_3xi8 _0_s3xi8;
    struct s_i8 _1_si8;
};

struct s_i8_i16 {
    int8_t _0_i8;
    int16_t _1_i16;
};

struct s_i8_i32 {
    int8_t _0_i8;
    int32_t _1_i32;
};

struct s_i8_i64 {
    int8_t _0_i8;
    int64_t _1_i64;
};

struct s_i16_i8 {
    int16_t _0_i16;
    int8_t _1_i8;
};

struct s_i32_i8 {
    int32_t _0_i32;
    int8_t _1_i8;
};

struct s_i64_i8 {
    int64_t _0_i64;
    int8_t _1_i8;
};


/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    sizeOfS_i8
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_sizeOfS_1i8
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return sizeof(struct s_i8);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    sizeOfS_s2xi8
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_sizeOfS_1s2xi8
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return sizeof(struct s_2xsi8);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    sizeOfS_3xi8
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_sizeOfS_13xi8
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return sizeof(struct s_3xi8);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    sizeOfS_si8_s3xi8
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_sizeOfS_1si8_1s3xi8
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return sizeof(struct s_si8_s3xi8);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    sizeOfS_s3xi8_si8
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_sizeOfS_1s3xi8_1si8
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return sizeof(struct s_s3xi8_si8);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    sizeOfS_i8_i16
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_sizeOfS_1i8_1i16
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return sizeof(struct s_i8_i16);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    sizeOfS_i8_i32
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_sizeOfS_1i8_1i32
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return sizeof(struct s_i8_i32);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    sizeOfS_i8_i64
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_sizeOfS_1i8_1i64
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return sizeof(struct s_i8_i64);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    sizeOfS_i16_i8
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_sizeOfS_1i16_1i8
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return sizeof(struct s_i16_i8);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    sizeOfS_i32_i8
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_sizeOfS_1i32_1i8
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return sizeof(struct s_i32_i8);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    sizeOfS_i64_i8
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_sizeOfS_1i64_1i8
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return sizeof(struct s_i64_i8);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    offsetOfS_s2xi8__1_si8
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_offsetOfS_1s2xi8_1_11_1si8
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return offsetof(struct s_2xsi8, _1_si8);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    offsetOfS_si8_s3xi8__1_s3xi8
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_offsetOfS_1si8_1s3xi8_1_11_1s3xi8
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return offsetof(struct s_si8_s3xi8, _1_s3xi8);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    offsetOfS_s3xi8_si8__1_si8
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_offsetOfS_1s3xi8_1si8_1_11_1si8
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return offsetof(struct s_s3xi8_si8, _1_si8);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    offsetOfS_i8_i16__1_i16
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_offsetOfS_1i8_1i16_1_11_1i16
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return offsetof(struct s_i8_i16, _1_i16);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    offsetOfS_i8_i32__1_i32
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_offsetOfS_1i8_1i32_1_11_1i32
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return offsetof(struct s_i8_i32, _1_i32);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    offsetOfS_i8_i64__1_i64
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_offsetOfS_1i8_1i64_1_11_1i64
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return offsetof(struct s_i8_i64, _1_i64);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    offsetOfS_i16_i8__1_i8
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_offsetOfS_1i16_1i8_1_11_1i8
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return offsetof(struct s_i16_i8, _1_i8);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    offsetOfS_i32_i8__1_i8
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_offsetOfS_1i32_1i8_1_11_1i8
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return offsetof(struct s_i32_i8, _1_i8);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    offsetOfS_i64_i8__1_i8
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_offsetOfS_1i64_1i8_1_11_1i8
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return offsetof(struct s_i64_i8, _1_i8);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    allignOfI8
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_allignOfI8
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return __alignof__(int8_t);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    allignOfI16
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_allignOfI16
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return __alignof__(int16_t);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    allignOfI32
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_allignOfI32
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return __alignof__(int32_t);
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory_NativeMemoryAlignment
 * Method:    allignOfI64
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_00024NativeMemoryAlignment_allignOfI64
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return __alignof__(int64_t);
    }


#ifdef __cplusplus
}
#endif