package com.brz.kotlinlearning

class KotlinBasics {
    fun main(args: Array<String>) {
        println("Hello, world!")

        println(max1(1, 2))

//         Объявление двух переменных
        val question =
            "The Ultimate Question of Life, the Universe, and Everything"
        val answer1 = 42

//         Объявление переменной с объявлением типа
        val answer2: Int = 42

//         Переменная типа Double
        val yearsToCompute = 7.5e6     // <----- 7.5 • 10^6 = 7500000.0

//         Объявление переменной, если в объявлении переменной отсутствует инициализирующее выражение,
//         её тип нужно указать явно:
        val answer3: Int
        answer3 = 42

//         val (от value) – неизменяемая ссылка.
//         var (от variable) - изменяемая ссылка.

//         Переменную val можно инициализировать разными значениями в зависимоси от некоторых условий,
//         если компилятор сможет гарантировать, что выполнится только из инициализирующих выражений:

        val message: String
        if (true or false) {
            message = "Success"
            // Выполнить операцию...
        } else {
            message = "Failed"
        }

        // Код является вполне допустимый:
        val languages = arrayListOf("Java")   //  <----  Объявление неизменяемой ссылки
        languages.add("Kotlin")               //  <---- Изменения объекта, на который она указывает

//         Ключевое слово var позволяет менять значение переменной, но её тип фиксирован.
//         Например, следующий код не скомпилируется:

        var noAnswer = 35
//        noAnswer = "noAnswer"    <---- Нужно преобразовать его вручную или привести к нужному типу
    }

//     fun – объвление функции max – имя функции ( Параметры ): тип возвращаемого значения
//     Тело-блок (block body)
    fun max1(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

//     fun – объвление функции max – имя функции ( Параметры ): тип возвращаемого значения = тело функции
//     Тело-выражение (expression body)
    fun max2(a: Int, b: Int): Int = if (a > b) a else b

//     Упростили, опустив тип возвращаемого значения (только с тело-выражение (expression body))
    fun max3(a: Int, b: Int) = if (a > b) a else b

}