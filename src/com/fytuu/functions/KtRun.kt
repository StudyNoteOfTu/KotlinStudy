package com.fytuu.functions

/**
 * run 内置函数
 */
// run + 传入匿名函数
fun main() {
    val str = "Fytuu is OK"
    //block(T)->R 返回值变化
    //持有 this 引用
    val r1 = str.run {
        this.length
    }
    println(r1)

    val r2 = str.run(::concreteFun)
    println(r2)

    //返回的是run内置函数的返回值所以可以对这个返回值继续进行run
    str.run { if (length > 5) true else false }
        .run { if (this) "true" else "false" }
        .run {
            //...
        }
}

//run + 使用具名函数
fun concreteFun(t: String): Int {
    //具名函数一定有return
    //此时，就用t来接收传入的this了（需要注意的是，非静态方法，第一个传入参数一定是this）
    //所以apply也可以用这个方式来具名接收传入的this
    return t.length
}