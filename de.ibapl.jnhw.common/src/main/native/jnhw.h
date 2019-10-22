/**
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
#ifndef _ljnhw_H
#define _ljnhw_H


#define _GNU_SOURCE

#define _LARGEFILE64_SOURCE

#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _JNHW_COMMON_IMPLEMENTATION_
#define _JNHW_IMPORT_OR_EXPORT_ JNIEXPORT
#else
#define _JNHW_IMPORT_OR_EXPORT_ JNIIMPORT
#endif   

    /**
     * Init exceptions and Refs
     * @returns JNI_TRUE if all is OK therwise JNI_FALSE if an exception occures
     * 
     */ 
    _JNHW_IMPORT_OR_EXPORT_ extern JNICALL jboolean jnhw_common_init(JNIEnv *env);

    //Exception names

#define NATIVE_ERROR_EXCEPTION "de/ibapl/jnhw/NativeErrorException"
#define NOT_DEFINED_EXCEPTION "de/ibapl/jnhw/NotDefinedException"
#define NULL_POINTER_EXCEPTION "java/lang/NullPointerException"
#define ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION "java/lang/ArrayIndexOutOfBoundsException"
#define INDEX_OUT_OF_BOUNDS_EXCEPTION "java/lang/IndexOutOfBoundsException"

    //Important class names
#define JNHW_CLASS_NAME_BYTE_REF "de/ibapl/jnhw/ByteRef"
#define JNHW_CLASS_NAME_SHORT_REF "de/ibapl/jnhw/ShortRef"
#define JNHW_CLASS_NAME_INT_REF "de/ibapl/jnhw/IntRef"
#define JNHW_CLASS_NAME_LONG_REF "de/ibapl/jnhw/LongRef"
#define JNHW_CLASS_NAME_OPAQUE_MEMORY "de/ibapl/jnhw/OpaqueMemory"
#define JNHW_CLASS_NAME_STRUCT_ARRAY "de/ibapl/jnhw/StructArray"

    //Cached
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_ByteRef_value_ID;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_ShortRef_value_ID;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_IntRef_value_ID;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_LongRef_value_ID;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_OpaqueMemory_baseAddress_ID;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_OpaqueMemory_sizeInBytes_ID;
    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID de_ibapl_jnhw_StructArray_length_ID;

    //Cached Exceptions
    _JNHW_IMPORT_OR_EXPORT_ extern void JNICALL throw_NativeErrorException(JNIEnv* env, int errno);

    _JNHW_IMPORT_OR_EXPORT_ extern void JNICALL throw_NotDefinedException(JNIEnv* env, const char* defineName);

    _JNHW_IMPORT_OR_EXPORT_ extern void JNICALL throw_NullPointerException(JNIEnv* env, const char* message);

    _JNHW_IMPORT_OR_EXPORT_ extern void JNICALL throw_ArrayIndexOutOfBoundsException(JNIEnv* env, const char* message);

    _JNHW_IMPORT_OR_EXPORT_ extern void JNICALL throw_IndexOutOfBoundsException(JNIEnv* env, const char* message);

    _JNHW_IMPORT_OR_EXPORT_ extern void JNICALL throwException(JNIEnv* env, const char* exceptionName, const char* fmt, ...);



    _JNHW_IMPORT_OR_EXPORT_ extern jclass JNICALL getGlobalClassRef(JNIEnv *env, const char* className);

    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID JNICALL getFieldId(JNIEnv *env, const char* className, const char* fieldName, const char* fieldType);

    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID JNICALL getMethodId(JNIEnv *env, const char* className, const char* methodName, const char* methodSignature);

    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID JNICALL getFieldIdOfClassRef(JNIEnv *env, jclass clazz, const char* fieldName, const char* fieldType);

    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID JNICALL getMethodIdOfClassRef(JNIEnv *env, jclass clazz, const char* methodName, const char* methodSignature);

    /*
     * Returns true if the array slice defined by the given offset and length
     * is out of bounds.
     */
    _JNHW_IMPORT_OR_EXPORT_ extern int outOfBoundsByteArray(JNIEnv *env, jint pos, jint len, jbyteArray array);

    _JNHW_IMPORT_OR_EXPORT_ extern int outOfBoundsOpaqueMemory(JNIEnv *env, jint pos, jint len, jobject opaqueMemory);



    /**
     * Unwarap the baseAddress of given opaqueMemory(jobject) of an OpacqueMemory instance anc casts these baseAddress to given type.
     * 
     */
#define UNWRAP_OPAQUE_MEM_TO_UINTPTR_T(opaqueMemory) (uintptr_t)(*env)->GetLongField(env, opaqueMemory, de_ibapl_jnhw_OpaqueMemory_baseAddress_ID)
    /**
     * Unwarap the baseAddress of given opaqueMemory(jobject) of an OpacqueMemory instance anc casts these baseAddress to given type and put it in ().
     * 
     */
#define UNWRAP_OPAQUE_MEM_TO(destType, opaqueMemory) (destType) UNWRAP_OPAQUE_MEM_TO_UINTPTR_T(opaqueMemory)
    /**
     * Unwarap the baseAddress given opaqueMemory(jobject) of an OpacqueMemory instance anc casts these baseAddress to given type.
     * If opaqueMemory == NULL return NULL, otherwise unwrap.
     * 
     */
#define UNWRAP_OPAQUE_MEM_TO_OR_NULL(destType, opaqueMemory) opaqueMemory == NULL ? NULL : (destType) UNWRAP_OPAQUE_MEM_TO_UINTPTR_T(opaqueMemory)
#define UNWRAP_OPAQUE_MEM_TO_VOID_PTR(opaqueMemory) UNWRAP_OPAQUE_MEM_TO(void*, opaqueMemory)

#define SIZE_OF_OPAQUE_MEM(opaqueMem) (*env)->GetIntField(env, opaqueMem, de_ibapl_jnhw_OpaqueMemory_sizeInBytes_ID)

#define LENGTH_OF_STRUCTURE_ARRAY(structureArray) (*env)->CallIntMethod(env, structureArray, de_ibapl_jnhw_StructArray_length_ID)

#define GET_BYTE_REF_VALUE(valueRef) (*env)->GetByteField(env, valueRef, de_ibapl_jnhw_ByteRef_value_ID)
#define SET_BYTE_REF_VALUE(valueRef, value) (*env)->SetByteField(env, valueRef, de_ibapl_jnhw_ByteRef_value_ID, value)

#define GET_SHORT_REF_VALUE(valueRef) (*env)->GetShortField(env, valueRef, de_ibapl_jnhw_ShortRef_value_ID)
#define SET_SHORT_REF_VALUE(valueRef, value) (*env)->SetShortField(env, valueRef, de_ibapl_jnhw_ShortRef_value_ID, value)

#define GET_INT_REF_VALUE(valueRef) (*env)->GetIntField(env, valueRef, de_ibapl_jnhw_IntRef_value_ID)
#define SET_INT_REF_VALUE(valueRef, value) (*env)->SetIntField(env, valueRef, de_ibapl_jnhw_IntRef_value_ID, value)

#define GET_LONG_REF_VALUE(valueRef) (*env)->GetLongField(env, valueRef, de_ibapl_jnhw_LongRef_value_ID)
#define SET_LONG_REF_VALUE(valueRef, value) (*env)->SetLongField(env, valueRef, de_ibapl_jnhw_LongRef_value_ID, value)


#ifdef __cplusplus
}
#endif

#endif
