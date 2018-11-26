package com.css.kotlintest.kotlinbase

import com.css.kotlintest.javacode.MInterface
import com.css.kotlintest.javacode.StaticClass

abstract class KotlinCallJava {
    protected lateinit var staticClass: StaticClass
    private fun init() {
        staticClass = StaticClass.with(this)
        staticClass.doSomething()
    }
    private fun callInnerClass() {
        var jjj = MInterfaceImplement().call()
        var kkk = object : MInterface{
            override fun call() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }

    class MInterfaceImplement : MInterface{
        override fun call() {
            println("call")
        }
    }


}
