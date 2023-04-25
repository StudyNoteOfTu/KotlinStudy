package com.fytuu.list

/**
 * List集合
 */
fun main() {
    //-------创建
//    val list : List<String>  = listOf<String>("a","b","c")
    val list = listOf("a", "b", "c")

    //-------索引取值，从 0 到 size-1
    //java是 get()，kt对get做了运算符重载，借鉴了C++的运算符重载，字节码仍然翻译为 get()
    println(list[0])
    println(list.get(0))

    //-------推荐： Kt对索引取值的优化： 空、越界的默认判断
    //默认一个String值
    println(list.getOrElse(9) { index -> "out index is $index" }) //返回 T 类型
    println(list.getOrElse(10) { "out index is $it" }) //返回 T 类型
    //默认一个null值
    println(list.getOrNull(9)?:"[配合了空合并操作符?:] get result is null")//返回 T? 可空类型


    //Kt的List来自Collection，但是没有add，remove函数
    //Kt的MutableList也来自Collection，但接口定义了 add 和 remove 函数 （直接默认实现了java的ArrayList）
    //------- 可变 List （默认实现 ArrayList）
    val mutableList = mutableListOf("a","b","a","c","b")
    mutableList.add("d")
//    mutableList.remove("a")//只remove第一个符合的
    mutableList.removeAll(listOf("a","b"))//移除所有"a"和"b"
    println(mutableList.toString())

    //LinkedList，在Kt中无实现，可以直接用java中的LinkedList

}