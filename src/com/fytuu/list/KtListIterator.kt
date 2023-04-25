package com.fytuu.list

import java.lang.Exception

/**
 * list 遍历
 */
fun main() {

    val mutableList = mutableListOf("a", "b", "a", "c", "b", "d", "e")

    //removeIf，给遍历过程中加一个 filter，
    //      如果这个filter的函数返回true，则从集合中删去该元素
//    mutableList.removeIf(Predicate {
//        it == "a"
//    })
    //传入了一个匿名函数（从Java的视角来看，其实传入的是一个java中Predicate接口的实现类）
    //从Kt的视角来看，传入的是一个匿名函数，因为这个Predicate接口只有一个函数需要实现，所以可以这么做
    mutableList.removeIf {
        it == "a"
    }
    //特别的，如果对 Predicate 这个接口还有额外的函数需要重写的话，就不能按Kt视角来做了
    //Kt的函数类型对象，只针对 只有一个函数需要实现的Java接口


    //遍历
    for (s in mutableList) {
        //...
    }

    //iterator
    val iterator = mutableList.iterator()
    while (iterator.hasNext()) {
        //这里面可以搞删除
        val next = iterator.next()
    }

    //forEach
    mutableList.forEach {
        println("el is $it") //内部也是 iterator
    }

    //带下标
    mutableList.forEachIndexed { index, el ->
        //这里面不允许搞删除
        println("el in $index is $el")
    }

    //获取元素，过滤获取元素 , _不是变量名，是过滤解构赋值的，不接受赋值，_无法当变量使用
    val (_, n1, _, n2) = listOf(1, 2, 3, 4)
    println(" skip el at index0, and n1: $n1, skip el at index2, and n2: $n2")

}