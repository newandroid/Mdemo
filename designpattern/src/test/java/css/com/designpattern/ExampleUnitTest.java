package css.com.designpattern;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void fileTest(){
        System.out.println(System.getProperty("user.home"));
        String absolutePath = new File("./").getAbsolutePath();
        System.out.println(absolutePath);
    }
}