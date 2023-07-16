package com.derry.s3

import java.io.File

// TODO 50.Kotlin语言的apply内置函数
fun main() {
    val info = "Derry You Hao"

    // 普通的方式
    println("info字符串的长度是:${info.length}")
    println("info最后一个字符是:${info[info.length - 1]}")
    println("info全部转成小写是:${info.toLowerCase()}")

    println()

    // apply内置函数的方式
    // info.apply特点：apply函数始终是返回 info本身 String类型
    val infoNew: String = info.apply {
        // 一般大部分情况下，匿名函数，都会持有一个it，但是apply函数不会持有it，却会持有当前this == info本身
        println("apply匿名函数里面打印的:$this")

        println("info字符串的长度是:${length}")
        println("info最后一个字符是:${this[length - 1]}")
        println("info全部转成小写是:${toLowerCase()}")
    }
    println("apply返回的值:$infoNew")

    println()

    // 真正使用apply函数的写法规则如下：
    // info.apply特点：apply函数始终是返回 “info本身”this，所以可以链式调用
    info.apply {
        println("长度是:$length")
    }.apply {
        println("最后一个字符是:${this[length - 1]}")
        true
        true
        true
    }.apply {
        println("全部转成小写是:${toLowerCase()}")
    }

    println()

    // 普通写法
    val file = File("D:\\a.txt")
    file.setExecutable(true)
    file.setReadable(true)
    println(file.readLines())

    println()

    // apply写法
    // 匿名函数里面 持有的this == file本身
    /*val fileNew: File =*/ file.apply {
        setExecutable(true)
    }.apply {
        setReadable(true)
    }.apply {
        println(file.readLines())
    }

    // TODO apply内置函数的结论：
    // 1.xxx.apply的返回值是， xxx点apply，返回xxx本身
    // 2.xxx.apply里面没有it，只有this，this == xxx本身
    // 3.使用中，不需要用apply的返回值，而是尽量链式调用，功能分层
}