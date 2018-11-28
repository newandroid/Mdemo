package com.css.test.daggertest.document;


import dagger.Module;
import dagger.Provides;

@Module
public class ComputerMoudel {
    @Provides
    Screen provideScrren(){
        return new Screen();
    }

    @Provides
    Headset provideHeadset(){
        return new Headset();
    }
}
