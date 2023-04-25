package com.fytuu.functions

/**
 * takeIf 内置函数
 */
fun main() {
    println(checkPermissionAction("root","root"))
}

//前端
fun checkPermissionAction(name:String, pwd:String):String{
    //如果匿名函数返回true，则takeIf返回this，如果匿名函数返回false，则takeIf返回null
    return (name.takeIf {
        //it 表示 name
        permissionSystem(it,pwd)
    }?.let {
        //如果非空，执行到let中来
        it+"_appendix"
    })?:"what"

    //空合并操作符 ?:"what"  if(x!=null) this else "what"
    // 空合并操作符 ?: 接收的是takeIf为null的结果，或者let的结果
}
// 权限系统
private fun permissionSystem(username: String, pwd: String): Boolean {//可能返回string，可能null
    return if (username == "root" && pwd == "root") {//== : equals
        return true
    } else false
}