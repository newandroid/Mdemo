package css.com.javalearn;

import java.lang.reflect.Method;

public class MyClass {
    public void testReflect(){
        try {
            BaseObject baseObject = new BaseObject();
            Method method = BaseObject.class.getMethod("setFakeStr",String.class);
            System.out.println("getFakeInt:"+baseObject.getFakeInt());
            method.invoke(baseObject,5);
            System.out.println("getFakeInt:"+baseObject.getFakeInt());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
