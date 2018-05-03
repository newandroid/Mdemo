package css.com.designpattern.chapter8;

/**
 * Created by css on 2018/5/4.
 * 开机状态，此时再触发开机功能不做任何动作
 */
public class PowerOnState implements TvState {
    @Override
    public void nextChannel() {
        System.out.println("下一个频道");
    }

    @Override
    public void preChannel() {
        System.out.println("上一个频道");
    }

    @Override
    public void volUp() {
        System.out.println("音量+");
    }

    @Override
    public void volDown() {
        System.out.println("音量-");
    }
}
