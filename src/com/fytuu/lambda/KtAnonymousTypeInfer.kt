package com.fytuu.lambda

/**
 * 匿名函数的类型推断，简化写法
 */

fun main() {
    //原先写法 , 冒号方式则为“声明”，必须指定入参类型和返回类型
    val m : (Int,String)->String = {v0,v1->
        ""
    }

    //现在写法
    val m1 = {v0:Int, v1:String ->
        //以String结尾，则默认推断返回值为字符串
        v1
        //以Int结尾，则默认推断返回值为Int类型
        v0
        //以Unit结尾，默认返回值为Void类型
        Unit//返回一个空，约定最后一句就是return，而且不允许自行写return
    }

    //没有入参
    val m2 = {
        123.4f
    }

    println(m1(1,"hello"))//kotlin.Unit
    println(m2())

    //原理：匿名函数编译时自动生成了一个匿名类，其中invoke方法内填入的是函数的具体实现
    //最后不是通过反射！是直接进行方法调用！
}