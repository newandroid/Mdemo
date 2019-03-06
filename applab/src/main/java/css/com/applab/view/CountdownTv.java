package css.com.applab.view;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import androidx.appcompat.widget.AppCompatTextView;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * create by css on 2019/3/4
 */
public class CountdownTv extends AppCompatTextView {
    private long startTime;
    private int periodSecond = 10;
    Disposable subscribe;

    public CountdownTv(Context context) {
        super(context);
        init();
    }

    public CountdownTv(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CountdownTv(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearSub();
    }

    private void init() {
        show(periodSecond);
    }

    public void start() {
        if (subscribe == null)
            subscribe = Observable.interval(0, 1, TimeUnit.SECONDS)
                    .take(periodSecond)
                    .subscribe(it -> {
                        show((int) (periodSecond - it - 1));
                    }, t -> System.out.println(t), () -> {
                        SystemClock.sleep(1000);
                        show(periodSecond);
                    });
    }

    public void reset() {
        clearSub();
        show(periodSecond);
    }

    private void show(int secondValue) {
        int hour = secondValue / (60 * 60);
        int min = (secondValue - hour * 60 * 60) / 60;
        int second = secondValue % (60 * 60);

        String result = String.format(Locale.getDefault(), "%02d:%02d:%02d", hour, min, second);
        if (!result.equals(getText().toString()))
            setText(result);
    }

    private void clearSub() {
        if (subscribe != null && !subscribe.isDisposed()) {
            subscribe.dispose();
            subscribe = null;
        }
    }


}
