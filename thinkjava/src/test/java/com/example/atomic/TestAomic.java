package com.example.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAomic {
    @Test
    public void base() {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger.compareAndSet(2, 5));
        System.out.println(atomicInteger.get());
    }
}
