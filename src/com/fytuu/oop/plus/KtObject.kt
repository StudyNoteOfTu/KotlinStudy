package com.fytuu.oop.plus

// KtObject 既是单例的实例，又是类名
//默认单例，所以不允许主动声明构造函数
object KtObject{
    init{
        println("init...")
    }

    fun show() = println("show...")
}

fun main() {
    //KtObject又是类名，又是该类的单例实现（Kt帮我们写好了单例）
    //内部原理：线程安全的懒加载 static final INSTANCE，类加载的时候才通过 static 代码块进行单例实例化
    println(KtObject)
}