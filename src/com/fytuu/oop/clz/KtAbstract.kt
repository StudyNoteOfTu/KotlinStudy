package com.fytuu.oop.clz

abstract class BaseActivity {

    fun onCreate() {
        setContentView(getLayoutId())
        //模板方法+默认实现
        initViews()
        initData()
    }

    private fun setContentView(layoutId: Int) {
        println("加载到 $layoutId 布局")
    }

    abstract fun getLayoutId(): Int

    //以及一些不一定要重写的函数
    open fun initViews() {
        //空默认实现 ，模板方法
    }

    //默认函数都是被final修饰的
    open fun initData() {
        //空默认实现 ，模板方法
    }
}

class MainActivity : BaseActivity(){
    override fun getLayoutId(): Int {
        return 1 //R.layout.activity_main
    }

    override fun initViews(){
        super.initViews()
        println("init views")
    }

    override fun initData() {
        super.initData()
        println("initData")
    }
}

fun main() {
    MainActivity().onCreate()
}