package com.css.test.daggertest.document;

import dagger.Component;

@Component(modules = ComputerMoudel.class)
public interface ComputerShop {
    Computer sell();
}
