package com.fytuu.oop

class KtCompute {
    //普通字段
    var number: Int = 1
        //只有final getter，且NotNull
        get() = field
        set(value) {
            field = value
        }

    //计算属性 - 某个字段的值是通过计算得到的（重写get()为计算逻辑），而与初始值无关，所以声明时不写初始值
    //          同时，也不会作为成员变量进行编译，使用 xxx.number2 时认为直接调用 getNumber2() 方法
    val number2: Int  //这个写法，number2不会写入成成员变量， 且field失效，get函数覆盖了field本身
        get() =  (1..1000).shuffled().first()//从1.。1000取出随机值，返回给getNumber2()函数

    //普通字段，不严格符合计算属性的定义，更偏向于一个普通字段，在get时额外做了处理
    val number3: Int = -1000  //这样写，number3被写入为final的成员变量，field有效，且必须使用它
        get() = field+ (1..1000).shuffled().first()//从1.。1000取出随机值，返回给getNumber2()函数

    val info :String? = /*null*/ ""

    //Kt约定规范：防范竞态条件： 当调用info成员时，该成员可能为null，也可能为空值 "",就必须采用防范竞态条件
    fun getShowInfo() :String{
        //通过空合并，将可空类型，转为不可空类型
        return info?.let {
            if (it.isBlank()){
                "empty info"
            }else it
        }?:"null info"
    }
}

fun main() {
    val kt = KtCompute()
    println(kt.number)
}