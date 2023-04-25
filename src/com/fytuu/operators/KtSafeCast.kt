package com.fytuu.operators

import kotlin.math.roundToInt

//数字类型的安全类型转换
fun main() {

    //--------- String 转数字 -----------

    //可以不写:Int，自动类型判断了
    val number = "666".toInt()//会抛出异常，如果无法转换
//    val number = "666".toIntOrNull() //返回类型为 Int? 如果无法转换，返回null
    println(number)

//    val number2 = "666.6k".toDouble()
    var number2:Double? = "666.6k".toDoubleOrNull() //返回类型为 Double?
    number2 = number2?:0.0
    println(number2)


    //--------- Double 转 Int -----------
    println(35.94324.toInt())//舍弃小数部分
    println((-35.94324).roundToInt())//四舍五入 -36

    //--------- 数字格式化 -----------
    val r = "%.3f".format(35.94324) //返回的是字符串类型
    val r2:Double? = r.toDoubleOrNull()
    println(r)
    println(r2)
}