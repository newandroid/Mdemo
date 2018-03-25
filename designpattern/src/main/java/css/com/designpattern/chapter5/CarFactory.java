package css.com.designpattern.chapter5;

/**
 * Created by css on 2018-03-24.
 */

public abstract class CarFactory {
    abstract <T extends Car> T createCar(Class<T> clz);
}
