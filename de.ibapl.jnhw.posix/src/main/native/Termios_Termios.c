#include "jnhw.h"

#ifdef HAVE_TERMIOS_H

#include "de_ibapl_jnhw_posix_Termios_StructTermios.h"
#include <termios.h>
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
 * Method:    sizeofTermios
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_sizeofTermios
      (JNIEnv *env, jclass clazz) {
    return sizeof(struct termios);
}

/*
 * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
 * Method:    c_iflag
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1iflag__J
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((struct termios*)baseAddress)->c_iflag;
}

/*
 * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
 * Method:    c_iflag
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1iflag__JI
  (JNIEnv *env, jclass clazz, jlong baseAddress, jint value) {
    ((struct termios*)baseAddress)->c_iflag = value;
}

/*
 * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
 * Method:    c_oflag
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1oflag__J
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((struct termios*)baseAddress)->c_oflag;
}

/*
 * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
 * Method:    c_oflag
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1oflag__JI
  (JNIEnv *env, jclass clazz, jlong baseAddress, jint value) {
    ((struct termios*)baseAddress)->c_oflag = value;
}

/*
 * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
 * Method:    c_cflag
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1cflag__J
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((struct termios*)baseAddress)->c_cflag;
}

/*
 * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
 * Method:    c_cflag
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1cflag__JI
  (JNIEnv *env, jclass clazz, jlong baseAddress, jint value) {
    ((struct termios*)baseAddress)->c_cflag = value;
}

/*
 * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
 * Method:    c_lflag
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1lflag__J
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((struct termios*)baseAddress)->c_lflag;
}

/*
 * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
 * Method:    c_lflag
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1lflag__JI
  (JNIEnv *env, jclass clazz, jlong baseAddress, jint value) {
    ((struct termios*)baseAddress)->c_lflag = value;
}

/*
 * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
 * Method:    c_cc
 * Signature: (JI)B
 */
JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1cc__JI
  (JNIEnv *env, jclass clazz, jlong baseAddress, jint index) {
    return ((struct termios*)baseAddress)->c_cc[index];
}

/*
 * Class:     de_ibapl_jnhw_posix_Termios_StructTermios
 * Method:    c_cc
 * Signature: (JIB)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024StructTermios_c_1cc__JIB
  (JNIEnv *env, jclass clazz, jlong baseAddress, jint index, jbyte value) {
    ((struct termios*)baseAddress)->c_cc[index] = value;
}

#ifdef __cplusplus
}
#endif
#endif