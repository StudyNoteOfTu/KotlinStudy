package com.fytuu.oop.enum

/**
 * 代数数据类型
 * 1. 定义枚举类
 * 2. when使用枚举类
 */
enum class KtGrade {
    PERFECT,
    GOOD,
    NORMAL,
    BAD;
}

//枚举可以实现单例，密封类也可以：
//密封类
//     用处：枚举类的升级版，一个项对应一个静态内部类，内部的INSTANCE为单例
//              单例模式的静态内部类，构造函数私有，只能访问INSTANCE
//     同时，可以自定义类在其中，用class表示，此时这就是一个静态内部类，但并非单例
//              自定义类只会编译为普通的静态内部类，默认构造函数公有，外界可以通过构造函数实例化
//          这里的自定义类可以增加额外的修饰符，例如增加data修饰符，帮我们增加toString，compare，hashcode等函数
sealed class KtGrade2 {
    //单例模式：静态内部类，线程安全
    //class PERFECT extends KtGrade2{INSTANCE,static{init}}
    object PERFECT : KtGrade2()

    object GOOD : KtGrade2()

    object NORMAL : KtGrade2()

    //也可以用class，用了class就不再是单例类了，就是普通的一个类而已
    //  使用的时候仍然要通过构造函数实例化
    class BAD : KtGrade2() {
        //成员变量
        val info: String = "BAD"
            get() = field+"ABC"
            //val变量修饰的不允许有setter方法

        //成员变量- 计算属性
        //          如果计算属性有初值，则getter中必须使用field
        //          如果计算属性没有初值，则getter中不允许使用field
        val compute:String = "abc"
            get() = field+"abc"
    }

    //有点：可以额外进行自定义功能拓展，不仅是原先的单例用处而已
    //      ps: data数据类型，只对主构造函数的接收参数作为成员变量来自动生成copy，tostring等函数
    //          不会对类内的其他成员变量进行自动处理
    data class CUSTOM(val info: String) : KtGrade2()

}

class Judge2(private val grade2: KtGrade2) {
    fun show() =
        //要么包含所有情况，要么加上else
        when (grade2) {
            //如果是KtGrade2.PERFECT这个类（注意这个PERFECT是个静态内部类的类名）
            is KtGrade2.PERFECT -> "表现完美"
            //...其他
            //当然，KtGrade2.CUSTOM是自定义的类，静态内部类，所以可以额外调用一些方法
            is KtGrade2.CUSTOM -> "custom , info is ${(grade2 as KtGrade2.CUSTOM).info}"
            else -> "其他"
        }
}

class Judge(private val grade: KtGrade) {
    fun show(): String {
        //不再强制需要 else
        //  因为种类使用枚举类型做判断，因为枚举类可以明确有哪些种类
        //  要么包含所有情况，要么加上else
        return when (grade) {
            KtGrade.PERFECT -> "表现完美"
            KtGrade.GOOD -> "表现不错"
            KtGrade.NORMAL -> "表现一般"
            KtGrade.BAD -> "表现不足"
        }
    }

//    fun show2() =
//        //不再强制需要 else
//        //因为种类使用枚举类型做判断，因为枚举类可以明确有哪些种类
//        when (grade) {
//            KtGrade.PERFECT -> "表现完美"
//            KtGrade.GOOD -> "表现不错"
//            KtGrade.NORMAL -> "表现一般"
//            KtGrade.BAD -> "表现不足"
//        }
}

fun main() {
//    println(Judge(KtGrade.NORMAL).show())
    println(Judge2(KtGrade2.CUSTOM("infoStr")).show())//只是个普通的静态内部类，需要调用主构造函数才可以获取对象，注意这并不是单例
    println(Judge2(KtGrade2.PERFECT).show())//帮我们做好了单例实例化，可以直接点出来，用的就是PERFECT类的INSTANCE单例

    //如果这个是data类，数据类型，则==为equals，比较的是equals()方法
    //  而data类帮我们重写了equals()方法，比较的是成员变量的值
    //如果是个普通类，进行==判断，一定返回的是false，因为默认的equals()
    //  equals()的默认实现就是直接比较引用
    //===一定是false，因为两个对象不可能引用一致
    println(KtGrade2.CUSTOM("name1") == KtGrade2.CUSTOM("name1"))
}