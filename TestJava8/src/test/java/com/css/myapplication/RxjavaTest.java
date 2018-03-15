package com.css.myapplication;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/9/26.
 */

public class RxjavaTest {
    @Test
    public void myTest() {
        List<String> datas = createData();
        Observable.from(datas)
                .flatMap(Observable::just)
                .doOnNext(s -> System.out.println("before time:" + Calendar.getInstance().getTime()))
                .delay(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .subscribe(s -> {

                    System.out.println("" + s + ":" + Calendar.getInstance().getTime());
                });
    }

    @Test
    public void timestamp(){
        List<String> datas = createData();
        Observable.from(datas)
                .timestamp()
                .subscribe(s -> {
                    System.out.println(s);
                });
    }

    @Test
    public void timer(){
        List<String> datas = createData();
        Observable.timer(1,TimeUnit.SECONDS)
                .timestamp()
                .subscribe(s -> {
                    System.out.println(s);
                });
    }


    private List<String> createData(){
        List<String> datas = new ArrayList<>();
        datas.add("night");
        datas.add("moon");
        return datas;
    }
}
