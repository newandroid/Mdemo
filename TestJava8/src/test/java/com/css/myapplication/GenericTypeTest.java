package com.css.myapplication;

import com.css.myapplication.myclass.GenericType;

import org.junit.Test;

/**
 * Created by Administrator on 2017/9/17.
 */

public class GenericTypeTest {
    @Test
    public void getMethod(){
        GenericType<String> name = new GenericType<>();
        name.setData("xiaoming");
        System.out.println("result:"+name.getData());
    }
}
