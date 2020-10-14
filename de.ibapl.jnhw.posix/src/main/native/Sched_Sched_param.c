/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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
     * Method:    sizeof_sched_param
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_00024Sched_1param_sizeof_1sched_1param
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct sched_param);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched_Sched_param
     * Method:    offsetof_sched_ss_init_budget
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_00024Sched_1param_offsetof_1sched_1ss_1init_1budget
#if defined(__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        throw_NoSuchNativeTypeMemberException(env, "sched_param", "sched_ss_init_budget");
        return -1;
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct sched_param, sched_ss_init_budget);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched_Sched_param
     * Method:    offsetof_sched_ss_repl_period
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_00024Sched_1param_offsetof_1sched_1ss_1repl_1period
#if defined(__linux__)  || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        throw_NoSuchNativeTypeMemberException(env, "sched_param", "offsetof_sched_ss_repl_period");
        return -1;
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct sched_param, offsetof_sched_ss_repl_period);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched_Sched_param
     * Method:    sched_priority
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_00024Sched_1param_sched_1priority__
    (JNIEnv *env, jobject structSched_param) {
        return (UNWRAP_STRUCT_SCHED_PARAM_PTR(structSched_param))->sched_priority;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched_Sched_param
     * Method:    sched_priority
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Sched_00024Sched_1param_sched_1priority__I
    (JNIEnv *env, jobject structSched_param, jint sched_priority) {
        (UNWRAP_STRUCT_SCHED_PARAM_PTR(structSched_param))->sched_priority = sched_priority;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched_Sched_param
     * Method:    sched_ss_low_priority
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_00024Sched_1param_sched_1ss_1low_1priority__
#if defined(__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject sched_param) {
        throw_NoSuchNativeTypeMemberException(env, "sched_param", "sched_ss_low_priority");
        return -1;
#else
    (JNIEnv *env, jobject structSched_param) {
        return (UNWRAP_STRUCT_SCHED_PARAM_PTR(structSched_param))->sched_ss_low_priority;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched_Sched_param
     * Method:    sched_ss_low_priority
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Sched_00024Sched_1param_sched_1ss_1low_1priority__I
#if defined(__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject sched_param, __attribute__ ((unused)) jint sched_ss_low_priority) {
        throw_NoSuchNativeTypeMemberException(env, "sched_param", "sched_ss_low_priority");
#else
    (JNIEnv *env, jobject structSched_param, jint sched_ss_low_priority) {
        (UNWRAP_STRUCT_SCHED_PARAM_PTR(structSched_param))->sched_ss_low_priority = sched_ss_low_priority;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched_Sched_param
     * Method:    sched_ss_max_repl
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_00024Sched_1param_sched_1ss_1max_1repl__
#if defined(__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject sched_param) {
        throw_NoSuchNativeTypeMemberException(env, "sched_param", "sched_ss_max_repl");
        return -1;
#else
    (JNIEnv *env, jobject structSched_param) {
        return (UNWRAP_STRUCT_SCHED_PARAM_PTR(structSched_param))->sched_ss_max_repl;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched_Sched_param
     * Method:    sched_ss_max_repl
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Sched_00024Sched_1param_sched_1ss_1max_1repl__I
#if defined(__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject sched_param, __attribute__ ((unused)) jint sched_ss_max_repl) {
        throw_NoSuchNativeTypeMemberException(env, "sched_param", "sched_ss_max_repl");
#else
    (JNIEnv *env, jobject structSched_param, jint sched_ss_max_repl) {
        (UNWRAP_STRUCT_SCHED_PARAM_PTR(structSched_param))->sched_ss_max_repl = sched_ss_max_repl;
#endif
    }


#endif
#ifdef __cplusplus
}
#endif
