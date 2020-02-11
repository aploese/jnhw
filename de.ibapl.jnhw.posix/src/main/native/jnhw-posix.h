/**
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


#if  defined(__linux__)
#define _GNU_SOURCE

#if defined(_LP64)
//64 bit

#else
//32 bit

#endif
#elif defined(__FreeBSD__)
#define _POSIX_C_SOURCE 200809
//no 
#elif defined(__APPLE__)
#define _POSIX_C_SOURCE 200809
#endif

//#if defined(__linux__) || defined(__APPLE__) || defined(__FreeBSD__)
//#define _LARGEFILE64_SOURCE
//#endif

#include "jnhw-common.h"

#include "../../../config.h"

#ifndef _jnhw_posix_H
#define _jnhw_posix_H

#ifdef __cplusplus
extern "C" {
#endif

#define JNHW_CLASS_NAME_LOCALE_T "de/ibapl/jnhw/posix/Locale$Locale_t"
#define JNHW_CLASS_NAME_TIME_TM "de/ibapl/jnhw/posix/Time$Tm"

    extern jclass de_ibapl_jnhw_posix_Locale_Locale_t_Class;
    extern jfieldID de_ibapl_jnhw_posix_Locale_Locale_t_nativeValue_ID;
    extern jmethodID de_ibapl_jnhw_posix_Locale_Locale_t_init_ID;

    extern jclass de_ibapl_jnhw_posix_Time_Tm_Class;
    extern jmethodID de_ibapl_jnhw_posix_Time_Tm_init_ID;

#define UNWRAP_LOCALE_T(Locale_tObject) (locale_t) (*env)->GetLongField(env, Locale_tObject, de_ibapl_jnhw_posix_Locale_Locale_t_nativeValue_ID)   
#define CREATE_LOCALE_T(value) (*env)->NewObject(env, de_ibapl_jnhw_posix_Locale_Locale_t_Class, de_ibapl_jnhw_posix_Locale_Locale_t_init_ID, value)

#define UNWRAP_STRUCT_TERMIOS_PTR(structTermios) UNWRAP_OPAQUE_MEM_TO(struct termios*, structTermios)

#define UNWRAP_STRUCT_POLLFD_PTR(structPollFd) UNWRAP_OPAQUE_MEM_TO(struct pollfd*, structPollFd)

#define UNWRAP_STRUCT_LCONV_PTR(structLconv) UNWRAP_OPAQUE_MEM_TO(struct lconv*, structLconv)

#define UNWRAP_STRUCT_TM_PTR(structTm) UNWRAP_OPAQUE_MEM_TO(struct tm*, structTm)

#define UNWRAP_STRUCT_TIMESPEC_PTR(structTimespec) UNWRAP_OPAQUE_MEM_TO(struct timespec*, structTimespec)
#define UNWRAP_STRUCT_TIMESPEC_PTR_OR_NULL(structTimespec) UNWRAP_OPAQUE_MEM_TO_OR_NULL(struct timespec*, structTimespec)

#define UNWRAP_STRUCT_TM_PTR(structTm) UNWRAP_OPAQUE_MEM_TO(struct tm*, structTm)
#define WRAP_STATIC_STRUCT_TM(baseAddress) (*env)->NewObject(env, de_ibapl_jnhw_posix_Time_Tm_Class, de_ibapl_jnhw_posix_Time_Tm_init_ID, baseAddress, sizeof (struct tm))

#define UNWRAP_STRUCT_SIGACTION_PTR(structSigaction) UNWRAP_OPAQUE_MEM_TO(struct sigaction*, structSigaction)
#define UNWRAP_STRUCT_SIGACTION_PTR_OR_NULL(structSigaction) UNWRAP_OPAQUE_MEM_TO_OR_NULL(struct sigaction*, structSigaction)

#define UNWRAP_STRUCT_SIGEVENT_PTR(structSigevent) UNWRAP_OPAQUE_MEM_TO(struct sigevent*, structSigevent)
#define UNWRAP_STRUCT_SIGEVENT_PTR_OR_NULL(structSigevent) UNWRAP_OPAQUE_MEM_TO_OR_NULL(struct sigevent*, structSigevent)

#define UNWRAP_SIGINFO_T_PTR(structSiginfo_t) UNWRAP_OPAQUE_MEM_TO(siginfo_t*, structSiginfo_t)
#define UNWRAP_SIGINFO_T_PTR_OR_NULL(structSiginfo_t) UNWRAP_OPAQUE_MEM_TO_OR_NULL(siginfo_t*, structSiginfo_t)
    
#define UNWRAP_UNION_SIGVAL_PTR(unionSigval) UNWRAP_OPAQUE_MEM_TO(union sigval*, unionSigval)
    
#define UNWRAP_STACK_T_PTR(structStack_t) UNWRAP_OPAQUE_MEM_TO(stack_t*, structStack_t)
#define UNWRAP_STACK_T_PTR_OR_NULL(structStack_t) UNWRAP_OPAQUE_MEM_TO_OR_NULL(stack_t*, structStack_t)

#define UNWRAP_STRUCT_UCONTEXT_T_PTR(structUcontext_t) UNWRAP_OPAQUE_MEM_TO(struct ucontext_t*, structUcontext_t)

#define UNWRAP_STRUCT_AIOCB_PTR(structAiocb) UNWRAP_OPAQUE_MEM_TO(struct aiocb*, structAiocb)

#define UNWRAP_SIGSET_T_PTR(sigset)UNWRAP_OPAQUE_MEM_TO(sigset_t*, sigset)
#define UNWRAP_SIGSET_T_PTR_OR_NULL(sigset) UNWRAP_OPAQUE_MEM_TO_OR_NULL(sigset_t*, sigset)

#define UNWRAP_PTHREAD_T_PTR(pthread)UNWRAP_OPAQUE_MEM_TO(pthread_t*, pthread)
    
#define UNWRAP_PTHREAD_ATTR_T_PTR(pthread_attr)UNWRAP_OPAQUE_MEM_TO(pthread_attr_t*, pthread_attr)
#define UNWRAP_PTHREAD_ATTR_T_PTR_OR_NULL(pthread_attr)UNWRAP_OPAQUE_MEM_TO_OR_NULL(pthread_attr_t*, pthread_attr)

#define UNWRAP_TIMER_T_PTR(timerid)UNWRAP_OPAQUE_MEM_TO(timer_t*, timerid)
    
#ifdef __cplusplus
}
#endif

#endif
