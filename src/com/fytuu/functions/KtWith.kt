package com.fytuu.functions

/**
 * with函数
 */
fun main() {

    val str = "Fytuu"
    //传入具名函数
    with(str, ::println)

    //传入匿名函数 + 与其他的配合
    with(str) {
        true
    }.let { println("what?") }.run { }

    //with的连续调用
    with(with(str, ::getStrLen), ::println)
}

fun getStrLen(str: String) = str.length