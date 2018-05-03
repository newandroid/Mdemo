package css.com.designpattern.chapter8;

/**
 * Created by css on 2018/5/4.
 */
public class TvController implements PowerController {
    TvState tvState;

    public void setTvState(TvState tvState) {
        this.tvState = tvState;
    }

    @Override
    public void powerOn() {
        setTvState(new PowerOnState());
        System.out.println("开机啦");
    }

    @Override
    public void powerOff() {
        setTvState(new PowerOffState());
        System.out.println("关机啦");
    }

    public void nextChannel() {
        tvState.nextChannel();
    }

    public void preChannel() {
        tvState.preChannel();
    }

    public void volUp() {
        tvState.volUp();
    }

    public void volDown() {
        tvState.volDown();
    }
}
