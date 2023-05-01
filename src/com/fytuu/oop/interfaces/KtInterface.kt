package com.fytuu.oop.interfaces

//接口类不需要open，默认就有
//  接口不能有构造函数
//  如果有成员变量，子类除了重写函数，还需要重写函数
//      原因很简单，如果在接口中定义了一个变量，变量不会被编译
//      变量X会被编译为 getX() 和 setX(x:String) 两个空函数
//      这个成员变量不允许赋给初值，就只用于编译为getter/setter两个空函数
//      如果成员变量被 val 修饰，则只有getter空函数，而没有setter
//      这两个空函数不能直接被子类重写，而是需要通过重写变量值的形式，进行重写
interface IUSB {
    //接口中可以有变量，将被编译为getter、setter(如果是var修饰）两个空函数
    val usbVersion: Int

    fun addUsb()
}

//这两个空函数不能直接被子类重写，而是需要通过重写变量值的形式
//  这里主构造函数给了一个默认值，这是C++特性中的缺省传入参数的特性
//重写getter setter函数的方式 1：
//  通过在构造函数中对接口中定义的变量加上override修饰，完成其getter与setter方法的重写
//  不要求接受参数的修饰符必须与接口一致，接口变量被val修饰的话，实现类可以用var修饰
class Mouse(override var usbVersion: Int = 1) : IUSB {

    //把自己返回出去
    fun changeVersion(): Mouse {
        usbVersion += 1
        return this
    }

    fun showVersion() {
        println("version is $usbVersion")
    }

    override fun addUsb() {
        println("add new usb , version is $usbVersion")
    }
}
//重写getter setter函数的方式 2：
//  通过在类内对接口中定义的变量加上override修饰，完成其getter与setter方法的重写
//  不要求接受参数的修饰符必须与接口一致，接口变量被val修饰的话，实现类可以用var修饰
open class KeyBoard : IUSB{
    //与普通的类不一样的是，这里的成员变量必须初始化
    //补充：Kt可以做响应式，因为所有成员变量都有getter、setter方法
    override var usbVersion: Int = 1
        get(){
//            println("响应式，get前")
            return 1
        }
        set(value){
            println("响应式，set前")
            //kt中没有三目运算符
            field = if(value==1) 1 else 0
        }

    override fun addUsb() {
        println("add new usb , version is $usbVersion")
    }
}

//实现类的子类
//     也可以通过上述方式对父类的成员变量进行重写，这部分细节在继承的章节进行探究
class KeyBoardSon(override var usbVersion: Int) : KeyBoard(){
//    //可以继续往下重写
//    override var usbVersion: Int
//        get() = super.usbVersion
//        set(value) {}
}

fun main() {
    Mouse().showVersion()
    Mouse().changeVersion().showVersion()

    val keyBoard = KeyBoard()
    keyBoard.usbVersion = 10
    println("key board version is ${keyBoard.usbVersion}")
}