package com.brz.kotlinlearning

interface Printer {
    fun printText(text: String)
}

class CanonPrinter : Printer {
    override fun printText(text: String) = println("Печать: $text")
}

class SmartPrinter(private val basePrinter: Printer) : Printer by basePrinter {
    private var pageCount = 0

    override fun printText(text: String) {
        pageCount++
        println("Лог: Печатаем страницу №$pageCount")

        basePrinter.printText(text)
    }
}

fun main() {
    val canon = CanonPrinter()
    val smartPrinter = SmartPrinter(canon)

    smartPrinter.printText("Привет, Kotlin!")
}
