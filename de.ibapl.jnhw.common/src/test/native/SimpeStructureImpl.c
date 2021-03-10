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
        int64_t eighth;
    };

    /*
     * Class:     de_ibapl_jnhw_common_memory_layout_SimpeStructureImpl
     * Method:    getNativeDefinedLayout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/common/test/memory/layout/SimpeStructureImpl/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_common_test_memory_layout_SimpeStructureImpl_getNativeDefinedLayout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass structLayoutClass) {
        jobject result = JnhwCreateStructLayout(env, structLayoutClass, sizeof (struct SimpleStructure), __alignof__ (struct SimpleStructure));
        if (result == NULL) {
            return NULL;
        }
        if (JnhwSetLongField(env, result, "offsetFirst", offsetof(struct SimpleStructure, first))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "offsetSecond", offsetof(struct SimpleStructure, second))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "offsetThird", offsetof(struct SimpleStructure, third))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "offsetForth", offsetof(struct SimpleStructure, forth))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "offsetFifth", offsetof(struct SimpleStructure, fifth))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "offsetSixth", offsetof(struct SimpleStructure, sixth))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "offsetSeventh", offsetof(struct SimpleStructure, seventh))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "offsetEighth", offsetof(struct SimpleStructure, eighth))) {
            return result;
        }
        return result;
    }

#ifdef __cplusplus
}
#endif
