package com.derry.s5

// 四肢信息class，我就是为了方便toString打印
data class LimbsInfo(var info: String, var length: Int) {
    fun show() {
        println("${info}的长度是:$length")
    }
}

enum class Limbs(private val limbsInfo: LimbsInfo) {
    // kotlin的枚举类，也是个class，里面的枚举值相当于class的一个实例
    LEFT_HAND(LimbsInfo("左手", 88)), // 左手
    RIGHT_HAND(LimbsInfo("右手", 88)), // 右手

    LEFT_FOOT(LimbsInfo("左脚", 140)), // 左脚
    RIGHT_FOOT(LimbsInfo("右脚", 140)) // 右脚

    // 1. WEEK 这个时候 再定义单调的 枚举值，就报错了，必须所有枚举值，保持一致的效果
    // 2. 枚举值的声明(的参数) 必须和 主构造的参数 保持一致

    ; // 结束枚举值

    fun show() = "四肢是:${limbsInfo.info}的长度是:${limbsInfo.length}"

    fun updateData(limbsInfo: LimbsInfo) {
        println("更新前的数据是:${this.limbsInfo}")
        this.limbsInfo.info = limbsInfo.info
        this.limbsInfo.length = limbsInfo.length
        println("更新后的数据是:${this.limbsInfo}")
    }
}

// TODO 96-Kotlin语言的枚举类定义函数学习
fun main() {
    // 显示枚举值

    // 一般不会这样用，错误用法
    /*println(Limbs.show())
    println(Limbs().show())*/

    // 一般的用法如下：
    println(Limbs.LEFT_HAND.show())
    println(Limbs.RIGHT_HAND.show())
    println(Limbs.LEFT_FOOT.show())
    println(Limbs.RIGHT_FOOT.show())

    println()

    // 更新枚举值
    Limbs.RIGHT_HAND.updateData(LimbsInfo("左手2", 99))
    Limbs.LEFT_HAND.updateData(LimbsInfo("右手2", 99))
    Limbs.LEFT_FOOT.updateData(LimbsInfo("左脚2", 199))
    Limbs.RIGHT_FOOT.updateData(LimbsInfo("右脚2", 199))
}