//
// Created by HP on 2020/6/10.
//

#include <jni.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#include "native_color.h"

extern "C" {
JNIEXPORT void JNICALL Java_com_android_gles3jni_NativeColorRenderer_surfaceCreated(JNIEnv *env,
                                                                                    jobject obj,
                                                                                    jint color);
JNIEXPORT void JNICALL Java_com_android_gles3jni_NativeColorRenderer_surfaceChanged(JNIEnv *env,
                                                                                    jobject obj,
                                                                                    jint width,
                                                                                    jint height);
JNIEXPORT void JNICALL Java_com_android_gles3jni_NativeColorRenderer_onDrawFrame(JNIEnv *env,
                                                                                 jobject obj);
};
extern "C" JNIEXPORT void JNICALL
Java_com_android_gles3jni_NativeColorRenderer_surfaceCreated(JNIEnv *env, jobject obj, jint color) {
    GLfloat redF = ((color >> 16) & 0xFF) * 1.0f / 255;
    GLfloat greenF = ((color >> 8) & 0xFF) * 1.0f / 255;
    GLfloat blueF = (color & 0xFF) * 1.0f / 255;
    GLfloat alphaF = ((color >> 24) & 0xFF) * 1.0f / 255;
    glClearColor(redF, greenF, blueF, alphaF);
}
extern "C" JNIEXPORT void JNICALL
Java_com_android_gles3jni_NativeColorRenderer_surfaceChanged(JNIEnv *env,
                                                             jobject obj,
                                                             jint width,
                                                             jint height) {
    glViewport(0, 0, width, height);
}
extern "C" JNIEXPORT void JNICALL
Java_com_android_gles3jni_NativeColorRenderer_onDrawFrame(JNIEnv *env,
                                                          jobject obj) {
    glClear(GL_COLOR_BUFFER_BIT);
}
