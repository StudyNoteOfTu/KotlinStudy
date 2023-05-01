package com.fytuu.oop.interfaces

/**
 * 接口的默认实现：对标Java中的default
 */
interface IUSB2{
    //成员变量可以给初值，方式为给getter默认实现
    val usbVersion:Int
        get() = 1 //初始值
    //val 不允许为setter

    val usbInfo:String
        get() = "init default usb info"

    fun show(){
        println("default fun show() impl with show usbVersion: $usbVersion")
    }

    //默认实现的原理：
    //  都被写入到接口中 DefaultImpls 静态内部类里成为 static 函数
    //  同时，这些static函数都至少有一个IUSB2类型的传入参数，表示调用者实例
    //      也得益于此设计，方法的默认实现之间，可以访问其他变量，例如show()可以访问usbVersion
    //      底层其实是调用了Kt形式 show($this:IUSB2){... $this.getUsbVersion()}
}

class Mouse2:IUSB2{
    override val usbVersion: Int
        get() = super.usbVersion //默认调用了父类的默认实现，其实是父类的默认getter是实现
    //Java形式： IUSB2.DefaultImpls.getUsbVersion(this)
}

fun main() {

}