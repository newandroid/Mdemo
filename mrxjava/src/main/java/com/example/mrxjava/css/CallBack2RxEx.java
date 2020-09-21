package com.example.mrxjava.css;

public class CallBack2RxEx {
    static class LaowangSun<T> implements Laowang {
        T t;

        public LaowangSun(T t) {
            this.t = t;
        }

        @Override
        public void callMeHaveLaunch(EatFood eatFood) {
            eatFood.haveLaunch(t);
        }
    }

    static interface Laowang {
        void callMeHaveLaunch(EatFood eatFood);
    }

    public interface EatFood {
        void haveLaunch(Object o);
    }

    public static void main(String[] args) {
        Laowang laowang = new LaowangSun<String>("lao wang sun");
        laowang.callMeHaveLaunch(new EatFood() {
            @Override
            public void haveLaunch(Object o) {
                System.out.println("ni ming have launch" + o);
            }
        });
    }
}
