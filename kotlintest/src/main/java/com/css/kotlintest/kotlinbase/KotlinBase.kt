package com.css.kotlintest.kotlinbase

class KotlinBase {
    fun main() {
        println("hello world")
    }

    fun sum(a: Int, b: Int): Int {
        println("sum of $a and $b is ${a + b}")
        return a + b
    }

    fun isranges(){
        val x = 10
        val y = 9
        if (x in 0..y){
            println("fits in range")
        }
    }
}
