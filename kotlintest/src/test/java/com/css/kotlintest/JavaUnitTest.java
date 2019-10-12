package com.css.kotlintest;

import android.widget.TextView;

import com.css.kotlintest.bean.ByteProtocolBean;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class JavaUnitTest {


    @Test
    public void setFields() {
        try {
            Object object = ByteProtocolBean.class.newInstance();
            Field[] declaredFields = object.getClass().getDeclaredFields();
            for (int i = 0; i <declaredFields.length-1; i++) {
                declaredFields[i].setByte(object, (byte) i);
            }
            byte[] jjjj = new byte[]{1,2,3};
            declaredFields[2].set(object,jjjj);
            System.out.println(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();

        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkAn(){
        for (Field field : ByteProtocolBean.class.getFields()) {
            for (Annotation annotation : field.getAnnotations()) {
                System.out.println(annotation.annotationType());
            }
        }
    }

    public void createJavaCode(){
        ArrayList<TextView> list = new ArrayList<>();
    }

    @Test
    public void test(){
        try {
            System.out.println(Integer.valueOf(""));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public <T extends String> void hahha(T t){
        System.out.println(t.getClass().getSimpleName());
    }

}
