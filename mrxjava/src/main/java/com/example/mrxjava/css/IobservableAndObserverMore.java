package com.example.mrxjava.css;

import com.example.mrxjava.functions.Func1;
import com.example.mrxjava.functions.Func2;
import com.example.mrxjava.reactive.AbstractIObservable;
import com.example.mrxjava.reactive.IDisposable;
import com.example.mrxjava.reactive.IObservable;
import com.example.mrxjava.reactive.IObserver;
import com.example.mrxjava.reactive.Notification;

import java.util.List;
import java.util.Map;

public class IobservableAndObserverMore {
    public static void main(String[] args) {
        IObservable iObservable = new AbstractIObservable(){
                    @Override
                    public IDisposable subscribe(IObserver observer) {
                        return null;
                    }
                };
        iObservable.subscribe(new IObserver(){
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onNext(Object args) {

            }
        });
    }
}
