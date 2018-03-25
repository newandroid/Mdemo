package css.com.designpattern.chapter5;

/**
 * Created by css on 2018-03-24.
 */

public class Q7 extends Car {
    @Override
    void move() {
        System.out.println(this.getClass().getName());
    }
}
