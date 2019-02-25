package css.com.applab.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import androidx.annotation.Nullable;
import css.com.applab.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * create by css on 2019/1/15
 */
public class Rxjava2RuntimeActivity extends Activity {
    int count = 0;
    TextView delayTv;
    TextView correntTv;
    PublishSubject<Integer> debounceSubject = PublishSubject.create();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        delayTv = findViewById(R.id.delayTv);
        delayTv.setText("" + count);
        correntTv = findViewById(R.id.correntTv);
        correntTv.setText("" + count);
//        TimeoutTest.main(null);
        debounceSubject.subscribeOn(Schedulers.io())
                .delay(3,TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> delayTv.setText("" + s));
    }

    public void click(View view) {
        count++;
        correntTv.setText("" + count);
        debounceSubject.onNext(count);

    }
}
