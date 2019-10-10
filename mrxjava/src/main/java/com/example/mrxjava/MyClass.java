package com.example.mrxjava;

import com.example.mrxjava.functions.Func1;
import com.example.mrxjava.operations.WatchableExtensions;
import com.example.mrxjava.reactive.IDisposable;
import com.example.mrxjava.reactive.IObservable;
import com.example.mrxjava.reactive.IObserver;

public class MyClass {
    static final String CONTENT = "content";

    public static void main(String[] args) {
        //normal implement
        String dataPull = getDataPull();
        System.out.println(dataPull);

        //push implement
        IObservable<String> dataPush = getDataPush();
        dataPush.subscribe(new IObserver<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onNext(String args) {
                System.out.println(args);
            }
        });
    }

    private void unkonwTest() {
        IObservable iObservable = WatchableExtensions.create(new Func1<IDisposable, IObserver<String>>() {
            @Override
            public IDisposable call(IObserver<String> iObserver) {
                iObserver.onNext("hello world");
//                iObserver.onError(new Exception());
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                iObserver.onNext("delay");
                iObserver.onCompleted();
                return null;
            }
        });
        IDisposable onCompleted = iObservable.subscribe(new IObserver<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(String args) {
                System.out.println(args);
            }
        });
        onCompleted.unsubscribe();//无效

//        iObservable.subscribe(new String(""));

    }

    public static String getDataPull() {
        return CONTENT;
    }

    public static IObservable<String> getDataPush() {
        return WatchableExtensions.create(new Func1<IDisposable, IObserver<String>>() {
            @Override
            public IDisposable call(IObserver<String> iObserver) {
                iObserver.onNext(CONTENT);
                return null;
            }
        });
    }
}
