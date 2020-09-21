package com.example.mrxjava.cssthread;


import org.jruby.RubyThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        //创建Callable对象任务
        Callable task = new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                System.out.println("子线程在进行计算");
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                int sum = 0;
                for (int i = 0; i < 100; i++)
                    sum += i;
                System.out.println("子线程完毕");
                return sum;
            }

        };
        //提交任务并获取执行结果
        Future<Integer> result = executor.submit(task);
        System.out.println("111111");
        //关闭线程池
        executor.shutdown();
        System.out.println("22222");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            if (result.get() != null) {
                System.out.println("task运行结果" + result.get());
            } else {
                System.out.println("未获取到结果");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
}
