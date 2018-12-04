package com.css.test.daggertest.document;


import dagger.Module;
import dagger.Provides;

@Module
public class ComputerModule {
    @Provides
    Screen provideScreen(){
        return new Screen();
    }

    @Provides
    Headset provideHeadset(){
        return new Headset();
    }
}
