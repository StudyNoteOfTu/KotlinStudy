package com.fytuu.functions

import java.io.File

/**
 * apply内置函数
 */
fun main() {
    val info = "Fytuu hello!"
    //普通方式
    println("一般方式-----------")
    println("info length is ${info.length}")
    println("info last char is ${info[info.length - 1]}")
    println("change info to lowercase is ${info.toLowerCase()}")

    println("apply内置函数方式-----------")
    //apply内置函数的方式
    //apply始终返回的是info本身
    //  特别的是单个参数的匿名函数持有it，但apply并没有，持有的是this,this是info本身
    //  更特别的是，this可以省略
    val infoNew: String = info.apply {
        println("info length is $length")
        println("info last char is ${this[length - 1]}")
        println("change info to lowercase is ${toLowerCase()}")
    }
    println(infoNew)

    println("链式调用-----------")
    //由于返回的是 调用者本身 ，所以可以一直链式调用
    info.apply {
        println("info length is $length")
    }.apply {
        println("info last char is ${this[length - 1]}")
    }.apply {
        println("change info to lowercase is ${toLowerCase()}")
    }

    println("使用示例-----------")
    /* 原来：
    val file = File("test.txt");
    file.setExecutable(true)
    file.setReadable(true)
     */
    //现在
//    val file = File("D:\\A其他\\其他\\Test.txt")
    val file = File("test.txt")
    //apply将上下文切换到该对象内部
    file.apply {
//        println(this.setExecutable(true))
        println(setExecutable(true))
    }.apply {
//        println(this.setReadable(true))
        println(setReadable(true))
    }.apply {
        //报错 FileNotFoundException
//        println(this.readLines())
        println(readLines())
        //不要错写成 readLine() 这是个读取系统输入的类似 Scanner 的东西，阻塞读取
    }
}