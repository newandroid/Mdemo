package com.example.mrxjava.operations;

import com.example.mrxjava.reactive.AbstractIObservable;
import com.example.mrxjava.reactive.IDisposable;
import com.example.mrxjava.reactive.IObservable;
import com.example.mrxjava.reactive.IObserver;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * Returns the last element of an observable sequence.
 * 
 * @param <T>
 */
/* package */final class OperationLast<T> extends AbstractIObservable<T> {
    private final AtomicReference<T> lastValue = new AtomicReference<T>();
    private final IObservable<T> that;
    private final AtomicBoolean onNextCalled = new AtomicBoolean(false);

    OperationLast(IObservable<T> that) {
        this.that = that;
    }

    public IDisposable subscribe(final IObserver<T> watcher) {
        final AtomicWatchableSubscription subscription = new AtomicWatchableSubscription();
        final IObserver<T> observer = new AtomicWatcher<T>(watcher, subscription);

        subscription.setActual(that.subscribe(new IObserver<T>() {
            public void onNext(T value) {
                onNextCalled.set(true);
                lastValue.set(value);
            }

            public void onError(Exception ex) {
                observer.onError(ex);
            }

            public void onCompleted() {
                if (onNextCalled.get()) {
                    observer.onNext(lastValue.get());
                }
                observer.onCompleted();
            }
        }));

        return subscription;
    }

    public static class UnitTest {

        @Test
        public void testLast() {
            IObservable<String> w = WatchableExtensions.toWatchable("one", "two", "three");
            IObservable<String> watchable = new OperationLast<String>(w);

            @SuppressWarnings("unchecked")
            IObserver<String> aWatcher = mock(IObserver.class);
            watchable.subscribe(aWatcher);
            verify(aWatcher, never()).onNext("one");
            verify(aWatcher, never()).onNext("two");
            verify(aWatcher, times(1)).onNext("three");
            verify(aWatcher, never()).onError(any(Exception.class));
            verify(aWatcher, times(1)).onCompleted();
        }
    }
}