package css.com.designpattern.chapter5;

/**
 * Created by css on 2018-03-24.
 */

public class MainTest {
    public void show(){
        new AudiFactory().createCar(Q5.class).move();
        new AudiFactory().createCar(Q7.class).move();
    }
}
