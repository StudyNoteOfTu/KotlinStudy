package com.fytuu.basic

fun main() {
    val week = 5

    //switch在kotlin中的写法为when，这个是表达式，是有返回值的
    //这里的res认为是Any类型，相当于Object类型
    // 可能会有多种情况，比如String类型，比如else的{}类型
    val res = when (week) {
        1 -> "week = 1, 星期一"
//        else -> "" //必须有一个不满足的情况
        else -> {//等同有 default
            println("不满足条件")
//            2 //返回一个 2
            //什么都不写返回一个空，最后是 kotlin.Unit对象
        } //或者不明确返回，直接执行方法块
        //准确来说最后返回的是一个kotlin/Unit.INSTANCE（字节码中看到的）
        //kotlin/Unit.INSTANCE这是一个 Kotlin.Unit 类型的对象，类同于 void 空类型
    }
    //Unit只有一个toString方法，值为"kotlin.Unit"，再没有其他东西了，表征着 void 空类型
    println(res)
}