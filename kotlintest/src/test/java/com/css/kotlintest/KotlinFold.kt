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
    @Test
    fun real(){
        val items = listOf(1,2,3,4,5)
        items.fold(0,{aac:Int,i:Int->
            println("aac =$aac,i = $i")
            val result = aac+i
            println("result=$result")
            result
        })

        val jointToString = items.fold("Elements:",{aac,i -> aac+" "+i})
        println(jointToString)

        val product = items.fold(1,Int::times)
        println(product)
    }
}