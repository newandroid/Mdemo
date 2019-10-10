package com.example.mrxjava.operations;

import com.example.mrxjava.functions.Func1;
import com.example.mrxjava.reactive.AbstractIObservable;
import com.example.mrxjava.reactive.IDisposable;
import com.example.mrxjava.reactive.IObservable;
import com.example.mrxjava.reactive.IObserver;

import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/* package */final class OperationFilter<T> extends AbstractIObservable<T> {
    private final IObservable<T> that;
    private final Func1<Boolean, T> predicate;

    OperationFilter(IObservable<T> that, Func1<Boolean, T> predicate) {
        this.that = that;
        this.predicate = predicate;
    }

    public IDisposable subscribe(IObserver<T> watcher) {
        final AtomicWatchableSubscription subscription = new AtomicWatchableSubscription();
        final IObserver<T> observer = new AtomicWatcher<T>(watcher, subscription);

        subscription.setActual(that.subscribe(new IObserver<T>() {
            public void onNext(T value) {
                try {
                    if ((boolean) predicate.call(value)) {
                        observer.onNext(value);
                    }
                } catch (Exception ex) {
                    observer.onError(ex);
                    subscription.unsubscribe();
                }
            }

            public void onError(Exception ex) {
                observer.onError(ex);
            }

            public void onCompleted() {
                observer.onCompleted();
            }
        }));

        return subscription;
    }

    public static class UnitTest {

        @Test
        public void testFilter() {
            IObservable<String> w = WatchableExtensions.toWatchable("one", "two", "three");
            IObservable<String> watchable = new OperationFilter<String>(w, new Func1<Boolean, String>() {

                @Override
                public Boolean call(String t1) {
                    if (t1.equals("two"))
                        return true;
                    else
                        return false;
                }
            });

            @SuppressWarnings("unchecked")
            IObserver<String> aWatcher = mock(IObserver.class);
            watchable.subscribe(aWatcher);
            verify(aWatcher, never()).onNext("one");
            verify(aWatcher, times(1)).onNext("two");
            verify(aWatcher, never()).onNext("three");
            verify(aWatcher, never()).onError(any(Exception.class));
            verify(aWatcher, times(1)).onCompleted();
        }
    }
}