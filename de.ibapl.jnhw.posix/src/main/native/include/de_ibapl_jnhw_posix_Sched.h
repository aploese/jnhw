/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class de_ibapl_jnhw_posix_Sched */

#ifndef _Included_de_ibapl_jnhw_posix_Sched
#define _Included_de_ibapl_jnhw_posix_Sched
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     de_ibapl_jnhw_posix_Sched
 * Method:    initFields
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Sched_initFields
  (JNIEnv *, jclass);

/*
 * Class:     de_ibapl_jnhw_posix_Sched
 * Method:    sched_get_priority_max
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1get_1priority_1max
  (JNIEnv *, jclass, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Sched
 * Method:    sched_get_priority_min
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1get_1priority_1min
  (JNIEnv *, jclass, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Sched
 * Method:    sched_getparam
 * Signature: (ILde/ibapl/jnhw/posix/Sched/Sched_param;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1getparam
  (JNIEnv *, jclass, jint, jobject);

/*
 * Class:     de_ibapl_jnhw_posix_Sched
 * Method:    sched_getscheduler
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1getscheduler
  (JNIEnv *, jclass, jint);

/*
 * Class:     de_ibapl_jnhw_posix_Sched
 * Method:    sched_rr_get_interval
 * Signature: (ILde/ibapl/jnhw/posix/Time/Timespec;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1rr_1get_1interval
  (JNIEnv *, jclass, jint, jobject);

/*
 * Class:     de_ibapl_jnhw_posix_Sched
 * Method:    sched_setparam
 * Signature: (ILde/ibapl/jnhw/posix/Sched/Sched_param;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1setparam
  (JNIEnv *, jclass, jint, jobject);

/*
 * Class:     de_ibapl_jnhw_posix_Sched
 * Method:    sched_setscheduler
 * Signature: (IILde/ibapl/jnhw/posix/Sched/Sched_param;)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1setscheduler
  (JNIEnv *, jclass, jint, jint, jobject);

/*
 * Class:     de_ibapl_jnhw_posix_Sched
 * Method:    sched_yield
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1yield
  (JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif
