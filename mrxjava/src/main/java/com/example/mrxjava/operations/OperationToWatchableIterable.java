package com.example.mrxjava.operations;

import com.example.mrxjava.reactive.AbstractIObservable;
import com.example.mrxjava.reactive.IDisposable;
import com.example.mrxjava.reactive.IObservable;
import com.example.mrxjava.reactive.IObserver;

import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * Accepts an Iterable object and exposes it as an Observable.
 * 
 * @param <T>
 *            The type of the Iterable sequence.
 */
/* package */class OperationToWatchableIterable<T> extends AbstractIObservable<T> {
    public OperationToWatchableIterable(Iterable<T> list) {
        this.iterable = list;
    }

    public Iterable<T> iterable;

    public IDisposable subscribe(IObserver<T> watcher) {
        final AtomicWatchableSubscription subscription = new AtomicWatchableSubscription(WatchableExtensions.noOpSubscription());
        final IObserver<T> observer = new AtomicWatcher<T>(watcher, subscription);

        for (T item : iterable) {
            observer.onNext(item);
        }
        observer.onCompleted();

        return subscription;
    }

    public static class UnitTest {

        @Test
        public void testIterable() {
            IObservable<String> watchable = new OperationToWatchableIterable<String>(Arrays.<String> asList("one", "two", "three"));

            @SuppressWarnings("unchecked")
            IObserver<String> aWatcher = mock(IObserver.class);
            watchable.subscribe(aWatcher);
            verify(aWatcher, times(1)).onNext("one");
            verify(aWatcher, times(1)).onNext("two");
            verify(aWatcher, times(1)).onNext("three");
            verify(aWatcher, never()).onError(any(Exception.class));
            verify(aWatcher, times(1)).onCompleted();
        }
    }
}