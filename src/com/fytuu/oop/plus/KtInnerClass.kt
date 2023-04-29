package com.fytuu.oop.plus

/**
 * 内部类
 *      Kt中： 嵌套类 = 静态内部类
 *      通过加上 inner 将其标识为 非静态内部类
 */
//一个传入参数的主构造函数
class Body(_bodyInfo: String) {
    //身体类，外部信息
    //主构造函数赋初值的成员变量：
    val bodyInfo = _bodyInfo

    //默认情况下是 ： 静态内部类
    //添加 inner 才变为非静态内部类，可以访问外部类的变量
    inner class Heart(_heartInfo: String) {
        val heartInfo = _heartInfo
        //心脏类
        //非静态内部类可以访问外部类变量
        inline fun showBodyInfo() {
            println("outer class body info is: $bodyInfo")
            println("inner class heart info is: $heartInfo")
        }
    }

    //默认情况下是： 静态内部类
    //Java形式：
    //public static final class Arm{...}
    class Arm(_armInfo: String) {
        //手臂类
        class Hand {
            class LeftHand {

            }

            class RightHand {

            }
        }
    }

}


fun main() {
    //非静态内部类的实例方法只有这样，通常不建议这么做
    //java:
    //InnerClass inner = new OuterClass().new InnerClass()
    val heart = Body("").Heart("")

    //静态内部类可以单独实例化
    val arm = Body.Arm("")
}