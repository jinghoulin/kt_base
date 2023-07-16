package com.derry.s3

// TODO 46.Kotlin语言的==与===比较操作
fun main() {
    // == 值 内容的比较  相当于Java的equals
    // === 引用的比较

    val name1: String = "Derry"
    val name2: String = "Derry"
    val name3 = "ww"

    // 小结：name1.equals(name2)  等价于 name1 == name2  都是属于 值 内容的比较
    println(name1.equals(name2)) // java
    println(name1 == name2) // kt

    // PS: Java中用字面量"Derry"给字符串赋值，是开辟在字符串常量池中，所以两个字符串用相同的字面量则地址相同
    // PS: 除非用new String("Derry")赋值，new的对象会开辟在堆中，则地址不同

    // 引用的比较
    println(name1 === name2) // true
    println(name1 === name3) // false

    // 引用的比较 难度高一点点
    val name4 = "derry".capitalize() // 修改成"Derry"
    println(name4 === name1)
    // "derry".capitalize() 把 d 修改成 大写的D，并不是复用了 n1/n2的 字符串常量池里面的 “Derry”
    // 所以是false
}