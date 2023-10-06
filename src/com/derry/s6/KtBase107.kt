package com.derry.s6

class KtBase107<T>(vararg objects: T, var isMap: Boolean) {
    // vararg 是用数组Array保存和使用的

    // 1.objectArray:Array<T>
    // out 我们的T只能被 读取，不能修改   T只能读取。因为泛型T在传入后不会再变化，所以用out修饰
    private val objectArray: Array<out T> = objects

    // 2.showObj(index)
    fun showObj(index: Int): T? = objectArray[index].takeIf { isMap } ?: null /*objectArray[index]*/

    // 3.mapObj(index, 变换lambda)   objectArray[index]
    fun <O> mapObj(index: Int, mapAction: (T?) -> O) =
        mapAction(objectArray[index].takeIf { isMap }  /*objectArray[index]*/)
}

// TODO 107-Kotlin语言的vararg关键字(动态参数) 多个参数
// 1.objectArray:Array<T>
// 2.showObj(index)
// 3.mapObj(index,变换lambda)
// 4.p.showOBj  p.mapObj(int -> str)
// 5.p的类型  it的类型
fun main() {
    // 泛型中的* 相当于Java的?
    // p的类型 ?

    // 由于你使用的 太多类型的混合了，泛型 这个才是他真正的类型 : KtBase107<{Comparable<*> & java.io.Serializable}>
    //  由于不允许我们这样写 : KtBase107<{Comparable<*> & java.io.Serializable}> 所以我们用父类 Any? 代替
    val p: KtBase107<Any?> = KtBase107("Derry", false, 53454, 4543.3f, 4554.54, null, 'C', isMap = true)
    // 泛型是可以接收null的

    println(p.showObj(0))
    println(p.showObj(1))
    println(p.showObj(2))
    println(p.showObj(3))
    println(p.showObj(4)) // 4554.54
    println(p.showObj(5)) // null
    println(p.showObj(6)) // C

    println()

    // mapObj
    // it的类型  实际上 真正的类型 {Comparable<*> & java.io.Serializable}  需要转换一下才行 例如：it.toString
    val r: Int = p.mapObj(0) {
        it
        it.toString()
        it.toString().length
    }
    println("第零个元素的字符串长度是:$r")

    // it的类型  实际上 真正的类型 {Comparable<*> & java.io.Serializable}  由于我们的第三个元素是 Int类型，所以不需要转换，自动转的
    val r2: String = p.mapObj(2) {
        "我的第三个元素是:$it"
    }
    println(r2)

    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    val p2: KtBase107<String> = KtBase107("AAA", "BBB", "CCC", isMap = true)
    val r3 = p2.mapObj(2) {
        it
        // it 的类型：  是String?    为什么 it 是 String? , 是因为你的  lambda (T?) -> O  参数是T?
        "我要把你变成String类型 it:$it"
    }
    println(r3)
}