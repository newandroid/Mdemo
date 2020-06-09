package com.android.gles3jni;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class NativeColorRenderer implements GLSurfaceView.Renderer {
    static {
        System.loadLibrary("gles3jni");
    }

    public native void surfaceCreated(int color);

    public native void surfaceChanged(int width, int height);

    public native void onDrawFrame();

    private int color;


    public NativeColorRenderer(int color) {
        this.color = color;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        surfaceCreated(color);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        surfaceChanged(width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        onDrawFrame();
    }
}
