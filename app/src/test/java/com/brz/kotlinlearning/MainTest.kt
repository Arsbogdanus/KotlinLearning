package com.brz.kotlinlearning

class MainTest {
    fun main(args: Array<String>) {
        fun eval(e: Expr): Int {
            if (e is Num){
                val n = e as Num       // Явное приведение к типу Num здесь излишне
            return n.value
            }
            if (e is Sum){
                return eval(e.right) + eval(e.left)     // Переменная e уже приведена к нужному типу!
            }
            throw IllegalArgumentException("Unknown expression")
        }
        println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
        // 7

        fun eval2(e: Expr): Int =
            if (e is Num){
                e.value
        } else if (e is Sum) {
                eval2(e.right) + eval2(e.left)
            } else {
            throw IllegalArgumentException("Unknown expression")
        }
        println(eval2(Sum(Num(1), Num(2))))
        // 3

        fun eval3(e: Expr): Int =
            when (e){
                is Num ->
                    e.value
                is Sum ->
                    eval3(e.right) + eval3(e.left) // <-- Используется автоматическое приведение типов
                else ->
                    throw IllegalArgumentException("Unknown expression")
            }

        fun evalWithLogging(e: Expr): Int =
            when (e){
                is Num -> {
                    println("num: ${e.value}")
                    e.value                             // Это последнее выражение в блоке,
                }                                       // функция вернет его значение, если e имеет тип Num
                is Sum -> {
                    val left =evalWithLogging(e.left)
                    val right =evalWithLogging(e.right)
                    println("sum: $left + $right")      // Функция вернет значение этого выражения,
                    left + right                        // если e имеет тип Sum
                }
                else -> throw IllegalArgumentException("Unknown expression")
            }
        println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
        // num: 1
        // num: 2
        // sum: 1 + 2
        // num: 4
        // sum: 3 + 4
        // 7
    }
}