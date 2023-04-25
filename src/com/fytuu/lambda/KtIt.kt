package com.fytuu.lambda

/**
 * it 关键字特点
 *
 * 核心：只有一个传入参数，自带一个it关键字，不用单独写接收
 */
fun main() {
    //一般写法
    val m: (Int) -> String = { v0 ->
        println("v0 is $v0")
        "v0 is $v0"
    }
    //等价写法:
    m(1)
    m.invoke(1)

    //it关键字，如果只有一个传入参数，自带一个it关键字，不用单独写接收
    val m1:(Int)->String = {
        println("v0 is $it")
        "v0 is $it"
    }
    m1(1)
    m1.invoke(1)
}