package css.com.applab;

import android.content.pm.PackageManager;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    PackageManager packageManager;

    @Test
    public void addition_isCorrect() {
        System.out.println(input(0));

    }

    /**
     * @param value 400-1
     * @return 0-1
     */
    public float input(int value) {
        float e = 1f / 400;
        return 1 - value * e;
    }
}