package css.com.designpattern.chapter7;

/**
 * Created by css on 2018/5/4.
 */
public class BusStrategy implements CalculateStrategy {
    /**
     * 北京公交车，10公里内1元钱，超过10公里之后每加1元钱可以乘5公里
     * @param km
     * @return
     */
    @Override
    public int calculatePrice(int km) {
        //超过10公里的总距离
        int extraTotal = km - 10;
        //超过的距离是5公里的倍数
        int extraFactor = extraTotal / 5;
        //超过的距离对5公里取余
        int fraction = extraTotal % 5;
        //价格计算
        int price = 1 + extraFactor * 1;

        return fraction > 0 ? ++price : price;
    }
}
