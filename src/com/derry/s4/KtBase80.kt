package com.derry.s4

class KtBase80 {

    var number = 9

    // 成员number的声明要在init使用它之前
    init {
        number = number.times(9)
    }

}

// TODO 80.Kotlin语言的初始化陷阱一学习
fun main() {
    println(KtBase80().number)
}