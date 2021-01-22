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

//Important class names
#define JNHW_CLASS_NAME_BYTE_REF   "de/ibapl/jnhw/common/references/ByteRef"
#define JNHW_CLASS_NAME_SHORT_REF  "de/ibapl/jnhw/common/references/ShortRef"
#define JNHW_CLASS_NAME_INT_REF    "de/ibapl/jnhw/common/references/IntRef"
#define JNHW_CLASS_NAME_LONG_REF   "de/ibapl/jnhw/common/references/LongRef"
#define JNHW_CLASS_NAME_OBJECT_REF "de/ibapl/jnhw/common/references/ObjectRef"

#define JNHW_CLASS_NAME_NATIVE_FUNCTION_POINTER "de/ibapl/jnhw/common/memory/NativeFunctionPointer"
#define JNHW_CLASS_NAME_CALL_NATIVE_I_V "de/ibapl/jnhw/common/nativecall/CallNative_I_V"
#define JNHW_CLASS_NAME_CALL_NATIVE_J_V "de/ibapl/jnhw/common/nativecall/CallNative_J_V"
#define JNHW_CLASS_NAME_CALL_NATIVE_IJ_V "de/ibapl/jnhw/common/nativecall/CallNative_IJ_V"
#define JNHW_CLASS_NAME_CALL_NATIVE_I_I_PTR_ABSTRACT_NATIVE_MEMORY_V "de/ibapl/jnhw/common/nativecall/CallNative_I_I_PtrAbstractNativeMemory_V"
#define JNHW_CLASS_NAME_CALL_NATIVE_I_PTR_ABSTRACT_NATIVE_MEMORY_PTR_ABSTRACT_NATIVE_MEMORY_V "de/ibapl/jnhw/common/nativecall/CallNative_I_PtrAbstractNativeMemory_PtrAbstractNativeMemory_V"
#define JNHW_CLASS_NAME_CALL_NATIVE_PTR_ABSTRACT_NATIVE_MEMORY_V "de/ibapl/jnhw/common/nativecall/CallNative_PtrAbstractNativeMemory_V"

#define JNHW_CLASS_NAME_ABSTRACT_NATIVE_MEMORY "de/ibapl/jnhw/common/memory/AbstractNativeMemory"
#define JNHW_CLASS_NAME_OPAQUE_MEMORY_32 "de/ibapl/jnhw/common/memory/OpaqueMemory32"
#define JNHW_CLASS_NAME_OPAQUE_MEMORY_64 "de/ibapl/jnhw/common/memory/OpaqueMemory64"
#define JNHW_CLASS_NAME_STRUCT_ARRAY_32 "de/ibapl/jnhw/common/memory/StructArray32"
#define JNHW_CLASS_NAME_POINTER_ARRAY_32 "de/ibapl/jnhw/common/memory/PointerArray32"

#ifdef __cplusplus
extern "C" {
#endif

    JNIEXPORT jfieldID de_ibapl_jnhw_common_references_ByteRef_value_ID = NULL;
    JNIEXPORT jfieldID de_ibapl_jnhw_common_references_ShortRef_value_ID = NULL;
    JNIEXPORT jfieldID de_ibapl_jnhw_common_references_IntRef_value_ID = NULL;
    JNIEXPORT jfieldID de_ibapl_jnhw_common_references_LongRef_value_ID = NULL;
    JNIEXPORT jfieldID de_ibapl_jnhw_common_references_ObjectRef_value_ID = NULL;
    JNIEXPORT jfieldID de_ibapl_jnhw_common_memory_AbstractNativeMemory_baseAddress_ID = NULL;
    JNIEXPORT jfieldID de_ibapl_jnhw_common_memory_OpaqueMemory32_sizeInBytes_ID = NULL;
    JNIEXPORT jfieldID de_ibapl_jnhw_common_memory_OpaqueMemory64_sizeInBytes_ID = NULL;
    JNIEXPORT jmethodID de_ibapl_jnhw_common_memory_StructArray32_length_ID = NULL;

    JNIEXPORT jclass de_ibapl_jnhw_common_memory_NativeAddressHolder_Class = NULL;
    JNIEXPORT jfieldID de_ibapl_jnhw_common_memory_NativeAddressHolder_address_ID = NULL;
    JNIEXPORT jmethodID de_ibapl_jnhw_common_memory_NativeAddressHolder_init_ID = NULL;

    JNIEXPORT jclass de_ibapl_jnhw_common_memory_NativeFunctionPointer_Class = NULL;
    JNIEXPORT jclass de_ibapl_jnhw_common_nativecall_CallNative_I_V_Class = NULL;
    JNIEXPORT jclass de_ibapl_jnhw_common_nativecall_CallNative_J_V_Class = NULL;
    JNIEXPORT jclass de_ibapl_jnhw_common_nativecall_CallNative_IJ_V_Class = NULL;
    JNIEXPORT jclass de_ibapl_jnhw_common_nativecall_CallNative_I_I_PtrAbstractNativeMemory_V_Class = NULL;
    JNIEXPORT jclass de_ibapl_jnhw_common_nativecall_CallNative_I_PtrAbstractNativeMemory_PtrAbstractNativeMemory_V_Class = NULL;
    JNIEXPORT jclass de_ibapl_jnhw_common_nativecall_CallNative_PtrAbstractNativeMemory_V_Class = NULL;

    JNIEXPORT jfieldID de_ibapl_jnhw_common_memory_NativeFunctionPointer_nativeAddress_ID = NULL;
    JNIEXPORT jmethodID de_ibapl_jnhw_common_memory_NativeFunctionPointer_init_ID = NULL;
    JNIEXPORT jmethodID de_ibapl_jnhw_common_nativecall_CallNative_I_V_init_ID = NULL;
    JNIEXPORT jmethodID de_ibapl_jnhw_common_nativecall_CallNative_J_V_init_ID = NULL;
    JNIEXPORT jmethodID de_ibapl_jnhw_common_nativecall_CallNative_IJ_V_init_ID = NULL;
    JNIEXPORT jmethodID de_ibapl_jnhw_common_nativecall_CallNative_I_I_PtrAbstractNativeMemory_V_init_ID = NULL;
    JNIEXPORT jmethodID de_ibapl_jnhw_common_nativecall_CallNative_I_PtrAbstractNativeMemory_PtrAbstractNativeMemory_V_init_ID = NULL;
    JNIEXPORT jmethodID de_ibapl_jnhw_common_nativecall_CallNative_PtrAbstractNativeMemory_V_init_ID = NULL;

    JNIEXPORT jfieldID de_ibapl_jnhw_common_memory_PointerArray32_cachedReferences_ID = NULL;

    static jboolean JNICALL jnhw_common_init(JNIEnv *env) {
        if (initExceptions(env) == JNI_FALSE) {
            return JNI_FALSE;
        }
        if (de_ibapl_jnhw_common_references_ByteRef_value_ID == NULL) {
            de_ibapl_jnhw_common_references_ByteRef_value_ID = getFieldId(env, JNHW_CLASS_NAME_BYTE_REF, "value", "B");
            if (de_ibapl_jnhw_common_references_ByteRef_value_ID == NULL) {
                return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_common_references_ShortRef_value_ID == NULL) {
            de_ibapl_jnhw_common_references_ShortRef_value_ID = getFieldId(env, JNHW_CLASS_NAME_SHORT_REF, "value", "S");
            if (de_ibapl_jnhw_common_references_ShortRef_value_ID == NULL) {
                return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_common_references_IntRef_value_ID == NULL) {
            de_ibapl_jnhw_common_references_IntRef_value_ID = getFieldId(env, JNHW_CLASS_NAME_INT_REF, "value", "I");
            if (de_ibapl_jnhw_common_references_IntRef_value_ID == NULL) {
                return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_common_references_LongRef_value_ID == NULL) {
            de_ibapl_jnhw_common_references_LongRef_value_ID = getFieldId(env, JNHW_CLASS_NAME_LONG_REF, "value", "J");
            if (de_ibapl_jnhw_common_references_LongRef_value_ID == NULL) {
                return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_common_references_ObjectRef_value_ID == NULL) {
            de_ibapl_jnhw_common_references_ObjectRef_value_ID = getFieldId(env, JNHW_CLASS_NAME_OBJECT_REF, "value", "Ljava/lang/Object;");
            if (de_ibapl_jnhw_common_references_ObjectRef_value_ID == NULL) {
                return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_common_memory_AbstractNativeMemory_baseAddress_ID == NULL) {
            de_ibapl_jnhw_common_memory_AbstractNativeMemory_baseAddress_ID = getFieldId(env, JNHW_CLASS_NAME_ABSTRACT_NATIVE_MEMORY, "baseAddress", "J");
            if (de_ibapl_jnhw_common_memory_AbstractNativeMemory_baseAddress_ID == NULL) {
                return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_common_memory_OpaqueMemory32_sizeInBytes_ID == NULL) {
            de_ibapl_jnhw_common_memory_OpaqueMemory32_sizeInBytes_ID = getFieldId(env, JNHW_CLASS_NAME_OPAQUE_MEMORY_32, "sizeInBytes", "I");
            if (de_ibapl_jnhw_common_memory_OpaqueMemory32_sizeInBytes_ID == NULL) {
                return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_common_memory_OpaqueMemory64_sizeInBytes_ID == NULL) {
            de_ibapl_jnhw_common_memory_OpaqueMemory64_sizeInBytes_ID = getFieldId(env, JNHW_CLASS_NAME_OPAQUE_MEMORY_64, "sizeInBytes", "J");
            if (de_ibapl_jnhw_common_memory_OpaqueMemory64_sizeInBytes_ID == NULL) {
                return JNI_FALSE;
            }
        }
        //TODO use array ???
        if (de_ibapl_jnhw_common_memory_StructArray32_length_ID == NULL) {
            de_ibapl_jnhw_common_memory_StructArray32_length_ID = getMethodId(env, JNHW_CLASS_NAME_STRUCT_ARRAY_32, "length", "()I");
            if (de_ibapl_jnhw_common_memory_StructArray32_length_ID == NULL) {
                return JNI_FALSE;
            }
        }

        if (de_ibapl_jnhw_common_memory_PointerArray32_cachedReferences_ID == NULL) {
            de_ibapl_jnhw_common_memory_PointerArray32_cachedReferences_ID = getFieldId(env, JNHW_CLASS_NAME_POINTER_ARRAY_32, "cachedReferences", "[Lde/ibapl/jnhw/common/memory/OpaqueMemory32;");
            if (de_ibapl_jnhw_common_memory_PointerArray32_cachedReferences_ID == NULL) {
                return JNI_FALSE;
            }
        }

        if (de_ibapl_jnhw_common_memory_NativeAddressHolder_Class == NULL) {
            de_ibapl_jnhw_common_memory_NativeAddressHolder_Class = getGlobalClassRef(env, JNHW_CLASS_NAME_NATIVE_ADDRESS_HOLDER);
            if (de_ibapl_jnhw_common_memory_NativeAddressHolder_Class == NULL) {
                return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_common_memory_NativeAddressHolder_init_ID == NULL) {
            de_ibapl_jnhw_common_memory_NativeAddressHolder_init_ID = getMethodIdOfClassRef(env, de_ibapl_jnhw_common_memory_NativeAddressHolder_Class, "<init>", "(J)V");
            if (de_ibapl_jnhw_common_memory_NativeAddressHolder_init_ID == NULL) {
                return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_common_memory_NativeAddressHolder_address_ID == NULL) {
            de_ibapl_jnhw_common_memory_NativeAddressHolder_address_ID = getFieldIdOfClassRef(env, de_ibapl_jnhw_common_memory_NativeAddressHolder_Class, "address", "J");
            if (de_ibapl_jnhw_common_memory_NativeAddressHolder_address_ID == NULL) {
                return JNI_FALSE;
            }
        }

        if (de_ibapl_jnhw_common_memory_NativeFunctionPointer_Class == NULL) {
            de_ibapl_jnhw_common_memory_NativeFunctionPointer_Class = getGlobalClassRef(env, JNHW_CLASS_NAME_NATIVE_FUNCTION_POINTER);
            if (de_ibapl_jnhw_common_memory_NativeFunctionPointer_Class == NULL) {
                return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_common_memory_NativeFunctionPointer_init_ID == NULL) {
            de_ibapl_jnhw_common_memory_NativeFunctionPointer_init_ID = getMethodIdOfClassRef(env, de_ibapl_jnhw_common_memory_NativeFunctionPointer_Class, "<init>", "(J)V");
            if (de_ibapl_jnhw_common_memory_NativeFunctionPointer_init_ID == NULL) {
                return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_common_memory_NativeFunctionPointer_nativeAddress_ID == NULL) {
            de_ibapl_jnhw_common_memory_NativeFunctionPointer_nativeAddress_ID = getFieldIdOfClassRef(env, de_ibapl_jnhw_common_memory_NativeFunctionPointer_Class, "nativeAddress", "J");
            if (de_ibapl_jnhw_common_memory_NativeFunctionPointer_nativeAddress_ID == NULL) {
                return JNI_FALSE;
            }
        }

        if (de_ibapl_jnhw_common_nativecall_CallNative_I_V_Class == NULL) {
            de_ibapl_jnhw_common_nativecall_CallNative_I_V_Class = getGlobalClassRef(env, JNHW_CLASS_NAME_CALL_NATIVE_I_V);
            if (de_ibapl_jnhw_common_nativecall_CallNative_I_V_Class == NULL) {
                return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_common_nativecall_CallNative_I_V_init_ID == NULL) {
            de_ibapl_jnhw_common_nativecall_CallNative_I_V_init_ID = getMethodIdOfClassRef(env, de_ibapl_jnhw_common_nativecall_CallNative_I_V_Class, "<init>", "(J)V");
            if (de_ibapl_jnhw_common_nativecall_CallNative_I_V_init_ID == NULL) {
                return JNI_FALSE;
            }
        }

        if (de_ibapl_jnhw_common_nativecall_CallNative_J_V_Class == NULL) {
            de_ibapl_jnhw_common_nativecall_CallNative_J_V_Class = getGlobalClassRef(env, JNHW_CLASS_NAME_CALL_NATIVE_J_V);
            if (de_ibapl_jnhw_common_nativecall_CallNative_J_V_Class == NULL) {
                return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_common_nativecall_CallNative_J_V_init_ID == NULL) {
            de_ibapl_jnhw_common_nativecall_CallNative_J_V_init_ID = getMethodIdOfClassRef(env, de_ibapl_jnhw_common_nativecall_CallNative_J_V_Class, "<init>", "(J)V");
            if (de_ibapl_jnhw_common_nativecall_CallNative_J_V_init_ID == NULL) {
                return JNI_FALSE;
            }
        }

        if (de_ibapl_jnhw_common_nativecall_CallNative_IJ_V_Class == NULL) {
            de_ibapl_jnhw_common_nativecall_CallNative_IJ_V_Class = getGlobalClassRef(env, JNHW_CLASS_NAME_CALL_NATIVE_IJ_V);
            if (de_ibapl_jnhw_common_nativecall_CallNative_IJ_V_Class == NULL) {
                return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_common_nativecall_CallNative_IJ_V_init_ID == NULL) {
            de_ibapl_jnhw_common_nativecall_CallNative_IJ_V_init_ID = getMethodIdOfClassRef(env, de_ibapl_jnhw_common_nativecall_CallNative_IJ_V_Class, "<init>", "(J)V");
            if (de_ibapl_jnhw_common_nativecall_CallNative_IJ_V_init_ID == NULL) {
                return JNI_FALSE;
            }
        }

        if (de_ibapl_jnhw_common_nativecall_CallNative_I_I_PtrAbstractNativeMemory_V_Class == NULL) {
            de_ibapl_jnhw_common_nativecall_CallNative_I_I_PtrAbstractNativeMemory_V_Class = getGlobalClassRef(env, JNHW_CLASS_NAME_CALL_NATIVE_I_I_PTR_ABSTRACT_NATIVE_MEMORY_V);
            if (de_ibapl_jnhw_common_nativecall_CallNative_I_I_PtrAbstractNativeMemory_V_Class == NULL) {
                return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_common_nativecall_CallNative_I_I_PtrAbstractNativeMemory_V_init_ID == NULL) {
            de_ibapl_jnhw_common_nativecall_CallNative_I_I_PtrAbstractNativeMemory_V_init_ID = getMethodIdOfClassRef(env, de_ibapl_jnhw_common_nativecall_CallNative_I_I_PtrAbstractNativeMemory_V_Class, "<init>", "(J)V");
            if (de_ibapl_jnhw_common_nativecall_CallNative_I_I_PtrAbstractNativeMemory_V_init_ID == NULL) {
                return JNI_FALSE;
            }
        }

        if (de_ibapl_jnhw_common_nativecall_CallNative_I_PtrAbstractNativeMemory_PtrAbstractNativeMemory_V_Class == NULL) {
            de_ibapl_jnhw_common_nativecall_CallNative_I_PtrAbstractNativeMemory_PtrAbstractNativeMemory_V_Class = getGlobalClassRef(env, JNHW_CLASS_NAME_CALL_NATIVE_I_PTR_ABSTRACT_NATIVE_MEMORY_PTR_ABSTRACT_NATIVE_MEMORY_V);
            if (de_ibapl_jnhw_common_nativecall_CallNative_I_PtrAbstractNativeMemory_PtrAbstractNativeMemory_V_Class == NULL) {
                return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_common_nativecall_CallNative_I_PtrAbstractNativeMemory_PtrAbstractNativeMemory_V_init_ID == NULL) {
            de_ibapl_jnhw_common_nativecall_CallNative_I_PtrAbstractNativeMemory_PtrAbstractNativeMemory_V_init_ID = getMethodIdOfClassRef(env, de_ibapl_jnhw_common_nativecall_CallNative_I_PtrAbstractNativeMemory_PtrAbstractNativeMemory_V_Class, "<init>", "(J)V");
            if (de_ibapl_jnhw_common_nativecall_CallNative_I_PtrAbstractNativeMemory_PtrAbstractNativeMemory_V_init_ID == NULL) {
                return JNI_FALSE;
            }
        }

        if (de_ibapl_jnhw_common_nativecall_CallNative_PtrAbstractNativeMemory_V_Class == NULL) {
            de_ibapl_jnhw_common_nativecall_CallNative_PtrAbstractNativeMemory_V_Class = getGlobalClassRef(env, JNHW_CLASS_NAME_CALL_NATIVE_PTR_ABSTRACT_NATIVE_MEMORY_V);
            if (de_ibapl_jnhw_common_nativecall_CallNative_PtrAbstractNativeMemory_V_Class == NULL) {
                return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_common_nativecall_CallNative_PtrAbstractNativeMemory_V_init_ID == NULL) {
            de_ibapl_jnhw_common_nativecall_CallNative_PtrAbstractNativeMemory_V_init_ID = getMethodIdOfClassRef(env, de_ibapl_jnhw_common_nativecall_CallNative_PtrAbstractNativeMemory_V_Class, "<init>", "(J)V");
            if (de_ibapl_jnhw_common_nativecall_CallNative_PtrAbstractNativeMemory_V_init_ID == NULL) {
                return JNI_FALSE;
            }
        }

        return JNI_TRUE;
    }

    static void JNICALL jnhw_common_release(JNIEnv *env) {
        releaseExceptions(env);

        de_ibapl_jnhw_common_references_ByteRef_value_ID = NULL;
        de_ibapl_jnhw_common_references_ShortRef_value_ID = NULL;
        de_ibapl_jnhw_common_references_IntRef_value_ID = NULL;
        de_ibapl_jnhw_common_references_LongRef_value_ID = NULL;
        de_ibapl_jnhw_common_references_ObjectRef_value_ID = NULL;
        de_ibapl_jnhw_common_memory_AbstractNativeMemory_baseAddress_ID = NULL;
        de_ibapl_jnhw_common_memory_OpaqueMemory32_sizeInBytes_ID = NULL;
        de_ibapl_jnhw_common_memory_OpaqueMemory64_sizeInBytes_ID = NULL;
        de_ibapl_jnhw_common_memory_StructArray32_length_ID = NULL;
        
        deleteGlobalRef(env, &de_ibapl_jnhw_common_memory_NativeAddressHolder_Class);
        de_ibapl_jnhw_common_memory_NativeAddressHolder_address_ID = NULL;
        de_ibapl_jnhw_common_memory_NativeAddressHolder_init_ID = NULL;

        deleteGlobalRef(env, &de_ibapl_jnhw_common_memory_NativeFunctionPointer_Class);
        de_ibapl_jnhw_common_memory_NativeFunctionPointer_nativeAddress_ID = NULL;
        de_ibapl_jnhw_common_memory_NativeFunctionPointer_init_ID = NULL;

        deleteGlobalRef(env, &de_ibapl_jnhw_common_nativecall_CallNative_I_V_Class);
        de_ibapl_jnhw_common_nativecall_CallNative_I_V_init_ID = NULL;
        deleteGlobalRef(env, &de_ibapl_jnhw_common_nativecall_CallNative_J_V_Class);
        de_ibapl_jnhw_common_nativecall_CallNative_J_V_init_ID = NULL;
        deleteGlobalRef(env, &de_ibapl_jnhw_common_nativecall_CallNative_IJ_V_Class);
        de_ibapl_jnhw_common_nativecall_CallNative_IJ_V_init_ID = NULL;
        deleteGlobalRef(env, &de_ibapl_jnhw_common_nativecall_CallNative_I_I_PtrAbstractNativeMemory_V_Class);
        de_ibapl_jnhw_common_nativecall_CallNative_I_I_PtrAbstractNativeMemory_V_init_ID = NULL;
        deleteGlobalRef(env, &de_ibapl_jnhw_common_nativecall_CallNative_I_PtrAbstractNativeMemory_PtrAbstractNativeMemory_V_Class);
        de_ibapl_jnhw_common_nativecall_CallNative_I_PtrAbstractNativeMemory_PtrAbstractNativeMemory_V_init_ID = NULL;
        deleteGlobalRef(env, &de_ibapl_jnhw_common_nativecall_CallNative_PtrAbstractNativeMemory_V_Class);
        de_ibapl_jnhw_common_nativecall_CallNative_PtrAbstractNativeMemory_V_init_ID = NULL;

        de_ibapl_jnhw_common_memory_PointerArray32_cachedReferences_ID = NULL;
    }

    JNIEXPORT jclass JNICALL getGlobalClassRef(JNIEnv *env, const char* className) {
        jclass clazz = (*env)->FindClass(env, className);
        if (clazz == NULL) {
            return NULL;
        }

        jclass result = (*env)->NewGlobalRef(env, clazz);
        (*env)->DeleteLocalRef(env, clazz);
        if (result == NULL) {
            throw_Exception(env, RUNTIME_EXCEPTION_CLASS_NAME, "Cant get global ref for %s", className);
            return NULL;
        }
        return result;

    }

    JNIEXPORT void JNICALL deleteGlobalRef(JNIEnv *env, jobject *classRef) {
        if (*classRef != NULL) {
            (*env)->DeleteGlobalRef(env, *classRef);
            *classRef = NULL;
        }
    }

    JNIEXPORT jfieldID JNICALL getFieldId(JNIEnv *env, const char* className, const char* fieldName, const char* fieldType) {

        jclass clazz = (*env)->FindClass(env, className);
        if (clazz == NULL) {
            return NULL;
        }

        jfieldID result = (*env)->GetFieldID(env, clazz, fieldName, fieldType);
        (*env)->DeleteLocalRef(env, clazz);
        return result;
    }

    JNIEXPORT jmethodID JNICALL getMethodId(JNIEnv *env, const char* className, const char* methodName, const char* methodSignature) {
        jclass clazz = (*env)->FindClass(env, className);
        if (clazz == NULL) {
            return NULL;
        }
        jmethodID result = (*env)->GetMethodID(env, clazz, methodName, methodSignature);
        (*env)->DeleteLocalRef(env, clazz);
        return result;
    }

    JNIEXPORT jfieldID JNICALL getFieldIdOfClassRef(JNIEnv *env, jclass clazz, const char* fieldName, const char* fieldType) {
        return (*env)->GetFieldID(env, clazz, fieldName, fieldType);
    }

    JNIEXPORT jmethodID JNICALL getMethodIdOfClassRef(JNIEnv *env, jclass clazz, const char* methodName, const char* methodSignature) {
        return (*env)->GetMethodID(env, clazz, methodName, methodSignature);
    }

    JNIEXPORT jmethodID JNICALL getStaticMethodIdOfClassRef(JNIEnv *env, jclass clazz, const char* methodName, const char* methodSignature) {
        return (*env)->GetStaticMethodID(env, clazz, methodName, methodSignature);
    }

    /*
     * Returns true if the array slice defined by the given offset and length
     * is out of bounds.
     */
    JNIEXPORT int outOfBoundsByteArray(JNIEnv *env, jint pos, jint len, jbyteArray array) {
        return ((pos < 0) ||
                (len < 0) ||
                // We are very careful to avoid signed integer overflow,
                // the result of which is undefined in C.
                ((*env)->GetArrayLength(env, array) - pos < len));
    }

    JNIEXPORT int outOfBoundsOpaqueMemory32(JNIEnv *env, jint pos, jint len, jobject opaqueMemory) {
        return (pos < 0) ||
                (len < 0) ||
                // We are very careful to avoid signed integer overflow,
                // the result of which is undefined in C.
                (SIZE_OF_OPAQUE_MEM_32(opaqueMemory) - pos < len);
    }

    JNIEXPORT int outOfBoundsOpaqueMemory64(JNIEnv *env, jlong pos, jlong len, jobject opaqueMemory) {
        return (pos < 0) ||
                (len < 0) ||
                // We are very careful to avoid signed integer overflow,
                // the result of which is undefined in C.
                (SIZE_OF_OPAQUE_MEM_64(opaqueMemory) - pos < len);
    }

    JNIEXPORT jint JNICALL
    JNI_OnLoad(JavaVM *jvm, __attribute__ ((unused)) void *reserved) {
        JNIEnv *env;
        if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_10)) {
            return JNI_ERR;
        }

        if (jnhw_common_init(env) == JNI_TRUE) {
            return JNI_VERSION_10;
        } else {
            return JNI_ERR;
        }
    }

    JNIEXPORT void JNICALL
    JNI_OnUnload(JavaVM *jvm, __attribute__ ((unused)) void *reserved) {
        JNIEnv *env;

        if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_10)) {
            jnhw_common_release(env);
            return;
        }

    }

#ifdef __cplusplus
}
#endif