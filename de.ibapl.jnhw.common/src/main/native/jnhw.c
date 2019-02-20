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
#include "jnhw.h"
#include "JnhwExceptions.h"

#ifdef __cplusplus
extern "C" {
#endif

    JNIEXPORT jfieldID de_ibapl_jnhw_ByteRef_value_ID = NULL;
    JNIEXPORT jfieldID de_ibapl_jnhw_ShortRef_value_ID = NULL;
    JNIEXPORT jfieldID de_ibapl_jnhw_IntRef_value_ID = NULL;
    JNIEXPORT jfieldID de_ibapl_jnhw_LongRef_value_ID = NULL;

    JNIEXPORT void JNICALL jnhw_common_init(JNIEnv *env) {
        initExceptions(env);
        if (de_ibapl_jnhw_ByteRef_value_ID == NULL) {
            de_ibapl_jnhw_ByteRef_value_ID = getFieldId(env, JNHW_CLASS_NAME_BYTE_REF, "value", "B");
        }
        if (de_ibapl_jnhw_ShortRef_value_ID == NULL) {
            de_ibapl_jnhw_ShortRef_value_ID = getFieldId(env, JNHW_CLASS_NAME_SHORT_REF, "value", "S");
        }
        if (de_ibapl_jnhw_IntRef_value_ID == NULL) {
            de_ibapl_jnhw_IntRef_value_ID = getFieldId(env, JNHW_CLASS_NAME_INT_REF, "value", "I");
        }
        if (de_ibapl_jnhw_LongRef_value_ID == NULL) {
            de_ibapl_jnhw_LongRef_value_ID = getFieldId(env, JNHW_CLASS_NAME_LONG_REF, "value", "J");
        }
    }

    JNIEXPORT jclass JNICALL getGlobalClassRef(JNIEnv *env, const char* className) {
        jclass clazz = (*env)->FindClass(env, className);
        if (clazz == NULL) {
            throw_ClassNotFoundException(env, className);
            return NULL;
        }
        jclass result = (*env)->NewGlobalRef(env, clazz);
        (*env)->DeleteLocalRef(env, clazz);
        if (result == NULL) {
            //TODO what ex to throw???
            throw_ClassNotFoundException(env, className);
        }
        return result;

    }

    JNIEXPORT jfieldID JNICALL getFieldId(JNIEnv *env, const char* className, const char* fieldName, const char* fieldType) {

        jclass clazz = (*env)->FindClass(env, className);
        if (clazz == NULL) {
            throw_ClassNotFoundException(env, className);
            return NULL;
        }

        jfieldID result = (*env)->GetFieldID(env, clazz, fieldName, fieldType);
        (*env)->DeleteLocalRef(env, clazz);
        if (result == NULL) {
            throw_NoSuchFieldException(env, className, fieldName, fieldType);
            return NULL;
        }
        return result;
    }

    JNIEXPORT jfieldID JNICALL getFieldIdOfClassRef(JNIEnv *env, jclass clazz, const char* className, const char* fieldName, const char* fieldType) {

        jfieldID result = (*env)->GetFieldID(env, clazz, fieldName, fieldType);
        if (result == NULL) {
            throw_NoSuchFieldException(env, className, fieldName, fieldName);
            return NULL;
        }
        return result;
    }

    JNIEXPORT jmethodID JNICALL getMethodIdOfClassRef(JNIEnv *env, jclass clazz, const char* className, const char* methodName, const char* methodSignature) {

        jmethodID result = (*env)->GetMethodID(env, clazz, methodName, methodSignature);
        if (result == NULL) {
            throw_NoSuchMethodException(env, className, methodName, methodSignature);
            return NULL;
        }
        return result;
    }
#ifdef __cplusplus
}
#endif