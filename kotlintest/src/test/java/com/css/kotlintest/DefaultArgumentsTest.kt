package com.css.kotlintest

import org.junit.Test

class DefaultArgumentsTest {
    open class ParentClass {
        open fun simplePrintArgument(value: Int = 5) {
            println(value)
        }
    }

    class SubClss : ParentClass() {
        override fun simplePrintArgument(value: Int) {
            super.simplePrintArgument(value)
        }
//        override fun simplePrintArgument(value: Int = 8) {// error 重写方法不允许重新设置默认值
//            super.simplePrintArgument(value)
//        }
    }

    fun firstDefaultSecondNot(defaultValue: Int = 4, notDef: Int) {
        println("default:$defaultValue noDef:$notDef")
    }
    fun allDefault(first:Int = 4,sencond:Int=5){
        println("first:$first sencond:$sencond")
    }

    fun defaultAndFunctionArgument(defaultValue: Int = 7, notDef: Int, pux: () -> Unit) {
        println("default:$defaultValue noDef:$notDef")
    }

    fun allDefaultAndFunctionArgument(defaultValue: Int = 7, notDef: Int = 99, pux: () -> Unit) {
        println("default:$defaultValue noDef:$notDef")
        pux()
    }

    @Test
    fun run() {
        DefaultArgumentsTest.SubClss().simplePrintArgument()
        println("----")
//        firstDefaultSecondNot(88)//error
        firstDefaultSecondNot(notDef = 88)
        allDefault()
        allDefault(33)
        println("----")

//        defaultAndFunctionArgument(77){ println("haha")} // error
        defaultAndFunctionArgument(notDef = 77) { println("haha") }
        println("----")
        allDefaultAndFunctionArgument(33) { println("all default") }
        allDefaultAndFunctionArgument { println("all default") }
    }
}