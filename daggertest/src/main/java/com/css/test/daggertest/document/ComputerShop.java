package com.css.test.daggertest.document;

import dagger.Component;

@Component(modules = ComputerModule.class)
public interface ComputerShop {
    Computer sell();
}
