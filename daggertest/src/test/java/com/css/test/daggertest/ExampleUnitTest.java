package com.css.test.daggertest;

import com.css.test.daggertest.document.ComputerMoudel;
import com.css.test.daggertest.document.ComputerShop;
import com.css.test.daggertest.document.DaggerComputerShop;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        DaggerComputerShop.builder().computerMoudel(new ComputerMoudel()).build();
        ComputerShop computerShop = DaggerComputerShop.create();
        computerShop.sell().playGame();
    }
}