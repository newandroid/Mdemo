package com.css.kotlintest

import org.junit.Test

class KotlinOnceTest{
    //不会用
//    val p: String by lazy {
//        // compute the string
//    }

    @Test
    fun run(){
        val result = """
            |i have a dream
            |that one day
        """.trimMargin()
        println(result)

        "your name".also { println(it) }
    }
}