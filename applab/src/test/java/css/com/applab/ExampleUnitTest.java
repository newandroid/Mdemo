package css.com.applab;

import android.content.pm.PackageManager;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    PackageManager packageManager;
InputStream inputStream;
    @Test
    public void addition_isCorrect() {
        HashMap h = new HashMap();
        System.out.println(input(0));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int c;
    }

    /**
     * @param value 400-1
     * @return 0-1
     */
    public float input(int value) {
        float e = 1f / 400;
        return 1 - value * e;
    }


    @Test
    public void hoho(){
        AtomicInteger atomicInteger= new AtomicInteger(10);
        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.decrementAndGet());
    }
}