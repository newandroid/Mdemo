package css.com.designpattern.chapter8;

import org.junit.Test;

/**
 * Created by css on 2018/5/4.
 */
public class Client {
    @Test
    public void show(){
        TvController tvController = new TvController();
        tvController.powerOn();
        tvController.nextChannel();
        tvController.volUp();
        tvController.powerOff();
        //此时不会生效
        tvController.volDown();
    }
}
