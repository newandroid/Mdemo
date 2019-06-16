package com.example;

import com.example.reflect.FieldSpy;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * create by css on 13/06/2019
 */
public class ReflectTest {
    @Test
    public void show(){
        FieldSpy.main("com.example.reflect.FieldSpy","b");
//        FieldSpy.main("com.example.reflect.FieldSpy","name");
    }
    @Test
    public void trueTest(){
        try {
            Class<?> c = Class.forName("com.example.reflect.FieldSpy");
            Field[] fields = c.getFields();
            for (Field field : fields) {
                System.out.println(field.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
