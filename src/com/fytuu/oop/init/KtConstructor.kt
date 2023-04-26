package com.fytuu.oop.init

/**
 * 主构造函数 - 临时参数
 * 主构造函数 - 直接接收
 *
 * 次构造函数（构造函数重载）
 *
 * 构造函数的默认参数
 */

/**
 * 主构造函数 - 临时参数
 * 1. 变量名约定以 _ 开头
 * 2. 需要接收才能使用
 */
class KtStudent(_name: String, _sex: Char, _age: Int) // 主构造函数
{
    //写在次构造函数之外的变量声明，都在主构造函数中执行初始化
    //且访问不到次构造函数新的传入参数
    var info: String = ""

    //次构造函数1
    constructor() : this("", 'F', 12) {
        //空构造函数
    }

    //次构造函数2， 以下写法是错误的，和主构造函数重复了，只会调用主构造函数，不会调用该构造函数
    constructor(name: String, sex: Char, age: Int, info: String = "default info") : this(name, sex, age) {
        this.info = info
    }

    //接收构造函数
    var name = _name
        get() = field   //只允许public
        private set(value) { //可以主动设为private
            field = value
        }
    val sex = _sex //只读，不允许修改： val变量不允许有setter
        get() = field

    //计算属性
    val age = _age
        get() = if (field < 0) -1 else field

    fun show() {
//        println(this.name)
        println(name)
    }
}

/**
 * 主构造函数 - 直接接收
 * 缺点：只能用默认的getter、setter
 * 可以和临时类型结合使用，用两者的优点
 */
class KtStudentPro(_name: String = "", val sex: Char = 'M', val age: Int = -1) {

    //name的getter、setter需要定制化，可以用接收的方式进行处理，其他的用默认处理
    var name = _name
        get() = field
        set(value) {
            field = value
        }
}


fun main() {
    //---------主构造函数 - 临时参数
    //使用构造函数
    KtStudent("fytuu", 'F', 23)
    //也可以具名地构造（和函数一样，通过具名，可以打乱顺序）
    val student = KtStudent(_sex = 'F', _age = 23, _name = "fytuu")
    println(student.name)
    student.show()

    //---------主构造函数 - 直接接收
    val studentPro = KtStudentPro("fytuu", 'M', 23)

    //--------- 次构造函数
    val student2 = KtStudent()
    val student3 = KtStudent("fytuu", 'M', 23, "my info")

    //--------- 构造函数 + 默认参数
    val student4 = KtStudentPro()
    // 需要注意：
    // 打印由次构造函数+默认参数的情况
    println(student.info)//打印为""，说明还是走了初始构造函数
    //重载选择优先级： 主构造函数 > 次构造函数
    //调用顺序： 主构造函数 > 次构造函数 (原因也很简单，次构造函数内部都走了 this())，而主构造函数内部走了super()
}