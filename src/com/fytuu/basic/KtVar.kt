package com.fytuu.basic

/**
 * 声明变量
 */

const val PI = 3.14;

fun main(args: Array<String>){
    //声明变量
    var name : String = "name";
    println(name);
    /**
     * 以下全是Kotlin的
     * String
     * Char
     * Boolean
     * Int
     * Float
     * Double
     * List
     * Set
     * Map
     *
     * 没有基本数据类型了，会通过编译器转为 java 的 int等（编译成字节码的时候）
     */

    //自动补全类型（Object？）
    //声明只读变量
    //val 为只读的变量（value）， var 为可读可写的变量（variable）
    val info = "name"
    println(info)

    //声明常量
    // 1. 只能是基本数据类型+String可以声明为编译时常量
    // 2. 不能用在局部变量
    // 3. 只能和 val 合用
    //const val PI = 3.14 写到函数之外，才能在编译期编译为常量
}