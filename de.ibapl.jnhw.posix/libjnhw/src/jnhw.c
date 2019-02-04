#include "jnhw.h"
#include "JnhwExceptions.h"


JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *jvm, void *reserved) {
    JNIEnv *env;
    if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_1_4)) {
        return JNI_ERR;
    }

    initExceptions(env);

    de_ibapl_jnhw_ByteRef_value_ID = getFieldId(env, JNHW_CLASS_NAME_BYTE_REF, "value", "B");
    de_ibapl_jnhw_ShortRef_value_ID = getFieldId(env, JNHW_CLASS_NAME_SHORT_REF, "value", "S");
    de_ibapl_jnhw_IntRef_value_ID = getFieldId(env, JNHW_CLASS_NAME_INT_REF, "value", "I");
    de_ibapl_jnhw_LongRef_value_ID = getFieldId(env, JNHW_CLASS_NAME_LONG_REF, "value", "J");

    //TODO Check and if pending clear exception and return JNI_FALSE???

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

jclass getGlobalClassRef(JNIEnv *env, const char* className) {
    jclass clazz = (*env)->FindClass(env, className);
    if (clazz == NULL) {
        throw_ClassNotFoundException(env, className);
        return NULL;
    }
    jclass result = (*env)->NewGlobalRef(env, clazz);
    (*env)->DeleteLocalRef(env, clazz);
    if (result == NULL) {
        //TODO what ex to throw???
        throw_ClassNotFoundException(env, className);
    }
    return result;
    
}

jfieldID getFieldId(JNIEnv *env, const char* className, const char* fieldName, const char* fieldType) {

    jclass clazz = (*env)->FindClass(env, className);
    if (clazz == NULL) {
        throw_ClassNotFoundException(env, className);
        return NULL;
    }

    jfieldID result = (*env)->GetFieldID(env, clazz, fieldName, fieldType);
    (*env)->DeleteLocalRef(env, clazz);
    if (result == NULL) {
        throw_NoSuchFieldException(env, className, fieldName, fieldType);
        return NULL;
    }
    return result;
}

jfieldID getFieldIdOfClassRef(JNIEnv *env, jclass clazz, const char* className, const char* fieldName, const char* fieldType) {

    jfieldID result = (*env)->GetFieldID(env, clazz, fieldName, fieldType);
    if (result == NULL) {
        throw_NoSuchFieldException(env, className, fieldName, fieldName);
        return NULL;
    }
    return result;
}

jmethodID getMethodIdOfClassRef(JNIEnv *env, jclass clazz, const char* className, const char* methodName, const char* methodSignature) {

    jmethodID result = (*env)->GetMethodID(env, clazz, methodName, methodSignature);
    if (result == NULL) {
        throw_NoSuchMethodException(env, className, methodName, methodSignature);
        return NULL;
    }
    return result;
}
