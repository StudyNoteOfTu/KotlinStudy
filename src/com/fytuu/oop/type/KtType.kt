package com.fytuu.oop.type

/**
 * Kotlin 泛型
 */

//泛型类
class KtType<T>(private val obj: T) {
    fun show() = println("print: $obj")
}

//泛型函数
class KtType2<T>(private val isR: Boolean, private val obj: T) {
    //takeIf中结果为true的话返回调用者本身，结果为false的话返回null

    //返回值使用了泛型
    fun getObj(): T? = obj.takeIf { isR }
}

//data数据类帮我们自动写好一个toString
data class ObjPrinted(val info: String)

data class ObjPrinted2(val info: String)

fun main() {

    val objPrinted = ObjPrinted("default info 1  ")
    val objPrinted2 = ObjPrinted2("default info 2 ")

    //自动泛型判断
    KtType(objPrinted).show()
    KtType(objPrinted2).show()

    KtType("new bee").show()
    KtType(String("new bee 2".toByteArray())).show()


    //返回值使用了泛型
    println(KtType2(true, "str obj").getObj())//str obj
    println(KtType2(false, "str obj").getObj())//null

    show(objPrinted)
    show(null)//Exception in thread "main" kotlin.KotlinNullPointerException
}

fun <R> show(item:R){
    item?.also {//不论it还是this实际上都可以修改原来的变量，只是it被约定为不用来修改原值
        //此外also可以返回调用者本身
        //it是item
        println("item is not null, it is $it")
    }!!
    //回顾， !!表示如果为空则抛出空指针异常


    //泛型不可以用来做类型判断，会被擦除
//    println(r is R)
}

//匿名函数搞一个常见的映射函数
//block为一个函数参数声明
fun <T,R> T.apply(block:(T)->R):R{
    return block(this)
}