package com.css.test.daggertest;

import dagger.Component;

@Component(modules = ComputerMoudel.class)
public interface ComputerShop {
    Computer sell();
}
