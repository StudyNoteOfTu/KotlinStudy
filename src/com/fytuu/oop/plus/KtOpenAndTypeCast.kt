package com.fytuu.oop.plus

import java.io.File

//所有的类，默认是final修饰的，要被继承的话，需要主动加上open
open class Person(val name:String){
    fun showName() = println("name is {$name}")

    //Kt所有函数，也默认是final修饰的，不能被重写，需要主动加上open
    //而且open修饰的，只能是public 、 protected
    open fun myPrint() = println("waiting for override")
}

//不可以再用 name， 重名
// 'name' hides member of supertype 'Person' and needs 'override' modifier
class Student(val subName:String): Person(subName){

    override fun myPrint() {
        super.myPrint()
        //subName直接使用了主构造函数+直接接收
        //name由于调用的是父类的name，需要通过getter进行访问
        println("student name is $subName , father name is $name")
    }


    fun uniqueFun(){
        println("子类特有的函数")
    }
}

//类型转换
fun main() {
    val p : Person = Student("张三")
    p.myPrint()//调用函数，优先走子类实现

    println(p is Person)//instance of
    println(p is Student) // is means instance of
    println(p is File)

    //is 或者 as 选择一个做类型转换
    if(p is Student){
        (p as Student).uniqueFun() //这样写是标准的，
        // 当然现在编译器已经很智能了，当看到uniqueFun被调用的时候，可以默认把p转为student
    }
    //如果没有被is包裹，则无法只能转换，必须主动写 as Student明确说明
    (p as Student).uniqueFun()
}