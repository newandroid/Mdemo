package com.css.kotlintest

import com.css.kotlintest.kotlinbase.KotlinBase
import org.junit.Test

import org.junit.Assert.*
import java.io.File

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    fun mul(a: Int, b: Int) = a * b
    @Test
    fun mytest() {
        val base = KotlinBase()
        base.main()
        base.isranges()
    }

    @Test
    fun mytest2() {
        for (x in 1..10 step 2) {
            print(x)
        }
        println()
        for (x in 9 downTo 0 step 3) {
            print(x)
        }
    }

    @Test
    fun mytestCollection() {
        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
        fruits
                .filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { println(it) }
    }

    @Test
    fun filetest(){
    }
}
