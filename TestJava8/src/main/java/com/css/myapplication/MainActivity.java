package com.css.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.hoho).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> datas = createData();
                Observable.from(datas)
                        .concatMap(s -> Observable.just(s).delay(1,TimeUnit.SECONDS))
                        .subscribe(s -> System.out.println(s));
            }
        });
    }

    private List<String> createData() {
        List<String> datas = new ArrayList<>();
        datas.add("night");
        datas.add("moon");
        return datas;
    }

    private Queue<String> createQueue() {
        Queue<String> datas = new ArrayDeque<>();
        datas.add("night");
        datas.add("moon");
        return datas;
    }

}
