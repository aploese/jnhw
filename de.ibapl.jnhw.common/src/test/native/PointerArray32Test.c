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
#include "de_ibapl_jnhw_common_test_memory_PointerArray32Test.h"

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_common_test_memory_PointerArray32Test
 * Method:    getCachedReferencesLength
 * Signature: (Lde/ibapl/jnhw/common/memory/PointerArray32;)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_test_memory_PointerArray32Test_getCachedReferencesLength
  (JNIEnv *env, __attribute__ ((unused))jclass clazz, jobject pointerArray) {
    if (de_ibapl_jnhw_common_memory_PointerArray32_cachedReferences_ID == NULL) {
        throw_Exception(env, RUNTIME_EXCEPTION_CLASS_NAME, "de_ibapl_jnhw_common_memory_PointerArray32_cachedReferences_ID is NULL!");
        return -1;
    }
    return LENGTH_OF_POINTER_ARRAY_32(pointerArray);
}

#ifdef __cplusplus
}
#endif
