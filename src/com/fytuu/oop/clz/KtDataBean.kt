package com.fytuu.oop.clz

/*
note：
1. 数据类型至少必须含有一个参数的主构造函数
2. 数据类型的主构造函数必须主动接受参数，val var修饰接收参数
3. 数据类型不能使用 abstract/open/sealed/inner等修饰，数据类型只负责数据载入
        可以理解为面向主构造函数参数的普通JavaBean，没有其他额外的功能
4.  仅需要普通的 copy/toString/解构/compare比较 等功能时，可以使用数据类型
 */


//普通类
//setter getter
class KtNormalBean(var msg: String, var code: Int, var data: String)

//数据类 - JavaBean形式
//额外多了 component、toString、hashcode、equals、copy
//      这些多出来的函数，只是用主构造函数声明的变量，而且必须主动接收！！！
//      其中，对象类型的数据的copy为引用拷贝
data class KtDataBean(var msg: String, var code: Int, var data: String)


//copy()只会拷贝柱构造器中声明的变量！！！
//data class Parent(var son:KtDataBean,var son2:KtNormalBean)
data class Parent(var num:Int, var son:KtDataBean){
    //给一个次构造函数也可以，因为无论如何，初始化的时候一定会调用到主构造函数
}


fun main() {
    //结构操作
//    val (v1,v2,v3) = listOf()

    //调用toString打印的是 com.fytuu.oop.clz.KtNormalBean@610455d6
    //默认Any即java的Object的toString
    println(KtNormalBean("loginSuccess", 200, "ok"))

    //这个是data帮你实现了toString等函数
    println(KtDataBean("loginSuccess", 200, "ok"))

    //数据类型也提供了equals()，如果不是同一个对象，则会比较内容
    println(
        KtDataBean("loginSuccess", 200, "ok")
                == KtDataBean("loginSuccess", 200, "ok")
    ) //true

    //如果是默认类，默认equals则是引用的比较
    println(
        KtNormalBean("a", 200, "a")
                == KtNormalBean("a", 200, "a")
    )//false

    //data类提供的copy函数
    val son1 = KtDataBean("son1",200,"son1")
    var num = 20
    val parent = Parent(num,son1)
    val copyFromParent = parent.copy()//内部默认copy了son1
    //验证拷贝情况
    println(parent.son == copyFromParent.son)//应该为true，因为值相同
    println(parent.son === copyFromParent.son)//应该为true，copy直接把引用交出去了
    //验证拷贝是引用拷贝：
    son1.msg="changed Mes！！！"
    num = 40
    println(parent.son.msg) //结果：changed Mes!!!
    println(copyFromParent.son.msg)//结果：changed Mes!!!

    println(parent.num)//仍然是20
    println(copyFromParent.num)//仍然是20

    //结论：copy为引用拷贝，如果是基本类型则为值拷贝
    //      其实本质就是直接把操作数拷贝了，引用类型的操作数是引用地址
    //          所以拷贝的是引用地址 -> 引用拷贝
    //          如果原来的对象在其指向的地址上做了数据修改，那么由于引用拷贝
    //          引用没变，拷贝来的对象也指向的是这个地址，使用的时候用的是上述对象（同一个对象）
    //          称之为引用拷贝、浅拷贝
    //      而基本类型的操作数（内容本身）就是值
    //          所以拷贝的是值 -> 值拷贝
    //          原来地址的被修改了也无所谓，我拷贝的是原来的值
    println(parent)
}
