package css.com.designpattern.chapter8;

/**
 * Created by css on 2018/5/4.
 * 电视机状态，定义了电视操作的函数
 */
public interface TvState {
    public void nextChannel();
    public void preChannel();
    public void volUp();
    public void volDown();
}
