package com.fytuu.oop.clz

/**
 * 操作符重载
 */

//主构造函数的变量如果不接收就无法使用，例如number2，仅仅在主构造函数传入了，但没有赋值给任何变量
//class KtOpNum(var number:Int,number2:Int)


data class KtOpNum(var num:Int){
    //C++运算符重载的话，直接 “+" 就好了
    //      Kt的运算符重载的实现，通过 plus 来表示 + ，和C++不一样

    //如果设置成了private，则外界无法使用 + 进行操作
    operator fun plus(p2:KtOpNum):Int{
        return this.num + p2.num + 1
    }
}

fun main() {

    val resPlusOne = KtOpNum(2) + KtOpNum(2)
    println(resPlusOne)

}