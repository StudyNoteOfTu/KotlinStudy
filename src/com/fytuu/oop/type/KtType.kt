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
    println("测试KtType，自动泛型判断")
    KtType(objPrinted).show()
    KtType(objPrinted2).show()

    KtType("new bee").show()
    KtType(String("new bee 2".toByteArray())).show()


    //返回值使用了泛型
    println("测试KtType2，返回值使用泛型")
    println(KtType2(true, "str obj").getObj())//str obj
    println(KtType2(false, "str obj").getObj())//null

    show(objPrinted)
//    show(null)//Exception in thread "main" kotlin.KotlinNullPointerException

    //调用模拟RxJava中的map函数
    //如果isMap= false，则返回null，如果isMap = true，则返回map函数中apply函数的结果
    println("测试KtRxMap")
    val r = KtRxMap(true,"inputStringType").map {
        println("get input: $it")
        1//返回Int类型的1
//        "hello"//返回string类型的"hello"
    }?:"map result is null"
    println(r)


    println("测试map函数")
    val r2 = 1.map {
        println("接收到 $it, 返回字符串ok")
        "ok"
    }
    println(r2)
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
fun <T,R> T.map(block:(T)->R):R{
    return block(this)
}
//等同于下面这种写法写法
//上面的this其实就是apply()中的第一个传入参数： map(this:T,block:(T)->R)
//inline fun <I,O> map(caller:I,block:(I)->O) = block(caller)

//模拟RxJava的map操作符
class KtRxMap<T>(val isMap:Boolean = true, val input:T){
    //定义变换后的类型，用了lambda，可以用inline，避免增加额外的匿名类
    inline fun <R> map(apply:(T)->R):R?{
        return apply(input).takeIf { isMap }
    }

    //另一种写法 - 直接return结果，返回值自动判定
    inline fun <R> map2(apply:(T)->R) = apply(input).takeIf { isMap }
}