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
#include "de_ibapl_jnhw_posix_Sched_Sched_param.h"

#ifdef __cplusplus
extern "C" {
#endif
    //for offsetof
#include <stddef.h>
#include <unistd.h>

#ifdef _POSIX_VERSION
#include <sched.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Sched_Sched_param
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/posix/Sched/Sched_param/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Sched_00024Sched_1param_native2Layout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (struct sched_param), __alignof__ (struct sched_param));
        if (result == NULL) {
            return NULL;
        }
        if (JnhwSetLongField(env, result, "sched_priority", offsetof(struct sched_param, sched_priority))) {
            return result;
        }
#if defined(__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
#else
        if (JnhwSetLongField(env, result, "sched_ss_low_priority", offsetof(struct sched_param, sched_ss_low_priority))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "sched_ss_repl_period", offsetof(struct sched_param, sched_ss_repl_period))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "sched_ss_init_budget", offsetof(struct sched_param, sched_ss_init_budget))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "sched_ss_max_repl", offsetof(struct sched_param, sched_ss_max_repl))) {
            return result;
        }
#endif
        return result;
    }


#endif
#ifdef __cplusplus
}
#endif
