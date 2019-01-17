package css.com.applab.rxjava2;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * create by css on 2019/1/17
 */
public class TimeoutTest {
    public static void main(String[] args) {

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                System.out.println("begin");
                e.onNext("time out");
            }
        }).timeout(5, TimeUnit.SECONDS)
                .subscribe(s -> System.out.println(s),Throwable::printStackTrace);
    }
}
