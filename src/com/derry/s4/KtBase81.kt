package com.derry.s4

class KtBase81 {

    val info: String

    init {
        // 如果info在getInfoMethod()使用它之后才赋值，肯定空指针异常
        info = "DerryOK"
        getInfoMethod()
        // info = "DerryOK"
    }

    fun getInfoMethod() {
        println("info:${info[0]}")
    }

}

// TODO 81.Kotlin语言的初始化陷阱二学习
fun main() {
    KtBase81().getInfoMethod()
}