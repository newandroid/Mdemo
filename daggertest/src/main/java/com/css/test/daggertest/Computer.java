package com.css.test.daggertest;

import javax.inject.Inject;

public class Computer {
    private Screen screen;
    private Headset headset;

    @Inject
    public Computer(Screen screen, Headset headset) {
        this.screen = screen;
        this.headset = headset;
    }

    public void playGame(){
        System.out.println(screen.getClass().getSimpleName());
        System.out.println(headset.getClass().getSimpleName());
        System.out.println("dota2 run");
    }
}
