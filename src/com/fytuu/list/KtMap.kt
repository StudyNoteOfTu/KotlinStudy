package com.fytuu.list

/**
 * map
 */
fun main() {
    // ----------- 创建
//    val map = mapOf<Int,String>(1 to("a"), 2 to "b")
    val map = mapOf(1 to ("a"), 2 to "b") //内部自动转为Pair对象
    val map2 = mapOf(Pair(1, "a"), 2 to "b")
    //Pair(key, value) 等价于 key to(value) 等价于 key to value

    // -----------  取值
    println(map.get(1))//原始写法，不推荐
    // ↓↓↓ 改用Kt运算符重载后的优化操作 ↓↓↓
    println(map[10] ?: "entry doesn't exist")//运算符重载了，返回可空类型 T?
    //map中默认找不到返回null，没有越界一说
    println(map.getOrDefault(10, "defaultVal"))
    println(map.getOrElse(100) { "elseVal" })
    //如果value为null也认为是“不存在”的话，使用 map.getOrElseNullable
    //如果value为null，虽然存在该key，也会走内置函数返回值

    // ---------- 找不到，想要主动抛异常的话： 使用 map.getValue() 方法
    //key不存在会报错：java.util.NoSuchElementException
    //内部原理：找不到的话Kt封装的时候, getOrElseNullable 的internal内置函数（匿名函数）中，throw NoSuchElementException()
    println(map.getValue(100))
}