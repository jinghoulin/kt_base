package com.derry.s1

// TODO 18.Kotlin语言的具名函数参数
fun main() {
        // 具名函数参数 用法
    // 函数的参数顺序，是调用者 自定义 决定的
    loginAction(age = 99, userpwd = "123", usernam = "de", username = "Derry", phonenumber = "123456")
}

private fun loginAction(username: String, userpwd: String, phonenumber: String, age: Int, usernam: String) {
    println("username:$username, userpwd:$userpwd, phonenumber:$phonenumber, age:$age")
}