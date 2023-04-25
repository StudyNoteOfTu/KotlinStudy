package com.fytuu.lambda

/**
 * 特别注意，这里main中匿名函数/lambda表达式生成的字节码存在 bridge 关键字，这是桥方法
 * 函数的具体实现在invoke中。其效果类似于Java中：
 * interface AnonymousInterface{
 *     void invoke(String msg, int code);
 * }
 *
 * public static void main(String[] args){
 *      loginAPI("Fytuuu","123456",(msg,code)->{...})
 * }
 *
 * 个人体验：Android中就有很多这种需要回调的地方，如果每个地方都单独写一个interface可能会很麻烦
 * 使用kt这个方式，可以避免写接口，直接匿名函数即可，签名一致就可以使用。
 */

/**
 * 传入参数为函数
 * 在java中要用接口来做回调
 * kt原理也类似，因为约定了函数的传参和返回值，这就相当于约定了接口的一个函数
 */
fun main() {
    //由于是最后一个参数，所以可以写到括号外面去
    loginAPI("Fytuuu","123456"){msg,code->
        println("msg:$msg code:$code")
    }
    //不取出去的写法：
//    loginAPI("Fyt","123",{msg,code->
//        println("msg:$msg code:$code")
//    })

    //还有一种写法，这个写法理解为具名函数的调用，往函数的responseResult名字的传入参数，传入{}lambda匿名函数
//    loginAPI("Fytuuu","123456",responseResult = {msg,code->
//        println("msg:$msg code:$code")
//    })
}

//模拟：数据库 SqlServer
private const val USER_NAME_SAVE_DB = "Fytuuu"
private const val USER_PWD_SAVE_DB = "123456"

//登录API , 模仿前端传入用户名密码
//回调函数为 responseResult
fun loginAPI(username:String, userpwd:String, responseResult:(String,Int)->Unit){
    //为empty也算作是null
    if (username == null || userpwd == null){
        TODO("用户名或密码为null")//抛出异常的方式
//        println("用户名或者密码为null")
//        return
    }
    //校验
    if (username.length > 3 && userpwd.length > 3){
        //调用服务器来校验服务器登录校验
        if (webServerLoginAPI(username,userpwd)){
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

//登录的API暴露者 服务器
//接收前端发来的消息
private fun webServerLoginAPI(username:String,userpwd: String):Boolean{
    //这里的==相当于java的equals
//    if (username == USER_NAME_SAVE_DB && userpwd == USER_PWD_SAVE_DB){
//        return true
//    }else{
//        return false
//    }
    //但是 kt 的 if 是表达式， java的if是语句，所以可以改写为：
    // 1. 三目运算符
//    return username == USER_NAME_SAVE_DB && userpwd == USER_PWD_SAVE_DB
    // 2. kt 的 if 表达式
    return if (username == USER_NAME_SAVE_DB && userpwd == USER_PWD_SAVE_DB) true else false
}