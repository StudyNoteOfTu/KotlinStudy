package com.fytuu.list

/**
 * Set集合
 */
fun main() {
    //--------创建
    val set: Set<String> = setOf("a", "b", "c", "a")//不会出现重复元素(重复的不会再插入）
    //原理： SetsKt.setOf(new String[]{"a", "b", "c", "a"}); 得到的是Kt的Set
    println(set)
    //上述方法实例化，默认是一个java的 LinkedHashSet，是有插入顺序的
    //后来来的重复元素不会插入，即默认在LinkedHashSet中的优先级不会变化
    println(set.elementAt(0))
    println(set.elementAt(2))
//    println(set.elementAt(4))//越界报错

    //---------推荐，防越界
    println(set.elementAtOrElse(4) { "el at index $it doesn't exist" })
    println(set.elementAtOrNull(4) ?: "el doesn't exist")

    //遍历set
    val iterator = set.iterator()
    //iterator 遍历
    while (iterator.hasNext()) {
        val next = iterator.next();
    }

    //forEach 遍历
    set.forEach {
        println("el is $it")
    }

    //forEach 带index（插入顺序）
    set.forEachIndexed { index, el ->
        println("el at $index is $el")
    }

    //一样重载了 += -= 方法
    val mutableSet = mutableSetOf("a", "b", "c")
    mutableSet += "d" //.add()
    mutableSet -= "k" //.remove()
    println(mutableSet.toString())

}