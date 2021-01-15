/**
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
#ifndef _ljnhw_common_H
#define _ljnhw_common_H

#include <stdint.h>

#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _JNHW_COMMON_IMPLEMENTATION_
#define _JNHW_IMPORT_OR_EXPORT_ JNIEXPORT

#include "../../../config.h"

#else
#define _JNHW_IMPORT_OR_EXPORT_ JNIIMPORT
#endif   

#include "JnhwExceptions.h"

//globally important class names
#define JNHW_CLASS_NAME_NATIVE_ADDRESS_HOLDER "de/ibapl/jnhw/common/memory/NativeAddressHolder"
    
    //Cached
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_common_references_ByteRef_value_ID;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_common_references_ShortRef_value_ID;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_common_references_IntRef_value_ID;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_common_references_LongRef_value_ID;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_common_references_ObjectRef_value_ID;
    
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_common_memory_AbstractNativeMemory_baseAddress_ID;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_common_memory_OpaqueMemory32_sizeInBytes_ID;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_common_memory_OpaqueMemory64_sizeInBytes_ID;
    
    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID de_ibapl_jnhw_common_memory_StructArray32_length_ID;
    
    _JNHW_IMPORT_OR_EXPORT_ extern jclass de_ibapl_jnhw_common_memory_NativeAddressHolder_Class;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_common_memory_NativeAddressHolder_address_ID;
    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID de_ibapl_jnhw_common_memory_NativeAddressHolder_init_ID;
    
    //TODO deprecated ...
    _JNHW_IMPORT_OR_EXPORT_ extern jclass de_ibapl_jnhw_common_memory_NativeFunctionPointer_Class;
    //TODO deprecated ...
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_common_memory_NativeFunctionPointer_nativeAddress_ID;
    //TODO deprecated ...
    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID de_ibapl_jnhw_common_memory_NativeFunctionPointer_init_ID;
    
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID de_ibapl_jnhw_common_memory_PointerArray32_cachedReferences_ID;

    _JNHW_IMPORT_OR_EXPORT_ extern jclass JNICALL getGlobalClassRef(JNIEnv *env, const char* className);
    
    _JNHW_IMPORT_OR_EXPORT_ extern void JNICALL deleteGlobalRef(JNIEnv *env, jobject *classRef);

    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID JNICALL getFieldId(JNIEnv *env, const char* className, const char* fieldName, const char* fieldType);

    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID JNICALL getMethodId(JNIEnv *env, const char* className, const char* methodName, const char* methodSignature);

    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID JNICALL getFieldIdOfClassRef(JNIEnv *env, jclass clazz, const char* fieldName, const char* fieldType);

    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID JNICALL getMethodIdOfClassRef(JNIEnv *env, jclass clazz, const char* methodName, const char* methodSignature);

    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID JNICALL getStaticMethodIdOfClassRef(JNIEnv *env, jclass clazz, const char* methodName, const char* methodSignature);
    /*
     * Returns true if the array slice defined by the given offset and length
     * is out of bounds.
     */
    _JNHW_IMPORT_OR_EXPORT_ extern int outOfBoundsByteArray(JNIEnv *env, jint pos, jint len, jbyteArray array);

    _JNHW_IMPORT_OR_EXPORT_ extern int outOfBoundsOpaqueMemory32(JNIEnv *env, jint pos, jint len, jobject opaqueMemory32);
    _JNHW_IMPORT_OR_EXPORT_ extern int outOfBoundsOpaqueMemory64(JNIEnv *env, jlong pos, jlong len, jobject opaqueMemory64);



    /**
     * Unwarap the baseAddress of given opaqueMemory(jobject) of an OpaqueMemory instance and cast these baseAddress to given type and put it in ().
     * Using GetIntField for 32bit addresses will fail on BIG_ENDIAN...
     * 
     */
#define UNWRAP_OPAQUE_MEM_TO(destType, opaqueMemory) ((destType)((intptr_t)(*env)->GetLongField(env, opaqueMemory, de_ibapl_jnhw_common_memory_AbstractNativeMemory_baseAddress_ID)))

    /**
     * Unwarap the baseAddress given opaqueMemory(jobject) of an OpaqueMemory instance and cast these baseAddress to given type.
     * If opaqueMemory == NULL return NULL, otherwise unwrap.
     * 
     */
#define UNWRAP_OPAQUE_MEM_TO_OR_NULL(destType, opaqueMemory) opaqueMemory == NULL ? (destType)NULL : UNWRAP_OPAQUE_MEM_TO(destType, opaqueMemory)

#define UNWRAP_OPAQUE_MEM_TO_VOID_PTR(opaqueMemory) UNWRAP_OPAQUE_MEM_TO(void*, opaqueMemory)
#define UNWRAP_OPAQUE_MEM_TO_VOID_PTR_OR_NULL(opaqueMemory) UNWRAP_OPAQUE_MEM_TO_OR_NULL(void*, opaqueMemory)
#define UNWRAP_OPAQUE_MEM_TO_VOID_PTR_PTR(opaqueMemory) UNWRAP_OPAQUE_MEM_TO(void**, opaqueMemory)

#define SIZE_OF_OPAQUE_MEM_32(opaqueMem) (*env)->GetIntField(env, opaqueMem, de_ibapl_jnhw_common_memory_OpaqueMemory32_sizeInBytes_ID)
#define SIZE_OF_OPAQUE_MEM_64(opaqueMem) (*env)->GetLongField(env, opaqueMem, de_ibapl_jnhw_common_memory_OpaqueMemory64_sizeInBytes_ID)

#define LENGTH_OF_STRUCTURE_ARRAY_32(structureArray) (int32_t)(*env)->CallIntMethod(env, structureArray, de_ibapl_jnhw_common_memory_StructArray32_length_ID)

#define LENGTH_OF_POINTER_ARRAY_32(pointerArray) (*env)->GetArrayLength(env, (*env)->GetObjectField(env, pointerArray, de_ibapl_jnhw_common_memory_PointerArray32_cachedReferences_ID))

#define GET_BYTE_REF_VALUE(valueRef) (*env)->GetByteField(env, valueRef, de_ibapl_jnhw_common_references_ByteRef_value_ID)
#define SET_BYTE_REF_VALUE(valueRef, value) (*env)->SetByteField(env, valueRef, de_ibapl_jnhw_common_references_ByteRef_value_ID, value)

#define GET_SHORT_REF_VALUE(valueRef) (*env)->GetShortField(env, valueRef, de_ibapl_jnhw_common_references_ShortRef_value_ID)
#define SET_SHORT_REF_VALUE(valueRef, value) (*env)->SetShortField(env, valueRef, de_ibapl_jnhw_common_references_ShortRef_value_ID, value)

#define GET_INT_REF_VALUE(valueRef) (*env)->GetIntField(env, valueRef, de_ibapl_jnhw_common_references_IntRef_value_ID)
#define SET_INT_REF_VALUE(valueRef, value) (*env)->SetIntField(env, valueRef, de_ibapl_jnhw_common_references_IntRef_value_ID, value)

#define GET_LONG_REF_VALUE(valueRef) (*env)->GetLongField(env, valueRef, de_ibapl_jnhw_common_references_LongRef_value_ID)
#define SET_LONG_REF_VALUE(valueRef, value) (*env)->SetLongField(env, valueRef, de_ibapl_jnhw_common_references_LongRef_value_ID, value)

#define GET_OBJECT_REF_VALUE(valueRef) (*env)->GetObjectField(env, valueRef, de_ibapl_jnhw_common_references_ObjectRef_value_ID)
#define SET_OBJECT_REF_VALUE(valueRef, value) (*env)->SetObjectField(env, valueRef, de_ibapl_jnhw_common_references_ObjectRef_value_ID, value)

//#define UNWRAP_NATIVE_FUNCTION_POINTER(nativeFunctionPointer)(void*)(intptr_t)(*env)->GetLongField(env, nativeFunctionPointer, de_ibapl_jnhw_NativeFunctionPointer_nativeAddress_ID)
#define UNWRAP_NATIVE_FUNCTION_POINTER_TO(destType, nativeFunctionPointer)(destType)(intptr_t)(*env)->GetLongField(env, nativeFunctionPointer, de_ibapl_jnhw_common_memory_NativeFunctionPointer_nativeAddress_ID)
#define CREATE_NATIVE_FUNCTION_POINTER(value) (*env)->NewObject(env, de_ibapl_jnhw_common_memory_NativeFunctionPointer_Class, de_ibapl_jnhw_common_memory_NativeFunctionPointer_init_ID, (jlong) (intptr_t) value)
    
#define UNWRAP_NATIVE_ADDRESS_HOLDER_TO(destType, value) (destType)(intptr_t)(*env)->GetLongField(env, value, de_ibapl_jnhw_common_memory_NativeAddressHolder_address_ID)    
#define CREATE_NATIVE_ADDRESS_HOLDER(value) (*env)->NewObject(env, de_ibapl_jnhw_common_memory_NativeAddressHolder_Class, de_ibapl_jnhw_common_memory_NativeAddressHolder_init_ID, (jlong) (intptr_t) value)

#ifdef __cplusplus
}
#endif

#endif
