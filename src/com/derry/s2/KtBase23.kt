package com.derry.s2

// TODO 23.Kotlin语言的匿名函数学习
fun main() {
    val len = "Derry".count()
    println(len)

    val len2 = "Derry".count {
        // it 等价于 D e r r y 的字符 Char
        it == 'r'// 如果 it 等于 r 字符，就返回true， 最终返回两个true
    }
    println(len2)
}

