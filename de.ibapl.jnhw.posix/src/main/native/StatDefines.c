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
#include "de_ibapl_jnhw_posix_sys_Stat.h"

#ifdef __cplusplus
extern "C" {
#endif


    //We need the POSIX version ...    
#if !defined(HAVE_SYS_STAT_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Stat
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_sys_Stat_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else
#include <sys/stat.h>

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Stat
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_sys_Stat_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_SYS_STAT_H", JNI_TRUE)) {
            return;
        }

        if (JnhwSetStaticIntField(env, clazz, "S_IRWXU", S_IRWXU)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "S_IRUSR", S_IRUSR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "S_IWUSR", S_IWUSR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "S_IXUSR", S_IXUSR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "S_IRWXG", S_IRWXG)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "S_IRGRP", S_IRGRP)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "S_IWGRP", S_IWGRP)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "S_IXGRP", S_IXGRP)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "S_IRWXO", S_IRWXO)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "S_IROTH", S_IROTH)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "S_IWOTH", S_IWOTH)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "S_IXOTH", S_IXOTH)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "S_ISUID", S_ISUID)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "S_ISGID", S_ISGID)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "S_ISVTX", S_ISVTX)) {
            return;
        }
    }

#endif
#ifdef __cplusplus
}
#endif
