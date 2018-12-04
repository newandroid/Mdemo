package com.css.test.daggertest.document.googlesample;

import dagger.Component;

@Component(modules = DropCaffeeModule.class)
public interface CoffeShop {
    CoffeeMaker maker();
}
