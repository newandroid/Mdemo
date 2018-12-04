package com.css.test.daggertest.document.googlesample;

import dagger.Module;
import dagger.Provides;

@Module
public class DropCaffeeModule {
    @Provides
    static Heater provideHeater(){
        return new ElectricHeater();
    }
    @Provides
    static Pump providerPump(Thermosiphon pump){
        return pump;
    }
}
