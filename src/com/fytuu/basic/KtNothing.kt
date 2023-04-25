package com.fytuu.basic

fun main() {

}

private fun show(number: Int){
    when(number){
        //TODO函数返回一个Nothing对象，内部实现为抛出一个NotImplementedError异常
        -1 -> TODO("分数不合法")
        in 0..59 -> println("不及格")
        in 60..70 -> println("及格")
        in 71..100 -> println("优秀")
    }
}

interface A{
    fun show()
}

class AImpl : A {
    override fun show() {
        //这个TODO函数返回一个Nothing对象，内部实现为抛出一个NotImplementedError异常
        //是会终止程序的
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}