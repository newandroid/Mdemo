package css.com.applab;

import org.junit.Test;

public class MathApi {
    @Test
    public void roundTest(){
        int value = (int) Math.ceil(24 * 1.0 / 4);
        System.out.println(value);
    }
}
