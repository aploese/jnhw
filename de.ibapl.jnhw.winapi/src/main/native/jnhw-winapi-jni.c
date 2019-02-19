#include "../../../config.h"
#include "jnhw.h"

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *jvm, void *reserved) {
    JNIEnv *env;
    if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_1_4)) {
        return JNI_ERR;
    }
//    jnhw_common_init(env);
    
    return JNI_VERSION_1_4;
}

JNIEXPORT void JNICALL
JNI_OnUnload(JavaVM *jvm, void *reserved) {
    JNIEnv *env;

    if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_1_4)) {
        return;
    }

}
#ifdef __cplusplus
}
#endif
