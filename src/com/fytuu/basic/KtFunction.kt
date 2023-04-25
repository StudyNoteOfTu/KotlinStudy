package com.fytuu.basic

fun main() {
    //具名函数调用
    m3(var1 = 99, var0 = 10, var2 = 88)
    //相当于
//    val var1 = 99
//    val var2 = 88
//    val var0 = 10
//    m3(var0, var1, var2)
    //字节码：
    //额外多了局部变量
    //    BIPUSH 99
    //    BIPUSH 10
    //    BIPUSH 88
    //    ISTORE 0
    //    ISTORE 1
    //    ISTORE 2
    //    ILOAD 1
    //    ILOAD 2
    //    ILOAD 0
}

//默认是public，默认返回值是 Unit返回类型，同等于java的void关键字
//fun m0(){
//}
fun m0(): Unit {
    return
}

//更符合字节码规范
private fun m1(age: Int, name: String): Int {
    return 100;
}

//C++优点，默认参数，也有C++的后置要求
private fun m2(age: Int, id: Int = 4) {

}

//具名函数，传入参数的时候可以随意打乱传参顺序
private fun m3(var0: Int, var1: Int, var2: Int) {

}