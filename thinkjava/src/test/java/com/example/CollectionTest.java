package com.example;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Administrator on 2017/9/26.
 */

public class CollectionTest {
    @Test
    public void queueTest(){
        Queue<String> datas = new ArrayDeque<>();
        datas.add("wind");
        datas.add("machine");
        String poll = datas.poll();
        System.out.println("poll:"+poll);
        System.out.println("size:"+datas.size());
    }
}
