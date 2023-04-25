package com.fytuu.list

import java.io.File

/**
 * map 的遍历
 */
fun main() {
    val map0 /*: Map<Int, Any>*/ = mapOf(Pair(1, "a"), Pair(2, File("aaa")))
    //map 默认是插入优先的LinkedHashMap
    val map = mapOf(1 to "a", 2 to "b", 3 to "c")

    //forEach : Entry
    map.forEach {
        //it: Map.Entry<Int,String>
        println("${it.key} : ${it.value}")
    }


//    //forEach : Key, Value
//    map.forEach{key, value ->//这种写法不太好，使用 (key,value)->{}
//        println("$key : $value")
//    }
    //↑↑↑这种写法不太好↑↑↑，↓↓↓使用 (key,value)->{}↓↓↓
    //forEach : (Key, Value)
    map.forEach { (key, value) ->
        println("$key : $value")
    }

    //entrySet的forEach index为插入优先的LinkedHashMap的插入顺序
    map.entries.forEachIndexed { index, it ->
        println("index is $index , entry is ${it.key} : ${it.value}")
    }

    //增强forEach
    for (entry in map) { //内部和Java一样，都是iterator遍历
        println("entry is ${entry.key} : ${entry.value}")
    }

}