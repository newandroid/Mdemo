package css.com.applab;

import java.io.Serializable;

public class SleepUtils implements Serializable {
    public static void sleep(){
        try {
            Thread.sleep(3000*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
