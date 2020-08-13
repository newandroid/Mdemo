package com.android.gles3jni;

import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class RectangleRenderer implements GLSurfaceView.Renderer {
    private static final int POSITION_COMPONENT_COUNT = 2;
    private static final int COLOR_COMPONENT_COUNT = 3;
    private static final int BYTES_PER_FLOAT = 4;
    private FloatBuffer vertexBuffer;
    private int mProgram;
    private int aPositionLocation;
    private int uMatrixLocation;
    private int aColorLocation;
    private String vertextShader = "#version 300 es\n" +
            "layout (location = 0) in vec4 vPosition;\n" +
            "layout (location = 1) in vec4 aColor;\n" +
            "uniform mat4 u_Matrix;\n" +
            "out vec4 vColor;\n" +
            "void main() {\n" +
            "     gl_Position  = u_Matrix*vPosition;\n" +
            "     gl_PointSize = 10.0;\n" +
            "     vColor = aColor;\n" +
            "}";
    private String fragmentShader = "#version 300 es\n" +
            "precision mediump float;\n" +
            "in vec4 vColor;\n" +
            "out vec4 fragColor;\n" +
            "void main() {\n" +
            "     fragColor = vColor;\n" +
            "}";

    /**
     * 点的坐标
     */
    private float[] vertexPoints = new float[]{
            0.0f, 0.0f, 1.0f, 1.0f, 1.0f,
            -0.5f, -0.8f, 1.0f, 1.0f, 1.0f,
            0.5f, -0.8f, 1.0f, 1.0f, 1.0f,
            0.5f, 0.8f, 1.0f, 1.0f, 1.0f,
            -0.5f, 0.8f, 1.0f, 1.0f, 1.0f,
            -0.5f, -0.8f, 1.0f, 1.0f, 1.0f,

            0.0f, 0.25f, 0.5f, 0.5f, 0.5f,
            0.0f, -0.25f, 0.5f, 0.5f, 0.5f,
    };
    //之前定义的坐标数据中，每一行是5个数据，前两个表示坐标(x,y)，后三个表示颜色(r,g,b)
    private static final int STRIDE = (POSITION_COMPONENT_COUNT + COLOR_COMPONENT_COUNT) * BYTES_PER_FLOAT;
    //所以这里实际是 STRIDE = (2 + 3) x 4

    private final float[] mMatrix = new float[16];


    public RectangleRenderer() {
        //分配内存空间,每个浮点型占4字节空间
        vertexBuffer = ByteBuffer.allocateDirect(vertexPoints.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        //传入指定的坐标数据
        vertexBuffer.put(vertexPoints);
        vertexBuffer.position(0);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        //设置背景颜色
        GLES30.glClearColor(0.5f, 0.5f, 0.5f, 0.5f);

        //编译
        final int vertexShaderId = ShaderUtils.compileShader(GLES30.GL_VERTEX_SHADER, vertextShader);
        final int fragmentShaderId = ShaderUtils.compileShader(GLES30.GL_FRAGMENT_SHADER, fragmentShader);
        //鏈接程序片段
        mProgram = ShaderUtils.linkProgram(vertexShaderId, fragmentShaderId);
        //在OpenGLES环境中使用程序片段
        GLES30.glUseProgram(mProgram);
        uMatrixLocation = GLES30.glGetUniformLocation(mProgram, "u_Matrix");
        aPositionLocation = GLES30.glGetAttribLocation(mProgram, "vPosition");
        aColorLocation = GLES30.glGetAttribLocation(mProgram, "aColor");

        vertexBuffer.position(0);
        //获取顶点数组 (POSITION_COMPONENT_COUNT = 2)
        GLES30.glVertexAttribPointer(aPositionLocation, POSITION_COMPONENT_COUNT, GLES30.GL_FLOAT, false, STRIDE, vertexBuffer);

        GLES30.glEnableVertexAttribArray(aPositionLocation);

        vertexBuffer.position(POSITION_COMPONENT_COUNT);
        //颜色属性分量的数量 COLOR_COMPONENT_COUNT = 3
        GLES30.glVertexAttribPointer(aColorLocation, COLOR_COMPONENT_COUNT, GLES30.GL_FLOAT, false, STRIDE, vertexBuffer);

        GLES30.glEnableVertexAttribArray(aColorLocation);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES30.glViewport(0, 0, width, height);
        final float aspectRatio = width > height ? (float) width / (float) height : (float) height / (float) width;
        if (width > height) {
            //横屏
            Matrix.orthoM(mMatrix, 0, -aspectRatio, aspectRatio, -1f, 1f, -1f, 1f);
        } else {
            //竖屏
            Matrix.orthoM(mMatrix, 0, -1f, 1f, -aspectRatio, aspectRatio, -1f, 1f);
        }
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT);
        GLES30.glUniformMatrix4fv(uMatrixLocation,1,false,mMatrix,0);
        //绘制矩形
        GLES30.glDrawArrays(GLES30.GL_TRIANGLE_STRIP, 0, 6);

        //绘制两个点
        GLES30.glDrawArrays(GLES30.GL_POINTS, 6, 2);
    }
}
