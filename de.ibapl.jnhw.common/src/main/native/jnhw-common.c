/*
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
#define _JNHW_COMMON_IMPLEMENTATION_ 1
#include "jnhw-common.h"

#ifdef __cplusplus
extern "C" {
#endif

    JNIEXPORT jfieldID de_ibapl_jnhw_ByteRef_value_ID = NULL;
    JNIEXPORT jfieldID de_ibapl_jnhw_ShortRef_value_ID = NULL;
    JNIEXPORT jfieldID de_ibapl_jnhw_IntRef_value_ID = NULL;
    JNIEXPORT jfieldID de_ibapl_jnhw_LongRef_value_ID = NULL;
    JNIEXPORT jfieldID de_ibapl_jnhw_OpaqueMemory_baseAddress_ID = NULL;
    JNIEXPORT jfieldID de_ibapl_jnhw_OpaqueMemory_sizeInBytes_ID = NULL;
    JNIEXPORT jmethodID de_ibapl_jnhw_StructArray_length_ID = NULL;

    static jboolean  JNICALL jnhw_common_init(JNIEnv *env) {
         if (initExceptions(env) == JNI_FALSE) {
             return JNI_FALSE;
         }
        if (de_ibapl_jnhw_ByteRef_value_ID == NULL) {
            de_ibapl_jnhw_ByteRef_value_ID = getFieldId(env, JNHW_CLASS_NAME_BYTE_REF, "value", "B");
            if (de_ibapl_jnhw_ByteRef_value_ID == NULL) {
             return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_ShortRef_value_ID == NULL) {
            de_ibapl_jnhw_ShortRef_value_ID = getFieldId(env, JNHW_CLASS_NAME_SHORT_REF, "value", "S");
            if (de_ibapl_jnhw_ShortRef_value_ID == NULL) {
             return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_IntRef_value_ID == NULL) {
            de_ibapl_jnhw_IntRef_value_ID = getFieldId(env, JNHW_CLASS_NAME_INT_REF, "value", "I");
            if (de_ibapl_jnhw_IntRef_value_ID == NULL) {
             return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_LongRef_value_ID == NULL) {
            de_ibapl_jnhw_LongRef_value_ID = getFieldId(env, JNHW_CLASS_NAME_LONG_REF, "value", "J");
            if (de_ibapl_jnhw_LongRef_value_ID == NULL) {
             return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_OpaqueMemory_baseAddress_ID == NULL) {
            de_ibapl_jnhw_OpaqueMemory_baseAddress_ID = getFieldId(env, JNHW_CLASS_NAME_OPAQUE_MEMORY, "baseAddress", "J");
            if (de_ibapl_jnhw_OpaqueMemory_baseAddress_ID == NULL) {
             return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_OpaqueMemory_sizeInBytes_ID == NULL) {
            de_ibapl_jnhw_OpaqueMemory_sizeInBytes_ID = getFieldId(env, JNHW_CLASS_NAME_OPAQUE_MEMORY, "sizeInBytes", "I");
            if (de_ibapl_jnhw_OpaqueMemory_sizeInBytes_ID == NULL) {
             return JNI_FALSE;
            }
        }
        if (de_ibapl_jnhw_StructArray_length_ID == NULL) {
            de_ibapl_jnhw_StructArray_length_ID = getMethodId(env, JNHW_CLASS_NAME_STRUCT_ARRAY, "length", "()I");
            if (de_ibapl_jnhw_StructArray_length_ID == NULL) {
             return JNI_FALSE;
            }
        }
         return JNI_TRUE;
    }

    static void  JNICALL jnhw_common_release(JNIEnv *env) {
         releaseExceptions(env);
         
        de_ibapl_jnhw_ByteRef_value_ID = NULL;
        de_ibapl_jnhw_ShortRef_value_ID = NULL;
        de_ibapl_jnhw_IntRef_value_ID = NULL;
        de_ibapl_jnhw_LongRef_value_ID = NULL;
        de_ibapl_jnhw_OpaqueMemory_baseAddress_ID = NULL;
        de_ibapl_jnhw_OpaqueMemory_sizeInBytes_ID = NULL;
        de_ibapl_jnhw_StructArray_length_ID = NULL;
    }

    JNIEXPORT jclass JNICALL getGlobalClassRef(JNIEnv *env, const char* className) {
        jclass clazz = (*env)->FindClass(env, className);
        if (clazz == NULL) {
            return NULL;
        }

        jclass result = (*env)->NewGlobalRef(env, clazz);
        (*env)->DeleteLocalRef(env, clazz);
        if (result == NULL) {
            throwException(env, "java/lang/RuntimeException", "Cant get global ref for %s", className);
            return NULL;
        }
        return result;

    }

    JNIEXPORT void JNICALL deleteGlobalRef(JNIEnv *env, jobject classRef) {
        if (classRef != NULL) {
            (*env)->DeleteGlobalRef(env, classRef);
        }
    }

    JNIEXPORT jfieldID JNICALL getFieldId(JNIEnv *env, const char* className, const char* fieldName, const char* fieldType) {

        jclass clazz = (*env)->FindClass(env, className);
        if (clazz == NULL) {
            return NULL;
        }

        jfieldID result = (*env)->GetFieldID(env, clazz, fieldName, fieldType);
        (*env)->DeleteLocalRef(env, clazz);
        if (result == NULL) {
            return NULL;
        }
        return result;
    }

    JNIEXPORT jmethodID JNICALL getMethodId(JNIEnv *env, const char* className, const char* methodName, const char* methodSignature) {

        jclass clazz = (*env)->FindClass(env, className);
        if (clazz == NULL) {
            return NULL;
        }

        jmethodID result = (*env)->GetMethodID(env, clazz, methodName, methodSignature);
        (*env)->DeleteLocalRef(env, clazz);
        if (result == NULL) {
            return NULL;
        }
        return result;
    }

    JNIEXPORT jfieldID JNICALL getFieldIdOfClassRef(JNIEnv *env, jclass clazz, const char* fieldName, const char* fieldType) {

        jfieldID result = (*env)->GetFieldID(env, clazz, fieldName, fieldType);
        if (result == NULL) {
            return NULL;
        }
        return result;
    }

    JNIEXPORT jmethodID JNICALL getMethodIdOfClassRef(JNIEnv *env, jclass clazz, const char* methodName, const char* methodSignature) {

        jmethodID result = (*env)->GetMethodID(env, clazz, methodName, methodSignature);
        if (result == NULL) {
            return NULL;
        }
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

    JNIEXPORT int outOfBoundsOpaqueMemory(JNIEnv *env, jint pos, jint len, jobject opaqueMemory) {
        return ((pos < 0) ||
                (len < 0) ||
                // We are very careful to avoid signed integer overflow,
                // the result of which is undefined in C.
                ((*env)->GetIntField(env, opaqueMemory, de_ibapl_jnhw_OpaqueMemory_sizeInBytes_ID) - pos < len));
    }

        JNIEXPORT jint JNICALL
    JNI_OnLoad(JavaVM *jvm, void *reserved) {
        JNIEnv *env;
        if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_1_4)) {
            return JNI_ERR;
        }
        
        if (jnhw_common_init(env) == JNI_TRUE) {
            return JNI_VERSION_1_4;
        } else {
            return JNI_ERR;
        }
    }

    JNIEXPORT void JNICALL
    JNI_OnUnload(JavaVM *jvm, void *reserved) {
        JNIEnv *env;

        if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_1_4)) {
            jnhw_common_release(env);
            return;
        }

    }

#ifdef __cplusplus
}
#endif