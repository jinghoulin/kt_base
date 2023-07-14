package com.derry.s3

// TODO 42.Kotlin语言的先决条件函数
fun main() {
    var value1: String? = null
    var value2: Boolean = false

    // 判空。常用
    checkNotNull(value1) // java.lang.IllegalStateException: Required value was null.
    // 判空。
    requireNotNull(value1) // java.lang.IllegalArgumentException: Required value was null.

    // 判真假。
    require(value2) // java.lang.IllegalArgumentException: Failed requirement.
    // 自定义异常信息
    require(value2) { "你的Value2是false呀" }
}