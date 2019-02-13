package css.com.applab.rxjava2;

import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.functions.Predicate;

public class RxTmp {
    @Test
    public void run() {
        Observable.just(1)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer != 1;
                    }
                })
                .subscribe(System.out::println);
    }
}
