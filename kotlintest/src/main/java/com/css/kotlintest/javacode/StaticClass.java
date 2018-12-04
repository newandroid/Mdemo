package com.css.kotlintest.javacode;

import com.css.kotlintest.kotlinbase.KotlinCallJava;

import androidx.annotation.NonNull;

public class StaticClass {
    private KotlinCallJava kotlinObject;

    public StaticClass(KotlinCallJava kotlinObject) {
        this.kotlinObject = kotlinObject;
    }

    public static StaticClass with(@NonNull KotlinCallJava kotlinObject){
        return new StaticClass(kotlinObject);
    }

    public void doSomething(){
//        new SubType("kjkj");
    }

    public static class Type{
        public String type = "type";

        public Type() {
        }

        public Type(String type) {
            this.type = type;
        }
    }
    public static final class SubType extends Type{

    }
}
