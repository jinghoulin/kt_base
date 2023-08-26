package com.derry.s5

// 普通类
class ResponseResultBean1(var msg: String, var code: Int, var data: String) : Any()
// 会生成：set get 构造函数

// 数据类 -- 一般是用于 JavaBean的形式下，用数据类
data class ResponseResultBean2(var msg: String, var code: Int, var data: String) : Any()
// 会生成：set get 构造函数 解构操作 copy toString hashCode equals  。数据类 生成 更丰富

// TODO 91.Kotlin语言的数据类学习
// 1.普通类 与 数据类 的 toString 背后原理
// 2.前面学习过的 == 与 ===
// 3.普通类的 == 背后原理
// 4.数据类的 == 背后原理
fun main() {
    // val (v1, v2, v3) =list  这个是list集合之前的 解构操作

    println(ResponseResultBean1("loginSuccess", 200, "登录成功的数据..."))
    // 普通类：: 走的是Any()的toString 各平台实现toString打印了   com.derry.s5.ResponseResultBean1@266474c2

    println(ResponseResultBean2("loginSuccess", 200, "登录成功的数据..."))
    // 数据类：: 默认重写了 父类的 toString  打印子类的toString详情  ResponseResultBean2(msg=loginSuccess, code=200, data=登录成功的数据...)

    println()
    // =====================

    // 前面我们学习  == 值的比较 相当于java的equals      ===引用 对象 比较

    println( // 推理 两个 普通类 的值 是一样的，应该是true ，实际背后并不是这样的
        ResponseResultBean1("loginSuccess", 200, "登录成功的数据...") ==
                ResponseResultBean1("loginSuccess", 200, "登录成功的数据...")
    )
    // 会到Any的 equals 实现 （平台实现的依然是引用的比较）


    println(
        ResponseResultBean2("loginSuccess", 200, "登录成功的数据...") ==
                ResponseResultBean2("loginSuccess", 200, "登录成功的数据...")
    )
    // 数据类 重写了 equals 会调用 子类的 equals函数（对值的比较）
}