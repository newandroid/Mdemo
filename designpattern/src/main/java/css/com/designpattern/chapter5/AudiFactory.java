package css.com.designpattern.chapter5;

/**
 * Created by css on 2018-03-24.
 */

public class AudiFactory extends CarFactory {

    @Override
    <T extends Car> T createCar(Class<T> clz) {
        Car car = null;
        try {
            car = (Car) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
        }
        return (T) car;
    }
}
