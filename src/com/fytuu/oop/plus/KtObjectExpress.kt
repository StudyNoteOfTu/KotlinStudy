package com.fytuu.oop.plus

/**
 * 对象表达式
 */
open class KtObjectExpress {

    open fun add(info: String) = println("add:$info")

    open fun del(info: String) = println("del:$info")

}


interface InterfaceKt{
    public abstract fun run()
}

fun main() {

    //匿名方式写子类：
    val son = object: KtObjectExpress(){
        override fun add(info: String) {
            println("add anonymous son :$info")
        }

        override fun del(info: String) {
            println("del anonymous son: $info")
        }

        fun newFun(){
            println("its a new function in anonymous son class")
        }
    }

//    son.newFun()
    son.del("delInfo")


    //具名方式写子类 - 直接调用主构造函数
    val concreteSon1 = KtObjectExpressSon()
    concreteSon1.del("delInfo")

    //匿名方式对Java原生接口进行实现
    val anonymousSon2 = object: Runnable{
        override fun run() {
            //do some thing
        }
    }
    //简洁：由于这是只有一个函数的接口，所以可以把它变成一个lambda表达式的简洁写法
    val anonymousSon3 = Runnable {
        //do some thing
    }

    //但是Kotlin的接口，则不能用lambda表达式！！！
    val ktIntImpl = object : InterfaceKt {
        override fun run() {
            println("")
        }
    }

    //两个函数的接口就不能这样了
    val anonymousSon4 = object:TwoFunInterface{
        override fun fun1() {
            //...
        }

        override fun fun2() {
            //...
        }
    }

    //具名方式实现Java原生接口
    val concreteSon3 = TaskRunnable("info")
}

//具名方式写子类
//class KtObjectExpressSon : KtObjectExpress(){ //不写()默认主构造函数为空参
class KtObjectExpressSon() : KtObjectExpress(){
    override fun add(info: String) {
        println("add concrete son :$info")
    }

    override fun del(info: String) {
        println("del concrete son :$info")
    }
}

//具名方式实现Java原生接口
class TaskRunnable(val info:String) : Runnable{
    override fun run() {
        println("running... show info : $info")
    }
}
