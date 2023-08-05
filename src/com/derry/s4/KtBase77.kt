package com.derry.s4

/**
 * 个人总结：Kotlin的类成员（字段）和init代码块，都会生成在Java的构造函数中，且按代码前后顺序。验证：反编译成Java
 */
// 第一步：生成val sex: Char
class KtBase77(_name: String, val sex: Char) // 主构造
{

    // 第二步： 生成val mName  // 由于是写在 init代码块前面，所以先生成， 其实类成员 和 init代码块 是同时生成
    val mName = _name

    init {
        val nameValue = _name // 第三步：生成nameValue细节
        println("init代码块打印:nameValue:$nameValue")
    }

    // 次构造 三个参数的  必须先调用主构造
    constructor(name: String, sex: Char, age: Int) : this(name, sex) {
        // 第五步：生成次构造的细节
        println("次构造 三个参数的, name:$name, sex:$sex, age:$age")
    }

    // 第四步
    val derry = "AAA"

    // 纠正网上优秀博客的错误： 类成员先初始生成   再init代码块初始生成  错误了
    // Derry正确说法：init代码块 和 类成员 是同时的，只不过它写在 init代码块前面 就是先生成它
}

// TODO 77.Kotlin语言的构造初始化顺序学习
// 1.main 调用次构造 name sex age
// 2.主构造的 val 变量
// 3.var mName = _name
// 4.init { nameValue 打印 }
fun main() {
    // 调用次构造
    KtBase77("李元霸", '男', 88)  // 调用次构造
}