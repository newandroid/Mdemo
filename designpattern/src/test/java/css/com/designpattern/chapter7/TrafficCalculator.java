package css.com.designpattern.chapter7;

import org.junit.Test;

/**
 * Created by css on 2018/5/4.
 */
public class TrafficCalculator {
    CalculateStrategy calculateStrategy;

    public void setCalculateStrategy(CalculateStrategy calculateStrategy) {
        this.calculateStrategy = calculateStrategy;
    }
    public int calculatePrice(int km){
        return calculateStrategy.calculatePrice(km);
    }

    @Test
    public void show(){
        TrafficCalculator trafficCalculator = new TrafficCalculator();
        trafficCalculator.setCalculateStrategy(new BusStrategy());
        System.out.println(" 公交车乘16公里的价格"+   trafficCalculator.calculatePrice(16));

        trafficCalculator.setCalculateStrategy(new SubwayStrategy());
        System.out.println(" 地铁乘16公里的价格"+   trafficCalculator.calculatePrice(16));
    }
}
