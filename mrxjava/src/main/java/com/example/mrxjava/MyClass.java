package com.example.mrxjava;

import com.example.mrxjava.functions.Func1;
import com.example.mrxjava.operations.WatchableExtensions;
import com.example.mrxjava.reactive.IDisposable;
import com.example.mrxjava.reactive.IObservable;
import com.example.mrxjava.reactive.IObserver;

public class MyClass {

    public static void main(String[] args) {
        IObservable iObservable = WatchableExtensions.create(new Func1<IDisposable, IObserver<String>>() {
            @Override
            public IDisposable call(IObserver<String> iObserver) {
                iObserver.onNext("hello world");
//                iObserver.onError(new Exception());
                try {
                    Thread.sleep(2*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
        onCompleted.unsubscribe();

        iObservable.subscribe(new String(""));

    }
}
