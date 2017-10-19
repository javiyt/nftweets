#include <jni.h>
#define xstr(s) str(s)
#define str(s) #s

JNIEXPORT jstring JNICALL
Java_yt_javi_nftweets_ui_main_MainActivity_getCryptedTwitterKey(JNIEnv *env, jobject instance) {

    return (*env)->  NewStringUTF(env, xstr(TWITTER_CONSUMER_KEY));
}

JNIEXPORT jstring JNICALL
Java_yt_javi_nftweets_ui_main_MainActivity_getCryptedTwitterSecret(JNIEnv *env, jobject instance) {

    return (*env)->NewStringUTF(env, xstr(TWITTER_CONSUMER_SECRET));
}

JNIEXPORT jstring JNICALL
Java_yt_javi_nftweets_ui_main_MainActivity_getCryptedNewsApiKey(JNIEnv *env, jobject instance) {

    return (*env)->NewStringUTF(env, xstr(NEWS_API_KEY));
}

JNIEXPORT jstring JNICALL
Java_yt_javi_nftweets_ui_main_MainActivity_getEncryptionKey(JNIEnv *env, jobject instance) {

    return (*env)->NewStringUTF(env, xstr(ENCRYPTION_KEY));
}