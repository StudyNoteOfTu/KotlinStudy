package com.fytuu.keywords

/**
 * vararg关键字 = 动态参数
 *
 * [] - 操作符重载
 */
//注意，T可以是 Any? 类型
class KtVararg<T>(vararg array: T)
//相当于：
//class KtVararg3<T>(list:Array<T>)//记住，Kt里面的数组是Array，集合是List，没有[]
{
    //接收
    //out 表示这个 T 泛型类型只能被读取，不能被修改
    var objArray: Array<out T> = array;

    fun showObj(index: Int): T? {
//        println(objArray[index]) //这种方法容易越界，不推荐
        return objArray.getOrNull(index)
    }

    //类型变换
    fun <R> map(index: Int, block: (T?) -> R): R {
        return block(objArray.getOrNull(index))
    }
}

fun main() {
    println(KtVararg(1, 2, 3).showObj(5))
    println(KtVararg(1, 2, 3).showObj(1))
    println(KtVararg(1, 2, 3).map(1) {
//        it ?: "it's null"
        //转为string类型表征其类型
        it?.let {
            it.javaClass.toString()
        } ?: Unit.javaClass.toString()
    })
    println(KtVararg(1, 2, 3).map(5) {
//        it ?: "it's null"
        //转为string类型表征其类型
        ((it?.javaClass)?.toString()) ?: Unit.javaClass.toString()
    })

    //什么类型都传,显然泛型被推断为Any类型
    val res: KtVararg<Any?> = KtVararg("hello", null, 3, 23423.1f)
    println(KtVararg("hello", null, 3, 23423.1f).showObj(5))


    //-------------  [] - 操作符重载 ——------------------
    println(KtVarargArrayOperator("张三", "李四")[1])

}

//-------------  [] - 操作符重载 ——------------------
class KtVarargArrayOperator<T>(vararg objects:T){
    //开启T泛型的只读模式
    var objectArray: Array<out T> =objects

    fun converter():Array<out T>{
        return objectArray
    }

    //[]操作符重载，与Array相关联
    fun getElement(index:Int):T?{
//        return objectArray.get(index)
//        return objectArray[index]
        return objectArray.getOrNull(index)
    }

    //定义操作符重载，将原有的操作符重载变为自定义的工作逻辑
    //get操作符重载等同于与[]进行对应
    operator fun get(index:Int):T? = objectArray.getOrNull(index)
}