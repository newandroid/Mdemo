package css.com.datastructureandalgorithms;

import java.util.Arrays;
import java.util.Collections;

/**
 * create by css on 2019/1/23
 */
public class MyTree<T> {
    T value;
    MyTree parent;
    MyTree[] sub = new MyTree[]{};

    public void addSub(MyTree myTree) {
        MyTree[] newSub = new MyTree[sub.length + 1];
//        Collections.copy();
    }

    public void deleteLastSub() {

    }

    public void modify() {

    }

    public MyTree get() {
        return null;
    }

    public void loop() {

    }

}
