package com.fytuu.basic

fun main() {
    val garden = "花园"
    val time = 6
    //kt的字符串模板拼接写法
    println("今天天气很晴朗${garden}玩儿了$time 小时")
//    println("今天天气很晴朗"+garden+"玩儿了"+time+" 小时")

    val isLogined = false
    //kt的if是表达式，有返回值，更灵活
    //java的if是语句，有局限性
    println("server response result : ${if (isLogined) "恭喜你登陆成功" else "登陆失败"}")
    //实现思路很简单，把if部分单独执行，然后将返回值给到一个局部变量/或者栈里，然后拿去用
    //例如这里将if表达式的结果放到比如 var0 中，
    // 然后变为： "server response result:"+var0 的StringBuilder的拼接操作

    //常用方法
    // 1. 获取字符串长度
    val length = garden.count()
}
