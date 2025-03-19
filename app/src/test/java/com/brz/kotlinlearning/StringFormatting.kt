package com.brz.kotlinlearning

class StringFormatting {
    //        Пример строковых шаблонов (string templates)
    fun main(args: Array<String>) {
        val name = if (args.size > 0) args[0] else "Kotlin"
//         Чтобы включить в строку символ "$", его нужно экранировать println("\$")
        println("Hello, $name!")
//         Синтаксис ${} используется для подстановки первого элемента массива args
        println("Hello, ${args[0]}!")
//         Можно помещать двойные кавычки внутрь других двойных кавычек, пока они входят в состав выражения:
        println("Hello, ${if (args.size > 0) args[0] else "someone"}!")
    }
}