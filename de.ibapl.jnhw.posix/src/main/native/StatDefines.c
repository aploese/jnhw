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


    /*
     * Class:     de_ibapl_jnhw_posix_sys_Stat
     * Method:    HAVE_SYS_STAT_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_sys_Stat_HAVE_1SYS_1STAT_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef HAVE_SYS_STAT_H
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

#ifdef _POSIX_VERSION
#include <sys/stat.h>

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Stat
     * Method:    S_IRWXU
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Stat_S_1IRWXU
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return S_IRWXU;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Stat
     * Method:    S_IRUSR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Stat_S_1IRUSR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return S_IRUSR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Stat
     * Method:    S_IWUSR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Stat_S_1IWUSR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return S_IWUSR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Stat
     * Method:    S_IXUSR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Stat_S_1IXUSR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return S_IXUSR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Stat
     * Method:    S_IRWXG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Stat_S_1IRWXG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return S_IRWXG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Stat
     * Method:    S_IRGRP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Stat_S_1IRGRP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return S_IRGRP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Stat
     * Method:    S_IWGRP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Stat_S_1IWGRP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return S_IWGRP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Stat
     * Method:    S_IXGRP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Stat_S_1IXGRP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return S_IXGRP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Stat
     * Method:    S_IRWXO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Stat_S_1IRWXO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return S_IRWXO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Stat
     * Method:    S_IROTH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Stat_S_1IROTH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return S_IROTH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Stat
     * Method:    S_IWOTH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Stat_S_1IWOTH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return S_IWOTH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Stat
     * Method:    S_IXOTH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Stat_S_1IXOTH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return S_IXOTH;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Stat
     * Method:    S_ISUID
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Stat_S_1ISUID
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return S_ISUID;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Stat
     * Method:    S_ISGID
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Stat_S_1ISGID
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return S_ISGID;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Stat
     * Method:    S_ISVTX
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Stat_S_1ISVTX
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return S_ISVTX;
    }

#endif
#ifdef __cplusplus
}
#endif
