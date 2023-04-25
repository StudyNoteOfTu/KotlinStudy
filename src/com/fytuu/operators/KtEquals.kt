package com.fytuu.operators

fun main() {
    // == 值 内容的比较，相当于Java的equals ， 转为Java后可以看到内部封装了 Intrinsics.areEqual()，实际是判空再调用Object的equals比较
    // === 引用的比较，相当于Java的==

    val u = "t"
    val name1 = "Fytuu"
    val name2 = "Fytu"+u
    println(name1.equals(name2))//java
    println(name1 == name2)
    println(name1 === name2) //false
    //name2变为了StringBuilder拼接之后toString的String结果，name1是String，两者不是同一个对象，地址不同
    println(name1.javaClass)
    println(name2.javaClass)

    //capitalize() 首字母改成大写
    val name3 = "fytuu".capitalize() //"修改为 Fytuu"
    println(name1 == name3)//true
    println(name1 === name3)//false，内部没有java的intern()，没有放到字符串常量池，仍然是新的一个String


}