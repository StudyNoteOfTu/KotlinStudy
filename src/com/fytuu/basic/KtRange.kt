package com.fytuu.basic

import kotlin.math.roundToInt

/**
 * 类型推断
 *
 * Range 表达式
 */
fun main() {

//    var info:String = "Fytuu is Success"
    //自动推断出info变量为String类型
//    val info = "Fytuu is Success"
//    println(info)
//
//    //kt没有提供Integer这种工具类对象
//    val num = 99
//    println(num)

    //----------- range 表达式 -----------------
    val index = (Math.random()*100).roundToInt()
//    val index = (Math.random()*100)
    val min = 0
    val max  = 59
    //range 从哪里到哪里
    // 1. 如果index是double类型，则内部使用的是一个RangesKt.intRangeContains()
    // 2. 如果index的类型和比较的门限类型一致，直接使用 <= >来判断
    // 3. 区间： 左闭右闭
    if (index in min..max){
        println("不及格")
    }else{
        println("及格")
    }
    //index !in min..max 不在区间内

}