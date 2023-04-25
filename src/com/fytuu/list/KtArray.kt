package com.fytuu.list

import java.io.File

/**
 * Kt中的数组
 * IntArray intArrayOf
 * ByteArray byteArrayOf
 * ...
 * Array arrayOf 对象数组
 *
 * 越界保护
 * 操作符重载
 * List 与 Array 的转换
 * 对象数组
 */
fun main() {
    //1. intArrayOf 常规操作的越界崩溃
    val intArray: IntArray = intArrayOf(1, 2, 3, 4, 5)//Java中的int[]数组
    println(intArray[0])
    println(intArray.get(0))//get被重载为[0]

    //这样的设计让数组和List集合的操作进行了统一，同时提供了越界保护！！！
    println(intArray.getOrNull(100) ?: "out of boundary")//内部原理：帮我们做了下标越界判断
    println(intArray.getOrElse(100) {
        -1
    })//内部原理：帮我们做了下标越界判断，越界返回内置函数（直接返回内置函数return的结果)


    //---------集合转数组
    val list = listOf("a","b","c")
    //String被认为是引用类型，所以返回的是一个泛型数组
    val strArray = list.toTypedArray()
    println(strArray.javaClass) //class [Ljava.lang.String;


    //对象数组
    val array = arrayOf(File("a"),"a",1)
    val array2 = arrayOf(File("a"))
    println(array.javaClass) //class [Ljava.lang.Object;
    println(array2.javaClass) //class [Ljava.io.File;
}