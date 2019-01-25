package css.com.applab.rxjava2;

import org.junit.Test;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;

/**
 * create by css on 2019/1/14
 */
public class FlowableTest {
    @Test
    public void hello(){
        Flowable<String> stringFlowable = Flowable.just("hello world!");
        stringFlowable.subscribe(s -> System.out.println("1"));
        stringFlowable.subscribe(s -> System.out.println("2"));
    }

    @Test
    public void empty(){
        Flowable<Object> empty = Flowable.empty();
        empty.subscribe(new FlowableSubscriber<Object>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {
                System.out.println("3");
            }
        });
        empty.subscribe(s -> System.out.println("1"));
        empty.subscribe(s -> System.out.println("2"));
    }
}
