package css.com.applab;

import org.junit.Test;

import java.util.Random;

public class MathApi {
    @Test
    public void roundTest() {
        int value = (int) Math.ceil(24 * 1.0 / 4);
        System.out.println(value);
    }

    @Test
    public void randomTest() {
        int value = (int) (Math.random()*500);

        for (int i = 0; i < 5; i++) {
            Random random = new Random((long) (Math.random()*1000));
            System.out.println(random.nextInt());
        }
    }
}
