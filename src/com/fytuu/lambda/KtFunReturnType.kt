package com.fytuu.lambda

import java.io.Serializable
import kotlin.jvm.internal.FunctionBase
import kotlin.jvm.internal.Reflection

/**
 * kt语言的函数类型 和 隐式返回
 */
fun main() {
    //写一个函数

    //第一步： 函数输入输出的声明
    val m: () -> String
    //第二部： 函数体实现（对上述函数声明的实现）
    m = {
        //        return "Fytuuu"
        // 匿名函数不能写return，最后一行约定默认就是return了
        "Fytuuu"
    }


    val voidM: () -> Unit
    voidM = {
        //这里的2不会被编译，因为这个2没有实际意义
        2
    }

    //这里的{}被编译为一个 extends kotlin/jvm/internal/Lambda implements kotlin/jvm/functions/Function0 的实现
    //这里的Function0意味着这个函数为 invoke() ， 没有传入参数
    //类似的 Function4 意味着这个函数 invoke(p1,p2,p3,p4) 有四个传入参数
    //具体类型为泛型，由定义的地方约定

    println(m)
    //打印结果 () -> kotlin.String
//    abstract class Lambda<out R>(override val arity: Int) : FunctionBase<R>, Serializable {
//        override fun toString(): String = Reflection.renderLambdaToString(this)
//    }

    println(m())


    //一气呵成地写函数
    //v0,v1,v2 接收传入参数
    val m1: (Int, Int, Int) -> String = { v0, v1, v2 ->
        //执行过程
        val temp = v1 + v2
        //返回结果
        "v0 is $v0"
    }

    //调用函数
    println(m1(1, 2, 3))
}

/*
fun m():String{
    return "Fytuu"
}
 */

/*
fun m1(v0:Int, v1:Int, v2:Int):String{
}
 */