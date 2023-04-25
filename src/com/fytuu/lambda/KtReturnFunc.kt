package com.fytuu.lambda

/**
 * 将函数类型作为返回类型
 *      作用：
 *
 * 可以发现，kt把匿名函数封装到了一个类中，这导致函数可以作为参数进行传递
 * 从而引发了，将函数作为传入参数，将函数作为返回值。本质都是该函数的执行依托于invoke
 * invoke中的逻辑依托于匿名函数的具体实现逻辑，编到字节码
 * 可以理解为就是java的接口、回调的一种特别的表现形式
 *
 * 编译器对函数类型变量做了优化，不需要主动调用invoke，让我们感觉像是可以直接调用函数一样
 */
fun main() {
    val resultFunc = m()
//    println(resultFunc(23,220.0))
    println(resultFunc.invoke(23,220.0))
}

//传入参数列表为空，返回值为一个函数类型
private fun m():(Int,Double)->String{
    val name = "Fytuuu";
    //返回一个匿名函数
    return {age,weight->
        val info="（2023年）"
        "我的名字是$name,$info,我的年龄是:$age,我的体重是$weight"
    }
}