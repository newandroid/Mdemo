package com.example.mrxjava.css;

import com.example.mrxjava.functions.Func1;
import com.example.mrxjava.functions.Func2;
import com.example.mrxjava.reactive.IDisposable;
import com.example.mrxjava.reactive.IObservable;
import com.example.mrxjava.reactive.IObserver;
import com.example.mrxjava.reactive.Notification;

import java.util.List;
import java.util.Map;

public class IobservableAndObserver {
    public static void main(String[] args) {
        IObservable iObservable = new IObservable() {
            @Override
            public IDisposable subscribe(IObserver watcher) {
                return null;
            }

            @Override
            public IObservable filter(Object callback) {
                return null;
            }

            @Override
            public IObservable filter(Func1 predicate) {
                return null;
            }

            @Override
            public IObservable last() {
                return null;
            }

            @Override
            public IObservable map(Object callback) {
                return null;
            }

            @Override
            public IObservable map(Func1 func) {
                return null;
            }

            @Override
            public IObservable mapMany(Object callback) {
                return null;
            }

            @Override
            public IObservable mapMany(Func1 func) {
                return null;
            }

            @Override
            public IObservable<Notification> materialize() {
                return null;
            }

            @Override
            public IObservable onErrorResumeNext(IObservable resumeSequence) {
                return null;
            }

            @Override
            public IObservable onErrorResumeNext(Func1 resumeFunction) {
                return null;
            }

            @Override
            public IObservable onErrorResumeNext(Object resumeFunction) {
                return null;
            }

            @Override
            public IObservable onErrorReturn(Func1 resumeFunction) {
                return null;
            }

            @Override
            public IObservable onErrorReturn(Object resumeFunction) {
                return null;
            }

            @Override
            public IObservable reduce(Func2 accumulator) {
                return null;
            }

            @Override
            public IObservable reduce(Object accumulator) {
                return null;
            }

            @Override
            public IObservable reduce(Object initialValue, Func2 accumulator) {
                return null;
            }

            @Override
            public IObservable reduce(Object initialValue, Object accumulator) {
                return null;
            }

            @Override
            public IObservable scan(Func2 accumulator) {
                return null;
            }

            @Override
            public IObservable scan(Object accumulator) {
                return null;
            }

            @Override
            public IObservable scan(Object initialValue, Func2 accumulator) {
                return null;
            }

            @Override
            public IObservable scan(Object initialValue, Object accumulator) {
                return null;
            }

            @Override
            public IObservable skip(int num) {
                return null;
            }

            @Override
            public IDisposable subscribe(Map callbacks) {
                return null;
            }

            @Override
            public IDisposable subscribe(Object onNext) {
                return null;
            }

            @Override
            public IDisposable subscribe(Object onNext, Object onError) {
                return null;
            }

            @Override
            public IDisposable subscribe(Object onNext, Object onError, Object onComplete) {
                return null;
            }

            @Override
            public IObservable take(int num) {
                return null;
            }

            @Override
            public IObservable<List> toList() {
                return null;
            }

            @Override
            public IObservable<List> toSortedList() {
                return null;
            }

            @Override
            public IObservable<List> toSortedList(Func2 sortFunction) {
                return null;
            }

            @Override
            public IObservable<List> toSortedList(Object sortFunction) {
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
