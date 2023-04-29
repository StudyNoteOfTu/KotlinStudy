package com.fytuu.oop.plus

// KtObject 既是单例的实例，又是类名
//默认单例，所以不允许主动声明构造函数
object KtObject{
    //public static final KtObject INSTANCE;
    //private KtObject(){}
    //static{ 实例化INSTANCE、 调用init{} }
    init{
        //写到了static{}里面，而不再是写到构造函数中
        println("init...")
    }

    fun show() = println("show...")
}

fun main() {
    //KtObject又是类名，又是该类的单例实现（Kt帮我们写好了单例）
    //内部原理：线程安全的懒加载 static final INSTANCE，类加载的时候才通过 static 代码块进行单例实例化
    println("before")
    //使用到的时候，进行单例类加载
    println(KtObject)

    /*
        before
        init...
        com.fytuu.oop.plus.KtObject@330bedb4
     */

}