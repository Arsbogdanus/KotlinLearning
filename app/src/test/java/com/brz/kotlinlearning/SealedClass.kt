package com.brz.kotlinlearning

sealed class Expression {
    class Num(val value: Int) : Expression()
    class Sum(val left: Expression, val right: Expression) : Expression()
}

fun eval(e: Expression): Int =
    when (e) {
        is Expression.Num -> e.value
        is Expression.Sum -> eval(e.right) + eval(e.left)
    }