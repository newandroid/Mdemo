package css.com.applab.rxjava2;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import io.reactivex.subjects.PublishSubject;

public class DelayTest {
    static PublishSubject<Integer> deleteResponsDebounceSubject = PublishSubject.create();
    static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
    public static void main(String[] args) {

        System.out.println("start "+sdf.format(System.currentTimeMillis()));
        deleteResponsDebounceSubject.debounce(3, TimeUnit.SECONDS).subscribe(s -> {
            System.out.println("happen "+sdf.format(System.currentTimeMillis()));
        });
        deleteResponsDebounceSubject.onNext(1);
        try {
            Thread.sleep(2*1000);
            deleteResponsDebounceSubject.onNext(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1*1000);
            deleteResponsDebounceSubject.onNext(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(10*1000);
            System.out.println("end "+sdf.format(System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
