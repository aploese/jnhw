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

#include "de_ibapl_jnhw_PointerArray32.h"

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_PointerArray32
 * Method:    get0
 * Signature: (I)Lde/ibapl/jnhw/NativeAddressHolder;
 */
JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_PointerArray32_get0
    (JNIEnv *env, jobject pointerArray, jint index) {
        return CREATE_NATIVE_ADDRESS_HOLDER((intptr_t)*(UNWRAP_OPAQUE_MEM_TO_VOID_PTR_PTR(pointerArray) + index));
    }

    /*
     * Class:     de_ibapl_jnhw_PointerArray32
     * Method:    set0
     * Signature: (ILde/ibapl/jnhw/OpaqueMemory;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_PointerArray32_set0
    (JNIEnv *env, jobject pointerArray, jint index, jobject opaqueMemory) {
        *(UNWRAP_OPAQUE_MEM_TO_VOID_PTR_PTR(pointerArray) + index) = UNWRAP_OPAQUE_MEM_TO_VOID_PTR(opaqueMemory);
    }

    /*
     * Class:     de_ibapl_jnhw_PointerArray32
     * Method:    sizeofPointer
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_PointerArray32_sizeofPointer
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return sizeof (void*);
    }

#ifdef __cplusplus
}
#endif