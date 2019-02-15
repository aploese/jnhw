#include "../../../config.h"
#include "jnhw.h"

#ifdef HAVE_SYS_IOCTL_H

#include "de_ibapl_jnhw_unix_sys_Ioctl.h"
#include <sys/ioctl.h>
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_unix_sys_Ioctl
     * Method:    ioctl
     * Signature: (IJ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_ioctl__IJ
    (JNIEnv *env, jclass clazz, jint fd, jlong request) {
        int result = ioctl(fd, request);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
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

        int _intRef = (*env)->GetIntField(env, intRef, de_ibapl_jnhw_IntRef_value_ID);

        int result = ioctl(fd, request, &_intRef);
        (*env)->SetIntField(env, intRef, de_ibapl_jnhw_IntRef_value_ID, _intRef);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

#ifdef __cplusplus
}
#endif
#endif