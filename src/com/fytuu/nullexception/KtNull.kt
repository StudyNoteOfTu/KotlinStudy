package com.fytuu.nullexception

/**
 * 默认是不可为空类型，不能随意给null
 */
fun main() {

    //第一种情况，默认是不可空类型，不能岁一个null

    var name:String = "Fytuuu"
    //null不能是非空类型String的值
//    name = null

    //第二种情况，声明时指定为可空类型
    var name2:String ?
    name2 = null;
    println(name2)
    name2 = "Fytuu"


    //判空 v?.func() 执行函数
    var name3:String? ="zhangsan"
    name3 = null
    name3?.capitalize()//name是可空类型的，想要使用必须给出补救措施：
    //name3?.func() : 如果name3为空，则func()方法不执行
    //这个写法比java来得高效很多

    //let安全调用 ， 判空执行多个函数 let把多个函数包装起来
    val res = name3?.let {
        // it = name3 本身
        if (it.isBlank()){
            //如果name3是empty值，没有内容
            "Default"//返回
        }else{
            it //返回 name3 本身
        }
    }
    //相当于：
    //if (name3 != null) {
    //         boolean var3 = false;
    //         boolean var4 = false;
    //         int var6 = false;
    //         var10000 = StringsKt.isBlank((CharSequence)name3) ? "Default" : name3;
    //      } else {
    //         var10000 = null;
    //      }

    println(res)
}