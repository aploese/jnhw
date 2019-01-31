#include "jnhw.h"
#include "JnhwExceptions.h"

JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *jvm, void *reserved) {
    JNIEnv *env;
    if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_1_4)) {
        return JNI_ERR;
    }

    // mark that the lib was loaded
    jclass LibCHeader = (*env)->FindClass(env,
            "de/ibapl/jnhw/LibJnhwLoader");
    if (LibCHeader == NULL) {
        return JNI_ERR;
    }
    jfieldID LibCHeader_libLoaded = (*env)->GetStaticFieldID(env,
            LibCHeader, "libLoaded", "Z");
    if (LibCHeader_libLoaded == NULL) {
        return JNI_ERR;
    }

    (*env)->SetStaticBooleanField(env, LibCHeader,
            LibCHeader_libLoaded, JNI_TRUE);

    (*env)->DeleteLocalRef(env, LibCHeader);


    return JNI_VERSION_1_4;
}

JNIEXPORT void JNICALL
JNI_OnUnload(JavaVM *jvm, void *reserved) {
    JNIEnv *env;

    if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_1_4)) {
        return;
    }

    // mark that the lib was unloaded
    jclass LibCHeader = (*env)->FindClass(env,
            "de/ibapl/jnhw/LibJnhwLoader");
    if (LibCHeader != NULL) {
        jfieldID LibCHeader_libLoaded = (*env)->GetStaticFieldID(env,
                LibCHeader, "libLoaded", "Z");
        (*env)->SetStaticBooleanField(env, LibCHeader,
                LibCHeader_libLoaded, JNI_FALSE);
    }
    (*env)->DeleteLocalRef(env, LibCHeader);
}
