package css.com.designpattern.chapter7;

/**
 * Created by css on 2018/5/4.
 */
public class TaxiStrategy implements CalculateStrategy {
    @Override
    public int calculatePrice(int km) {
        return km * 2;
    }
}
