package com.android.gles3jni;

import android.opengl.GLES30;

public class ShaderUtils {
    public static int compileVertexShader(String shaderCode) {
        return compileShader(GLES30.GL_VERTEX_SHADER, shaderCode);
    }

    public static int compileFragmentShader(String shaderCode) {
        return compileShader(GLES30.GL_FRAGMENT_SHADER, shaderCode);
    }

    /**
     * 链接小程序
     *
     * @param vertexShaderId   顶点着色器
     * @param fragmentShaderId 片段着色器
     * @return
     */
    public static int linkProgram(int vertexShaderId, int fragmentShaderId) {
        int programId = GLES30.glCreateProgram();
        if (programId != 0) {
            GLES30.glAttachShader(programId, vertexShaderId);
            GLES30.glAttachShader(programId, fragmentShaderId);
            GLES30.glLinkProgram(programId);
            int[] linkStatus = new int[1];
            GLES30.glGetProgramiv(programId, GLES30.GL_LINK_STATUS, linkStatus, 0);
            if (linkStatus[0] == 0) {
                String info = GLES30.glGetProgramInfoLog(programId);
                System.out.println(info);
                GLES30.glDeleteProgram(programId);
                return 0;
            }
            return programId;
        } else {
            //创建失败
            return 0;
        }
    }

    /**
     * @param type       顶点着色器：GLES30.GL_VERTEX_SHADER
     *                   片段着色器：GLES30.GL_FRAGMENT_SHADER
     * @param shaderCode
     * @return
     */
    public static int compileShader(int type, String shaderCode) {
        int shaderId = GLES30.glCreateShader(type);
        if (shaderId != 0) {
            GLES30.glShaderSource(shaderId, shaderCode);
            GLES30.glCompileShader(shaderId);
            int[] compileStatus = new int[1];
            GLES30.glGetShaderiv(shaderId, GLES30.GL_COMPILE_STATUS, compileStatus, 0);
            if (compileStatus[0] == 0) {
                String info = GLES30.glGetShaderInfoLog(shaderId);
                System.out.println(info);
                GLES30.glDeleteShader(shaderId);
                return 0;
            }
            return shaderId;
        } else {
            //创建失败
            return 0;
        }
    }
}
