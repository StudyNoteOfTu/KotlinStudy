package com.fytuu.string


const val INFO = "Fytuu is a baidu engineer "
fun main() {
    //----------- substring -----------
    //indexOf
    val i = INFO.indexOf('i')
    //substring(startIndex:Int, endIndex:Int)
    INFO.substring(0,i)
    //substring(range:IntRange) 编译器将 0..i 编译为 IntRange 对象
    // IntRange.start 和 IntRange.end
    INFO.substring(0..i)
    //和..等价
    INFO.substring(0 until i) //Kt 一般使用此方式


    //----------- split -----------
    val jsonText = "Fytuu,Leo,Jett"
    //list 会自动类型推断为 List<T> ,其中T为String，泛型方法自动判断
    val list = jsonText.split(',')
    println("split list is $list")

    //对标 C++的解构操作 ， Kt也有解构
//    val (v1,v2) = list //可以只取前几个，但不能越界
    val (v1,v2,v3) = list
    println("v1 $v1, v2 $v2, v3 $v3")


    //----------- replace -----------
    val sourceVal = "abcdefghijklmnopqrstuvwxyz"
    //正则表达式方式 Regex("CharSequence")
    //模拟字符替换成数字
    val res = sourceVal.replace(Regex("[akmno]")){
//        println(it.value)
//        it.value//完全没做任何事情，表示返回遍历到的符合正则表达式的字符
        when(it.value){
            //akmno
            "a" -> "1"
            "k" -> "2"
            else -> it.value
        }
    }
    //底层原理：将lambda作为 transform函数传入，最后拼接replace结果的时候，进行：
    //  不在正则内的： sb.append(origin)
    //  在正则内的：   sb.append(transform(origin))

    println(res)
}