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
#include "de_ibapl_jnhw_common_memory_Int16_t.h"

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_common_memory_NativeIntNumber
 * Method:    nativeInt8ToHexString
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_NativeIntNumber_nativeInt8ToHexString
    (JNIEnv *env, jobject nativeIntNumber) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, "%02x", 0x00FF & *UNWRAP_OPAQUE_MEM_TO(uint8_t*, nativeIntNumber));
        return (*env)->NewStringUTF(env, buf);
    }


/*
 * Class:     de_ibapl_jnhw_common_memory_NativeIntNumber
 * Method:    nativeInt16ToHexString
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_NativeIntNumber_nativeInt16ToHexString
    (JNIEnv *env, jobject nativeIntNumber) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, "%04x", 0x0000FFFF & *UNWRAP_OPAQUE_MEM_TO(uint16_t*, nativeIntNumber));
        return (*env)->NewStringUTF(env, buf);
    }

/*
 * Class:     de_ibapl_jnhw_common_memory_NativeIntNumber
 * Method:    nativeInt32ToHexString
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_NativeIntNumber_nativeInt32ToHexString
    (JNIEnv *env, jobject nativeIntNumber) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, "%08x", *UNWRAP_OPAQUE_MEM_TO(uint32_t*, nativeIntNumber));
        return (*env)->NewStringUTF(env, buf);
    }


/*
 * Class:     de_ibapl_jnhw_common_memory_NativeIntNumber
 * Method:    nativeInt64ToHexString
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_NativeIntNumber_nativeInt64ToHexString
    (JNIEnv *env, jobject nativeIntNumber) {
        char buf[128] = {0};
#if defined(__LP64__) 
  #if defined(__OpenBSD__)
        snprintf(buf, sizeof (buf) - 1, "%016llx", *UNWRAP_OPAQUE_MEM_TO(uint64_t*, nativeIntNumber));
  #else
        snprintf(buf, sizeof (buf) - 1, "%016lx", *UNWRAP_OPAQUE_MEM_TO(uint64_t*, nativeIntNumber));
  #endif
#elif defined(__WIN64)
        snprintf(buf, sizeof (buf) - 1, "%016I64x", *UNWRAP_OPAQUE_MEM_TO(uint64_t*, nativeIntNumber));
#else
        snprintf(buf, sizeof (buf) - 1, "%016llx", *UNWRAP_OPAQUE_MEM_TO(uint64_t*, nativeIntNumber));
#endif
        return (*env)->NewStringUTF(env, buf);
    }




#ifdef __cplusplus
}
#endif
