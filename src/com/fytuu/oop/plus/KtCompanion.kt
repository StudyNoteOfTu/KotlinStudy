package com.fytuu.oop.plus

/**
 * 伴生对象
 *      在KT中是没有static静态成员变量的，伴生对象用来代替这个设计缺陷
 *
 * 原理：
 *      1. 生成的类中有静态成员 Companion，其内部有所有的static方法（伴生对象中的方法）
 *      2. 伴生对象的成员在外部类中进行编译插入，编译为static类，同时是private的
 *      3. getter setter被卸载Companion类中，是static静态方法
 *      4. 编译时，伴生对象 Companion被编译为静态内部类，构造函数私有
 *
 *      //   public static final KtCompanion.Companion Companion = new KtCompanion.Companion((DefaultConstructorMarker)null);
 *      //   public static final class Companion {...}

 */
class KtCompanion{
    //伴生对象 - 包装静态成员、静态方法
    companion object {
        //写了 public 也没用，一定是private的，不允许直接点它
        val staticVal = "staticInfo"
        fun showStaticVal() = println("show info : $staticVal")
    }
}


fun main() {
    println(KtCompanion.staticVal)

    KtCompanion.showStaticVal()

}