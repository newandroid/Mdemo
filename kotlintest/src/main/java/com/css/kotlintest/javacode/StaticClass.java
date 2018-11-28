package com.css.kotlintest.javacode;

import android.support.annotation.NonNull;

import com.css.kotlintest.kotlinbase.KotlinCallJava;

public class StaticClass {
    private KotlinCallJava kotlinObject;

    public StaticClass(KotlinCallJava kotlinObject) {
        this.kotlinObject = kotlinObject;
    }

    public static StaticClass with(@NonNull KotlinCallJava kotlinObject){
        return new StaticClass(kotlinObject);
    }

    public void doSomething(){

    }
}
