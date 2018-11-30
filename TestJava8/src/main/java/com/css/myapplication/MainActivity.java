package com.css.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import rx.Observable;

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
