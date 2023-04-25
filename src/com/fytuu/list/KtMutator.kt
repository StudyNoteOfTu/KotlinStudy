package com.fytuu.list

import java.util.function.Predicate


/**
 * 对Kt可变集合 MutableList的操作，mutator函数
 */
fun main() {
    val mutableList = mutableListOf("a", "b", "a", "c", "b")
    //运算符重载了
    mutableList += "a" //.add()
    mutableList += listOf("k","h") //.addAll()
    mutableList -= "c" //.remove()
    mutableList -= listOf("a") //.removeAll()

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

}
