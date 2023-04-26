package com.fytuu.oop

/**
 * 延时初始化 lateInit
 */
class KtLateInit {
    //一定是var，表示这个变量后续可以改，不能是val
    //  lateinit 只能用在引用类型上，不能用在基本数据类型上，例如 Int 等
    //  lateinit 变量不允许有getter、setter（因为不可以直接访问，必须通过某个函数来访问）
    private lateinit var lateInfo: String //lateinit只能用在引用类型，且引用类型默认初值为null


    //后来调用，用的时候才加载
    fun lazyLoadInfo() {//延时初始化，用于懒加载，用到才加载
        lateInfo = "后来填入的信息"
    }

    fun showInfo() {
        //当然，可以进行一个判断来避免直接使用
        //isInitialized原理：编译器见到isInitialized，则额外插桩插入字节码getter、setter方法
        if (::lateInfo.isInitialized) {
            println("需要先调用 lazyLoadInfo() 先对变量进行初始化")
        } else {
            println(lateInfo)
        }
    }
}

fun main() {
    val ktLateInit = KtLateInit()
    //报错：延时加载的变量还没加载你就使用
//    ktLateInit.lazyLoadInfo()
    ktLateInit.showInfo()

    //抛异常原理：
    //1.
    //  所有 lateinit 修饰的变量，在访问的时候编译为：
    //  var v = this.info
    //  if(v == null){Intrinsics.throwUninitializedPropertyAccessException("lateInfo");}
    //2.
    //  lateinit只能用在引用类型，且引用类型默认初值为null
}