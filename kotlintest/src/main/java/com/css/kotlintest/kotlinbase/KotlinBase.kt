package com.css.kotlintest.kotlinbase

import android.widget.TextView
import com.css.kotlintest.EqualsBean
import java.util.*

class KotlinBase {
    fun main() {
        println("hello world")
    }

    fun sum(a: Int, b: Int): Int {
        println("sum of $a and $b is ${a + b}")
        return a + b
    }

    fun isranges() {
        val x = 10
        val y = 9
        if (x in 0..y) {
            println("fits in range")
        }
    }

    fun arrayDemo() {
        val list = ArrayList<TextView>()
    }

    fun <T, R> Collection<T>.fold(
            initial: R,
            combine: (acc: R, nextElement: T) -> R
    ): R {
        var accumulator: R = initial
        for (element: T in this) {
            accumulator = combine(accumulator, element)
        }
        return accumulator
    }

    fun testLambda(){
        val items = listOf(1,2,3,4,5)
//        val result = items.fold(0){
//            acc:Int,i:Int->
//            print("acc = $acc,i=$i, ")
//            val result = acc+i
//            println("result = $result")
//            result
//        }
//        println(result)
        val joinedToString = items.fold("elemnts:") { acc, i-> "$acc $i" }
        println(joinedToString)
//        val product = items.fold(1, Int::times)
    }

    public fun equalTest(){
        val bean = EqualsBean("css")
        println(bean.name=="css")
        println(bean.name==="css")
    }

}
