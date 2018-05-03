package css.com.designpattern.chapter7;

/**
 * Created by css on 2018/5/4.
 */
public class SubwayStrategy implements CalculateStrategy {
    /**
     * 6公里(含)内3元，6~12公里（含）4元，12~22公里（含）5元，22~32公里（含）6元
     * @param km
     * @return
     */
    @Override
    public int calculatePrice(int km) {
        if (km<=6){
            return 3;
        }else if (km<=12){
            return 4;
        }else if (km<=22){
            return 5;
        }else if (km<=32){
            return 6;
        }else {
            return 7;
        }
    }
}
