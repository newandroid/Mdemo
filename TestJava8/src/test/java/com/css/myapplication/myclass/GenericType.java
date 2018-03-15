package com.css.myapplication.myclass;

/**
 * Created by Administrator on 2017/9/17.
 */

public class GenericType<T> {
    private T data;
    public void setData(T data){
        this.data = data;
    }
    public T getData(){
        return data;
    }
}
