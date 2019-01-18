package com.css.kotlintest.javacode;

import androidx.annotation.NonNull;

/**
 * create by css on 2019/1/18
 */
public interface Function<T, R> {
    /**
     * Apply some calculation to the input value and return some other value.
     * @param t the input value
     * @return the output value
     * @throws Exception on error
     */
    R apply(@NonNull T t) throws Exception;
}