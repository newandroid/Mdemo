package com.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * create by css on 2019/8/23
 */
public class RxjavaTest {
    @Test
    public void hello(){
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(String.valueOf(i));
        }
        arrayList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
