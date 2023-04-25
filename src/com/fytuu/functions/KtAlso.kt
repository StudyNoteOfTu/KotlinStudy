package com.fytuu.functions

import java.util.*

/**
 * also 内置函数
 */
fun main() {
    val list = arrayOf(1,2,3)
    val r = list.also {
        it[0] = 4
    }
    println(r.contentToString())
    println(list.contentToString())
}