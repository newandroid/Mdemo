package com.css.kotlintest

import org.junit.Test

/**
 * create by css on 2019/3/19
 */
class KotlinTest {
    @Test
    fun show() {
        val wait = arrayListOf<Int>(1, 2, 3, 4, 5)

        //continute braak goto
        for (n in wait.indices) {
            println(wait[n])
            if (n == 2) return
        }
    }

}