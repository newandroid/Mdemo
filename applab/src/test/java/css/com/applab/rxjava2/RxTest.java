package css.com.applab.rxjava2;

import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Cancellable;
import io.reactivex.functions.Consumer;


public class RxTest {
    @Test
    public void hhahha() {
        Observable.just("jjjj")
                .map(s -> {
                    System.out.println("do something");
                    return Observable.just(s);
                })
                .map(s -> {
                    System.out.println("do something222");
                    return Observable.just(s);
                })
                .subscribe();
    }

    ObservableEmitter<String> gload=null;
    @Test
    public void run() {
        ObservableOnSubscribe<String> observableOnSubscribe = new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                gload = e;
                e.onNext("this is on next");
//                e.onError(new RuntimeException("custom"));
//                e.onComplete();
            }
        };

        Consumer<String> onNextConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("RxTest.accept s:" + s);
            }
        };

        Consumer<Throwable> onErrorConsumer = new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
            }
        };

        Action onCompleteAction = new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("RxTest.run");
            }
        };


        ObservableEmitter<String> observableEmitter = new ObservableEmitter<String>() {
            @Override
            public void setDisposable(Disposable d) {

            }

            @Override
            public void setCancellable(Cancellable c) {

            }

            @Override
            public boolean isDisposed() {
                return false;
            }

            @Override
            public ObservableEmitter<String> serialize() {
                return null;
            }

            @Override
            public boolean tryOnError(Throwable t) {
                return false;
            }

            @Override
            public void onNext(String value) {

            }

            @Override
            public void onError(Throwable error) {

            }

            @Override
            public void onComplete() {

            }
        };
//        try {
//            observableOnSubscribe.subscribe(observableEmitter);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        observableEmitter.onNext(" you know,i love you");
        Observable<String> stringObservable = Observable.create(observableOnSubscribe);
        Disposable disposable = stringObservable.subscribe(onNextConsumer, onErrorConsumer, onCompleteAction);
//        gload.onNext("you know,i cannot love you");
//        disposable.dispose();
    }
}
