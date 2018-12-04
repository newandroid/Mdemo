package com.css.test.daggertest.document.googlesample;

import javax.inject.Inject;

public class CoffeeMaker {
    Heater heater;
    Pump pump;
    @Inject
    public CoffeeMaker(Heater heater, Pump pump) {
        this.heater = heater;
        this.pump = pump;
    }

    public void showFieldsClassName() {
        System.out.println(heater.getClass().getSimpleName()
                + "  "
                + pump.getClass().getSimpleName());
    }
}
