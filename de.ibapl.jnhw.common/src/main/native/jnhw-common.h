/**
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
#ifndef _ljnhw_common_H
#define _ljnhw_common_H

#include <stdint.h>

#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif

    /**
     * Structure for define names
     *  a class name:      JNWW_cN_X_L_name, where cN is the abbrevation for class name, X is the shorted package name without the last L ist the last part of the package name and name is the class name
     *  a class signature: JNWW_cS_X_L_name, where cS is the abbrevation for class signature, X is the shorted package name without the last L ist the last part of the package name and name is the class name
     *
     *
     */
#ifdef _JNHW_COMMON_IMPLEMENTATION_
#define _JNHW_IMPORT_OR_EXPORT_ JNIEXPORT

#include "../../../config.h"

#else
#define _JNHW_IMPORT_OR_EXPORT_ JNIIMPORT
#endif

#include "JnhwExceptions.h"

#define STR(x) #x
#define CLASS_NAME_TO_SIGNATURE(className) "L"className";"


    //globally important class names
#define dijc_m_NativeAddressHolder_CName "de/ibapl/jnhw/common/memory/NativeAddressHolder"
#define dijc_m_NativeAddressHolder_CSig CLASS_NAME_TO_SIGNATURE(dijc_m_NativeAddressHolder_CName)

#define dijc_m_NativeFunctionPointer_CName "de/ibapl/jnhw/common/memory/NativeFunctionPointer"
#define dijc_m_NativeFunctionPointer_CSig CLASS_NAME_TO_SIGNATURE(dijc_m_NativeFunctionPointer_CName)

#define dijc_np_FunctionPtr_I_V_CName "de/ibapl/jnhw/common/nativepointer/FunctionPtr_I_V"
#define dijc_np_FunctionPtr_I_V_CSig CLASS_NAME_TO_SIGNATURE(dijc_np_FunctionPtr_I_V_CName)

#define dijc_np_FunctionPtr_J_V_CName "de/ibapl/jnhw/common/nativepointer/FunctionPtr_J_V"
#define dijc_np_FunctionPtr_J_V_CSig CLASS_NAME_TO_SIGNATURE(dijc_np_FunctionPtr_J_V_CName)

#define dijc_np_FunctionPtr_IJ_V_CName "de/ibapl/jnhw/common/nativepointer/FunctionPtr_IJ_V"
#define dijc_np_FunctionPtr_IJ_V_CSig CLASS_NAME_TO_SIGNATURE(dijc_np_FunctionPtr_IJ_V_CName)

#define dijc_np_FunctionPtr_I_I_Mem_V_CName "de/ibapl/jnhw/common/nativepointer/FunctionPtr_I_I_Mem_V"
#define dijc_np_FunctionPtr_I_Mem_V_CSig CLASS_NAME_TO_SIGNATURE(dijc_np_FunctionPtr_I_Mem_V_CName)

#define dijc_np_FunctionPtr_I_Mem_Mem_V_CName "de/ibapl/jnhw/common/nativepointer/FunctionPtr_I_Mem_Mem_V"
#define dijc_np_FunctionPtr_Mem_Mem_V_CSig CLASS_NAME_TO_SIGNATURE(dijc_np_FunctionPtr_Mem_Mem_V_CName)

#define dijc_np_FunctionPtr_Mem_V_CName "de/ibapl/jnhw/common/nativepointer/FunctionPtr_Mem_V"
#define dijc_np_FunctionPtr_Mem_V_CSig CLASS_NAME_TO_SIGNATURE(dijc_np_FunctionPtr_Mem_V_CName)



    //Cached
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID dijc_r_ByteRef_value__FID;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID dijc_r_ShortRef_value__FID;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID dijc_r_IntRef_value__FID;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID dijc_r_LongRef_value__FID;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID dijc_r_ObjectRef_value__FID;

    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID dijc_m_AbstractNativeMemory_baseAddress__FID;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID dijc_m_OpaqueMemory32_sizeInBytes__FID;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID dijc_m_OpaqueMemory64_sizeInBytes__FID;

    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID dijc_m_StructArray32_length__MID;

    _JNHW_IMPORT_OR_EXPORT_ extern jclass dijc_m_NativeAddressHolder__GCR;
    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID dijc_m_NativeAddressHolder_address__FID;
    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID dijc_m_NativeAddressHolder_init__MID;

    //TODO deprecated ...
    _JNHW_IMPORT_OR_EXPORT_ extern jclass dijc_m_NativeFunctionPointer__GCR;
    _JNHW_IMPORT_OR_EXPORT_ extern jclass dijc_np_FunctionPtr_I_V__GCR;
    _JNHW_IMPORT_OR_EXPORT_ extern jclass dijc_np_FunctionPtr_J_V__GCR;
    _JNHW_IMPORT_OR_EXPORT_ extern jclass dijc_np_FunctionPtr_IJ_V__GCR;
    _JNHW_IMPORT_OR_EXPORT_ extern jclass dijc_np_FunctionPtr_I_I_Mem_V__GCR;
    _JNHW_IMPORT_OR_EXPORT_ extern jclass dijc_np_FunctionPtr_I_Mem_Mem_V__GCR;
    _JNHW_IMPORT_OR_EXPORT_ extern jclass dijc_np_FunctionPtr_Mem_V__GCR;

    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID dijc_m_NativeFunctionPointer_nativeAddress__FID;

    //TODO deprecated ...
    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID dijc_m_NativeFunctionPointer_init__MID;
    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID dijc_np_FunctionPtr_I_V_init__MID;
    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID dijc_np_FunctionPtr_J_V_init__MID;
    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID dijc_np_FunctionPtr_IJ_V_init__MID;
    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID dijc_np_FunctionPtr_I_I_Mem_V_init__MID;
    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID dijc_np_FunctionPtr_I_Mem_Mem_V_init__MID;
    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID dijc_np_FunctionPtr_Mem_V_init__MID;

    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID dijc_m_PointerArray32_cachedReferences__FID;


    _JNHW_IMPORT_OR_EXPORT_ extern jclass JNICALL getGlobalClassRef(JNIEnv *env, const char* className);

    _JNHW_IMPORT_OR_EXPORT_ extern void JNICALL deleteGlobalRef(JNIEnv *env, jobject *classRef);

    _JNHW_IMPORT_OR_EXPORT_ extern jfieldID JNICALL getFieldId(JNIEnv *env, const char* className, const char* fieldName, const char* fieldType);

    _JNHW_IMPORT_OR_EXPORT_ extern jmethodID JNICALL getMethodId(JNIEnv *env, const char* className, const char* methodName, const char* methodSignature);

    /*
     * Returns true if the array slice defined by the given offset and length
     * is out of bounds.
     */
    _JNHW_IMPORT_OR_EXPORT_ extern int outOfBoundsByteArray(JNIEnv *env, jint pos, jint len, jbyteArray array);

    _JNHW_IMPORT_OR_EXPORT_ extern int outOfBoundsOpaqueMemory32(JNIEnv *env, jint pos, jint len, jobject opaqueMemory32);
    _JNHW_IMPORT_OR_EXPORT_ extern int outOfBoundsOpaqueMemory64(JNIEnv *env, jlong pos, jlong len, jobject opaqueMemory64);

    /**
     * call Fieldlayout.int8_t(offset) from the native side.
     *
     * @param env
     * @param clazzFL
     * @param dataTypeName the name of a static methos that represents a fatatype i.e. "int8_t"
     * @param fieldName
     * @param value
     * @return
     */
    _JNHW_IMPORT_OR_EXPORT_ extern jobject JNICALL JnhwCreateFieldLayout(JNIEnv *env, jclass clazzFL, const char * dataTypeName, jlong offset);
    _JNHW_IMPORT_OR_EXPORT_ extern jobject JnhwCreateStructLayout(JNIEnv *env, jclass structLayoutClass, int64_t sizeInBytes, int32_t alingmentInBytes);

    _JNHW_IMPORT_OR_EXPORT_ extern jboolean JnhwSetLongField(JNIEnv *env, jclass clazz, const char * fieldName, jlong value);


    _JNHW_IMPORT_OR_EXPORT_ extern jboolean JnhwSetStaticObjectField(JNIEnv *env, jclass clazz, const char * fieldClassSignature, const char * fieldName, jobject value);
    _JNHW_IMPORT_OR_EXPORT_ extern jboolean JnhwSetStaticLongField(JNIEnv *env, jclass clazz, const char * fieldName, jlong value);
    _JNHW_IMPORT_OR_EXPORT_ extern jboolean JnhwSetStaticIntField(JNIEnv *env, jclass clazz, const char * fieldName, jint value);
    _JNHW_IMPORT_OR_EXPORT_ extern jboolean JnhwSetStaticShortField(JNIEnv *env, jclass clazz, const char * fieldName, jshort value);
    _JNHW_IMPORT_OR_EXPORT_ extern jboolean JnhwSetStaticByteField(JNIEnv *env, jclass clazz, const char * fieldName, jbyte value);
    _JNHW_IMPORT_OR_EXPORT_ extern jboolean JnhwSetStaticBooleanField(JNIEnv *env, jclass clazz, const char * fieldName, jboolean value);

    _JNHW_IMPORT_OR_EXPORT_ extern jboolean JnhwSetStaticObjectDefineField(JNIEnv *env, jclass clazz, const char * fieldName, jobject value);
    _JNHW_IMPORT_OR_EXPORT_ extern jboolean JnhwSetStaticIntDefineField(JNIEnv *env, jclass clazz, const char * fieldName, jint value);

    //Its funny how the differnt archs ans OSses have different datatypes so a long int is not equals to long long on 64 bit...

#define JNHW_FORMAT_STRING_int8_t "%d"
#define JNHW_FORMAT_STRING_uint8_t "%u"
#define JNHW_FORMAT_STRING_HEX_int8_t "0x%02x"
#define JNHW_FORMAT_STRING_HEX_uint8_t "0x%02x"

#define JNHW_FORMAT_STRING_int16_t "%d"
#define JNHW_FORMAT_STRING_uint16_t "%u"
#define JNHW_FORMAT_STRING_HEX_int16_t "0x%04x"
#define JNHW_FORMAT_STRING_HEX_uint16_t "0x%04x"

#define JNHW_FORMAT_STRING_int32_t "%d"
#define JNHW_FORMAT_STRING_uint32_t "%u"
#define JNHW_FORMAT_STRING_HEX_int32_t "0x%08x"
#define JNHW_FORMAT_STRING_HEX_uint32_t "0x%08x"

#if defined(__LP64__)
#if defined(__OpenBSD__)
#define JNHW_FORMAT_STRING_int64_t "%lld"
#define JNHW_FORMAT_STRING_uint64_t "%llu"
#define JNHW_FORMAT_STRING_HEX_int64_t "0x%016llx"
#define JNHW_FORMAT_STRING_HEX_uint64_t "0x%016llx"
#else
#define JNHW_FORMAT_STRING_int64_t "%ld"
#define JNHW_FORMAT_STRING_uint64_t "%lu"
#define JNHW_FORMAT_STRING_HEX_int64_t "0x%016lx"
#define JNHW_FORMAT_STRING_HEX_uint64_t "0x%016lx"
#endif
#elif defined(__WIN64)
#define JNHW_FORMAT_STRING_int64_t "%lld"
#define JNHW_FORMAT_STRING_uint64_t "%llu"
#define JNHW_FORMAT_STRING_HEX_int64_t "0x%016llx"
#define JNHW_FORMAT_STRING_HEX_uint64_t "0x%016llx"
#else
#define JNHW_FORMAT_STRING_int64_t "%lld"
#define JNHW_FORMAT_STRING_uint64_t "%llu"
#define JNHW_FORMAT_STRING_HEX_int64_t "0x%016llx"
#define JNHW_FORMAT_STRING_HEX_uint64_t "0x%016llx"
#endif

    /**
     * Unwarap the baseAddress of given opaqueMemory(jobject) of an OpaqueMemory instance and cast these baseAddress to given type and put it in ().
     * Using GetIntField for 32bit addresses will fail on BIG_ENDIAN...
     *
     */
#define UNWRAP_ABSTRACT_MEM_TO(destType, abstractMemory) ((destType)((uintptr_t)(*env)->GetLongField(env, abstractMemory, dijc_m_AbstractNativeMemory_baseAddress__FID)))

    /**
     * Unwarap the baseAddress given abstractMemory(jobject) of an OpaqueMemory instance and cast these baseAddress to given type.
     * If abstractMemory == NULL return NULL, otherwise unwrap.
     *
     */
#define UNWRAP_ABSTRACT_MEM_TO_OR_NULL(destType, abstractMemory) abstractMemory == NULL ? (destType)NULL : UNWRAP_ABSTRACT_MEM_TO(destType, abstractMemory)

#define UNWRAP_ABSTRACT_MEM_TO_VOID_PTR(abstractMemory) UNWRAP_ABSTRACT_MEM_TO(void*, abstractMemory)
#define UNWRAP_ABSTRACT_MEM_TO_VOID_PTR_OR_NULL(abstractMemory) UNWRAP_ABSTRACT_MEM_TO_OR_NULL(void*, abstractMemory)
#define UNWRAP_ABSTRACT_MEM_TO_VOID_PTR_PTR(abstractMemory) UNWRAP_ABSTRACT_MEM_TO(void**, abstractMemory)

#define SIZE_OF_OPAQUE_MEM_32(opaqueMem) (*env)->GetIntField(env, opaqueMem, dijc_m_OpaqueMemory32_sizeInBytes__FID)
#define SIZE_OF_OPAQUE_MEM_64(opaqueMem) (*env)->GetLongField(env, opaqueMem, dijc_m_OpaqueMemory64_sizeInBytes__FID)

#define LENGTH_OF_STRUCTURE_ARRAY_32(structureArray) (int32_t)(*env)->CallIntMethod(env, structureArray, dijc_m_StructArray32_length__MID)

#define LENGTH_OF_POINTER_ARRAY_32(pointerArray) (*env)->GetArrayLength(env, (*env)->GetObjectField(env, pointerArray, dijc_m_PointerArray32_cachedReferences__FID))

#define GET_BYTE_REF_VALUE(valueRef) (*env)->GetByteField(env, valueRef, dijc_r_ByteRef_value__FID)
#define SET_BYTE_REF_VALUE(valueRef, value) (*env)->SetByteField(env, valueRef, dijc_r_ByteRef_value__FID, value)

#define GET_SHORT_REF_VALUE(valueRef) (*env)->GetShortField(env, valueRef, dijc_r_ShortRef_value__FID)
#define SET_SHORT_REF_VALUE(valueRef, value) (*env)->SetShortField(env, valueRef, dijc_r_ShortRef_value__FID, value)

#define GET_INT_REF_VALUE(valueRef) (*env)->GetIntField(env, valueRef, dijc_r_IntRef_value__FID)
#define SET_INT_REF_VALUE(valueRef, value) (*env)->SetIntField(env, valueRef, dijc_r_IntRef_value__FID, value)

#define GET_LONG_REF_VALUE(valueRef) (*env)->GetLongField(env, valueRef, dijc_r_LongRef_value__FID)
#define SET_LONG_REF_VALUE(valueRef, value) (*env)->SetLongField(env, valueRef, dijc_r_LongRef_value__FID, value)

#define GET_OBJECT_REF_VALUE(valueRef) (*env)->GetObjectField(env, valueRef, dijc_r_ObjectRef_value__FID)
#define SET_OBJECT_REF_VALUE(valueRef, value) (*env)->SetObjectField(env, valueRef, dijc_r_ObjectRef_value__FID, value)

    //#define UNWRAP_NATIVE_FUNCTION_POINTER(nativeFunctionPointer)(void*)(intptr_t)(*env)->GetLongField(env, nativeFunctionPointer, de_ibapl_jnhw_NativeFunctionPointer_nativeAddress_ID)
#define UNWRAP_NativeFunctionPointer_TO(destType, nativeFunctionPointer)(destType)(uintptr_t)(*env)->GetLongField(env, nativeFunctionPointer, dijc_m_NativeFunctionPointer_nativeAddress__FID)

#define CREATE_NativeFunctionPointer(value) (*env)->NewObject(env, dijc_m_NativeFunctionPointer__GCR, dijc_m_NativeFunctionPointer_init__MID, (jlong) (uintptr_t) value)

#define CREATE_FunctionPtr_I_V(value) (*env)->NewObject(env, dijc_np_FunctionPtr_I_V__GCR, dijc_np_FunctionPtr_I_V_init__MID, (jlong) (uintptr_t) value)
#define CREATE_FunctionPtr_J_V(value) (*env)->NewObject(env, dijc_np_FunctionPtr_J_V__GCR, dijc_np_FunctionPtr_J_V_init__MID, (jlong) (uintptr_t) value)
#define CREATE_FunctionPtr_IJ_V(value) (*env)->NewObject(env, dijc_np_FunctionPtr_IJ_V__GCR, dijc_np_FunctionPtr_IJ_V_init__MID, (jlong) (uintptr_t) value)
#define CREATE_FunctionPtr_I_I_Mem_V(value) (*env)->NewObject(env, dijc_np_FunctionPtr_I_I_Mem_V__GCR, dijc_np_FunctionPtr_I_I_Mem_V_init__MID, (jlong) (uintptr_t) value)
#define CREATE_FunctionPtr_I_Mem_Mem_V(value) (*env)->NewObject(env, dijc_np_FunctionPtr_I_Mem_Mem_V__GCR, dijc_np_FunctionPtr_I_Mem_Mem_V_init__MID, (jlong) (uintptr_t) value)
#define CREATE_FunctionPtr_Mem_V(value) (*env)->NewObject(env, dijc_np_FunctionPtr_Mem_V__GCR, dijc_np_FunctionPtr_Mem_V_init__MID, (jlong) (uintptr_t) value)

#define UNWRAP_NativeAddressHolder_TO(destType, value) (destType)(uintptr_t)(*env)->GetLongField(env, value, dijc_m_NativeAddressHolder_address__FID)
#define CREATE_NativeAddressHolder(value) (*env)->NewObject(env, dijc_m_NativeAddressHolder__GCR, dijc_m_NativeAddressHolder_init__MID, (jlong) (uintptr_t) value)

#ifdef __cplusplus
}
#endif

#endif
