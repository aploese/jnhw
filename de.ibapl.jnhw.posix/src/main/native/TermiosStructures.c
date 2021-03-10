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
#include "jnhw-posix.h"
#include "de_ibapl_jnhw_posix_Termios_StructTermios.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION
#include <termios.h>

    //for offsetof
#include <stddef.h>

    JNHW_ASSERT__tcflag_t__IS__uint32_t
    JNHW_ASSERT__cc_t__IS__uint8_t


    /*
     * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/posix/Termios/StructTermios/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_native2Layout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (struct termios), __alignof__ (struct termios));
        if (result == NULL) {
            return NULL;
        }
        if (JnhwSetLongField(env, result, "c_iflag", offsetof(struct termios, c_iflag))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "c_oflag", offsetof(struct termios, c_oflag))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "c_cflag", offsetof(struct termios, c_cflag))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "c_lflag", offsetof(struct termios, c_lflag))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "c_cc", offsetof(struct termios, c_cc))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "c_line", offsetof(struct termios, c_line))) {
            return result;
        }
#if (defined(_HAVE_STRUCT_TERMIOS_C_ISPEED) && _HAVE_STRUCT_TERMIOS_C_ISPEED != 0) || defined(__APPLE__) || defined(__FreeBSD__)
        if (JnhwSetLongField(env, result, "c_ispeed", offsetof(struct termios, c_ispeed))) {
            return result;
        }
#endif
#if (defined(_HAVE_STRUCT_TERMIOS_C_OSPEED) && _HAVE_STRUCT_TERMIOS_C_OSPEED != 0) || defined(__APPLE__) || defined(__FreeBSD__)
        if (JnhwSetLongField(env, result, "c_ospeed", offsetof(struct termios, c_ospeed))) {
            return result;
        }
#endif
        return result;
    }


#endif
#ifdef __cplusplus
}
#endif
