package com.css.kotlintest

import com.css.kotlintest.kotlinbase.KotlinBase
import com.css.kotlintest.kotlinbase.function
import org.junit.Assert.assertEquals
import org.junit.Test
import java.nio.file.Files
import java.nio.file.Paths

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class KotlinUnitTest {
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
    fun filetest() {
        val stream = Files.newInputStream(Paths.get("C:\\Users\\WIN10\\Desktop\\temp\\temp\\myfiles.txt"))
        stream.buffered().reader().use { reader ->
            println(reader.readText())
        }
    }

    @Test
    fun invokeParamTest() {
        pringSum(4, 7)
    }

    fun pringSum(a: Int, b: Int) {
        println("a+b value is ${a + b}")
    }

    @Test
    fun forIndices() {
        val datas = arrayOf("apple", "android", "wp")
        for (n in datas.indices) {
            println("$n ${datas[n]}")
        }
    }

    @Test
    fun extensionFunction() {
        fun KotlinBase.extensionPrint() {
            println("i am extension")
        }
        KotlinBase().extensionPrint()
    }

    @Test
    fun invokeFuntionFile() {
        function()
    }

    @Test
    fun testlambda() {
        KotlinBase().testLambda()
    }

    @Test
    fun testlambda2() {
        fun lambdaFunction(str: String, caculateFunction: (data: Int) -> Int) {
            println(str)
            val testdata = 5
            println(caculateFunction(testdata))
        }

//        lambdaFunction("unknow param") { println(it) }
        lambdaFunction("unknow param",{
            other->
            println(other)
        })
        println("-----------")
        lambdaFunction("unknow param") { noParamFunction() }
        println("-----------")
        lambdaFunction("unknow param") { oneParamFunction(it) }
        println("-----------")
        lambdaFunction("unknow param") { twoParamFunction(it, 10.toDouble()) }
        println("-----------")
        lambdaFunction("unknow param") { diffParamFunction("sdf") }
        println("-----------")
    }

    fun noParamFunction():Int{
        return 5
    }
    fun diffParamFunction(str:String):Int{
        return 7
    }

    fun oneParamFunction(data: Int):Int {
        println("this is oneParamFunction data: $data")
        return data
    }

    fun twoParamFunction(data: Int, mulData: Double):Int {
        println("this is twoParamFunction data: $data mulData:$mulData")
        return data
    }


}