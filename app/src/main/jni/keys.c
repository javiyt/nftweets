#include <jni.h>

JNIEXPORT jstring JNICALL
Java_yt_javi_nftweets_ui_main_MainActivity_getCryptedTwitterKey(JNIEnv *env, jobject instance) {

    return (*env)->  NewStringUTF(env, "Jncic4Z3Fa6YDh7h3Rst1JQBKwNSjaYHXXID/i7qP8A=");
}

JNIEXPORT jstring JNICALL
Java_yt_javi_nftweets_ui_main_MainActivity_getCryptedTwitterSecret(JNIEnv *env, jobject instance) {

    return (*env)->NewStringUTF(env, "KF4KkMhYIXPysx5hD8T6rbbgZwUbSKE06KjdgYhwXYcxXh+raTGPeXAAoLUkKS4rZlXf0uqVEvJyd/2WUZRYZw==");
}

JNIEXPORT jstring JNICALL
Java_yt_javi_nftweets_ui_main_MainActivity_getCryptedNewsApiKey(JNIEnv *env, jobject instance) {

    return (*env)->NewStringUTF(env, "Ip4faoBWz16ZMwIy4iPBnc5lACGZBovnBFDvUeSMF0dynJbjeNCC+EmTorz59dQs");
}