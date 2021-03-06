package com.android.gles3jni;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Bundle;

public class RendererActivity extends Activity {
    GLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();
    }

    private void setupViews() {
        glSurfaceView = new GLSurfaceView(this);
        setContentView(glSurfaceView);
        glSurfaceView.setEGLContextClientVersion(3);
//        GLSurfaceView.Renderer renderer = new NativeColorRenderer(Color.BLUE);
        GLSurfaceView.Renderer renderer = new RectangleRenderer();
        glSurfaceView.setRenderer(renderer);
    }
}
