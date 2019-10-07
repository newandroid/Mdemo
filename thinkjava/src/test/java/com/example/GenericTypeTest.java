package com.example;


import com.example.myclass.GenericType;

import org.junit.Test;

/**
 * Created by Administrator on 2017/9/17.
 */

public class GenericTypeTest {
    @Test
    public void getMethod() {
        GenericType<String> name = new GenericType<>();
        name.setData("xiaoming");
        System.out.println("result:" + name.getData());
        gTest(new String("ni hao"));
    }

    private <T> T gTest(T t) {
        System.out.println(t.hashCode());
        return t;
    }
}
