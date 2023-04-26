package com.fytuu.oop

/**
 * 初始代码块
 */

class KtInitBlock(_name: String, _age: Int) //主构造函数
{

    val mName = _name
    var mAge = _age

    //初始化代码块，字节码中可以看到，这是插桩，在构造函数中执行
    //  类似于Java的{}构造代码块,而不是 static{} 静态代码快
    //  在 执行任何构造函数 的时候（主构造的中间，次构造之前），都会执行该代码块
    //
    //  在构造函数和 init 代码块中，可以使用临时参数， 且只能访问到主构造函数的传入参数
    init {
        println("init block enter")

        //...
        //1. 使用临时参数
        println("name is $_name")
        val tempVal = _name //这里的 tempVal 只在代码块中可见，是个局部变量

        //2. 可以用来做校验工作，require函数： 如果value为false，则打印lazyMessage的内容
        //      lazyMessage的返回类型为Any，最后走toString打印
        //      这里是抛出异常的方式，如果不希望程序终止运行，可以进行tryCatch异常的捕获
        try {
            require(tempVal.isNotBlank()) {//由于_name是非null类型，所以只要判断是否为空即可
                //如果校验不希望为空,则在此处返回错误结果，抛出异常
                "name is empty"
            }
        } catch (e: Exception) {
            //打印错误，接收错误，程序继续执行
            println(e)
        }

        println("init block exit")
    }

    constructor() : this("default name", 23) {
        println("次构造函数")
    }


    val info: String = "default info "

}

fun main() {
    KtInitBlock()//调用次构造函数
    /* 打印结果：
        init block enter
        name is default name
        init block exit
        次构造函数
     */

    KtInitBlock("", 23)//校验失败的情况
}