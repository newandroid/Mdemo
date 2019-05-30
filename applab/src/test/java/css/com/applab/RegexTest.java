package css.com.applab;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * create by css on 2019/5/8
 */
public class RegexTest {
    @Test
    public void hoho() {
        Pattern pattern = Pattern.compile("([\\w])\\1{2,}|((?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)|9(?=0)){2,})");
        String wait = "12345678";
        Matcher matcher = pattern.matcher(wait);
        System.out.println(matcher.find());
    }
    @Test
    public void office(){
        Pattern pattern =
                Pattern.compile("");
    }
}
