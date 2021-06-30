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

#ifdef __cplusplus
extern "C" {
#endif
    /*
     * __GCR : global class reference
     * __FID : field ID
     * __MID : method ID
     */

    /*
     * only for tests - it is not optimized.
     */
    JNIEXPORT jobject JnhwWrapInteger(JNIEnv *env, jint value) {
        jclass intClass = (*env)->FindClass(env, "java/lang/Integer");
        if (intClass == NULL) {
            return NULL;
        }

        jmethodID mId = (*env)->GetStaticMethodID(env, intClass, "valueOf", "(I)Ljava/lang/Integer;");
        if (mId == NULL) {
            return NULL;
        }

        jobject o = (*env)->CallStaticObjectMethod(env, intClass, mId, value);
        if ((*env)->ExceptionCheck(env)) {
            return NULL;
        } else {
            return o;
        }
    }

    /*
     * only for tests - it is not optimized.
     */
    JNIEXPORT jobject JnhwWrapLong(JNIEnv *env, jlong value) {
        jclass longClass = (*env)->FindClass(env, "java/lang/Long");
        if (longClass == NULL) {
            return NULL;
        }

        jmethodID mId = (*env)->GetStaticMethodID(env, longClass, "valueOf", "(J)Ljava/lang/Long;");
        if (mId == NULL) {
            return NULL;
        }

        jobject o = (*env)->CallStaticObjectMethod(env, longClass, mId, value);
        if ((*env)->ExceptionCheck(env)) {
            return NULL;
        } else {
            return o;
        }
    }

    JNIEXPORT jint JNICALL
    JNI_OnLoad(JavaVM *jvm, __attribute__ ((unused)) void *reserved) {
        JNIEnv *env;
        if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_10)) {
            return JNI_ERR;
        }
        initExceptions(env);
        return JNI_VERSION_10;
    }

    JNIEXPORT void JNICALL
    JNI_OnUnload(JavaVM *jvm, __attribute__ ((unused)) void *reserved) {
        JNIEnv *env;

        if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_10)) {
            releaseExceptions(env);
            return;
        }

    }

#ifdef __cplusplus
}
#endif