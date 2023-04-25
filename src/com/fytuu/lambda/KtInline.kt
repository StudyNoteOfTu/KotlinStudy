package com.fytuu.lambda

/**
 * 内联函数
 *      相当于 C++ inline内联函数效果
 *      C++：内联函数 vs 宏定义/替换
 *          内联函数在编译时展开，宏在预编译时展开
 *          编译时，内联函数直接嵌入到目标代码中，而宏只是一个简单的文本替换
 *          宏定义不是函数，内联函数是真正的函数，会进行安全性检查
 *          inline是一个建议性关键字，实际决定权在操作系统
 */
fun main() {
    //- 如果不用内联函数：
    //      lambda代码块的执行将会被放在一个对象中（调用invoke方法来执行）
    //      由于需要利用对象，所以会造成性能损耗
    //- 使用内联函数后：
    //      直接将 loginAPI2这个函数的代码块以及lambda的代码块编译（编译为字节码）到此处
    //      减少函数开辟(栈）、对象开辟（堆）带来的性能损耗
//    loginAPI2("Fytuuu","123456"){msg,code->
//        println("msg:$msg code:$code")
//    }

    //另一种写法, lambda是函数类型的对象！
    //将一个方法转为对象来引用，可以通过 ::methodName 的方式来做
    //如果没有inline，字节码中仍然是通过一个对象的方式传入参数responseResult //(Function2)null.INSTANCE
    //  :: 可以理解为将这个函数，变为函数类型的对象
//    val funObj = ::responseResult
//    loginAPI2("Fytuuu","123456",funObj);
    loginAPI2("Fytuuu","123456",::responseResult);
}

//也可以单独把这个传入函数给写出来（类似单独把java中的匿名内部类抽出来写）
fun responseResult(msg:String,code:Int){
    println("msg:$msg code:$code")
}

//静态方法，签名一致的话会与同一个包下的产生冲突
inline fun loginAPI2(username:String,userpwd:String,responseResult:(String,Int)->Unit){
    if (username == null || userpwd == null){
        TODO("用户名或密码为null")//抛出异常的方式
    }
    //校验
    if (username.length > 3 && userpwd.length > 3){
        //调用服务器来校验服务器登录校验
        if (webServerLoginAPI2(username,userpwd)){
            //登录成功
            responseResult("登录成功",200);
        }else{
            //登录失败
            responseResult("登录失败",444);
        }
    }else{
        TODO("用户名和密码不合格")
    }
}
// inline 内联函数调用的函数不允许是private的，必须是public
//登录的API暴露者 服务器
fun webServerLoginAPI2(username:String,userpwd: String):Boolean{
    return username == USER_NAME_SAVE_DB && userpwd == USER_PWD_SAVE_DB
}

private const val USER_NAME_SAVE_DB = "Fytuuu"
private const val USER_PWD_SAVE_DB = "123456"