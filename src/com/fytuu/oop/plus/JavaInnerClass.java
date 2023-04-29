package com.fytuu.oop.plus;

public class JavaInnerClass {

    public class InnerClass {
    }

    public static void main(String[] args) {
        //一般静态内部类不会这么搞
        //静态内部类只是内部使用的
        InnerClass in = new JavaInnerClass().new InnerClass();
    }
}

class Annother{
    public void fun(){
        JavaInnerClass.InnerClass in = new JavaInnerClass().new InnerClass();
    }
}
