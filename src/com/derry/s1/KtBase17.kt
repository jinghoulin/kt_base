package com.derry.s1

// TODO 17.Kotlin中函数参数的默认参数
fun main() {
    action01("lisi", 89)
    action02("wangwu")
    action03()

    action03("赵六", 76)
}

// java的解决是： 是用 建造者设计模式 你自己去builder 我不管了
// KT中解决可以用：默认参数 也可以 建造者设计模式

private fun action01(name: String, age: Int) {
    println("我的姓名是:$name, 我的年龄是:$age")
}

private fun action02(name: String, age: Int = 77) {
    println("我的姓名是:$name, 我的年龄是:$age")
}

private fun action03(name: String = "王五", age: Int = 67) {
    println("我的姓名是:$name, 我的年龄是:$age")
}