package com.css.kotlintest

import org.junit.Test

/**
 * higher-order function
 * fold (also termed reduce, accumulate, aggregate, compress, or inject)
 */
class KotlinFold {
    fun defaultParam(name: String = "css", subName: String) {
        println("name:$name subName:$subName")
    }

    fun mulParam(vararg name: String) {
        name.forEach { print("$it ") }
    }


    @Test
    fun run() {
//        defaultParam()//error
//        defaultParam("cen")//error
        //named param
        defaultParam(subName = "cen")

        mulParam("zhangsan", "lisi", "wangwu")
        println()

        infix fun Int.sh1(x: Int): Int {
            return this * x
        }

        println(5 shl 2)
    }
}