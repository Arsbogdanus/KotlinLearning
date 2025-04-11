package com.brz.kotlinlearning.cycleswhileandfor

import java.util.TreeMap

class Cycles {
    val oneToTen = 1..10; // диапозон, интервал между двумя значениями, второе значение является частью диапозона

    fun fizzBuzz(i: Int) = when {
        i % 15 == 0 -> "FizzBuzz"
        i % 3 == 0 -> "Fizz"
        i % 5 == 0 -> "Buzz"
        else -> "$i "
    }

    fun main(args: Array<String>) {
        for (i in 1..100) { // Выволняется обход диапозона от 1 до 100
            print(fizzBuzz(i))
        }

        for (i in 100 downTo 1 step 2) { // Выволняется обход диапозона в обратном порядке с шагом 2
            print(fizzBuzz(i))
        }

        val binaryReps = TreeMap<Char, String>()
        for (c in 'A'..'F') {
            val binary = Integer.toBinaryString(c.toInt())
            binaryReps[c] = binary
        }

        for ((letter, binary) in binaryReps) {
            println("$letter = $binary")
        }

        val list = arrayListOf("10", "11", "1001")
        for ((index, element) in list.withIndex()) { // обход коллекции с сохранением индекса
        println("$index: $element")
        }
    }

}