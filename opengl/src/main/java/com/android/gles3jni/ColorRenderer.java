package com.android.gles3jni;

import android.graphics.Color;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class ColorRenderer implements GLSurfaceView.Renderer {
    private int color;

    public ColorRenderer(int color) {
        this.color = color;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        float r = Color.red(color) * 1f / 255;
        float g = Color.green(color) * 1f / 255;
        float b = Color.blue(color) * 1f / 255;
        float a = Color.alpha(color) * 1f / 255;
        GLES30.glClearColor(r, g, b, a);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES30.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES30.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }
}
