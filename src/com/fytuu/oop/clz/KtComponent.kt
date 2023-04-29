package com.fytuu.oop.clz

//普通类 + 自定义解构函数
//      注意要加上 operator 标签，表示这个是操作符重载
class KtComponent(var name: String, var age: Int) {
    //component 1/2/3... 数字顺序与成员顺序保持一致
    operator fun component1(): String {
        return name
    }

    operator fun component2() = age
}

//数据类型直接用就好
data class KtComponent2(var name: String, var age: Int)


/**
 * 解构函数
 */
fun main() {
    val (name, age) = KtComponent("name", 12)
    println("name is $name, age is $age")

    //可以拒收
    val (_, age2) = KtComponent2("name2", 14)
    println("age is $age2")

}