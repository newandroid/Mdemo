package css.com.designpattern.chapter6;

/**
 * Created by css on 2018-03-25.
 */

public class ImplementFactory extends AbstractFactory {

    @Override
    ImplementProduct productA() {
        return new ImplementProduct("a");
    }

    @Override
    ImplementProduct productB() {
        return new ImplementProduct("b");
    }
}
