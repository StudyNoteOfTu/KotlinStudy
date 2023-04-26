package com.fytuu.oop.init

//生成 KtField 类
class KtField {
    var name = "field name"
    /*
        //由于是不可空类型，有@NotNull
        @NotNull
        private String name = "field name"
        //以及getter/setter
        //外界可以通过 KtField().name 来访问name，实现原理是get方法，并不是直接访问字段！
        final getter/setter

        //如果是 NotNull，在代码的最前面还会默认加上判空操作 kotlin/jvm/.../Intrinsics.checkParameterIsNotNull(value, "value");
     */

    //var 为 普通变量， 仍为 private，有getter和setter
    var info = "field info"
        //改成大写返回
        get() = field.toUpperCase()
        set(value/*:String*/) {
            field = "[override set value]_$value"
        }

    //val 为 final 修饰符修饰，仍为 private， 有getter，没有setter
    val constVal = ""
}

//以下位于 KtFieldKt.class 中
fun main() {
    val ktField = KtField()
    //实际是： ktField.getName()
    println("ktField name is ${ktField.name}")
    //内部 调用setName()
    ktField.info = "newInfo"

    println(ktField.info)
}