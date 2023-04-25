package com.fytuu.list

/**
 * 可变 Map
 *
 * 增减
 * 查找
 * get
 * getOrDefault
 * getOrPut
 * getOrElse
 */
fun main() {
    //可变map （允许有 put remove）
    val map = mutableMapOf(1 to "a", 2 to "b", 3 to "c")
    println(map)
    map += 4 to "d" //put(Pair)
    map.put(5,"e")  //等价于+=
    map += 1 to "aa"//put(Pair)
    map -= 2        //remove(key)
    println(map)
    //操作符重载
    map[1] = "aaa"
    println(map)

    //其他的和java中的类似：
    map.putIfAbsent(1,"put if absent")
    println(map)

    //getOrPut 如果没有就拿默认的，并且put(key,defaultValue())
    val getOrPutRes = map.getOrPut(6){
        "f"
    }
    println("getOrPut result is $getOrPutRes")
    println(map)

    //getOrDefault 如果没有就拿默认的，就此打住，不会帮你 put
    println(map.getOrDefault(7, "nothing"))
    println(map)
}