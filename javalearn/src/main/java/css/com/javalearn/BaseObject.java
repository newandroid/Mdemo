package css.com.javalearn;

/**
 * Created by Administrator on 2017/11/18.
 */

public class BaseObject {
    private int fakeInt = 0;
    private String fakeStr = "init";

    public String getFakeStr() {
        return fakeStr;
    }

    private void setFakeStr(String fakeStr) {
        this.fakeStr = fakeStr;
    }



    private void setFakeInt(Integer fakeInt) {
        this.fakeInt = fakeInt;
    }

    public int getFakeInt(){
        return fakeInt;
    }
}
