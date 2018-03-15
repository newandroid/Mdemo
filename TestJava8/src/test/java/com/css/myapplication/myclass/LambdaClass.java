package com.css.myapplication.myclass;

import com.css.myapplication.myinterface.LambdaInterface;

/**
 * Created by Administrator on 2017/9/17.
 */

public class LambdaClass {
    private LambdaInterface lambdaInterface;
    public void setResult(String result){
        if (lambdaInterface!=null){
            lambdaInterface.show(result);
        }
    }

    public void setLambdaInterface(LambdaInterface lambdaInterface){
        this.lambdaInterface = lambdaInterface;
    }
    public static void show(String result){
        System.out.println(result);
    }
}
