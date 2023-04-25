package com.fytuu.functions

/**
 * let内置函数
 */
fun main() {
    val list: List<Int> = listOf(6, 4, 1, 5, 7, 8, 1)
//    val list:List<Any> = listOf(6,4,1,5,7,8,1,"a")
    println(list)

    //第一个元素
    val first = list.first()
    println(first)
    //最后一个元素
    val last = list.last()
    println(last)
    //两数相加
    val res = first + last
    println(res)

    //改用 let 内置函数来做 , it 是调用者本身
    // let 内置函数匿名函数的最后一行为返回值
    val res1 = list.let {
        it.first() + it.last()
    }
    println(res1)

    //与apply的区别
    //      let 最后一行作为返回值
    //      apply 总返回this，调用者本身
    //原理
    //      let有 block() 返回值类型转换： return block(this)
    //          block：(T)->R，这个T就是it，这个block就是上述匿名函数（
    //          let函数只有block这一个传入参数，且类型为函数类型）
    //          这个类型转换的设计很常见，比如RxJava中就有
    //      apply 则直接 return this
    //          传入的 block: T.apply()->Unit 被作为模板函数在 apply 函数中return前调用

    /**
     * 其他
     * apply传入的匿名函数是 ()->Unit,所以其内部根本就没有it可访问，没有传入参数
     * let传入的匿名函数是 (T)->R ，所以其内部可以用it来访问传参，同时let内部实现调用block为：
     *      block(this)
     *      ？所以it访问传入参数，实际上it访问的就是this，但其不可重定向
     */

    println(m(null))
}

// ----------- if(value == null) 判空返回 -----------

//普通方式
//fun m(value: String?): String {
//    return if (value == null) "value is null" else "value is $value"
//}
//普通方式简化写法
fun m(value: String?) = if (value == null) "value is null" else "value is $value"


//let方式
//fun m1(value: String?): String {
//    return value?.let {
//        "value is $it"
//    } ?: "value is null"
//}

//let方式简化写法
//写到这里默认返回值为String，注意，String也可以为null，它也算是引用类型
//fun m1(value:String?) = value?.let{
//    "value is $it"
//}

fun m1(value:String?) = value?.let{
    "value is $it"
}?:"value is null"