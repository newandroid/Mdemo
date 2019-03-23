package com.example;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * create by css on 2019/1/24
 */
public class StringTest {
    @Test
    public void run(){
        String s = "jj";
        try {
            System.out.println(s.getBytes("utf-8").toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
