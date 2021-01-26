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


#if HAVE_UCONTEXT_H
#include <ucontext.h>
#endif

#ifdef _POSIX_VERSION

#include "de_ibapl_jnhw_x_open_Ucontext.h"
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_x_open_Ucontext
     * Method:    getcontext
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Ucontext_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_x_1open_Ucontext_getcontext
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject ucp) {
        if (ucp == NULL) {
            throw_NullPointerException(env, "ucp is NULL");
            return;
        }
        if (getcontext(UNWRAP_STRUCT_UCONTEXT_T_PTR(ucp))) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_x_open_Ucontext
     * Method:    setcontext
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Ucontext_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_x_1open_Ucontext_setcontext
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject ucp) {
        if (ucp == NULL) {
            throw_NullPointerException(env, "ucp is NULL");
            return;
        }
        if (setcontext(UNWRAP_STRUCT_UCONTEXT_T_PTR(ucp))) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_x_open_Ucontext
     * Method:    swapcontext
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Ucontext_t;Lde/ibapl/jnhw/posix/Signal/Ucontext_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_x_1open_Ucontext_swapcontext
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject oucp, jobject ucp) {
        if (oucp == NULL) {
            throw_NullPointerException(env, "oucp is NULL");
            return;
        }
        if (ucp == NULL) {
            throw_NullPointerException(env, "ucp is NULL");
            return;
        }
        if (swapcontext(UNWRAP_STRUCT_UCONTEXT_T_PTR(oucp), UNWRAP_STRUCT_UCONTEXT_T_PTR(ucp))) {
            throw_NativeErrorException(env, errno);
        }
    }

#ifdef __cplusplus
}
#endif
#endif