package com.fytuu.nullexception

/**
 * 断言 !!
 *
 * 原理：在执行前先判空，如果没有异常，则继续执行后续代码（编译期插桩 !! 变为 if(){} ...)
 *
 * if(name == null){
 *      throw new KotlinNullPointerException();
 * }
 * ...
 *
 * 用的是KotlinNullPointerException，这个继承自NullPointerException
 */
fun main() {

}

fun assert(name:String?){
    val r = name!!.capitalize() //!! 表示不管name是不是null，都执行后续函数
    //这里的capitalize()报了空指针异常
    println(r)
}

fun assert2(name:String?){
    if (name==null){
        throw KotlinNullPointerException();
    }
    var r = name.capitalize()
    println(r)
}