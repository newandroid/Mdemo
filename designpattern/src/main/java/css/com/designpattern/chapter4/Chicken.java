package css.com.designpattern.chapter4;

import java.util.ArrayList;

/**
 * Created by css on 2018-03-24.
 * 原型模式
 */

public class Chicken implements Cloneable{
    int age;
    ArrayList<String> name = new ArrayList<>();

    @Override
    public Object clone(){
        try{
            Chicken chicken = (Chicken) super.clone();
            chicken.age = this.age;
            chicken.name = (ArrayList<String>) this.name.clone();
        }catch (Exception e){}
        return null;
    }
}
