package com.example.mrxjava;

import com.example.mrxjava.functions.Func1;
import com.example.mrxjava.operations.WatchableExtensions;
import com.example.mrxjava.reactive.IDisposable;
import com.example.mrxjava.reactive.IObserver;

public class AsyncConcept {
    public static void main(String[] args) {
        WatchableExtensions.create(new Func1<IDisposable, IObserver<String>>() {
            @Override
            public IDisposable call(IObserver<String> iObserver) {
                System.out.println(Thread.currentThread().toString());
                iObserver.onNext("hello world");
                return null;
            }
        }).subscribe(new IObserver<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onNext(String args) {
                System.out.println(Thread.currentThread().toString());
                System.out.println(args);
            }
        });
    }
}
