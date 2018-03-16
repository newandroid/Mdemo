package css.com.designpattern.chapter2;

import java.io.ObjectStreamException;

/**
 * Created by css on 2018-03-17.
 */

public class SingletonLazy {
    private SingletonLazy(){}
    public SingletonLazy getInstance(){
        return SingletonLazyHolder.sInstance;
    }

    private static class SingletonLazyHolder{
        private static final SingletonLazy sInstance = new SingletonLazy();
    }

    //杜绝单例对象在反序列化时重新生成对象
    private Object readResolve() throws ObjectStreamException{
        return SingletonLazyHolder.sInstance;
    }
}
