package com.css.kotlintest

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * create by css on 2019/3/19
 */
class KotlinTest {
    @Test
    fun show() {
        GlobalScope.launch { // launch a new coroutine in background and continue
            delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
            println("World!") // print after delay
        }
        println("Hello,") // main thread continues while coroutine is delayed
        runBlocking {
            delay(2000L)  // ... while we delay for 2 seconds to keep JVM alive
        }

    }

    @Test
    fun other() = runBlocking <Unit>{
        GlobalScope.launch {
            delay(1000L)
            println("world!")
        }
        println("Hello,")
        delay(2000L)
    }

    @Test
    fun wait4job()= runBlocking{
        val job = GlobalScope.launch {
            delay(1000L)
            println("world!")
        }
        println("hello")
        job.join()
    }

}