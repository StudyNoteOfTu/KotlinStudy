package com.fytuu.lambda

/**
 * Lambda
 */
fun main() {
    //匿名函数就是lambda表达式
    //${}可以理解为给的是一个表达式？表达式有返回值！填入的表达式只允许一条！
    val m = { num1: Int, num2: Int ->
        "两数相加的结果为： ${
        num1 + num2
        }"
    }
    println(m(1, 2))

    val m2 = { number: Int ->
        //不定返回类型
        when (number) {
            1 -> "星期一"
            2 -> "星期二"
            else -> -1
        }
    } // m2 : (Int) -> Any
}