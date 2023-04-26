package com.fytuu.oop.init

/**
 * 惰性加载 by lazy 自动加载，不用主动去调用了
 */
class KtByLazy
{
    val data by lazy {
        fetchData()
    }

    private fun fetchData():String{
        return "lazy data"
    }


}

fun main() {
    val ktByLazy = KtByLazy()
    //用到的时候才加载
    println(ktByLazy.data)
}