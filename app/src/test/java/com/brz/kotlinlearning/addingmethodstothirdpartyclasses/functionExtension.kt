package com.brz.kotlinlearning.addingmethodstothirdpartyclasses

fun String.lastChar(): Char =
    this.get(this.length - 1)     // К методам объекта-получателя можно обращаться без "this"
// Тип-получатель       // Объект-получатель

fun main(args: Array<String>) {
    println("Kotlin".lastChar())
    // n
}

val c = "Kotlin".lastChar()
