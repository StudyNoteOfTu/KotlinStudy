package com.fytuu.oop.enum

/**
 * 枚举类
 */

enum class KtMenu0 {
    Item1,
    Item2,
    Item3
}

//类同java
/**
 * public enum Season{
 *  SPRING(1),SUMMER(2),AUTUMN(3),WINTER(4)
 *
 *  private int code;
 *  private Season
 * }
 */
enum class KtMenu(var num: Int) {
    Item1(1),
    Item2(2),
    Item3(3)
}

/**
 * 其他使用方法：
 *      枚举类用来存放固定对象
 */
class Card(val info: String) {
    fun show() {
        println("Card info is $info")
    }
}

//把CardInfo的实例对象装到
//enum class CardContainer(private val c: Card) {
//由于未来需要访问到内部包裹的Card，所以要用val或者var来接收它
enum class CardContainer(var c: Card) {
    Container1(Card("c1")),
    Container2(Card("c1")),
    Container3(Card("c1"));//最后要是封号

    //通用方法

    fun show() {
        println("Container shows info : ${c.info}")
    }
}

fun main() {
    //相当于走了 public static final KtMenu Item1 = new KtMenu(1)
    //KtMenu.Item1.getNum()
    println(KtMenu.Item1.num)

    //拿到内部的值
    CardContainer.Container1.c = Card("c4")
    println(CardContainer.Container1.c.info)
    //容器的方法
    CardContainer.Container1.show()
}