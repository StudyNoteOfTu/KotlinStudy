package com.fytuu.list

/**
 * List 与 Set 的相互转换
 */
fun main() {
    var list = mutableListOf("a", "b", "a", "c", "a")//list 可重复
    println(list)

    //1. list去重（转set去重）
    val set = list.toMutableSet() //toSet()为不可变set
    println(set)

    //2. 再转回list
    list = set.toMutableList()//list类型为MutableList
    println(list)

    //3. 快捷写法
    val list2 = list.toSet().toList()
    println(list2)

    //4. 直接使用去重函数 distinct
    list = mutableListOf("a", "b", "a", "c", "a")//list 可重复
    //内部实现： 转为 MutableSet， 然后转为 List
    val list3 =  list.distinct() //去重完的东西变为 List 返回出去
    println(list3)

}