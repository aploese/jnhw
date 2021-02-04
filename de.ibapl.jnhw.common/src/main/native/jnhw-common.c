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
#define dijc_r_ByteRef_CName   "de/ibapl/jnhw/common/references/ByteRef"
#define dijc_r_ShortRef_CName  "de/ibapl/jnhw/common/references/ShortRef"
#define dijc_r_IntRef_CName    "de/ibapl/jnhw/common/references/IntRef"
#define dijc_r_LongRef_CName   "de/ibapl/jnhw/common/references/LongRef"
#define dijc_r_ObjectRef_CName "de/ibapl/jnhw/common/references/ObjectRef"

#define dijc_u_IntDefine_CName "de/ibapl/jnhw/common/util/IntDefine"
#define dijc_u_IntDefine_CSig CLASS_NAME_TO_SIGNATURE(dijc_u_IntDefine_CName)

#define dijc_u_ObjectDefine_CName "de/ibapl/jnhw/common/util/ObjectDefine"
#define dijc_u_ObjectDefine_CSig CLASS_NAME_TO_SIGNATURE(dijc_u_ObjectDefine_CName)

#define dijc_m_AbstractNativeMemory_CName "de/ibapl/jnhw/common/memory/AbstractNativeMemory"

#define dijc_m_OpaqueMemory32_CName "de/ibapl/jnhw/common/memory/OpaqueMemory32"
#define dijc_m_OpaqueMemory32_CSig CLASS_NAME_TO_SIGNATURE(dijc_m_OpaqueMemory32_CName)

#define dijc_m_OpaqueMemory64_CName "de/ibapl/jnhw/common/memory/OpaqueMemory64"
#define dijc_m_StructArray32_CName "de/ibapl/jnhw/common/memory/StructArray32"
#define dijc_m_PointerArray32_CName "de/ibapl/jnhw/common/memory/PointerArray32"

#ifdef __cplusplus
extern "C" {
#endif
    /*
     * __GCR : global class reference
     * __FID : field ID
     * __MID : method ID
     */

    JNIEXPORT jfieldID dijc_r_ByteRef_value__FID = NULL;
    JNIEXPORT jfieldID dijc_r_ShortRef_value__FID = NULL;
    JNIEXPORT jfieldID dijc_r_IntRef_value__FID = NULL;
    JNIEXPORT jfieldID dijc_r_LongRef_value__FID = NULL;
    JNIEXPORT jfieldID dijc_r_ObjectRef_value__FID = NULL;
    JNIEXPORT jfieldID dijc_m_AbstractNativeMemory_baseAddress__FID = NULL;
    JNIEXPORT jfieldID dijc_m_OpaqueMemory32_sizeInBytes__FID = NULL;
    JNIEXPORT jfieldID dijc_m_OpaqueMemory64_sizeInBytes__FID = NULL;
    JNIEXPORT jmethodID dijc_m_StructArray32_length__MID = NULL;

    JNIEXPORT jclass dijc_m_NativeAddressHolder__GCR = NULL;
    JNIEXPORT jfieldID dijc_m_NativeAddressHolder_address__FID = NULL;
    JNIEXPORT jmethodID dijc_m_NativeAddressHolder_init__MID = NULL;

    jclass dijc_u_IntDefine__GCR = NULL;
    jfieldID dijc_u_IntDefine_UNDEFINED__FID = NULL;
    jmethodID dijc_u_IntDefine_toIntDefine__MID = NULL;
    jclass dijc_u_ObjectDefine__GCR = NULL;
    jfieldID dijc_u_ObjectDefine_UNDEFINED__FID = NULL;
    jmethodID dijc_u_ObjectDefine_toObjectDefine__MID = NULL;

    JNIEXPORT jclass dijc_m_NativeFunctionPointer__GCR = NULL;
    JNIEXPORT jclass dijc_np_FunctionPtr_I_V__GCR = NULL;
    JNIEXPORT jclass dijc_np_FunctionPtr_J_V__GCR = NULL;
    JNIEXPORT jclass dijc_np_FunctionPtr_IJ_V__GCR = NULL;
    JNIEXPORT jclass dijc_np_FunctionPtr_I_I_Mem_V__GCR = NULL;
    JNIEXPORT jclass dijc_np_FunctionPtr_I_Mem_Mem_V__GCR = NULL;
    JNIEXPORT jclass dijc_np_FunctionPtr_Mem_V__GCR = NULL;

    JNIEXPORT jfieldID dijc_m_NativeFunctionPointer_nativeAddress__FID = NULL;
    JNIEXPORT jmethodID dijc_m_NativeFunctionPointer_init__MID = NULL;
    JNIEXPORT jmethodID dijc_np_FunctionPtr_I_V_init__MID = NULL;
    JNIEXPORT jmethodID dijc_np_FunctionPtr_J_V_init__MID = NULL;
    JNIEXPORT jmethodID dijc_np_FunctionPtr_IJ_V_init__MID = NULL;
    JNIEXPORT jmethodID dijc_np_FunctionPtr_I_I_Mem_V_init__MID = NULL;
    JNIEXPORT jmethodID dijc_np_FunctionPtr_I_Mem_Mem_V_init__MID = NULL;
    JNIEXPORT jmethodID dijc_np_FunctionPtr_Mem_V_init__MID = NULL;

    JNIEXPORT jfieldID dijc_m_PointerArray32_cachedReferences__FID = NULL;

    JNIEXPORT jboolean JnhwSetStaticObjectField(JNIEnv *env, jclass clazz, const char * fieldClassSignature, const char * fieldName, jobject value) {
        jfieldID fid = (*env)->GetStaticFieldID(env, clazz, fieldName, fieldClassSignature);
        if (fid == NULL) {
            return JNI_TRUE;
        }
        (*env)->SetStaticObjectField(env, clazz, fid, value);
        return JNI_FALSE;
    }

    JNIEXPORT jboolean JnhwSetStaticIntField(JNIEnv *env, jclass clazz, const char * fieldName, jint value) {
        jfieldID fid = (*env)->GetStaticFieldID(env, clazz, fieldName, "I");
        if (fid == NULL) {
            return JNI_TRUE;
        }
        (*env)->SetStaticIntField(env, clazz, fid, value);
        return JNI_FALSE;
    }

    JNIEXPORT jboolean JnhwSetStaticLongField(JNIEnv *env, jclass clazz, const char * fieldName, jlong value) {
        jfieldID fid = (*env)->GetStaticFieldID(env, clazz, fieldName, "J");
        if (fid == NULL) {
            return JNI_TRUE;
        }
        (*env)->SetStaticLongField(env, clazz, fid, value);
        return JNI_FALSE;
    }

    JNIEXPORT jboolean JnhwSetStaticShortField(JNIEnv *env, jclass clazz, const char * fieldName, jshort value) {
        jfieldID fid = (*env)->GetStaticFieldID(env, clazz, fieldName, "S");
        if (fid == NULL) {
            return JNI_TRUE;
        }
        (*env)->SetStaticShortField(env, clazz, fid, value);
        return JNI_FALSE;
    }

    JNIEXPORT jboolean JnhwSetStaticByteField(JNIEnv *env, jclass clazz, const char * fieldName, jbyte value) {
        jfieldID fid = (*env)->GetStaticFieldID(env, clazz, fieldName, "B");
        if (fid == NULL) {
            return JNI_TRUE;
        }
        (*env)->SetStaticByteField(env, clazz, fid, value);
        return JNI_FALSE;
    }

    JNIEXPORT jboolean JnhwSetStaticBooleanField(JNIEnv *env, jclass clazz, const char * fieldName, jboolean value) {
        jfieldID fid = (*env)->GetStaticFieldID(env, clazz, fieldName, "Z");
        if (fid == NULL) {
            return JNI_TRUE;
        }
        (*env)->SetStaticBooleanField(env, clazz, fid, value);
        return JNI_FALSE;
    }

    JNIEXPORT jboolean JnhwSetStaticObjectDefineField(JNIEnv *env, jclass clazz, const char * fieldName, jobject value) {
        jfieldID fid = (*env)->GetStaticFieldID(env, clazz, fieldName, dijc_u_ObjectDefine_CSig);
        if (fid == NULL) {
            return JNI_TRUE;
        }
        jobject _value = (*env)->CallStaticObjectMethod(env, clazz, dijc_u_ObjectDefine_toObjectDefine__MID, value);
        (*env)->SetStaticObjectField(env, clazz, fid, _value);
        return JNI_FALSE;
    }

    JNIEXPORT jboolean JnhwSetStaticIntDefineField(JNIEnv *env, jclass clazz, const char * fieldName, jint value) {
        jfieldID fid = (*env)->GetStaticFieldID(env, clazz, fieldName, dijc_u_IntDefine_CSig);
        if (fid == NULL) {
            return JNI_TRUE;
        }
        jobject _value = (*env)->CallStaticObjectMethod(env, clazz, dijc_u_IntDefine_toIntDefine__MID, value);
        (*env)->SetStaticObjectField(env, clazz, fid, _value);
        return JNI_FALSE;
    }

    static jboolean JNICALL jnhw_common_init(JNIEnv *env) {
        if (initExceptions(env) == JNI_FALSE) {
            return JNI_FALSE;
        }
        if (dijc_r_ByteRef_value__FID == NULL) {
            dijc_r_ByteRef_value__FID = getFieldId(env, dijc_r_ByteRef_CName, "value", "B");
            if (dijc_r_ByteRef_value__FID == NULL) {
                return JNI_FALSE;
            }
        }
        if (dijc_r_ShortRef_value__FID == NULL) {
            dijc_r_ShortRef_value__FID = getFieldId(env, dijc_r_ShortRef_CName, "value", "S");
            if (dijc_r_ShortRef_value__FID == NULL) {
                return JNI_FALSE;
            }
        }
        if (dijc_r_IntRef_value__FID == NULL) {
            dijc_r_IntRef_value__FID = getFieldId(env, dijc_r_IntRef_CName, "value", "I");
            if (dijc_r_IntRef_value__FID == NULL) {
                return JNI_FALSE;
            }
        }
        if (dijc_r_LongRef_value__FID == NULL) {
            dijc_r_LongRef_value__FID = getFieldId(env, dijc_r_LongRef_CName, "value", "J");
            if (dijc_r_LongRef_value__FID == NULL) {
                return JNI_FALSE;
            }
        }
        if (dijc_r_ObjectRef_value__FID == NULL) {
            dijc_r_ObjectRef_value__FID = getFieldId(env, dijc_r_ObjectRef_CName, "value", "Ljava/lang/Object;");
            if (dijc_r_ObjectRef_value__FID == NULL) {
                return JNI_FALSE;
            }
        }
        if (dijc_m_AbstractNativeMemory_baseAddress__FID == NULL) {
            dijc_m_AbstractNativeMemory_baseAddress__FID = getFieldId(env, dijc_m_AbstractNativeMemory_CName, "baseAddress", "J");
            if (dijc_m_AbstractNativeMemory_baseAddress__FID == NULL) {
                return JNI_FALSE;
            }
        }
        if (dijc_m_OpaqueMemory32_sizeInBytes__FID == NULL) {
            dijc_m_OpaqueMemory32_sizeInBytes__FID = getFieldId(env, dijc_m_OpaqueMemory32_CName, "sizeInBytes", "I");
            if (dijc_m_OpaqueMemory32_sizeInBytes__FID == NULL) {
                return JNI_FALSE;
            }
        }
        if (dijc_m_OpaqueMemory64_sizeInBytes__FID == NULL) {
            dijc_m_OpaqueMemory64_sizeInBytes__FID = getFieldId(env, dijc_m_OpaqueMemory64_CName, "sizeInBytes", "J");
            if (dijc_m_OpaqueMemory64_sizeInBytes__FID == NULL) {
                return JNI_FALSE;
            }
        }
        //TODO use array ???
        if (dijc_m_StructArray32_length__MID == NULL) {
            dijc_m_StructArray32_length__MID = getMethodId(env, dijc_m_StructArray32_CName, "length", "()I");
            if (dijc_m_StructArray32_length__MID == NULL) {
                return JNI_FALSE;
            }
        }

        if (dijc_m_PointerArray32_cachedReferences__FID == NULL) {
            dijc_m_PointerArray32_cachedReferences__FID = getFieldId(env, dijc_m_PointerArray32_CName, "cachedReferences", "["dijc_m_OpaqueMemory32_CSig);
            if (dijc_m_PointerArray32_cachedReferences__FID == NULL) {
                return JNI_FALSE;
            }
        }

        if (dijc_m_NativeAddressHolder__GCR == NULL) {
            dijc_m_NativeAddressHolder__GCR = getGlobalClassRef(env, dijc_m_NativeAddressHolder_CName);
            if (dijc_m_NativeAddressHolder__GCR == NULL) {
                return JNI_FALSE;
            }
        }
        if (dijc_m_NativeAddressHolder_init__MID == NULL) {
            dijc_m_NativeAddressHolder_init__MID = (*env)->GetMethodID(env, dijc_m_NativeAddressHolder__GCR, "<init>", "(J)V");
            if (dijc_m_NativeAddressHolder_init__MID == NULL) {
                return JNI_FALSE;
            }
        }
        if (dijc_m_NativeAddressHolder_address__FID == NULL) {
            dijc_m_NativeAddressHolder_address__FID = (*env)->GetFieldID(env, dijc_m_NativeAddressHolder__GCR, "address", "J");
            if (dijc_m_NativeAddressHolder_address__FID == NULL) {
                return JNI_FALSE;
            }
        }

        if (dijc_m_NativeFunctionPointer__GCR == NULL) {
            dijc_m_NativeFunctionPointer__GCR = getGlobalClassRef(env, dijc_m_NativeFunctionPointer_CName);
            if (dijc_m_NativeFunctionPointer__GCR == NULL) {
                return JNI_FALSE;
            }
        }
        if (dijc_m_NativeFunctionPointer_init__MID == NULL) {
            dijc_m_NativeFunctionPointer_init__MID = (*env)->GetMethodID(env, dijc_m_NativeFunctionPointer__GCR, "<init>", "(J)V");
            if (dijc_m_NativeFunctionPointer_init__MID == NULL) {
                return JNI_FALSE;
            }
        }
        if (dijc_m_NativeFunctionPointer_nativeAddress__FID == NULL) {
            dijc_m_NativeFunctionPointer_nativeAddress__FID = (*env)->GetFieldID(env, dijc_m_NativeFunctionPointer__GCR, "nativeAddress", "J");
            if (dijc_m_NativeFunctionPointer_nativeAddress__FID == NULL) {
                return JNI_FALSE;
            }
        }

        if (dijc_np_FunctionPtr_I_V__GCR == NULL) {
            dijc_np_FunctionPtr_I_V__GCR = getGlobalClassRef(env, dijc_np_FunctionPtr_I_V_CName);
            if (dijc_np_FunctionPtr_I_V__GCR == NULL) {
                return JNI_FALSE;
            }
        }
        if (dijc_np_FunctionPtr_I_V_init__MID == NULL) {
            dijc_np_FunctionPtr_I_V_init__MID = (*env)->GetMethodID(env, dijc_np_FunctionPtr_I_V__GCR, "<init>", "(J)V");
            if (dijc_np_FunctionPtr_I_V_init__MID == NULL) {
                return JNI_FALSE;
            }
        }

        if (dijc_np_FunctionPtr_J_V__GCR == NULL) {
            dijc_np_FunctionPtr_J_V__GCR = getGlobalClassRef(env, dijc_np_FunctionPtr_J_V_CName);
            if (dijc_np_FunctionPtr_J_V__GCR == NULL) {
                return JNI_FALSE;
            }
        }
        if (dijc_np_FunctionPtr_J_V_init__MID == NULL) {
            dijc_np_FunctionPtr_J_V_init__MID = (*env)->GetMethodID(env, dijc_np_FunctionPtr_J_V__GCR, "<init>", "(J)V");
            if (dijc_np_FunctionPtr_J_V_init__MID == NULL) {
                return JNI_FALSE;
            }
        }

        if (dijc_np_FunctionPtr_IJ_V__GCR == NULL) {
            dijc_np_FunctionPtr_IJ_V__GCR = getGlobalClassRef(env, dijc_np_FunctionPtr_IJ_V_CName);
            if (dijc_np_FunctionPtr_IJ_V__GCR == NULL) {
                return JNI_FALSE;
            }
        }
        if (dijc_np_FunctionPtr_IJ_V_init__MID == NULL) {
            dijc_np_FunctionPtr_IJ_V_init__MID = (*env)->GetMethodID(env, dijc_np_FunctionPtr_IJ_V__GCR, "<init>", "(J)V");
            if (dijc_np_FunctionPtr_IJ_V_init__MID == NULL) {
                return JNI_FALSE;
            }
        }

        if (dijc_np_FunctionPtr_I_I_Mem_V__GCR == NULL) {
            dijc_np_FunctionPtr_I_I_Mem_V__GCR = getGlobalClassRef(env, dijc_np_FunctionPtr_I_I_Mem_V_CName);
            if (dijc_np_FunctionPtr_I_I_Mem_V__GCR == NULL) {
                return JNI_FALSE;
            }
        }
        if (dijc_np_FunctionPtr_I_I_Mem_V_init__MID == NULL) {
            dijc_np_FunctionPtr_I_I_Mem_V_init__MID = (*env)->GetMethodID(env, dijc_np_FunctionPtr_I_I_Mem_V__GCR, "<init>", "(J)V");
            if (dijc_np_FunctionPtr_I_I_Mem_V_init__MID == NULL) {
                return JNI_FALSE;
            }
        }

        if (dijc_np_FunctionPtr_I_Mem_Mem_V__GCR == NULL) {
            dijc_np_FunctionPtr_I_Mem_Mem_V__GCR = getGlobalClassRef(env, dijc_np_FunctionPtr_I_Mem_Mem_V_CName);
            if (dijc_np_FunctionPtr_I_Mem_Mem_V__GCR == NULL) {
                return JNI_FALSE;
            }
        }
        if (dijc_np_FunctionPtr_I_Mem_Mem_V_init__MID == NULL) {
            dijc_np_FunctionPtr_I_Mem_Mem_V_init__MID = (*env)->GetMethodID(env, dijc_np_FunctionPtr_I_Mem_Mem_V__GCR, "<init>", "(J)V");
            if (dijc_np_FunctionPtr_I_Mem_Mem_V_init__MID == NULL) {
                return JNI_FALSE;
            }
        }

        if (dijc_np_FunctionPtr_Mem_V__GCR == NULL) {
            dijc_np_FunctionPtr_Mem_V__GCR = getGlobalClassRef(env, dijc_np_FunctionPtr_Mem_V_CName);
            if (dijc_np_FunctionPtr_Mem_V__GCR == NULL) {
                return JNI_FALSE;
            }
        }
        if (dijc_np_FunctionPtr_Mem_V_init__MID == NULL) {
            dijc_np_FunctionPtr_Mem_V_init__MID = (*env)->GetMethodID(env, dijc_np_FunctionPtr_Mem_V__GCR, "<init>", "(J)V");
            if (dijc_np_FunctionPtr_Mem_V_init__MID == NULL) {
                return JNI_FALSE;
            }
        }

        if (dijc_u_IntDefine__GCR == NULL) {
            dijc_u_IntDefine__GCR = getGlobalClassRef(env, dijc_u_IntDefine_CName);
            if (dijc_u_IntDefine__GCR == NULL) {
                return JNI_FALSE;
            }
        }

        if (dijc_u_IntDefine_UNDEFINED__FID == NULL) {
            dijc_u_IntDefine_UNDEFINED__FID = (*env)->GetStaticFieldID(env, dijc_u_IntDefine__GCR, "UNDEFINED", dijc_u_IntDefine_CSig);
            if (dijc_u_IntDefine_UNDEFINED__FID == NULL) {
                return JNI_FALSE;
            }
        }

        if (dijc_u_IntDefine_toIntDefine__MID == NULL) {
            dijc_u_IntDefine_toIntDefine__MID = (*env)->GetStaticMethodID(env, dijc_u_IntDefine__GCR, "toIntDefine", "(I)"dijc_u_IntDefine_CSig);
            if (dijc_u_IntDefine_toIntDefine__MID == NULL) {
                return JNI_FALSE;
            }
        }

        if (dijc_u_ObjectDefine__GCR == NULL) {
            dijc_u_ObjectDefine__GCR = getGlobalClassRef(env, dijc_u_ObjectDefine_CName);
            if (dijc_u_ObjectDefine__GCR == NULL) {
                return JNI_FALSE;
            }
        }

        if (dijc_u_ObjectDefine_UNDEFINED__FID == NULL) {
            dijc_u_ObjectDefine_UNDEFINED__FID = (*env)->GetStaticFieldID(env, dijc_u_ObjectDefine__GCR, "UNDEFINED", dijc_u_ObjectDefine_CSig);
            if (dijc_u_ObjectDefine_UNDEFINED__FID == NULL) {
                return JNI_FALSE;
            }
        }

        if (dijc_u_ObjectDefine_toObjectDefine__MID == NULL) {
            dijc_u_ObjectDefine_toObjectDefine__MID = (*env)->GetStaticMethodID(env, dijc_u_ObjectDefine__GCR, "toObjectDefine", "(Ljava/lang/Object;)"dijc_u_ObjectDefine_CSig);
            if (dijc_u_ObjectDefine_toObjectDefine__MID == NULL) {
                return JNI_FALSE;
            }
        }

        return JNI_TRUE;
    }

    static void JNICALL jnhw_common_release(JNIEnv *env) {
        releaseExceptions(env);

        dijc_r_ByteRef_value__FID = NULL;
        dijc_r_ShortRef_value__FID = NULL;
        dijc_r_IntRef_value__FID = NULL;
        dijc_r_LongRef_value__FID = NULL;
        dijc_r_ObjectRef_value__FID = NULL;
        dijc_m_AbstractNativeMemory_baseAddress__FID = NULL;
        dijc_m_OpaqueMemory32_sizeInBytes__FID = NULL;
        dijc_m_OpaqueMemory64_sizeInBytes__FID = NULL;
        dijc_m_StructArray32_length__MID = NULL;

        deleteGlobalRef(env, &dijc_m_NativeAddressHolder__GCR);
        dijc_m_NativeAddressHolder_address__FID = NULL;
        dijc_m_NativeAddressHolder_init__MID = NULL;

        deleteGlobalRef(env, &dijc_m_NativeFunctionPointer__GCR);
        dijc_m_NativeFunctionPointer_nativeAddress__FID = NULL;
        dijc_m_NativeFunctionPointer_init__MID = NULL;

        deleteGlobalRef(env, &dijc_np_FunctionPtr_I_V__GCR);
        dijc_np_FunctionPtr_I_V_init__MID = NULL;
        deleteGlobalRef(env, &dijc_np_FunctionPtr_J_V__GCR);
        dijc_np_FunctionPtr_J_V_init__MID = NULL;
        deleteGlobalRef(env, &dijc_np_FunctionPtr_IJ_V__GCR);
        dijc_np_FunctionPtr_IJ_V_init__MID = NULL;
        deleteGlobalRef(env, &dijc_np_FunctionPtr_I_I_Mem_V__GCR);
        dijc_np_FunctionPtr_I_I_Mem_V_init__MID = NULL;
        deleteGlobalRef(env, &dijc_np_FunctionPtr_I_Mem_Mem_V__GCR);
        dijc_np_FunctionPtr_I_Mem_Mem_V_init__MID = NULL;
        deleteGlobalRef(env, &dijc_np_FunctionPtr_Mem_V__GCR);
        dijc_np_FunctionPtr_Mem_V_init__MID = NULL;

        dijc_m_PointerArray32_cachedReferences__FID = NULL;

        deleteGlobalRef(env, &dijc_u_IntDefine__GCR);
        dijc_u_IntDefine_toIntDefine__MID = NULL;
        dijc_u_IntDefine_UNDEFINED__FID = NULL;
        deleteGlobalRef(env, &dijc_u_ObjectDefine__GCR);
        dijc_u_ObjectDefine_toObjectDefine__MID = NULL;
        dijc_u_ObjectDefine_UNDEFINED__FID = NULL;

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