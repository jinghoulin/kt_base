package com.derry.s5

object KtBase87 {
    /* object 对象类背后做了什么事情

        public static final KtBase87 INSTANCE;

        private KtBase87() {} // 主构造废除一样的效果

        public final void show() {
            String var1 = "我是show函数...";
            ...
            System.out.println(var1);
        }

        // 这个区域是 object 的特点，kt的init代码块不主构造函数中实现，而是在java的static代码块中实现：
        static {
            // 单例实例的创建
            KtBase87 var0 = new KtBase87();
            INSTANCE = var0;

            // init{}的实现
            String var1 = "KtBase91 init...";
            ...
            System.out.println(var0);
        }
        // 所以object的单例是饿汉式
     */

    init {
        println("KtBase91 init...")
    }

    fun show() = println("我是show函数...")
}

// TODO 87.Kotlin语言的对象声明学习
fun main() {
    // object KtBase87 既是单例的实例，也是类名
    // 小结：既然是 单例的实例，又是类名，只有一个创建，这就是典型的单例
    println(KtBase87) // 背后代码：println(KtBase87.INSTANCE)
    println(KtBase87) // 背后代码：println(KtBase87.INSTANCE)
    println(KtBase87)
    println(KtBase87)
    println(KtBase87)
    println(KtBase87)

    // 背后代码：KtBase87.INSTANCE.show();
    println(KtBase87.show())
}