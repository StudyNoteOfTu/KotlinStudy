package com.fytuu.functions

/**
 * takeUnless 内置函数，与takeIf功能相反
 *      如果takeUnless(block)的内置函数block返回false，
 *      则返回T调用者本身
 */

//takeUnless的意义：
class Manager {

    private var infoValue: String? = null

    //返回 String? 类型
    fun getInfoValue() = infoValue

    fun setInfoValue(infoValue: String) {
        this.infoValue = infoValue
    }
}

fun main() {
    val manager = Manager()
    //也经常和空合并操作符 ?: 一起使用
    val infoRes = manager.getInfoValue().takeUnless {
        //如果infoValue为空或者null，返回true
        it.isNullOrBlank()
    } ?: "infoValue未初始化"
    println(infoRes)

    manager.setInfoValue("inited")

    //需要注意下面这个加了let的写法，
    // 空合并操作符 ?: 接收的是takeUnless为null的结果，或者let的结果
    val infoRes2 = manager.takeUnless {
        manager.getInfoValue().isNullOrBlank()
    }?.let {
        it.getInfoValue() + "_appendix"
    } ?: "infoValue未初始化"
    println(infoRes2)

    //用了 takeUnless 可以不用再去写 ！ 进行结果取反，代码整洁
}