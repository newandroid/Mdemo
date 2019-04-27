package com.css.kotlintest

import com.css.kotlintest.kotlinbase.KotlinBase
import org.junit.Test

/**
 * create by css on 2019/1/18
 */
class BaseTest2 {
    @Test
    fun run() {
        KotlinBase().equalTest()
    }

    @Test
    fun loopTest() {
        val arrayOf = arrayOf(0, 0, 1, 0, 0, 0)
        for (i in arrayOf) {
//            for (x in 0..i){//error
//                println(x)
//            }

            for (x in 1..i){//居然不出错，太神奇了
                println(x)
            }
        }

        //依据不出错，再次尝试
//        val arrayOf2 = arrayOf(0, 0, 3, 0, 0, 0)
//        for (i in arrayOf2) {
////            for (x in 4..i){
////                println(x)
////            }
//            for (x in 2..i) {
//                println(x)
//            }
//        }
    }
}