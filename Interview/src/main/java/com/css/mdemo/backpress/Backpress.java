package com.css.mdemo.backpress;

import android.os.SystemClock;

/**
 * create by css on 2019/2/13
 */
public class Backpress {

    public void eventHappened() {
        System.out.println("Backpress.eventHappened");
        handlerEvent();
    }

    public void handlerEvent() {
        System.out.println("Backpress.handlerEvent");
        SystemClock.sleep(5000);
    }
    public void handlerComplete(){
        System.out.println("Backpress.handlerComplete");
    }

    public void circle() {
        for (int i = 0; i < 100; i++) {
            eventHappened();
            handlerEvent();
        }
    }
}
