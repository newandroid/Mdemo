package com.css.test.daggertest;

import com.css.test.daggertest.document.ComputerModule;
import com.css.test.daggertest.document.ComputerShop;
import com.css.test.daggertest.document.DaggerComputerShop;
import com.css.test.daggertest.document.googlesample.DaggerCoffeShop;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        DaggerComputerShop.builder().computerModule(new ComputerModule()).build();
        ComputerShop computerShop = DaggerComputerShop.create();
        computerShop.sell().playGame();
    }

    @Test
    public void testCoffee(){
        DaggerCoffeShop.create().maker().showFieldsClassName();
    }
}