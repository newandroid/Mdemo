package css.com.applab.rxjava2;

import org.junit.Test;

import io.reactivex.Flowable;

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
        empty.subscribe(s -> System.out.println("1"));
        empty.subscribe(s -> System.out.println("2"));
    }
}
