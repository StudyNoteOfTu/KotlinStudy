package com.fytuu.nullexception

import java.lang.Exception

fun main() {
    var info:String? = "abc"
    info = null
    //空合并操作符： x1 ?: x2 相当于 x1!=null? x1:x2
    //简化了代码
    println(info ?: "info is null")

    //let+ 空合并操作符
    //如果info为null，let返回值为null，接下去一定返回 ?: 之后的内容
    println(info?.let { "$it" }?:"")


    //先决条件函数
    /**
     * require(value:Boolean)
     * requireNotNull(value:T) //根据传入参数类型来决定泛型，和Java类同，这是泛型方法
     * checkNotNull(value:T) //同上
     */
    expOnNull()
    expOnFalse()
}

//遇到参数为false抛异常
fun expOnFalse(){
    try {
        //如果给了默认初值为null，则编译为Java的Boolean类型
        //如果给了是false，则编译为boolean基本类型
        var isOk:Boolean? = true
        //如果还有其他地方用到isOk，无法确定类型，统一编译为Boolean类型
        isOk = getNull()
        //require不允许传入空值
        //如果isOk为null，传false进去
        require(isOk?:false)//传入false抛异常：java.lang.IllegalArgumentException: Failed requirement.
    }catch (e:Exception){
        println(e)
    }
}

fun getNull():Boolean?{
    return false
}

//遇到参数为null抛异常
fun expOnNull(){
    try {
        var info:String? = null

//        checkException(info)
        //也可以用系统自带的
        checkNotNull(info)
        requireNotNull(info)

        println(info!!.length) // 这里会报 KotlinNullPointerException
    }catch (e:Exception){
        println("exception: $e")
    }
}

fun checkException(info: String?) {
    info ?: throw CustomException()
}

//自定义异常
class CustomException : IllegalArgumentException("代码不严谨，参数有问题，为null")
