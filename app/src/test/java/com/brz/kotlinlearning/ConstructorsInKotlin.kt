package com.brz.kotlinlearning

class Employee(
    val name: String,
    var position: String,
    var salary: Double
) {
    constructor(name: String, position: String) : this(name, position, 0.0) {
        println("Вызван вторичный конструктор №1 (без зарплаты)")
    }

    constructor(name: String) : this(name, "Не назначена") {
        println("Вызван вторичный конструктор №2 (только имя)")
    }

    fun printInfo() {
        println("Сотрудник: $name | Должность: $position | Оклад: $salary")
    }
}

fun main() {
    val dev = Employee("Алексей", "Разработчик", 150000.0)
    dev.printInfo()

    println("---")

    val designer = Employee("Мария", "Дизайнер")
    designer.printInfo()

    println("---")

    // Использование вторичного конструктора №2
    val intern = Employee("Иван")
    intern.printInfo()
}