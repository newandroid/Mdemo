package com.example.mrxjava.css;

public class CallBack2Rx {

    static interface Laowang {
        void callMeHaveLaunch(EatFood eatFood);
    }

    public interface EatFood {
        void haveLaunch();
    }

    public static void main(String[] args) {
        Laowang laowang = new Laowang() {
            @Override
            public void callMeHaveLaunch(EatFood eatFood) {
                eatFood.haveLaunch();
            }
        };
        laowang.callMeHaveLaunch(new EatFood() {
            @Override
            public void haveLaunch() {
                System.out.println("ni ming have launch");
            }
        });
    }
}
