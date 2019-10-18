package com.example.mrxjava;

import com.example.mrxjava.functions.Func1;
import com.example.mrxjava.operations.WatchableExtensions;
import com.example.mrxjava.reactive.AbstractIObservable;
import com.example.mrxjava.reactive.IDisposable;
import com.example.mrxjava.reactive.IObservable;
import com.example.mrxjava.reactive.IObserver;

public class MyClass {
    static final String CONTENT = "content";

    public static void main(String[] args) {
        testRealBase();
//        testpullpush();
//        testEmpty();
//        testEvent();
//        testAsync();
    }

    private static void testRealBase() {

        IObservable<String> iObservable = new AbstractIObservable<String>() {
            @Override
            public IDisposable subscribe(IObserver<String> observer) {
//                final IObserver<String> ooobserver = new AtomicWatcher<String>(observer, iDisposable);
                observer.onNext("hello");
                return null;
            }
        };
        iObservable.subscribe(new IObserver<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onNext(String args) {

            }
        });
    }

    private static void testEmpty() {
        WatchableExtensions.empty().subscribe(new IObserver<Object>() {
            @Override
            public void onCompleted() {
                System.out.println("MyClass.onCompleted");
            }

            @Override
            public void onError(Exception e) {
                System.out.println("MyClass.onError");
            }

            @Override
            public void onNext(Object args) {
                System.out.println("MyClass.onNext");
            }
        });
    }

    private static void testEvent() {

        IObservable iObservable = WatchableExtensions.create(new Func1<IDisposable, IObserver<String>>() {
            @Override
            public IDisposable call(IObserver<String> iObserver) {
                //event 装载的地方
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
        IObserver iObserver = new IObserver<String>() {
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
                //事件消费的地方
                System.out.println(args);
            }
        };
//        WatchableExtensions.empty().subscribe(iObserver);
        IDisposable onCompleted = iObservable.subscribe(iObserver);//桥梁
//        onCompleted.unsubscribe();//无效

//        iObservable.subscribe(new String(""));

    }

    static void testpullpush() {
        //normal implement
        String dataPull = getDataPull();
        System.out.println(dataPull);//阻塞式的

        //push implement
        IObservable<String> dataPush = getDataPush();
        dataPush.subscribe(new MOnNextImplement<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }

    static void testAsync() {

    }

    public static String getDataPull() {
        return CONTENT;
    }

    public static IObservable<String> getDataPush() {
        return WatchableExtensions.create(func1);
    }

    static Func1 func1 = new Func1<IDisposable, IObserver<String>>() {
        @Override
        public IDisposable call(IObserver<String> iObserver) {
            iObserver.onNext(CONTENT);
            return null;
        }
    };

    static abstract class MOnNextImplement<T> implements IObserver<T> {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Exception e) {

        }

        @Override
        public void onNext(T args) {
            call(args);
        }

        public abstract void call(T t);
    }

    static class BaseIDisposable implements IDisposable {
        private boolean isDisposage = false;

        @Override
        public void unsubscribe() {
            isDisposage = true;
        }

        public boolean isUnsubscribed() {
            return isDisposage;
        }
    }

    static class BaseWatch{
        IObserver observer;
    }
    static class BaseWatchable<T> extends AbstractIObservable{
        Iterable<T> content;

        public BaseWatchable(Iterable<T> content) {
            this.content = content;
        }

        @Override
        public IDisposable subscribe(IObserver observer) {
            BaseIDisposable baseIDisposable = new BaseIDisposable();
            observer.onNext("121");
            return null;
        }
    }


}
