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


    /* TODO move to test...
     */
    _JNHW_IMPORT_OR_EXPORT_ extern jobject JnhwWrapInteger(JNIEnv *env, jint value);
    _JNHW_IMPORT_OR_EXPORT_ extern jobject JnhwWrapLong(JNIEnv *env, jlong value);

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
    //Unix 64 bit pointer
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

#define JNHW_FORMAT_STRING_HEX_uintptr_t "0x%016lx"
#define JNHW_FORMAT_STRING_HEX_intptr_t "0x%016lx"

#elif defined(__WIN64)
    //Win 64 bit pointer
#define JNHW_FORMAT_STRING_int64_t "%lld"
#define JNHW_FORMAT_STRING_uint64_t "%llu"
#define JNHW_FORMAT_STRING_HEX_int64_t "0x%016llx"
#define JNHW_FORMAT_STRING_HEX_uint64_t "0x%016llx"
#define JNHW_FORMAT_STRING_HEX_uintptr_t "0x%016llx"
#define JNHW_FORMAT_STRING_HEX_intptr_t "0x%016llx"
#else
    // 32 bit pointer
#define JNHW_FORMAT_STRING_int64_t "%lld"
#define JNHW_FORMAT_STRING_uint64_t "%llu"
#define JNHW_FORMAT_STRING_HEX_int64_t "0x%016llx"
#define JNHW_FORMAT_STRING_HEX_uint64_t "0x%016llx"
#define JNHW_FORMAT_STRING_HEX_uintptr_t "0x%08x"
#define JNHW_FORMAT_STRING_HEX_intptr_t "0x%08x"
#endif

#ifdef __cplusplus
}
#endif

#endif
