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

#ifndef JnhwExceptions_H
#define JnhwExceptions_H

#ifdef __cplusplus
extern "C" {
#endif

#define RUNTIME_EXCEPTION_CLASS_NAME "java/lang/RuntimeException"
#define OUT_OF_MEMORY_ERROR_CLASS_NAME "java/lang/OutOfMemoryError"

    //Cached Exceptions
    _JNHW_IMPORT_OR_EXPORT_ extern void JNICALL throw_NativeErrorException(JNIEnv* env, int errorNumber);

    _JNHW_IMPORT_OR_EXPORT_ extern void JNICALL throw_NoSuchNativeMethodException(JNIEnv* env, const char* methodName);

    _JNHW_IMPORT_OR_EXPORT_ extern void JNICALL throw_NoSuchNativeTypeMemberException(JNIEnv* env, const char* type, const char* member);

    _JNHW_IMPORT_OR_EXPORT_ extern void JNICALL throw_NoSuchNativeTypeException(JNIEnv* env, const char* type);

    _JNHW_IMPORT_OR_EXPORT_ extern void JNICALL throw_NullPointerException(JNIEnv* env, const char* message);

    _JNHW_IMPORT_OR_EXPORT_ extern void JNICALL throw_ArrayIndexOutOfBoundsException(JNIEnv* env, const char* message);

    _JNHW_IMPORT_OR_EXPORT_ extern void JNICALL throw_IndexOutOfBoundsException(JNIEnv* env, const char* message);

    _JNHW_IMPORT_OR_EXPORT_ extern void JNICALL throw_IllegalArgumentException(JNIEnv* env, const char* message);

    _JNHW_IMPORT_OR_EXPORT_ extern void JNICALL throw_RuntimeException(JNIEnv* env, const char* fmt, ...);

    _JNHW_IMPORT_OR_EXPORT_ extern void JNICALL throw_Exception(JNIEnv* env, const char* exceptionName, const char* fmt, ...);



#ifdef _JNHW_COMMON_IMPLEMENTATION_

    jboolean initExceptions(JNIEnv* env);

    void releaseExceptions(JNIEnv* env);

#endif

#ifdef __cplusplus
}
#endif

#endif