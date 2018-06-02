package css.com.designpattern.chapter2;

/**
 * Created by css on 2018-03-17.
 * 恶汉模式
 */

class Singleton {
    private static final Singleton ourInstance = new Singleton();

    static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {

    }
}
