package css.com.applab.view;

import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;

import java.lang.ref.WeakReference;
import java.util.Locale;

import androidx.appcompat.widget.AppCompatTextView;


/**
 * create by css on 2019/3/4
 */
public class CountdownTv extends AppCompatTextView {
    private long startTimestamp;
    private int periodSecond;
    private MyHandler myHandler;
    private Listener listener;
    private boolean isKeepGoing = false;

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
//        if (isTimerRunning()) stopTimer();
    }

    private void init() {
        myHandler = new MyHandler(this);
        show(periodSecond);
    }

    public void start(long lastTimstamp, int periodSecond, boolean isOn) {
        this.startTimestamp = lastTimstamp;
        this.periodSecond = periodSecond;
        show(periodSecond);
        if (isNeedStopTimer(lastTimstamp, periodSecond, isOn)) {//停止计时
            if (isTimerRunning()) stopTimer();
            show(periodSecond);
        } else {//开始计时
            if (!isTimerRunning()) {//启动定时器
                startTimer();
            }
        }
    }

    public static boolean isNeedStopTimer(long lastTimstamp, int periodSecond, boolean isOn) {
        return !isOn || ((lastTimstamp + periodSecond * 1000) < System.currentTimeMillis());
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    private void show(int secondValue) {
        int hour = secondValue / (60 * 60);
        int min = (secondValue - hour * 60 * 60) / 60;
        int second = secondValue % 60;

        String result = String.format(Locale.getDefault(), "%02d:%02d:%02d", hour, min, second);
        if (!result.equals(getText().toString()))
            setText(result);
    }


    private static final class MyHandler extends android.os.Handler {
        WeakReference<CountdownTv> countdownTvWeakReference;

        MyHandler(CountdownTv countdownTv) {
            countdownTvWeakReference = new WeakReference<>(countdownTv);
        }

        @Override
        public void handleMessage(Message msg) {
            CountdownTv countdownTv = countdownTvWeakReference.get();
            if (countdownTv == null) return;
            if (countdownTv.getRemainTime() < 0) {
                countdownTv.stopTimer();
//                countdownTv.show(countdownTv.periodSecond);
            } else {
                countdownTv.show(countdownTv.getRemainTime());
            }

        }
    }

    private class SleepThread implements Runnable {
        @Override
        public void run() {
            while (isKeepGoing) {
                SystemClock.sleep(1000);
                if (isKeepGoing) {
                    myHandler.sendEmptyMessage(1);
                }
            }
        }
    }


    private void startTimer() {
        System.out.println("CountdownTv.startTimer " + this);
        isKeepGoing = true;
        new Thread(new SleepThread()).start();
    }

    private void stopTimer() {
        isKeepGoing = false;
        System.out.println("CountdownTv.stopTimer " + this);
        show(periodSecond);
        if (listener != null) listener.onStopTime();
    }

    private boolean isTimerRunning() {
        return isKeepGoing;
    }

    /**
     * @return 获取剩余时间=持续-（现在-开始）
     */
    private int getRemainTime() {
        return periodSecond - (int) ((System.currentTimeMillis() - startTimestamp) / 1000);
    }

    public interface Listener {
        void onStopTime();
    }

}
