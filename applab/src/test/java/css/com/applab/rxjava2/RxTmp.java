package css.com.applab.rxjava2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

public class RxTmp {
    @Test
    public void run(){
        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(1);
        data.add(1);
        data.add(1);

        Flowable.just(data)
                .subscribe(it-> System.out.println(it));
    }
}
