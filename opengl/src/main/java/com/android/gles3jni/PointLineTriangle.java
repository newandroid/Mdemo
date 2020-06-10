package com.android.gles3jni;

import android.graphics.Color;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class PointLineTriangle implements GLSurfaceView.Renderer {

    FloatBuffer vertexBuffer;
    FloatBuffer colorBuffer;
    /**
     * 顶点着色器
     */
    private String vertextShader =
            "#version 300 es \n" +
                    "layout (location = 0) in vec4 vPosition;\n"
                    + "layout (location = 1) in vec4 aColor;\n"
                    + "out vec4 vColor;\n"
                    + "void main() { \n"
                    + "gl_Position  = vPosition;\n"
                    + "gl_PointSize = 10.0;\n"
                    + "vColor = aColor;\n"
                    + "}\n";

    private String fragmentShader =
            "#version 300 es \n" +
                    "precision mediump float;\n"
                    + "in vec4 vColor;\n"
                    + "out vec4 fragColor;\n"
                    + "void main() { \n"
                    + "fragColor = vColor; \n"
                    + "}\n";
    private float[] vertexPoints = new float[]{
            0f, 0.5f, 0f,
            -0.5f, -0.5f, 0f,
            0.5f, -0.5f, 0f
    };
    private float[] color = new float[]{
            0.0f, 1.0f, 0.0f, 1.0f,
            1.0f, 0.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f, 1.0f
    };
    int linkProgram;

    public PointLineTriangle() {
        vertexBuffer = ByteBuffer.allocateDirect(vertexPoints.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        vertexBuffer.put(vertexPoints);
        vertexBuffer.position(0);
        colorBuffer = ByteBuffer.allocateDirect(color.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        //传入指定的数据
        colorBuffer.put(color);
        colorBuffer.position(0);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES30.glClearColor(0.5f, 0.5f, 0.5f, 0.5f);
        int vertexShaderId = ShaderUtils.compileShader(GLES30.GL_VERTEX_SHADER, vertextShader);
        int fragmentShaderId = ShaderUtils.compileShader(GLES30.GL_FRAGMENT_SHADER, fragmentShader);
        linkProgram = ShaderUtils.linkProgram(vertexShaderId, fragmentShaderId);
        GLES30.glUseProgram(linkProgram);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES30.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES30.glClear(GL10.GL_COLOR_BUFFER_BIT);
        GLES30.glVertexAttribPointer(0, 3, GLES30.GL_FLOAT, false, 0, vertexBuffer);
        GLES30.glEnableVertexAttribArray(0);
        GLES30.glEnableVertexAttribArray(1);
        GLES30.glVertexAttribPointer(1, 4, GLES30.GL_FLOAT, false, 0, colorBuffer);

//        GLES30.glDrawArrays(GLES30.GL_POINTS, 0, 3);

//        GLES30.glDrawArrays(GLES30.GL_LINE_STRIP, 0, 2);
//        GLES30.glLineWidth(10);

        GLES30.glDrawArrays(GLES30.GL_TRIANGLES, 0, 3);
        GLES30.glDisableVertexAttribArray(0);
        GLES30.glDisableVertexAttribArray(1);
    }
}