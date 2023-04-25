package com.fytuu.lambda

fun main() {

    val len = "Fytuu".count()
    println(len)

    //传入一个匿名函数
//    val len2 = "Fytuu".count(){
//        it == 'u'
//    }
//    val len2 = "Fytuu".count({
//        it == 'u'
//    })
    //CharSequence.count(predicate:(char) -> Boolean)方法内部对所有字符进行迭代
    //注意的是，这里用到了C++的内联函数概念，不会增加调用栈
    //C++： inline修饰的函数叫做内联函数 直接将函数内容编译到调用的地方！
    //优点： 让代码执行得更快，减少函数调用栈的操作
    //缺点：增加耦合
    //注意：C++中的内联只是对编译器的请求，而不是命令，编译器可以忽略内敛请求：
    //  例如：函数包含：静态变量，递归，返回类型不是void，包含goto 等情况的时候，不会执行内联
    val len2 = "Fytuu".count {
        it == 'u'
    }
    println(len2)
}

//拒绝inline编译，函数内包含递归
//private inline fun test(){
//    test()
//}