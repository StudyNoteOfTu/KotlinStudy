package com.fytuu.oop.type

/**
 * out - 协变 - 修饰只能作为输出参数的类型
 * in - 逆变 - 修饰只能作为传入参数的类型
 * 什么都不写，就是不做权限设定
 *  没有out、in修饰的类型的对象，既可以作为输出参数，也可以作为传入参数
 *
 *  从 协变与逆变 的字面意思来看
 *  在Java中，频繁往外读取数据的，适合使用泛型的上界限定符 extends，频繁插入的，适合使用下界限定符 super
 *  同时，extends可以用于返回类型的限定，但是不可以用于参数类型的限定，super可以用于参数类型的限定，不能用于返回类型的限定
 *
 * Java <? extends T>    <? super T>
 * kt   <out T>          <in T>
 *说明  接收其与其子类     接收其与其父类
 *
 *  也就是说 ， kt中 out 和 in 只是表现为传入参数、传出参数权限的修饰限定
 *      而实际上，其实就是Java中泛型的一种限定符
 *      <out T> 相当于可以使用类型 T 或 T的子类，当它作为返回值的时候，无论具体类型是什么，返回值都可以用T作为父类进行指引。
 *          （多态）（更多用于多态的父类对子类的指引，而不做改变）
 *      <in T> 则相反，可以使用T或T的父类，作为频分插入数据的类型，可以确保插入的逻辑一定在T中有实现
 *          （换句话说，就是对它进行改变的方法总存在）
 *
 */
interface Producer<out T> {
    //T类型的参数不允许作为一个传入参数的类型
    //例如下列代码将会报错
//    fun producer(item: T) {}

    //作为一个生产者，out修饰的T类型对象只能被对外提供
    fun producer(): T
}

//同理，消费这的设计，in修饰的T类型对象只能被读取修改使用，不允许输出，对外提供
interface Consumer<in T> {
    //in修饰的T类型对象，能够被作为传入参数，被修改，但该类型不允许作为输出
    fun consume(item: T)
    //T类型的参数只能作为传入参数，不能作为输出参数的类型
//    fun consume():T{}
}

class CakeProducer() : Producer<CakeProducer.Cake> {
    //不加 inner修饰符，为静态内部类，这里这样写主要是让Cake与CakeProducer写在同一个地方，逻辑上合理
    //两者联系很密切 - 从属，而不被别人使用，就可以使用内部类来写，至于是否静态则看情况。
    class Cake() {}

    override fun producer(): Cake {
        //提供一个Cake
        return Cake()
    }
}

interface TypeInfo<out T>
open class TypeFather() {}
class TypeSon() : TypeFather() {}

class Pdc1 : TypeInfo<TypeFather>
class Pdc2 : TypeInfo<TypeSon>

fun main() {
    //如果是 interface TypeInfo<T> 则以下代码会报错，不支持泛型类型父子类的赋值
    val p: TypeInfo<TypeFather> = Pdc2()
    //但是如果在泛型类型前加上out修饰，则可以
    //相当于 <T> 是不允许接受 T 的子类的
    //但是 <? extends T>则允许接收T的子类
    //Java的<? extends T>限定符，在Kt中的表现为 <out T>
}

