package css.com.applab.leakcheck;

import android.os.SystemClock;

public class WorkClass {
    private LeakCallBack callBack;

    public WorkClass(LeakCallBack callBack) {
        this.callBack = callBack;
    }

    public void doSomething() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(60 * 1000);
                System.out.println("WorkClass.run");
                if (callBack != null) callBack.onCall();
            }
        }).start();
    }
}
