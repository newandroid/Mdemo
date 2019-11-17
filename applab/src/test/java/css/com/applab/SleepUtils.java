package css.com.applab;

public class SleepUtils {
    public static void sleep(){
        try {
            Thread.sleep(3000*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
