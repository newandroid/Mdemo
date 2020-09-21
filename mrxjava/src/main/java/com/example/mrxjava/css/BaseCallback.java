package com.example.mrxjava.css;

public class BaseCallback {
    static class Me implements EatFood {
        void doSomething() {
            new Laowang().callMeHaveLaunch(Me.this);
        }

        @Override
        public void haveLaunch() {
            System.out.println("Me.haveLaunch");
        }
    }


    static class Laowang {
        void callMeHaveLaunch(EatFood eatFood) {
            eatFood.haveLaunch();
        }
    }

    public interface EatFood {
        void haveLaunch();
    }

    public static void main(String[] args) {
        new Me().doSomething();

        new Laowang().callMeHaveLaunch(new EatFood() {
            @Override
            public void haveLaunch() {
                System.out.println("ni ming have launch");
            }
        });
    }

}
