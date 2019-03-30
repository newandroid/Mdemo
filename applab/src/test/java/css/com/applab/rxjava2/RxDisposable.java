package css.com.applab.rxjava2;

import org.junit.Test;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/**
 * create by css on 2019/3/30
 */
public class RxDisposable {
    @Test
    public void show() {
        PublishSubject<String> publishSubject = PublishSubject.create();
        Disposable subscribe = publishSubject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("RxDisposable.onNext");
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                System.out.println("RxDisposable.onError:" + throwable.getMessage());
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("RxDisposable.onComplete");
            }
        }, new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                System.out.println("RxDisposable.onSubscribe Disposable");
            }
        });
        publishSubject.onNext("hello");
        publishSubject.onComplete();
        try {
            RuntimeException haha = new RuntimeException("haha");
        }catch (Exception exc){
            publishSubject.onError(exc);
        }
        subscribe.dispose();
        publishSubject.onNext("hello");
        publishSubject.onNext("hello");
    }
}
