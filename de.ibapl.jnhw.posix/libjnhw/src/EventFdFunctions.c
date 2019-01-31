#include "jnhw.h"

#include "de_ibapl_jnhw_linux_sys_Eventfd.h"
#include <sys/eventfd.h>
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    static jfieldID de_ibapl_jnhw_linux_sys_Eventfd_LongRef_value = NULL;

/*
 * Class:     de_ibapl_jnhw_linux_sys_Eventfd
 * Method:    initNative
 * Signature: (Ljava/lang/Class;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_linux_sys_Eventfd_initNative
    (JNIEnv *env, jclass clazz, jclass longRef_Class) {
        de_ibapl_jnhw_linux_sys_Eventfd_LongRef_value = (*env)->GetFieldID(env,
                longRef_Class, "value", "J");
        if (de_ibapl_jnhw_linux_sys_Eventfd_LongRef_value == NULL) {
            throwException(env, UnsatisfiedLinkException, "Get FieldID of LongRef.value");
        }
    }

    /*
     * Class:     de_ibapl_jnhw_linux_sys_Eventfd
     * Method:    eventfd
     * Signature: (II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_linux_sys_Eventfd_eventfd
    (JNIEnv *env, jclass clazz, jint count, jint flags) {
        int result = eventfd(count, flags);
        if (result < 0) {
            throwNativeError(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_linux_sys_Eventfd
     * Method:    eventfd_read
     * Signature: (IJ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_linux_sys_Eventfd_eventfd_1read
    (JNIEnv *env, jclass clazz, jint fd, jobject valueRef) {
        eventfd_t _valueRef = (*env)->GetLongField(env, valueRef, de_ibapl_jnhw_linux_sys_Eventfd_LongRef_value);
        int result = eventfd_read(fd, &_valueRef);
        (*env)->SetLongField(env, valueRef, de_ibapl_jnhw_linux_sys_Eventfd_LongRef_value, _valueRef);
        if (result < 0) {
            throwNativeError(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_linux_sys_Eventfd
     * Method:    eventfd_write
     * Signature: (IJ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_linux_sys_Eventfd_eventfd_1write
    (JNIEnv *env, jclass clazz, jint fd, jlong value) {
        int result = eventfd_write(fd, value);
        if (result < 0) {
            throwNativeError(env, errno);
        }
        return result;
    }

#ifdef __cplusplus
}
#endif
