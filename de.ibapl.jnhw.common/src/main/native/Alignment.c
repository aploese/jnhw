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

//for offsetof
#include <stddef.h>

#include "de_ibapl_jnhw_common_memory_layout_Alignment.h"

#ifdef __cplusplus
extern "C" {
#endif

    struct s_int8_t {
        int8_t first;
    };

    struct s_int16_t {
        int8_t first;
        int16_t last;
    };

    struct s_int32_t {
        int8_t first;
        int32_t last;
    };

    struct s_int64_t {
        int8_t first;
        int64_t last;
    };

    struct s_intptr_t {
        int8_t first;
        intptr_t last;
    };

    struct s_void {
        int8_t first;
        void* last;
    };

    struct s_long {
        int8_t first;
        long last;
    };

#pragma pack(push)  /* push current alignment to stack */
#pragma pack(16)     /* set alignment to 16 byte boundary */

    struct align_16 {
        int8_t first;
        int64_t last;
    };

#pragma pack(pop)   /* restore original alignment from stack */

    /*
     * Class:     de_ibapl_jnhw_common_memory_layout_Alignment
     * Method:    getFromNative
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_memory_layout_Alignment_getFromNative
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jint req) {
        switch (req) {
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_INT8_T:
                return __alignof__ (int8_t);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_INT16_T:
                return __alignof__ (int16_t);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_INT32_T:
                return __alignof__ (int32_t);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_INT64_T:
                return __alignof__ (int64_t);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_INTPTR_T:
                return __alignof__ (intptr_t);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_POINTER:
                return __alignof__ (void*);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_LONG:
                return __alignof__ (long);

            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_INT8_T | de_ibapl_jnhw_common_memory_layout_Alignment_STRUCT_OFFSET:
                return __alignof__ (struct s_int8_t);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_INT16_T | de_ibapl_jnhw_common_memory_layout_Alignment_STRUCT_OFFSET:
                return __alignof__ (struct s_int16_t);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_INT32_T | de_ibapl_jnhw_common_memory_layout_Alignment_STRUCT_OFFSET:
                return __alignof__ (struct s_int32_t);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_INT64_T | de_ibapl_jnhw_common_memory_layout_Alignment_STRUCT_OFFSET:
                return __alignof__ (struct s_int64_t);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_INTPTR_T | de_ibapl_jnhw_common_memory_layout_Alignment_STRUCT_OFFSET:
                return __alignof__ (struct s_intptr_t);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_POINTER | de_ibapl_jnhw_common_memory_layout_Alignment_STRUCT_OFFSET:
                return __alignof__ (struct s_void);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_LONG | de_ibapl_jnhw_common_memory_layout_Alignment_STRUCT_OFFSET:
                return __alignof__ (struct s_long);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_INT16_T | de_ibapl_jnhw_common_memory_layout_Alignment_ALIGN_IN_STRUCT_OFFSET:
                return offsetof(struct s_int16_t, last);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_INT32_T | de_ibapl_jnhw_common_memory_layout_Alignment_ALIGN_IN_STRUCT_OFFSET:
                return offsetof(struct s_int32_t, last);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_INT64_T | de_ibapl_jnhw_common_memory_layout_Alignment_ALIGN_IN_STRUCT_OFFSET:
                return offsetof(struct s_int64_t, last);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_INTPTR_T | de_ibapl_jnhw_common_memory_layout_Alignment_ALIGN_IN_STRUCT_OFFSET:
                return offsetof(struct s_intptr_t, last);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_POINTER | de_ibapl_jnhw_common_memory_layout_Alignment_ALIGN_IN_STRUCT_OFFSET:
                return offsetof(struct s_void, last);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_LONG | de_ibapl_jnhw_common_memory_layout_Alignment_ALIGN_IN_STRUCT_OFFSET:
                return offsetof(struct s_long, last);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ___BIGGEST_ALIGNMENT__:
                return __BIGGEST_ALIGNMENT__;


            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_ALIGN_16 | de_ibapl_jnhw_common_memory_layout_Alignment_STRUCT_OFFSET:
                return __alignof__ (struct align_16);
            case de_ibapl_jnhw_common_memory_layout_Alignment_REQ_ALIGNOF_ALIGN_16 | de_ibapl_jnhw_common_memory_layout_Alignment_ALIGN_IN_STRUCT_OFFSET:
                return offsetof(struct align_16, last);


            default:
                throw_IllegalArgumentException(env, "Can't handle request");
                return -1;
        }
    }
#ifdef __cplusplus
}
#endif
