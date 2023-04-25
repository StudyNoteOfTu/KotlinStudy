package com.fytuu.operators

//forEach
fun main() {
    val str = "abcefghijklmnopqrstuvwxyz"
    //用 c 覆盖 it 接收传入参数
    str.forEach { c->
        print("$c ")
    }
}