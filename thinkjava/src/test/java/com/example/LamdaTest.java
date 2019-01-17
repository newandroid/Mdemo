package com.example;


import com.example.myclass.LambdaClass;

import org.junit.Test;

/**
 * Created by Administrator on 2017/9/17.
 */

public class LamdaTest {
    private int age;
    @Test
    public void guitest() {
        LambdaClass lambdaClass = new LambdaClass();
        lambdaClass.setLambdaInterface(LamdaTest::haha);
        lambdaClass.setResult("hello");
    }

    private static void haha(String result){
        System.out.println(result);
    }

}
