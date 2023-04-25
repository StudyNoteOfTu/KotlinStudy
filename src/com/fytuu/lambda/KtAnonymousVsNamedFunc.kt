package com.fytuu.lambda

/**
 * 匿名函数和具名函数的区别
 *
 * 匿名函数：
 *      当只有一个传入参数的时候，可以通过 it 来访问这个传入参数
 * 具名函数：
 *      只能通过传入参数名来访问传入参数，不允许使用 it
 */

fun main() {
    //匿名函数，showResult函数可以通过 it 来访问传入参数
    showAge(23){//匿名函数
        println("show result：$it")
    }

    //具名函数
    showAge(23,::showResultImpl)

    //对标Java进行理解的话：
    //  匿名函数类似于 匿名内部类
    //  具名函数类似于 非静态内部类
}


//这是个具名函数（有函数名就是具名）
fun showResultImpl(result:String){
//    println("show result: $it") // 编译失败，it只能用在匿名函数中
    println("show result: $result")
}

fun showAge(age:Int, showResult:(String)->Unit) {
    val str = "age is $age"
    showResult(str)
}
