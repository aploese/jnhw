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
#include "de_ibapl_jnhw_unix_sys_Ioctl.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifndef HAVE_SYS_IOCTL_H

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else
#include <sys/ioctl.h>

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_SYS_IOCTL_H", JNI_TRUE)) {
            return;
        }

#if defined(__linux__) && defined(__sh__) 
        if (JnhwSetStaticIntField(env, clazz, "FIONREAD", (int32_t) FIONREAD)) {
            return;
        }
#else
        if (JnhwSetStaticIntField(env, clazz, "FIONREAD", FIONREAD)) {
            return;
        }
#endif        

        if (JnhwSetStaticIntField(env, clazz, "TIOCM_LE", TIOCM_LE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_ST", TIOCM_ST)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_SR", TIOCM_SR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_CTS", TIOCM_CTS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_DTR", TIOCM_DTR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_CAR", TIOCM_CAR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_CD", TIOCM_CD)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_RTS", TIOCM_RTS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_RNG", TIOCM_RNG)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_RI", TIOCM_RI)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCM_DSR", TIOCM_DSR)) {
            return;
        }

#if defined (__linux__) 
        if (JnhwSetStaticIntDefineField(env, clazz, "TIOCMIWAIT", TIOCMIWAIT)) {
            return;
        }
#elif defined(TIOCMIWAIT)
#error "TIOCMIWAIT defined"
#else
#endif

#if defined (__linux__) 
        if (JnhwSetStaticIntDefineField(env, clazz, "TIOCGICOUNT", TIOCGICOUNT)) {
            return;
        }
#elif defined(TIOCGICOUNT)
#error "TIOCGICOUNT defined"
#else
#endif

#if defined (__linux__) 
#if defined(__sh__) 
        if (JnhwSetStaticIntDefineField(env, clazz, "TIOCGSOFTCAR", (int32_t) TIOCGSOFTCAR)) {
            return;
        }
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "TIOCGSOFTCAR", TIOCGSOFTCAR)) {
            return;
        }
#endif        
#elif defined(TIOCGSOFTCAR)
#error "TIOCGSOFTCAR defined"
#else
#endif

#if defined (__linux__) 
#if defined(__sparc__)
        if (JnhwSetStaticIntDefineField(env, clazz, "TIOCSSOFTCAR", (int32_t) TIOCSSOFTCAR)) {
            return;
        }
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "TIOCSSOFTCAR", TIOCSSOFTCAR)) {
            return;
        }
#endif
#elif defined(TIOCSSOFTCAR)
#error "TIOCSSOFTCAR defined"
#else
#endif

        if (JnhwSetStaticIntField(env, clazz, "TIOCEXCL", TIOCEXCL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCSBRK", TIOCSBRK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIOCCBRK", TIOCCBRK)) {
            return;
        }

#if defined(__linux__) && defined(__sh__) 
        if (JnhwSetStaticIntField(env, clazz, "TIOCMGET", (int32_t) TIOCMGET)) {
            return;
        }
#else
        if (JnhwSetStaticIntField(env, clazz, "TIOCMGET", TIOCMGET)) {
            return;
        }
#endif        

#if defined(__APPLE__) || defined (__FreeBSD__) || defined (__OpenBSD__) || (defined(__linux__) && defined(__sparc__))
        //Just force the conversation or check at runtime sizeof??
        if (JnhwSetStaticIntField(env, clazz, "TIOCMSET", (int32_t) TIOCMSET)) {
            return;
        }
#else
        if (JnhwSetStaticIntField(env, clazz, "TIOCMSET", TIOCMSET)) {
            return;
        }
#endif

#if defined(__APPLE__) || defined (__FreeBSD__) || defined (__OpenBSD__) || (defined(__linux__) && defined(__sparc__))
        //Just force the conversation or check at runtime sizeof??
        if (JnhwSetStaticIntField(env, clazz, "TIOCMBIC", (int32_t) TIOCMBIC)) {
            return;
        }
#else
        if (JnhwSetStaticIntField(env, clazz, "TIOCMBIC", TIOCMBIC)) {
            return;
        }
#endif

#if defined(__APPLE__) || defined (__FreeBSD__) || defined (__OpenBSD__) || (defined(__linux__) && defined(__sparc__))
        //Just force the conversation or check at runtime sizeof??
        if (JnhwSetStaticIntField(env, clazz, "TIOCMBIS", (int32_t) TIOCMBIS)) {
            return;
        }
#else
        if (JnhwSetStaticIntField(env, clazz, "TIOCMBIS", TIOCMBIS)) {
            return;
        }
#endif

#if defined(__linux__) && defined(__sh__) 
        if (JnhwSetStaticIntField(env, clazz, "TIOCOUTQ", (int32_t) TIOCOUTQ)) {
            return;
        }
#else
        if (JnhwSetStaticIntField(env, clazz, "TIOCOUTQ", TIOCOUTQ)) {
            return;
        }
#endif        
    }

#endif
#ifdef __cplusplus
}
#endif
