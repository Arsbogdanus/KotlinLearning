package com.brz.kotlinlearning.exceptions

import java.io.BufferedReader

class ExceptionInKotlin {
    fun main(args: Array<String>) {
        val number: Int = 2;
        val percentage =
            if (number in 0..100)
                number
            else
                throw IllegalArgumentException(                 // throw – это выражение
                    "A percentage value must be between 0 and 100: $number"
                )
    }

    fun readNumber(reader: BufferedReader): Int? { // Не требуется явно указывать, какое исключение может возбудить функция
        try {
            val line = reader.readLine()
            return Integer.parseInt(line)
        } catch (e: NumberFormatException) {       // Тип исключения записывается справа
            return null
        } finally {                                // Блок finally действует так же, как в Java
            reader.close()
        }
    }

    fun readNumber2(reader: BufferedReader) {
        val number = try {
            Integer.parseInt(reader.readLine())     // Получит значение выражения try
        } catch (e: NumberFormatException) {
            return
        }
        println(number)
    }

    fun readNumber3(reader: BufferedReader) {
        val number = try {
            Integer.parseInt(reader.readLine())     // Получит значение выражения try
        } catch (e: NumberFormatException) {
            null
        }
        println(number)
    }
}