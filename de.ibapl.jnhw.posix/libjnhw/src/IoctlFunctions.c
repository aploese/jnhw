#include "jnhw.h"

#include "de_ibapl_jnhw_unix_sys_Ioctl.h"
#include <sys/ioctl.h>
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    static jfieldID de_ibapl_jnhw_unix_sys_Ioctl_ioctl_IntRef_value = NULL;

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    initNative
     * Signature: (Ljava/lang/Class;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_initNative
    (JNIEnv *env, jclass clazz, jclass intRef_Class) {
        de_ibapl_jnhw_unix_sys_Ioctl_ioctl_IntRef_value = (*env)->GetFieldID(env,
                intRef_Class, "value", "I");
        if (de_ibapl_jnhw_unix_sys_Ioctl_ioctl_IntRef_value == NULL) {
            throwException(env, UnsatisfiedLinkException, "Get FieldID of IntRef.value");
        }
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    ioctl
     * Signature: (IJ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_ioctl__IJ
    (JNIEnv *env, jclass clazz, jint fd, jlong request) {
        int result = ioctl(fd, request);
        if (result < 0) {
            throwNativeError(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    ioctl
     * Signature: (IJLde/ibapl/jnhw/IntRef;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_ioctl__IJLde_ibapl_jnhw_IntRef_2
    (JNIEnv *env, jclass clazz, jint fd, jlong request, jobject intRef) {

        int _intRef = (*env)->GetIntField(env, intRef, de_ibapl_jnhw_unix_sys_Ioctl_ioctl_IntRef_value);

        int result = ioctl(fd, request, &_intRef);
        (*env)->SetIntField(env, intRef, de_ibapl_jnhw_unix_sys_Ioctl_ioctl_IntRef_value, _intRef);
        if (result < 0) {
            throwNativeError(env, errno);
        }
        return result;
    }

#ifdef __cplusplus
}
#endif
