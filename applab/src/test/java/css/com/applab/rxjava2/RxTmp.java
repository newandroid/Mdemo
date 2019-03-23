package css.com.applab.rxjava2;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

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
    @Test
    public void run2() {
        Observable.interval(0,1,TimeUnit.SECONDS)
                .take(5)
                .subscribe(System.out::println);
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private AtomicInteger count = new AtomicInteger();
    @Test
    public void run3() {
        Observable.interval(0,1,TimeUnit.SECONDS)
                .subscribe(it->{
                    count.set(count.get()+1);
                    System.out.println("###111 count:"+count);
                });
        try {
            Thread.sleep(3*1000);
            count.set(0);
            System.out.println("###333 count:"+count);
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
