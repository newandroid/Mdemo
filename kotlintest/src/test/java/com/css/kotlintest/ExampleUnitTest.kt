package com.css.kotlintest

import com.css.kotlintest.kotlinbase.KotlinBase
import org.junit.Test

import org.junit.Assert.*

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
    @Test
    fun mytest(){
        val base = KotlinBase()
        base.main()
    }
}
