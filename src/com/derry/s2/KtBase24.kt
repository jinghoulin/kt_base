package com.derry.s2

// TODO 24.Kotlin语言的函数类型&隐式返回学习
fun main() {
    // 我们现在在写函数

    // 第一步：函数的输入输出的声明。这个变量名（lambda的声明）只是对函数的描述
    val methodAction : () -> String
    // lambda表达式语法：(parameters) -> {statements} 实现时当一个参数时可以省略()，当一条语句时可以省略{}

    // 第二步：对上面函数的实现
    methodAction = {
        val inputValue = 999999
        "$inputValue Derry" // == 背后隐式 return "$inputValue Derry";
        // 匿名函数不要写return，最后一行就是返回值
    }

    // 第三步：调用此函数
    println(methodAction())
    println(methodAction.invoke())// 在lambda执行的时候会创建匿名函数的Function类再调用其invoke方法实现
}

/*
fun methodAction() : String {
    return "Derry"
}
 */